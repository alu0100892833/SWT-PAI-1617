package ull.pai.swt.graphics;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

/**
 * Quick example of how to use graphics in SWT. 
 * This class is a program that creates a graphic circle.
 * @author Óscar Darias Plasencia
 * @since 7-5-2017
 */
public class PaintCircle {
	private static final int OVAL_MARGIN = 40;

	public static void main(String [] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		
		// Paint listener draws the circle
		shell.addPaintListener(event -> {
			Rectangle rect = shell.getClientArea();
			event.gc.drawOval(OVAL_MARGIN, OVAL_MARGIN, rect.width - OVAL_MARGIN * 2, rect.height - OVAL_MARGIN * 2);
		});
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	} 
}