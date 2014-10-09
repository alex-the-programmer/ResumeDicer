package com.alex.resumeDicer.UI;

import lombok.Getter;
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
import org.eclipse.swt.widgets.ProgressBar;

import com.alex.resumeDicer.Model.AccountInfoModel;

public class AccountsEmbedder extends Composite {

	@Getter
	private AccountsList accountsList;
	private Button image;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AccountsEmbedder(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());

		image = new Button(this, SWT.FLAT);
		image.setEnabled(false);
		FormData fd_image = new FormData();
		fd_image.bottom = new FormAttachment(0, 113);
		fd_image.right = new FormAttachment(0, 450);
		fd_image.top = new FormAttachment(0, 10);
		fd_image.left = new FormAttachment(0, 10);
		image.setLayoutData(fd_image);

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				val accountsList = ((AccountsEmbedder) ((Control) event.getSource()).getParent()).getAccountsList();
				accountsList.addAccountInfoModel(new AccountInfoModel());
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.bottom = new FormAttachment(image, 0, SWT.BOTTOM);
		fd_btnNewButton.right = new FormAttachment(100, -10);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Add account");

		accountsList = new AccountsList(this, SWT.NONE);
		FormData fd_accountsList = new FormData();
		fd_accountsList.bottom = new FormAttachment(image, 333, SWT.BOTTOM);
		fd_accountsList.right = new FormAttachment(btnNewButton, 0, SWT.RIGHT);
		fd_accountsList.top = new FormAttachment(image, 6);
		fd_accountsList.left = new FormAttachment(image, 0, SWT.LEFT);
		accountsList.setLayoutData(fd_accountsList);

		ProgressBar progressBar = new ProgressBar(this, SWT.NONE);
		progressBar.setEnabled(false);
		FormData fd_progressBar = new FormData();
		fd_progressBar.right = new FormAttachment(btnNewButton, 0, SWT.RIGHT);
		fd_progressBar.bottom = new FormAttachment(100, -10);
		fd_progressBar.left = new FormAttachment(0, 10);
		progressBar.setLayoutData(fd_progressBar);

		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setEnabled(false);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.right = new FormAttachment(btnNewButton, 0, SWT.RIGHT);
		fd_btnNewButton_1.top = new FormAttachment(accountsList, 6);
		fd_btnNewButton_1.left = new FormAttachment(0, 10);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Run update");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void setLogoImage(String imagePath) {
		// image.setImage(new );
	}
}
