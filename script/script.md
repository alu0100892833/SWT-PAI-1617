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

Entonces surge SWT con el objetivo de mantenerse a un nivel más cercano al sistema operativo, y por ende a la librería AWT. El precio a pagar por esto es la dependencia a nivel visual del sistema operativo sobre el que se ejecuta la aplicación.

SWT utiliza componentes nativos siempre que sea posible, al igual que AWT. La diferencia es que SWT provee al desarrollador de una mayor cantidad de estos, comúnmente llamados widgets. Esto es debido a que si un widget no está disponible nativamente para una plataforma, SWT lo emula internamente.

Los usos que se le dan a SWT son dos:

* Desarrollo de aplicaciones interactivas, sustituyendo a SWING o AWT como framework para la interfaz.
* Desarrollo de plug-ins para Eclipse. Las aplicaciones de Eclipse normalmente utilizan SWT para la interfaz de usuario. Para desarrollar plug-ins que extiendan las funcionalidades del IDE, se tiene que usar SWT.

---

### 4. SWT vs SWING

Las ventajas de SWING con respecto a SWT son:

* Forma parte de las librerías de Java, así que no son necesarias librerías externas.
* Funciona exactamente igual en todas las plataformas.
* Existen editores gráficos para SWING en casi cualquier IDE.
* Está soportado por extensiones oficiales de Java como java OpenGL.
* La documentación está proporcionada por Oracle y es muy extensa y detallada.

Por contra:

* No proporciona una experiencia idéntica a la de una aplicación nativa del sistema operativo con el que se trabaja, como ya hemos mencionado.
* El uso de componentes pesados se superpone al uso de los componentes ligeros de SWING, lo cual no suele ser un problema ya que ambos se entendieron para trabajar en solitario, no combinados.

Las ventajas de SWT con respecto a SWING son:

* Utiliza componentes nativos cuando es posible, lo cual implica también un comportamiento nativo al SO.
* Fuertemente soportado por el IDE Eclipse.

Por contra:

* Requiere de librerías nativas en el sistema en el que se va a ejecutar la aplicación.
* Podría no emular cualquier tipo de comportamiento debido al uso de componentes nativos. Si un comportamiento no se puede emular en un sistema directamente, entonces SWT tampoco puede.

---

### 5. CÓMO INSTALARLO

Si queremos hacer uso de SWT en nuestro proyecto, tenemos que importar manualmente las dependencias, ya que el código no se encuentra en las dependencias del propio lenguaje.

1. Lo primero es ir a la página de descarga de SWT.
2. Seleccionamos la última versión estable y luego, en la siguiente página, hacemos scroll hasta abajo. Deberían aparecer las versiones para los diferentes sistemas operativos. Descargamos el `.zip` correspondiente al sistema en el que vayamos a desarrollar.
3. Los siguientes pasos son bastante distintos a como se suelen importar dependencias. Lo primero que hay que hacer es importar el `.zip` a eclipse como **proyecto**. Seleccionamos `File > Import > Existing Projects into Workspace` y seleccionamos el `.zip` descargado.
4. El proyecto de SWT se importará en nuestro espacio de trabajo de Eclipse. Acto seguido, se puede añadir como dependencia a otros proyectos abiertos de nuestro espacio de trabajo. Pinchamos click derecho y abrimos `Properties`. En la sección `Java Build Path` vamos a la pestaña `Projects` y añadimos el proyecto SWT importado.
5. Después de esto, se podrán utilizar perfectamente las librerías de SWT.

La principal parte negativa de todo esto, aparte de tener que realizar más operaciones que para instalar una librería normal, como ocurría con AssertJ, por ejemplo, es que necesitamos mantener abierto el proyecto de SWT constantemente en nuestro espacio de trabajo.














---