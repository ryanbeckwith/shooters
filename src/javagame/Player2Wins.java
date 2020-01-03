package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Player2Wins extends BasicGameState
{
  Animation p2, p2Wins, p2WinsBig;
  Animation win, wins, winsBig;
  Animation exitButton, exitButtonClick, exitButtonClickBig;
  Animation play, playAgain, playAgainBig;
  int[] duration = {200, 200};
  long startingTime;
  long totalTime;
  
  public Player2Wins(int player2wins)
  {
    
  }

  public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException
  {
    Image[] exit = {new Image("res/ExitButton.png"), new Image("res/ExitButton.png")};
    Image[] exitBig = {new Image("res/ExitButtonBig.png"), new Image("res/ExitButtonBig.png")};
    Image[] p = {new Image("res/Player2Wins.png"), new Image("res/Player2Wins.png")};
    Image[] pBig = {new Image("res/Player2WinsBig.png"), new Image("res/Player2WinsBig.png")};
    Image[] w = {new Image("res/RedWins.png"), new Image("res/RedWins.png")};
    Image[] wBig = {new Image("res/RedWinsBig.png"), new Image("res/RedWinsBig.png")};
    Image[] pla = {new Image("res/PlayAgain.png"), new Image("res/PlayAgain.png")};
    Image[] plaBig = {new Image("res/PlayAgainBig.png"), new Image("res/PlayAgainBig.png")};
    
    exitButtonClick = new Animation(exit, duration, false);
    exitButtonClickBig = new Animation(exitBig, duration, false);
    exitButton = exitButtonClick;
    p2Wins = new Animation(p, duration, false);
    p2WinsBig = new Animation(pBig, duration, false);
    p2 = p2Wins;
    wins = new Animation(w, duration, false);
    winsBig = new Animation(wBig, duration, false);
    win = wins;
    playAgain = new Animation(pla, duration, false);
    playAgainBig = new Animation(plaBig, duration, false);
    play = playAgain;
    
    startingTime = System.currentTimeMillis();
  }

  public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
  {
    g.fillRect(0, 0, 1800, 950);
    p2.draw(540, 100);
    win.draw(670 ,310);
    exitButton.draw(790, 800);
    play.draw(685, 650);
  }

  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
  {
    int xPos = Mouse.getX();
    int yPos = Mouse.getY();
    totalTime = System.currentTimeMillis() - startingTime;
    
    if((xPos > 685 && xPos < 1115) && (yPos > 220 && yPos < 300))
    {
      play = playAgainBig;
      if(Mouse.isButtonDown(0))
      {
        sbg.getState(1).init(gc, sbg);
        sbg.enterState(1);
      }
    }
    else
    {
      play = playAgain;
    }
    
    if((xPos > 790 && xPos < 1010) && (yPos > 70 && yPos < 150))
    {
      exitButton = exitButtonClickBig;
      if(Mouse.isButtonDown(0))
      {
        System.exit(0);
      }
    }
    else
    {
      exitButton = exitButtonClick;
    }
    
    if(totalTime % 1000 < 500)
    {
      p2 = p2WinsBig;
    }
    else
    {
      p2 = p2Wins;
    }
    
    if(totalTime % 1000 < 500)
    {
      win = winsBig;
    }
    else
    {
      win = wins;
    }
  }

  public int getID()
  {
    return 4;
  }

}
