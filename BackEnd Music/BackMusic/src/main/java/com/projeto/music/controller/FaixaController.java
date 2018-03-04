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

import com.projeto.music.model.Faixa;
import com.projeto.music.service.FaixaService;

@RestController
@CrossOrigin("${origem-permitida}")
public class FaixaController {
	
	FaixaService faixaService = new FaixaService();
	
	@GetMapping("/faixas")
	public List<Faixa> list() {
		return faixaService.getFaixas();
	}
	
	@PostMapping("/faixas")
	public void create(@RequestBody Faixa faixa) {
		faixaService.createFaixa(faixa);
	}
	
	@PutMapping("faixas/{id}")
	public void update(@PathVariable String id, @RequestBody Faixa faixa) {
		faixaService.updateFaixa(faixa, Integer.parseInt(id));
	}
	
	@DeleteMapping("/faixas/{id}")
	public void delete(@PathVariable String id) {
		faixaService.deleteFaixa(Integer.parseInt(id));
	}

}
