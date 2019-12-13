package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Aeronave;

public class AeronaveDAO {



    public void salvar(Aeronave a) throws Exception {

        if (a.getIdAeronave() == 0) {
            inserir(a);
        } else {
            alterar(a);
        }

    }

    public List<Aeronave> listar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM Aeronave LIMIT 5";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List listaAeronavs = new ArrayList<>();
            while (rs.next()) {
                Aeronave a = new Aeronave();
                
                a.setIdAeronave(rs.getInt("idAeronave"));
                a.setModelo(rs.getString("Modelo"));
                a.setAutonomia(rs.getTime("Autonomia").toString());
                a.setCapCombustivel(rs.getFloat("capCombustivel"));
                a.setVelocidade(rs.getFloat("Velocidade"));
                a.setNumChassi(rs.getString("NumChassi"));
                a.setTipo(rs.getString("Tipo"));
                        
                //Status leitura read
                a.setStatus("N");

                listaAeronavs.add(a);
            }


            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao buscar Aeronave");
            return listaAeronavs;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Aeronave" + ex);
        } finally {

            ConnectionFactory.closeConnection(con, ps);

        }
        return null;

    }

    public void inserir(Aeronave a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO Aeronave (Modelo, Autonomia, capCombustivel, Velocidade, NumChassi, Tipo) VALUES (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, a.getModelo());     
            ps.setString(2, a.getAutonomia());  
            ps.setFloat(3, a.getCapCombustivel()); 
            ps.setFloat(4, a.getVelocidade()); 
            ps.setString(5,a.getNumChassi());
            ps.setString(6, a.getTipo());       


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir Aeronave");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Aeronave" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void alterar(Aeronave a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE Aeronave SET Modelo=?, Autonomia=?, capCombustivel=?, Velocidade=?, NumChassi=?, Tipo=? WHERE idAeronave=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getModelo());     
            ps.setString(2, a.getAutonomia());  
            ps.setFloat(3, a.getCapCombustivel()); 
            ps.setFloat(4, a.getVelocidade()); 
            ps.setString(5,a.getNumChassi());
            ps.setString(6, a.getTipo()); 
            ps.setInt(7,a.getIdAeronave());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao alterar Aeronave");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar Aeronave" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void excluir(Aeronave a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "DELETE FROM Aeronave WHERE idAeronave=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getIdAeronave());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao excuir Aeronave");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Aeronave" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public Aeronave procurar(int IdAero) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM Aeronave where idAeronave=?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, IdAero);
            ResultSet rs = ps.executeQuery();

            Aeronave a = new Aeronave();
                a.setIdAeronave(rs.getInt("idAeronave"));
                a.setModelo(rs.getString("Modelo"));
                a.setAutonomia(rs.getTime("Autonomia").toString());
                a.setCapCombustivel(rs.getFloat("Capacidade"));
                a.setVelocidade(rs.getFloat("Velocidade"));
                a.setNumChassi(rs.getString("NumChassi"));
                a.setTipo(rs.getString("Tipo"));
            //Status leitura read
            a.setStatus("N");

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao buscar Aeronave");
            return a;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Aeronave" + ex);
        } finally {

            ConnectionFactory.closeConnection(con, ps);

        }
        return null;

    }
}
