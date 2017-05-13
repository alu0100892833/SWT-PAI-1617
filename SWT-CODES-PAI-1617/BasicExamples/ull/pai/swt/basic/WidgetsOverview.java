package ull.pai.swt.basic;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * Basic example of an application with a graphical user interface developed with SWT.
 * It shows a button in the middle of the screen. When pressed, the application terminates.
 * @author Óscar Darias Plasencia
 * @since 4-5-2017
 */
public class WidgetsOverview { 
	private static final int WINDOW_WIDTH = 220;
	private static final int WINDOW_HEIGHT = 130;

    public WidgetsOverview(Display display) {
        Shell shell = new Shell(display, SWT.SHELL_TRIM);

        GridLayout layout = new GridLayout();
        layout.verticalSpacing = 60;
        layout.horizontalSpacing = 20;
        layout.numColumns = 3;
        layout.marginLeft = 20;
        layout.marginTop = 20;
        shell.setLayout(layout);
        
        Menu menuBar = new Menu(shell, SWT.BAR);
        MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
        cascadeFileMenu.setText("File");
        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        cascadeFileMenu.setMenu(fileMenu);
        MenuItem newItem = new MenuItem(fileMenu, SWT.PUSH);
        newItem.setText("New");
        shell.setMenuBar(menuBar);

        MenuItem subMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
        subMenuItem.setText("Import");

        Menu submenu = new Menu(shell, SWT.DROP_DOWN);
        subMenuItem.setMenu(submenu);

        MenuItem feedItem = new MenuItem(submenu, SWT.PUSH);
        feedItem.setText("Import news feed...");

        MenuItem bmarks = new MenuItem(submenu, SWT.PUSH);
        bmarks.setText("Import bookmarks...");

        MenuItem mailItem = new MenuItem(submenu, SWT.PUSH);
        mailItem.setText("Import mail...");
        
        MenuItem cascadeViewMenu = new MenuItem(menuBar, SWT.CASCADE);
        cascadeViewMenu.setText("View");
        Menu viewMenu = new Menu(shell, SWT.DROP_DOWN);
        cascadeViewMenu.setMenu(viewMenu);
  
        MenuItem statItem = new MenuItem(viewMenu, SWT.CHECK);
        statItem.setSelection(true);
        statItem.setText("Option");

        GridData data = new GridData(WINDOW_WIDTH, WINDOW_HEIGHT); 

        Label descLabel = new Label(shell, SWT.NONE);
        descLabel.setText("WIDGETS ON SWT");
        FontData[] fDatas = descLabel.getFont().getFontData();
        fDatas[0].setHeight(20);
        descLabel.setFont(new Font(display, fDatas[0]));
        descLabel.setLayoutData(data);
        descLabel.pack();


        Button pushButton = new Button(shell, SWT.PUSH); 
        pushButton.setText("SWT.PUSH");
        pushButton.setLayoutData(data);
        pushButton.pack();


        Button arrowButton = new Button(shell, SWT.ARROW | SWT.LEFT);
        arrowButton.setText("SWT.ARROW");
        arrowButton.setLayoutData(data); 
        arrowButton.pack(); 


        Button checkButton = new Button(shell, SWT.CHECK);
        checkButton.setText("SWT.CHECK");
        checkButton.setLayoutData(data);
        checkButton.pack();


        Combo exampleCombo = new Combo(shell, SWT.DROP_DOWN); 
        exampleCombo.setLayoutData(data);
        exampleCombo.add("Example 1.", 0);
        exampleCombo.add("Example 2.");
        exampleCombo.add("Example 3.");
        exampleCombo.add("Example 4.");
        exampleCombo.pack();

        Group group = new Group(shell, SWT.NONE);
        group.setLayoutData(new GridData(130, 100));
        group.setText("This is a Group!");


        Label labelInGroup = new Label(group, SWT.NONE); 
    	labelInGroup.setText("Label in Group");
    	labelInGroup.setLocation(20,20);
    	labelInGroup.pack();

    	Button button = new Button(group, SWT.PUSH);
    	button.setText("Push button");
    	button.setLocation(20,45);
        button.pack();

        group.pack();

        List list = new List(shell, SWT.MULTI);
        list.setLayoutData(new GridData(130, 40));
        list.add("Text 1.");
        list.add("Text 2.");


        ProgressBar progress = new ProgressBar(shell, SWT.HORIZONTAL);
        progress.setLayoutData(data);
        progress.setMaximum(10);
        progress.setMinimum(0);
        progress.setSelection(8);


        DateTime slider = new DateTime(shell, SWT.DATE);
        slider.setLayoutData(data);

        Scale scale = new Scale(shell, SWT.HORIZONTAL);
        scale.setLayoutData(data);
        scale.setMaximum(10);
        scale.setMinimum(0);
        scale.setSelection(5);


        Spinner spinner = new Spinner(shell, SWT.HORIZONTAL);
        spinner.setLayoutData(data);
        spinner.setMaximum(10);
        spinner.setMinimum(0);
        spinner.setSelection(8);


        shell.setText("SWT's Widgets");
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
        WidgetsOverview ex = new WidgetsOverview(display);
        display.dispose();
    }
}
