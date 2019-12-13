package Principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.Interface.Exportarr;
import model.Interface.PessoaXML;
import model.Interface.ImportarXML;
import model.bean.Aeronave;
import model.bean.Endereco;
import model.bean.Pessoa;
import model.dao.AeronaveDAO;
import model.dao.EnderecoDAO;
import model.dao.PessoaDAO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws Exception {

        //----------Exportando Banco para XML----------
//        Exportarr exp = new Exportarr();
//        if (exp.Banco_to_Xml() == 1) {
//            System.out.println("Exportado com sucesso!");
//        } else {
//            System.err.println("Não foi possivel esportar");
//        }

        //----------Importando XML para Banco----------
        ImportarXML imp = new ImportarXML();
        if (imp.all() == 1) {
            System.out.println("\nImportado com sucesso!");   
        } else {
            System.err.println("Não foi possivel importar");
        }

        //----------Testando Pessoa--------------------
        //PessoaEnderecoDAO pEDAO = new PessoaEnderecoDAO();
        //Endereco e = new Endereco(0, "Rua Barros", 29500000, 63, "Alegre", "ES");
        //EnderecoDAO eDAO = new EnderecoDAO();
        //----------Testando Aeronave------------------
        //Aeronave a= new Aeronave("Airbus A320", "8:00:00", 320, 750, "5J6RM4H3XC", "Jato");
        //AeronaveDAO aDAO= new AeronaveDAO();
        //aDAO.salvar(a);
    }
}
