package com.ljelectrar.views;

import java.util.Set;

import com.ljelectrar.models.Student;
import com.ljelectrar.services.StudentService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("REMOVE STUDENT")
@Route(value = "remove-student")
public class RemoveStudentView extends VerticalLayout {

	private Grid<Student> grid;
	private final StudentService studentService;
	private Button remove;
	private Button cancel;

	private Set<Student> selected;

	public RemoveStudentView(StudentService studentService) {

		this.studentService = studentService;

		setSizeFull();
		setAlignItems(Alignment.CENTER);

		createFieldVariables();
		configureGrid();

		add(grid, createButtonLayout());

		loadStudents();

	}

	private void loadStudents() {
		grid.setItems(studentService.findAll());
		grid.setSelectionMode(SelectionMode.MULTI);
	}

	private Component createButtonLayout() {
		remove.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

		cancel.addClickListener(event -> closeView());
		remove.addClickListener(event -> removeSelected());

		return new HorizontalLayout(remove, cancel);
	}

	private void removeSelected() {

	}

	private void closeView() {
		getUI().ifPresent(ui -> ui.navigate(""));
	}

	private void configureGrid() {
		grid.setSizeFull();
		grid.setColumns("country", "zipcode");
		grid.addColumn(s -> s.getName()).setHeader("name");
		grid.addColumn(s -> s.getAge()).setHeader("Age");

		grid.addComponentColumn(s -> {
			// using different colored icons
			// to different status
			Icon icon;

			if (s.getStatus().getName().equals("ACTIVE")) {
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
	}

	private void createFieldVariables() {
		grid = new Grid<>(Student.class);
		remove = new Button("Remove");
		cancel = new Button("Cancel");

	}

}
