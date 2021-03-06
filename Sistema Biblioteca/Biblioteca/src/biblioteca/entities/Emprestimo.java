package biblioteca.entities;

import java.sql.Date;

public class Emprestimo {

	private Integer idEmprestimo;
	private Usuario usuario;
	private Livro livro;
	private Date dataEmprestimo;
	private Date dataDevolucao;

	public Emprestimo() {}
	
	public Emprestimo(Integer idEmprestimo, Usuario usuario, Livro livro, Date dataEmprestimo, Date dataDevolucao) {
		this.idEmprestimo = idEmprestimo;
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}


	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public Date getDataDevolucao() {
		return dataDevolucao;
	}


	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	@Override
	public String toString() {
		return "Emprestimo [idEmprestimo=" + idEmprestimo + ", usuario=" + usuario + ", livro=" + livro
				+ ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + "]";
	}

}
