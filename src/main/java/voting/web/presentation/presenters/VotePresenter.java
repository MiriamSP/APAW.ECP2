package voting.web.presentation.presenters;

import voting.rest.business.controllers.VoteBusinessController;
import voting.rest.business.views.VoteTransfer;
import voting.web.presentation.models.Model;

public class VotePresenter {

    private String param1;

    private String param2;

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
        return "VoteView";
    }
    
    public String action1(Model model) {
        model.put("msg", "VotePresenter:action1");
        VoteTransfer voteTransfer = new VoteBusinessController().m1();
        model.put("voteTransfer", voteTransfer);
        return "VoteView";
    }
    

}
