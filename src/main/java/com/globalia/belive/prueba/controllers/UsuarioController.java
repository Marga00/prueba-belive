package com.globalia.belive.prueba.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.globalia.belive.prueba.entity.Usuario;
import com.globalia.belive.prueba.service.IUsuarioService;

@Controller
@RequestMapping("/views/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/")
	public String listarUsuarios(Model model) {
		List<Usuario> listadoUsuarios = usuarioService.listarTodos();

		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("usuarios", listadoUsuarios);
		return "/views/usuarios/lista";

	}

	@GetMapping("/create")
	public String crear(Model model) {

		Usuario usuario = new Usuario();

		model.addAttribute("titulo", "Formulario: Nuevo Usuario");
		model.addAttribute("usuario", usuario);
		return "/views/usuarios/frmCrear";

	}

	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Usuario usuario, BindingResult result,
			Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {

			model.addAttribute("titulo", "Formulario: Nuevo Usuario");
			model.addAttribute("usuario", usuario);
			System.out.println("Existieron errores en el formulario");
			return "/views/usuarios/frmCrear";
		}

		usuarioService.guardar(usuario);
		attribute.addFlashAttribute("success","Usuario guardado con éxito");
		return "redirect:/views/usuarios/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idUsuario, Model model, RedirectAttributes attribute) {

		Usuario usuario = null;

		if (idUsuario > 0) {
			usuario = usuarioService.buscarPorId(idUsuario);
			if (usuario == null) {
				attribute.addFlashAttribute("error", "Error: El ID del usuario no existe");
				return "redirect:/views/usuarios/";
			}

		} else {
			attribute.addFlashAttribute("error", "Error: Error con el ID del usuario");
			return "redirect:/views/usuarios/";
		}

		model.addAttribute("titulo", "Formulario: Editar Usuario");
		model.addAttribute("usuario", usuario);
		return "/views/usuarios/frmCrear";

	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idUsuario, RedirectAttributes attribute) {
		Usuario usuario = null;

		if (idUsuario > 0) {
			usuario = usuarioService.buscarPorId(idUsuario);
			if (usuario == null) {
				attribute.addFlashAttribute("error", "Error: El ID de usuario no existe");
				return "redirect:/views/usuarios/";
			}

		} else {
			attribute.addFlashAttribute("error", "Error: El ID de usuario no existe");
			return "redirect:/views/usuarios/";
		}

		usuarioService.eliminar(idUsuario);
		attribute.addFlashAttribute("warning", "Registro eliminado");

		return "redirect:/views/usuarios/";

	}
}
