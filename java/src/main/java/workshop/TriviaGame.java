package workshop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriviaGame {
    private final List<Player> players = new ArrayList<>();
   private final Question question;

  
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
       question=new Question();
        }
    

   private Player currentPlayer(){
    return players.get(currentPlayer);
    }


    public void add(String playerName) {
        String playername = null;


        Player player=new Player(playername);
        players.add(player);
        

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        
    }
  private void askQuestion() {
      String currentCategory;
      switch(currentPlayer().place()%4){
          case 0:currentCategory = "Pop"; break;
          case 1:currentCategory = "Science"; break;
          case 2:currentCategory = "Sports"; break;
          default:currentCategory = "Rock"; break;
        
    }}

 

    public void roll(int roll) {
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer().inpenaltybox()) {
            if (roll % 2 != 0) {
                

                System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
                currentPlayer().isgettingoutofpenaltybox();
                currentPlayer().move(roll);
                askQuestion();}
            else{
               currentPlayer().move(roll);
                askQuestion();
            }}
            else {
                System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
                currentPlayer().isgettingoutofpenaltybox();
            }
            
        } 
        

    

  


    public void CorrectAnswer() {
        if (currentPlayer().inpenaltybox(false)) {
            System.out.println("Answer was correct!!!!");
               currentPlayer().addpurse();}
               

              nextPlayer();
            } 
          

    public void wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        currentPlayer().isgettingoutofpenaltybox(); 

      nextPlayer();
    }

  

    private void nextPlayer() {
        currentPlayer++;
        
    }

   
}