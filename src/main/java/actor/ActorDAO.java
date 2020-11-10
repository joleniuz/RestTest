/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcCon;

/**
 *
 * @author Joel
 */
public class ActorDAO {
    
    private final String GET_DATA = "SELECT counselor_id, first_name, last_name FROM counselor";
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<ActorDTO> getActors(){
        
        ActorDTO actorDto = null;
        List<ActorDTO> actors = new ArrayList<ActorDTO>();
        JdbcCon db = new JdbcCon();
        
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = db.openConnection();
            ps = con.prepareStatement(GET_DATA);
            rs = ps.executeQuery();
            
            while(rs.next()){
                actorDto = new ActorDTO();
                actorDto.setCounselorID(rs.getString(1));
                actorDto.setFirsName(rs.getString(2));
                actorDto.setLastName(rs.getString(3));
                actors.add(actorDto);
                
                System.out.println(actorDto.getCounselorID());
                System.out.println(actorDto.getFirsName());
                System.out.println(actorDto.getLastName());
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return actors;
    }
}
