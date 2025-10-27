package com.medica.service;

import java.util.List;
import java.util.stream.Collectors;

import com.medica.dto.UsuarioDTO;
import com.medica.model.Tbl_Usuario;
import com.medica.service.imp.ClassUsuarioImpl;
import com.medico.mapper.UsuarioMapper;

public class UsuarioService {
	private final IUsuario dao = new ClassUsuarioImpl();

    public void registrar(Tbl_Usuario usuario) {
        dao.registrarUsuario(usuario);
    }
    public void actualizar(Tbl_Usuario usuario) {
        dao.actualizarUsuario(usuario);
    }

    public void eliminar(int id) {
        dao.eliminarUsuario(id);
    }

    public Tbl_Usuario buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    public List<UsuarioDTO> listar() {
        return dao.listarUsuarios().stream()
                  .map(UsuarioMapper::toDTO)
                  .collect(Collectors.toList());
    }

    public boolean login(String username, String password) {
        return dao.validarLogin(username, password);
    }
}