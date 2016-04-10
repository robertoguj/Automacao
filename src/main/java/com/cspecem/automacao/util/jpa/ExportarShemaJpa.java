package com.cspecem.automacao.util.jpa;

import javax.persistence.Persistence;

public class ExportarShemaJpa {

	public static void main(String[] args) {
		try {
			Persistence.createEntityManagerFactory("PedidoPU");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
