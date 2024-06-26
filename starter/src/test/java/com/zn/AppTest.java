package com.zn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppTest {
    static Connection con = null;
    static String cname = "dm.jdbc.driver.DmDriver";
    static String url = "jdbc:dm://localhost:5236";
    static String userid = "SYSDBA";
    static String pwd = "ksspasswjs";


    public static void main(String[] args) {
        try {
            Class.forName(cname);
            con = DriverManager.getConnection(url, userid, pwd);
            con.setAutoCommit(true);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("""
                    SELECT * FROM "dbo"."Test_Tab"
                    """);
            System.out.println();
        } catch (Exception e) {
            System.out.println("[FAIL]conn database：" + e.getMessage());
        }
    }
}
