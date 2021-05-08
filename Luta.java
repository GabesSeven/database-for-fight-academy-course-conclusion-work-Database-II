package trabalhobancodedados;

public class Luta {
	private final Lutador desafiante;
	private final Lutador desafiado;
	private final String data;
	
	public Luta(Lutador desafiante, Lutador desafiado, String data) {
		this.desafiante = desafiante;
		this.desafiado = desafiado;
		this.data = data;
	}

	public Lutador getDesafiante() {
		return desafiante;
	}

	public Lutador getDesafiado() {
		return desafiado;
	}

	public String getData() {
		return data;
	}
}
