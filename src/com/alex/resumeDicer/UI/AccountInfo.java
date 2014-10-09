package com.alex.resumeDicer.UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class AccountInfo extends Composite {
	private Text text;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AccountInfo(Composite parent, int style) {
		super(parent, SWT.BORDER);
		setLayout(new FormLayout());

		Label lblAccountEmailAddress = new Label(this, SWT.NONE);
		FormData fd_lblAccountEmailAddress = new FormData();
		fd_lblAccountEmailAddress.top = new FormAttachment(0, 10);
		fd_lblAccountEmailAddress.left = new FormAttachment(0, 10);
		lblAccountEmailAddress.setLayoutData(fd_lblAccountEmailAddress);
		lblAccountEmailAddress.setText("Account email address:");

		text = new Text(this, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(0, 183);
		fd_text.top = new FormAttachment(lblAccountEmailAddress, 6);
		fd_text.left = new FormAttachment(0, 10);
		text.setLayoutData(fd_text);

		Label lblPassword = new Label(this, SWT.NONE);
		FormData fd_lblPassword = new FormData();
		fd_lblPassword.top = new FormAttachment(lblAccountEmailAddress, 0, SWT.TOP);
		lblPassword.setLayoutData(fd_lblPassword);
		lblPassword.setText("Password:");

		text_1 = new Text(this, SWT.BORDER | SWT.PASSWORD);
		fd_lblPassword.left = new FormAttachment(text_1, 0, SWT.LEFT);
		FormData fd_text_1 = new FormData();
		fd_text_1.top = new FormAttachment(lblPassword, 6);
		fd_text_1.right = new FormAttachment(text, 179, SWT.RIGHT);
		fd_text_1.left = new FormAttachment(text, 6);
		text_1.setLayoutData(fd_text_1);

		Button btnNewButton = new Button(this, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(text, -2, SWT.TOP);
		fd_btnNewButton.left = new FormAttachment(text_1, 6);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Remove");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
