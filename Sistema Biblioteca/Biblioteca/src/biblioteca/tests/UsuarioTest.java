package biblioteca.tests;

import java.util.List;

import biblioteca.dao.UsuarioDAO;
import biblioteca.entities.Usuario;

public class UsuarioTest {
	public static void main(String[] args) throws Exception {
		
		//TESTE INSERIR E LISTAR
		/*
		Usuario user1 = new Usuario();
		
		user1.setRa(1520283);
		user1.setCpf("222.444.888-20");
		user1.setNome("Marta Silva");
		user1.setTpUsuario("Aluno");
		user1.setEmail("aluno@fit.com.br");
		user1.setAtivo(true);
		user1.setQtdLivros(1);
		user1.setSenha("senha9999");
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.inserir(user1);
		
		try 
		{
			List<Usuario> users = dao.listarTodos();
			
			for (Usuario usuario : users) {
				System.out.println(usuario.getIdUsuario());
				System.out.println(usuario.getRa());
				System.out.println(usuario.getCpf());
				System.out.println(usuario.getNome());
				System.out.println(usuario.getTpUsuario());
				System.out.println(usuario.getEmail());
				System.out.println(usuario.getAtivo());
				System.out.println(usuario.getQtdLivros());
				System.out.println(usuario.getSenha());
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		//TESTE ALTERAR
		
		Usuario user1 = new Usuario();
		
		UsuarioDAO dao = new UsuarioDAO();
		
		user1.setIdUsuario(5);
		user1.setRa(1520283);
		user1.setCpf("222.444.888-20");
		user1.setNome("Marta Silva dos Anjos");
		user1.setTpUsuario("Aluno");
		user1.setEmail("aluno@fit.com.br");
		user1.setAtivo(true);
		user1.setQtdLivros(1);
		user1.setSenha("Segred@");
	
		 
		 dao.alterar(user1);
		 
		 System.out.println("Alterado!");
		
		 try 
			{
				List<Usuario> users = dao.listarTodos();
				
				for (Usuario usuario : users) {
					System.out.println(usuario.getIdUsuario());
					System.out.println(usuario.getRa());
					System.out.println(usuario.getCpf());
					System.out.println(usuario.getNome());
					System.out.println(usuario.getTpUsuario());
					System.out.println(usuario.getEmail());
					System.out.println(usuario.getAtivo());
					System.out.println(usuario.getQtdLivros());
					System.out.println(usuario.getSenha());
					System.out.println("=============================");
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		 
		 /*
		
		//TESTE DELETAR
		
		UsuarioDAO dao = new UsuarioDAO();

		try 
		{
		
			dao.deletar(1);
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		try 
		{
			List<Usuario> users = dao.listarTodos();
			
			for (Usuario usuario : users) {
				System.out.println(usuario.getIdUsuario());
				System.out.println(usuario.getRa());
				System.out.println(usuario.getCpf());
				System.out.println(usuario.getNome());
				System.out.println(usuario.getTpUsuario());
				System.out.println(usuario.getEmail());
				System.out.println(usuario.getAtivo());
				System.out.println(usuario.getQtdLivros());
				System.out.println(usuario.getSenha());
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
	*/
	
	}
}
