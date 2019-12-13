package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Endereco;

public class EnderecoDAO {

    public Endereco existente(Endereco e) {

        for (Endereco end : this.listar()) {
            if (end.equals(e)) {
                JOptionPane.showMessageDialog(null, "Endereco Existente");
                return end;
            }
        }
        return null;

    }

    public void salvar(Endereco e) throws Exception {

        if (e.getIdEndereco() == 0) {
            inserir(e);
        } else {
            alterar(e);
        }

    }

    public List<Endereco> listar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM Endereco LIMIT 5";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List listaEnderecs = new ArrayList<>();
            while (rs.next()) {
                Endereco e = new Endereco();
                e.setIdEndereco(rs.getInt("idEndereco"));
                e.setLogradouro(rs.getString("Logradouro"));
                e.setCep(rs.getInt("Cep"));
                e.setNumero(rs.getInt("Numero"));
                e.setCidade(rs.getString("Cidade"));
                e.setUF(rs.getString("UF"));
                //Status leitura read
                e.setStatus("N");

                listaEnderecs.add(e);
            }

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao buscar");
            return listaEnderecs;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar" + ex);
        } finally {

            ConnectionFactory.closeConnection(con, ps);

        }
        return null;

    }

    public void inserir(Endereco e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO endereco (Logradouro,Cep,Numero,Cidade,UF) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getLogradouro());
            ps.setInt(2, e.getCep());
            ps.setInt(3, e.getNumero());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getUF());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir endereco");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir edereco" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void alterar(Endereco e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE Endereco SET Logradouro=?, Cep=?, Numero=?, Cidade=?, UF=? WHERE idEndereco=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getLogradouro());
            ps.setInt(2, e.getCep());
            ps.setInt(3, e.getNumero());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getUF());
            ps.setInt(6, e.getIdEndereco());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao alterar endereco");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar endereco" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void excluir(Endereco e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "DELETE FROM Endereco WHERE idEndereco=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, e.getIdEndereco());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao excuir endereco");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir endereco" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public Endereco procurar(int IdEnd) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM Endereco where idEndereco=?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, IdEnd);
            ResultSet rs = ps.executeQuery();

            Endereco e = new Endereco();
            e.setIdEndereco(rs.getInt("idEndereco"));
            e.setLogradouro(rs.getString("Logradouro"));
            e.setCep(rs.getInt("Cep"));
            e.setNumero(rs.getInt("Numero"));
            e.setCidade(rs.getString("Cidade"));
            e.setUF(rs.getString("UF"));
            //Status leitura read
            e.setStatus("N");

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao buscar");
            return e;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar" + ex);
        } finally {

            ConnectionFactory.closeConnection(con, ps);

        }
        return null;

    }
}
