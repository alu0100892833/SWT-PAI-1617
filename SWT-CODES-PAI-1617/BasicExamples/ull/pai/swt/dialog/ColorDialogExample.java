package ull.pai.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Quick example of a color dialog in SWT.
 * @author Óscar Darias Plasenicia
 * @since 4-5-2017
 */
public class ColorDialogExample { 
    
    private Shell shell;
    private Label label;

    /**
     * Constructor that simply calls initUI.
     * @param display
     */
    public ColorDialogExample(Display display) {
        initUI(display);
    }

    /**
     * This method creates the UI. 
     * A simple text, and the background with an event handler that calls onMouseDown().
     * @param display
     */
    private void initUI(Display display) {
        shell = new Shell(display);
        
        RowLayout layout = new RowLayout();
        layout.marginHeight = 100;
        layout.marginWidth = 100;
        shell.setLayout(layout);             

        label = new Label(shell, SWT.NONE);
        label.setText("This label changes its color.");
        
        shell.addListener(SWT.MouseDown, event -> onMouseDown());
        
        shell.setText("ColorDialog");
        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }        
    }
    
    /**
     * Method that is called when the mouse presses the window.
     * Opens a color dialog and sets the label with the selected color.
     */
    private void onMouseDown() {
        ColorDialog dialog = new ColorDialog(shell);
        RGB rgb = dialog.open();
        
        if (rgb != null) {
            Color col = new Color(shell.getDisplay(), rgb);
            label.setForeground(col);
            col.dispose();
        }            
    }    

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        ColorDialogExample ex = new ColorDialogExample(display);
        display.dispose();
    }
}