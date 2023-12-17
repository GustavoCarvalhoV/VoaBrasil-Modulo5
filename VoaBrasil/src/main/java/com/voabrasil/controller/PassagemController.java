package com.voabrasil.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.voabrasil.model.Destino;
import com.voabrasil.model.Passagem;
import com.voabrasil.model.Usuario;
import com.voabrasil.repository.DestinoRepository;
import com.voabrasil.repository.PassagemRepository;
import com.voabrasil.repository.UsuarioRepository;

@Controller
@RequestMapping("/passagem")
public class PassagemController {
	
	@Autowired
	private PassagemRepository passagemRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("passagem/listar.html");
 
		List<Passagem> passagens = passagemRepository.findAll();
//		List<Usuario> usuarios = usuarioRepository.findAll();
//		List<Destino> destinos = destinoRepository.findAll();
		modelAndView.addObject("passagens", passagens);
 
		return modelAndView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("passagem/cadastro");
 
//		List<Usuario> usuarios = usuarioRepository.findAll();
//		List<Destino> destinos = destinoRepository.findAll();
		
		modelAndView.addObject("passagem", new Passagem());
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		modelAndView.addObject("destinos", destinoRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
    public ModelAndView cadastrar(Passagem passagem, @RequestParam("usuario") Long  usuario, @RequestParam("destino") Long  destino) throws IOException {


        Usuario usuario1 = new Usuario();
        usuario1 = usuarioRepository.findById(usuario).orElse(null);
        passagem.setUsuario(usuario1);

        ModelAndView modelAndView = new ModelAndView("redirect:/passagem");
 
        passagemRepository.save(passagem);
 
        return modelAndView;
    }
	
	@GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("passagem/edit");

        List<Usuario> usuarios = usuarioRepository.findAll();
        modelAndView.addObject("usuarios", usuarios);

        List<Destino> destinos = destinoRepository.findAll();
        modelAndView.addObject("destinos", destinos);
        
        Passagem passagem = passagemRepository.getReferenceById(id);
        modelAndView.addObject("passagem", passagem);

        Usuario us = passagem.getUsuario();
        modelAndView.addObject("usuario", us);
        
        Destino des = passagem.getDestino();
        modelAndView.addObject("destino", des);
 
        return modelAndView;
    }
	
	@PostMapping("/{id}/editar")
    public ModelAndView editar(Passagem passagem, @RequestParam("usuario") Long id, @RequestParam("destino") Long idDes) {
        Usuario us = usuarioRepository.findById(id).orElse(null);
        Destino des = destinoRepository.findById(idDes).orElse(null);
        passagem.setUsuario(us);
        passagem.setDestino(des);
     
        passagemRepository.save(passagem);
        ModelAndView modelAndView = new ModelAndView("redirect:/passagem");
 
        return modelAndView;
    }
	
	@GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/passagem");

        Passagem passagem = passagemRepository.findById(id).orElse(null);

        passagemRepository.deleteById(passagem.getId());
 
        return modelAndView;
    }
}
