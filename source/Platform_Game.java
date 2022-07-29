import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Platform_Game extends PApplet {

float playerX, playerY, playerHeight, playerWidth, playerSpeedY;
float rect1X, rect1Y, rect1Height, rect1Width;
float rect2X, rect2Y, rect2Height, rect2Width;
float rect3X, rect3Y, rect3Height, rect3Width;
float rect4X, rect4Y, rect4Height, rect4Width;
float rectauxX, rectauxY, rectauxHeight, rectauxWidth;
float monsX, monsY, monsHeight, monsWidth;
float proyectilX, proyectilY;
float proymonsX, proymonsY;
float sueloY;
float x1, y1, x2, y2;
float a;
boolean c1, c2, pintar;
int puntuacion;
boolean fase1, fase2, fase3;
boolean haymonstruo;
boolean subir3, bajar3, subir4, bajar4, noelegido;
boolean jugar, movimiento, tutorial, gameover, saltando;
boolean disparando, disparandoDerecha, disparandoIzquierda;
boolean disparandoM, disparandoDerechaM, disparandoIzquierdaM;
boolean colisionaux;
boolean [] keys;
public void setup()
{
  background(125);
  keys = new boolean [5];
  
  jugar = false;
  tutorial = false;
  saltando = false;
  playerX = 62.5f;
  playerY = 0;
  playerHeight = 40;
  playerWidth = 40;
  monsHeight = 30;
  monsWidth = 20;
  monsX = -10000;
  monsY = -10000;
  playerSpeedY = 0;
  sueloY = 600;
  rect1X = -300;
  rect1Y = 500;
  rect1Height = 20;
  rect1Width = 425;
  rect2X = 950;
  rect2Y = 500;
  rect2Height = 20;
  rect2Width = 500;
  rect3X = 325;
  rect3Y = 500;
  rect3Height = 20;
  rect3Width = 100;
  rect4X = 625;
  rect4Y = 400;
  rect4Height = 20;
  rect4Width = 100;
  fase1 = false;
  fase2 = false;
  haymonstruo = true;
  subir3 = true;
  bajar3 = false;
  subir4 = true;
  bajar4 = false;
  pintar = true;
  c1 = false;
  c2 = false;
  a = 0;
  puntuacion = 0;
  disparando = false;
  disparandoDerecha = false;
  disparandoIzquierda = false;
  movimiento = true;
  disparandoM = false;
  disparandoDerechaM = false;
  disparandoIzquierdaM = false;
  
}

public void draw()
{
  if(jugar == false)
  {
    background(125);
    textSize(50);
    text("'E' - Jugar", width/2 - 130, height/2 + 75);
    if(key == 'e')
    {
      jugar = true;
    }
  }
  if(jugar)
  {
    a ++;
    if(a >= 125)
    {
      a = 125;
    }
    background(a); //fondo
    stroke(255);
    strokeWeight(2);
    
    for (int i = 0; i < width; i = i + 20)
    {
      fill(0);
      stroke(0);
      triangle(i,sueloY+20, i+20, sueloY+20, i+10, sueloY);
    }
    fill(0);
    rect(0, sueloY+20, width, 1000);
    //dibujar rectángulos en la pantalla
    pintar();
    //gravedad
    playerY += playerSpeedY;
    //uso de las teclas
    movimiento();
    //colisiones
    colision();
    //bordes de la pantalla
    bordes();
    //dibuja los elementos
    fill(0);
    stroke(0);
    rect(rect1X, rect1Y, rect1Width, rect1Height);
    rect(rect2X, rect2Y, rect2Width, rect2Height);
    fill(0xff168922);
    stroke(0xff168922);
    rect(rect3X, rect3Y, rect3Width, rect3Height);
    rect(rect4X, rect4Y, rect4Width, rect4Height);
    fill(255,255,0); //el cuadrado personaje es amarillo
    stroke(255,255,0);
    rect(playerX, playerY, playerHeight, playerWidth);
    textSize(50);
    fill(255);    //el texto es blanco
    stroke(255);
    text(puntuacion, width/2 - 25, 50);
    //puntuacion
    puntuacion();
    //cambios de fase
    fases();
    //disparar
    disparar();
    //monstruos
    monstruos();
    //disparos de los monstruos
    disparoMonstruo();
    finjuego();
    
  } 
}

public void keyPressed()
{
  if(jugar)
  {
    if(key == 'd')
    {
      keys[0] = true;
    }
    if(key == 'a')
    {
      keys[1] = true;
    }
    if(key == 'w' & saltando == false)
    {
      keys[2] = true;
    }
    if(key == 's')
    {
      keys[3] = true;
    }
    if(key == ' ')
    {
      keys[4] = true;
    }
  }
}
public void keyReleased()
{
  if(jugar)
  {
    if(key == 'd')
    {
      keys[0] = false;
    }
    if(key == 'a')
    {
      keys[1] = false;
    }
    if(key == 'w')
    {
      keys[2] = false;
    }
    if(key == 's')
    {
      keys[3] = false;
    }
    if(key == ' ')
    {
      keys[4] = false;
    }
  }
}
public void bordes()
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
public void colision()
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
      playerY = rect3Y - playerHeight - 2.00000000000000000000000000000000001f;
      }
      else if(bajar3)
      {
      playerY = rect3Y - playerHeight + 1.99999999999999999999999999999999999f;
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
      playerY = rect4Y - playerHeight - 2.00000000000000000000000000000000001f;
      }
      else if(bajar4)
      {
      playerY = rect4Y - playerHeight + 1.99999999999999999999999999999999999f;
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
public void disparar()
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
public void disparoMonstruo()
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
public void fases()
{
  if(fase1)
    {
      if(noelegido)
      {
      switch(PApplet.parseInt(random(0,2)))
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
        switch(PApplet.parseInt(random(0,2)))
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
public void finjuego()
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
public void monstruos()
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
public void movimiento()
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
public void pintar()
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
public void puntuacion()
{
  if(puntuacion >= 5)
    {
      rect3Width = 100;
      rect4Width = 100;
      fase1 = true;
    }
    if(puntuacion >= 10)
    {
      fase2 = true;
    }
    if(puntuacion >= 0)
    {
      fase3 = true;
    }
}
public void tutorial()
{
  


}
  public void settings() {  size(1000,700); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Platform_Game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
