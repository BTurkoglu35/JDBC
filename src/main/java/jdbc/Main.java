package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //DBWork objesi olustur
        DBWork dbw = new DBWork();
        //connection methodunu   cagir.
      Connection con= dbw.connect_to_db("techproed","postgres","280620at");

       //yeni table olusturma methodunu cagir
      dbw.createTable(con,"employess");


    }
}
