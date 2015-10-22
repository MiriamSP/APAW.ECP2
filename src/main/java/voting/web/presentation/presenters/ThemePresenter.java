package voting.web.presentation.presenters;

import voting.rest.business.controllers.ThemeBusinessController;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.views.ThemeTransfer;
import voting.web.presentation.models.Model;

public class ThemePresenter {

    private String param1;

    private String param2;

    protected void setParam1(String param1) {
        this.param1 = param1;
    }

    protected void setParam2(String param2) {
        this.param2 = param2;
    }

    public String process_orig(Model model) {
        model.put("msg", "Mensaje de Helper1Controller");
        return "VotingView";
    }

    public String action1_orig(Model model) {
        model.put("msg", "Mensaje de Helper1Controller:action1:param1: " + param1);
        return "VotingView";
    }

    public String action2(Model model) {
        model.put("msg", "Mensaje de Helper1Controller:action2:param2: " + param2);
        return "VotingView";
    }
        
    public String process(Model model) {
        model.put("msg", "ThemePresenter:process");
        return "ThemeView";
    }
    
    public String action1(Model model) {
        model.put("msg", "ThemePresenter:action1");
        ThemeTransfer themeTransfer = new ThemeBusinessController().m1();
        model.put("themeTransfer", themeTransfer);
        return "ThemeView";
    }
    // TODO POST /ThemeManager?themeName=Tema1&action=createTheme HTTP/1.1
    //createTheme
    public void createTheme(Model model) {
        Object object = model.get("themeName");
        Theme theme = (Theme) object;        
      
        new ThemeBusinessController().CreateTheme(theme.getName());
    }
}
