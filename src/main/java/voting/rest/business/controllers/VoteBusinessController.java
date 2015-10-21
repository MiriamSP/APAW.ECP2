package voting.rest.business.controllers;

import java.util.List;

import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.models.daos.DaoFactory;

public class VoteBusinessController {
    // CASOS DE USO VOTE
    //
    // - VoteTheme
    // - ShowThemeManager

    public boolean VoteTheme(String nameTheme) {
        Theme theme = getThemeByName(nameTheme);
        if (theme != null) {
            // List<Vote> voteList = getVoteByName(theme);
            return false;
        } else {
            Vote voteNew = new Vote(getNextId(), 1, theme);
            DaoFactory.getFactory().getVoteDao().create(voteNew);
            return true;
        }
    }

    private Theme getThemeByName(String name) {
        return DaoFactory.getFactory().getThemeDao().findByName(name);
    }

    private List<Vote> getVoteByName(Theme theme) {
        return DaoFactory.getFactory().getVoteDao().findByTheme(theme);
    }

    private int getNextId() {
        return DaoFactory.getFactory().getVoteDao().findAll().size() + 1;
    }

    public VoteTransfer m1() {
        DaoFactory.getFactory().getVoteDao().findAll();
        return new VoteTransfer();
    }

    public void m2(ThemeTransfer themeTransfer) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }
}
