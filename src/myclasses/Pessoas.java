package myclasses;

public class Pessoas {
	String nome;
	String sobrenome;
	String email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Pessoas [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + "]";
	}
	
	

}
