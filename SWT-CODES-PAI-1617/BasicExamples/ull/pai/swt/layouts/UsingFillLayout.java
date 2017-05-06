package ull.pai.swt.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class UsingFillLayout {

    private Image infoPicture;

    public UsingFillLayout(Display display) { 
        Shell shell = new Shell(display); 
        FillLayout layout = new FillLayout();
        layout.marginHeight = 5;
        layout.marginWidth = 5;
        shell.setLayout(layout);
        
        loadImage(shell);

        Label label = new Label(shell, SWT.IMAGE_PNG);
        label.setImage(infoPicture);
        
        shell.setText("FillLayout");        
        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }        
    }
    
    private void loadImage(Shell shell) {
        Device dev = shell.getDisplay();
        
        try {
            infoPicture = new Image(dev, "img/info.png");
        } catch(Exception e) {
            System.out.println("Cannot load image");
            e.printStackTrace();
        }        
    }

    @Override
    public void finalize() {
        infoPicture.dispose();
    }

    public static void main(String[] args) {
        Display display = new Display();
        UsingFillLayout app = new UsingFillLayout(display);
        app.finalize();
        display.dispose();
    }
}
