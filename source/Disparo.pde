void disparar()
{
  if(keys[4] == true & disparando == false)
  {
    proyectilX = playerX + playerWidth/2;
    proyectilY = playerY + playerHeight/2;
    disparando = true;
    if(mouseX > playerX)
    {
      disparandoIzquierda = false;
      disparandoDerecha = true;
    }
    else if(mouseX < playerX)
    {
      disparandoDerecha = false;
      disparandoIzquierda = true;
    }
  }
  if(disparando)
  {
    if(disparandoDerecha)
    {
      proyectilX = proyectilX + 10;
      if(proyectilX > width)
      {
        disparando = false;
        disparandoDerecha = false;
        disparandoIzquierda = false;
      }
    }
    if(disparandoIzquierda)
    {
      proyectilX = proyectilX - 10;
      if(proyectilX < 0)
      {
        disparando = false;
        disparandoDerecha = false;
        disparandoIzquierda = false;
      }
    }
    fill(255,255,0);
    stroke(255,255, 0);
    ellipse(proyectilX, proyectilY, 5, 5);
    
  }
}
