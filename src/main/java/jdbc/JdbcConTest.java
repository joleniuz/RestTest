/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import actor.ActorDAO;
import actor.ActorDTO;
import java.util.List;

/**
 *
 * @author Joel
 */
public class JdbcConTest {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JdbcCon db = new JdbcCon();
    
        List<ActorDTO> actors = new ActorDAO().getActors();
        
    }
    
}
