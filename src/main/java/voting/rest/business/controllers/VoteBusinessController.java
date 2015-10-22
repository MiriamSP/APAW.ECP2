package voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.models.daos.DaoFactory;

public class VoteBusinessController {

    public boolean VoteTheme(VoteTransfer voteTransfer) {
        int id = getNextId();
        String nameThemeVoteTransfer = voteTransfer.getName();
        Theme theme = getThemeByName(nameThemeVoteTransfer);
        int themeValueVote = voteTransfer.getVote();
        Vote vote = new Vote(id, themeValueVote, theme);
        DaoFactory.getFactory().getVoteDao().create(vote);
        return true;
    }

    public List<ThemeTransfer> getThemeVoteAverages() {

        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();

        List<ThemeTransfer> themeTransferList = new ArrayList<>();
        for (int i = 0; i < themeList.size(); i++) {

            Theme theme = themeList.get(i);
            List<Vote> voteList = DaoFactory.getFactory().getVoteDao().findByTheme(theme);

            double average = sumVotes(voteList) / voteList.size();
            String nameTheme = themeList.get(i).getName();
            ThemeTransfer themeTransfer = new ThemeTransfer(nameTheme, average);
            themeTransferList.add(themeTransfer);
        }
        return themeTransferList;
    }

    private double sumVotes(List<Vote> voteList) {
        double sum = 0;
        for (int i = 0; i < voteList.size(); i++) {
            sum += voteList.get(i).getVote();
        }
        return sum;
    }

    private Theme getThemeByName(String name) {
        return DaoFactory.getFactory().getThemeDao().findByName(name);
    }

    private int getNextId() {
        return DaoFactory.getFactory().getVoteDao().findAll().size() + 1;
    }

}
