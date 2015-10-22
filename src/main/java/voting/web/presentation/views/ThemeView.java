package voting.web.presentation.views;

import java.util.List;

import voting.web.presentation.models.Model;

public class ThemeView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Theme Manager Page\n");

        List<String> themesList = (List<String>) model.get("msg");
        System.out.print("Temas: [ ");
      //TODO
        /*for (String themeName : themesList) {
            System.out.print(themeName + " ");
        }
        */
        System.out.print("] \n");
    }
}
