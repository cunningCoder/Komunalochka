package crud;

import java.sql.*;

public class crud {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;


    public static void readDB() {
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


}
