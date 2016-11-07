package biblioteca.tests;

import java.util.List;
import biblioteca.dao.AutorDAO;
import biblioteca.entities.Autor;

public class AutorTest {
	public static void main(String[] args) throws Exception {
		
		//TEST INSERIR E LISTAR
		/*
		Autor autor1 = new Autor();
		autor1.setNome("Josué");
		autor1.setSobrenome("Santos");
				
		AutorDAO dao = new AutorDAO();
		
		dao.inserir(autor1);
		
		try 
		{
			List<Autor> autores = dao.listarTodos();
			
			for (Autor autor : autores) {
				System.out.println(autor.getIdAutor());
				System.out.println(autor.getNome());
				System.out.println(autor.getSobrenome());
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		
		
		//TEST ALTERAR
		
		Autor autor1 = new Autor();
		
		AutorDAO dao = new AutorDAO();
		
		autor1.setIdAutor(1);
		autor1.setNome("Adriano");
		autor1.setSobrenome("Silva");
		 
		 dao.alterar(autor1);
		 
		 System.out.println("Alterado!");
		 
		 try 
			{
				List<Autor> autores = dao.listarTodos();
				
				for (Autor autor : autores) {
					System.out.println(autor.getIdAutor());
					System.out.println(autor.getNome());
					System.out.println(autor.getSobrenome());
					System.out.println("=============================");
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}

		//TEST DELETAR		
		/*
		
		AutorDAO dao = new AutorDAO();

		try 
		{
		
			dao.deletar(1);
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		try 
		{
			List<Autor> autores = dao.listarTodos();
			
			for (Autor autor : autores) {
				System.out.println(autor.getIdAutor());
				System.out.println(autor.getNome());
				System.out.println(autor.getSobrenome());
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
	*/
	
	}
}




