package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import biblioteca.config.Factory;
import biblioteca.entities.Categoria;

public class CategoriaDAO implements GenericDAO<Categoria>  {
	
	Connection connection;
	
	public CategoriaDAO() throws Exception {
		this.connection = new Factory().getConnection();
	}

	@Override
	public void inserir(Categoria categoria) {
		try 
		{
			String sql = "INSERT INTO TB_CATEGORIA" + "(NOME)" + " VALUES (?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoria.getNome());
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Categoria categoria) {
		try 
		{
			String sql = "UPDATE  TB_CATEGORIA "
					+ " SET NOME = ? "
					+ " WHERE ID_CATEGORIA = ? ";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoria.getNome());
			statement.setInt(2, categoria.getIdCategoria());
			
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
			String sql = "DELETE FROM  TB_CATEGORIA "
					+ " WHERE ID_CATEGORIA = ?";
			
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
	public List<Categoria> listarTodos() {
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		try 
		{
			String sql = "SELECT * FROM TB_CATEGORIA";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Categoria cat = new Categoria();
				
				cat.setIdCategoria(resultSet.getInt("ID_CATEGORIA"));
				cat.setNome(resultSet.getString("NOME"));
				
				listaCategorias.add(cat);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaCategorias;
	}

	@Override
	public Categoria buscarPorId(Integer id) {
		Categoria cat = null;
		
		try 
		{
			String sql = "SELECT * FROM TB_CATEGORIA "
					+ " WHERE ID_CATEGORIA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				cat = new Categoria();
				
				cat.setIdCategoria(resultSet.getInt("ID_CATEGORIA"));
				cat.setNome(resultSet.getString("NOME"));
			}
			
			statement.execute();
			statement.close();
			resultSet.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cat;
	}

	@Override
	public List<Categoria> buscaLike(String param) {
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		try 
		{
			String sql = "SELECT * FROM TB_CATEGORIA "
					+ " WHERE NOME LIKE ?%";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, param);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Categoria cat = new Categoria();
				
				cat.setIdCategoria(resultSet.getInt("ID_CATEGORIA"));
				cat.setNome(resultSet.getString("NOME"));
				
				listaCategorias.add(cat);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaCategorias;
	}

	

}
