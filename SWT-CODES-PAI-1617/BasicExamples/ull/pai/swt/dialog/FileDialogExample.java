package ull.pai.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class FileDialogExample { 
	private static final String[] FILTER_NAMES = {
			"Java sources", "All Files (*)"
	};
	private static final String[] FILTER_EXTENSIONS = {
			"*.java", "*"	
	};

    private Shell window;  
    private Label pathLabel;

    public FileDialogExample(Display display) {
        initUI(display);
    }

    private void initUI(Display display) {
        window = new Shell(display);

        RowLayout layout = new RowLayout();
        layout.marginHeight = 50;
        layout.marginWidth = 50;
        window.setLayout(layout);

        pathLabel = new Label(window, SWT.NONE);
        String homeDir = System.getProperty("user.home"); 
        pathLabel.setText(homeDir);
        pathLabel.pack();

        window.addListener(SWT.MouseDown, event -> onMouseDown());

        window.setText("FileDialog");
        window.pack();
        window.open();

        while (!window.isDisposed()) {
          if (!display.readAndDispatch()) {
            display.sleep();
          }
        }
    }
    
    private void onMouseDown() {
        FileDialog dialog = new FileDialog(window, SWT.OPEN);

        dialog.setFilterNames(FILTER_NAMES);
        dialog.setFilterExtensions(FILTER_EXTENSIONS);

        String path = dialog.open();
        
        if (path != null) {
            pathLabel.setText(path);
            pathLabel.pack();
            window.pack();
        }        
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        FileDialogExample ex = new FileDialogExample(display);
        display.dispose();
    }
}