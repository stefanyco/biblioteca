package biblioteca.tests;

import java.util.ArrayList;
import java.util.List;

import biblioteca.dao.EditoraDAO;
import biblioteca.entities.Editora;

public class EditoraTest {

	public static void main(String[] args) throws Exception {
		Editora ed = new Editora();
		//ed.setNome("TESTE 02 UPDATE");
		//ed.setIdEditora(2);
		
		EditoraDAO dao = new EditoraDAO();
		dao.buscarPorId(2);
		
		try 
		{
			List<Editora> eds = dao.buscaLike("TESTE");
			
			for (Editora editora : eds) {
				System.out.println(editora.getIdEditora());
				System.out.println(editora.getNome());
				System.out.println("=============================");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
