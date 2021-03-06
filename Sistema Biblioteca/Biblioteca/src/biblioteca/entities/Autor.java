package biblioteca.entities;

public class Autor {
	
	private Integer idAutor;
	private String nome;
	private String sobrenome;
	
	public Autor() {}

	public Autor(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Autor(Integer idAutor, String nome, String sobrenome) {
		this.idAutor = idAutor;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}
	

}
