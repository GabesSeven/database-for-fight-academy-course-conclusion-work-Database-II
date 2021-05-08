package trabalhobancodedados;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Database implements Closeable, AutoCloseable {
	private Connection conexao;

	public Database(String user, String senha) throws SQLException {
		String url = "jdbc:oracle:thin:@200.145.158.211:1521:xe";

		this.conexao = DriverManager.getConnection(url, user, senha);
                this.criaTabelas();
	}

	private void criaTabelas() throws SQLException {
		String sql = "create type Endereco_TY force as object ("
				+ "rua varchar2(20),"
				+ "numero varchar2(5),"
				+ "cidade varchar2(20),"
				+ "bairro varchar2(20),"
				+ "cep varchar2(8),"
				+ "estado varchar2(2)"
                                + ")";
                
		this.criaTabela(sql);

		sql = "create type Pessoa_TY force as object ("
				+ "cpf varchar2(11),"
				+ "nome varchar2(20),"
				+ "nacionalidade varchar2(20),"
				+ "arteMarcial varchar2(20)"
				+ ") not final";
                
                this.criaTabela(sql);                
		sql = "create table Pessoa_TB of Pessoa_TY (primary key (cpf))";
                this.criaTabela(sql);
                
                
                sql = "create type Lutador_TY under Pessoa_TY ("
				+ "peso varchar2(30),"
				+ "idade varchar2(20),"
				+ "apelido varchar(20),"
				+ "altura varchar(20)"
				+ ")";
                this.criaTabela(sql);
                sql = "create table Lutador_TB of Lutador_TY (primary key (cpf))";
                this.criaTabela(sql);
                
                
                sql = "create type Tecnico_TY under Pessoa_TY("
				+ "lutador Lutador_TY"
				+ ")";
                this.criaTabela(sql);
                sql = "create table Tecnico_TB of Tecnico_TY (primary key (cpf))";
                this.criaTabela(sql);
                
                
		sql = "create type Academia_TY force as object ("
				+ "cnpj varchar2(11),"
				+ "nome varchar2(20),"
			    //	+ "endereco Endereco_TY,"
			    //	+ "tecnico Tecnico_TY"
                            	+ "endereco varchar2(20),"
                                + "tecnico varchar2(20)"
			    	+ ")";
                this.criaTabela(sql);
                sql = "create table Academia_TB of Academia_TY (primary key (cnpj))";
                this.criaTabela(sql);

		
                sql = "create type Luta_TY force as object("
				//+ "desafiante Lutador_TY,"
				//+ "desafiado Lutador_TY,"
				+ "desafiante varchar2(20),"
				+ "desafiado varchar2(20),"
                                + "data_ varchar2(11)"
				+ ")";
                this.criaTabela(sql);
                sql = "create table Luta_TB of Luta_TY (primary key (desafiante, desafiado, data_))";
                this.criaTabela(sql);
                
        }
	
	private void criaTabela(String sql) throws SQLException {
		try(Statement stmt = conexao.createStatement()) {
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			if(e.getErrorCode() == 955) {
				//Tabela já existe, o erro pode ser ignorado
				return;
			} else {
				throw e;
			}
		}
	}
	
	public void insereLutador(Lutador lutador) throws SQLException {
                if(getLutador(lutador.getCpf()) != null) {
			throw new IllegalArgumentException("Já existe um lutador com o mesmo CPF, não é possível inserir");
		}
		
		if(!existePessoa(lutador.getCpf())) {
			inserePessoa(lutador.getCpf(), lutador.getNome(), lutador.getNacionalidade(), lutador.getArteMarcial());
		} else {
			atualizaPessoa(lutador.getCpf(), lutador.getNome(), lutador.getNacionalidade(), lutador.getArteMarcial());
		}
		try(PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Lutador_TB VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
			stmt.setString(1, lutador.getCpf());
                        stmt.setString(2, lutador.getNome());
                        stmt.setString(3, lutador.getNacionalidade());
                        stmt.setString(4, lutador.getArteMarcial());
                        stmt.setString(5, lutador.getPeso());
			stmt.setString(6, lutador.getIdade());
			stmt.setString(7, lutador.getApelido());
			stmt.setString(8, lutador.getAltura());
			
			stmt.executeUpdate();
		}
	}
	
	/**
	 * Atualiza os registros de um lutador (identificado por um CPF).
	 * @param lutador Lutador com os dados que serão atualizados
	 * @return 1 se um registro foi atualizado, 0 caso contrário
	 * @throws SQLException
	 */
	public int atualizaLutador(Lutador lutador) throws SQLException {
		atualizaPessoa(lutador.getCpf(), lutador.getNome(), lutador.getNacionalidade(), lutador.getArteMarcial());
		
		String sql = "UPDATE Lutador_TB SET apelido=?, altura=?, idade=?, peso=? WHERE cpf=?";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, lutador.getApelido());
			stmt.setString(2, lutador.getAltura());
			stmt.setString(3, lutador.getIdade());
			stmt.setString(4, lutador.getPeso());
			stmt.setString(5, lutador.getCpf());
			
			return stmt.executeUpdate();
		}
	}
	
	/**
	 * Retorna o registro de um lutador a partir de um CPF
	 * @param cpf CPF do lutador
	 * @return Registro completo do lutador
	 * @throws SQLException
	 */
	public Lutador getLutador(String cpf) throws SQLException {
		String query = "SELECT Pessoa_TB.nome, Pessoa_TB.nacionalidade, Pessoa_TB.arteMarcial, Lutador_TB.apelido, Lutador_TB.altura, Lutador_TB.idade, Lutador_TB.peso "
				+ "FROM Pessoa_TB INNER JOIN Lutador_TB USING (cpf) "
				+ "WHERE (cpf = ?)";

		try(PreparedStatement stmt = conexao.prepareStatement(query)) {
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			if(!resultado.next()) {
				return null;
			}
			
			String nome = resultado.getString(1);
			String nacionalidade = resultado.getString(2);
			String arteMarcial = resultado.getString(3);
			String apelido = resultado.getString(4);
			String altura = resultado.getString(5);
			String idade = resultado.getString(6);
			String peso = resultado.getString(7);
			
			return new Lutador(cpf, nome, nacionalidade, arteMarcial, apelido, altura, idade, peso);
		}
	}
	
	/**
	 * Remove um lutador do banco de dados (identificado pelo CPF)
	 * @param lutador
	 * @return 1 se um registro foi removido, 0 caso contrário
	 * @throws SQLException
	 */
	public int deletaLutador(Lutador lutador) throws SQLException {
		String sql = "DELETE FROM Lutador_TB WHERE cpf=?"; 
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, lutador.getCpf());
			
			return stmt.executeUpdate();
		}
	}
	
	/**
	 * Insere o registro de um técnico no banco de dados
	 * @param tecnico Técnico que será inserido
	 * @throws SQLException
	 */
	public void insereTecnico(Tecnico tecnico) throws SQLException {
		Lutador lutador = getLutador(tecnico.getCpfLutador());
                
                if(getTecnico(tecnico.getCpf()) != null) {
			//throw new IllegalArgumentException("Já existe um tecnico com o mesmo CPF, não é possível inserir");   
                }
                
                if(!existeLutador(tecnico.getCpfLutador())) {
                    JOptionPane.showMessageDialog(null, "Erro!", "Lutador nao existe", JOptionPane.ERROR_MESSAGE);
                    //System.out.print("lutador nao existe");
                    return;
                }
		
		if(!existePessoa(tecnico.getCpf())) {
			inserePessoa(tecnico.getCpf(), tecnico.getNome(), tecnico.getNacionalidade(), tecnico.getArteMarcial());
		} else {
			atualizaPessoa(tecnico.getCpf(), tecnico.getNome(), tecnico.getNacionalidade(), tecnico.getArteMarcial());
		}
		
		try(PreparedStatement stmt = conexao.prepareStatement("INSERT INTO Tecnico_TB VALUES (?, ?, ?, ?, Lutador_TY(?, ?, ?, ?, ?, ?, ?, ?))")) {
			stmt.setString(1, tecnico.getCpf());
                        stmt.setString(2, tecnico.getNome());
                        stmt.setString(3, tecnico.getNacionalidade());
                        stmt.setString(4, tecnico.getArteMarcial());
                        stmt.setString(5, tecnico.getCpfLutador());
                        stmt.setString(6, lutador.getNome());
                        stmt.setString(7, lutador.getNacionalidade());
                        stmt.setString(8, lutador.getArteMarcial());
                        stmt.setString(9, lutador.getPeso());
                        stmt.setString(10, lutador.getIdade());
                        stmt.setString(11, lutador.getApelido());
                        stmt.setString(12, lutador.getAltura());
                        
			stmt.executeUpdate();
		}
	}
	
	/**
	 * Atualiza o registro de um técnico (identificado pelo CPF)
	 * @param tecnico Técnico com os dados que serão atualizados 
	 * @return 1 se um registro foi atualizado, 0 caso contrário
	 * @throws SQLException
	 */
        
        //construir cerificação...
	public int atualizaTecnico(Tecnico tecnico) throws SQLException {
		return atualizaPessoa(tecnico.getCpf(), tecnico.getNome(), tecnico.getNacionalidade(), tecnico.getArteMarcial());
	}
	
	/**
	 * Retorna o técnico identificado pelo CPF informado 
	 * @param cpf CPF do técnico
	 * @return Técnico com o CPF correspondente, ou null caso não exista um registo de técnico com o CPF informado
	 * @throws SQLException
	 */
	public Tecnico getTecnico(String cpf) throws SQLException {
		String query = "SELECT Pessoa_TB.nome, Pessoa_TB.nacionalidade, Pessoa_TB.arteMarcial "
				+ "FROM Pessoa_TB INNER JOIN Tecnico_TB USING (cpf) "
				+ "WHERE (cpf = ?)";

		try(PreparedStatement stmt = conexao.prepareStatement(query)) {
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			if(!resultado.next()) {
				return null;
			}
			
			String nome = resultado.getString(1);
			String nacionalidade = resultado.getString(2);
			String arteMarcial = resultado.getString(3);
			String cpfLutador = resultado.getString(4);
                        
                        return new Tecnico(cpf, nome, nacionalidade, arteMarcial, cpfLutador);
		}
	}
	
        	/**
	 * Deleta um registro de técnico
	 * @param tecnico Técnico que será deletado
	 * @return número de registros deletados
	 * @throws SQLException
	 */
	public int deletaTecnico(Tecnico tecnico) throws SQLException {
		String sql = "DELETE FROM Tecnico_TB WHERE CPF=?"; 
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, tecnico.getCpf());
			
			return stmt.executeUpdate();
		}
	}
        

	/**
	 * Insere um registro de academia no banco de dados
	 * @param academia
	 * @throws SQLException
	 */
	public void insereAcademia(Academia academia) throws SQLException {
		if(getAcademia(academia.getCnpj()) != null) {
			throw new IllegalArgumentException("Já existe uma academia com o mesmo CNPJ, não é possível inserir");
		}

		if(getTecnico(academia.getTecnico().getCpf()) == null) {
			insereTecnico(academia.getTecnico());
		}
		
		String sql = "INSERT INTO Academia_TB VALUES (?, ?, ?, ?)";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, academia.getCnpj());
			stmt.setString(2, academia.getNome());
			stmt.setString(3, academia.getTecnico().getCpf());
			stmt.setString(4, academia.getEndereco());
			
			stmt.executeUpdate();
		}
	}
	
	/**
	 * Retorna um registro da academia que possui o CNPJ informado, ou null caso não exista um registro de academia com o CNPJ
	 * @param cnpj
	 * @return
	 * @throws SQLException
	 */
	public Academia getAcademia(String cnpj) throws SQLException {
		String sql = "SELECT  nome, tecnico, endereco FROM Academia_TB WHERE cnpj=?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, cnpj);
			
			ResultSet resultado = stmt.executeQuery();
			
			if(!resultado.next()) {
				return null;
			}
			
			String nome = resultado.getString(1);
			//Tecnico tecnico = getTecnico(resultado.getString(2));
			String tecnico = resultado.getString(2);
                        String endereco = resultado.getString(3);

			return new Academia(cnpj, endereco, nome, tecnico);
		}
	}
	
	/**
	 * Remove um registro de academia
	 * @param academia
	 * @return 1 se um registro foi removido, 0 caso contrário
	 * @throws SQLException
	 */
	public int deletaAcademia(Academia academia) throws SQLException {
		String sql = "DELETE FROM Academia_TB WHERE cnpj=?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, academia.getCnpj());
			
			return stmt.executeUpdate();
		}
	}
	
	/**
	 * Atualiza o registro de uma academia (identificada pelo CNPJ)
	 * @param academia
	 * @return Numero de registros atualizados
	 * @throws SQLException
	 */
	public int atualizaAcademia(Academia academia) throws SQLException {
		//if(getTecnico(academia.getTecnico()) == null) {
		//	insereTecnico(academia.getTecnico());
		//}
		
		String sql = "UPDATE Academia_TB SET nome=?, tecnico=?, endereco=? WHERE cnpj=?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, academia.getNome());
			stmt.setString(2, academia.getTecnico2());
			stmt.setString(3, academia.getEndereco());
			stmt.setString(4, academia.getCnpj());
			
			return stmt.executeUpdate();
		}
	}
	
	/**
	 * Insere um registro de luta no banco de dados
	 * @param luta registro de luta que será inserido
	 * @throws SQLException
	 */
	public void insereLuta(Luta luta) throws SQLException {
		if(getLuta(luta.getDesafiante(), luta.getDesafiado(), luta.getData()) == null) {
			throw new IllegalArgumentException("Já existe uma luta entre o desafiante e o desafiado na data especificada, não é possível inserir uma nova");
		}
		
		String sql = "INSERT INTO Luta_TB VALUES (?, ?, ?)";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, luta.getDesafiante().getCpf());
			stmt.setString(2, luta.getDesafiado().getCpf());
			stmt.setString(3, luta.getData());
			
			stmt.executeUpdate();
		}
	}
	
	/**
	 * Retorna uma luta que ocorreu entre dois lutadores específicos em uma data específica, com o vencedor preenchido
	 * @param desafiante Lutador desafiante
	 * @param desafiado Lutador desafiado
	 * @param data Data da luta
	 * @return Dados completos da luta
	 * @throws SQLException
	 */
	public Luta getLuta(Lutador desafiante, Lutador desafiado, String data) throws SQLException {
		String sql = "SELECT * FROM Luta_TB WHERE desafiante=? AND desafiado=? AND data_=?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, desafiante.getCpf());
			stmt.setString(2, desafiado.getCpf());
			stmt.setString(3, data);
			
                        
			ResultSet resultado = stmt.executeQuery();
			
			if(!resultado.next()) {
				return null;
			}
			
			return new Luta(desafiante, desafiado, data);
		}
	}
	
	//private LocalDate getDataFromString(String s) {
	//	int dia = Integer.parseInt(s.substring(0, 2));
	//	int mes = Integer.parseInt(s.substring(3, 5));
	//	int ano = Integer.parseInt(s.substring(6, 10));
			
	//	return LocalDate.of(ano, mes, dia);
	//}
	
	//private String getStringFromData(LocalDate data) {
	//	return String.format("%02d", data.getDayOfMonth()) + "/" + String.format("%02d", data.getMonthValue()) + "/" + data.getYear();
	//}
	
	/**
	 * Apaga o registro de uma luta
	 * @param luta Luta que será deletada
	 * @throws SQLException
	 */
	public void deletaLuta(Luta luta) throws SQLException {
		String sql = "DELETE FROM Luta_TB WHERE desafiante=? AND desafiado=? AND data_=?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, luta.getDesafiante().getCpf());
			stmt.setString(2, luta.getDesafiado().getCpf());
			stmt.setString(3, luta.getData());
			
			stmt.executeUpdate();
		}
	}
	
	/**
	 * Retorna uma lista com todos os lutadores registrados
	 * @return Lista de lutadores
	 * @throws SQLException
	 */
	public List<Lutador> getTodosLutadores() throws SQLException {
		String query = "SELECT Pessoa_TB.nome, Pessoa_TB.nacionalidade, Pessoa_TB.arteMarcial, Lutador_TB.apelido, Lutador_TB.altura, Lutador_TB.idade, Lutador_TB.peso "
				+ "FROM Pessoa_TB INNER JOIN Lutador_TB USING (cpf)";
		
		List<Lutador> lista = new ArrayList<>();

		try(PreparedStatement stmt = conexao.prepareStatement(query)) {
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				String nome = resultado.getString(1);
				String nacionalidade = resultado.getString(2);
				String arteMarcial = resultado.getString(3);
				String apelido = resultado.getString(4);
				String altura = resultado.getString(5);
				String idade = resultado.getString(6);
				String peso = resultado.getString(7);
				//String cpf = resultado.getString(8);
                                
                                //lista.add(new Lutador(cpf, nome, nacionalidade, arteMarcial, apelido, altura, idade, peso));
				lista.add(new Lutador(nome, nacionalidade, arteMarcial, apelido, altura, idade, peso));
			}
			
			return lista;
		}
	}
	
	/**
	 * Retorna uma lista com todos os técnicos registrados
	 * @return Lista de técnicos
	 * @throws SQLException
	 */
	public List<Tecnico> getTodosTecnicos() throws SQLException {
		String query = "SELECT Pessoa_TB.nome, Pessoa_TB.nacionalidade, Pessoa_TB.arteMarcial "
				+ "FROM Pessoa_TB INNER JOIN Tecnico_TB USING (cpf) ";
		
		List<Tecnico> lista = new ArrayList<>();

		try(PreparedStatement stmt = conexao.prepareStatement(query)) {
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
                                String nome = resultado.getString(1);
				String nacionalidade = resultado.getString(2);
				String arteMarcial = resultado.getString(3);
                                //String cpf = resultado.getString(4);
				
                                //lista.add(new Tecnico(cpf, nome, nacionalidade, arteMarcial));
				lista.add(new Tecnico(nome, nacionalidade, arteMarcial));
			}
			
			return lista;
		}
	}
	
	/**
	 * Retorna uma lista com todas as academias registradas
	 * @return Lista de academias
	 * @throws SQLException
	 */
	public List<Academia> getTodasAcademias() throws SQLException {
		String sql = "SELECT nome, tecnico, cnpj, endereco FROM Academia_TB";

		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			
			List<Academia> lista = new ArrayList<>();

			while(resultado.next()) {
				String nome = resultado.getString(1);
				//Tecnico tecnico = getTecnico(resultado.getString(2));
                                String tecnico = resultado.getString(2);
				String cnpj = resultado.getString(3);
				String endereco = resultado.getString(4);

				lista.add(new Academia(cnpj, endereco, nome, tecnico));
			}
			
			return lista;
		}
	}
	
	/**
	 * Retorna uma lista com todas as lutas registradas
	 * @return Lista de lutas
	 * @throws SQLException
	 */
	public List<Luta> getTodasLutas() throws SQLException {
		String sql = "SELECT desafiante, desafiado, data_ FROM Luta_TB";
		
		List<Luta> lista = new ArrayList<>();

		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				Lutador desafiante = getLutador(resultado.getString(1));
				Lutador desafiado = getLutador(resultado.getString(2));
				String data = resultado.getString(3);
				//LocalDate data = resultado.getObject(3, LocalDate.class);
                                
                                lista.add(new Luta(desafiante, desafiado, data));
				//lista.add(new Luta(desafiante, desafiado, getStringFromData(data)));
			}
			
			return lista;
		}
	}
		
	private boolean existePessoa(String cpf) throws SQLException {
		try(PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM Pessoa_TB WHERE cpf=?")) {
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			if(resultado.next()) {
				return true;
			} else {
				return false;
			}
		}
	}
        
        private boolean existeLutador(String cpf) throws SQLException {
		try(PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM Lutador_TB WHERE cpf=?")) {
			stmt.setString(1, cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			if(resultado.next()) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private void inserePessoa(String cpf, String nome, String nacionalidade, String arteMarcial) throws SQLException {
		try(PreparedStatement stmt = conexao.prepareStatement("insert into Pessoa_TB values(?, ?, ?, ?)")) {
			stmt.setString(1, cpf);
			stmt.setString(2, nome);
			stmt.setString(3, nacionalidade);
			stmt.setString(4, arteMarcial);
			
			stmt.executeUpdate();
		}
	}
	
	private int atualizaPessoa(String cpf, String nome, String nacionalidade, String arteMarcial) throws SQLException {
		String sql = "UPDATE Pessoa_TB SET nome=?, nacionalidade=?, arteMarcial=? WHERE cpf=?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, nome);
			stmt.setString(2, nacionalidade);
			stmt.setString(3, arteMarcial);
			stmt.setString(4, cpf);
			
			return stmt.executeUpdate();
		}
	}
	
	@Override
	public void close() {
		try {
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
