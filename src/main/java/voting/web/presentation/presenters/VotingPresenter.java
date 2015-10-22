package voting.web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;
import voting.rest.business.controllers.VoteBusinessController;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.web.presentation.models.Model;

public class VotingPresenter {

    private String themeName;

    private String themeValueVote;

    public void setNameTheme(String themeName) {
        this.themeName = themeName;
    }

    public String getNameTheme() {
        return this.themeName;
    }

    public void setThemeValueVote(String themeValueVote) {
        this.themeValueVote = themeValueVote;
    }

    public String getThemeValueVote() {
        return this.themeValueVote;
    }

    public int getThemeValueVoteInt() {
        return Integer.parseInt(this.themeValueVote);
    }

    public List<String> process() {
        List<ThemeTransfer> themeTransfer = new VoteBusinessController().getThemeVoteAverages();

        List<String> averagesList = new ArrayList<>();

        for (int i = 0; i < themeTransfer.size(); i++) {
            averagesList.add("[themeName=" + themeTransfer.get(i).getName() + ", average=" + themeTransfer.get(i).getAverage() + "]");
        }
        return averagesList;
    }

    public void voteTheme(Model model) {
        String nameTheme = this.getNameTheme();
        int themeValueVoteInt = this.getThemeValueVoteInt();
        VoteTransfer voteTransfer = new VoteTransfer(nameTheme, themeValueVoteInt);
        new VoteBusinessController().VoteTheme(voteTransfer);
    }

}
