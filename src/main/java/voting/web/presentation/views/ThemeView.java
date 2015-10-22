package voting.web.presentation.views;

import java.util.List;

import voting.web.presentation.models.Model;

public class ThemeView implements View {
    @Override
    public void show(Model model) {
        System.out.println("----- ThemeManager ------\n");

        List<String> themesList = (List<String>) model.get("msg");
        System.out.print("Temas: [ ");
        for (String themeName : themesList) {
            System.out.print(themeName + " ");
        }
        System.out.print("] \n");
    }
}
