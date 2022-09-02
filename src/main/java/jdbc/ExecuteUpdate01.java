package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","280620at");
        Statement st=con.createStatement();

        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE edin.

        String sql="UPDATE companies set number_of_employees=1600  WHERE number_of_employees< (select Avg(number_of_employees) from companies)" ;

        int updateSatirSAyisi=st.executeUpdate(sql);//update edilen satir sayisini return eder.
        System.out.println(updateSatirSAyisi);

        String sql2="select * from companies";
        st.executeQuery(sql2);
        ResultSet resultSet=st.executeQuery(sql2);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1)+"--"+resultSet.getString(2)+"--"+resultSet.getInt(3));
        }

        con.close();
        st.close();
        resultSet.close();








    }
}
