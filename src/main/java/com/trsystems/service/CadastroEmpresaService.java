package com.trsystems.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.trsystems.model.Empresa;
import com.trsystems.repository.Empresas;
import com.trsystems.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	@Transacional
	public void salvar(Empresa empresa) {
		empresas.salvar(empresa);
	}

	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}