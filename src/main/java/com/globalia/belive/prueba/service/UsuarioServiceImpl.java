package com.globalia.belive.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalia.belive.prueba.entity.Usuario;
import com.globalia.belive.prueba.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarTodos() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);

	}

}
