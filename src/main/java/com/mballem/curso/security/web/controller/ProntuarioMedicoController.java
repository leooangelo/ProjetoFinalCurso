package com.mballem.curso.security.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.security.domain.Prontuario;
import com.mballem.curso.security.service.ProntuarioMedicoService;

@Controller
@RequestMapping("prontuarios")
public class ProntuarioMedicoController {
	
	@Autowired
	private ProntuarioMedicoService prontuarioMedicoService;
		
	@GetMapping({"", "/"})
	public String abrir(Prontuario prontuario) {
		return "prontuario/prontuario";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(Prontuario prontuario, RedirectAttributes redirect) {
		prontuarioMedicoService.salvar(prontuario);
		redirect.addFlashAttribute("sucesso", "Operação realizado com sucesso !");
		return "redirect:/prontuarios";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getEspecialidades(HttpServletRequest request){
		return ResponseEntity.ok(prontuarioMedicoService.buscarProntuarios(request));
	}
		
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("prontuario", prontuarioMedicoService.buscarPorId(id));
		return "prontuario/prontuario";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes redirect) {
		prontuarioMedicoService.remover(id);
		redirect.addFlashAttribute("sucesso", "Operação realizada com sucesso");
		return "redirect:/prontuarios";
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<?> getEspecialidadesPorTermo(@RequestParam("termo") String termo){
		List<String> prontuarios = prontuarioMedicoService.buscarEspecialidadeByTermo(termo);
		return ResponseEntity.ok(prontuarios);
	}
	
	
}
