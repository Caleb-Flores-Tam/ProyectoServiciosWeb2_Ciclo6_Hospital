package com.medica.service.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.medica.ConnectionSql.ConectarBD;
import com.medica.model.Tbl_Cita;
import com.medica.model.Tbl_Medico;
import com.medica.model.Tbl_Paciente;
import com.medica.model.Tbl_Usuario;
import com.medica.service.ICitas;
import org.springframework.stereotype.Service;

@Service
public class ClassCitaImp implements ICitas{

	@Override
	public List<Tbl_Cita> ListaCitas() {
		List<Tbl_Cita> lista = new ArrayList<>();

        String sqlListado = "SELECT c.idCitas, "
                + "m.nomDoctor AS NombreMedico, "
                + "e.nomEspecialidad AS Especialidad, "
                + "m.correo AS CorreoMedico, "
                + "p.dni AS DniPaciente, "
                + "p.nombre_pac AS NombrePaciente, "
                + "p.seguro AS Seguro, "
                + "p.telefono_pac AS TelefonoPaciente, "
                + "u.cargo AS CargoUsuario, "
                + "u.departamento AS DepartamentoUsuario, "
                + "u.nombre AS NombreUsuario, "
                + "u.apellido AS ApellidoUsuario, "
                + "c.FechaCreacion, "
                + "c.FechaAtencion, "
                + "c.Motivo "
                + "FROM Tbl_Citas c "
                + "INNER JOIN Tbl_Medico m ON c.IdMedico = m.cod_coc "
                + "INNER JOIN Tbl_Especialidad e ON m.especialidad = e.idEspecialidad "
                + "INNER JOIN Tbl_Paciente p ON c.IdPaciente = p.cod_pac "
                + "INNER JOIN Tbl_Usuario u ON c.IdUsuario = u.id_usuario "
                + "ORDER BY c.FechaCreacion DESC";

        try (Connection cn = ConectarBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sqlListado);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // ---- MÉDICO ----
                Tbl_Medico medico = new Tbl_Medico();
                medico.setNomDoctor(rs.getString("NombreMedico"));
                medico.setCorreo(rs.getString("CorreoMedico"));
                medico.setEspecialidadNombre(rs.getString("Especialidad"));

                // ---- PACIENTE ----
                Tbl_Paciente paciente = new Tbl_Paciente();
                paciente.setDni(rs.getString("DniPaciente"));
                paciente.setNombre_pac(rs.getString("NombrePaciente"));
                paciente.setSeguro(rs.getString("Seguro"));
                paciente.setTelefono_pac(rs.getString("TelefonoPaciente"));

                // ---- USUARIO ----
                Tbl_Usuario usuario = new Tbl_Usuario();
                usuario.setCargo(rs.getString("CargoUsuario"));
                usuario.setDepartamento(rs.getString("DepartamentoUsuario"));
                usuario.setNombre(rs.getString("NombreUsuario"));
                usuario.setApellido(rs.getString("ApellidoUsuario"));

                // ---- CITA ----
                Tbl_Cita cita = new Tbl_Cita();
                cita.setIdCitas(rs.getInt("idCitas"));
                cita.setIdMedico(medico);
                cita.setIdPaciente(paciente);
                cita.setIdUsuario(usuario);

                // FechaCreacion (LocalDateTime)
                if (rs.getTimestamp("FechaCreacion") != null) {
                    cita.setFechaCreacion(rs.getTimestamp("FechaCreacion").toLocalDateTime());
                } else {
                    cita.setFechaCreacion(LocalDateTime.now());
                }

                cita.setFechaAtencion(rs.getString("FechaAtencion"));
                cita.setMotivo(rs.getString("Motivo"));

                lista.add(cita);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
	    }


	@Override
	public void RegistrarCita(Tbl_Cita cita) {
		 String sqlInsert = "INSERT INTO Tbl_Citas (IdMedico, IdPaciente, IdUsuario, FechaCreacion, FechaAtencion, Motivo) "
                 + "VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection cn = ConectarBD.getConexion();
		     PreparedStatement ps = cn.prepareStatement(sqlInsert)) {
		
		    // Parámetros
		    ps.setInt(1, cita.getIdMedico().getCod_doc());
		    ps.setInt(2, cita.getIdPaciente().getCod_pac());
		    ps.setInt(3, cita.getIdUsuario().getId());
		
		    // Fecha de creación (usa la actual si es null)
		    LocalDateTime fechaCreacion = cita.getFechaCreacion() != null 
		            ? cita.getFechaCreacion() 
		            : LocalDateTime.now();
		    ps.setTimestamp(4, Timestamp.valueOf(fechaCreacion));
		
		    // Fecha de atención (puede venir como string tipo "2025-10-28")
		    ps.setString(5, cita.getFechaAtencion());
		
		    // Motivo de la cita
		    ps.setString(6, cita.getMotivo());
		
		    ps.executeUpdate();
		
		    System.out.println("Cita registrada correctamente.");
		
		} catch (SQLException e) {
		    System.err.println("Error al registrar la cita: " + e.getMessage());
		    e.printStackTrace();
		}
		
	}

	@Override
	public void ActualizarCita(Tbl_Cita cita) {
	    String sql = "UPDATE Tbl_Citas SET IdMedico = ?, IdPaciente = ?, IdUsuario = ?, "
	               + "FechaAtencion = ?, Motivo = ? WHERE idCitas = ?";
	    
	    try (Connection con = ConectarBD.getConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, cita.getIdMedico().getCod_doc());
	        ps.setInt(2, cita.getIdPaciente().getCod_pac());
	        ps.setInt(3, cita.getIdUsuario().getId());
	        ps.setString(4, cita.getFechaAtencion());
	        ps.setString(5, cita.getMotivo());
	        ps.setInt(6, cita.getIdCitas());
	        
	        ps.executeUpdate();
	        System.out.println("Cita actualizada correctamente.");

	    } catch (SQLException e) {
	        System.out.println("Error al actualizar la cita: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public void EliminarCita(Tbl_Cita cita) {
	    String sql = "DELETE FROM Tbl_Citas WHERE idCitas = ?";
	    
	    try (Connection con = ConectarBD.getConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, cita.getIdCitas());
	        ps.executeUpdate();
	        System.out.println("Cita eliminada correctamente.");

	    } catch (SQLException e) {
	        System.out.println("Error al eliminar la cita: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public Tbl_Cita buscarCitaId(Tbl_Cita cita) {
	    Tbl_Cita resultado = null;
	    String sql = "SELECT * FROM Tbl_Citas WHERE idCitas = ?";
	    
	    try (Connection con = ConectarBD.getConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, cita.getIdCitas());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            resultado = new Tbl_Cita();
	            resultado.setIdCitas(rs.getInt("idCitas"));

	            // Relacionar los objetos si tienes sus modelos
	            Tbl_Medico medico = new Tbl_Medico();
	            medico.setCod_doc(rs.getInt("IdMedico"));
	            resultado.setIdMedico(medico);

	            Tbl_Paciente paciente = new Tbl_Paciente();
	            paciente.setCod_pac(rs.getInt("IdPaciente"));
	            resultado.setIdPaciente(paciente);

	            Tbl_Usuario usuario = new Tbl_Usuario();
	            usuario.setId(rs.getInt("IdUsuario"));
	            resultado.setIdUsuario(usuario);

	            resultado.setFechaCreacion(rs.getTimestamp("FechaCreacion").toLocalDateTime());
	            resultado.setFechaAtencion(rs.getString("FechaAtencion"));
	            resultado.setMotivo(rs.getString("Motivo"));
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al buscar la cita: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return resultado;
	}

}
