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
public class CapituloModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String titulo;
	private int numCap;
	
	@OneToMany(mappedBy = "capitulo" , fetch = FetchType.EAGER)
	private List<PaginaModel> paginas;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private VolumeModel volume;

	
	/* getters e setters*/
	
	
		
	public String getTitulo() {
		return titulo;
	}

	public int getNumCap() {
		return numCap;
	}

	public void setNumCap(int numCap) {
		this.numCap = numCap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public VolumeModel getVolume() {
		return volume;
	}

	public void setVolume(VolumeModel volume) {
		this.volume = volume;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<PaginaModel> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<PaginaModel> paginas) {
		this.paginas = paginas;
	}
	
	@Override
	public String toString() {
		return "Capítulo " + this.numCap + " - " + this.titulo;
	}
	
}
