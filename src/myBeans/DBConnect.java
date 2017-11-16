/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

/**
 *
 * @author Kjones36
 */
import java.sql.*;
import javax.swing.*;
import java.util.*;

public class DBConnect {

  // declare connection variables
  String driver = "com.mysql.jdbc.Driver";
  String url = "jdbc:mysql://localhost:3306/hotelproject";
  String user = "Kyle";
  String pwd = "Kyle";

  // declare SQL varaibles
  PreparedStatement pstm;
  Connection conn = null;
  Statement stm = null;
  ResultSet rst = null;
  ResultSetMetaData rsmd = null;

  // Establish connection
  private String open() {
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, pwd);
      stm = conn.createStatement();
    } catch (Exception exp) {
      return exp.getMessage();
    }
    return "Success";
  }
  
  private void close() {
    try {
      conn.close();
    } catch (Exception e) {
    }
  }
  
  public String update(String sql) {
    try {
      Class.forName(driver);
      Connection conn = DriverManager.getConnection(url, user, pwd);
      Statement stm = conn.createStatement();
      stm.executeUpdate(sql);
      stm.close();
      conn.close();
      return "Success";
    } catch (Exception e) {
      return e.getMessage();
    }
  }
  
  public String updateDB(String sql) {
    try {
      String message = open();
      if (message.equals("Success")) {
        stm = conn.createStatement();
        stm.executeUpdate(sql);
        stm.close();
        close();
        return "update Successful";
      } else {
        return message;
      }
    } catch (Exception e) {
      return e.getMessage();
    }
  }
  
  public String queryDB(String sql, String ... args) {
    String CsvMessage = "";
    int columns;
    try {
      String message = open();
      if (message.equals("Success")) {
        pstm = conn.prepareStatement(sql);
        int j=1;
        for (String d : args) 
          pstm.setString(j++, d);
        rst = pstm.executeQuery();
        rsmd = rst.getMetaData();
        columns = rsmd.getColumnCount();
        while (rst.next()) {
          for (int i = 1; i <= columns; i++) {
            CsvMessage += rst.getString(i) + ", ";
          }
          CsvMessage += "<br>";
        }
        close();
        return CsvMessage;
      } else {
        return message;
      }
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  public JTable getTable(String sql) {
    JTable table = null;
    String opened = open();
    String[] row;
    if (opened.equals("Success")) {
      try {
        rst = stm.executeQuery(sql);
        rsmd = rst.getMetaData();
        int count = rsmd.getColumnCount();
        String[] headings = new String[count];
        for (int i = 0; i < count; i++) {
          headings[i] = rsmd.getColumnName(i+1);
        }
        ArrayList<String> data = new ArrayList<String>();
        row = new String[count];
        while (rst.next()) {
          for (int i = 0; i < count; i++) {
            data.add(rst.getString(i+1));
          }
        }
        String[][] dataArray = new String[data.size()/count][count];
        for (int i = 0; i < data.size()/count; i++) {
          for (int j = 0; j < count; j++) {
            dataArray[i][j] = data.get(count * i + j);
          }
        }
        table = new JTable(dataArray, headings);

      } catch (Exception exp) {
        String[] heading = {"Error"};
        String[][] data = {{exp.getMessage()}};
        table = new JTable(data, heading);

      }
    } else {
      String[] heading = {"Error"};
      String[][] data = {{opened}};
      table = new JTable(data, heading);

    }
    return table;
  }
  
  
}
