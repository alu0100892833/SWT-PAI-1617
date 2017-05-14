package ull.pai.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * Quick example on how to use a MessageBox.
 * Just a program that asks you if you are sure you want to close it.
 * @author Óscar Darias Plasencia
 * @since 5-5-2017
 */
public class MessageBoxExample { 

    private Shell shell;

    /**
     * Constructor.
     * @param display
     */
    public MessageBoxExample(Display display) {
        initUI(display);
    }

    /**
     * Empty window that, when closed, calls the showMessageBox method.
     * @param display
     */
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

    /**
     * Shows a message box that asks you if you really want to close the window.
     * @param event
     */
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