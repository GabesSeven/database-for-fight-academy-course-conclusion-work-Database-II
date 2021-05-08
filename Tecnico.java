package trabalhobancodedados;

public class Tecnico {
	String cpf;
	String nome;
	String nacionalidade;
	String arteMarcial;
	String cpfLutador;
        
	public Tecnico(String cpf, String nome, String nacionalidade, String arteMarcial, String cpfLutador) {
		this.cpf = cpf;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.arteMarcial = arteMarcial;
                this.cpfLutador = cpfLutador;
	}
        
        public Tecnico(String nome, String nacionalidade, String arteMarcial) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.arteMarcial = arteMarcial;
	}
        
        public String getCpfLutador(){
            return cpfLutador;
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

	public String getCpf() {
		return cpf;
	}
}

