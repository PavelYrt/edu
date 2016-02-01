package com.example.UI;

import com.example.model.Book;
import com.example.model.User;
import com.example.repository.BookRepository;
import com.example.repository.UserRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private final BookRepository bookRepo;
    private final UserRepository userRepo;
    private final BookEditor editor;
    private final Grid grid;
    private final TextField filter;
    private final Button addNewBtn;
    private final Button booksOnHandsBtn;
    private final Button newUserBtn;
    private final Button registerBtn;
    private final ComboBox selectingUsers;

    @Autowired
    public VaadinUI(BookRepository bookRepo, BookEditor editor, UserRepository userRepo) {
        this.bookRepo = bookRepo;
        this.editor = editor;
        this.booksOnHandsBtn = new Button("Книги на руках");
        this.newUserBtn = new Button("Добавить пользователя");
        this.registerBtn = new Button("Оформить");
        this.userRepo = userRepo;
        this.selectingUsers = new ComboBox("Выбрать пользователя", listUsers());
        this.grid = new Grid();
        this.filter = new TextField();
        this.addNewBtn = new Button("Добавить книгу", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn, booksOnHandsBtn, newUserBtn, registerBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, selectingUsers, editor);
        setContent(mainLayout);

        // Configure layouts and components
        actions.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        grid.setHeight(300, Unit.PIXELS);
        grid.setWidth(910, Unit.PIXELS);
        grid.setColumns("id", "name", "author", "genre", "pagecount", "description");

        filter.setInputPrompt("Filter by name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.addTextChangeListener(e -> VaadinUI.this.listBooks(e.getText()));

        // Connect selected Customer to editor or hide if none is selected
        grid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                editor.setVisible(false);
            } else {
                editor.editBook((Book) e.getSelected().iterator().next());
            }
        });

        // Instantiate and edit new Book the new button is clicked
        addNewBtn.addClickListener(e -> {
            editor.editBook(new Book(""));//
        });

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            VaadinUI.this.listBooks(filter.getValue());
        });

        // Initialize listing
        listBooks(null);
    }

    @SuppressWarnings("unchecked")
    private void listBooks(String text) {
        if (StringUtils.isEmpty(text)) {
            grid.setContainerDataSource(
                    new BeanItemContainer(Book.class, bookRepo.findAll()));
        } else {
            grid.setContainerDataSource(new BeanItemContainer(Book.class,
                    bookRepo.findByNameStartsWithIgnoreCase(text)));
        }
    }

    private List<User> listUsers() {
        return userRepo.findAll();
    }
}
