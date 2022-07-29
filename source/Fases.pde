void fases()
{
  if(fase1)
    {
      if(noelegido)
      {
      switch(int(random(0,2)))
      {
        case 0: 
        subir3 = false;
        bajar3 = true;
        noelegido = false;
        break;
        case 1:
        bajar3 = false;
        subir3 = true;
        noelegido = false;
        break;
      }
      }
      
      if(subir3)
      {
        rect3Y = rect3Y - 2;
      }
      if(rect3Y < 200)
      {
        subir3 = false;
        bajar3 = true;
      }
      if(bajar3)
      {
        rect3Y = rect3Y + 2;
        if(rect3Y > sueloY-30)
        {
          bajar3 = false;
          subir3 = true;
        }
      }
    }
    
    if(fase2)
    {
      if(noelegido)
      {
        switch(int(random(0,2)))
        {
          case 0: 
          subir4 = false;
          bajar4 = true;
          noelegido = true;
          break;
          case 1:
          bajar4 = false;
          subir4 = true;
          noelegido = true;
          break;
        }
      }
      if(subir4)
      {
        rect4Y = rect4Y - 2;
      }
      if(rect4Y < 200)
      {
        subir4 = false;
        bajar4 = true;
      }
      if(bajar4)
      {
        rect4Y = rect4Y + 2;
        if(rect4Y > sueloY-30)
        {
          bajar4 = false;
          subir4 = true;
        }
      }
    }
    
}
