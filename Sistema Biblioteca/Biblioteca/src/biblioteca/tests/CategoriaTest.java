package biblioteca.tests;


import java.util.List;

import biblioteca.dao.CategoriaDAO;
import biblioteca.entities.Categoria;

public class CategoriaTest {
	public static void main(String[] args) throws Exception {
		
		//TEST INSERIR E LISTAR
		/*
		Categoria cat1 = new Categoria();
		cat1.setNome("Ciência");
				
		CategoriaDAO dao = new CategoriaDAO();
		
		dao.inserir(cat1);
		
		try 
		{
			List<Categoria> categorias = dao.listarTodos();
			
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getIdCategoria());
				System.out.println(categoria.getNome());
		
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		//TEST ALTERAR
		
		Categoria cat1 = new Categoria();
		
		CategoriaDAO dao = new CategoriaDAO();
		
		cat1.setIdCategoria(1);
		cat1.setNome("Tecnologia da Informação");
	
		 
		 dao.alterar(cat1);
		 
		 System.out.println("Alterado!");
		
		 try 
			{
				List<Categoria> categorias = dao.listarTodos();
				
				for (Categoria categoria : categorias) {
					System.out.println(categoria.getIdCategoria());
					System.out.println(categoria.getNome());
			
					System.out.println("=============================");
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}

		*/
		//TEST DELETAR		
		
		
		CategoriaDAO dao = new CategoriaDAO();

		try 
		{
		
			dao.deletar(1);
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		try 
		{
			List<Categoria> categorias = dao.listarTodos();
			
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getIdCategoria());
				System.out.println(categoria.getNome());
		
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}



