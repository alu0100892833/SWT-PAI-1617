package ull.pai.swt.basic;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Basic example of an application with a graphical user interface developed with SWT.
 * It shows a button in the middle of the screen. When pressed, the application terminates.
 * @author Óscar Darias Plasencia
 * @since 4-5-2017
 */
public class QuitButtonEx {

    public QuitButtonEx(Display display) {
        initUI(display);
    }

    private void initUI(Display display) {
        Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
        
        RowLayout layout = new RowLayout();
        layout.marginLeft = 50;
        layout.marginTop = 50;
        shell.setLayout(layout);

        Button quitBtn = new Button(shell, SWT.PUSH);
        quitBtn.setText("Quit");
        quitBtn.setLayoutData(new RowData(80, 30));

        quitBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                shell.getDisplay().dispose();
                System.exit(0);
            }
        });

        shell.setText("Quit button");
        shell.setSize(250, 200);
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
        QuitButtonEx ex = new QuitButtonEx(display);
        display.dispose();
    }
}