package br.senac.rj.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.senac.rj.entity.Cliente;
import br.senac.rj.entity.Funcionario;
import br.senac.rj.entity.Usuario;

public class GenericDao<T> {

	Connection con = DaoFactory.getConnection();
	PreparedStatement stmt;
	ResultSet rs;
	
	public GenericDao() {
	}
	
	public String getClasse(Usuario u) {
		return u.getClass().getSimpleName().toLowerCase();
	}
	
	public void create(Usuario u) throws Exception {
		stmt = con.prepareStatement("insert into ? values (?,?,?,?,?)");
		stmt.setString(1, getClasse(u));
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public static void main(String[] args) {
		try {
			new GenericDao<Object>().create(new Cliente());
			new GenericDao<Object>().create(new Funcionario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
