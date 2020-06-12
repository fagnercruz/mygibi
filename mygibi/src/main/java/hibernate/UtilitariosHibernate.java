package hibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilitariosHibernate {
	
	// Atributos =====================================================================================
	private static EntityManagerFactory fabricaGerenciadorEntidades = null;
	
	
	// Métodos =======================================================================================
	
	/* método que cria uma única fábrica de gerenciador de entidades (padrão singleton) */
	private static void init() {
		try {
			if(fabricaGerenciadorEntidades == null) {
				//mygibi esta na tag <persistence-unit> do persistence.xml
				fabricaGerenciadorEntidades = Persistence.createEntityManagerFactory("mygibi"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* método que obtém (e retorna) um gerenciador de entidades da fábrica de gerenciador de entidades */
	public static EntityManager getEntityManager() {
		return fabricaGerenciadorEntidades.createEntityManager();
	}
	
	/* método que devolve um objeto salvo no banco, pesquisando pela campo id preenchido no objeto entidade
	 * 
	 * ex: se a entidade passada por 
	 * paramentro for um objeto do tipo 
	 * telefone, ele vai buscar na 
	 * tabela telefone
	 *  
	 *  */
	public static Object getPK(Object entidade) {
		return fabricaGerenciadorEntidades.getPersistenceUnitUtil().getIdentifier(entidade);
	}
	
	/* método executado sempre quando a classe é invocada */
	static {
		init();
	}
	
}
