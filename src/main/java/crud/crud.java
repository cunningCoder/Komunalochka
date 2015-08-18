package crud;

import entity.month;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class crud {
    public static ArrayList<month> monthArray = new ArrayList<month>();
    public static Vector a;
    public static Vector b;

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void createDb(){
        String inDb = "insert into mydb.month (monthName,rentSum) value ('August',2);";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.executeUpdate(inDb);
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }

    }
    public static void readFromDB() {
        String query = "select * from mydb.month;";

            try {
                con = DriverManager.getConnection(url, user, password);
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);


                int numColumns = rs.getMetaData().getColumnCount();
                Vector column = new Vector();
                for (int i = 1; i <= numColumns; i++) {
                    column.add(rs.getMetaData().getColumnName(i));        }
                Vector data = new Vector();
                while (rs.next()) {
                    Vector row = new Vector();
                    for (int i = 1; i <= numColumns; i++) {
                        row.add(rs.getString(i));
                    }
                    data.add(row);
                }
                a=column;
                b=data;


                while (rs.next()) {
                    int id = rs.getInt("idMonth");
                    String name = rs.getString("monthName");
                    float rentSum = rs.getFloat("rentSum");
                    month month = new month(id,name,rentSum);
                    monthArray.add(month);
                    System.out.println("ID" + id +" Month "+ name +" Sum:"+ rentSum );


                }
            }
            catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
            finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.err.println("Error: " + ex.getMessage());
                }
            }
    }

    public  static void updateDb(){
        String update = "update mydb.month set monthName='August' where idMonth=785;";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.executeUpdate(update);
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
    public  static void deleteFromDb(){
        String delDb = "delete from mydb.month where idMonth=785;";
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.executeUpdate(delDb);


        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }


}
