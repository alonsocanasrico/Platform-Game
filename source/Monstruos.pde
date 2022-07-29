void monstruos()
{
  if(haymonstruo)
    {
      monsX = rect4X + rect4Width/2;
      monsY = rect4Y - monsHeight;
      fill(255,0,0);
      stroke(255,0,0);
      rect(monsX, monsY, monsWidth, monsHeight);
    }
  if(haymonstruo == false)
    {
      monsX = playerX;
      monsY = -10000;
      if((proymonsX < 0) || (proymonsX > width))
      {
        proymonsX = -10000;
        proymonsY = -10000;
      }
      fill(255,0,0);
      stroke(255,0,0);
      rect(monsX, monsY, monsWidth, monsHeight);
    }
}
