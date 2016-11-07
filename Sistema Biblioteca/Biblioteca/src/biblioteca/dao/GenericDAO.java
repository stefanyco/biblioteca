package biblioteca.dao;

import java.util.List;

public interface GenericDAO <T>{

	void inserir(T obj);
	void alterar(T obj);
	void deletar(Integer id);
	
	List<T> listarTodos() throws Exception;
	T buscarPorId(Integer id);
	List<T> buscaLike(String param);
	
}
