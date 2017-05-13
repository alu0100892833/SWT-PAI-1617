package ull.pai.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;


public class MessageBoxExample { 

    private Shell shell;

    public MessageBoxExample(Display display) {
        initUI(display);
    }

    private void initUI(Display display) {
        shell = new Shell(display);

        shell.addListener(SWT.Close, event -> showMessageBox(event));

        shell.setText("Message box");
        shell.setSize(350, 300);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private void showMessageBox(Event event) {
        MessageBox messageBox = new MessageBox(shell, 
        		SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
        messageBox.setText("WARNING");
        messageBox.setMessage("Are you sure you want to close this application? Every unsaved data will be lost.");
        event.doit = messageBox.open() == SWT.YES;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        MessageBoxExample ex = new MessageBoxExample(display);
        display.dispose();
    }
}