
package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexao {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estacionamento";
    private static final String USER = "root";
    private static final String PASS = "";
    
    //private static Connection Connection = null;
    
    public static Connection getConnection(){
        
        try{
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
                  
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException ("Erro na conexão ", ex);
        } 
    }
    
    public static void closeConnection(Connection con) {
	if (con != null) {
            try {
		con.close();
            } catch (SQLException ex) {
		System.err.println("Erro "+ex);
            }
	}
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {
	if (stmt != null) {
            try {
		stmt.close();
            } catch (SQLException ex) {
		System.err.println("Erro "+ex);
            }
	}
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
	if (rs != null) {
            try {
		rs.close();
            } catch (SQLException ex) {
		System.err.println("Erro "+ex);
            }
	}
        closeConnection(con, stmt);
    }
    
    private static Properties loadProperties() throws DbException{
        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }
    
    public static void closeStatement(Statement st) throws DbException{
        if(st!= null){
            try{
                st.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeResultSet(ResultSet rs) throws DbException{
        if(rs!= null){
            try{
                rs.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}











