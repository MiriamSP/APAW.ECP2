package voting.web.presentation.frontController;

import voting.web.http.HttpRequest;
import voting.web.http.HttpResponse;
import voting.web.presentation.models.Model;
import voting.web.presentation.presenters.ThemeManagerPresenter;
import voting.web.presentation.presenters.VotingPresenter;
import voting.web.presentation.views.ErrorView;
import voting.web.presentation.views.ThemeManagerView;
import voting.web.presentation.views.View;
import voting.web.presentation.views.VotingView;

public class Dispatcher {

    static final String nameVotePresenter = "VotingPresenter";

    static final String nameThemePresenter = "ThemeManagerPresenter";;

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case nameVotePresenter:
            VotingPresenter votingPresenter = new VotingPresenter();
            // Injectar parámetros mediante helper1Presenter.setters()
            nextView = votingPresenter.process(model);
            break;
        case nameThemePresenter:
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            model.put("themeName", themeManagerPresenter.process());
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {

        // TODO - Completar con las acciones
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";
        // System.out.print("[MSP] --@ DISPATCHER presenter:" + presenter + " Action: " + action + " nextView: " + nextView + "\n");
        String themeName = request.getParams().get("themeName");
        String themeValueVote = request.getParams().get("value");

        switch (presenter) {
        case nameVotePresenter:
            VotingPresenter votingPresenter = new VotingPresenter();
            model.put("themeName", themeName);
            model.put("themeValueVote", themeValueVote);
            if ("voteTheme".equals(action)) {
                System.out.print("[MSP] @ DISPATCHER --ACTION:" + action + " THEMA: " + themeName + " valor: " + themeValueVote + "\n");
                // comentado
                // votingPresenter.setParam1((request.getParams().get("param1")));
                // Injectar parámetros mediante helper1Presenter.setters()
                votingPresenter.setNameTheme(themeName);
                votingPresenter.setThemeValueVote(themeValueVote);
                votingPresenter.voteTheme(model);

                nextView = votingPresenter.action1(model);
            } else if ("action2".equals(action)) {
                // comentado
                // votingPresenter.setParam2((request.getParams().get("param2")));
                // Injectar parámetros mediante helper2Presenter.setters()
                nextView = votingPresenter.action2(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case nameThemePresenter:
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            model.put("themeName", themeName);
            if ("createTheme".equals(action)) {
                themeManagerPresenter.setNameTheme(themeName);
                themeManagerPresenter.createTheme(model);
                model.put("themeName", themeManagerPresenter.process());

            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }

    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "VotingView":
            view = new VotingView();
            break;
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
