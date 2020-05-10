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

	private LivroRepository produtoRepository;

	public ProdutoResource(LivroRepository rd) {
		this.produtoRepository = rd;
	}

	@GetMapping("/livros")
	public List<Livros> listaProdutos() {

		return this.produtoRepository.findAll();

	}

	@GetMapping("/livros/{id}")
	public Livros listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/livros")
	public Livros salvaProduto(@RequestBody @Valid Livros produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/livros")
	public Messages deletaProduto(@RequestBody @Valid Livros produto) {
		produtoRepository.delete(produto);
		Messages mg = new Messages("Deletado com sucesso!");
		mg.setStatus(true);
		return mg;
	}

	@PutMapping("/livros")
	public Livros atualizaProduto(@RequestBody @Valid Livros produto) {
		return produtoRepository.save(produto);
	}
}
