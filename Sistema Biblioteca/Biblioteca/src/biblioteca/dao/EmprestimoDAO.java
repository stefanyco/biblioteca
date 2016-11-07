package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import biblioteca.config.Factory;
import biblioteca.entities.Emprestimo;

public class EmprestimoDAO {
	
	Connection connection;
	
	UsuarioDAO usuarioDAO;
	LivroDAO livroDAO;
	
	public EmprestimoDAO() throws Exception {
		this.connection = new Factory().getConnection();
	}


	public void inserir(Emprestimo emprestimo) {
		try 
		{
			String sql = "INSERT INTO TB_EMPRESTIMO " + "(ID_USUARIO, ID_LIVRO, DATAEMPRESTIMO, DATADEVOLU플O"
					 + " VALUES (?,?,?,?)";
			
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, emprestimo.getUsuario().getIdUsuario());
			statement.setInt(2, emprestimo.getLivro().getIdLivro());
			statement.setDate(3, emprestimo.getDataEmprestimo());
			statement.setDate(4, emprestimo.getDataDevolucao());
					
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void alterar(Emprestimo emprestimo) {
		try 
		{
			String sql = "UPDATE  TB_EMPRESTIMO "
					+ " SET ID_USUARIO=?, ID_LIVRO=?, DATAEMPRESTIMO=?, DAATDEVOLUCAO=? "
					+ " WHERE ID_EMPRESTIMO = ? ";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, emprestimo.getUsuario().getIdUsuario());
			statement.setInt(2, emprestimo.getLivro().getIdLivro());
			statement.setDate(3, emprestimo.getDataEmprestimo());
			statement.setDate(4, emprestimo.getDataDevolucao());
			statement.setInt(5, emprestimo.getIdEmprestimo());
		
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void deletar(Integer id) {
		try 
		{
			String sql = "DELETE FROM  TB_EMPRESTIMO"
					+ " WHERE ID_EMPRESTIMO = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public List<Emprestimo> listarTodos() {
		List<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();
		
		try 
		{
			String sql = "SELECT * FROM TB_EMPRESTIMO";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Emprestimo emp= new Emprestimo();
				
				emp.setIdEmprestimo(resultSet.getInt("ID_EMPRESTIMO"));
				emp.setUsuario(usuarioDAO.buscarPorId(resultSet.getInt("ID_USUARIO")));
				emp.setLivro(livroDAO.buscarPorId(resultSet.getInt("ID_LIVRO")));
				emp.setDataEmprestimo(resultSet.getDate("DATAEMPRESTIMO"));
				emp.setDataDevolucao(resultSet.getDate("DATADEVOLU플O"));
						
						
				listaEmprestimos.add(emp);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaEmprestimos;
	}


	public Emprestimo buscarPorId(Integer id) {
		Emprestimo emp = null;
		
		try 
		{
			String sql = "SELECT * FROM TB_EMPRESTIMO "
					+ " WHERE ID_EMPRESTIMO = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				emp = new Emprestimo();
				
				emp.setIdEmprestimo(resultSet.getInt("ID_EMPRESTIMO"));
				emp.setUsuario(usuarioDAO.buscarPorId(resultSet.getInt("ID_USUARIO")));
				emp.setLivro(livroDAO.buscarPorId(resultSet.getInt("ID_LIVRO")));
				emp.setDataEmprestimo(resultSet.getDate("DATAEMPRESTIMO"));
				emp.setDataDevolucao(resultSet.getDate("DATADEVOLU플O"));
			}
			
			statement.execute();
			statement.close();
			resultSet.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}


	public List<Emprestimo> buscaLike(Integer param) {
		List<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();
		
		try 
		{
			String sql = "SELECT * FROM TB_EMPRESTIMO "
					+ " WHERE ID_USUARIO LIKE ?%";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, param);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Emprestimo emp = new Emprestimo();
				
				emp.setIdEmprestimo(resultSet.getInt("ID_EMPRESTIMO"));
				emp.setUsuario(usuarioDAO.buscarPorId(resultSet.getInt("ID_USUARIO")));
				emp.setLivro(livroDAO.buscarPorId(resultSet.getInt("ID_LIVRO")));
				emp.setDataEmprestimo(resultSet.getDate("DATAEMPRESTIMO"));
				emp.setDataDevolucao(resultSet.getDate("DATADEVOLU플O"));
				
				listaEmprestimos.add(emp);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaEmprestimos;
	}

}

	

