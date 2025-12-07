package com.trsystems.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// @ApplicationScoped INFORMAR PARA O CDI QUE A INSTÂNCIA DESSA CLASSE, DEVE SOBREVIVER DURANTE TODO O CICLO DE VIDA DA APLICAÇÃO
@ApplicationScoped 
public class EntityManagerProducer {
	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
	}

	// INVOCAR E CRIAR NOVA INSTÂNCIA
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}

	// CDI FAZ A CHAMADA, PARA SE ENCERRAR O EntityManager
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
