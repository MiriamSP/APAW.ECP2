package voting.rest.business.controllers;

import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.models.daos.DaoFactory;

public class ThemeBusinessController {

    public ThemeTransfer m1() {
        DaoFactory.getFactory().getThemeDao().findAll();
        return new ThemeTransfer();
    }

    public void m2(VoteTransfer voteTransfer) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }

}
