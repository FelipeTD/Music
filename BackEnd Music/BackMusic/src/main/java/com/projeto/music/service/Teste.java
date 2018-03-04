package com.projeto.music.service;

import java.time.LocalDate;

import com.projeto.music.model.Album;
import com.projeto.music.model.Faixa;
import com.projeto.music.model.Usuario;

public class Teste {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Fernando");
		LocalDate date = LocalDate.parse("1992-08-14");
		usuario.setDataNascimento(date);
		usuario.setSexo("M");
		usuario.setUsuario("fernando@gmail.com");
		usuario.setSenha("654321");

		UsuarioService userService = new UsuarioService();
		System.out.println(userService.getUsuarios());
		// userService.createUsuario(usuario);
		// userService.deleteUsuario(1);
		// userService.updateUsuario(usuario);

		Album album = new Album();
		album.setId(1);
		album.setNome("Skank - Multishow Ao Vivo");
		album.setAnoLancamento(2000);
		album.setArtista("Skank");

		AlbumService albumService = new AlbumService();
		System.out.println(albumService.getAlbuns());
		// albumService.createAlbum(album);
		// albumService.updateAlbum(album);
		// albumService.deleteAlbum(2);
		
		Faixa faixa = new Faixa();
		faixa.setId(2);
		faixa.setNome("Dois Rios");
		faixa.setDuracao(300);
		faixa.setCodigoAlbum(1);
		faixa.setOrdem(2);

		FaixaService faixaService = new FaixaService();
		System.out.println(faixaService.getFaixas());
		//faixaService.createFaixa(faixa);
		//faixaService.updateFaixa(faixa);
		faixaService.deleteFaixa(2);

	}

}
