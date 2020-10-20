package com.mballem.curso.security.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mballem.curso.security.datatables.Datatables;
import com.mballem.curso.security.datatables.DatatablesColunas;
import com.mballem.curso.security.domain.Especialidade;
import com.mballem.curso.security.domain.Prontuario;
import com.mballem.curso.security.repository.ProntuarioMedicoRepository;

@Service
public class ProntuarioMedicoService {
	
	@Autowired
	private ProntuarioMedicoRepository prontuarioMedicoRepository;
	
	@Autowired Datatables dataTables;
	public Object buscarEspecialidade;
	
	@Transactional
	public Map<String, Object> buscarProntuarios(HttpServletRequest request) {
		dataTables.setRequest(request);
		dataTables.setColunas(DatatablesColunas.PRONTUARIOS);
		Page<?> page = dataTables.getSearch().isEmpty()
				? prontuarioMedicoRepository.findAll(dataTables.getPageable())
						: prontuarioMedicoRepository.findAllByTitulo(dataTables.getSearch(), dataTables.getPageable());
				
		return dataTables.getResponse(page);
	}
	
	@Transactional
	public void salvar(Prontuario prontuario) {
		prontuarioMedicoRepository.save(prontuario);
	}

	
	@Transactional
	public Prontuario buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return prontuarioMedicoRepository.findById(id).get();
	}
	
	@Transactional
	public void remover(Long id) {
		prontuarioMedicoRepository.deleteById(id);
		
	}
	
	@Transactional
	public List<String> buscarEspecialidadeByTermo(String termo) {
		// TODO Auto-generated method stub
		return  prontuarioMedicoRepository.findEspecialidadesByTermo(termo);
	}
	
	@Transactional
	public Set<Prontuario> buscarPorTitulos(String[] titulos) {
		// TODO Auto-generated method stub
		return prontuarioMedicoRepository.findByTitulos(titulos);
	}
	
}
