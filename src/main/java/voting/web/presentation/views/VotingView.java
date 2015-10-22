package voting.web.presentation.views;

import java.util.List;
import voting.web.presentation.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.println("Voting Page\n");
        List<String> votesList = (List<String>) model.get("themeValueVote");
        System.out.print("Temas: ");
        for (int i = 0; i < votesList.size(); i++) {
            System.out.print("[ThemeTransfer " + votesList.get(i) + "]");

            if (i < votesList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("] \n");
    }

}
