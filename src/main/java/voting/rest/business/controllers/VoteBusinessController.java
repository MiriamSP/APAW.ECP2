package voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.rest.data.models.daos.DaoFactory;

public class VoteBusinessController {
    // CASOS DE USO VOTE (BusinessController2)
    // - VoteTheme
    // - ShowThemeManager

    public boolean VoteTheme_OLD(String nameTheme) {
        Theme theme = getThemeByName(nameTheme);
        if (theme != null) {
            return false;
        } else {
            Vote voteNew = new Vote(getNextId(), 1, theme);
            DaoFactory.getFactory().getVoteDao().create(voteNew);
            return true;
        }
    }

    public boolean VoteTheme(VoteTransfer voteTransfer) {
        int id = getNextId();
        String nameThemeVoteTransfer = voteTransfer.getName();
        Theme theme = getThemeByName(nameThemeVoteTransfer);
        int themeValueVote = voteTransfer.getVote();
        Vote vote = new Vote(id, themeValueVote, theme);

        DaoFactory.getFactory().getVoteDao().create(vote);
        return true;

    }

    private double sumVotes(List<Vote> voteList) {
        double sum = 0;
        for (int i = 0; i < voteList.size(); i++) {
            sum += voteList.get(i).getVote();
        }
        return sum;
    }

    public List<ThemeTransfer> getThemeVoteAverages() {
        // System.out.print("[----------------------getThemeVoteAverages \n");

        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
        System.out.print("[--------------themeList.size " + themeList.size() + "\n");

        // List<Vote> voteList = null;// = new List<Vote>;
        List<ThemeTransfer> themeTransferList = new ArrayList<>();
        for (int i = 0; i < themeList.size(); i++) {
            // System.out.print("[--------------themeList.get(i) " + themeList.get(i)+"\n");
            // Vote vote = (Vote) DaoFactory.getFactory().getVoteDao().findByTheme(themeList.get(i));
            Theme theme = themeList.get(i);
            System.out.print("[--------------theme " + theme.getName() + " || id:" + theme.getId() + "\n");
            List<Vote> voteList = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
            // voteList.add(vote);
            System.out.print("[--------------voteList.size " + voteList.size() + "\n");

            double average = sumVotes(voteList) / voteList.size();
            int id = themeList.get(i).getId();
            String nameTheme = themeList.get(i).getName();
            ThemeTransfer themeTransfer = new ThemeTransfer(nameTheme, average);
            themeTransferList.add(themeTransfer);
        }
        return themeTransferList;
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
        DaoFactory.getFactory().getThemeDao().findAll();
        return new VoteTransfer();
    }

    public void m2(ThemeTransfer themeTransfer) {
        DaoFactory.getFactory().getVoteDao().read(1);
    }

    public List<Vote> getVotes() {
        return DaoFactory.getFactory().getVoteDao().findAll();
    }
}
