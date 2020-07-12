import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class starfield extends PApplet {

Star[] stars = new Star[1000];

public void setup(){
  //size(1000, 1000);
  
  for (int i = 0; i < stars.length; i++){
    stars[i] = new Star();
  }
}

public void draw(){
  background(0);
  translate(width/2, height/2);
  for (int i = 0; i< stars.length; i++){
    stars[i].update();
    stars[i].show();
  }
}
class Star {
  float x;
  float y;
  float z;
  
  float pz;

  Star() {
    y = random(-width, width);
    x = random(-height, height);
    z = random(width);
    pz = z;
  }

  public void update() {
    z = z - 5;
    if (z < 1) {
      y = random(-width, width);
      x = random(-height, height);
      z = width;
      pz = z;
      
    }
  }

  public void show() {
    fill(255);
    noStroke();

    float sx = map(x / z, 0, 1, 0, width);
    float sy = map(y / z, 0, 1, 0, height);

    float r = map(z, 0, width, 16, 0);
    ellipse(sx, sy, r, r);
    
    float px = map(x / pz, 0, 1, 0, width);
    float py = map(y / pz, 0, 1, 0, height);
    
    stroke(255);
    
    pz = z;
    
    line(px, py, sx, sy);
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
