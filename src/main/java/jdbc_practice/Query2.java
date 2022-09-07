package jdbc_practice;

import java.sql.*;

public class Query2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "280620at");

        Statement st = con.createStatement();


      //  ogrenciler tablosundaki erkek ogrencileri listeleyinz
        ResultSet data=st.executeQuery("select * from ogrenciler where cinsiyet='E'");

        while (data.next()){
            System.out.println(data.getInt("okul_no") + "--" + data.getString("ogrenci_isim") + "--" + data.getString("sinif") + "--" + data.getString("cinsiyet"));
        }

       con.close();
        st.close();
        data.close();






    }
}