package com.voabrasil.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.voabrasil.model.Destino;
import com.voabrasil.repository.DestinoRepository;

@Controller
@RequestMapping("/destinos")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	
	// lista todos os dados do banco destino
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("destino/listar.html");

		List<Destino> destinos = destinoRepository.findAll();
		modelAndView.addObject("destinos", destinos);

		return modelAndView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("destino/cadastro");

		modelAndView.addObject("destino", new Destino());

		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
    public ModelAndView cadastrar(Destino destino)  throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/destinos");

        destinoRepository.save(destino);

        return modelAndView;
    }
	
	@GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("destino/edit");

        Destino destino = destinoRepository.getReferenceById(id);
        modelAndView.addObject("destino", destino);

        return modelAndView;
    }
	
	@PostMapping("/{id}/editar")
    public ModelAndView editar(Destino destino) {
    
        destinoRepository.save(destino);
        ModelAndView modelAndView = new ModelAndView("redirect:/destinos");

        return modelAndView;
    }
	
	@GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/destinos");

        destinoRepository.deleteById(id);

        return modelAndView;
    }
}
