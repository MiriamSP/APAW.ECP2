package voting.web.presentation.presenters;

import java.util.List;

import voting.rest.business.controllers.ThemeBusinessController;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.views.ThemeTransfer;
import voting.web.presentation.models.Model;

public class ThemeManagerPresenter {

    private String param1;

    private String param2;
    
    private String themeName;


    public void setNameTheme(String themeName) {
        this.themeName = themeName;
    }
    
    public String getNameTheme() {
        return this.themeName ;
    }
    
    protected void setParam1(String param1) {
        this.param1 = param1;
    }
    

    protected void setParam2(String param2) {
        this.param2 = param2;
    }

    public String process_orig(Model model) {
        model.put("themeName", "Mensaje de Helper1Controller");
        return "ThemeManagerView";
    }

    public String action1_orig(Model model) {
        model.put("msg", "Mensaje de Helper1Controller:action1:param1: " + param1);
        return "ThemeManagerView";
    }

    public String action2(Model model) {
        model.put("msg", "Mensaje de Helper1Controller:action2:param2: " + param2);
        return "VotingView";
    }
        
    public ThemeTransfer process2() {
        ThemeTransfer themeTransfer = new ThemeBusinessController().m1();
        return themeTransfer;
    }
    
    public List<String> process() {
        List<String> themesList = new ThemeBusinessController().getThemes();
        return themesList;
    }

    
    public String process(Model model) {
      //  model.put("themeName", "ThemePresenter:process");
        model.put("themeName", new ThemeBusinessController());
        return "ThemeManagerView";
    }
    
    public String action1(Model model) {
        model.put("msg", "ThemeManagerPresenter:action1");
        ThemeTransfer themeTransfer = new ThemeBusinessController().m1();
        model.put("themeTransfer", themeTransfer);
        return "ThemeManagerView";
    }
    // TODO POST /ThemeManager?themeName=Tema1&action=createTheme HTTP/1.1
    //createTheme
    public void createTheme(Model model) {
    
        //Object object = model.get("themeName");
        //Theme theme = (Theme) object; 
        //System.out.print("[MSP] -- Presenter - CreateTheme: " + this.getNameTheme() + " \n");
      
        new ThemeBusinessController().CreateTheme(this.getNameTheme());
       
    }
}
