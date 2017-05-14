package ull.pai.swt.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Example of how to use RowLayout to create interfaces with SWT.
 * @author Óscar Darias Plasencia 
 * @since 2-5-2017
 */
public class UsingRowLayout {

	/**
	 * Constructor that builds the main window.
	 * @param display The Display object father of the shell.
	 */
    public UsingRowLayout(Display display) { 
        Shell shell = new Shell(display);

        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 10;
        shell.setLayout(rowLayout);

        Button btn1 = new Button(shell, SWT.PUSH);
        btn1.setText("Regular");
        btn1.setLayoutData(new RowData(80, 30));

        Button btn2 = new Button(shell, SWT.PUSH);
        btn2.setText("Smaller");
        btn2.setLayoutData(new RowData(50, 30));

        Button btn3 = new Button(shell, SWT.PUSH);
        btn3.setText("Larger");
        btn3.setLayoutData(new RowData(100, 30));
        
        shell.setText("RowLayout");
        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }        
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        UsingRowLayout ex = new UsingRowLayout(display);
        display.dispose();
    }
}
