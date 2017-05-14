package ull.pai.swt.mobileball;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Rectangle;

public class GraphicBallWindow {
	private final int PANEL_WIDTH = 700;
    private final int PANEL_HEIGHT = 700;
    private final int BALL_RADIUS = 30;
    private final int MOVING_DISTANCE = 40;
    private final int RED_RGB = 255;
    
    private Shell window;
    private Composite buttonsSpace;
    private Button upButton, leftButton, downButton, rightButton;
    private GraphicBall ball;
	
	
	public GraphicBallWindow(Display parent) {
		window = new Shell(parent);
		window.setLayout(new FormLayout());
		
		setButtons();
		Device device = Display.getCurrent ();
		Color red = new Color (device, RED_RGB, 0, 0);
		ball = new GraphicBall(PANEL_WIDTH / 2, PANEL_HEIGHT / 2, 
				BALL_RADIUS, red);
		window.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setButtonsListeners();
		setSpaceListener();
		
		window.open();
		while (!window.isDisposed()) {
            if (!window.getDisplay().readAndDispatch()) {
                window.getDisplay().sleep();
            }
        }
	}
	

	public Composite getButtonsSpace() {
		return buttonsSpace;
	}



	public void setButtonsSpace(Composite buttonsSpace) {
		this.buttonsSpace = buttonsSpace;
	}



	public Button getUpButton() {
		return upButton;
	}



	public void setUpButton(Button upButton) {
		this.upButton = upButton;
	}



	public Button getLeftButton() {
		return leftButton;
	}



	public void setLeftButton(Button leftButton) {
		this.leftButton = leftButton;
	}



	public Button getDownButton() {
		return downButton;
	}



	public void setDownButton(Button downButton) {
		this.downButton = downButton;
	}



	public Button getRightButton() {
		return rightButton;
	}



	public void setRightButton(Button rightButton) {
		this.rightButton = rightButton;
	}



	public GraphicBall getBall() {
		return ball;
	}



	public void setBall(GraphicBall ball) {
		this.ball = ball;
	}



	private void setButtons() {
		buttonsSpace = new Composite(window, SWT.NONE);
		buttonsSpace.setLayout(new FormLayout());
		FormData buttonsSpaceData = new FormData();
		buttonsSpaceData.left = new FormAttachment(25);
		buttonsSpaceData.right = new FormAttachment(75);
		buttonsSpaceData.top = new FormAttachment(75, 10);
		buttonsSpaceData.bottom = new FormAttachment(100, 10);
		buttonsSpace.setLayoutData(buttonsSpaceData);
		
		upButton = new Button(buttonsSpace, SWT.PUSH);
		upButton.setText("UP");
		FormData upData = new FormData();
		upData.left = new FormAttachment(25);
		upData.right = new FormAttachment(75);
		upData.top = new FormAttachment(0);
		upData.bottom = new FormAttachment(33);
		upButton.setLayoutData(upData);
		
		downButton = new Button(buttonsSpace, SWT.PUSH);
		downButton.setText("DOWN");
		FormData downData = new FormData();
		downData.left = new FormAttachment(25);
		downData.right = new FormAttachment(75);
		downData.top = new FormAttachment(66);
		downData.bottom = new FormAttachment(100);
		downButton.setLayoutData(downData);
		
		leftButton = new Button(buttonsSpace, SWT.PUSH);
		leftButton.setText("LEFT");
		FormData leftData = new FormData();
		leftData.left = new FormAttachment(20);
		leftData.right = new FormAttachment(45);
		leftData.top = new FormAttachment(33);
		leftData.bottom = new FormAttachment(66);
		leftButton.setLayoutData(leftData);
		
		rightButton = new Button(buttonsSpace, SWT.PUSH);
		rightButton.setText("RIGHT");
		FormData rightData = new FormData();
		rightData.left = new FormAttachment(55);
		rightData.right = new FormAttachment(80);
		rightData.top = new FormAttachment(33);
		rightData.bottom = new FormAttachment(66);
		rightButton.setLayoutData(rightData);
	}
	
	
	
	private void setSpaceListener() {
		window.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent pe) {
				Rectangle clientArea = window.getClientArea();
				getBall().drawBall(pe.gc, clientArea.width, clientArea.height); 
			}
		});
	}
	
	
	private void setButtonsListeners() {
		upButton.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				try {
					getBall().moveUp(MOVING_DISTANCE, PANEL_WIDTH, PANEL_HEIGHT);
				} catch (OutOfRangeException e) {
					e.printStackTrace();
				}
				window.redraw();
				window.update();
			}
		});
		
		leftButton.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				try {
					getBall().moveLeft(MOVING_DISTANCE, PANEL_WIDTH, PANEL_HEIGHT);
				} catch (OutOfRangeException e) {
					e.printStackTrace();
				}
				window.redraw();
				window.update();
			}
		});
		
		rightButton.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				try {
					getBall().moveRight(MOVING_DISTANCE, PANEL_WIDTH, PANEL_HEIGHT);
				} catch (OutOfRangeException e) {
					e.printStackTrace();
				}
				window.redraw();
				window.update();
			}
		});
		
		downButton.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				try {
					getBall().moveDown(MOVING_DISTANCE, PANEL_WIDTH, PANEL_HEIGHT);
				} catch (OutOfRangeException e) {
					e.printStackTrace();
				}
				window.redraw();
				window.update();
			}
		});
	}
	

}



















// end