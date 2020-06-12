package hibernate;

import org.junit.Test;

import dao.Daogenerico;
import model.AutorModel;
import model.PaginaModel;
import model.ProjetoModel;

public class Testador {
	
	@Test
	public void testeConexao() {
		UtilitariosHibernate.getEntityManager();
	}
	
	@Test
	public void testeSalvar() {
		
		//AUTOR
		/*Daogenerico<AutorModel> daoAutor = new Daogenerico<AutorModel>();
		
		AutorModel autor = new AutorModel();
		autor.setNomeCompleto("Fagner Cunha da Cruz");
		autor.setPseudonimo("Penouther");
		
		daoAutor.salvar(autor);
		*/
		
		//PROJETO
		Daogenerico<ProjetoModel> DAOProjeto = new Daogenerico<>();
		AutorModel autor = new AutorModel();
		autor.setId(1L);
		ProjetoModel projeto = new ProjetoModel();
		projeto.setNomeProjeto("One-Punch Girl");
		projeto.setSinopse("Somos apresentado a uma moça que treina até perder os cabelos e com um soco ajeita qualquer maquiagem");
		projeto.setAutor((AutorModel) DAOProjeto.pesquisar(autor));
		DAOProjeto.salvar(projeto);
		
	}
	
	@Test
	public void pesquisar() {
		Daogenerico<AutorModel> autorDAO = new Daogenerico<AutorModel>();
		
		AutorModel autor = new AutorModel();
		autor.setId(1L);
		autor = (AutorModel) autorDAO.pesquisar(autor);
		System.out.println(autor);
		
	}
	
	@Test
	public void listar() {
		Daogenerico dao = new Daogenerico();
		
		AutorModel autor = new AutorModel();
		autor.setId(1L);
		autor = (AutorModel) dao.pesquisar(autor);
		
		System.out.println("Projetos de " + autor.getPseudonimo());
		System.out.println("---------------------------");
		for (ProjetoModel projetos : autor.getProjetos()) {
			System.out.println(projetos.getNomeProjeto() + ":");
			System.out.println(projetos.getSinopse());
			System.out.println("=====");
		}
	}

}
