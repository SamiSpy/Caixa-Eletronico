
package utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection abrirConexao(){
        
        Connection con = null;
        
        try{ 
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "";
            
            url = "jdbc:mysql://127.0.0.1/db_caixaeletronico?user=root&password=";
            
            con = (Connection) DriverManager.getConnection(url);
        
        }catch(SQLException e){
        
            e.getMessage();
            System.out.println("Erro de conexão: " + e.getMessage());
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro de conexão: " + ex.getMessage());
        }
        
        return con;
    
    }
    
     public static void fecharConexao(Connection con){
    
        try{
        
            con.close();
            
        }catch(SQLException e){
        
            System.out.println("Erro de conexão: " + e.getMessage());
            
        }
               
}
     
}
