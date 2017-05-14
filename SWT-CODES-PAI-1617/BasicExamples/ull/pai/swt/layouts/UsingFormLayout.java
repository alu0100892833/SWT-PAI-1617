package ull.pai.swt.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * Example of how to use FormLayout to build interfaces with SWT.
 * @author Óscar Darias Plasencia
 * @since 2-5-2017
 */
public class UsingFormLayout {
    
	/**
	 * Constructor that creates the window with the layout.
	 * @param display
	 */
    public UsingFormLayout(Display display) {
        Shell shell = new Shell(display);  
        shell.setLayout(new FormLayout());
        
        Label lbl = new Label(shell, SWT.LEFT); 
        lbl.setText("Search:");
        
        FormData lblData = new FormData();
        lblData.left = new FormAttachment(0, 5);
        lblData.top = new FormAttachment(0, 10);
        lbl.setLayoutData(lblData);         
        
        Text searchText = new Text(shell, SWT.SINGLE);
        FormData searchTextData = new FormData(); 
        searchTextData.left = new FormAttachment(lbl, 15);
        searchTextData.top = new FormAttachment(0, 10);
        searchTextData.right = new FormAttachment(100, -5);
        searchText.setLayoutData(searchTextData);      
        
        Composite resultComposite = new Composite(shell, SWT.NONE);      
        RowLayout rowLayout = new RowLayout();
        resultComposite.setLayout(rowLayout);
        
        Button okBtn = new Button(resultComposite, SWT.PUSH); 
        okBtn.setText("OK");
        okBtn.setLayoutData(new RowData(80, 30));
        Button closeBtn = new Button(resultComposite, SWT.PUSH);
        closeBtn.setText("Close");
        closeBtn.setLayoutData(new RowData(80, 30));
        
        FormData resultCompositeData = new FormData();  
        resultCompositeData.bottom = new FormAttachment(100, -5);
        resultCompositeData.right = new FormAttachment(100, 0);
        resultComposite.setLayoutData(resultCompositeData);         
        
        Text resultText = new Text(shell, SWT.MULTI | SWT.BORDER);  
        FormData resultTextData = new FormData();
        resultTextData.width = 250;
        resultTextData.height = 180;
        resultTextData.top = new FormAttachment(searchText, 10);
        resultTextData.left = new FormAttachment(0, 5);
        resultTextData.right = new FormAttachment(100, -5);
        resultTextData.bottom = new FormAttachment(resultComposite, -10);
        resultText.setLayoutData(resultTextData);           
        
        shell.setText("Search Engine");
        shell.pack();
        shell.open();
        
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }        
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        UsingFormLayout ex = new UsingFormLayout(display);
        display.dispose();    
    }
}