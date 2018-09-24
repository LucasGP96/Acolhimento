package DAO;

import View.InserirFuncionarioView;
import acolhimento.Funcionario;

/**
 *
 * @author wilsi
 */
public class FuncionarioDao {
    
    
    public static void Salvar(Funcionario funcionario){
        
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://127.0.0.1:3306/prova2";
        
        String sql = "insert Funcionario values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
        
        
    }
    
    
    
}
