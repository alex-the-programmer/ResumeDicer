package com.alex.resumeDicer.UI;

import lombok.val;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

import com.alex.resumeDicer.Model.AccountInfoModel;

public class AccountsEmbedder extends Composite {
	private Button image;
	private AccountsList accountsList;

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

		Button btnAddAccount = new Button(this, SWT.NONE);
		btnAddAccount.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				val accountsList = ((AccountsEmbedder) ((Control) event.getSource()).getParent()).accountsList;
				accountsList.addAccountInfoModel(new AccountInfoModel());
			}
		});
		FormData fd_btnAddAccount = new FormData();
		fd_btnAddAccount.bottom = new FormAttachment(image, 0, SWT.BOTTOM);
		fd_btnAddAccount.right = new FormAttachment(100, -10);
		btnAddAccount.setLayoutData(fd_btnAddAccount);
		btnAddAccount.setText("Add account");

		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.top = new FormAttachment(image, 6);
		fd_scrolledComposite.right = new FormAttachment(100, -10);
		fd_scrolledComposite.left = new FormAttachment(image, 0, SWT.LEFT);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		ProgressBar progressBar = new ProgressBar(this, SWT.NONE);
		progressBar.setEnabled(false);
		FormData fd_progressBar = new FormData();
		fd_progressBar.right = new FormAttachment(btnAddAccount, 0, SWT.RIGHT);
		fd_progressBar.bottom = new FormAttachment(100, -10);
		fd_progressBar.left = new FormAttachment(0, 10);
		progressBar.setLayoutData(fd_progressBar);

		Button btnRunUpdate = new Button(this, SWT.NONE);
		fd_scrolledComposite.bottom = new FormAttachment(btnRunUpdate, -6);

		accountsList = new AccountsList(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(accountsList);
		scrolledComposite.setMinSize(accountsList.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		btnRunUpdate.setEnabled(false);
		FormData fd_btnRunUpdate = new FormData();
		fd_btnRunUpdate.left = new FormAttachment(btnAddAccount, 0, SWT.LEFT);
		fd_btnRunUpdate.top = new FormAttachment(image, 339);
		fd_btnRunUpdate.right = new FormAttachment(btnAddAccount, 0, SWT.RIGHT);
		btnRunUpdate.setLayoutData(fd_btnRunUpdate);
		btnRunUpdate.setText("Run update");

		Label lblBrowser = new Label(this, SWT.NONE);
		FormData fd_lblBrowser = new FormData();
		fd_lblBrowser.top = new FormAttachment(scrolledComposite, 6);
		fd_lblBrowser.left = new FormAttachment(image, 0, SWT.LEFT);
		lblBrowser.setLayoutData(fd_lblBrowser);
		lblBrowser.setText("Browser:");

		Button btnChrome = new Button(this, SWT.RADIO);
		btnChrome.setSelection(true);
		FormData fd_btnChrome = new FormData();
		fd_btnChrome.top = new FormAttachment(lblBrowser, 6);
		fd_btnChrome.left = new FormAttachment(0, 10);
		btnChrome.setLayoutData(fd_btnChrome);
		btnChrome.setText("Chrome");

		Button btnFirefox = new Button(this, SWT.RADIO);
		FormData fd_btnFirefox = new FormData();
		fd_btnFirefox.left = new FormAttachment(btnChrome, 5);
		fd_btnFirefox.top = new FormAttachment(btnChrome, 0, SWT.TOP);
		btnFirefox.setLayoutData(fd_btnFirefox);
		btnFirefox.setText("Firefox");

		Button btnSafari = new Button(this, SWT.RADIO);
		FormData fd_btnSafari = new FormData();
		fd_btnSafari.top = new FormAttachment(btnChrome, 0, SWT.TOP);
		fd_btnSafari.left = new FormAttachment(btnFirefox, 6);
		btnSafari.setLayoutData(fd_btnSafari);
		btnSafari.setText("Safari");

		Button btnInternetexplorer = new Button(this, SWT.RADIO);
		FormData fd_btnInternetexplorer = new FormData();
		fd_btnInternetexplorer.top = new FormAttachment(btnChrome, 0, SWT.TOP);
		fd_btnInternetexplorer.left = new FormAttachment(btnSafari, 6);
		btnInternetexplorer.setLayoutData(fd_btnInternetexplorer);
		btnInternetexplorer.setText("InternetExplorer");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void setLogoImage(String imagePath) {
		// image.setImage(new );
	}
}
