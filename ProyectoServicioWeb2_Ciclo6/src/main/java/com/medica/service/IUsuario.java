package com.medica.service;

import java.util.List;
import com.medica.model.Tbl_Usuario;

public interface IUsuario {
	void registrarUsuario(Tbl_Usuario usuario);
    void actualizarUsuario(Tbl_Usuario usuario);
    void eliminarUsuario(int idUsuario);
    Tbl_Usuario buscarPorId(int id);
    Tbl_Usuario buscarPorUsername(String username);
    List<Tbl_Usuario> listarUsuarios();
    boolean validarLogin(String username, String password);
}
