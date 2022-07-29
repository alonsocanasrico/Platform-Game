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
void setup()
{
  background(125);
  keys = new boolean [5];
  size(1000,700);
  jugar = false;
  tutorial = false;
  saltando = false;
  playerX = 62.5;
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

void draw()
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
    fill(#168922);
    stroke(#168922);
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

void keyPressed()
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
void keyReleased()
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
