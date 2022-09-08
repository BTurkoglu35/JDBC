package jdbc_practice;

import static jdbc_practice.DatabaseUtilty.*;

public class Query06 {
    public static void main(String[] args) {
        createConnection();
        String query = "SELECT * FROM ogrenciler";
        System.out.println("SUtun isimleri: "+getColumnNames(query));

        System.out.println("Okul no :"+getColumnData(query,"okul_no"));
        System.out.println("ogrenci isim :"+getColumnData(query,"ogrenci_isim"));
        System.out.println("Sinif :"+getColumnData(query,"sinif"));
        System.out.println("Cinsiyet :"+getColumnData(query,"cinsiyet"));
    }
}
