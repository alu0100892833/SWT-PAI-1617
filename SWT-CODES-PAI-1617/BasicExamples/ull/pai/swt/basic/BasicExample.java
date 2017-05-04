package ull.pai.swt.basic;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

/**
 * Basic example of an application with a graphical user interface developed with SWT.
 * @author Óscar Darias Plasencia
 * @since 4-5-2017
 */
public class BasicExample {
	
    public static void main (String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        Label label = new Label(shell, SWT.NONE);
        label.setText("Hola Mundo");
        label.pack();
        shell.setSize(270, 100);
        shell.setText("PROGRAMA HOLA MUNDO");
        shell.setToolTipText("This is a window");
        centerWindow(shell);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) 
            	display.sleep();
        }
        display.dispose();
    }
    
    /**
     * Centers the given Shell object in the middle of the window.
     * @param shell
     */
    public static void centerWindow(Shell shell) {
    	Rectangle bds = shell.getDisplay().getBounds();

        Point p = shell.getSize();

        int nLeft = (bds.width - p.x) / 2;
        int nTop = (bds.height - p.y) / 2;

        shell.setBounds(nLeft, nTop, p.x, p.y);
    }
}