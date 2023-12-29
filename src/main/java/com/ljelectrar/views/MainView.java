package com.ljelectrar.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="/index")
@PageTitle(value="Home")
public class MainView extends VerticalLayout {
	
	public MainView() {
		add(new Button("Click", event ->{
			add(new Text("Hello World"));
		}));
	}
	
}
