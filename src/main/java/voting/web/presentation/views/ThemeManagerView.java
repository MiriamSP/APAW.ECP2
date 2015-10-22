package voting.web.presentation.views;

import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.web.presentation.models.Model;

public class ThemeManagerView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Theme Manager Page\n");

        Object object = model.get("themeName");
        Theme theme = (Theme) object;
        System.out.print("Temas: [ ");
        if (theme != null) {
            
            // TODO

            System.out.print(theme.getName() + " ");
            // for (String themeName : themesList) {
            // System.out.print(themeName + " ");
            // }
        } else {
            System.out.print("Theme null");

        }

        System.out.print("] \n");

    }
}
