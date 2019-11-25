package dev.soterocra.apachepoi.entities;

import java.io.Serializable;
import java.util.Date;

public class People implements Serializable {
	private static final long serialVersionUID = -3184431218939000441L;

	private String nome;
	private Integer idade;
	private String cpf;
	private String rg;
	private Date dateNasci;
	private String signo;
	private String mae;
	private String pai;
	private String email;
	private String senha;
	private String cep;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String fixo;
	private String celular;
	private Double altura;
	private Double peso;
	private String tipoSanguinio;
	private String cor;

	public People() {
	}

	public People(String nome, Integer idade, String cpf, String rg, Date dateNasci, String signo, String mae,
			String pai, String email, String senha, String cep, String endereco, Integer numero, String bairro,
			String cidade, String estado, String fixo, String celular, Double altura, Double peso, String tipoSanguinio,
			String cor) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
		this.dateNasci = dateNasci;
		this.signo = signo;
		this.mae = mae;
		this.pai = pai;
		this.email = email;
		this.senha = senha;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.fixo = fixo;
		this.celular = celular;
		this.altura = altura;
		this.peso = peso;
		this.tipoSanguinio = tipoSanguinio;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDateNasci() {
		return dateNasci;
	}

	public void setDateNasci(Date dateNasci) {
		this.dateNasci = dateNasci;
	}

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getTipoSanguinio() {
		return tipoSanguinio;
	}

	public void setTipoSanguinio(String tipoSanguinio) {
		this.tipoSanguinio = tipoSanguinio;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
