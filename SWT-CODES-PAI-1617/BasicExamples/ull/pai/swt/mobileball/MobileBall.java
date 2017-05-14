package ull.pai.swt.mobileball;

import org.eclipse.swt.widgets.Display;

/**
 * Main program for executing the mobile ball using SWT for the interface.
 * @author Óscar Darias Plasencia
 * @since 5-9-2017
 */
public class MobileBall {

	public static void main(String[] args) {
		final Display display = new Display();
		@SuppressWarnings("unused")
		GraphicBallWindow shell = new GraphicBallWindow(display);
		
		display.dispose();
	}
}
