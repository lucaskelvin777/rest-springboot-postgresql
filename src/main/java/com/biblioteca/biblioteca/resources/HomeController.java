package com.biblioteca.biblioteca.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.models.Messages;

@RestController
public class HomeController {

	@GetMapping("/")
    public Messages home(){
		Messages mg = new Messages("Servidor ok!");
		mg.setStatus(true);
        return mg;
    }
}