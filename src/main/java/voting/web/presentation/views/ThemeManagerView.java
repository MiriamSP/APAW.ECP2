package voting.web.presentation.views;

import java.util.List;
import voting.web.presentation.models.Model;

public class ThemeManagerView implements View {
    @Override
    public void show(Model model) {
        System.out.println("Theme Manager Page\n");
        List<String> themesList = (List<String>) model.get("themeName");
        System.out.print("Temas: [");
        for (int i = 0; i < themesList.size(); i++) {
            System.out.print(themesList.get(i));
            if (i < themesList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("] \n");
    }
}
