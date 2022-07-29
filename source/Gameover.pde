void finjuego()
{
  if(gameover)
  {
    movimiento = false;
    x1 = -10000;
    y1 = -10000;
    x2 = -10000;
    y2 = -10000;
    fill(125);
    rect(0,0,width, height);
    fill(255);
    textSize(50);
    text("Puntuación: " + puntuacion, width/2 - 150, height/2 + 50);
    text("'R' - Volver al menú", width/2 - 220, height/2 + 100);
    textSize(75);
    text("GAME OVER", width/2 - 220, height/2 - 100);
    if(key == 'r')
    {
      gameover = false;
      setup();
    }
  }
}
