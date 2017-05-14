package ull.pai.swt.mobileball;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

/**
 * Esta clase representa una bola abstracta que puede ser representada mediante un gráfico.
 * Contiene todos los métodos necesarios para ello.
 * @author Óscar Darias Plasencia
 * @since 29/03/2017
 */
class GraphicBall {

    private int x, y;
    private double radius;
    private Color color;

    /**
     * Constructor por parámetros.
     * @param center Coordenadas del centro del círculo.
     * @param radius Radio del círculo.
     * @param color Objeto Color que representa el color con el que se dibujaría el círculo.
     */
    GraphicBall(int x, int y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    private Color getColor() {
        return color;
    }

    private double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private double getCenterX() {
        return x;
    }

    private double getCenterY() {
        return y;
    }

    /**
     * Este método indica si la posición a la que el círculo se ha movido está fuera de los límites del plano por el que se mueve.
     * @param width Anchura del plano.
     * @param height Altura del plano.
     * @return True o false, si está o no, fuera de los límites.
     */
    private boolean isOutOfBounds(int width, int height) {
        if ((getCenterX() + getRadius() > width) || (getCenterY() + getRadius() > height))
            return true;
        else if ((getCenterX() - getRadius() < 0) || (getCenterY() - getRadius() < 0))
            return true;
        return false;
    }

    /**
     * Mueve el círculo hacia arriba en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    void moveUp(double distance, int width, int height) throws OutOfRangeException {
    	setY((int) (getCenterY() - distance));
        if (isOutOfBounds(width, height)) {
        	setY((int) getRadius());
            throw new OutOfRangeException("In position [" + getCenterX() + ", " + getCenterY() + "].");
        }
    }
    
    

    /**
     * Mueve el círculo hacia abajo en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    void moveDown(double distance, int width, int height)  throws OutOfRangeException {
    	setY((int) (getCenterY() + distance));
        if (isOutOfBounds(width, height)) {
        	setY(height - (int) getRadius());
            throw new OutOfRangeException();
        }
    }
    
    
    /**
     * Mueve el círculo hacia la izquierda en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    void moveLeft(double distance, int width, int height) throws OutOfRangeException {
    	setX((int) (getCenterX() - distance));
        if (isOutOfBounds(width, height)) {
        	setX((int) getRadius());
            throw new OutOfRangeException();
        }
    }

    /**
     * Mueve el círculo hacia la derecha en la distancia especificada como parámetro.
     * @param distance
     * @param width Anchura del plano por el que se mueve.
     * @param height Altura del plano por el que se mueve.
     */
    void moveRight(double distance, int width, int height) throws OutOfRangeException {
    	setX((int) (getCenterX() + distance));
        if (isOutOfBounds(width, height)) {
        	setX(width - (int) getRadius());
            throw new OutOfRangeException();
        }
    }

    /**
     * Este método devuelve la posición de la esquina superior izquierda del rectángulo que engloba a la bola.
     * Esto a fin de poder representar la bola correctamente con el método fillOval, que requiere de dicho dato y no del centro de la bola.
     * @return
     */
    private int getUpperLeftCornerX() {
        return (int) (getCenterX() - getRadius());
    }
    
    /**
     * Este método devuelve la posición de la esquina superior izquierda del rectángulo que engloba a la bola.
     * Esto a fin de poder representar la bola correctamente con el método fillOval, que requiere de dicho dato y no del centro de la bola.
     * @return
     */
    private int getUpperLeftCornerY() {
        return (int) (getCenterY() - getRadius());
    }

    /**
     * Este método dibuja la bola en una ventana gráfica, a partir de los atributos de la misma.
     * Se asegura de que la bola no se sale del panel. Si lo hiciera, la dejaría en el límite.
     * @param g
     * @param width Es la anchura del panel en el que se va a dibujar la bola.
     * @param height Es la altura del panel en el que se va a dibujar la bola.
     */
    void drawBall(GC graphics, int width, int height) {
        // graphics.setForeground(getColor());
    	graphics.setBackground(graphics.getDevice().getSystemColor(SWT.COLOR_RED));
        graphics.fillOval((int) getUpperLeftCornerX(), (int) getUpperLeftCornerY(), 2 * (int) getRadius(), 2 * (int) getRadius());
    }
}







