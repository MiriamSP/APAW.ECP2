package voting.web.presentation.presenters;

import java.util.List;

import voting.rest.business.controllers.ThemeBusinessController;
import voting.rest.business.controllers.VoteBusinessController;
import voting.rest.business.models.entities.Theme;
import voting.rest.business.models.entities.Vote;
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
        return this.themeName ;
    }
    
    public void setThemeValueVote(String themeValueVote) {
        this.themeValueVote = themeValueVote;
    }
    
    public String getThemeValueVote() {
        return this.themeValueVote ;
    }
    
    public int getThemeValueVoteInt() {
        return Integer.parseInt(this.themeValueVote );
    }
    
    public List<Vote> process() {
        List<Vote> votesList = new VoteBusinessController().getVotes();
        return votesList;
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
    //voteTheme
    public void voteTheme(Model model) {
        String nameTheme = this.getNameTheme();
        int themeValueVoteInt = this.getThemeValueVoteInt();
        System.out.print("[MSP] -- VotingPresenter - THEMA: " + themeName + "\n");
        //TODO
        Theme theme = new Theme(1,nameTheme);
        VoteTransfer voteTransfer = new VoteTransfer(themeValueVoteInt, theme);
        new VoteBusinessController().VoteTheme(voteTransfer);
    } 
    
    
    
    
}
