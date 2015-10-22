package voting.web.presentation.views;

import java.util.ArrayList;
import java.util.List;

import voting.rest.business.controllers.ThemeBusinessController;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.views.ThemeTransfer;
import voting.web.presentation.models.Model;

public class ThemeManagerView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Theme Manager Page\n");

        //String s = (String) model.get("themeName");
        //System.out.println(s + "\n");

        List<String> themesList = (List<String>) model.get("themeName");
        System.out.print("Temas: [ ");
        for (int i = 0; i < themesList.size(); i++) {
            System.out.print(themesList.get(i) + " ");
        }
        System.out.print("] \n");

    }
}
