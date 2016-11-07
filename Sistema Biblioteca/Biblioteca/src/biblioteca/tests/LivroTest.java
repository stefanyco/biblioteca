package biblioteca.tests;

import java.util.List;

import biblioteca.dao.LivroDAO;
import biblioteca.entities.Livro;

public class LivroTest {
	public static void main(String[] args) throws Exception {
		
		//TESTE INSERIR E LISTAR
		/*
		Livro livro1 = new Livro();
		
		livro1.setAno(2000);
		livro1.setEdicao(10);
		livro1.setIdAutor(1);
		livro1.setIdCategoria(2);
		livro1.setIdEditora(3);
		livro1.setQtd(4);
		livro1.setSinopse("Desenvolvimento Java Web");
		livro1.setTitulo("Java");
			
		
		LivroDAO dao = new LivroDAO();
		dao.inserir(livro1);
		
		try 
		{
			List<Livro> livros = dao.listarTodos();
			
			for (Livro livro : livros) {
				System.out.println(livro.getSinopse());
				System.out.println(livro.getTitulo());
				System.out.println(livro.getAno());
				System.out.println(livro.getEdicao());
				System.out.println(livro.getIdAutor());
				System.out.println(livro.getIdCategoria());
				System.out.println(livro.getIdEditora());
				System.out.println(livro.getIdLivro());
				System.out.println(livro.getQtd());
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		//TESTE ALTERAR
		
		Livro livro1 = new Livro();
		
		LivroDAO dao = new LivroDAO();
		
		livro1.setIdLivro(1);
		livro1.setAno(2000);
		livro1.setEdicao(10);
		//livro1.setIdAutor(1);
		//livro1.setIdCategoria(2);
		//livro1.setIdEditora(3);
		livro1.setQtd(10);
		livro1.setSinopse("Desenvolvimento Java Web");
		livro1.setTitulo("Java");
		 
		 dao.alterar(livro1);
		 
		 System.out.println("Alterado!");

		
		//TESTE DELETAR
		/*
		
		LivroDAO dao = new LivroDAO();

		try 
		{
		
			dao.deletar(1);
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		try 
		{
			List<Livro> livros = dao.listarTodos();
			
			for (Livro livro : livros) {
				System.out.println(livro.getIdEditora());
				System.out.println(livro.getIdAutor());
				System.out.println(livro.getIdCategoria());
				System.out.println(livro.getTitulo());
				System.out.println(livro.getEdicao());
				System.out.println(livro.getAno());
				System.out.println(livro.getQtd());
				System.out.println(livro.getSinopse());
				System.out.println(livro.getIdLivro());
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
	*/
	
	}
}


