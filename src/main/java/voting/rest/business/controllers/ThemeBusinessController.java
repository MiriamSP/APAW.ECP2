package voting.rest.business.controllers;

import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.memory.daos.ThemeMemoryDao;
import voting.rest.data.models.daos.DaoFactory;
import voting.rest.data.models.daos.ThemeDao;

public class ThemeBusinessController {
    // CASOS DE USO THEME
    //
    // -- ShowVoting
    // - CreateTheme

    public boolean CreateTheme(String nameThemeNew) {
        ThemeTransfer themeTransfer = m1();

        /*
         * if (ThemeMemoryDao.findByName(nameThemeNew) != null) { return false; } else { // crear theme int id =
         * DaoFactory.getFactory().getThemeDao().findAll().size() + 1; Theme themeNew = new Theme(id, nameThemeNew);
         * DaoFactory.getFactory().getThemeDao().create(themeNew); }
         */
        return true;

    }

    public ThemeTransfer m1() {
        DaoFactory.getFactory().getThemeDao().findAll();
        return new ThemeTransfer();
    }

    public void m2(VoteTransfer voteTransfer) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }

}
