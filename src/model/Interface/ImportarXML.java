package model.Interface;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.bean.Aeronave;
import model.bean.Endereco;
import model.bean.Pessoa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ImportarXML {

    public int all() throws Exception {

        try {

            PessoaXML pXML = new PessoaXML();
            EnderecoXML eXML = new EnderecoXML();
            AeronaveXML aXML = new AeronaveXML();

            Endereco end = new Endereco();
            Aeronave a = new Aeronave();
            Pessoa p = new Pessoa();

            //objetos para construir e fazer a leitura do documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            //abre e faz o parser de um documento xml de acordo com o nome passado no parametro
            Document doc = builder.parse("C:\\Users\\Matheus\\Documents\\NetBeansProjects\\AirTaxi\\AirTaxi.xml");

            //==================================================================================================
            //==========================================PESSOA==================================================
            //==================================================================================================
            //System.out.println("**************************************\n");
            //cria uma lista de pessoas. Busca no documento todas as tag Pessoa
            NodeList listaDePessoas = doc.getElementsByTagName("Pessoa");

            //pego o tamanho da lista de Pessoas
            int tamanhoLista = listaDePessoas.getLength();

            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoLista; i++) {

                //pego cada item (Pessoa) como um nó (node)
                Node noPessoa = listaDePessoas.item(i);

                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {

                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoPessoa = (Element) noPessoa;

                    //já posso pegar o atributo do element
                    String idPessoa = elementoPessoa.getAttribute("idPessoa");

                    //**************
                    p.setIdPessoa(Integer.parseInt(idPessoa));

                    //imprimindo o id
                    //System.out.println("ID PESSOA = " + p.getIdPessoa());
                    //****************
                    //recupero os nos filhos do elemento pessoa (nome, idade e peso)
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();

                    //pego o tamanho da lista de filhos do elemento pessoa
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();

                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhos; j++) {

                        //crio um no com o cada tag filho dentro do no pessoa (tag nome,...)
                        Node noFilho = listaDeFilhosDaPessoa.item(j);

                        //verifico se são tipo element
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {

                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;

                            //verifico em qual filho estamos pela tag
                            switch (elementoFilho.getTagName()) {

                                case "status":
                                    p.setStatus(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    //System.out.println("STATUS=" + p.getStatus());
                                    break;

                                case "nome":
                                    p.setNome(elementoFilho.getTextContent());
                                    //imprimo o nome
                                    //System.out.println("NOME=" + p.getNome());
                                    break;

                                case "Rg":
                                    p.setRg(Integer.parseInt(elementoFilho.getTextContent()));
                                    //imprimo o peso
                                    //System.out.println("RG=" + p.getRg());
                                    break;

                                case "Cpf":
                                    p.setCpf(elementoFilho.getTextContent());
                                    //imprimo o nome
                                    //System.out.println("CPF=" + p.getCpf());
                                    break;

                                case "IdEndereco":
                                    p.setIdEndereco(Integer.parseInt(elementoFilho.getTextContent()));
                                    //imprimo o nome
                                    //System.out.println("ID ENDERECO DA PESSOA=" + p.getIdEndereco());
                                    break;

                            }

                        }

                    }
                    pXML.Xml_to_Banco(p);
                }

            }

            //==================================================================================================
            //============================================ENDERECO==============================================
            //==================================================================================================
            //System.out.println("**************************************\n");
            //cria uma lista de pessoas. Busca no documento todas as tag Pessoa
            NodeList listaDeEnderecos = doc.getElementsByTagName("Endereco");

            //pego o tamanho da lista de Pessoas
            int tamanhoListaEnd = listaDeEnderecos.getLength();

            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoListaEnd; i++) {

                //pego cada item (ENdereco) como um nó (node)
                Node noEndereco = listaDeEnderecos.item(i);

                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if (noEndereco.getNodeType() == Node.ELEMENT_NODE) {

                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoEndereco = (Element) noEndereco;

                    //já posso pegar o atributo do element
                    String idEndereco = elementoEndereco.getAttribute("idEndereco");

                    //**************
                    end.setIdEndereco(Integer.parseInt(idEndereco));

                    //imprimindo o id
                    //System.out.println("ID ENDERECO = " + end.getIdEndereco());
                    //****************
                    //recupero os nos filhos do elemento Endereco
                    NodeList listaDeFilhosDeEndereco = elementoEndereco.getChildNodes();

                    //pego o tamanho da lista de filhos do elemento Endereco
                    int tamanhoListaFilhosEnd = listaDeFilhosDeEndereco.getLength();

                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhosEnd; j++) {

                        //crio um no com o cada tag filho dentro do no Endereco
                        Node noFilho = listaDeFilhosDeEndereco.item(j);

                        //verifico se são tipo element
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {

                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;

                            //verifico em qual filho estamos pela tag
                            switch (elementoFilho.getTagName()) {

                                case "status":
                                    end.setStatus(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    //System.out.println("STATUS=" + end.getStatus());
                                    break;

                                case "Logradouro":
                                    end.setLogradouro(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    //System.out.println("LOGREDOURO=" + end.getLogradouro());
                                    break;

                                case "Cep":
                                    end.setCep(Integer.parseInt(elementoFilho.getTextContent()));
                                    //imprimo a idade
                                    //System.out.println("CEP=" + end.getCep());
                                    break;

                                case "Numero":
                                    end.setNumero(Integer.parseInt(elementoFilho.getTextContent()));
                                    //imprimo a idade
                                    //System.out.println("NUMERO=" + end.getNumero());
                                    break;

                                case "Cidade":
                                    end.setCidade(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    //System.out.println("STATUS=" + end.getCidade());
                                    break;

                                case "UF":
                                    end.setUF(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    //System.out.println("UF=" + end.getUF());
                                    break;
                            }
                        }

                    }
                    eXML.Xml_to_Banco(end);
                }

            }
            //==================================================================================================
            //==========================================AERONAVE================================================
            //==================================================================================================
            System.out.println("**************************************\n");

            //cria uma lista de aeronave. Busca no documento todas as tag Pessoa
            NodeList listaDeAeronaves = doc.getElementsByTagName("Aeronave");

            //pego o tamanho da lista de Pessoas
            int tamanhoListaAero = listaDeAeronaves.getLength();

            //varredura na lista de aeronave
            for (int i = 0; i < tamanhoListaAero; i++) {

                //pego cada item (aeronare) como um nó (node)
                Node noAeronave = listaDeAeronaves.item(i);

                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if (noAeronave.getNodeType() == Node.ELEMENT_NODE) {

                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoAeronave = (Element) noAeronave;

                    //já posso pegar o atributo do element
                    String idAeronave = elementoAeronave.getAttribute("idAeronave");

                    //**************
                    a.setIdAeronave(Integer.parseInt(idAeronave));

                    //imprimindo o id
                    System.out.println("ID AERONAVE = " + a.getIdAeronave());

                    //****************
                    //recupero os nos filhos do elemento Endereco
                    NodeList listaDeFilhosDeAeronave = elementoAeronave.getChildNodes();

                    //pego o tamanho da lista de filhos do elemento Endereco
                    int tamanhoListaFilhosAero = listaDeFilhosDeAeronave.getLength();

                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhosAero; j++) {

                        //crio um no com o cada tag filho dentro do no Endereco
                        Node noFilho = listaDeFilhosDeAeronave.item(j);

                        //verifico se são tipo element
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {

                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;

                            //verifico em qual filho estamos pela tag
                            switch (elementoFilho.getTagName()) {

                                case "status":
                                    a.setStatus(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    System.out.println("STATUS=" + a.getStatus());
                                    break;

                                case "modelo":
                                    a.setModelo(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    System.out.println("MODELO=" + a.getModelo());
                                    break;

                                case "autonomia":
                                    a.setAutonomia(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    System.out.println("AUTONOMIA=" + a.getAutonomia());
                                    break;

                                case "capCombustivel":
                                    a.setCapCombustivel(Float.parseFloat((elementoFilho.getTextContent())));
                                    //imprimo a idade
                                    System.out.println("CAPACIDADE=" + a.getCapCombustivel());
                                    break;

                                case "velocidade":
                                    a.setVelocidade(Float.parseFloat(elementoFilho.getTextContent()));
                                    //imprimo a idade
                                    System.out.println("VELOCIDADE=" + a.getVelocidade());
                                    break;

                                case "NumChassi":
                                    a.setNumChassi(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    System.out.println("NUM CHASSI=" + a.getNumChassi());
                                    break;

                                case "Tipo":
                                    a.setTipo(elementoFilho.getTextContent());
                                    //imprimo a idade
                                    System.out.println("TIPO=" + a.getTipo());
                                    break;

                            }
                        }
                    }
                    aXML.Xml_to_Banco(a);
                }
            }
            System.out.println("**************************************\n");

            //==================================================================================================
            //==================================================================================================
            return 1;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ImportarXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
