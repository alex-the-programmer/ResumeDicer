package com.alex.resumeDicer.UI;

import lombok.val;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.alex.resumeDicer.Model.AccountInfoModel;

public class AccountInfo extends Composite {

	private Text emailAddress;
	private Text password;

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

		emailAddress = new Text(this, SWT.BORDER);
		FormData fd_emailAddress = new FormData();
		fd_emailAddress.right = new FormAttachment(0, 183);
		fd_emailAddress.top = new FormAttachment(lblAccountEmailAddress, 6);
		fd_emailAddress.left = new FormAttachment(0, 10);
		emailAddress.setLayoutData(fd_emailAddress);

		Label lblPassword = new Label(this, SWT.NONE);
		FormData fd_lblPassword = new FormData();
		fd_lblPassword.top = new FormAttachment(lblAccountEmailAddress, 0, SWT.TOP);
		lblPassword.setLayoutData(fd_lblPassword);
		lblPassword.setText("Password:");

		password = new Text(this, SWT.BORDER | SWT.PASSWORD);
		fd_lblPassword.left = new FormAttachment(password, 0, SWT.LEFT);
		FormData fd_password = new FormData();
		fd_password.top = new FormAttachment(lblPassword, 6);
		fd_password.right = new FormAttachment(emailAddress, 179, SWT.RIGHT);
		fd_password.left = new FormAttachment(emailAddress, 6);
		password.setLayoutData(fd_password);

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				val accountInfo = (AccountInfo) ((Control) event.getSource()).getParent();
				val accountsList = (AccountsList) accountInfo.getParent();
				accountsList.removeAccountInfo(accountInfo);
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(emailAddress, -2, SWT.TOP);
		fd_btnNewButton.left = new FormAttachment(password, 6);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Remove");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void setAccountInfo(AccountInfoModel model) {
		if (model == null || model.getEmailAdress() == null || model.getPassword() == null)
			return;

		this.emailAddress.setText(model.getEmailAdress());
		this.password.setText(model.getPassword());
	}

	public AccountInfoModel getAccountInfoModel() {
		return new AccountInfoModel(emailAddress.getText(), password.getText());
	}
}
