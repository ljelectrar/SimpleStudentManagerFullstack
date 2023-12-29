package com.ljelectrar.views;

import java.util.ArrayList;
import java.util.List;

import com.ljelectrar.models.Status;
import com.ljelectrar.models.Student;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="/index")
@PageTitle(value="Home")
public class MainView extends VerticalLayout {
	
	private Grid<Student> grid;
	
	public MainView() {
		
		setSizeFull();
		setAlignItems(Alignment.CENTER);
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("Leandro Junior", 28, 27257515, "BR", new Status("Reactive")));
		
		// GRID
		grid = new Grid<>(Student.class);
		grid.setItems(students);
		
		add(grid);
	}
	
}
