package biblioteca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.dao.EditoraDAO;
import biblioteca.entities.Editora;

/**
 * Servlet implementation class EditoraServlet
 */
@WebServlet("/editora")
public class EditoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditoraServlet() {}
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String acao = request.getParameter("acao");
		String proxPage = "home.jsp";
		
		try 
		{
			EditoraDAO dao = new EditoraDAO();
			if (acao.equals("cadastrar")) {
				String nome = request.getParameter("nome");
				
				Editora editora = new Editora(nome);
				dao.inserir(editora);
				request.setAttribute("msg", "Cadastro Efetuado com Sucesso!");
				proxPage = "editora?acao=listar";
			}else if (acao.equals("listar")) {
				List<Editora> lista = dao.listarTodos();
				request.setAttribute("listaEditoras", lista);
				proxPage = "editoraListar.jsp";
			}else if (acao.equals("remover")) {
				
				String id = request.getParameter("id");
				
				dao.deletar(Integer.parseInt(id));
				proxPage = "editoraListar.jsp";
			}else if (acao.equals("editar")) {
				String id = request.getParameter("id");
				
				Editora editora = dao.buscarPorId(Integer.parseInt(id));
				request.setAttribute("editora", editora);
				proxPage = "editoraEditar.jsp";
			}else if (acao.equals("atualizar")) {
				
				String id = request.getParameter("id");
				String nome = request.getParameter("nome");
				
				Editora editora = new Editora(Integer.parseInt(id), nome);
				dao.alterar(editora);
				proxPage = "editora?acao=listar";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(proxPage).forward(request, response);

    }
  
}
