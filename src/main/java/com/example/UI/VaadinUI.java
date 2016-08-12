package com.example.UI;

import com.example.model.Book;
import com.example.model.Passport;
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

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private final BookRepository bookRepo;
    private final UserRepository userRepo;
    private final BookEditor bookEditor;
    private final UserEditor userEditor;
    private final Grid booksGrid;
    private final Grid usersGrid;
    private final TextField filter;
    private final Button addNewBtn;
    private final Button booksOnHandsBtn;
    private final Button newUserBtn;
    private final Button registerBtn;
    private final Button allUsersBtn;

    @Autowired
    public VaadinUI(BookRepository bookRepo, BookEditor bookEditor, UserRepository userRepo, UserEditor userEditor) {
        this.bookRepo = bookRepo;
        this.bookEditor = bookEditor;
        this.userEditor = userEditor;
        this.booksGrid = new Grid();
        this.usersGrid = new Grid();
        this.allUsersBtn = new Button("Users");
        this.booksOnHandsBtn = new Button("Books at users");
        this.newUserBtn = new Button("Add user", FontAwesome.PLUS);
        this.registerBtn = new Button("Checkout");
        this.userRepo = userRepo;
        this.filter = new TextField();
        this.addNewBtn = new Button("Add book", FontAwesome.PLUS);
    }

    @Override
    protected void init(VaadinRequest request) {
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn, booksOnHandsBtn);
        VerticalLayout bookControls = new VerticalLayout(actions, booksGrid, bookEditor);
        VerticalLayout userControls = new VerticalLayout(new HorizontalLayout(newUserBtn, allUsersBtn), usersGrid, userEditor);
        HorizontalLayout mainLayout = new HorizontalLayout(bookControls, userControls);
        setContent(mainLayout);
        actions.setSpacing(true);
        bookControls.setSpacing(true);
        userControls.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);
        booksGrid.setWidth(600, Unit.PIXELS);
        booksGrid.setColumns("id", "name", "author", "genre", "pagecount", "description");
        usersGrid.setSizeFull();
        usersGrid.setColumns("id", "userFullName", "passport");
        usersGrid.setContainerDataSource(new BeanItemContainer(User.class, userRepo.findAll()));
        filter.setInputPrompt("Filter by name");
        filter.addTextChangeListener(e -> VaadinUI.this.listBooks(e.getText()));

        booksGrid.addSelectionListener(e -> {
            if (e.getSelected().isEmpty()) {
                bookEditor.setVisible(false);
            } else {
                bookEditor.editBook((Book) e.getSelected().iterator().next());
            }
        });
        addNewBtn.addClickListener(e -> bookEditor.editBook(new Book("")));
        newUserBtn.addClickListener(clickEvent -> userEditor.editUser(new User(""), new Passport("")));
        bookEditor.setChangeHandler(() -> {
            bookEditor.setVisible(false);
            VaadinUI.this.listBooks(filter.getValue());
        });
        listBooks(null);
        userEditor.setChangeHandler(() -> {
            userEditor.setVisible(false);
            VaadinUI.this.listUsers();
        });
        listBooks(null);
    }

    @SuppressWarnings("unchecked")
    private void listBooks(String text) {
        if (StringUtils.isEmpty(text)) {
            booksGrid.setContainerDataSource(
                    new BeanItemContainer(Book.class, bookRepo.findAll()));
        } else {
            booksGrid.setContainerDataSource(new BeanItemContainer(Book.class,
                    bookRepo.findByNameStartsWithIgnoreCase(text)));
        }
    }

    private void listUsers() {
        usersGrid.setContainerDataSource(new BeanItemContainer(User.class, userRepo.findAll()));
    }
}
