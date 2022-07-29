void bordes()
{
  if(playerX < -50)
    {
      playerX = -49;
    }
    if(playerX > width)
    {
      haymonstruo = true;
     disparandoM = false;
      playerX = -50;
      puntuacion ++;
      a = 0;
      rect3Y = random(300,550);
      rect4Y = random(300,550);
      rect3X = random(275, 375);
      rect4X = random(575, 675);
      rect3Width = rect3Width - 5;
      rect4Width = rect4Width - 5;
      noelegido = true;
      pintar = true;
      rectauxX = -100000;
      rectauxY = -100000;
      x1 = -10000;
      y1 = -10000;
      x2 = -10000;
      y2 = -10000;
    }
}
