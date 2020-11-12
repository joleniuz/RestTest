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
    
    private final String GET_ACTORS = "SELECT * FROM counselor";
    private final String GET_ACTOR_BY_ID = "SELECT * FROM counselor WHERE counselor_id=?";
    
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
            ps = con.prepareStatement(GET_ACTORS);
            rs = ps.executeQuery();
            
            while(rs.next()){
                actorDto = new ActorDTO();
                actorDto.setCounselorID(rs.getInt(1));
                actorDto.setFirsName(rs.getString(2));
                System.out.println(rs.getString(2));
                actorDto.setNickName(rs.getString(3));
                actorDto.setLastName(rs.getString(4));
                actorDto.setTelephone(rs.getString(5));
                actorDto.setEmail(rs.getString(6));
                actorDto.setMemberSince(rs.getString(7));
                actors.add(actorDto);
                  
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return actors;
    }
    
    public ActorDTO getActorById(int actorId){
        
        ActorDTO actor = null;
        JdbcCon db = new JdbcCon();
        
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = db.openConnection();
            ps = con.prepareStatement(GET_ACTOR_BY_ID);
            ps.setInt(1, actorId);
            rs = ps.executeQuery();
            
            if(rs.next()){
            actor = new ActorDTO();
            actor.setCounselorID(rs.getInt(1));
            actor.setFirsName(rs.getString(2));
            actor.setNickName(rs.getString(3));
            actor.setLastName(rs.getString(4));
            actor.setTelephone(rs.getString(5));
            actor.setEmail(rs.getString(6));
            actor.setMemberSince(rs.getString(7));
            
            System.out.println(rs.getString(2));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return actor;
    }
}
