package jdbc;

import java.sql.*;

public class preparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "280620at");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.
        //1.adim: Prepared statement query'sini olustur

        String sgl1="update companies set   number_of_employees =? where company =? ";

       //2.adim:preparedStatement objesini olustur
        PreparedStatement pst1=con.prepareStatement(sgl1);

        //3.Adim: set...() methodlari ile soru isaretleri icin deger giricez.
        pst1.setInt(1,9999);
        pst1.setString(2,"IBM");

        //4.Adim: Execute Query
        int updateRow=pst1.executeUpdate();
        System.out.println(updateRow+"satir guncellendi");

        String sql2="SELECT * FROM companies order by number_of_employees  ";
        ResultSet result1=st.executeQuery(sql2);
        while (result1.next()) {
            System.out.println(result1.getInt(1)+"--"+result1.getString(2)+"--"+result1.getInt(3));
        }

        //google icin degisiklik .15000 yapalim
        pst1.setInt(1,15000);
        pst1.setString(2,"GOOGLE");


        int updateRow2=pst1.executeUpdate();
        System.out.println(updateRow2+"satir guncellendi");

        String sql3="SELECT * FROM companies order by number_of_employees  ";
        ResultSet result2=st.executeQuery(sql2);
        while (result2.next()) {
            System.out.println(result2.getInt(1)+"--"+result2.getString(2)+"--"+result2.getInt(3));
        }
        System.out.println("*********");
        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        read_data(con,"companies");
    }
    //bir tablonun istenilen datasini prepared statement ile cagirmak icin kullanilan method
    public static void read_data(Connection con,String tableName){
          try {
              String query=String.format("select * from %s",tableName);//format  ethodu dinamik string olusturmak icin kullanilir.
              //sql query'i calistir'
              Statement statement=   con.createStatement();
              ResultSet rs=statement.executeQuery(query);//datayi cagirip resultset konteynirina koyuyoruz
              while (rs.next()){//tum datayi cagiralim
                  System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3));              }


          }catch (Exception e) {
              System.out.println(e);
          }



    }


}