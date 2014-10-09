package com.alex.resumeDicer.Service;

import lombok.NonNull;

import org.openqa.selenium.WebDriver;

import com.alex.resumeDicer.Model.AccountInfoModel;

public abstract class ServiceBase implements Runnable {

	private WebDriver driver;
	private AccountInfoModel model;

	public ServiceBase(@NonNull WebDriver driver, @NonNull AccountInfoModel model) {
		this.driver = driver;
		this.model = model;
	}

	public abstract void authenticate();

	public abstract void runUpdate();

	@Override
	public void run() {
		authenticate();
		runUpdate();
	}
}
