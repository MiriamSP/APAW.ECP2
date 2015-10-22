package voting.rest.business.controllers;

import voting.rest.business.models.entities.Theme;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.models.daos.DaoFactory;

public class ThemeBusinessController {
    // CASOS DE USO THEME - BusinessController1
    // -- ShowVoting
    // - CreateTheme

    public boolean CreateTheme(String nameThemeNew) {
        if (getThemeByName(nameThemeNew) != null) {
            return false;
        } else {
            Theme themeNew = new Theme(getNextId(), nameThemeNew);
            DaoFactory.getFactory().getThemeDao().create(themeNew);
            return true;
        }
    }

    private int getNextId() {
        return DaoFactory.getFactory().getThemeDao().findAll().size() + 1;
    }

    private Theme getThemeByName(String name) {
        return DaoFactory.getFactory().getThemeDao().findByName(name);
    }

    public void ShowVoting() {

    }
    
    public ThemeTransfer m1() {
        DaoFactory.getFactory().getThemeDao().findAll();
        return new ThemeTransfer();
    }

    public void m2(VoteTransfer voteTransfer) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }    
}
