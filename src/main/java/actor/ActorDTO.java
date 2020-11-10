/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actor;

/**
 *
 * @author Joel
 */
public class ActorDTO {
       
    private String counselorID;
    private String firsName;
    private String lastName;

    public String getCounselorID() {
        return counselorID;
    }

    public void setCounselorID(String counselorID) {
        this.counselorID = counselorID;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
