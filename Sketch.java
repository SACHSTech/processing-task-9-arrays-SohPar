import processing.core.PApplet;

public class Sketch extends PApplet {

// Local Variables For The Array
float[] circleY = new float[50];
float[] snow = new float[50];
float[] mousePositionsX = new float[25];
float[] mousePositionsY = new float[25];
int speed = 3;
int num = 25;
int index = 0;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
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

    background(19, 24, 98);

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
  fill(255, 255, 255);
  rect(i*8, 400-snow[i], 8, 400);
}

// Move the object around the snowfall with mouse
mousePositionsX[index] = mouseX;
mousePositionsY[index] = mouseY;
index = (index + 1) % num;
for (int i = 0; i < 25; i++) {
  int pos = (index + i) % num;
  ellipse(mousePositionsX[pos], mousePositionsY[pos], i, i);
  speed = 1;

}
}

  // Control Speed of The SnowFall
  public void keyPressed() {
    if (keyCode == DOWN) {
      speed = 5;
    }
    if (keyCode == UP) {
      speed = 1;
    }
  }
}

