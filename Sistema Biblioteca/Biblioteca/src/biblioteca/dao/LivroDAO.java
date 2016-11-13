package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import biblioteca.config.Factory;
import biblioteca.entities.Livro;

public class LivroDAO implements GenericDAO<Livro> {

	Connection connection;
	
	EditoraDAO editoraDAO;
	AutorDAO autorDAO;
	CategoriaDAO categoriaDAO;
	
	public LivroDAO() throws Exception {
		this.connection = new Factory().getConnection();
	}

	@Override
	public void inserir(Livro livro) {
		try 
		{
			String sql = "INSERT INTO TB_LIVRO " + "(ID_EDITORA, ID_AUTOR, ID_CATEGORIA,"
					+ "TITULO, EDICAO, ANO, QTD, TIPO, ESPECIAL, SINOPSE) " + " VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, livro.getEditora().getIdEditora());
			statement.setInt(2, livro.getAutor().getIdAutor());
			statement.setInt(3, livro.getCategoria().getIdCategoria());
			statement.setString(4, livro.getTitulo());
			statement.setInt(5, livro.getEdicao());
			statement.setInt(6, livro.getAno());
			statement.setInt(7, livro.getQtd());
			statement.setString(8, livro.getTipo());
			statement.setString(9, livro.getEspecial());
			
			statement.setString(10, livro.getSinopse());
			
			
			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Livro livro) {
		try 
		{
			String sql = "UPDATE  TB_LIVRO "
					+ " SET ID_EDITORA=?, ID_AUTOR=?, ID_CATEGORIA=?, TITULO=?, EDICAO=?, ANO=?, QTD=?, SINOPSE=?, "
					+ " TIPO=?, ESPECIAL=? "
					+ " WHERE ID_LIVRO = ? ";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, livro.getEditora().getIdEditora());
			statement.setInt(2, livro.getAutor().getIdAutor());
			statement.setInt(3, livro.getCategoria().getIdCategoria());
			statement.setString(4, livro.getTitulo());
			statement.setInt(5, livro.getEdicao());
			statement.setInt(6, livro.getAno());
			statement.setInt(7, livro.getQtd());
			statement.setString(8, livro.getSinopse());
			statement.setString(9, livro.getTipo());
			statement.setString(10, livro.getEspecial());
			statement.setInt(11, livro.getIdLivro());
			
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
			String sql = "DELETE FROM  TB_LIVRO"
					+ " WHERE ID_LIVRO = ?";
			
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
	public List<Livro> listarTodos() throws Exception {
		List<Livro> listaLivros = new ArrayList<Livro>();
		
		try 
		{
			String sql = "SELECT * FROM TB_LIVRO";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Livro livro	= new Livro();
				
				livro.setIdLivro(resultSet.getInt("ID_LIVRO"));
				livro.setEditora(editoraDAO.buscarPorId(resultSet.getInt("ID_EDITORA")));
				livro.setAutor(autorDAO.buscarPorId(resultSet.getInt("ID_AUTOR")));
				livro.setCategoria(categoriaDAO.buscarPorId(resultSet.getInt("ID_CATEGORIA")));
				livro.setTitulo(resultSet.getString("TITULO"));
				livro.setEdicao(resultSet.getInt("EDICAO"));
				livro.setAno(resultSet.getInt("ANO"));
				livro.setQtd(resultSet.getInt("QTD"));
				livro.setSinopse(resultSet.getString("SINOPSE"));
				livro.setTipo(resultSet.getString("TIPO"));
				livro.setEspecial(resultSet.getString("ESPECIAL"));
						
				listaLivros.add(livro);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaLivros;
	}

	@Override
	public Livro buscarPorId(Integer id) {
		Livro livro = null;
		
		try 
		{
			String sql = "SELECT * FROM TB_LIVRO "
					+ " WHERE ID_LIVRO = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				livro = new Livro();
				
				livro.setIdLivro(resultSet.getInt("ID_LIVRO"));
				livro.setEditora(editoraDAO.buscarPorId(resultSet.getInt("ID_EDITORA")));
				livro.setAutor(autorDAO.buscarPorId(resultSet.getInt("ID_AUTOR")));
				livro.setCategoria(categoriaDAO.buscarPorId(resultSet.getInt("ID_CATEGORIA")));
				livro.setTitulo(resultSet.getString("TITULO"));
				livro.setEdicao(resultSet.getInt("EDICAO"));
				livro.setAno(resultSet.getInt("ANO"));
				livro.setQtd(resultSet.getInt("QTD"));
				livro.setSinopse(resultSet.getString("SINOPSE"));
				livro.setTipo(resultSet.getString("TIPO"));
				livro.setEspecial(resultSet.getString("ESPECIAL"));
			}
			
			statement.execute();
			statement.close();
			resultSet.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return livro;
	}

	@Override
	public List<Livro> buscaLike(String param) {
		List<Livro> listaLivros = new ArrayList<Livro>();
		
		try 
		{
			String sql = "SELECT * FROM TB_LIVRO "
					+ " WHERE TITULO LIKE ?%";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, param);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Livro livro = new Livro();
				
				livro.setIdLivro(resultSet.getInt("ID_LIVRO"));
				livro.setEditora(editoraDAO.buscarPorId(resultSet.getInt("ID_EDITORA")));
				livro.setAutor(autorDAO.buscarPorId(resultSet.getInt("ID_AUTOR")));
				livro.setCategoria(categoriaDAO.buscarPorId(resultSet.getInt("ID_CATEGORIA")));
				livro.setTitulo(resultSet.getString("TITULO"));
				livro.setEdicao(resultSet.getInt("EDICAO"));
				livro.setAno(resultSet.getInt("ANO"));
				livro.setQtd(resultSet.getInt("QTD"));
				livro.setSinopse(resultSet.getString("SINOPSE"));
				livro.setTipo(resultSet.getString("TIPO"));
				livro.setEspecial(resultSet.getString("ESPECIAL"));
				
				listaLivros.add(livro);
				
			}
			
			resultSet.close();
			statement.close();
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaLivros;
	}

	

	

}
