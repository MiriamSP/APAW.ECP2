package voting.web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import voting.rest.business.controllers.ThemeBusinessController;
import voting.rest.business.controllers.VoteBusinessController;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;
import voting.rest.business.views.ThemeTransfer;
import voting.rest.business.views.VoteTransfer;
import voting.web.presentation.models.Model;

public class VotingPresenter {

    private String param1;

    private String param2;

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
        System.out.print("votingPresenter-------\n ");

        List<ThemeTransfer> themeTransfer = new VoteBusinessController().getThemeVoteAverages();
        System.out.print("themeTransfersize: " + themeTransfer.size() + "\n");

        List<String> averagesList = new ArrayList<>();
        System.out.print("averagesList.size(): " + averagesList.size() + "\n");

        for (int i = 0; i < themeTransfer.size(); i++) {
            averagesList.add("[themeName=" + themeTransfer.get(i).getName() + ", average=" + themeTransfer.get(i).getAverage() + "]");
            System.out.print("[themeName=" + themeTransfer.get(i).getName() + ", average=" + themeTransfer.get(i).getAverage() + "]\n");

        }
        return averagesList;

    }

    protected void setParam1(String param1) {
        this.param1 = param1;
    }

    protected void setParam2(String param2) {
        this.param2 = param2;
    }

    public String process(Model model) {
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

    public String process_orig(Model model) {
        model.put("msg", "VotePresenter:process");
        return "VotingView";
    }

    public String action1(Model model) {
        model.put("msg", "VotePresenter:action1");
        VoteTransfer voteTransfer = new VoteBusinessController().m1();
        model.put("voteTransfer", voteTransfer);
        return "VotingView";
    }

    // TODO POST /Voting?themeName=Tema1&action=voteTheme&value=5 HTTP/1.1
    // voteTheme
    public void voteTheme(Model model) {
        String nameTheme = this.getNameTheme();
        int themeValueVoteInt = this.getThemeValueVoteInt();
        //System.out.print("[MSP] -- VotingPresenter - THEMA: " + themeName + "\n");
        // TODO
        // Theme theme = new Theme(Theme.getNextId(),nameTheme);
        VoteTransfer voteTransfer = new VoteTransfer(nameTheme, themeValueVoteInt);
        new VoteBusinessController().VoteTheme(voteTransfer);

    }

}
