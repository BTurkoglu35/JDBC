package jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "280620at");

           Statement st = con.createStatement();

           //SORU: Ogrenciler tablosuna kayit ekleyin
//
   //  int s1  = st.executeUpdate("insert into ogrenciler values(204,'Merve Can','12','K')");
   //     System.out.println(s1 + " veri girisi yapildi");
//
        String [] sql={"insert into ogrenciler values(303,'Asude Can','12','K')",
                "insert into ogrenciler values(304,'Zeynep Can','12','K')",
                "insert into ogrenciler values(305,'Turkan Can','12','K')"};
        int count=0;
   //     for (String each:sql){

   //        count=count+  st.executeUpdate(each);

     //   } System.out.println(count+ " eleman eklendi");

        //2.yol
        String [] sql1={"insert into ogrenciler values(403,'Asude Can','12','K')",
                "insert into ogrenciler values(404,'Zeynep Can','12','K')",
                "insert into ogrenciler values(405,'Turkan Can','12','K')"};

        for (String each1:sql1){
            st.addBatch(each1);      //yukaridaki datalarin hepsini birlestiriyor
        }
        st.executeBatch(); //datalari tek seferde gonderiyor
        System.out.println("veriler eklendi");
    }
}
