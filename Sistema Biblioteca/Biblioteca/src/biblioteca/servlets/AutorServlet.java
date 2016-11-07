package biblioteca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.dao.AutorDAO;
import biblioteca.entities.Autor;

/**
 * Servlet implementation class AutorServlet
 */
@WebServlet("/autor")
public class AutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AutorServlet() {}
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String acao = request.getParameter("acao");
		String proxPage = "home.jsp";
		
		try 
		{
			AutorDAO dao = new AutorDAO();
			if (acao.equals("cadastrar")) {
				String nome = request.getParameter("nome");
				String sobrenome = request.getParameter("sobrenome");
				
				
				Autor autor = new Autor(nome, sobrenome);
				dao.inserir(autor);
				request.setAttribute("msg", "Cadastro Efetuado com Sucesso!");
				proxPage = "autor?acao=listar";
			}else if (acao.equals("listar")) {
				List<Autor> lista = dao.listarTodos();
				request.setAttribute("listaAutores", lista);
				proxPage = "autorListar.jsp";
			}else if (acao.equals("remover")) {
				
				String id = request.getParameter("id");
				
				dao.deletar(Integer.parseInt(id));
				proxPage = "autorListar.jsp";
			}else if (acao.equals("editar")) {
				String id = request.getParameter("id");
				
				Autor autor = dao.buscarPorId(Integer.parseInt(id));
				request.setAttribute("autor", autor);
				proxPage = "autorEditar.jsp";
			}else if (acao.equals("atualizar")) {
				
				String id = request.getParameter("id");
				String nome = request.getParameter("nome");
				String sobrenome = request.getParameter("sobrenome");
				
				Autor autor = new Autor(Integer.parseInt(id), nome, sobrenome);
				dao.alterar(autor);
				proxPage = "autor?acao=listar";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(proxPage).forward(request, response);

    }
  
}
