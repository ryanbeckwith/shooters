package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Controls extends BasicGameState
{
  int[] duration = {200, 200};
  Animation menuButton, menuButtonClick, menuButtonClickBig;
  Image player1, player2, wControl, aControl, sControl, dControl, upControl, downControl, leftControl, rightControl;
  Image periodControl, fControl, slashControl, spaceControl;
  
  public Controls(int controls)
  {
    
  }

  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
  {
    Image[] menu = {new Image("res/MenuButtonClick.png"), new Image("res/MenuButtonClick.png")};
    Image[] menuBig = {new Image("res/MenuButtonClickBig.png"), new Image("res/MenuButtonClickBig.png")};
    
    menuButtonClick = new Animation(menu, duration, false);
    menuButtonClickBig = new Animation(menuBig, duration, false);
    menuButton = menuButtonClick;
    
    player1 = new Image("res/Player1.png");
    player2 = new Image("res/Player2.png");
    wControl = new Image("res/WControl.png");
    aControl = new Image("res/AControl.png");
    sControl = new Image("res/SControl.png");
    dControl = new Image("res/DControl.png");
    upControl = new Image("res/UpArrowControl.png");
    downControl = new Image("res/DownArrowControl.png");
    leftControl = new Image("res/LeftArrowControl.png");
    rightControl = new Image("res/RightArrowControl.png");
    periodControl = new Image("res/PeriodControl.png");
    fControl = new Image("res/FControl.png");
    slashControl = new Image("res/SlashControl.png");
    spaceControl = new Image("res/SpaceControl.png");
  }

  public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
  {
    g.fillRect(0, 0, 1800, 950);
    player1.draw(370, 20);
    player2.draw(1110, 20);
    wControl.draw(1185, 120);
    sControl.draw(1110, 220);
    aControl.draw(1140, 320);
    dControl.draw(1103, 420);
    upControl.draw(395, 120);
    downControl.draw(365, 220);
    leftControl.draw(375, 320);
    rightControl.draw(363, 420);
    slashControl.draw(365, 520);
    spaceControl.draw(1095, 520);
    menuButton.draw(790, 840);
  }

  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
  {
    int xPos = Mouse.getX();
    int yPos = Mouse.getY();
    
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
    
  }

  public int getID()
  {
    return 2;
  }

  
  
}
