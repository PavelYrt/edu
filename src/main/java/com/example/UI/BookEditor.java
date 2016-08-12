package com.example.UI;

import com.example.model.Author;
import com.example.model.Book;
import com.example.model.Genre;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;
import com.example.repository.GenreRepository;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class BookEditor extends VerticalLayout {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    TextField name = new TextField("name");
    ComboBox authorName;
    ComboBox genreName;
    TextField pagecount = new TextField("pagecount");
    TextField description = new TextField("description");
    Button save = new Button("Save", FontAwesome.SAVE);
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", FontAwesome.TRASH_O);
    CssLayout actions = new CssLayout(save, cancel, delete);

    private Book book;

    @Autowired
    public BookEditor(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        authorName = new ComboBox("Author", authorRepository.findAll());
        genreName = new ComboBox("Genre", genreRepository.findAll());
        authorName.setNullSelectionAllowed(false);
        genreName.setNullSelectionAllowed(false);
        authorName.addValueChangeListener(e -> book.setAuthor((Author) e.getProperty().getValue()));
        genreName.addValueChangeListener(e -> book.setGenre((Genre) e.getProperty().getValue())); // todo transactions
        addComponents(name, authorName, genreName, pagecount, description, actions);
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        save.addClickListener(e -> bookRepository.saveAndFlush(book)); // todo saveAndFlush vs save
        delete.addClickListener(e -> bookRepository.delete(book));
        cancel.addClickListener(e -> editBook(book));
        setVisible(false);
    }

    public final void editBook(Book book) {
        final boolean persisted = book.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            this.book = bookRepository.findOne(book.getId());
        } else {
            this.book = book;
        }
        cancel.setVisible(persisted);
        BeanFieldGroup.bindFieldsUnbuffered(this.book, this);
        setVisible(true);
        save.focus();
        name.selectAll();
    }

    public void setChangeHandler(ChangeHandler h) {
        save.addClickListener(e -> h.onChange());
        delete.addClickListener(e -> h.onChange());
    }

    public interface ChangeHandler {
        void onChange();
    }
}
