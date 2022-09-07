package jdbc_practice;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "280620at");

   //     Statement st = con.createStatement();

        PreparedStatement ps =con.prepareStatement("select * from ogrenciler");

        ResultSet rs=ps.executeQuery();

       ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println("sutun sayisi "+rsmd.getColumnCount());
        System.out.println("1. sutunun adi "+rsmd.getColumnName(1));
        System.out.println("2. sutunun adi "+rsmd.getColumnName(2));
        System.out.println("3. sutunun adi "+rsmd.getColumnName(3));
        System.out.println("4. sutunun adi "+rsmd.getColumnName(4));

        System.out.println("1. sutunun data tipi "+rsmd.getColumnTypeName(1));
        System.out.println("2. sutunun data tipi "+rsmd.getColumnTypeName(2));
        System.out.println("3. sutunun data tipi "+rsmd.getColumnTypeName(3));
        System.out.println("4. sutunun data tipi "+rsmd.getColumnTypeName(4));

        System.out.println("tablo ismi "+rsmd.getTableName(4));

    }
}
