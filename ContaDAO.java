/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilitarios.ContaBean;

/**
 *
 * @author Otavio Souza (SamiSpy)
 */
public class ContaDAO {
    
    ContaBean cb = new ContaBean();
    
    private Connection con;
    
   public ContaDAO(Connection con){
        
        setCon(con);
        
    }
   
   public ContaBean validaLogin(ContaBean cb){
       
       boolean teste = false;
       
       String ag = cb.getAgencia();
       String pass = cb.getSenha();      
       
       String query;
       query = "SELECT * FROM tbl_banco WHERE agencia = ? AND senha = ?";
       
       try{
           
       
       PreparedStatement ps = getCon().prepareStatement(query);
       
       ps.setString(1, ag);
       ps.setString(2, pass);
       
       ResultSet rs = ps.executeQuery();
           
       if(rs.next()){
        
           teste = true;
           cb.setTeste(teste);
           cb.setSaldo(rs.getDouble("saldo"));
           System.out.println("Teste deu certo");
           return cb;
           
       }else{
           
           //DEBUG 
           System.out.println("banana");
       }
       
       }catch(SQLException e){
           
           System.out.println("ERRO DE SQL: " + e.getMessage());
           
       }
       
       return cb;
       
   }
   
   public ContaBean Selecionar(ContaBean cb){
       
       String query;
       query = "SELECT * FROM tbl_banco WHERE agencia = ? AND senha =?";
       
       try{
           
           PreparedStatement ps = getCon().prepareStatement(query);
           
           ps.setString(1, cb.getAgencia());
           ps.setString(2, cb.getSenha());
           
           ResultSet rs = ps.executeQuery();
           
           rs.next();
           
           cb.setSaldo(rs.getDouble("saldo"));
           
           return cb;
           
       }catch(SQLException e){
           
           System.out.println("Erro: " + e.getMessage());          
           
       }      
       
       return cb;
       
   }
   
   public ContaBean Deposito(ContaBean cb){
       
       String query = "UPDATE tbl_banco SET saldo = ? WHERE agencia = ? AND senha = ?";
       
       try{
           
           PreparedStatement ps = getCon().prepareStatement(query);
           
           ps.setDouble(1, cb.getSaldo());
           ps.setString(2, cb.getAgencia());
           ps.setString(3, cb.getSenha());
           
           ps.executeUpdate();
           
           return cb;           
           
       }catch(SQLException e){
           
           System.out.println("ERRO DE SQL: " + e.getMessage());
           
       }
       
       return cb;
   }

   public ContaBean Saque(ContaBean cb){
       
       String query = "UPDATE tbl_banco SET saldo = ? WHERE agencia = ? AND senha = ?";
       
       try{
           
           PreparedStatement ps = getCon().prepareStatement(query);
           
           ps.setDouble(1, cb.getSaldo());
           ps.setString(2, cb.getAgencia());
           ps.setString(3, cb.getSenha());
           
           ps.executeUpdate();
           
           return cb;           
           
       }catch(SQLException e){
           
           System.out.println("ERRO DE SQL: " + e.getMessage());
           
       }
       
       return cb;
   }
   
    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }
    
}
