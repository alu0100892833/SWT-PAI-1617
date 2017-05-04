# STANDARD WIDGET TOOLKIT
## GUIÓN

---

### 1. QUÉ ES SWT?

SWT, del inglés _Standard Widget Toolkit_ es un conjunto de componentes para construir interfaces gráficas en Java. El proyecto es 100% de código abierto y su desarrollo principal corre al cargo del proyecto Eclipse. Es básicamente una forma más que tenemos en Java de diseñar interfaces de usuario interactivas, que presenta ciertas ventajas con respecto a sus alternativas, pero también una serie de desventajas bien claras. En esta presentación vamos a llevar a cabo una introducción lo más completa posible acerca de cómo usar esta herramienta, sus ventajas y desventajas, principales usos, y otras peculiaridades.

---

### 2. LAS LIBRERÍAS DE ECLIPSE

A día de hoy todos sabemos perfectamente lo que es un paquete en Java. Más allá de poder crear nuestros propios paquetes, más del 50% del código que utilizamos en cada programa no es realmente nuestro, sino que las estructuras más básicas se encuentran en algún paquete disponible públicamente. Por ejemplo, el paquete `java.util` para las colecciones, o `java.io` para el manejo de ficheros en la entrada-salida.

Eclipse también pone a disposición de los desarrolladores sus propias librerías por medio del paquete `org.eclipse`. Dentro del mismo encontramos `org.eclipse.swt`. Estas librerías no se encuentran en el propio compilador de Java, como las anteriormente mencionadas, sino que se tienen que instalar manualmente.

---

### 3. RAZONES DE SU EXISTENCIA

SWT recupera la idea original de la biblioteca AWT de utilizar componentes nativos, con lo que adopta un estilo más consistente entre todas las plataformas, pero a la vez trata de no caer en las limitaciones de estas. La biblioteca SWING está codificada enteramente en Java y funciona bastante bien, pero algunos desarrolladores la acusan de no ofrecer una experiencia idéntica a la de una aplicación nativa. 
