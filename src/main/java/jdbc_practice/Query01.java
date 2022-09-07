package jdbc_practice;

import java.sql.*;


public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Driver yukle
        Class.forName("org.postgresql.Driver");
        //2 baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "280620at");
        //3 Veriyi al Statement
        Statement st = con.createStatement();

        //Resultset
        ResultSet veri = st.executeQuery("SELECT * FROM ogrenciler");

        //sonuclari al
        while (veri.next()) {
           //index kullanarak
        //    System.out.println(veri.getInt(1) + "--" + veri.getString(2) + "--" + veri.getString(3) + "--" + veri.getString(4));
           //sutun ismi kullanarak
            System.out.println(veri.getInt("okul_no") + "--" + veri.getString("ogrenci_isim") + "--" + veri.getString("sinif") + "--" + veri.getString("cinsiyet"));

        }
        con.close();
        st.close();
        veri.close();

    }

}
