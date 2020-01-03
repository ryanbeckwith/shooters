package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Play extends BasicGameState
{
  Animation blueBoi, movingUp, movingDown, movingLeft, movingRight, gunMovingUp, gunMovingDown, gunMovingLeft, gunMovingRight, blueBoi1, blueBoi2, blueBoi3;
  Animation bullets0, bullets1, bullets2, bullets3, bullets;
  Animation start, startGo, start1, start2, start3;
  Animation movingUp1, movingDown1, movingLeft1, movingRight1;
  Animation movingUp2, movingDown2, movingLeft2, movingRight2;
  Animation movingUp3, movingDown3, movingLeft3, movingRight3;
  Animation movingUp4, movingDown4, movingLeft4, movingRight4;
  Animation movingUp5, movingDown5, movingLeft5, movingRight5;
  Image worldMap, resumeButton, menuButton, exitButton;
  Image blueBullet1, blueBullet2, blueBullet3;
  boolean quit;
  boolean triggerPulled;
  boolean trigger1Pulled;
  boolean trigger2Pulled;
  boolean trigger3Pulled;
  boolean gunOut;
  boolean touchingRedBullet1;
  boolean touchingRedBullet2;
  boolean touchingRedBullet3;
  boolean starting;
  boolean veryBeginning;
  int gunOutCount;
  int triggerPulledCount;
  int mousePosX;
  int mousePosY;
  int remainingLives;
  int[] duration = {200, 200};
  float blueBoiPositionX;
  float blueBoiPositionY;
  float blueBullet1PositionX, blueBullet2PositionX, blueBullet3PositionX;
  float blueBullet1PositionY, blueBullet2PositionY, blueBullet3PositionY;
  float speedFactor = 0.8f;
  float bulletSpeedFactor = 1.2f;
  long startingTime;
  long totalTime;
  int direction = 1;
  int direction1, direction2, direction3;
  
  
  
  Animation redBoi, movingUpRed, movingDownRed, movingLeftRed, movingRightRed, gunMovingUpRed, gunMovingDownRed, gunMovingLeftRed, gunMovingRightRed, redBoi1, redBoi2, redBoi3;
  Animation bullets0Red, bullets1Red, bullets2Red, bullets3Red, bulletsRed;
  Animation movingUpRed1, movingDownRed1, movingLeftRed1, movingRightRed1;
  Animation movingUpRed2, movingDownRed2, movingLeftRed2, movingRightRed2;
  Animation movingUpRed3, movingDownRed3, movingLeftRed3, movingRightRed3;
  Animation movingUpRed4, movingDownRed4, movingLeftRed4, movingRightRed4;
  Animation movingUpRed5, movingDownRed5, movingLeftRed5, movingRightRed5;
  Image redBullet1, redBullet2, redBullet3;
  boolean triggerPulledRed;
  boolean trigger1PulledRed;
  boolean trigger2PulledRed;
  boolean trigger3PulledRed;
  boolean gunOutRed;
  boolean touchingBlueBullet1;
  boolean touchingBlueBullet2;
  boolean touchingBlueBullet3;
  int gunOutCountRed;
  int triggerPulledCountRed;
  int remainingLivesRed;
  float redBoiPositionX;
  float redBoiPositionY;
  float redBullet1PositionX, redBullet2PositionX, redBullet3PositionX;
  float redBullet1PositionY, redBullet2PositionY, redBullet3PositionY;
  int directionRed;
  int directionRed1, directionRed2, directionRed3;
  
  public Play(int state)
  {
    
  }
  
  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
  {
    quit = false;
    triggerPulled = false;
    trigger1Pulled = false;
    trigger2Pulled = false;
    trigger3Pulled = false;
    gunOut = false;
    touchingRedBullet1 = false;
    touchingRedBullet2 = false;
    touchingRedBullet3 = false;
    starting = true;
    veryBeginning = true;
    
    gunOutCount = 0;
    triggerPulledCount = 0;
    remainingLives = 12;
    blueBoiPositionX = 1253;
    blueBoiPositionY = 375;
    direction = 1;
    
    triggerPulledRed = false;
    trigger1PulledRed = false;
    trigger2PulledRed = false;
    trigger3PulledRed = false;
    gunOutRed = false;
    touchingBlueBullet1 = false;
    touchingBlueBullet2 = false;
    touchingBlueBullet3 = false;
    
    gunOutCountRed = 0;
    triggerPulledCountRed = 0;
    remainingLivesRed = 12;
    redBoiPositionX = 418;
    redBoiPositionY = 375;
    directionRed = 1;
    
    blueBullet1 = new Image("res/BlueBullet.png");
    blueBullet2 = new Image("res/BlueBullet.png");
    blueBullet3 = new Image("res/BlueBullet.png");

    worldMap = new Image("res/GameBoard2.png");
    resumeButton = new Image("res/ResumeButton.png");
    menuButton = new Image("res/MenuButton.png");
    exitButton = new Image("res/ExitButton2.png");
    
    Image[] walkUp = {new Image("res/BlueBoiBack2.png"), new Image("res/BlueBoiBack2.png")};
    Image[] walkDown = {new Image("res/BlueBoi.png"), new Image("res/BlueBoi.png")};
    Image[] walkLeft = {new Image("res/BlueBoiLeft.png"), new Image("res/BlueBoiLeft.png")};
    Image[] walkRight = {new Image("res/BlueBoiRight.png"), new Image("res/BlueBoiRight.png")};
    Image[] gunWalkUp = {new Image("res/BlueBoiBackGun.png"), new Image("res/BlueBoiBackGun.png")};
    Image[] gunWalkDown = {new Image("res/BlueBoiGun.png"), new Image("res/BlueBoiGun.png")};
    Image[] gunWalkLeft = {new Image("res/BlueBoiLeftGun.png"), new Image("res/BlueBoiLeftGun.png")};
    Image[] gunWalkRight = {new Image("res/BlueBoiRightGun.png"), new Image("res/BlueBoiRightGun.png")};
    Image[] bulletsLeft0 = {new Image("res/0BulletsLeft.png"), new Image("res/0BulletsLeft.png")};
    Image[] bulletsLeft1 = {new Image("res/1BulletsLeft.png"), new Image("res/1BulletsLeft.png")};
    Image[] bulletsLeft2 = {new Image("res/2BulletsLeft.png"), new Image("res/2BulletsLeft.png")};
    Image[] bulletsLeft3 = {new Image("res/3BulletsLeft.png"), new Image("res/3BulletsLeft.png")};
    Image[] st1 = {new Image("res/Start1.png"), new Image("res/Start1.png")};
    Image[] st2 = {new Image("res/Start2.png"), new Image("res/Start2.png")};
    Image[] st3 = {new Image("res/Start3.png"), new Image("res/Start3.png")};
    Image[] stGo = {new Image("res/StartGo.png"), new Image("res/StartGo.png")};
    Image[] up1 = {new Image("res/MovingUp1.png"), new Image("res/MovingUp1.png")};
    Image[] up2 = {new Image("res/MovingUp2.png"), new Image("res/MovingUp2.png")};
    Image[] up3 = {new Image("res/MovingUp3.png"), new Image("res/MovingUp3.png")};
    Image[] up4 = {new Image("res/MovingUp4.png"), new Image("res/MovingUp4.png")};
    Image[] up5 = {new Image("res/MovingUp5.png"), new Image("res/MovingUp5.png")};
    Image[] down1 = {new Image("res/MovingDown1.png"), new Image("res/MovingDown1.png")};
    Image[] down2 = {new Image("res/MovingDown2.png"), new Image("res/MovingDown2.png")};
    Image[] down3 = {new Image("res/MovingDown3.png"), new Image("res/MovingDown3.png")};
    Image[] down4 = {new Image("res/MovingDown4.png"), new Image("res/MovingDown4.png")};
    Image[] down5 = {new Image("res/MovingDown5.png"), new Image("res/MovingDown5.png")};
    Image[] left1 = {new Image("res/MovingLeft1.png"), new Image("res/MovingLeft1.png")};
    Image[] left2 = {new Image("res/MovingLeft2.png"), new Image("res/MovingLeft2.png")};
    Image[] left3 = {new Image("res/MovingLeft3.png"), new Image("res/MovingLeft3.png")};
    Image[] left4 = {new Image("res/MovingLeft4.png"), new Image("res/MovingLeft4.png")};
    Image[] left5 = {new Image("res/MovingLeft5.png"), new Image("res/MovingLeft5.png")};
    Image[] right1 = {new Image("res/MovingRight1.png"), new Image("res/MovingRight1.png")};
    Image[] right2 = {new Image("res/MovingRight2.png"), new Image("res/MovingRight2.png")};
    Image[] right3 = {new Image("res/MovingRight3.png"), new Image("res/MovingRight3.png")};
    Image[] right4 = {new Image("res/MovingRight4.png"), new Image("res/MovingRight4.png")};
    Image[] right5 = {new Image("res/MovingRight5.png"), new Image("res/MovingRight5.png")};
    
    movingUp = new Animation(walkUp, duration, false);
    movingDown = new Animation(walkDown, duration, false);
    movingLeft = new Animation(walkLeft, duration, false);
    movingRight = new Animation(walkRight, duration, false);
    gunMovingUp = new Animation(gunWalkUp, duration, false);
    gunMovingDown = new Animation(gunWalkDown, duration, false);
    gunMovingLeft = new Animation(gunWalkLeft, duration, false);
    gunMovingRight = new Animation(gunWalkRight, duration, false);
    bullets0 = new Animation(bulletsLeft0, duration, false);
    bullets1 = new Animation(bulletsLeft1, duration, false);
    bullets2 = new Animation(bulletsLeft2, duration, false);
    bullets3 = new Animation(bulletsLeft3, duration, false);
    startGo = new Animation(stGo, duration, false);
    start1 = new Animation(st1, duration, false);
    start2 = new Animation(st2, duration, false);
    start3 = new Animation(st3, duration, false);
    movingUp1 = new Animation(up1, duration, false);
    movingUp2 = new Animation(up2, duration, false);
    movingUp3 = new Animation(up3, duration, false);
    movingUp4 = new Animation(up4, duration, false);
    movingUp5 = new Animation(up5, duration, false);
    movingDown1 = new Animation(down1, duration, false);
    movingDown2 = new Animation(down2, duration, false);
    movingDown3 = new Animation(down3, duration, false);
    movingDown4 = new Animation(down4, duration, false);
    movingDown5 = new Animation(down5, duration, false);
    movingLeft1 = new Animation(left1, duration, false);
    movingLeft2 = new Animation(left2, duration, false);
    movingLeft3 = new Animation(left3, duration, false);
    movingLeft4 = new Animation(left4, duration, false);
    movingLeft5 = new Animation(left5, duration, false);
    movingRight1 = new Animation(right1, duration, false);
    movingRight2 = new Animation(right2, duration, false);
    movingRight3 = new Animation(right3, duration, false);
    movingRight4 = new Animation(right4, duration, false);
    movingRight5 = new Animation(right5, duration, false);
    start = start3;
    bullets = bullets3;
    blueBoi = movingDown;
    
    
    
    redBullet1 = new Image("res/RedBullet.png");
    redBullet2 = new Image("res/RedBullet.png");
    redBullet3 = new Image("res/RedBullet.png");
    
    Image[] walkUpRed = {new Image("res/RedBoiBack.png"), new Image("res/RedBoiBack.png")};
    Image[] walkDownRed = {new Image("res/RedBoi.png"), new Image("res/RedBoi.png")};
    Image[] walkLeftRed = {new Image("res/RedBoiLeft.png"), new Image("res/RedBoiLeft.png")};
    Image[] walkRightRed = {new Image("res/RedBoiRight.png"), new Image("res/RedBoiRight.png")};
    Image[] gunWalkUpRed = {new Image("res/RedBoiBackGun.png"), new Image("res/RedBoiBackGun.png")};
    Image[] gunWalkDownRed = {new Image("res/RedBoiGun.png"), new Image("res/RedBoiGun.png")};
    Image[] gunWalkLeftRed = {new Image("res/RedBoiLeftGun.png"), new Image("res/RedBoiLeftGun.png")};
    Image[] gunWalkRightRed = {new Image("res/RedBoiRightGun.png"), new Image("res/RedBoiRightGun.png")};
    Image[] bulletsLeft0Red = {new Image("res/0BulletsLeftRed.png"), new Image("res/0BulletsLeftRed.png")};
    Image[] bulletsLeft1Red = {new Image("res/1BulletsLeftRed.png"), new Image("res/1BulletsLeftRed.png")};
    Image[] bulletsLeft2Red = {new Image("res/2BulletsLeftRed.png"), new Image("res/2BulletsLeftRed.png")};
    Image[] bulletsLeft3Red = {new Image("res/3BulletsLeftRed.png"), new Image("res/3BulletsLeftRed.png")};
    Image[] up1Red = {new Image("res/MovingUpRed1.png"), new Image("res/MovingUpRed1.png")};
    Image[] up2Red = {new Image("res/MovingUpRed2.png"), new Image("res/MovingUpRed2.png")};
    Image[] up3Red = {new Image("res/MovingUpRed3.png"), new Image("res/MovingUpRed3.png")};
    Image[] up4Red = {new Image("res/MovingUpRed4.png"), new Image("res/MovingUpRed4.png")};
    Image[] up5Red = {new Image("res/MovingUpRed5.png"), new Image("res/MovingUpRed5.png")};
    Image[] down1Red = {new Image("res/MovingDownRed1.png"), new Image("res/MovingDownRed1.png")};
    Image[] down2Red = {new Image("res/MovingDownRed2.png"), new Image("res/MovingDownRed2.png")};
    Image[] down3Red = {new Image("res/MovingDownRed3.png"), new Image("res/MovingDownRed3.png")};
    Image[] down4Red = {new Image("res/MovingDownRed4.png"), new Image("res/MovingDownRed4.png")};
    Image[] down5Red = {new Image("res/MovingDownRed5.png"), new Image("res/MovingDownRed5.png")};
    Image[] left1Red = {new Image("res/MovingLeftRed1.png"), new Image("res/MovingLeftRed1.png")};
    Image[] left2Red = {new Image("res/MovingLeftRed2.png"), new Image("res/MovingLeftRed2.png")};
    Image[] left3Red = {new Image("res/MovingLeftRed3.png"), new Image("res/MovingLeftRed3.png")};
    Image[] left4Red = {new Image("res/MovingLeftRed4.png"), new Image("res/MovingLeftRed4.png")};
    Image[] left5Red = {new Image("res/MovingLeftRed5.png"), new Image("res/MovingLeftRed5.png")};
    Image[] right1Red = {new Image("res/MovingRightRed1.png"), new Image("res/MovingRightRed1.png")};
    Image[] right2Red = {new Image("res/MovingRightRed2.png"), new Image("res/MovingRightRed2.png")};
    Image[] right3Red = {new Image("res/MovingRightRed3.png"), new Image("res/MovingRightRed3.png")};
    Image[] right4Red = {new Image("res/MovingRightRed4.png"), new Image("res/MovingRightRed4.png")};
    Image[] right5Red = {new Image("res/MovingRightRed5.png"), new Image("res/MovingRightRed5.png")};
    
    movingUpRed = new Animation(walkUpRed, duration, false);
    movingDownRed = new Animation(walkDownRed, duration, false);
    movingLeftRed = new Animation(walkLeftRed, duration, false);
    movingRightRed = new Animation(walkRightRed, duration, false);
    gunMovingUpRed = new Animation(gunWalkUpRed, duration, false);
    gunMovingDownRed = new Animation(gunWalkDownRed, duration, false);
    gunMovingLeftRed = new Animation(gunWalkLeftRed, duration, false);
    gunMovingRightRed = new Animation(gunWalkRightRed, duration, false);
    bullets0Red = new Animation(bulletsLeft0Red, duration, false);
    bullets1Red = new Animation(bulletsLeft1Red, duration, false);
    bullets2Red = new Animation(bulletsLeft2Red, duration, false);
    bullets3Red = new Animation(bulletsLeft3Red, duration, false);
    movingUpRed1 = new Animation(up1Red, duration, false);
    movingUpRed2 = new Animation(up2Red, duration, false);
    movingUpRed3 = new Animation(up3Red, duration, false);
    movingUpRed4 = new Animation(up4Red, duration, false);
    movingUpRed5 = new Animation(up5Red, duration, false);
    movingDownRed1 = new Animation(down1Red, duration, false);
    movingDownRed2 = new Animation(down2Red, duration, false);
    movingDownRed3 = new Animation(down3Red, duration, false);
    movingDownRed4 = new Animation(down4Red, duration, false);
    movingDownRed5 = new Animation(down5Red, duration, false);
    movingLeftRed1 = new Animation(left1Red, duration, false);
    movingLeftRed2 = new Animation(left2Red, duration, false);
    movingLeftRed3 = new Animation(left3Red, duration, false);
    movingLeftRed4 = new Animation(left4Red, duration, false);
    movingLeftRed5 = new Animation(left5Red, duration, false);
    movingRightRed1 = new Animation(right1Red, duration, false);
    movingRightRed2 = new Animation(right2Red, duration, false);
    movingRightRed3 = new Animation(right3Red, duration, false);
    movingRightRed4 = new Animation(right4Red, duration, false);
    movingRightRed5 = new Animation(right5Red, duration, false);
    bulletsRed = bullets3Red;
    redBoi = movingDownRed;
    
    startingTime = System.currentTimeMillis();
  }
  
  public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
  {
    
    if(veryBeginning)
    {
      startingTime = System.currentTimeMillis();
      starting = true;
      veryBeginning = false;
    }
    worldMap.draw(0, 0);
    blueBoi.draw(blueBoiPositionX, blueBoiPositionY);
    bullets.draw(1680, 55);
    
    if(quit == true)
    {
      resumeButton.draw(705, 350);
      menuButton.draw(725, 450);
      exitButton.draw(755, 550);
      if(quit == false)
      {
        resumeButton.destroy();
        menuButton.destroy();
        exitButton.destroy();
      }
    }
    
    if(triggerPulled == true)
    {
      if(trigger1Pulled == true)
      {
        bullets = bullets2;
        blueBullet1.draw(blueBullet1PositionX, blueBullet1PositionY);
      }
      if(trigger2Pulled == true)
      {
        bullets = bullets1;
        blueBullet2.draw(blueBullet2PositionX, blueBullet2PositionY);
      }
      if(trigger3Pulled == true)
      {
        bullets = bullets0;
        blueBullet3.draw(blueBullet3PositionX, blueBullet3PositionY);
      }
      if(trigger3Pulled == false && trigger2Pulled == false && trigger1Pulled == false)
      {
        bullets = bullets3;
      }
    }
    
    if(touchingRedBullet1)
    {
      redBullet1PositionX = 1799;
      redBullet1PositionY = 0;
      touchingRedBullet1 = false;
    }
    
    if(touchingRedBullet2)
    {
      redBullet2PositionX = 1799;
      redBullet2PositionY = 0;
      touchingRedBullet2 = false;
    }
    
    if(touchingRedBullet3)
    {
      redBullet3PositionX = 1799;
      redBullet3PositionY = 0;
      touchingRedBullet3 = false;
    }
    
//redBoi    
//    
    redBoi.draw(redBoiPositionX, redBoiPositionY);
    bulletsRed.draw(70,55);
    
    if(triggerPulledRed == true)
    {
      if(trigger1PulledRed == true)
      {
        bulletsRed = bullets2Red;
        redBullet1.draw(redBullet1PositionX, redBullet1PositionY);
      }
      if(trigger2PulledRed == true)
      {
        bulletsRed = bullets1Red;
        redBullet2.draw(redBullet2PositionX, redBullet2PositionY);
      }
      if(trigger3PulledRed == true)
      {
        bulletsRed = bullets0Red;
        redBullet3.draw(redBullet3PositionX, redBullet3PositionY);
      }
      if(trigger3PulledRed == false && trigger2PulledRed == false && trigger1PulledRed == false)
      {
        bulletsRed = bullets3Red;
      }
    }
    
    if(touchingBlueBullet1)
    {
      blueBullet1PositionX = 1;
      blueBullet1PositionY = 0;
      touchingBlueBullet1 = false;
    }
    
    if(touchingBlueBullet2)
    {
      blueBullet2PositionX = 1;
      blueBullet2PositionY = 0;
      touchingBlueBullet2 = false;
    }
    
    if(touchingBlueBullet3)
    {
      blueBullet3PositionX = 1;
      blueBullet3PositionY = 0;
      touchingBlueBullet3 = false;
    }
    
    if(starting)
    {
      int startX = 0;
      if(start == startGo)
      {
        startX = 735;
      }
      else
      {
        startX = 810;
      }
      start.draw(startX, 340);
    }
  }
  
  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
  {
    Input input = gc.getInput();
    mousePosX = Mouse.getX();
    mousePosY = Mouse.getY();
    totalTime = System.currentTimeMillis() - startingTime;
    
    if(quit == false && starting == false)
    {
      if(input.isKeyDown(Input.KEY_UP) && gunOut == false)
      {
        direction = 0;
        blueBoi = movingUp;
        blueBoiPositionY -= delta * speedFactor;
        if(blueBoiPositionY < 20)
        {
          blueBoiPositionY += delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_UP) && gunOut == true)
      {
        direction = 0;
        if(remainingLives == 12 || remainingLives == 11)
        {
          blueBoi = gunMovingUp;
        }
        if(remainingLives == 10 || remainingLives == 9)
        {
          blueBoi = movingUp1;
        }
        if(remainingLives == 8 || remainingLives == 7)
        {
          blueBoi = movingUp2;
        }
        if(remainingLives == 6 || remainingLives == 5)
        {
          blueBoi = movingUp3;
        }
        if(remainingLives == 4 || remainingLives == 3)
        {
          blueBoi = movingUp4;
        }
        if(remainingLives == 2 || remainingLives == 1)
        {
          blueBoi = movingUp5;
        }
        blueBoiPositionY -= delta * speedFactor;
        if(blueBoiPositionY < 20)
        {
          blueBoiPositionY += delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_DOWN) && gunOut == false)
      {
        direction = 1;
        blueBoi = movingDown;
        blueBoiPositionY += delta * speedFactor;
        if(blueBoiPositionY > 720)
        {
          blueBoiPositionY -= delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_DOWN) && gunOut == true)
      {
        direction = 1;
        if(remainingLives == 12 || remainingLives == 11)
        {
          blueBoi = gunMovingDown;
        }
        if(remainingLives == 10 || remainingLives == 9)
        {
          blueBoi = movingDown1;
        }
        if(remainingLives == 8 || remainingLives == 7)
        {
          blueBoi = movingDown2;
        }
        if(remainingLives == 6 || remainingLives == 5)
        {
          blueBoi = movingDown3;
        }
        if(remainingLives == 4 || remainingLives == 3)
        {
          blueBoi = movingDown4;
        }
        if(remainingLives == 2 || remainingLives == 1)
        {
          blueBoi = movingDown5;
        }
        blueBoiPositionY += delta * speedFactor;
        if(blueBoiPositionY > 720)
        {
          blueBoiPositionY -= delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_LEFT) && gunOut == false)
      {
        direction = 2;
        blueBoi = movingLeft;
        blueBoiPositionX -= delta * speedFactor;
        if(blueBoiPositionX < 880)
        {
          blueBoiPositionX += delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_LEFT) && gunOut == true)
      {
        direction = 2;
        if(remainingLives == 12 || remainingLives == 11)
        {
          blueBoi = gunMovingLeft;
        }
        if(remainingLives == 10 || remainingLives == 9)
        {
          blueBoi = movingLeft1;
        }
        if(remainingLives == 8 || remainingLives == 7)
        {
          blueBoi = movingLeft2;
        }
        if(remainingLives == 6 || remainingLives == 5)
        {
          blueBoi = movingLeft3;
        }
        if(remainingLives == 4 || remainingLives == 3)
        {
          blueBoi = movingLeft4;
        }
        if(remainingLives == 2 || remainingLives == 1)
        {
          blueBoi = movingLeft5;
        }
        blueBoiPositionX -= delta * speedFactor;
        if(blueBoiPositionX < 880)
        {
          blueBoiPositionX += delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_RIGHT) && gunOut == false)
      {
        direction = 3;
        blueBoi = movingRight;
        blueBoiPositionX += delta * speedFactor;
        if(blueBoiPositionX > 1670)
        {
          blueBoiPositionX -= delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_RIGHT) && gunOut == true)
      {
        direction = 3;
        if(remainingLives == 12 || remainingLives == 11)
        {
          blueBoi = gunMovingRight;
        }
        if(remainingLives == 10 || remainingLives == 9)
        {
          blueBoi = movingRight1;
        }
        if(remainingLives == 8 || remainingLives == 7)
        {
          blueBoi = movingRight2;
        }
        if(remainingLives == 6 || remainingLives == 5)
        {
          blueBoi = movingRight3;
        }
        if(remainingLives == 4 || remainingLives == 3)
        {
          blueBoi = movingRight4;
        }
        if(remainingLives == 2 || remainingLives == 1)
        {
          blueBoi = movingRight5;
        }
        blueBoiPositionX += delta * speedFactor;
        if(blueBoiPositionX > 1670)
        {
          blueBoiPositionX -= delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_PERIOD))
      {
        gunOut = true;
      }
      
      
      if(input.isKeyPressed(Input.KEY_SLASH) && gunOut == true)
      {
        System.out.println("key pressed");
        if(trigger3Pulled == false)
        {
          if(direction == 0 && triggerPulledCount % 3 == 0)
          {
            blueBullet1PositionX = blueBoiPositionX;
            blueBullet1PositionY = blueBoiPositionY + 70;
            trigger1Pulled = true;
            blueBoi1 = blueBoi;
            direction1 = direction;
          }
          if (direction == 0 && triggerPulledCount % 3 == 1)
          {
            blueBullet2PositionX = blueBoiPositionX;
            blueBullet2PositionY = blueBoiPositionY + 70;
            trigger2Pulled = true;
            blueBoi2 = blueBoi;
            direction2 = direction;
          }
          if (direction == 0 && triggerPulledCount % 3 == 2)
          {
            blueBullet3PositionX = blueBoiPositionX;
            blueBullet3PositionY = blueBoiPositionY + 70;
            trigger3Pulled = true;
            blueBoi3 = blueBoi;
            direction3 = direction;
          }
          
          if(direction == 1 && triggerPulledCount % 3 == 0)
          {
            blueBullet1PositionX = blueBoiPositionX + 100;
            blueBullet1PositionY = blueBoiPositionY + 70;
            trigger1Pulled = true;
            blueBoi1 = blueBoi;
            direction1 = direction;
          }
          if (direction == 1 && triggerPulledCount % 3 == 1)
          {
            blueBullet2PositionX = blueBoiPositionX + 100;
            blueBullet2PositionY = blueBoiPositionY + 70;
            trigger2Pulled = true;
            blueBoi2 = blueBoi;
            direction2 = direction;
          }
          if (direction == 1 && triggerPulledCount % 3 == 2)
          {
            blueBullet3PositionX = blueBoiPositionX + 100;
            blueBullet3PositionY = blueBoiPositionY + 70;
            trigger3Pulled = true;
            blueBoi3 = blueBoi;
            direction3 = direction;
          }
          
          if(direction == 2 && triggerPulledCount % 3 == 0)
          {
            blueBullet1PositionX = blueBoiPositionX - 20;
            blueBullet1PositionY = blueBoiPositionY + 70;
            trigger1Pulled = true;
            blueBoi1 = blueBoi;
            direction1 = direction;
          }
          if (direction == 2 && triggerPulledCount % 3 == 1)
          {
            blueBullet2PositionX = blueBoiPositionX - 20;
            blueBullet2PositionY = blueBoiPositionY + 70;
            trigger2Pulled = true;
            blueBoi2 = blueBoi;
            direction2 = direction;
          }
          if (direction == 2 && triggerPulledCount % 3 == 2)
          {
            blueBullet3PositionX = blueBoiPositionX - 20;
            blueBullet3PositionY = blueBoiPositionY + 70;
            trigger3Pulled = true;
            blueBoi3 = blueBoi;
            direction3 = direction;
          }
          
          if(direction == 3 && triggerPulledCount % 3 == 0)
          {
            blueBullet1PositionX = blueBoiPositionX + 120;
            blueBullet1PositionY = blueBoiPositionY + 70;
            trigger1Pulled = true;
            blueBoi1 = blueBoi;
            direction1 = direction;
          }
          if (direction == 3 && triggerPulledCount % 3 == 1)
          {
            blueBullet2PositionX = blueBoiPositionX + 120;
            blueBullet2PositionY = blueBoiPositionY + 70;
            trigger2Pulled = true;
            blueBoi2 = blueBoi;
            direction2 = direction;
          }
          if (direction == 3 && triggerPulledCount % 3 == 2)
          {
            blueBullet3PositionX = blueBoiPositionX + 120;
            blueBullet3PositionY = blueBoiPositionY + 70;
            trigger3Pulled = true;
            blueBoi3 = blueBoi;
            direction3 = direction;
          }
          triggerPulledCount++;
          triggerPulled = true;
        }
        else if(trigger3Pulled == true)
        {
          System.out.println("reloading...");
        } 
      }
      else if(triggerPulled == true)
      {
        if(direction1 == 0 && blueBullet1PositionY > 0 && trigger1Pulled == true)
        {
          blueBullet1PositionY -= delta * bulletSpeedFactor;
        }
        else if(direction1 == 0 && blueBullet1PositionY < 0 && trigger1Pulled == true)
        {
          trigger1Pulled = false;
        }
        
        if(direction2 == 0 && blueBullet2PositionY > 0 && trigger2Pulled == true)
        {
          blueBullet2PositionY -= delta * bulletSpeedFactor;
        }
        else if(direction2 == 0 && blueBullet2PositionY < 0 && trigger2Pulled == true)
        {
          trigger2Pulled = false;
        }
        
        if(direction3 == 0 && blueBullet3PositionY > 0 && trigger3Pulled == true)
        {
          blueBullet3PositionY -= delta * bulletSpeedFactor;
        }
        else if(direction3 == 0 && blueBullet3PositionY < 0 && trigger3Pulled == true)
        {
          trigger3Pulled = false;
        }
        
        
        
        if(direction1 == 1 && blueBullet1PositionY < 950 && trigger1Pulled == true)
        {
          blueBullet1PositionY += delta * bulletSpeedFactor;
        }
        else if(direction1 == 1 && blueBullet1PositionY > 950 && trigger1Pulled == true)
        {
          trigger1Pulled = false;
        }
        
        if(direction2 == 1 && blueBullet2PositionY < 950 && trigger2Pulled == true)
        {
          blueBullet2PositionY += delta * bulletSpeedFactor;
        }
        else if(direction2 == 1 && blueBullet2PositionY > 950 && trigger2Pulled == true)
        {
          trigger2Pulled = false;
        }
        
        if(direction3 == 1 && blueBullet3PositionY < 950 && trigger3Pulled == true)
        {
          blueBullet3PositionY += delta * bulletSpeedFactor;
        }
        else if(direction3 == 1 && blueBullet3PositionY > 950 && trigger3Pulled == true)
        {
          trigger3Pulled = false;
        }
        
        
        
        if(direction1 == 2 && blueBullet1PositionX > 0 && trigger1Pulled == true)
        {
          blueBullet1PositionX -= delta * bulletSpeedFactor;
        }
        else if(direction1 == 2 && blueBullet1PositionX < 0 && trigger1Pulled == true)
        {
          trigger1Pulled = false;
        }
        
        if(direction2 == 2 && blueBullet2PositionX > 0 && trigger2Pulled == true)
        {
          blueBullet2PositionX -= delta * bulletSpeedFactor;
        }
        else if(direction2 == 2 && blueBullet2PositionX < 0 && trigger2Pulled == true)
        {
          trigger2Pulled = false;
        }
        
        if(direction3 == 2 && blueBullet3PositionX > 0 && trigger3Pulled == true)
        {
          blueBullet3PositionX -= delta * bulletSpeedFactor;
        }
        else if(direction3 == 2 && blueBullet3PositionX < 0 && trigger3Pulled == true)
        {
          trigger3Pulled = false;
        }
        
        
        
        if(direction1 == 3 && blueBullet1PositionX < 1800 && trigger1Pulled == true)
        {
          blueBullet1PositionX += delta * bulletSpeedFactor;
        }
        else if(direction1 == 3 && blueBullet1PositionX > 1800 && trigger1Pulled == true)
        {
          trigger1Pulled = false;
        }
        
        if(direction2 == 3 && blueBullet2PositionX < 1800 && trigger2Pulled == true)
        {
          blueBullet2PositionX += delta * bulletSpeedFactor;
        }
        else if(direction2 == 3 && blueBullet2PositionX > 1800 && trigger2Pulled == true)
        {
          trigger2Pulled = false;
        }
        
        if(direction3 == 3 && blueBullet3PositionX < 1800 && trigger3Pulled == true)
        {
          blueBullet3PositionX += delta * bulletSpeedFactor;
        }
        else if(direction3 == 3 && blueBullet3PositionX > 1800 && trigger3Pulled == true)
        {
          trigger3Pulled = false;
        }
      }
      
      
      
      
      
      
      if(redBullet1PositionX > blueBoiPositionX + 10 && redBullet1PositionX < blueBoiPositionX + 120)
      {
        if(redBullet1PositionY > blueBoiPositionY + 10 && redBullet1PositionY < blueBoiPositionY + 200)
        {
          remainingLives--;
          touchingRedBullet1 = true;
        }
      }
      
      if(redBullet2PositionX > blueBoiPositionX + 10 && redBullet2PositionX < blueBoiPositionX + 120)
      {
        if(redBullet2PositionY > blueBoiPositionY + 10 && redBullet2PositionY < blueBoiPositionY + 200)
        {
          remainingLives--;
          touchingRedBullet2 = true;
        }
      }
      
      if(redBullet3PositionX > blueBoiPositionX + 10 && redBullet3PositionX < blueBoiPositionX + 120)
      {
        if(redBullet3PositionY > blueBoiPositionY + 10 && redBullet3PositionY < blueBoiPositionY + 200)
        {
          remainingLives--;
          touchingRedBullet3 = true;
        }
      }
      
      
    }
    
//redBoi    
    
    
    if(quit == false && starting == false)
    {
      if(input.isKeyDown(Input.KEY_W) && gunOutRed == false)
      {
        directionRed = 0;
        redBoi = movingUpRed;
        redBoiPositionY -= delta * speedFactor;
        if(redBoiPositionY < 20)
        {
          redBoiPositionY += delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_W) && gunOutRed == true)
      {
        directionRed = 0;
        if(remainingLivesRed == 12 || remainingLivesRed == 11)
        {
          redBoi = gunMovingUpRed;
        }
        if(remainingLivesRed == 10 || remainingLivesRed == 9)
        {
          redBoi = movingUpRed1;
        }
        if(remainingLivesRed == 8 || remainingLivesRed == 7)
        {
          redBoi = movingUpRed2;
        }
        if(remainingLivesRed == 6 || remainingLivesRed == 5)
        {
          redBoi = movingUpRed3;
        }
        if(remainingLivesRed == 4 || remainingLivesRed == 3)
        {
          redBoi = movingUpRed4;
        }
        if(remainingLivesRed == 2 || remainingLivesRed == 1)
        {
          redBoi = movingUpRed5;
        }
        redBoiPositionY -= delta * speedFactor;
        if(redBoiPositionY < 20)
        {
          redBoiPositionY += delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_S) && gunOutRed == false)
      {
        directionRed = 1;
        redBoi = movingDownRed;
        redBoiPositionY += delta * speedFactor;
        if(redBoiPositionY > 720)
        {
          redBoiPositionY -= delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_S) && gunOutRed == true)
      {
        directionRed = 1;
        if(remainingLivesRed == 12 || remainingLivesRed == 11)
        {
          redBoi = gunMovingDownRed;
        }
        if(remainingLivesRed == 10 || remainingLivesRed == 9)
        {
          redBoi = movingDownRed1;
        }
        if(remainingLivesRed == 8 || remainingLivesRed == 7)
        {
          redBoi = movingDownRed2;
        }
        if(remainingLivesRed == 6 || remainingLivesRed == 5)
        {
          redBoi = movingDownRed3;
        }
        if(remainingLivesRed == 4 || remainingLivesRed == 3)
        {
          redBoi = movingDownRed4;
        }
        if(remainingLivesRed == 2 || remainingLivesRed == 1)
        {
          redBoi = movingDownRed5;
        }
        redBoiPositionY += delta * speedFactor;
        if(redBoiPositionY > 720)
        {
          redBoiPositionY -= delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_A) && gunOutRed == false)
      {
        directionRed = 2;
        redBoi = movingLeftRed;
        redBoiPositionX -= delta * speedFactor;
        if(redBoiPositionX < 0)
        {
          redBoiPositionX += delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_A) && gunOutRed == true)
      {
        directionRed = 2;
        if(remainingLivesRed == 12  || remainingLivesRed == 11)
        {
          redBoi = gunMovingLeftRed;
        }
        if(remainingLivesRed == 10 || remainingLivesRed == 9)
        {
          redBoi = movingLeftRed1;
        }
        if(remainingLivesRed == 8 || remainingLivesRed == 7)
        {
          redBoi = movingLeftRed2;
        }
        if(remainingLivesRed == 6 || remainingLivesRed == 5)
        {
          redBoi = movingLeftRed3;
        }
        if(remainingLivesRed == 4 || remainingLivesRed == 3)
        {
          redBoi = movingLeftRed4;
        }
        if(remainingLivesRed == 2 || remainingLivesRed == 1)
        {
          redBoi = movingLeftRed5;
        }
        redBoiPositionX -= delta * speedFactor;
        if(redBoiPositionX < 0)
        {
          redBoiPositionX += delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_D) && gunOutRed == false)
      {
        directionRed = 3;
        redBoi = movingRightRed;
        redBoiPositionX += delta * speedFactor;
        if(redBoiPositionX > 800)
        {
          redBoiPositionX -= delta * speedFactor;
        }
      }
      else if(input.isKeyDown(Input.KEY_D) && gunOutRed == true)
      {
        directionRed = 3;
        if(remainingLivesRed == 12 || remainingLivesRed == 11)
        {
          redBoi = gunMovingRightRed;
        }
        if(remainingLivesRed == 10 || remainingLivesRed == 9)
        {
          redBoi = movingRightRed1;
        }
        if(remainingLivesRed == 8 || remainingLivesRed == 7)
        {
          redBoi = movingRightRed2;
        }
        if(remainingLivesRed == 6 || remainingLivesRed == 5)
        {
          redBoi = movingRightRed3;
        }
        if(remainingLivesRed == 4 || remainingLivesRed == 3)
        {
          redBoi = movingRightRed4;
        }
        if(remainingLivesRed == 2 || remainingLivesRed == 1)
        {
          redBoi = movingRightRed5;
        }
        redBoiPositionX += delta * speedFactor;
        if(redBoiPositionX > 800)
        {
          redBoiPositionX -= delta * speedFactor;
        }
      }
      
      if(input.isKeyDown(Input.KEY_F))
      {
        gunOutRed = true;
      }
      
      if(input.isKeyPressed(Input.KEY_SPACE) && gunOutRed == true)
      {
        System.out.println("key pressed (red)");
        if(trigger3PulledRed == false)
        {
          if(directionRed == 0 && triggerPulledCountRed % 3 == 0)
          {
            redBullet1PositionX = redBoiPositionX;
            redBullet1PositionY = redBoiPositionY + 70;
            trigger1PulledRed = true;
            redBoi1 = redBoi;
            directionRed1 = directionRed;
          }
          if (directionRed == 0 && triggerPulledCountRed % 3 == 1)
          {
            redBullet2PositionX = redBoiPositionX;
            redBullet2PositionY = redBoiPositionY + 70;
            trigger2PulledRed = true;
            redBoi2 = redBoi;
            directionRed2 = directionRed;
          }
          if (directionRed == 0 && triggerPulledCountRed % 3 == 2)
          {
            redBullet3PositionX = redBoiPositionX;
            redBullet3PositionY = redBoiPositionY + 70;
            trigger3PulledRed = true;
            redBoi3 = redBoi;
            directionRed3 = directionRed;
          }
          
          if(directionRed == 1 && triggerPulledCountRed % 3 == 0)
          {
            redBullet1PositionX = redBoiPositionX + 100;
            redBullet1PositionY = redBoiPositionY + 70;
            trigger1PulledRed = true;
            redBoi1 = redBoi;
            directionRed1 = directionRed;
          }
          if (directionRed == 1 && triggerPulledCountRed % 3 == 1)
          {
            redBullet2PositionX = redBoiPositionX + 100;
            redBullet2PositionY = redBoiPositionY + 70;
            trigger2PulledRed = true;
            redBoi2 = redBoi;
            directionRed2 = directionRed;
          }
          if (directionRed == 1 && triggerPulledCountRed % 3 == 2)
          {
            redBullet3PositionX = redBoiPositionX + 100;
            redBullet3PositionY = redBoiPositionY + 70;
            trigger3PulledRed = true;
            redBoi3 = redBoi;
            directionRed3 = directionRed;
          }
          
          if(directionRed == 2 && triggerPulledCountRed % 3 == 0)
          {
            redBullet1PositionX = redBoiPositionX - 20;
            redBullet1PositionY = redBoiPositionY + 70;
            trigger1PulledRed = true;
            redBoi1 = redBoi;
            directionRed1 = directionRed;
          }
          if (directionRed == 2 && triggerPulledCountRed % 3 == 1)
          {
            redBullet2PositionX = redBoiPositionX - 20;
            redBullet2PositionY = redBoiPositionY + 70;
            trigger2PulledRed = true;
            redBoi2 = redBoi;
            directionRed2 = directionRed;
          }
          if (directionRed == 2 && triggerPulledCountRed % 3 == 2)
          {
            redBullet3PositionX = redBoiPositionX - 20;
            redBullet3PositionY = redBoiPositionY + 70;
            trigger3PulledRed = true;
            redBoi3 = redBoi;
            directionRed3 = directionRed;
          }
          
          if(directionRed == 3 && triggerPulledCountRed % 3 == 0)
          {
            redBullet1PositionX = redBoiPositionX + 120;
            redBullet1PositionY = redBoiPositionY + 70;
            trigger1PulledRed = true;
            redBoi1 = redBoi;
            directionRed1 = directionRed;
          }
          if (directionRed == 3 && triggerPulledCountRed % 3 == 1)
          {
            redBullet2PositionX = redBoiPositionX + 120;
            redBullet2PositionY = redBoiPositionY + 70;
            trigger2PulledRed = true;
            redBoi2 = redBoi;
            directionRed2 = directionRed;
          }
          if (directionRed == 3 && triggerPulledCountRed % 3 == 2)
          {
            redBullet3PositionX = redBoiPositionX + 120;
            redBullet3PositionY = redBoiPositionY + 70;
            trigger3PulledRed = true;
            redBoi3 = redBoi;
            directionRed3 = directionRed;
          }
          triggerPulledCountRed++;
          triggerPulledRed = true;
        }
        else if(trigger3PulledRed == true)
        {
          System.out.println("reloading (red)...");
        }
      }
      else if(triggerPulledRed == true)
      {
        if(directionRed1 == 0 && redBullet1PositionY > 0 && trigger1PulledRed == true)
        {
          redBullet1PositionY -= delta * bulletSpeedFactor;
        }
        else if(directionRed1 == 0 && redBullet1PositionY < 0 && trigger1PulledRed == true)
        {
          trigger1PulledRed = false;
        }
        
        if(directionRed2 == 0 && redBullet2PositionY > 0 && trigger2PulledRed == true)
        {
          redBullet2PositionY -= delta * bulletSpeedFactor;
        }
        else if(directionRed2 == 0 && redBullet2PositionY < 0 && trigger2PulledRed == true)
        {
          trigger2PulledRed = false;
        }
        
        if(directionRed3 == 0 && redBullet3PositionY > 0 && trigger3PulledRed == true)
        {
          redBullet3PositionY -= delta * bulletSpeedFactor;
        }
        else if(directionRed3 == 0 && redBullet3PositionY < 0 && trigger3PulledRed == true)
        {
          trigger3PulledRed = false;
        }
        
        
        if(directionRed1 == 1 && redBullet1PositionY < 950 && trigger1PulledRed == true)
        {
          redBullet1PositionY += delta * bulletSpeedFactor;
        }
        else if(directionRed1 == 1 && redBullet1PositionY > 950 && trigger1PulledRed == true)
        {
          trigger1PulledRed = false;
        }
        
        if(directionRed2 == 1 && redBullet2PositionY < 950 && trigger2PulledRed == true)
        {
          redBullet2PositionY += delta * bulletSpeedFactor;
        }
        else if(directionRed2 == 1 && redBullet2PositionY > 950 && trigger2PulledRed == true)
        {
          trigger2PulledRed = false;
        }
        
        if(directionRed3 == 1 && redBullet3PositionY < 950 && trigger3PulledRed == true)
        {
          redBullet3PositionY += delta * bulletSpeedFactor;
        }
        else if(directionRed3 == 1 && redBullet3PositionY > 950 && trigger3PulledRed == true)
        {
          trigger3PulledRed = false;
        }
        
        
        
        if(directionRed1 == 2 && redBullet1PositionX > 0 && trigger1PulledRed == true)
        {
          redBullet1PositionX -= delta * bulletSpeedFactor;
        }
        else if(directionRed1 == 2 && redBullet1PositionX < 0 && trigger1PulledRed == true)
        {
          trigger1PulledRed = false;
        }
        
        if(directionRed2 == 2 && redBullet2PositionX > 0 && trigger2PulledRed == true)
        {
          redBullet2PositionX -= delta * bulletSpeedFactor;
        }
        else if(directionRed2 == 2 && redBullet2PositionX < 0 && trigger2PulledRed == true)
        {
          trigger2PulledRed = false;
        }
        
        if(directionRed3 == 2 && redBullet3PositionX > 0 && trigger3PulledRed == true)
        {
          redBullet3PositionX -= delta * bulletSpeedFactor;
        }
        else if(directionRed3 == 2 && redBullet3PositionX < 0 && trigger3PulledRed == true)
        {
          trigger3PulledRed = false;
        }
        
        
        
        if(directionRed1 == 3 && redBullet1PositionX < 1800 && trigger1PulledRed == true)
        {
          redBullet1PositionX += delta * bulletSpeedFactor;
        }
        else if(directionRed1 == 3 && redBullet1PositionX > 1800 && trigger1PulledRed == true)
        {
          trigger1PulledRed = false;
        }
        
        if(directionRed2 == 3 && redBullet2PositionX < 1800 && trigger2PulledRed == true)
        {
          redBullet2PositionX += delta * bulletSpeedFactor;
        }
        else if(directionRed2 == 3 && redBullet2PositionX > 1800 && trigger2PulledRed == true)
        {
          trigger2PulledRed = false;
        }
        
        if(directionRed3 == 3 && redBullet3PositionX < 1800 && trigger3PulledRed == true)
        {
          redBullet3PositionX += delta * bulletSpeedFactor;
        }
        else if(directionRed3 == 3 && redBullet3PositionX > 1800 && trigger3PulledRed == true)
        {
          trigger3PulledRed = false;
        }
      }
      
      
      
      
      
      if(blueBullet1PositionX > redBoiPositionX + 10 && blueBullet1PositionX < redBoiPositionX + 120)
      {
        if(blueBullet1PositionY > redBoiPositionY + 10 && blueBullet1PositionY < redBoiPositionY + 200)
        {
          remainingLivesRed--;
          touchingBlueBullet1 = true;
        }
      }
      
      if(blueBullet2PositionX > redBoiPositionX + 10 && blueBullet2PositionX < redBoiPositionX + 120)
      {
        if(blueBullet2PositionY > redBoiPositionY + 10 && blueBullet2PositionY < redBoiPositionY + 200)
        {
          remainingLivesRed--;
          touchingBlueBullet2 = true;
        }
      }
      
      if(blueBullet3PositionX > redBoiPositionX + 10 && blueBullet3PositionX < redBoiPositionX + 120)
      {
        if(blueBullet3PositionY > redBoiPositionY + 10 && blueBullet3PositionY < redBoiPositionY + 200)
        {
          remainingLivesRed--;
          touchingBlueBullet3 = true;
        }
      }
    }
    
    if(totalTime > 0 && totalTime < 1000)
    {
      start = start3;
    }
    
    if(totalTime > 1000 && totalTime < 2000)
    {
      start = start2;
    }
    
    if(totalTime > 2000 && totalTime < 3000)
    {
      start = start1;
    }
    
    if(totalTime > 3000 && totalTime < 4000)
    {
      start = startGo;
    }
    
    if(totalTime > 4000)
    {
      starting = false;
      gunOut = true;
      gunOutRed = true;
    }
    
    if(remainingLivesRed <= 0)
    {
      sbg.enterState(3);
    }
    
    if(remainingLives <= 0)
    {
      sbg.enterState(4);
    }
    
    if(input.isKeyDown(Input.KEY_ESCAPE))
    {
      quit = true;
    }
    
    if(quit == true)
    {
      if(input.isKeyDown(Input.KEY_R))
      {
        quit = false;
      }
      if(input.isKeyDown(Input.KEY_M))
      {
        quit = false;
        sbg.enterState(0);
      }
      if(input.isKeyDown(Input.KEY_E))
      {
        quit = false;
        System.exit(0);
      }
    }
  }
  
  public int getID()
  {
    return 1;
  }
}
