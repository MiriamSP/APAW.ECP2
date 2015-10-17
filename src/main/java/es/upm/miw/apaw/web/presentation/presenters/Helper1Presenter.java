package es.upm.miw.apaw.web.presentation.presenters;

public class VotingPresenter {

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
        return "Helper1View";
    }

    public String action1(Model model) {
        model.put("msg", "Mensaje de Helper1Controller:action1:param1: " + param1);
        return "Helper1View";
    }

    public String action2(Model model) {
        model.put("msg", "Mensaje de Helper1Controller:action2:param2: " + param2);
        return "Helper1View";
    }

}
