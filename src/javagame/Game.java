package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame
{
  public static final String gamename = "Shooters";
  public static final int menu = 0;
  public static final int play = 1;
  public static final int controls = 2;
  public static final int player1Wins = 3;
  public static final int player2Wins = 4;
  public static final int credits = 5;
  
  public Game(String gamename)
  {
    super(gamename);
    this.addState(new Menu(menu));
    this.addState(new Play(play));
    this.addState(new Controls(controls));
    this.addState(new Player1Wins(player1Wins));
    this.addState(new Player2Wins(player2Wins));
    this.addState(new Credits(credits));
  }
  
  public void initStatesList(GameContainer gc) throws SlickException
  {
    this.getState(menu).init(gc, this);
    this.getState(play).init(gc, this);
    this.getState(controls).init(gc, this);
    this.getState(player1Wins).init(gc, this);
    this.getState(player1Wins).init(gc, this);
    this.getState(credits).init(gc, this);
    this.enterState(menu);
  }
  
  public static void main(String[] args)
  {
    AppGameContainer appgc;
    try
    {
      appgc = new AppGameContainer(new Game(gamename));
      appgc.setDisplayMode(1800, 950, false);
      appgc.start();
    }
    catch(SlickException e)
    {
      e.printStackTrace();
    }
  }
}
