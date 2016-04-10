package com.cspecem.automacao.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class DaoGenerico<T, ID extends Serializable> {

	@Inject
	protected EntityManager entityManager;
	
	private final Class<T> classePersistence;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public DaoGenerico() {
		this.classePersistence = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T salvar(T object) {
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		entityManager.persist(object);
		transacao.commit();
		entityManager.close();
		return null;
	}

	public T atualizar(T object) {
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		entityManager.merge(object);
		transacao.commit();
		entityManager.close();
		return null;
	}

	public void excluir(ID id) {
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		T object = entityManager.find(getClassePersistence(), id);
		entityManager.remove(object);
		transacao.commit();
		entityManager.close();
	}

	public T buscaPorId(ID id) {
		return entityManager.find(getClassePersistence(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> todos() {
		return this.getEntityManager().createQuery(
		        String.format("from %s", this.classePersistence.getName()))
		        .getResultList();
	}
	
	// Consulta com Criteria

	protected final Criteria criaCriteria() {
		Session session = (Session) entityManager.getDelegate();
		return session.createCriteria(getClassePersistence());
	}

	public Class<T> getClassePersistence() {
		return classePersistence;
	}


}
