/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import controller.Controller;
import java.util.Scanner;

/**
 *
 * @author Otavio Souza (SamiSpy)
 */
public class Program {
    
    ContaBean cb = new ContaBean();
    Controller controller = new Controller();
    Scanner sc = new Scanner(System.in);
    int opcao;
    
    public Program(){
        
    }
    
    public void Programa(){
        
        String sentinela = "ficar";
        
        do{
            
        
        System.out.println("Escolha uma opção: \n"
                + "Digite 1 para consultar o Saldo.\n"
                + "Digite 2 para efetuar um depósito.\n"
                + "Digite 3 para sacar.\n"
                + "Digite 0 para sair.");        
        opcao = sc.nextInt();
        
        switch(opcao){
            
            case 1:
                
                Saldo();
                
                break;
                
            case 2:
                
                Deposito();
                
                break;
                
            case 3:
                
                Saque();
            
            break;
            
            default:
            
            System.out.println("Até mais! :)");
            System.exit(0);
           
        }
        
            System.out.println("Deseja continuar? Digite 'sim' para sim ou 'sair' para finalizar.");
            sentinela = sc.next();
        
        }while(!(sentinela.equalsIgnoreCase("sair")));
        
        System.out.println("Até mais! :)");
        System.exit(0);             
    }
    
     public boolean Login(String login, String senha){
         
        cb.setAgencia(login);
        cb.setSenha(senha);
        
        controller.controllerVLogin(cb);
        
        return cb.isTeste();          
                
        }
     
     public void Saque(){
         
        System.out.println("Digite um valor para depósito: ");
         double saque = sc.nextDouble();
         
         cb.setSaldo(cb.getSaldo() - saque);
         
         controller.controllerSaque(cb);
         
         System.out.println("O seu novo saldo é de : " + cb.getSaldo());
         
     }
     
     public void Saldo(){
        
         System.out.println("Seu saldo é: " + cb.getSaldo());
          
     }
     
     public void Deposito(){
         
         System.out.println("Digite um valor para depósito: ");
         double deposito = sc.nextDouble();
         
         cb.setSaldo(cb.getSaldo() + deposito);
         
         controller.controllerDeposito(cb);
         
         System.out.println("O seu novo saldo é de : " + cb.getSaldo());
         
         
     }
     
    
}
