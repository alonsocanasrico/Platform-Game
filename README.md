# Platform-Game

Pequeño juego de plataformas desarrollado en Processing cuando tenía 17 años.\

Controles: \
	Desplazamiento:\
		A - Desplazarse a la izquierda\
		D - Desplazarse a la derecha\
		W - Saltar\
	Crear nueva plataforma:\
		Click derecho: coloca un punto, que será el vértice superior izquierdo de la plataforma que se puede dibujar\
		Click izquierdo: tras haber colocado el primer punto con el click derecho, coloca un punto, que será el vértice inferior derecho de la plataforma que se puede dibujar, y se dibujará la plataforma (la plataforma tiene un tamaño máximo, asique si se intenta dibujar una mayor, se dibujará auntomáticamente del máximo tamaño permitido.\
		S - Borra la plataforma dibujada, permitiendo dibujar una nueva (no se puede dibujar más de una plataforma al mismo tiempo)\
	Otras funciones:\
		Barra espaciadora: disparar (si el cursor está a la derecha del personaje, disparará a la derecha; si el cursor está a la izquierda, disparará hacia la izquierda). Si el disparo alcanza al rectángulo rojo, lo elimina.\

Consiste en llegar hasta el borde derecho de la pantalla, para pasar al siguiente nivel, el cual es generado aleatoriamente. En cada nivel, las plataformas se hacen más pequeñas para aumentar la dificultad.
