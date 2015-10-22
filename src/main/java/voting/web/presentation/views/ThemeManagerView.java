package voting.web.presentation.views;

import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.web.presentation.models.Model;

public class ThemeManagerView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Theme Manager Page\n");
        String themeName = (String) model.get("themeName");
       /* Object object = model.get("themeName");
        Theme theme = (Theme) object;*/
        System.out.print("Temas: [ ");
            
            // TODO

            System.out.print(themeName + " ");
            // for (String themeName : themesList) {
            // System.out.print(themeName + " ");
            // }
        
        System.out.print("] \n");

    }
}
