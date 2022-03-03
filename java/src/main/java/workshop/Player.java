package workshop;

public class Player {
    private String Name;
    private int place;
    private int purse;
    private boolean inPenaltyBox;
    public Player()
    {

    }
    public void setName(String Name)
    {
        this.Name=Name;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setPlace(int place)
    {
        this.place=place;
    }

    public void addToPlace(int number)
    {
        number=this.place+number;
    }

    public void modPlace(int number)
    {
        this.place%=number;
    }

    public int getPlace()
    {
        return place;
    }

    public void setPurse(int purse)
    {
        this.purse=purse;
    }

    public Integer getPurse()
    {
        return this.purse;
    }

    public void setInPenaltyBox(boolean inPenaltyBox)
    {
        this.inPenaltyBox=inPenaltyBox;
    }

    public boolean isInPenaltyBox()
    {
        return this.inPenaltyBox;
    }

    public void increasePurseByOne()
    {
        this.purse++;
    }

    public boolean didPlayerWin(){
        return !(getPurse()==6);
    }
}