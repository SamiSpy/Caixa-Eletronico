/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronicodb;

import java.util.Scanner;
import utilitarios.Program;

/**
 *
 * @author Otavio Souza (SamiSpy)
 */
public class CaixaEletronicoDB {   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Program p = new Program();    
        Scanner sc = new Scanner(System.in);
    
        String login;
        String senha;
        
        System.out.println("Digite a sua agência: ");
        login = sc.next();
        System.out.println("\nDigite a sua senha: ");
        senha = sc.next();
        
        boolean testelogin = p.Login(login, senha);
        
        if(testelogin == true){
            
            p.Programa();
            
        }else{
            
            System.out.println("Usuário ou senha inválidos!");
            
            
        }       
        
    }
    
}
