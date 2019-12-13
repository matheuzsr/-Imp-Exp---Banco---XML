package model.Interface;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.bean.Aeronave;
import model.bean.Endereco;
import model.bean.Pessoa;
import model.dao.AeronaveDAO;
import model.dao.EnderecoDAO;
import model.dao.PessoaDAO;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class Exportarr {

    public int Banco_to_Xml() throws Exception {
        try {
            EnderecoDAO eDAO = new EnderecoDAO();
            AeronaveDAO aDAO = new AeronaveDAO();
            PessoaDAO pDAO = new PessoaDAO();

            //************************************************************
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            org.w3c.dom.Document documentoXML = documentBuilder.newDocument();

            Element root = documentoXML.createElement("AirTaxi");
            documentoXML.appendChild(root);

            for (Pessoa p : pDAO.listar()) {
                //=============================== PESSOA ==================================================
                Element pessoa = documentoXML.createElement("Pessoa");

                //========= criando atributo ID ====================================
                Attr id = documentoXML.createAttribute("idPessoa");
                id.setValue(Integer.toString(p.getIdPessoa()));
                //fazendo a pessoa ficar com esse id
                pessoa.setAttributeNodeNS(id);
                //adicionar essa pessoa no nó principal
                root.appendChild(pessoa);
                //==================================================================

                //========== criando o atributo STATUS =============================
                Element status = documentoXML.createElement("status");
                status.appendChild(documentoXML.createTextNode(p.getStatus()));
                pessoa.appendChild(status);
                //==================================================================

                //========== criando o atributo NOME ===============================
                Element nome = documentoXML.createElement("nome");
                //nessa linha no xml seria exemplo: <nome> Isabela </nome>
                nome.appendChild(documentoXML.createTextNode(p.getNome()));
                //adicionando nome ao elemento pessoa
                pessoa.appendChild(nome);
                //==================================================================

                //========== criando atributo RG ===================================
                Element Rg = documentoXML.createElement("Rg");
                Rg.appendChild(documentoXML.createTextNode(Integer.toString(p.getRg())));
                //add rg ao elemento pessoa
                pessoa.appendChild(Rg);
                //==================================================================

                //========== criando o atributo CPF ================================
                Element Cpf = documentoXML.createElement("Cpf");
                Cpf.appendChild(documentoXML.createTextNode(p.getCpf()));
                //add Cpf ao elemento pessoa
                pessoa.appendChild(Cpf);
                //==================================================================

                //========== criando o atributo ENDERECO ===========================
                Element End = documentoXML.createElement("IdEndereco");
                End.appendChild(documentoXML.createTextNode(Integer.toString(p.getIdEndereco())));
                pessoa.appendChild(End);
            }

            for (Endereco end : eDAO.listar()) {
                //========================================= ENDERECO =================================================
                Element endereco = documentoXML.createElement("Endereco");

                //========= criando atributo ID ====================================
                Attr idEnd = documentoXML.createAttribute("idEndereco");
                idEnd.setValue(Integer.toString(end.getIdEndereco()));
                //fazendo o end ficar com esse id
                endereco.setAttributeNodeNS(idEnd);
                //adicionar esse end ao no nó principal
                root.appendChild(endereco);
                //==================================================================
                Element statusEnd = documentoXML.createElement("status");
                statusEnd.appendChild(documentoXML.createTextNode(end.getStatus()));
                endereco.appendChild(statusEnd);
                //===========================LOGRADOURO=============================
                Element logr = documentoXML.createElement("Logradouro");
                logr.appendChild(documentoXML.createTextNode(end.getLogradouro()));
                endereco.appendChild(logr);
                //==================================================================

                //===============================CEP================================
                Element CepEnd = documentoXML.createElement("Cep");
                CepEnd.appendChild(documentoXML.createTextNode(Integer.toString(end.getCep())));
                endereco.appendChild(CepEnd);
                //==================================================================

                //================================NUMERO============================
                Element num = documentoXML.createElement("Numero");
                num.appendChild(documentoXML.createTextNode(Integer.toString(end.getNumero())));
                endereco.appendChild(num);
                //==================================================================

                //================================CIDADE============================
                Element cid = documentoXML.createElement("Cidade");
                cid.appendChild(documentoXML.createTextNode(end.getCidade()));
                endereco.appendChild(cid);
                //==================================================================

                //==================================UF==============================
                Element Uf = documentoXML.createElement("UF");
                Uf.appendChild(documentoXML.createTextNode(end.getUF()));
                endereco.appendChild(Uf);
                //==================================================================
            }

            //====================================================================================================
            for (Aeronave a : aDAO.listar()) {
                //=========================================Aeronave===================================================
                Element aeronave = documentoXML.createElement("Aeronave");

                //========= criando atributo ID ====================================
                Attr idAero = documentoXML.createAttribute("idAeronave");
                idAero.setValue(Integer.toString(a.getIdAeronave()));
                //fazendo o end ficar com esse id
                aeronave.setAttributeNodeNS(idAero);
                //adicionar esse end ao no nó principal
                root.appendChild(aeronave);
                //==================================================================
                //Aeronave(int idAeronave, String modelo, String autonomia, float capacidade, float velocidade, String numChassi, String tipo) {
                Element statusAero = documentoXML.createElement("status");
                statusAero.appendChild(documentoXML.createTextNode(a.getStatus()));
                aeronave.appendChild(statusAero);
                //==================================================================
                Element modelo = documentoXML.createElement("modelo");
                modelo.appendChild(documentoXML.createTextNode(a.getModelo()));
                aeronave.appendChild(modelo);
                //==================================================================
                Element auto = documentoXML.createElement("autonomia");
                auto.appendChild(documentoXML.createTextNode(a.getAutonomia().toString()));
                aeronave.appendChild(auto);

                Element capac = documentoXML.createElement("capCombustivel");
                capac.appendChild(documentoXML.createTextNode(Float.toString(a.getCapCombustivel())));
                aeronave.appendChild(capac);

                Element vel = documentoXML.createElement("velocidade");
                vel.appendChild(documentoXML.createTextNode(Float.toString(a.getVelocidade())));
                aeronave.appendChild(vel);

                Element nChassi = documentoXML.createElement("NumChassi");
                nChassi.appendChild(documentoXML.createTextNode(a.getNumChassi()));
                aeronave.appendChild(nChassi);

                Element tipo = documentoXML.createElement("Tipo");
                tipo.appendChild(documentoXML.createTextNode(a.getTipo()));
                aeronave.appendChild(tipo);

                //====================================================================================================
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource documentoFonte = new DOMSource(documentoXML);

            StreamResult documentoFinal = new StreamResult(new File("C:\\Users\\Matheus\\Documents\\NetBeansProjects\\AirTaxi\\AirTaxi.xml"));
            transformer.transform(documentoFonte, documentoFinal);
            return 1;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(PessoaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(PessoaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(PessoaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
