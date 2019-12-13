package model.Interface;

import java.util.List;
import model.bean.Endereco;
import model.bean.Pessoa;
import model.dao.EnderecoDAO;
import model.dao.PessoaDAO;

public class EnderecoXML {

    public void Xml_to_Banco(Endereco e) throws Exception {
        EnderecoDAO edao = new EnderecoDAO();
        System.out.print("\nEndereco");

        switch (e.getStatus()) {
            case "N":
                System.out.print(" - [nada a fazer]");

                break;
            case "E":
                System.out.println(" - [excluir]");
                edao.excluir(e);
                break;
            case "I":
                System.out.println(" - [inserir]");
                edao.inserir(e);
                break;
            case "A":
                System.out.println(" - [alterar]");
                edao.alterar(e);
                break;

        }

    }

    public List<Pessoa> Banco_to_Xml() throws Exception {
        PessoaDAO pdao = new PessoaDAO();
        return pdao.listar();
    }
}
