package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Credits extends BasicGameState
{
  Animation creator, ryan, ryanBig;
  Animation creatorLast, beckwith, beckwithBig;
  Animation menuButton, menuButtonClick, menuButtonClickBig;
  Image createdBy;
  Image dedicatedTo, person;
  boolean keysDown;
  int[] duration = {200, 200};
  long startingTime, totalTime;
  
  public Credits(int credits)
  {
    
  }

  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
  {
    keysDown = false;
    
    Image[] ry = {new Image("res/RyanBlue.png"), new Image("res/RyanBlue.png")};
    Image[] ryBig = {new Image("res/RyanRed.png"), new Image("res/RyanRed.png")};
    Image[] beck = {new Image("res/BeckwithBlue.png"), new Image("res/BeckwithBlue.png")};
    Image[] beckBig = {new Image("res/BeckwithRed.png"), new Image("res/BeckwithRed.png")};
    Image[] menu = {new Image("res/MenuButtonClick.png"), new Image("res/MenuButtonClick.png")};
    Image[] menuBig = {new Image("res/MenuButtonClickBig.png"), new Image("res/MenuButtonClickBig.png")};
    
    createdBy = new Image("res/CreatedBy.png");
    dedicatedTo = new Image("res/DedicatedTo.png");
    person = new Image("res/Person.png");
    
    menuButtonClick = new Animation(menu, duration, false);
    menuButtonClickBig = new Animation(menuBig, duration, false);
    menuButton = menuButtonClick;
    ryan = new Animation(ry, duration, false);
    ryanBig = new Animation(ryBig, duration, false);
    beckwith = new Animation(beck, duration, false);
    beckwithBig = new Animation(beckBig, duration, false);
    creator = ryan;
    creatorLast = beckwith;
    
    startingTime = System.currentTimeMillis();
  }

  public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
  {
    g.fillRect(0, 0, 1800, 950);
    createdBy.draw(700, 50);
    creator.draw(685, 150);
    creatorLast.draw(505, 330);
    
    if(keysDown)
    {
      dedicatedTo.draw(660, 530);
      person.draw(505, 610);
    }
    
    menuButton.draw(790, 840);
  }

  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
  {
    Input input = gc.getInput();
    int xPos = Mouse.getX();
    int yPos = Mouse.getY();
    totalTime = System.currentTimeMillis() - startingTime;
    
    if((xPos > 790 && xPos < 1010) && (yPos > 30 && yPos < 110))
    {
      menuButton = menuButtonClickBig;
      if(Mouse.isButtonDown(0))
      {
        sbg.enterState(0);
      }
    }
    else
    {
      menuButton = menuButtonClick;
    }
    
    if(totalTime % 1000 < 500)
    {
      creator = ryanBig;
      creatorLast = beckwithBig;
    }
    else
    {
      creator = ryan;
      creatorLast = beckwith;
    }
    
    if(input.isKeyDown(Input.KEY_I) && input.isKeyDown(Input.KEY_L) && input.isKeyDown(Input.KEY_Y))
    {
      keysDown = true;
    }
    else
    {
      keysDown = false;
    }
  }

  public int getID()
  {
    return 5;
  }

}
