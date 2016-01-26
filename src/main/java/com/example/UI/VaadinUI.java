package com.example.UI;

import com.example.model.Book;
import com.example.repository.BookRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private final BookRepository repo;

    private final BookEditor editor;

    private final Grid grid;

    private final TextField filter;

    private final Button addNewBtn;

    @Autowired
    public VaadinUI(BookRepository repo, BookEditor editor) {
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid();
        this.filter = new TextField();
        this.addNewBtn = new Button("New customer", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);

        // Configure layouts and components
        actions.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        grid.setHeight(300, Unit.PIXELS);
        grid.setWidth(910, Unit.PIXELS);
        grid.setColumns("id", "name", "authorId", "genreId", "pagecount", "description");

        filter.setInputPrompt("Filter by id");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.addTextChangeListener(e -> listCustomers(e.getText()));

        // Connect selected Customer to editor or hide if none is selected
        grid.addSelectionListener(new SelectionEvent.SelectionListener() {
            @Override
            public void select(SelectionEvent e) {
                if (e.getSelected().isEmpty()) {
                    editor.setVisible(false);
                } else {
                    editor.editCustomer((Book) e.getSelected().iterator().next());
                }
            }
        });

        // Instantiate and edit new Book the new button is clicked
        addNewBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent e) {
                editor.editCustomer(new Book(""));//todo аргумент конструктора поставить
            }
        });

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(new BookEditor.ChangeHandler() {
            @Override
            public void onChange() {
                editor.setVisible(false);
                VaadinUI.this.listCustomers(filter.getValue());
            }
        });

        // Initialize listing
        listCustomers(null);
    }

    // tag::listCustomers[]
    private void listCustomers(String text) {
        if (StringUtils.isEmpty(text)) {
            grid.setContainerDataSource(
                    new BeanItemContainer(Book.class, repo.findAll()));
        }
        // end::listCustomers[]

    }
}
