package biblioteca.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import biblioteca.config.Factory;
import biblioteca.entities.Autor;

public class AutorDAO implements GenericDAO<Autor>{

	Connection connection;
	
	public AutorDAO() throws Exception {
		this.connection = new Factory().getConnection();
	}

	@Override
	public void inserir(Autor autor) {
		try 
		{
			String sql = "INSERT INTO TB_AUTOR " + "(NOME, SOBRENOME)" + 
					"VALUES (?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, autor.getNome());
			statement.setString(2, autor.getSobrenome());
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Autor autor) {
		try 
		{
		
		    String sql = "UPDATE TB_AUTOR SET NOME=?, SOBRENOME=? WHERE ID_AUTOR= ?";
		    
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, autor.getNome());
			statement.setString(2, autor.getSobrenome());
			statement.setInt(3, autor.getIdAutor());	
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void deletar(Integer id) {
		try 
		{
			String sql = "DELETE FROM  TB_AUTOR "
					+ " WHERE ID_AUTOR= ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Autor> listarTodos() {
		List<Autor> listaAutor = new ArrayList<Autor>();
		
		try 
		{
			String sql = "SELECT * FROM TB_AUTOR";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Autor autor = new Autor();
				
				autor.setIdAutor(resultSet.getInt("ID_AUTOR"));
				autor.setNome(resultSet.getString("NOME"));
				autor.setSobrenome(resultSet.getString("SOBRENOME"));
				
				listaAutor.add(autor);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaAutor;
	}

	@Override
	public Autor buscarPorId(Integer id) {
		Autor autor = null;
		
		try 
		{
			String sql = "SELECT * FROM TB_AUTOR "
					+ " WHERE ID_AUTOR = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				autor = new Autor();
				
				autor.setIdAutor(resultSet.getInt("ID_AUTOR"));
				autor.setNome(resultSet.getString("NOME"));
				autor.setSobrenome(resultSet.getString("SOBRENOME"));
				
			}
			
			statement.execute();
			statement.close();
			resultSet.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return autor;
	}

	@Override
	public List<Autor> buscaLike(String param) {
		List<Autor> listaAutor = new ArrayList<Autor>();
		
		try 
		{
			String sql = "SELECT * FROM TB_AUTOR "
					+ " WHERE NOME LIKE ?%";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, param);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Autor autor = new Autor();
				
				autor.setIdAutor(resultSet.getInt("ID_AUTOR"));
				autor.setNome(resultSet.getString("NOME"));
				autor.setSobrenome(resultSet.getString("SOBRENOME"));
				
				listaAutor.add(autor);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaAutor;
	}
	
	

}
