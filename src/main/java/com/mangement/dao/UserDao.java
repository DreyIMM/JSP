package com.mangement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mangement.bean.User;

public class UserDao {
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/users?useSSL=false", "root", "aa34244942");
	}
	
	
	
	private User getEntidade(ResultSet r) throws SQLException {
		User u = new User();
		u.id = r.getInt("id");
		u.nome = r.getString("nome");
		u.idade = r.getInt("idade");
		u.matricula = r.getString("matricula");
		return u;
	}
	
	public User obter(Integer id) {
		Connection c = null;
		User u = null;
		try {
			c = getConnection();
			PreparedStatement pst = c.prepareStatement(
					"SELECT * FROM users WHERE ID = ?");
			pst.setInt(1, id);
			ResultSet r = pst.executeQuery();
			if (r.next())
				u = getEntidade(r);
			r.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (c != null)
				try { c.close();} catch (Exception e) {}
		}
		return u;		
	}
	
	
	public List<User> obterTodos() {
		Connection c = null;
		List<User> lista = new ArrayList<>();
		try {
			c = getConnection();
			Statement st = c.createStatement();
			ResultSet r = st.executeQuery("SELECT * FROM users");
			while (r.next())
				lista.add(getEntidade(r));
			r.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (c != null)
				try { c.close();} catch (Exception e) {}
		}
		return lista;
	}
	
	public void create(User u) {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pst = c.prepareStatement(
					"INSERT INTO users VALUES (?,?,?,?)");
			pst.setInt(1, u.id);
			pst.setString(2, u.nome);
			pst.setInt(3, u.idade);
			pst.setString(4, u.matricula);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (c != null)
				try { c.close();} catch (Exception e) {}
		}
	}
	
	public void update(User p) {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pst = c.prepareStatement(
					"UPDATE users SET NOME = ?, "+
			        "idade = ?, "+ "matricula = ? WHERE id = ?");
			pst.setString(1, p.nome);
			pst.setInt(2, p.idade);
			pst.setString(3, p.matricula);
			pst.setInt(4, p.id);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (c != null)
				try { c.close();} catch (Exception e) {}
		}
	}
	
	public void remove(Integer id) {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pst = c.prepareStatement(
					"DELETE FROM users WHERE ID = ?");
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (c != null)
				try { c.close();} catch (Exception e) {}
		}		
	}
	

	
}
