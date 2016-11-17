package biblioteca.entities;

public class Usuario {
	
	private Integer idUsuario;
	private Integer ra;
	private String cpf;
	private String nome;
	private String tpUsuario;
	private String senha;
	private String email;
	private Integer qtdLivros;
	
	public Usuario() {}
	
	public Usuario(Integer idUsuario, Integer ra, String cpf, String nome, String tpUsuario, String senha, String email,
			Integer qtdLivros) {
		this.idUsuario = idUsuario;
		this.ra = ra;
		this.cpf = cpf;
		this.nome = nome;
		this.tpUsuario = tpUsuario;
		this.senha = senha;
		this.email = email;
		this.qtdLivros = qtdLivros;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getRa() {
		return ra;
	}
	public void setRa(Integer ra) {
		this.ra = ra;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTpUsuario() {
		return tpUsuario;
	}
	public void setTpUsuario(String tpUsuario) {
		this.tpUsuario = tpUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getQtdLivros() {
		return qtdLivros;
	}
	public void setQtdLivros(Integer qtdLivros) {
		this.qtdLivros = qtdLivros;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", ra=" + ra + ", cpf=" + cpf + ", nome=" + nome + ", tpUsuario="
				+ tpUsuario + ", senha=" + senha + ", email=" + email + ", qtdLivros=" + qtdLivros
				+ "]";
	}

}
