package ull.pai.swt.layouts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ComplexLayout { 
	 
	Image personalImage; 
	Text fanNameText; 
	Combo bornPlaceCombo;    
	Canvas fanPhoto; 
	List fanCategories;
	Text mailText;
	Text phoneText;

	public Shell createShell(final Display display) {
		final Shell shell = new Shell(display);
		FormLayout layout = new FormLayout(); 
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		shell.setLayout(layout);
		shell.setText("Zidane FanClub"); 
		
		Group fanInfo = new Group(shell, SWT.NONE);
		fanInfo.setText("Fan Info");
		FormLayout fanLayout = new FormLayout();
		fanLayout.marginWidth = 5;  
		fanLayout.marginHeight = 5;
		fanInfo.setLayout(fanLayout);
		
		Label fanName = new Label(shell, SWT.NONE); 
		fanName.setText("Your Name:");
		fanNameText = new Text(shell, SWT.SINGLE | SWT.BORDER); 
		
		Label birthPlace = new Label(shell, SWT.NONE);
		birthPlace.setText("Birth Place:");
		
		bornPlaceCombo = new Combo(shell, SWT.NONE);
		bornPlaceCombo.setItems(new String[] { "Spain", "England", "France", "Portugal",
				"Italy", "Germany", "Outside Europe" });
		
		Label photo = new Label(shell, SWT.NONE);
		photo.setText("Photo:");
		fanPhoto = new Canvas(shell, SWT.BORDER);
		
		Button browse = new Button(shell, SWT.PUSH);
		browse.setText("Browse...");
		
		Button delete = new Button(shell, SWT.PUSH); 
		delete.setText("Delete");
		
		Label categories = new Label(shell, SWT.NONE);
		categories.setText("Categories");
		fanCategories = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		fanCategories.setItems(new String[] { "He´s not bad", "He´s pretty good",
				"He used to be better", "Great player, bad coach", "Best I´ve seen",
				"I would marry him" });
		
		Button enter = new Button(shell, SWT.PUSH);
		enter.setText("Enter");
		
		FormData data = new FormData(); 
		data.top = new FormAttachment(fanNameText, 0, SWT.CENTER);
		fanName.setLayoutData(data);
		data = new FormData();
		data.left = new FormAttachment(fanName, 5);
		data.right = new FormAttachment(100, 0);
		fanNameText.setLayoutData(data);
		
		data = new FormData();
		data.top = new FormAttachment(bornPlaceCombo, 0, SWT.CENTER);
		birthPlace.setLayoutData(data);
		data = new FormData();
		data.top = new FormAttachment(fanNameText, 5);
		data.left = new FormAttachment(fanNameText, 0, SWT.LEFT);
		data.right = new FormAttachment(fanCategories, -5);
		bornPlaceCombo.setLayoutData(data);
		
		data = new FormData(80, 80);
		data.top = new FormAttachment(bornPlaceCombo, 5);
		data.left = new FormAttachment(fanNameText, 0, SWT.LEFT);
		data.right = new FormAttachment(fanCategories, -5);
		data.bottom = new FormAttachment(fanInfo, -5);
		fanPhoto.setLayoutData(data);
		fanPhoto.addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent event) {
				if (personalImage != null) {
					event.gc.drawImage(personalImage, 0, 0);
				}
			}
		});
		
		data = new FormData();
		data.top = new FormAttachment(fanPhoto, 0, SWT.TOP);
		photo.setLayoutData(data);
		data = new FormData();
		data.top = new FormAttachment(photo, 5);
		data.right = new FormAttachment(fanPhoto, -3);
		data.left = new FormAttachment(0, 1);
		browse.setLayoutData(data);
		browse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				String fileName = new FileDialog(shell).open();
				if (fileName != null) {
					personalImage = new Image(display, fileName);
				}
			}
		});
		
		data = new FormData();
		data.left = new FormAttachment(browse, 0, SWT.LEFT);
		data.top = new FormAttachment(browse, 3);
		data.right = new FormAttachment(fanPhoto, -3);
		delete.setLayoutData(data);
		delete.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				if (personalImage != null) {
					personalImage.dispose();
					personalImage = null;
					fanPhoto.redraw();
				}
			}
		});
		
		data = new FormData(90, 140);
		data.top = new FormAttachment(fanPhoto, 0, SWT.TOP);
		data.right = new FormAttachment(100, 0);
		data.bottom = new FormAttachment(enter, -5);
		fanCategories.setLayoutData(data);
		
		data = new FormData();
		data.bottom = new FormAttachment(fanCategories, -5);
		data.left = new FormAttachment(fanCategories, 0, SWT.CENTER);
		categories.setLayoutData(data);
		
		data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.bottom = new FormAttachment(100, 0);
		enter.setLayoutData(data);
		enter.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				System.out.println("\nDog Name: " + fanNameText.getText());
				System.out.println("Dog Breed: " + bornPlaceCombo.getText());
				System.out.println("Owner Name: " + mailText.getText());
				System.out.println("Owner Phone: " + phoneText.getText());
				System.out.println("Categories:");
				String cats[] = fanCategories.getSelection();
				for (int i = 0; i < cats.length; i++) {
					System.out.println("\t" + cats[i]);
				}
			}
		});
		
		data = new FormData();
		data.bottom = new FormAttachment(enter, -5);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(fanCategories, -5); 
		fanInfo.setLayoutData(data);
		
		Label eMail = new Label(fanInfo, SWT.NULL);
		eMail.setText("eMail:");
		
		Label phone = new Label(fanInfo, SWT.PUSH);
		phone.setText("Phone:");
		
		mailText = new Text(fanInfo, SWT.SINGLE | SWT.BORDER);
		phoneText = new Text(fanInfo, SWT.SINGLE | SWT.BORDER);
		
		data = new FormData();
		data.top = new FormAttachment(mailText, 0, SWT.CENTER);
		eMail.setLayoutData(data);
		
		data = new FormData();
		data.top = new FormAttachment(phoneText, 0, SWT.CENTER);
		phone.setLayoutData(data);
		
		data = new FormData();
		data.left = new FormAttachment(phone, 5);
		data.right = new FormAttachment(100, 0);
		mailText.setLayoutData(data);
		
		data = new FormData();
		data.left = new FormAttachment(mailText, 0, SWT.LEFT);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(55, 0);
		phoneText.setLayoutData(data);
		
		shell.pack();
		
		return shell;
	}	
	
	
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new ComplexLayout().createShell(display);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}














//END