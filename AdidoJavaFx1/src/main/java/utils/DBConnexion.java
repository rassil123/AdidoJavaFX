package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class DBConnexion {

    private final java.lang.String user = "root";
    private final java.lang.String pwd = "";
    private final java.lang.String url = "jdbc:mysql://localhost:3306/adido";
    private Connection cnx;

    // 1er etape : rendre le constructeur prive
    // 2eme etape : creer une variable de meme tupe que la classe
    private static DBConnexion instance;

   public DBConnexion(){
        try {
            cnx = DriverManager.getConnection(url,user,pwd);
            System.out.println("Connection Etablie !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }


    }
    // 3eme etape : creer une methode static et public pour recuperer l'instance

    public static DBConnexion getInstance(){
       if (instance == null) instance = new DBConnexion();
       return instance;
    }
    public Connection getCnx(){
       return cnx;
    }
}
