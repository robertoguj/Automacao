package com.cspecem.automacao.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import com.cspecem.automacao.model.Usuario;

public class Usuarios extends DaoGenerico<Usuario, Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Usuario> vendedores() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.entityManager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}

	public Usuario porEmail(String email) {
		Usuario usuario = null;
		
		try {
			usuario = this.entityManager.createQuery("from Usuario where lower(email) = :email", Usuario.class)
				.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o e-mail informado
		}
		
		return usuario;
	}
	
}