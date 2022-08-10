package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import myclasses.Cliente;

public class DaoCliente {

	private Connection connection; 

	 public DaoCliente() {
		connection = SingleConnection.getConnection();
		 
	}
	 
	public  void RecordCliente(Cliente cliente) throws Exception{
		if(!verify_user_by_cpf(cliente)) {//se o cpf nao exit ainda
		String splQuery = "INSERT INTO clientes (cpf, contato1, contato2, contato3, clientenome, endereco, ponto_de_referencia) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement prepStatment = connection.prepareStatement(splQuery);
		
		prepStatment.setString(1, cliente.getCpf());
		prepStatment.setString(2, cliente.getContato1());
		prepStatment.setString(3, cliente.getContato2());
		prepStatment.setString(4, cliente.getContato3());
		prepStatment.setString(5, cliente.getClientenome());
		prepStatment.setString(6, cliente.getEndereco());
		prepStatment.setString(7, cliente.getPonto_de_referencia());
		prepStatment.execute();
		
		connection.commit();
		}
		
	}
	
	public  void DeleteCliente(long id) throws Exception {
		String sqlQuery = "DELETE FROM clientes WHERE id = ?";
		PreparedStatement prepStatement = connection.prepareStatement(sqlQuery);
		prepStatement.setLong(1,id);
		prepStatement.execute();
		connection.commit();
	}
	
	public  List<Cliente> GetClienteById(long cliente_id) throws Exception{
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		String sqlQuery = "SELECT * FROM clientes WHERE id ="+ cliente_id;
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(resultset.getLong("id"));
			cliente.setCpf(resultset.getString("cpf"));
			cliente.setContato1(resultset.getString("contato1"));
			cliente.setContato2(resultset.getString("contato2"));
			cliente.setContato3(resultset.getString("contato3"));
			cliente.setClientenome(resultset.getString("clientenome"));
			cliente.setEndereco(resultset.getString("endereco"));
			cliente.setPonto_de_referencia(resultset.getString("ponto_de_referencia"));
			
			
			clientes.add(cliente);
		}
		return clientes;
	}
	
	public  List<Cliente> GetClienteByName(String name) throws Exception{
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		String sqlQuery = "SELECT * FROM clientes WHERE clientenome like '%?%'";
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, name);
		
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(resultset.getLong("id"));
			cliente.setCpf(resultset.getString("cpf"));
			cliente.setContato1(resultset.getString("contato1"));
			cliente.setContato2(resultset.getString("contato2"));
			cliente.setContato3(resultset.getString("contato3"));
			cliente.setClientenome(resultset.getString("clientenome"));
			cliente.setEndereco(resultset.getString("endereco"));
			cliente.setPonto_de_referencia(resultset.getString("ponto_de_referencia"));
			
			
			clientes.add(cliente);
		}
		return clientes;
	}
	
	public   boolean verify_user_by_cpf(Cliente cliente) throws Exception {
		String sqlQuery2 = "SELECT * FROM clientes WHERE cpf = ? ";
		PreparedStatement statment2 = connection.prepareStatement(sqlQuery2);
		statment2.setString(1, cliente.getCpf());
		ResultSet result2  = statment2.executeQuery();
		if(result2.next()) {
			System.out.println("Este cpf já está cadastrado .");
			result2.toString();
			return true;
		}
		return false;
	}
		
	public   Cliente UpdateCliente(Cliente cliente) throws Exception {
			
			if (!verify_user_by_cpf(cliente)) {/*Grava um novo*/
			
			String sql = "INSERT INTO cliente(cpf, contato1, contato2, contato3, clientenome, endereco, ponto_de_referencia)  VALUES (?,?,?,?,?,?,?)";
			PreparedStatement sqlCommand = connection.prepareStatement(sql);
			
			sqlCommand.setString(1, cliente.getCpf());
			sqlCommand.setString(2, cliente.getContato1());
			sqlCommand.setString(3, cliente.getContato2());
			sqlCommand.setString(4, cliente.getContato3());
			sqlCommand.setString(5, cliente.getClientenome());
			sqlCommand.setString(6, cliente.getEndereco());
			sqlCommand.setString(7, cliente.getPonto_de_referencia());
			
			sqlCommand.execute();
			
			connection.commit();
			
			}else {
				String sql = "UPDATE clientes SET cpf=?, contato1=?, contato2=?, contato3=?, clientenome=?, endereco=?, ponto_de_referencia=? WHERE cpf =  '"+cliente.getCpf()+"';";
				
				PreparedStatement sqlCommand = connection.prepareStatement(sql);
				
				sqlCommand.setString(1, cliente.getCpf());
				sqlCommand.setString(2, cliente.getContato1());
				sqlCommand.setString(3, cliente.getContato2());
				sqlCommand.setString(4, cliente.getContato3());
				sqlCommand.setString(5, cliente.getClientenome());
				sqlCommand.setString(6, cliente.getEndereco());
				sqlCommand.setString(7, cliente.getPonto_de_referencia());
				
				sqlCommand.executeUpdate();
				
				connection.commit();
				
			}
			
			return GetClienteByCpf(cliente.getCpf());
		}
	
	
public   Cliente GetClienteByCpf(String cpf) throws Exception  {
		
		Cliente cliente = new Cliente();
		
		String sql = "select * from clientes where cpf = '"+cpf+"'";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultset =  statement.executeQuery();
		
		while (resultset.next()) /*Se tem resultado*/ {
			
			
			cliente.setId(resultset.getLong("id"));
			cliente.setCpf(resultset.getString("cpf"));
			cliente.setContato1(resultset.getString("contato1"));
			cliente.setContato2(resultset.getString("contato2"));
			cliente.setContato3(resultset.getString("contato3"));
			cliente.setClientenome(resultset.getString("clientenome"));
			cliente.setEndereco(resultset.getString("endereco"));
			cliente.setPonto_de_referencia(resultset.getString("ponto_de_referencia"));
		}
		
		
		return cliente;
		
	}
	
}
