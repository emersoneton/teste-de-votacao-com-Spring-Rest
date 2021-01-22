package com.emersonluis.testedevotacao.resourse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssociadosResource {

	@JsonProperty("nome_Associado")
	private String nome;
	
	@JsonProperty("id_Associado")
	private String idAssociado;
	
	
	public AssociadosResource(String nome, String idAssociado) {
		this.nome = nome;
		this.idAssociado = idAssociado;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIdAssociado() {
		return idAssociado;
	}


	public void setIdAssociado(String idAssociado) {
		this.idAssociado = idAssociado;
	}
	
	
	
	
}
