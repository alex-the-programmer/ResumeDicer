package com.alex.resumeDicer.UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class AppWindow {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppWindow window = new AppWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlResumeDicer = new Shell();
		shlResumeDicer.setMinimumSize(new Point(823, 537));
		shlResumeDicer.setSize(832, 537);
		shlResumeDicer.setText("Resume Dicer");
		shlResumeDicer.setLayout(new FormLayout());

		TabFolder tabFolder = new TabFolder(shlResumeDicer, SWT.NONE);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.bottom = new FormAttachment(0, 488);
		fd_tabFolder.right = new FormAttachment(0, 806);
		fd_tabFolder.top = new FormAttachment(0, 10);
		fd_tabFolder.left = new FormAttachment(0, 10);
		tabFolder.setLayoutData(fd_tabFolder);

		TabItem tbtmDice = new TabItem(tabFolder, SWT.NONE);
		AccountsEmbedder diceAccountEmbedder = new AccountsEmbedder(tabFolder, SWT.NONE);
		diceAccountEmbedder.setLogoImage("Dice.png");
		tbtmDice.setControl(diceAccountEmbedder);
		tbtmDice.setText("Dice");

		TabItem tbtmMonster = new TabItem(tabFolder, SWT.NONE);
		AccountsEmbedder monsterAccountEmbedder = new AccountsEmbedder(tabFolder, SWT.NONE);
		tbtmMonster.setControl(monsterAccountEmbedder);
		tbtmMonster.setText("Monster");

		TabItem tbtmCareerbuilder = new TabItem(tabFolder, SWT.NONE);
		AccountsEmbedder careerBuilderAccountEmbedder = new AccountsEmbedder(tabFolder, SWT.NONE);
		tbtmCareerbuilder.setControl(careerBuilderAccountEmbedder);
		tbtmCareerbuilder.setText("CareerBuilder");

		shlResumeDicer.open();
		shlResumeDicer.layout();
		while (!shlResumeDicer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
