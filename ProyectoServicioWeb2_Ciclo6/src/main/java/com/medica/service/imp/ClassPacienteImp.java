package com.medica.service.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.medica.ConnectionSql.ConectarBD;
import com.medica.model.Tbl_Paciente;
import com.medica.service.IPacienteService;

@Service
public class ClassPacienteImp implements IPacienteService{
	
	@Override
	public void registrarPaciente(Tbl_Paciente paciente) {
		String sql = "INSERT INTO tbl_paciente VALUES(NULL, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = ConectarBD.getConexion().prepareStatement(sql);
            ps.setString(1, paciente.getDni());
            ps.setString(2, paciente.getNombre_pac());
            ps.setString(3, paciente.getSeguro());
            ps.setString(4, paciente.getTelefono_pac());
            ps.setString(5, paciente.getEstado());

            int z = ps.executeUpdate();
            if (z > 0) {
                System.out.println("Paciente registrado correctamente!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void actualizarPaciente(Tbl_Paciente paciente) {
		 String sql = "UPDATE tbl_paciente SET dni=?, nombre_pac=?, seguro=?, telefono_pac=?, estado=? WHERE cod_pac=?";
	        try {
	            PreparedStatement ps = ConectarBD.getConexion().prepareStatement(sql);
	            ps.setString(1, paciente.getDni());
	            ps.setString(2, paciente.getNombre_pac());
	            ps.setString(3, paciente.getSeguro());
	            ps.setString(4, paciente.getTelefono_pac());
	            ps.setString(5, paciente.getEstado());
	            ps.setInt(6, paciente.getCod_pac());
	            int z = ps.executeUpdate();
	            if (z > 0) {
	                System.out.println("Paciente actualizado correctamente!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
	@Override
	public void eliminarPaciente(Tbl_Paciente paciente) {
		 String sql = "DELETE FROM tbl_paciente WHERE cod_pac=?";
	        try {
	            PreparedStatement ps = ConectarBD.getConexion().prepareStatement(sql);
	            ps.setInt(1, paciente.getCod_pac());
	            int z = ps.executeUpdate();
	            if (z > 0) {
	                System.out.println("Paciente eliminado correctamente!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
	@Override
	public List<Tbl_Paciente> listadoPacientes() {
		List<Tbl_Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbl_paciente";
        try {
            PreparedStatement ps = ConectarBD.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tbl_Paciente p = new Tbl_Paciente();
                p.setCod_pac(rs.getInt(1));
                p.setDni(rs.getString(2));
                p.setNombre_pac(rs.getString(3));
                p.setSeguro(rs.getString(4));
                p.setTelefono_pac(rs.getString(5));
                p.setEstado(rs.getString(6));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
	}
	
	@Override
	public Tbl_Paciente buscarPaciente(Tbl_Paciente paciente) {
		 Tbl_Paciente encontrado = new Tbl_Paciente();
	        String sql = "SELECT * FROM tbl_paciente WHERE cod_pac=?";
	        try {
	            PreparedStatement ps = ConectarBD.getConexion().prepareStatement(sql);
	            ps.setInt(1, paciente.getCod_pac());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                encontrado.setCod_pac(rs.getInt(1));
	                encontrado.setDni(rs.getString(2));
	                encontrado.setNombre_pac(rs.getString(3));
	                encontrado.setSeguro(rs.getString(4));
	                encontrado.setTelefono_pac(rs.getString(5));
	                encontrado.setEstado(rs.getString(6));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return encontrado;
	    }
}
