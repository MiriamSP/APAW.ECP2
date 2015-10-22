package voting.web.presentation.views;

import java.util.List;

import voting.rest.business.models.entities.Vote;
import voting.web.presentation.models.Model;

public class VotingView implements View {

    @Override

    public void show(Model model) {
        System.out.println("Voting Page\n");
        // String themeName = (String) model.get("themeName");
        // String themeValueVote = (String) model.get("themeValueVote");
        //List<String> voteList = (List<String>) model.get("themeValueVote");
        double[][] voteList = (double[][]) model.get("themeValueVote");

        //List<Vote> voteList = (List<Vote>) model.get("themeValueVote");
       // System.out.print(voteList.size() +"size: \n");
        /*for (Vote vote : voteList) {
            System.out.println("[ThemeName=" + vote.getTheme().getName() + ",average=" + vote.getVote() + "\n");
        }*/

        model.get("votes");

        System.out.print("Temas: \n");

        // System.out.print("[themeName=" + themeName + ",average="+ themeValueVote +"\n");

        System.out.print("] \n");
    }

}
