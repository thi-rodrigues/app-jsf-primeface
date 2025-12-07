package com.trsystems.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.trsystems.model.Empresa;
import com.trsystems.model.RamoAtividade;

public class RamoAtividades implements Serializable {
	private static final long serialVersionUID = 5043691905128770183L;

	private EntityManager manager;

	public RamoAtividades() {
	}

	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa buscarPorId(Long id) {
		return manager.find(Empresa.class, id);
	}

	public List<RamoAtividade> pesquisar(String descricao) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
		
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), "%" + descricao + "%"));

		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}

}
