package biblioteca.entities;

public class Livro {

	private Integer idLivro;
	private Editora editora;
	private Autor autor;
	private Categoria categoria;
	private String titulo;
	private Integer edicao;
	private Integer ano;
	private Integer qtd;
	private String sinopse;
	private String tipo;
	private String especial;


	public Livro() {}
	
	

	public Livro(Integer idLivro, Editora editora, Autor autor, Categoria categoria, String titulo, Integer edicao,
			Integer ano, Integer qtd, String sinopse, String tipo, String especial) {
		this.idLivro = idLivro;
		this.editora = editora;
		this.autor = autor;
		this.categoria = categoria;
		this.titulo = titulo;
		this.edicao = edicao;
		this.ano = ano;
		this.qtd = qtd;
		this.sinopse = sinopse;
		this.tipo = tipo;
		this.especial = especial;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", editora=" + editora + ", autor=" + autor + ", categoria=" + categoria
				+ ", titulo=" + titulo + ", edicao=" + edicao + ", ano=" + ano + ", qtd=" + qtd + ", sinopse=" + sinopse
				+ ", tipo=" + tipo + ", especial=" + especial + "]";
	}

}