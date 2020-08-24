package com.laboratorio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.laboratorio.bean.Exame;



public class ExameDAO {

	// Metodo para criar conexao com o db
		public static Connection getConnection() throws Exception {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String  BD_URL = "jdbc:mysql://127.0.0.1:3306/LABORATORIO?useTimezone=true&serverTimezone=UTC";
				return DriverManager.getConnection(BD_URL, "Tester", "a1b2c3d4");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		public int incluirExame(Exame exame) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO EXAMES VALUES (?,?,?,?,?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, exame.getPedido());
				ps.setString(2, exame.getPacienteMatr());
				ps.setString(3, exame.getSolicitanteCRM());
				ps.setString(4, exame.getConvenio());
				ps.setString(5, exame.getLaudo());
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return i;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
		
		public List<Exame> listarExames() throws SQLException, Exception {
			List<Exame> lista = new ArrayList<>();
			ResultSet rs = null;
			try {
				String sql = "SELECT PEDIDO,PACMATR,SOLCRM,CONVENIO,LAUDO FROM EXAMES";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					lista.add(new Exame(rs.getInt("PEDIDO"),
					rs.getString("PACMATR"),
					rs.getString("SOLCRM"),
					rs.getString("CONVENIO"),
					rs.getString("LAUDO")));
				}
				return lista;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
		
		public Exame consultarExame(int pedido) throws SQLException, Exception {
			Exame exame= new Exame();
			String sql = "SELECT PEDIDO,PACMATR,SOLCRM,CONVENIO,LAUDO FROM EXAMES WHERE PEDIDO = ? ";
			ResultSet rs = null;
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setLong(1, pedido);
				rs = ps.executeQuery();
				if(rs.next()){
					exame.setPedido(rs.getInt("PEDIDO"));
					exame.setPacienteMatr(rs.getString("PACMATR"));
					exame.setSolicitanteCRM(rs.getString("SOLCRM"));
					exame.setConvenio(rs.getString("CONVENIO"));
					exame.setLaudo(rs.getString("LAUDO"));
				}
				return exame;
			} catch (SQLException e) {
				Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, e);
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
			return null;
		}
	
		public int atualizarExame(Exame exame)
				throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE EXAMES SET PACMATR=?,SOLCRM=?,CONVENIO=?,LAUDO=? WHERE PEDIDO=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, exame.getPacienteMatr());
				ps.setString(2, exame.getSolicitanteCRM());
				ps.setString(3, exame.getConvenio());
				ps.setString(4, exame.getLaudo());
				ps.setInt(5, exame.getPedido());
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
		
		public int excluirExame(int pedido) throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM EXAMES WHERE PEDIDO=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, pedido);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
}
