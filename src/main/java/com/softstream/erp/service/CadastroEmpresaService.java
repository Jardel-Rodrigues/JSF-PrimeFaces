package com.softstream.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.softstream.erp.model.Empresa;
import com.softstream.erp.repository.EmpresaRepository;
import com.softstream.erp.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresaRepository.salvar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresaRepository.remover(empresa);
	}

}
