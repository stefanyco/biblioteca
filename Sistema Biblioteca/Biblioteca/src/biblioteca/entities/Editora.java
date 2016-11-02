package biblioteca.entities;

public class Editora {
	
	private Integer idEditora;
	private String nome;
	
	public Editora() {}

	public Editora(Integer id_editora, String nome) {
		this.idEditora = id_editora;
		this.nome = nome;
	}
	
	public Integer getIdEditora() {
		return idEditora;
	}
	public void setIdEditora(Integer id_editora) {
		this.idEditora = id_editora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Editora [id_editora=" + idEditora + ", nome=" + nome + "]";
	}
}
