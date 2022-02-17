/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

/**
 *
 * @author user
 */
public class Player {
   private int purse=0;
   private final String playername;
    private int place=0;
    private boolean inpenaltybox=false;
    
    public void move(int roll){
        place+=roll;
        place%=12;
    }

    public Player(String playername) {
        this.playername = playername;
    }
    
    public int purse(){
        return purse;
    }
    public void addpurse(){
        purse++;
    }
    
    public boolean inpenaltybox(boolean b){
    return inpenaltybox;
    }
    
    public void isgettingoutofpenaltybox(){
        inpenaltybox =!inpenaltybox;
    }

   public int place() {
        return place;
    }

    boolean inpenaltybox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
