package com.projeto.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.music.model.Usuario;
import com.projeto.music.service.UsuarioService;

@RestController
@CrossOrigin("${origem-permitida}")
public class UsuarioController {
	
	UsuarioService usuarioService = new UsuarioService();
	
	@GetMapping("/usuarios")
	public List<Usuario> list() {
		return usuarioService.getUsuarios();
	}
	
	@PostMapping("/usuarios")
	public void create(@RequestBody Usuario usuario) {
		usuarioService.createUsuario(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public void update(@PathVariable String id, @RequestBody Usuario usuario) {
		usuarioService.updateUsuario(usuario, Integer.parseInt(id));
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void delete(@PathVariable String id) {
		usuarioService.deleteUsuario(Integer.parseInt(id));
	}

}
