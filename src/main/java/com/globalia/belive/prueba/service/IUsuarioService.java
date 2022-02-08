package com.globalia.belive.prueba.service;

import java.util.List;

import com.globalia.belive.prueba.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarTodos();

	public void guardar(Usuario usuario);

	public Usuario buscarPorId(Long id);

	public void eliminar(Long id);

}
