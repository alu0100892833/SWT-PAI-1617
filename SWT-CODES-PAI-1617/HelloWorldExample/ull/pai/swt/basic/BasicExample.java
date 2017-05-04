package ull.pai.swt.basic;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class BasicExample {
    public static void main (String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        Label label = new Label(shell, SWT.NONE);
        label.setText("Hola Mundo");
        label.pack();
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) 
            	display.sleep();
        }
        display.dispose();
    }
}