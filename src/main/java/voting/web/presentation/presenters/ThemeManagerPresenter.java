package voting.web.presentation.presenters;

import java.util.List;
import voting.rest.business.controllers.ThemeBusinessController;
import voting.web.presentation.models.Model;

public class ThemeManagerPresenter {

    private String themeName;

    public void setNameTheme(String themeName) {
        this.themeName = themeName;
    }

    public String getNameTheme() {
        return this.themeName;
    }

    public void createTheme(Model model) {
        new ThemeBusinessController().CreateTheme(this.getNameTheme());
    }

    public List<String> process() {
        List<String> themesList = new ThemeBusinessController().getThemes();
        return themesList;
    }

}
