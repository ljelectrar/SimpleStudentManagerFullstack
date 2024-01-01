package com.ljelectrar.views;

import com.ljelectrar.models.Student;
import com.ljelectrar.services.StudentService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="/index")
@PageTitle(value="Home")
public class MainView extends VerticalLayout {
	
	// Constructor injection
	private final StudentService studentService;
	private LogoLayout logoLayout;
	private Grid<Student> grid;
	private TextField filterField;
	
	public MainView(StudentService studentService ) {
		this.studentService = studentService;
		
		setSizeFull();
		setAlignItems(Alignment.CENTER);
		
		createFieldVariables();
		
		loadStudents();
		configureGrid();
		
		add(logoLayout, createToolBar(),grid);
	}
	
	private Component createToolBar() {
		filterField.setPlaceholder("Filter by name...");
		filterField.setClearButtonVisible(true);
		filterField.setValueChangeMode(ValueChangeMode.LAZY);
		filterField.addValueChangeListener(event -> updateStudents());

		return new HorizontalLayout(filterField);
	}
	
	private void updateStudents() {
		grid.setItems(studentService.find(filterField.getValue()));
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
			
			if(s.getStatus().getName().equals("ACTIVE")) {
				icon = VaadinIcon.CIRCLE.create();
				icon.setColor("green");
			} else if (s.getStatus().getName().equals("PASSIVE")) {
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
		this.logoLayout = new LogoLayout();
		this.grid = new Grid<>(Student.class);
		this.filterField = new TextField();
	}
	
	private void loadStudents() {
		grid.setItems(studentService.findAll());
	}	
	
}
