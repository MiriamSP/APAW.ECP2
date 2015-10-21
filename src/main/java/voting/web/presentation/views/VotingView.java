package voting.web.presentation.views;

import voting.web.presentation.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.println("Voting \n" + model.get("msg"));
    }

}
