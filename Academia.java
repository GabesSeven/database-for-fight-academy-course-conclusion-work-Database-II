package trabalhobancodedados;

public class Academia {
	private String cnpj;
	private String endereco;
	private String nome;
        private String tecnico_string;
	private Tecnico tecnico;
	
        public Academia(String cnpj, String endereco, String nome, String tecnico) {
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.nome = nome;
		this.tecnico_string = tecnico;
	}

	public Academia(String cnpj, String endereco, String nome, Tecnico tecnico) {
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.nome = nome;
		this.tecnico = tecnico;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}
        
        public String getTecnico2() {
		return tecnico_string;
	}
        
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getCnpj() {
		return cnpj;
	}
}
