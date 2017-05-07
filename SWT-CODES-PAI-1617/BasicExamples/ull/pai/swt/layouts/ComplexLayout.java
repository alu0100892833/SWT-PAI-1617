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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/**
 * A bit more complex example of the FormLayout SWT layout.
 * It emulates the inscription application of a Zinedine Zidane fan club.
 * @author Óscar Darias Plasencia
 * @since 7-5-2017
 */
public class ComplexLayout { 
	 
	Image personalImage; 		/* Personal image of the fan (needs to be loaded by the user) */
	Text fanNameText; 			/* The text box for the user to introduce its name */
	Combo bornPlaceCombo;    	/* A Combo object with a few countries to indicate the place of birth */
	Canvas fanPhoto; 			/* The graphics to draw the loaded photo */
	List fanCategories;			/* A list of categories to clasify the fan */
	Text mailText;				/* The text box for the user to introduce its email */
	Text phoneText;				/* The text box for the user to introduce its phone number */

	/**
	 * Constructor for the main shell. 
	 * @param display The display object parent of the shell.
	 * @return The created Shell object.
	 */
	public Shell createShell(final Display display) {
		
		// MAIN DATA OF THE SHELL
		final Shell shell = new Shell(display);
		FormLayout layout = new FormLayout(); 
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		shell.setLayout(layout);
		shell.setText("Zidane FanClub"); 
		
		// DECLARES A GROUP FOR THE FAN´S INFORMATION
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
		
		// PHOTO SECTION
		Label photo = new Label(shell, SWT.NONE);
		photo.setText("Photo:");
		fanPhoto = new Canvas(shell, SWT.BORDER);
		
		Button browse = new Button(shell, SWT.PUSH);
		browse.setText("Browse...");
		
		Button delete = new Button(shell, SWT.PUSH); 
		delete.setText("Delete");
		
		// DECLARING CATEGORIES
		Label categories = new Label(shell, SWT.NONE);
		categories.setText("Categories");
		fanCategories = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		fanCategories.setItems(new String[] { "He´s not bad", "He´s pretty good",
				"He used to be better", "Great player, bad coach", "Best I´ve seen",
				"I would marry him" });
		
		// FORM DATA FOR FAN INFO SECTION
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
		
		// FORM DATA FOR PHOTO SECTION
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
		
		// BROWSE BUTTON OPENS A FILE DIALOG (FILE EXPLORER)
		browse.setLayoutData(data);
		browse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				String fileName = new FileDialog(shell).open();
				if (fileName != null) {
					personalImage = new Image(display, fileName);
				}
			}
		});
		
		// DELETE BUTTON REMOVES ANY LOADED PHOTO
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
		
		// ENTER NEEDS TO BE DECLARED HERE SO IT CAN BE USED TO ATTACH THE POSITION OF OTHER WIDGETS
		Button enter = new Button(shell, SWT.PUSH);
		enter.setText("Enter");
		
		// FAN CATEGORIES FORM DATA
		data = new FormData(90, 140);
		data.top = new FormAttachment(fanPhoto, 0, SWT.TOP);
		data.right = new FormAttachment(100, 0);
		data.bottom = new FormAttachment(enter, -5);
		fanCategories.setLayoutData(data);
		
		data = new FormData();
		data.bottom = new FormAttachment(fanCategories, -5);
		data.left = new FormAttachment(fanCategories, 0, SWT.CENTER);
		categories.setLayoutData(data);
		
		// ENTER BUTTON CONFIGURATION
		data = new FormData();
		data.right = new FormAttachment(100, 0);
		data.bottom = new FormAttachment(100, 0);
		enter.setLayoutData(data);
		enter.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				System.out.println("\nFan name: " + fanNameText.getText());
				System.out.println("Place of Birth: " + bornPlaceCombo.getText());
				System.out.println("eMail: " + mailText.getText());
				System.out.println("Phone: " + phoneText.getText());
				System.out.println("Fan category:");
				String cats[] = fanCategories.getSelection();
				enteredInformation(shell, fanNameText.getText(), bornPlaceCombo.getText(), cats, 
						mailText.getText(), phoneText.getText());
			}
		});
		
		data = new FormData();
		data.bottom = new FormAttachment(enter, -5);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(fanCategories, -5); 
		fanInfo.setLayoutData(data);
		
		// EMAIL AND PHONE TEXT BOXES LAYOUT CONFIGURATION
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
		
		// SET TO PREFERED SIZE AND RETURN THE SHELL OBJECT
		shell.pack();
		return shell;
	}	
	
	/**
	 * This method shows up a combo box with the introduced information. Should be called when the user presses ENTER.
	 * @param shell
	 * @param name
	 * @param birth
	 * @param categories
	 * @param email
	 * @param phone
	 */
	private void enteredInformation(final Shell shell, String name, String birth, String[] categories, String email, String phone) {
		MessageBox introduceInfo = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
		introduceInfo.setText(name + ", " + birth);
		String message = email + "\n" + phone + "\n\n" + "Love level: ";
		for (String love : categories)
			message += love + ", ";
		introduceInfo.setMessage(message);
		introduceInfo.open();
	}
	
	
	/**
	 * Main program that loads a shell using the createShell method.
	 * @param args Should be empty.
	 */
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