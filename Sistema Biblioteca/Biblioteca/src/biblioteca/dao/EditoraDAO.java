package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import biblioteca.config.Factory;
import biblioteca.entities.Editora;

public class EditoraDAO implements GenericDAO<Editora> {

	Connection connection;

	public EditoraDAO() throws Exception {
		this.connection = new Factory().getConnection();
	}

	@Override
	public void inserir(Editora editora) {
		try 
		{
			String sql = "INSERT INTO TB_EDITORA (NOME) VALUES (?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, editora.getNome());

			statement.execute();
			statement.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Editora editora) {
		try 
		{
			String sql = "UPDATE  TB_EDITORA "
					+ " SET NOME = ? "
					+ " WHERE ID_EDITORA = ? ";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, editora.getNome());
			statement.setInt(2, editora.getIdEditora());

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
			String sql = "DELETE FROM  TB_EDITORA "
					+ " WHERE ID_EDITORA = ?";

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
	public List<Editora> listarTodos() {
		List<Editora> listaEditoras = new ArrayList<Editora>();

		try 
		{
			String sql = "SELECT * FROM TB_EDITORA";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Editora ed = new Editora();

				ed.setIdEditora(resultSet.getInt("ID_EDITORA"));
				ed.setNome(resultSet.getString("NOME"));

				listaEditoras.add(ed);

			}

			resultSet.close();
			statement.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaEditoras;
	}

	@Override
	public Editora buscarPorId(Integer id) {
		Editora ed = null;

		try 
		{
			String sql = "SELECT * FROM TB_EDITORA "
					+ " WHERE ID_EDITORA = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				ed = new Editora();

				ed.setIdEditora(resultSet.getInt("ID_EDITORA"));
				ed.setNome(resultSet.getString("NOME"));
			}

			statement.execute();
			statement.close();
			resultSet.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return ed;
	}

	@Override
	public List<Editora> buscaLike(String param) {
		List<Editora> listaEditoras = new ArrayList<Editora>();

		try 
		{
			String sql = "SELECT * FROM TB_EDITORA "
					+ " WHERE NOME LIKE '%?%' ";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, param);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Editora ed = new Editora();

				ed.setIdEditora(resultSet.getInt("ID_EDITORA"));
				ed.setNome(resultSet.getString("NOME"));

				listaEditoras.add(ed);

			}

			resultSet.close();
			statement.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return listaEditoras;
	}



}
