
package model.Interface;

import model.bean.Aeronave;
import model.dao.AeronaveDAO;

public class AeronaveXML {
       public void Xml_to_Banco(Aeronave a) throws Exception {
        AeronaveDAO aeroDAO = new AeronaveDAO();
        
        System.out.print("\nAeronave");
        switch (a.getStatus()) {
            case "N":
                System.out.print(" - [nada a fazer]");

                break;
            case "E":
                System.out.print(" - [excluir]");
                aeroDAO.excluir(a);
                break;
            case "I":
                System.out.print(" - [inserir]");
                aeroDAO.inserir(a);
                break;
            case "A":
                System.out.print(" - [alterar]");
                aeroDAO.alterar(a);
                break;
        }
    } 
}
