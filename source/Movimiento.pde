void movimiento()
{
  if(movimiento)
  {
  if(keys[0])
    {
      playerX += 10;
    }
  if(keys[1])
    {
      playerX -= 10;
    }
  if(keys[2] & saltando == false & abs(playerSpeedY) < 5)
    {
      playerSpeedY = -15;
      saltando = true;
    }
  }
}
