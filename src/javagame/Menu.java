package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState
{
  Animation playingNow;
  Animation playingNowBig;
  Animation playing;
  Animation exiting;
  Animation exitingGame;
  Animation exitingGameBig;
  Animation titling;
  Animation titlingNow;
  Animation titlingNowBig;
  Animation control, controls, controlsBig;
  Animation credit, credits, creditsBig;
  
  int[] duration = {200, 200};
  int[] titleDuration = {500, 500};
  int posX;
  int posY;
  long startingTime;
  long totalTime;
  
  public Menu(int state)
  {
    
  }
  
  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
  {
    Image[] play = {new Image("res/PlayButton.png"), new Image("res/PlayButton.png")};
    Image[] playBig = {new Image("res/PlayButtonBig.png"), new Image("res/PlayButtonBig.png")};
    Image[] exit = {new Image("res/ExitButton.png"), new Image("res/ExitButton.png")};
    Image[] exitBig = {new Image("res/ExitButtonBig.png"), new Image("res/ExitButtonBig.png")};
    Image[] title = {new Image("res/Title.png"), new Image("res/Title.png")};
    Image[] titleBig = {new Image("res/TitleBig.png"), new Image("res/TitleBig.png")};
    Image[] cont = {new Image("res/ControlsButton.png"), new Image("res/ControlsButton.png")};
    Image[] contBig = {new Image("res/ControlsButtonBig.png"), new Image("res/ControlsButtonBig.png")};
    Image[] cred = {new Image("res/CreditsButton.png"), new Image("res/CreditsButton.png")};
    Image[] credBig = {new Image("res/CreditsButtonBig.png"), new Image("res/CreditsButtonBig.png")};
    
    playingNow = new Animation(play, duration, false);
    playingNowBig = new Animation(playBig, duration, false);
    playing = playingNow;
    exitingGame = new Animation(exit, duration, false);
    exitingGameBig = new Animation(exitBig, duration, false);
    exiting = exitingGame;
    titlingNow = new Animation(title, titleDuration, false);
    titlingNowBig = new Animation(titleBig, titleDuration, false);
    titling = titlingNow;
    controls = new Animation(cont, duration, false);
    controlsBig = new Animation(contBig, duration, false);
    control = controls;
    credits = new Animation(cred, duration, false);
    creditsBig = new Animation(credBig, duration, false);
    credit = credits;
    
    startingTime = System.currentTimeMillis();
  }
  
  public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
  {
    g.fillRect(0, 0, 1800, 950);
    titling.draw(525, 150);
    playing.draw(810, 400);
    exiting.draw(810, 520);
    control.draw(720, 640);
    credit.draw(750, 760);
  }
  
  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
  {
    posX = Mouse.getX();
    posY = Mouse.getY();
    totalTime = System.currentTimeMillis() - startingTime;
    
    if((posX > 750 && posX < 1050) && (posY > 110 && posY < 190))
    {
      credit = creditsBig;
      if(Mouse.isButtonDown(0))
      {
        sbg.enterState(5);
      }
    }
    else
    {
      credit = credits;
    }
    
    if((posX > 720 && posX < 1080) && (posY > 230 && posY < 310))
    {
      control = controlsBig;
      if(Mouse.isButtonDown(0))
      {
        sbg.enterState(2);
      }
    }
    else
    {
      control = controls;
    }
    
    if((posX > 810 && posX < 990) && (posY > 470 && posY < 550))
    {
      playing = playingNowBig;
      if(Mouse.isButtonDown(0))
      {
        sbg.getState(1).init(gc, sbg);
        sbg.enterState(1);
      }
    }
    else
    {
      playing = playingNow;
    }
    
    if((posX > 810 && posX < 990) && (posY > 370 && posY < 450))
    {
      exiting = exitingGameBig;
      if(Mouse.isButtonDown(0))
      {
        System.exit(0);
      }
    }
    else
    {
      exiting = exitingGame;
    }
    
    if(totalTime % 1000 < 500)
    {
      titling = titlingNowBig;
    }
    else
    {
      titling = titlingNow;
    }
  }
  
  public int getID()
  {
    return 0;
  }
}
