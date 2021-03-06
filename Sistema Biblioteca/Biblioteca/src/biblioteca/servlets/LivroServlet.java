package biblioteca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.dao.AutorDAO;
import biblioteca.dao.CategoriaDAO;
import biblioteca.dao.EditoraDAO;
import biblioteca.dao.LivroDAO;
import biblioteca.entities.Autor;
import biblioteca.entities.Categoria;
import biblioteca.entities.Editora;
import biblioteca.entities.Livro;

/**
 * Servlet implementation class AutorServlet
 */
@WebServlet("/livro")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LivroServlet() {}
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String acao = request.getParameter("acao");
		String proxPage = "home.jsp";
		
		
	
		
		try 
		{
			Categoria ct = null;
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			
			Autor at = null;
			AutorDAO autorDAO = new AutorDAO();
			
			Editora ed = null;
			EditoraDAO editoraDAO = new EditoraDAO();
			
			LivroDAO dao = new LivroDAO();
			if (acao.equals("cadastrar")) {
				String titulo = request.getParameter("titulo");
				String edicao = request.getParameter("edicao");
				String ano = request.getParameter("ano");
				String qtd = request.getParameter("qtd");
				String tipo = request.getParameter("tipo");
				String especial = request.getParameter("especial");
				String idCategoria = request.getParameter("idCategoria");
				String idEditora = request.getParameter("idEditora");
				String idAutor = request.getParameter("idAutor");
				String sinopse = request.getParameter("sinopse");
				
				ct = categoriaDAO.buscarPorId(Integer.parseInt(idCategoria));
				at = autorDAO.buscarPorId(Integer.parseInt(idAutor));
				ed = editoraDAO.buscarPorId(Integer.parseInt(idEditora));
				
				Livro lv = new Livro();
				
				lv.setTitulo(titulo);
				lv.setEdicao(Integer.parseInt(edicao));
				lv.setAno(Integer.parseInt(ano));
				lv.setQtd(Integer.parseInt(qtd));
				lv.setTipo(tipo);
				lv.setEspecial(especial);
				lv.setCategoria(ct);
				lv.setEditora(ed);
				lv.setAutor(at);
				lv.setSinopse(sinopse);
				
				dao.inserir(lv);
				request.setAttribute("msg", "Cadastro Efetuado com Sucesso!");
				proxPage = "livro?acao=listar";
			}else if (acao.equals("listar")) {
				List<Livro> lista = dao.listarTodos();
				request.setAttribute("listaLivros", lista);
				proxPage = "livroListar.jsp";
			}else if (acao.equals("remover")) {
				
				String id = request.getParameter("id");
				
				dao.deletar(Integer.parseInt(id));
				proxPage = "livroListar.jsp";
			}else if (acao.equals("editar")) {
				String id = request.getParameter("id");
				
				Livro livro = dao.buscarPorId(Integer.parseInt(id));
				request.setAttribute("autor", livro);
				proxPage = "livroListar.jsp";
			}else if (acao.equals("atualizar")) {
				
				String id = request.getParameter("id");
				String titulo = request.getParameter("titulo");
				String edicao = request.getParameter("edicao");
				String ano = request.getParameter("ano");
				String qtd = request.getParameter("qtd");
				String tipo = request.getParameter("tipo");
				String especial = request.getParameter("especial");
				String idCategoria = request.getParameter("idCategoria");
				String idEditora = request.getParameter("idEditora");
				String idAutor = request.getParameter("idAutor");
				String sinopse = request.getParameter("sinopse");
				
				ct = categoriaDAO.buscarPorId(Integer.parseInt(idCategoria));
				at = autorDAO.buscarPorId(Integer.parseInt(idAutor));
				ed = editoraDAO.buscarPorId(Integer.parseInt(idEditora));
				
				Livro lv = new Livro();
				
				lv.setTitulo(titulo);
				lv.setEdicao(Integer.parseInt(edicao));
				lv.setAno(Integer.parseInt(ano));
				lv.setQtd(Integer.parseInt(qtd));
				lv.setTipo(tipo);
				lv.setEspecial(especial);
				lv.setCategoria(ct);
				lv.setEditora(ed);
				lv.setAutor(at);
				lv.setSinopse(sinopse);
				lv.setIdLivro(Integer.parseInt(id));
				
				dao.inserir(lv);
				request.setAttribute("msg", "Cadastro Efetuado com Sucesso!");
				proxPage = "livro?acao=listar";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(proxPage).forward(request, response);

    }
  
}
