package org.edelia.poc.ws.cxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcClientDAO implements ClientDAO {

	private DataSource datasource;

	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;
	}

	public JdbcClientDAO() {

	}

	@Override
	public Client rechercheClientParNom(String nom) {

		Client client = null;
		String sql = "SELECT * FROM CLIENT WHERE ID = ?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = datasource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, nom);
			rs = ps.executeQuery();
			if (rs.next()) {
				client = new Client(rs.getString("ID"), rs.getString("NOM"),
						rs.getString("PRENOM"), rs.getString("EMAIL"));
				client.setEtat(rs.getString("ETAT"));
			}
			return client;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(rs!=null)
				rs.close();
				if(ps!=null)
				ps.close();
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public void creationClient(Client client) {

		String sql = "INSERT INTO CLIENT "
				+ "(ID, NOM, PRENOM, EMAIL,ETAT) VALUES (?, ?, ?,?,'S')";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = datasource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, client.getId());
			ps.setString(2, client.getNom());
			ps.setString(3, client.getPrenom());
			ps.setString(4, client.getEmail());
			ps.executeUpdate();


		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			try {
              if(ps !=null)
				ps.close();
              if(conn!=null)
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public void miseAjourClient(Client client) {

		String sql = " UPDATE CLIENT "
				+ " SET  NOM=?, PRENOM=?, EMAIL=? , ETAT=? " + " WHERE ID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = datasource.getConnection();
			ps = conn.prepareStatement(sql);
			  if(client!=null ) {
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
			ps.setString(3, client.getEmail());
			ps.setString(4, client.getEtat());
			ps.setString(5, client.getId());
			ps.executeUpdate();
			  }

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
				     if(ps !=null)
					ps.close();
				     if(conn!=null)
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
