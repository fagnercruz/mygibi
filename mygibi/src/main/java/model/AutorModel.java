package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AutorModel {
	
	
	/* atributos */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String nomeCompleto;
	private String pseudonimo;
	
	@OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
	private List<ProjetoModel> projetos;
	
	/* métodos getters e setters */
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getPseudonimo() {
		return pseudonimo;
	}
	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}
	public List<ProjetoModel> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<ProjetoModel> projetos) {
		this.projetos = projetos;
	}
	
	@Override
	public String toString() {
		return "Autor: " + this.pseudonimo + " (aka " + this.nomeCompleto + ")";
	}
	
}
