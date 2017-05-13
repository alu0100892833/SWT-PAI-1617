package ull.pai.swt.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Calculator example for showing how GridLayout works in SWT.
 * @author Óscar Darias Plasencia
 * @since 13-5-2017
 */
public class CalculatorExample {
	private static final int N_COLUMNS = 4;
	private static final String[] BUTTONS = {
            "Reset", "Back", "", "Close", "7", "8", "9", "/", "4",
            "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"
        };

	/**
	 * Constructor that calls initUI for initializing the UI.
	 * @param display
	 */
    public CalculatorExample(Display display) {
        initUI(display);
    }
    
    /**
     * Creates the layout itself. It is not responsive in this case.
     * @param display
     */
    private void initUI(Display display) {
        Shell shell = new Shell(display, SWT.DIALOG_TRIM | SWT.CENTER);  

        GridLayout shellLayout = new GridLayout(N_COLUMNS, true);
        shell.setLayout(shellLayout);

        Text text = new Text(shell, SWT.SINGLE);
        GridData gridData = new GridData();
        gridData.horizontalSpan = N_COLUMNS;
        gridData.horizontalAlignment = GridData.FILL;
        text.setLayoutData(gridData);

        for (int i = 0; i < BUTTONS.length; i++) {
            if (i == 2) {
                Label lbl = new Label(shell, SWT.CENTER);
                GridData lblData = new GridData(SWT.FILL, SWT.FILL, false, false);  
                lbl.setLayoutData(lblData);
            } else {
               Button btn = new Button(shell, SWT.PUSH);
               btn.setText(BUTTONS[i]);
               GridData btnData = new GridData(SWT.FILL, SWT.FILL, false, false);
               btnData.widthHint = 80;
               btnData.heightHint = 30;
               btn.setLayoutData(btnData);
            }
        }
        
        shell.setText("Calculator");
        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }        
    }

    /**
     * Main program.
     * @param args Should be empty.
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        CalculatorExample ex = new CalculatorExample(display);
        display.dispose();
    }
}