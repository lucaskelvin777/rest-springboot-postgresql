package com.biblioteca.biblioteca.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.biblioteca.models.Livros;


public interface LivroRepository extends JpaRepository<Livros, Long>{
	public Livros findById(long id);

}

