package voting.rest.business.controllers;


import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.models.daos.DaoFactory;

public class VoteBusinessController {

    public VoteTransfer m1() {
        DaoFactory.getFactory().getVoteDao().findAll();
        return new VoteTransfer();
    }

    public void m2(ThemeTransfer themeTransfer) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }
}
