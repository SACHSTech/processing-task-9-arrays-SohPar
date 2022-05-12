import processing.core.PApplet;

public class Sketch extends PApplet {

// Local Variables For The Snowfall
float[] circleY = new float[50];
float[] snow = new float[50];
float[] mousePositionsX = new float[25];
float[] mousePositionsY = new float[25];
int playerX = 0;
int playerY = 0;
int playerSpeed = 3;
int speed = 3;
int num = 25;
int index = 0;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(350, 350);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    for (int i = 0; i < 50; i++) {
      circleY[i] = random(height);
    }
    for (int i = 0; i < 50; i++) {
      snow[i] = 5;
    }
  }
    
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    background(0);

    fill(255);
    for (int circleX = 0; circleX < 50; circleX++) {
      ellipse(circleX*8, circleY[circleX], 20, 20);
    }

    for (int i = 0; i < 50; i++) {
      circleY[i] += speed;
      if (circleY[i] >= 400) {
        circleY[i] = 0;
        snow[i] += 5;
      }
    }

    for (int i = 0; i < 50; i++) {
      rect(i*8, 400-snow[i], 8, 400);
    }

    fill(15, 215, 250);
    ellipse(playerX, playerY, 20, 20);

}

  // Control Speed of SnowFall + Move the ball around the snowfall
  public void keyPressed() {
  if (keyCode == DOWN) {
      speed = 2;
  }
  if (keyCode == UP) {
      speed = 1;
  }
  if (key == 'w') {
    playerY -= playerSpeed;
  }
  if (key == 'a') {
    playerX -= playerSpeed;
  }
  if (key == 's') {
    playerY += playerSpeed;
  }
  if (key == 'd') {
    playerX += playerSpeed;
  }
}
}


