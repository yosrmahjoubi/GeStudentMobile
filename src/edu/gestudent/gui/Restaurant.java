package edu.gestudent.gui;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant extends Form {
    static Form currentForm;

    public Restaurant(Form previous, Resources theme) {
        currentForm = this;
        setTitle("Restaurant");
        setLayout(new BorderLayout());
       // currentForm.setLayout();
        //currentForm.setTitle("List Plat");
        // currentForm = hi ;
        int mm = Display.getInstance().convertToPixels(3);
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
        Image icon1 = URLImage.createToStorage(placeholder, "icon1", "http://www.georgerrmartin.com/wp-content/uploads/2013/03/GOTMTI2.jpg");
        Image icon2 = URLImage.createToStorage(placeholder, "icon2", "http://www.georgerrmartin.com/wp-content/uploads/2012/08/clashofkings.jpg");
        Image icon3 = URLImage.createToStorage(placeholder, "icon3", "http://www.georgerrmartin.com/wp-content/uploads/2013/03/stormswordsMTI.jpg");
        Image icon4 = URLImage.createToStorage(placeholder, "icon4", "http://www.georgerrmartin.com/wp-content/uploads/2012/08/feastforcrows.jpg");
        Image icon5 = URLImage.createToStorage(placeholder, "icon5", "http://georgerrmartin.com/gallery/art/dragons05.jpg");

        ArrayList<Map<String, Object>> data = new ArrayList<>();
        data.add(createListEntry("Pasta", "Epuisé", icon1));
        data.add(createListEntry("Poulet", "Epuisé", icon2));
        data.add(createListEntry("Loubia", "Epuisé", icon3));
        data.add(createListEntry("K3aber fruit de mer", "Epuisé", icon4));
        data.add(createListEntry("Pizza 4 saisons", "Epuisé", icon5));
        data.add(createListEntry("Sandiwch escalope", "Epuisé", placeholder));
        data.add(createListEntry("Leblebi", "Epuisé", placeholder));

        DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
        MultiList ml = new MultiList(model);
        currentForm.add(BorderLayout.CENTER, ml);
        currentForm.show();

        getToolbar().addCommandToOverflowMenu("Registration", null, ev -> {
            Regisration().show();
        });

        getToolbar().addMaterialCommandToLeftBar("back", FontImage.MATERIAL_ARROW_BACK, ev -> {
            previous.showBack();
        });
    }

    public Form Regisration() {


        Form AddClub = new Form("Register", new FlowLayout(Component.CENTER, Component.CENTER));
        AddClub.getToolbar().addMaterialCommandToLeftBar("back", FontImage.MATERIAL_ARROW_BACK, ev -> {
            currentForm.showBack();
        });

        return AddClub;
    }

    private Map<String, Object> createListEntry(String name, String date, Image icon) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", date);
        entry.put("icon", icon);
        return entry;
    }

}