package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProjetoModel {
	
	private String nomeProjeto;
	private String sinopse;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "projeto", fetch = FetchType.EAGER)
	private List<VolumeModel> volumes;
	
	@ManyToOne(optional = false,fetch=FetchType.EAGER)
	private AutorModel autor;
	
		
	/* getters e setters */
	
	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<VolumeModel> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<VolumeModel> volumes) {
		this.volumes = volumes;
	}

	public AutorModel getAutor() {
		return autor;
	}

	public void setAutor(AutorModel autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "Projeto: " + this.nomeProjeto;
	}
}
