/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import edu.gestudent.entities.user;

/**
 *
 * @author Ayadi
 */
public class Login extends Form {

    Form current;
    private static user User;

    public Login(Resources theme) {
        current = this; //Récupérsation de l'interface(Form) en cours
        setTitle("GeStudent");
        setLayout(new FlowLayout(Component.CENTER, Component.CENTER));
        ImageViewer imageName = new ImageViewer(theme.getImage("gestudent.png"));
        Container cnt = new Container(BoxLayout.y());

        TextField username = new TextField(null, "username");
        TextField password = new TextField(null, "password");

        Button login = new Button("login");

        cnt.add(imageName);
        cnt.add(username);
        cnt.add(password);
        cnt.add(login);
        add(cnt);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                {

                    if (username.getText().equalsIgnoreCase("yosr") && password.getText().equalsIgnoreCase("yosr")){
                        new Student(current,theme).show();
                    }else {
                        new Teacher(current,theme).show();

                    }
                    /*User = ServicesUsers.getInstance().Login(username.getText(), password.getText());
                    if (User != null) {

                        username.setText("");
                        password.setText("");
                        Session.start(User);
                        
                        if (User.getRoles().equals("student")) {
                            new student(current,theme).show();
                        } else {
                          new teacher(current,theme).show();

                        }
                    } else {
                        Dialog.show("Alert", "This is already your home", "OK", null);
                    }*/

                }

            }
        });

    }

}
