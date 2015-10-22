package voting.web.presentation.views;

import java.util.List;


import voting.web.presentation.models.Model;

public class VotingView implements View {

    @Override

    public void show(Model model) {
        System.out.println("Voting Page\n");
        String themeName = (String) model.get("themeName");
        String themeValueVote = (String) model.get("themeValueVote");
        //List<Vote> voteList = VoteMemoryDao. findByTheme(Theme theme) 
        
        model.get("votes");

        System.out.print("Temas: \n");
        
        System.out.print("[themeName=" + themeName + ",average="+ themeValueVote +"\n");


        System.out.print("] \n");
    }

}
