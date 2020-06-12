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
public class VolumeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int numVol;
	private String titulo;
	
	@OneToMany(mappedBy = "volume", fetch = FetchType.EAGER)
	private List<CapituloModel> capitulos;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ProjetoModel projeto;
	
	/* getters e setters */
	
	public int getNumVol() {
		return numVol;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ProjetoModel getProjeto() {
		return projeto;
	}
	public void setProjeto(ProjetoModel projeto) {
		this.projeto = projeto;
	}
	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<CapituloModel> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<CapituloModel> capitulos) {
		this.capitulos = capitulos;
	}
	
	@Override
	public String toString() {
		return "Volume " + this.numVol + " " + this.titulo;
	}
	
}
