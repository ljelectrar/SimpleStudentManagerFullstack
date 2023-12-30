package com.ljelectrar.views;

import java.util.ArrayList;
import java.util.List;

import com.ljelectrar.models.Status;
import com.ljelectrar.models.Student;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="/index")
@PageTitle(value="Home")
public class MainView extends VerticalLayout {
	
	private LogoLayout logoLayout;
	
	private Grid<Student> grid;
	
	public MainView() {
		
		
		setSizeFull();
		setAlignItems(Alignment.CENTER);
		
		createFieldVariables();
		
		loadStudents();
		configureGrid();
		
		add(logoLayout ,grid);
	}
	
	private void configureGrid() {
		grid.setSizeFull();
		grid.setColumns("country", "zipcode");
		grid.addColumn(s-> s.getName()).setHeader("name");
		grid.addColumn(s -> s.getAge()).setHeader("Age");
		
		grid.addComponentColumn(s -> {
			//using different colored icons
			// to different status
			Icon icon;
			
			if(s.getStatus().equals("ACTIVE")) {
				icon = VaadinIcon.CIRCLE.create();
				icon.setColor("green");
			} else if (s.getStatus().equals("PASSIVE")) {
				icon = VaadinIcon.CLOSE_CIRCLE.create();
				icon.setColor("red");
			} else {
				icon = VaadinIcon.CHECK_CIRCLE.create();
				icon.setColor("orange");
			}
			
			return icon;
		}).setHeader("Status");
	
		
		grid.getColumns().forEach(col -> col.setAutoWidth(true));
	}
	
	private void createFieldVariables() {
		logoLayout = new LogoLayout();
		grid = new Grid<>(Student.class);
	}
	
	private void loadStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Leandro Junior", 28, 27257515, "BR", new Status("ACTIVE")));
		students.add(new Student("Maiara", 21, 27257500, "BR", new Status("PASSIVE")));
		students.add(new Student("Julia", 26, 27257500, "BR", new Status("ABSOLVED")));
		grid.setItems(students);
	}	
	
}
