void pintar()
{
  if(pintar)
  {
  if(mousePressed & mouseButton == LEFT & c2 == false)
  {
    x1 = mouseX;
    y1 = mouseY;
    c1 = true;
  }
  fill(255,255,0);
  stroke(255,255,0);
  ellipse(x1,y1,2,2);
  if(mousePressed & mouseButton == RIGHT & c1 == true & c2 == false & mouseY > y1 & mouseX > x1)
  {
    x2 = mouseX;
    y2 = mouseY;
    c2 = true;
  }
  fill(255,255,0);
  stroke(255,255,0);
  ellipse(x2,y2,2,2);
  if(c1 == true & c2 == true)
  {
    pintar = false; 
    c1 = false;
    c2 = false;
  }
  
  }
  if(pintar == false)
  {
    rectauxX = x1;
    rectauxY = y1;
    rectauxWidth = x2-x1;
    rectauxHeight = y2-y1;
    if(rectauxWidth > 120)
    {
      rectauxWidth = 120;
    }
    fill(255,255,0);
    stroke(255,255,0);
    rect(rectauxX,rectauxY, rectauxWidth, rectauxHeight);
    if(keys[3])
    {
      pintar = true;
      rectauxX = -100000;
      rectauxY = -100000;
      x1 = -10000;
      y1 = -10000;
      x2 = -10000;
      y2 = -10000;
    }
  }
}
