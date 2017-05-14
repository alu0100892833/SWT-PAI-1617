package ull.pai.swt.graphics;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class PaintCircle {
	private static final int OVAL_MARGIN = 40;

	public static void main(String [] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		
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