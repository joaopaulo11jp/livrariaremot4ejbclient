/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livrariaremot4client;

import br.edu.ifpb.livrariaremot4.interfaces.LivroManagerBeanRemote;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author joaopaulo
 */
public class LivrariaRemot4Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            Properties p = new Properties();
            p.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.impl.SerialInitContextFactory");
            InitialContext ctx = new InitialContext(p);
            LivroManagerBeanRemote lm = (LivroManagerBeanRemote) ctx.lookup("LivroManager");
            String l = lm.teste();
            System.out.println((l!=null)?l:"Nao cadastrado");
            
            
        } catch (NamingException ex) {
            Logger.getLogger(LivrariaRemot4Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
