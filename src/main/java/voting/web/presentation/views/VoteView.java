package voting.web.presentation.views;

import java.util.List;

import voting.rest.business.models.entities.Vote;
import voting.web.presentation.models.Model;

public class VoteView implements View {

    @Override

    public void show(Model model) {
        System.out.println("Voting Page\n");
        Object vote = model.get("msg");

        System.out.print("] \n");
    }

}
