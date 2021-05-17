/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shahbaproject.entites;

/**
 *
 * @author HAMMOUDA
 */
public class reservation {
      private int id ;
    private int nbrplace;
    private Boolean approuve;
    private String id_Event;
    private String user ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    public Boolean getApprouve() {
        return approuve;
    }

    public void setApprouve(Boolean approuve) {
        this.approuve = approuve;
    }

    public String getId_Event() {
        return id_Event;
    }

    public void setId_Event(String id_Event) {
        this.id_Event = id_Event;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public reservation(int id, int nbrplace, Boolean approuve, String id_Event, String user) {
        this.id = id;
        this.nbrplace = nbrplace;
        this.approuve = approuve;
        this.id_Event = id_Event;
        this.user = user;
    }

    public reservation(int nbrplace, Boolean approuve, String id_Event, String user) {
        this.nbrplace = nbrplace;
        this.approuve = approuve;
        this.id_Event = id_Event;
        this.user = user;
    }

    @Override
    public String toString() {
        return "reservation{" + "id=" + id + ", nbrplace=" + nbrplace + ", approuve=" + approuve + ", id_Event=" + id_Event + ", user=" + user + '}';
    }

    public reservation() {
    }
    
    
    
}
