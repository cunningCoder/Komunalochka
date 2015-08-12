package crud;

import java.sql.*;

public class crud {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void createDb(){
        String inDb = "insert into mydb.month (monthName) value ('August');";
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

                while (rs.next()) {
                    int id = rs.getInt("Idmonth");
                    String name = rs.getString("monthname");
                    float rentSum = rs.getFloat("rentSum");
                    System.out.println("Number "+id+" Month - "+name+" Rent - "+rentSum);
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
