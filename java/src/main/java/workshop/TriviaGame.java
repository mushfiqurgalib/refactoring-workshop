package workshop;


import java.util.*;

public class TriviaGame {
    
    private List<Player> players; 
    private List<Question> questionSets;
    public HashMap<Integer, String> questionMap = new HashMap<>();
    public HashMap<Integer, String> placeCategoryMap=new HashMap<>();

    int currentPlayerIndex = 0;
    boolean isGettingOutOfPenaltyBox;

    private void createQuestionMap()
    {
        questionMap.put(0, "Pop");
        questionMap.put(1, "Science");
        questionMap.put(2, "Sports");
        questionMap.put(3, "Rock");
    }

    public TriviaGame() {
        players=new ArrayList<>();
        questionSets=new ArrayList<>();
        Question popQuestionSet=new PopQuestion();
        Question rockQuestionSet=new RockQuestion();
        Question sportsQuestionSet=new SportsQuestion();
        Question scienceQuestionSet=new ScienceQuestion();
        questionSets.add(popQuestionSet);
        questionSets.add(scienceQuestionSet);
        questionSets.add(sportsQuestionSet);
        questionSets.add(rockQuestionSet);
        createQuestionMap();
        
    }

    public boolean isPlayable() {
        return players.size()>=2;
    }

    public void add(String playerName) {
        Player newPlayer=new Player();
        newPlayer.setName(playerName);
        newPlayer.setPlace(0);
        newPlayer.setPurse(0);
        newPlayer.setInPenaltyBox(false);
        players.add(newPlayer);

        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int rollNumber) 
    {
        Player currentPlayer=players.get(currentPlayerIndex);
        announce(currentPlayer + " is the current player");
        announce("They have rolled a " + rollNumber);

        if(playerWillMove(currentPlayer, rollNumber))
        {
            currentPlayer.modPlace(12);

            announce(currentPlayer.getName()
                        + "'s new location is "
                        + currentPlayer.getPlace());
                announce("The category is " + currentCategory());
                askQuestion();
        }
        else 
        {
            announce(currentPlayer.getName() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox=false;
        }

    }

    private void askQuestion() 
    {
        Player currentPlayer=players.get(currentPlayerIndex);
        Integer categoryIndex=currentPlayer.getPlace()%4;
        questionSets.get(categoryIndex).removeFirst();
    }


    private String currentCategory() {
        Player currentPlayer=players.get(currentPlayerIndex);
        Integer categoryIndex=currentPlayer.getPlace()%4;
        return questionMap.get(categoryIndex);
    }

    public boolean wasCorrectlyAnswered(int rollNumber) 
    {
        Player currentPlayer=players.get(currentPlayerIndex);

        if(playerWillMove(currentPlayer, rollNumber))
        {
            announce("Answer was correct!!!!");
                currentPlayer.increasePurseByOne();
                announce(currentPlayer.getName()
                    + " now has "
                    + currentPlayer.getPurse()
                    + " Gold Coins.");

                boolean winner = didPlayerWin();

                increaseCurrentPlayerIndex();
                return winner;
        }
        else 
        {
            increaseCurrentPlayerIndex();
                return true;
        }

    }

    public boolean wrongAnswer() 
    {
        Player currentPlayer=players.get(currentPlayerIndex);
        announce("Question was incorrectly answered");
        announce(currentPlayer.getName() + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);

        increaseCurrentPlayerIndex();
        return true;
    }

    private boolean didPlayerWin() {
        Player currentPlayer=players.get(currentPlayerIndex);
        return !(currentPlayer.getPurse() == 6);
    }

    private void announce(Object message) {
        System.out.println(message);
    }

    private boolean playerWillMove(Player player, int rollNumber)
    {
        return (!(player.isInPenaltyBox() && rollNumber%2==0));
    }

    private void increaseCurrentPlayerIndex()
    {
        currentPlayerIndex++;
        currentPlayerIndex%=players.size();
    }
}
