void colision()
{
  if(playerY + playerHeight > sueloY )
    {
      playerY = sueloY - playerHeight;
      playerSpeedY = 0;
      saltando = false;
      gameover = true;
      
    }
    else if((playerY + playerHeight > rect1Y) & (playerY < rect1Y) & (playerX + 9*playerWidth/10 > rect1X) & (playerX + playerWidth/10 < rect1X + rect1Width))
    {
      playerY = rect1Y - playerHeight;
      playerSpeedY = 0;
      saltando = false;
    }
    else if((playerY + playerHeight > rect2Y) & (playerY < rect2Y) & (playerX + 9*playerWidth/10 > rect2X) & (playerX + playerWidth/10 < rect2X + rect2Width))
    {
      playerY = rect2Y - playerHeight;
      playerSpeedY = 0;
      saltando = false;
    }
    else if((playerY + playerHeight > rect3Y) & (playerY + playerHeight/4 < rect3Y) & (playerX + 9*playerWidth/10 > rect3X) & (playerX + playerWidth/10 < rect3X + rect3Width))
    {
      if(subir3)
      {
      playerY = rect3Y - playerHeight - 2.00000000000000000000000000000000001;
      }
      else if(bajar3)
      {
      playerY = rect3Y - playerHeight + 1.99999999999999999999999999999999999;
      }
      else
      {
      playerY = rect3Y - playerHeight;
      }
      playerSpeedY = 0;
      saltando = false;
    }
    else if((playerY + playerHeight > rect4Y) & (playerY + playerHeight/4 < rect4Y) & (playerX + 9*playerWidth/10 > rect4X) & (playerX  + playerWidth/10 < rect4X + rect4Width))
    {
      if(subir4)
      {
      playerY = rect4Y - playerHeight - 2.00000000000000000000000000000000001;
      }
      else if(bajar4)
      {
      playerY = rect4Y - playerHeight + 1.99999999999999999999999999999999999;
      }
      else
      {
        playerY = rect4Y - playerHeight;
      }
      playerSpeedY = 0;
      saltando = false;
    }
    else if((playerY + playerHeight > rectauxY) & (playerY + playerHeight/4 < rectauxY) & (playerX + 9*playerWidth/10 > rectauxX) & (playerX + playerWidth/10 < rectauxX + rectauxWidth))
    {
      playerY = rectauxY - playerHeight;
      playerSpeedY = 0;
      saltando = false;
    }
    else
    {
      playerSpeedY ++;
    }
    if((((playerX < monsX) & ((monsX - playerX) < playerWidth)) || ((playerX > monsX) & ((playerX - monsX) < monsWidth))) & (((playerY > monsY) & ((playerY - monsY) < monsHeight)) || ((monsY > playerY) & ((monsY - playerY) < playerHeight))))
    {
      gameover = true;
    }
    if((((proyectilX < monsX) & ((monsX - proyectilX) < 0)) || ((proyectilX > monsX) & ((proyectilX - monsX) < monsWidth))) & (proyectilY > monsY-2) & (proyectilY < monsY + monsHeight + 2))
    {
      haymonstruo = false;
    }
    if((((proymonsX < playerX) & ((playerX - proymonsX) < 0)) || ((proymonsX > playerX) & ((proymonsX - playerX) < playerWidth))) & (proymonsY > playerY-2) & (proymonsY < playerY +playerHeight + 2))
    {
      gameover = true;
    }
    if((((proymonsX < rectauxX) & ((rectauxX - proymonsX) < 0)) || ((proymonsX > rectauxX) & ((proymonsX - rectauxX) < rectauxWidth))) & (proymonsY > rectauxY-2) & (proymonsY < rectauxY +rectauxHeight + 2))
    {
      colisionaux = true;
      disparandoDerechaM = false;
      disparandoIzquierdaM = false;
      disparandoM = false;
      proymonsX = monsX + monsWidth/2;
      proymonsY = monsY + monsHeight/2;
    }
 
    
}
