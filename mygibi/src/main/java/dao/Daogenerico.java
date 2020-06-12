package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hibernate.UtilitariosHibernate;

public class Daogenerico<E> {

	// Obtém um EntityManager do Hibernate - (texto adicionado pelo github)
	private EntityManager gerenciadorEntidades = UtilitariosHibernate.getEntityManager();
	
	// Métodos CRUD
	
	public void salvar(E entidade) {
		EntityTransaction transacao = gerenciadorEntidades.getTransaction();
		transacao.begin();
		gerenciadorEntidades.persist(entidade);
		transacao.commit();
	}
	
	public Object pesquisar(Object entidade) {
		Object id = UtilitariosHibernate.getPK(entidade);
		Object retorno = gerenciadorEntidades.find(entidade.getClass(), id);
		return retorno;
	}
	
}
