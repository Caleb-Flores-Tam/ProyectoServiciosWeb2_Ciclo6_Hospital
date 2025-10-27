package com.medico.mapper;


import com.medica.dto.UsuarioDTO;
import com.medica.model.Tbl_Usuario;

public class UsuarioMapper {
	public static UsuarioDTO toDTO(Tbl_Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEmail(entity.getEmail());
        dto.setTelefono(entity.getTelefono());
        dto.setCargo(entity.getCargo());
        dto.setActivo(entity.isActivo());
        dto.setFechaIngreso(entity.getFechaIngreso());
        dto.setUltimoAcceso(entity.getUltimoAcceso());
        return dto;
    }

    public static Tbl_Usuario toEntity(UsuarioDTO dto) {
        Tbl_Usuario entity = new Tbl_Usuario();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        entity.setCargo(dto.getCargo());
        entity.setActivo(dto.isActivo());
        entity.setFechaIngreso(dto.getFechaIngreso());
        entity.setUltimoAcceso(dto.getUltimoAcceso());
        return entity;
    }

}
