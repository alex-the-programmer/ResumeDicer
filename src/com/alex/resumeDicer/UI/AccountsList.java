package com.alex.resumeDicer.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.activity.InvalidActivityException;

import lombok.NonNull;
import lombok.val;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.alex.resumeDicer.Model.AccountInfoModel;

public class AccountsList extends Composite {

	private List<AccountInfo> accounts = new ArrayList<>();

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public AccountsList(Composite parent, int style) {
		super(parent, SWT.BORDER | SWT.V_SCROLL);
		setLayout(new FillLayout(SWT.VERTICAL));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public int getAccounts() throws InvalidActivityException {
		throw new InvalidActivityException();
	}

	public List<AccountInfoModel> getAccountInfoModels() {
		return accounts.stream().map(i -> i.getAccountInfoModel()).collect(Collectors.toList());
	}

	public void setAccountInfoModels(List<AccountInfoModel> models) {
		for (val model : models)
			addAccountInfoModel(model);
	}

	public void addAccountInfoModel(AccountInfoModel model) {
		val accountInfo = new AccountInfo(this, SWT.NONE);
		accountInfo.setAccountInfo(model);
		accounts.add(accountInfo);
		layout(true);
	}

	public void removeAccountInfo(@NonNull AccountInfo accountInfo) {
		accounts.remove(accountInfo);
		layout(true);
	}
}
