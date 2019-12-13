package model.Interface;

import model.bean.Pessoa;
import model.dao.PessoaDAO;


public class PessoaXML {

    public void Xml_to_Banco(Pessoa p) throws Exception {
        PessoaDAO pdao = new PessoaDAO();
        System.out.print("\nPessoa");
        switch (p.getStatus()) {
            case "N":
                System.out.print(" - [nada a fazer]");

                break;
            case "E":
                System.out.print(" - [excluir]");
                pdao.excluir(p);
                break;
            case "I":
                System.out.print(" - [inserir]");
                pdao.inserir(p);
                break;
            case "A":
                System.out.println(" - [alterar]");
                pdao.alterar(p);
                break;
        }
    }

    

}
