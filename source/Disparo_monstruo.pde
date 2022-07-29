void disparoMonstruo()
{
  if(fase3)
    {
      if(disparandoM == false)
      {
        proymonsX = monsX + monsWidth/2;
        proymonsY = monsY + monsHeight/2;
        if(monsX < playerX)
        {
          disparandoIzquierdaM = false;
          disparandoDerechaM = true;
        }
        else if(monsX > playerX)
        {
          disparandoDerechaM = false;
          disparandoIzquierdaM = true;
        }
        disparandoM = true;
      }
      if(disparandoM)
      {
        if(disparandoDerechaM)
        {
          proymonsX = proymonsX + 10;
          if(proymonsX > width)
          {
            disparandoDerechaM = false;
            disparandoIzquierdaM = false;
            disparandoM = false;
          }
        }
        if(disparandoIzquierdaM)
        {
          proymonsX = proymonsX - 10;
          if(proymonsX < 0)
          {
            disparandoDerechaM = false;
            disparandoIzquierdaM = false;
            disparandoM = false;
          }
        }
       
      }
      fill(255,0,0);
      stroke(255,0,0);
      ellipse(proymonsX, proymonsY, 5, 5);
    }
  }
