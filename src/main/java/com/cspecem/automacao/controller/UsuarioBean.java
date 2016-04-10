package com.cspecem.automacao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cspecem.automacao.model.Grupo;
import com.cspecem.automacao.model.Usuario;
import com.cspecem.automacao.repository.Usuarios;
import com.cspecem.automacao.util.jsf.FacesUtil;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Produces
	private Usuario usuario;
	
	@Inject
	private Usuarios usuarios;
	
	public UsuarioBean() {
		this.usuario = new Usuario();
	}
	
	private String confirmarSenha;
	
	private List<Usuario> lista;
	private List<Grupo> listaPerfil;
	private List<SelectItem> perfil;
	
	@PostConstruct
	public void inicializar() {
		lista = new ArrayList<Usuario>();
		listaPerfil = new ArrayList<Grupo>();
	}
	
	public List<SelectItem> getPerfil() {
		if (this.perfil == null) {
			this.perfil = new ArrayList<SelectItem>();
			this.perfil.add(new SelectItem("ADMINISTRADORES", "Administrador"));
			this.perfil.add(new SelectItem("VENDEDORES", "Vendedor"));
			this.perfil.add(new SelectItem("AUXILIARES", "Auxiliar"));
		}
		return perfil;
	}
	
	public String salvar() {
		try {
			String senha = this.usuario.getSenha();
			if (!senha.equals(this.confirmarSenha)) {
				FacesUtil.addErrorMessage("A senha não foi confirmada corretamente.");
				return null;
			}
			this.usuario.setAtivo(true);
			
			// setando data atual cadastro
			Date dataAtual = new Date(System.currentTimeMillis());
			this.usuario.setCadastro(dataAtual);
			
			this.usuario.setGrupos(listaPerfil);
			
			this.usuarios.salvar(usuario);
			FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
			
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Ocorreu um erro ao salvar usuário. " + e.getMessage());
		}
		return "UsuarioSucesso";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getLista() {
		// implementar
		return null;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}


}
