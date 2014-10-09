package com.alex.resumeDicer.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NonNull;
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
import org.eclipse.swt.widgets.ProgressBar;

import com.alex.resumeDicer.Model.AccountInfoModel;

public class AccountsEmbedder extends Composite {
	private Button image;
	private ScrolledComposite scrolledComposite;
	private List<AccountInfo> accounts = new ArrayList<>();

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
				val accountsEmbedder = ((AccountsEmbedder) ((Control) event.getSource()).getParent());
				accountsEmbedder.addAccountInfoModel(new AccountInfoModel());
			}
		});
		FormData fd_btnAddAccount = new FormData();
		fd_btnAddAccount.bottom = new FormAttachment(image, 0, SWT.BOTTOM);
		fd_btnAddAccount.right = new FormAttachment(100, -10);
		btnAddAccount.setLayoutData(fd_btnAddAccount);
		btnAddAccount.setText("Add account");

		scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.V_SCROLL);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.right = new FormAttachment(100, -10);
		fd_scrolledComposite.top = new FormAttachment(image, 6);
		fd_scrolledComposite.left = new FormAttachment(image, 0, SWT.LEFT);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandVertical(true);

		ProgressBar progressBar = new ProgressBar(this, SWT.NONE);
		progressBar.setEnabled(false);
		FormData fd_progressBar = new FormData();
		fd_progressBar.right = new FormAttachment(btnAddAccount, 0, SWT.RIGHT);
		fd_progressBar.bottom = new FormAttachment(100, -10);
		fd_progressBar.left = new FormAttachment(0, 10);
		progressBar.setLayoutData(fd_progressBar);

		Button btnNewButton_1 = new Button(this, SWT.NONE);
		fd_scrolledComposite.bottom = new FormAttachment(btnNewButton_1, -6);
		btnNewButton_1.setEnabled(false);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.top = new FormAttachment(image, 339);
		fd_btnNewButton_1.right = new FormAttachment(btnAddAccount, 0, SWT.RIGHT);
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

	public List<AccountInfoModel> getAccountInfoModels() {
		return accounts.stream().map(i -> i.getAccountInfoModel()).collect(Collectors.toList());
	}

	public void setAccountInfoModels(List<AccountInfoModel> models) {
		for (val model : models)
			addAccountInfoModel(model);
	}

	public void addAccountInfoModel(AccountInfoModel model) {
		val accountInfo = new AccountInfo(scrolledComposite, SWT.NONE);
		accountInfo.setAccountInfo(model);
		accounts.add(accountInfo);
		scrolledComposite.layout(true);
		layout(true);
	}

	public void removeAccountInfo(@NonNull AccountInfo accountInfo) {
		accounts.remove(accountInfo);
		layout(true);
	}
}
