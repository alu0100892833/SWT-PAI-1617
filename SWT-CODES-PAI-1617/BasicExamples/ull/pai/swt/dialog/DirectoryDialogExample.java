package ull.pai.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class DirectoryDialogExample {  

    private Shell window;
    private Label pathToDirectory; 

    public DirectoryDialogExample(Display display) {
        initUI(display);
    }

    private void initUI(Display display) {
        window = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);

        pathToDirectory = new Label(window, SWT.BORDER);
        pathToDirectory.setText("Ready");

        FormLayout layout = new FormLayout();
        window.setLayout(layout);

        FormData labelData = new FormData();
        labelData.left = new FormAttachment(0);
        labelData.right = new FormAttachment(100);
        labelData.bottom = new FormAttachment(100);
        pathToDirectory.setLayoutData(labelData);

        window.addListener(SWT.MouseDown, event -> onMouseDown());

        window.setText("DirectoryDialog");
        window.setSize(350, 250);
        window.open();

        while (!window.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private void onMouseDown() {
        DirectoryDialog dialog = new DirectoryDialog(window);
        String path = dialog.open();

        if (path != null) {
            pathToDirectory.setText(path);
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        DirectoryDialogExample ex = new DirectoryDialogExample(display);
        display.dispose();
    }
}