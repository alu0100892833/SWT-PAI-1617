package ull.pai.swt.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Quick example of a file dialog.
 * @author Óscar Darias Plasencia
 * @since 5-5-2017
 */
public class FileDialogExample { 
	private static final String[] FILTER_NAMES = {
			"Java sources", "All Files (*)"
	};
	private static final String[] FILTER_EXTENSIONS = {
			"*.java", "*"	
	};

    private Shell window;  
    private Label pathLabel;

    /**
     * Constructor.
     * @param display
     */
    public FileDialogExample(Display display) {
        initUI(display);
    }

    /**
     * Initializes an empty background. When it is clicked, calls onMouseDown.
     * @param display
     */
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
    
    /**
     * Opens a file dialog with the predefined filter names and filter extensions.
     * Writes the selected file´s path.
     */
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