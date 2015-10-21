package voting.web.presentation.views;

import voting.web.presentation.models.Model;

public class ThemeView implements View {

    @Override
    public void show(Model model) {
        System.out.println("ThemeManager \n" + model.get("msg"));
    }

}
