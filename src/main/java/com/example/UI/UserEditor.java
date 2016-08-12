package com.example.UI;

import com.example.model.Passport;
import com.example.model.User;
import com.example.repository.PassportRepository;
import com.example.repository.UserRepository;
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
public class UserEditor extends VerticalLayout {

    private final UserRepository userRepository;
    private final PassportRepository passportRepository;
    private User user;
    private Passport passport;

    TextField userFullName = new TextField("Full name");
    TextField series = new TextField("Series");
    TextField number = new TextField("Number");
    PopupDateField dateOfBirth = new PopupDateField("Date of Birth");
    TextField placeOfIssue = new TextField("Кем выдан");
    PopupDateField dateOfIssue = new PopupDateField("Date of issue");
    TextField residence = new TextField("Residence");
    Button save = new Button("Save", FontAwesome.SAVE);
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", FontAwesome.TRASH_O);
    CssLayout actions = new CssLayout(save, cancel, delete);

    @Autowired
    public UserEditor(UserRepository userRepository, PassportRepository passportRepository) {
        this.userRepository = userRepository;
        this.passportRepository = passportRepository;
        addComponents(userFullName, series, number, dateOfBirth, placeOfIssue, dateOfIssue, residence, actions);
        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        save.addClickListener(e -> {
            this.user.setPassport(this.passport);
            passportRepository.save(passport);
            userRepository.save(user);
        }); // todo saveAndFlush vs save
        delete.addClickListener(e -> {
            userRepository.delete(user); //todo вместе с юзером должен удаляться его паспорт
        });
        cancel.addClickListener(e -> editUser(user, passport));
        setVisible(false);
    }

    public final void editUser(User user, Passport passport) {
        this.passport = passport;
        this.user = user;
        BeanFieldGroup.bindFieldsUnbuffered(this.passport, this);
        BeanFieldGroup.bindFieldsUnbuffered(this.user, this);
        setVisible(true);
    }

    public void setChangeHandler(ChangeHandler h) {
        save.addClickListener(e -> h.onChange());
        delete.addClickListener(e -> h.onChange());
    }

    public interface ChangeHandler {
        void onChange();
    }
}
