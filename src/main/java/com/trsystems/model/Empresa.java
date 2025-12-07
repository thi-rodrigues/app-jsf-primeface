package com.trsystems.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.trsystems.enums.TipoEmpresa;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 2880383352004286116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOME_FANTASIA", nullable = false, length = 80)
	private String nomeFantasia;

	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 120)
	private String razaoSocial;
	
	@Column(nullable = false, length = 18)
	private String cnpj;

	@Column(name = "DATA_FUNDACAO")
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;

	@ManyToOne
	@JoinColumn(name = "RAMO_ATIVIDADE_ID", nullable = false)
	private RamoAtividade ramoAtividade;

	@Column(name = "TIPO_EMPRESA", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private TipoEmpresa tipoEmpresa;
	
	public Empresa() {
		super();
	}

	public Empresa(Long id, String nomeFantasia, String razaoSocial, Date dataFundacao, RamoAtividade ramoAtividade,
			TipoEmpresa tipoEmpresa) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.dataFundacao = dataFundacao;
		this.ramoAtividade = ramoAtividade;
		this.tipoEmpresa = tipoEmpresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Date getDataFuncao() {
		return dataFundacao;
	}

	public void setDataFuncao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", dataFundacao="
				+ dataFundacao + ", ramoAtividade=" + ramoAtividade + ", tipoEmpresa=" + tipoEmpresa + "]";
	}

}
