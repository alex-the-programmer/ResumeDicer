package com.alex.resumeDicer.UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;

public class AccountsList extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AccountsList(Composite parent, int style) {
		super(parent, SWT.V_SCROLL);
		setLayout(new StackLayout());

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
