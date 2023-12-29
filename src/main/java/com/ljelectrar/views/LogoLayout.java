package com.ljelectrar.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LogoLayout extends HorizontalLayout {
	
	private Image image;
	
	public LogoLayout() {
		image = new Image("../../images/logo.png", "My image");
		
		image.setHeight("250px");
		image.setWidth("250px");
		
		setJustifyContentMode(JustifyContentMode.CENTER);
		
		add(image);
	}
	
}
