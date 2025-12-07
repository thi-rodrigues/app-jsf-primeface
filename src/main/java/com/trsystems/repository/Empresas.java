package com.trsystems.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.trsystems.model.Empresa;

public class Empresas implements Serializable {
	private static final long serialVersionUID = 8878011262914507122L;

	@Inject
	private EntityManager manager;

	public Empresas() {
	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa buscarPorId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String valor) {
		String jpql = "FROM Empresa WHERE nomeFantasia like :nomeFantasia";
		TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
		query.setParameter("nomeFantasia", "%" + valor + "%");
		return query.getResultList();
	}

	public Empresa salvar(Empresa empresa) {
		return manager.merge(empresa); // ATUALIZAR ou CRIAR
	}

	public void remover(Empresa empresa) {
		empresa = buscarPorId(empresa.getId());
		manager.remove(empresa);
	}
}
