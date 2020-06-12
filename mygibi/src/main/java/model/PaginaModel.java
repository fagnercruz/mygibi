package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PaginaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int pag;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private CapituloModel capitulo;

	/* getters e setters */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPag() {
		return pag;
	}

	public void setPag(int pag) {
		this.pag = pag;
	}

	public CapituloModel getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(CapituloModel capitulo) {
		this.capitulo = capitulo;
	}

	@Override
	public String toString() {
		return "página " + this.pag;
	}

}
