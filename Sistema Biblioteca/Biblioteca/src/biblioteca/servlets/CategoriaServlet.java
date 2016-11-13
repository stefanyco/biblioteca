package biblioteca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.dao.CategoriaDAO;
import biblioteca.entities.Categoria;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CategoriaServlet() {}
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
		String proxPage = "home.jsp";
		
		try 
		{
			CategoriaDAO dao = new CategoriaDAO();
			if (acao.equals("cadastrar")) {
				String nome = request.getParameter("nome");
				
				Categoria categoria = new Categoria(nome);
				dao.inserir(categoria);
				request.setAttribute("msg", "Cadastrado com Sucesso!");
				proxPage = "categoriaListar.jsp";
			}else if (acao.equals("listar")) {
				List<Categoria> lista = dao.listarTodos();
				request.setAttribute("listaCategorias", lista);
				proxPage = "categoriaListar.jsp";
			}else if (acao.equals("remover")) {
				
				String id = request.getParameter("id");
				
				dao.deletar(Integer.parseInt(id));
				request.setAttribute("msg", "Removido com Sucesso!");
				proxPage = "categoriaListar.jsp";
			}else if (acao.equals("editar")) {
				String id = request.getParameter("id");
				
				Categoria categoria = dao.buscarPorId(Integer.parseInt(id));
				request.setAttribute("categoria", categoria);
				proxPage = "categoriaEditar.jsp";
			
			}else if (acao.equals("atualizar")) {
				
				String id = request.getParameter("id");
				String nome = request.getParameter("nome");
				
				Categoria categoria = new Categoria(Integer.parseInt(id), nome);
				dao.alterar(categoria);
				request.setAttribute("msg", "Alterado com Sucesso!");
				proxPage = "categoria?acao=listar";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(proxPage).forward(request, response);

    }

  
}
