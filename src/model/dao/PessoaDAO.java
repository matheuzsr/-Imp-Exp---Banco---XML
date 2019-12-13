package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

public class PessoaDAO {

    public void salvar(Pessoa p) throws Exception {
        if (p.getIdPessoa() == 0) {
            inserir(p);
        } else {
            alterar(p);
        }
    }

    public List<Pessoa> listar() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "SELECT * FROM Pessoa";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List listaPessoas = new ArrayList<>();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setRg(rs.getInt("Rg"));
                p.setCpf(rs.getString("Cpf"));
                p.setIdEndereco(rs.getInt("idEndereco"));
                
                //Status leitura read
                p.setStatus("N");
                
                listaPessoas.add(p);
            }

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao listar");
            return listaPessoas;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
        return null;
    }
    

    public void inserir(Pessoa p) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            
            String sql = "INSERT INTO Pessoa (Nome,Rg,Cpf,IdEndereco) VALUES (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getRg());
            ps.setString(3, p.getCpf());
            ps.setInt(4, p.getIdEndereco());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir pessoa");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir pessoa" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void alterar(Pessoa p) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE Pessoa SET Nome=?, Rg=?, Cpf=?, IdEndereco=? WHERE idPessoa=?";
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getRg());
            ps.setString(3, p.getCpf());
            ps.setInt(4, p.getIdEndereco());
            ps.setInt(5, p.getIdPessoa());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao alterar pessoa");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar pessoa" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }

    public void excluir(Pessoa p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "DELETE FROM Pessoa WHERE idPessoa=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getIdPessoa());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Sucesso excluir pessoa");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro excluir pessoa" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, ps);
        }
    }
    

}
