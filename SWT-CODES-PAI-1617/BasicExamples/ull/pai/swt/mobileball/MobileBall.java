package ull.pai.swt.mobileball;

import org.eclipse.swt.widgets.Display;

public class MobileBall {

	public static void main(String[] args) {
		final Display display = new Display();
		@SuppressWarnings("unused")
		GraphicBallWindow shell = new GraphicBallWindow(display);
		
		display.dispose();
	}
}
