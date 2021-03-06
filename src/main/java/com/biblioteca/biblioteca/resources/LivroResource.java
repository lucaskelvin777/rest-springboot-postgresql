package com.biblioteca.biblioteca.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.models.Livros;
import com.biblioteca.biblioteca.models.Messages;
import com.biblioteca.biblioteca.repository.LivroRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class LivroResource {

	private LivroRepository livroRepository;

	public LivroResource(LivroRepository rd) {
		this.livroRepository = rd;
	}

	@GetMapping("/livros")
	public List<Livros> listaLivros() {

		return this.livroRepository.findAll();

	}

	@GetMapping("/livros/{id}")
	public Livros listaLivrosById(@PathVariable(value = "id") long id) {
		return livroRepository.findById(id);
	}

	@PostMapping("/livros")
	public Livros salvaLivro(@RequestBody @Valid Livros livro) {
		return livroRepository.save(livro);
	}

	@DeleteMapping("/livros")
	public Messages deletaLivro(@RequestBody @Valid Livros livro) {
		livroRepository.delete(livro);
		Messages mg = new Messages("Deletado com sucesso!");
		mg.setStatus(true);
		return mg;
	}

	@PutMapping("/livros")
	public Livros atualizaLivro(@RequestBody @Valid Livros livro) {
		return livroRepository.save(livro);
	}
}
