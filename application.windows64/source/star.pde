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

  void update() {
    z = z - 5;
    if (z < 1) {
      y = random(-width, width);
      x = random(-height, height);
      z = width;
      pz = z;
      
    }
  }

  void show() {
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
