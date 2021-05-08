package trabalhobancodedados;

public class Lutador {
	private String cpf;
	private String nome;
	private String nacionalidade;
	private String arteMarcial;
	private String apelido;
	private String altura;
	private String idade;
	private String peso;
        
	public Lutador(String nome, String apelido, String idade,
			String nacionalidade, String altura, String peso, String arteMarcial) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.arteMarcial = arteMarcial;
		this.apelido = apelido;
		this.altura = altura;
		this.idade = idade;
		this.peso = peso;
	}
        
	public Lutador(String cpf, String nome, String apelido, String idade,
			String nacionalidade, String altura, String peso, String arteMarcial) {
		this.cpf = cpf;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.arteMarcial = arteMarcial;
		this.apelido = apelido;
		this.altura = altura;
		this.idade = idade;
		this.peso = peso;
	}

    Lutador(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getArteMarcial() {
		return arteMarcial;
	}

	public void setArteMarcial(String arteMarcial) {
		this.arteMarcial = arteMarcial;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getCpf() {
		return cpf;
	}
}

