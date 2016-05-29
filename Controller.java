/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ContaDAO;
import utilitarios.Conexao;
import utilitarios.ContaBean;

/**
 *
 * @author Otavio Souza
 */
public class Controller {
    
    ContaDAO cdao = new ContaDAO(Conexao.abrirConexao());
    
    public ContaBean controllerSelecinar(ContaBean cb){
        
        return cdao.Selecionar(cb);
        
    }
    
    public ContaBean controllerVLogin(ContaBean cb){
        
        return cdao.validaLogin(cb);
        
    }
    
    public ContaBean controllerDeposito(ContaBean cb){
        
        return cdao.Deposito(cb);
        
    }
    
    public ContaBean controllerSaque(ContaBean cb){
        
        return cdao.Saque(cb);
        
    }
    
}
