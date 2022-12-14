package jdbc;

import java.sql.*;

public class CallableStatement01 {
    /*
    Java'da methodlar return type sahibi olsa da ,void olsada method olaraak adlandirilir.
    SQL'de ise data return ediyorsa "function" denir.Return yapmiyorsa "procedure" diyee adlandirilir.
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "280620at");
        Statement st = con.createStatement();


        //1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.

        //1.Adim fonksiyon kodunu yaz
        String sql1="create or replace function  toplamaF(x NUMERIC, y NUMERIC)"+
                 "returns numeric"+
                " LANGUAGE plpgsql"+
                "as"+
                " $$"+
                 " begin"+
                "  return x+y;"+
                "end"+
               " $$";

         //2. adim fonksiyonu olustur
       // st.execute(sql1);

        //3.adim Fonksiyonu cagir
       CallableStatement cst1= con.prepareCall("{? = call toplamaF(?,?)}");

       //4.adim: Return icin registerOutParameter()  methodunu ,parametreler icin set() methodlarindan uygun olanlari kullan.
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,15);
        cst1.setInt(3,25);

        //5.adim :Calistirmak icin execute() methodunu kullan.
        cst1.execute();

        //6.adim: Sonucu cagirmak icin return data tipine gore "get" methodalrindan uygun olani kullan.
        System.out.println(cst1.getBigDecimal(1));


        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.

        String sql2 = "CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC, h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                " BEGIN\n" +
                " \n" +
                " RETURN 3.14 * r * r * h / 3;\n" +
                " \n" +
                " END\n" +
                "$$";

        //2. Adım: Fonksiyonu çalıştır.
        st.execute(sql2);

        //3. Adım: Fonksiyonu çağır.
        CallableStatement cst2 = con.prepareCall("{? = call koniHacmi(?, ?)}");

        //4. Adım: Return için registerOutParameter() methodunu, parametreler için set() methodlarından uygun olanları kullan.
        cst2.registerOutParameter(1, Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,1);

        //5. Adım: Çalıştırmak için execute() methodunu kullan.
        cst2.execute();

        //6. Adım: Sonucu çağırmak için return data tipine göre "get" methodlarından uygun olanı kullan.
        System.out.println(cst2.getBigDecimal(1));


    }




}
