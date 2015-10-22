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
            model.put("themeValueVote", votingPresenter.process());
            break;
        case nameThemePresenter:
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            model.put("themeName", themeManagerPresenter.process());
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";
        String themeName = request.getParams().get("themeName");
        String valueVote = request.getParams().get("value");

        switch (presenter) {
        case nameVotePresenter:
            VotingPresenter votingPresenter = new VotingPresenter();
            model.put("themeName", themeName);
            model.put("valueVote", valueVote);
            if ("voteTheme".equals(action)) {
                votingPresenter.setNameTheme(themeName);
                votingPresenter.setThemeValueVote(valueVote);
                votingPresenter.voteTheme(model);
                model.put("themeValueVote", votingPresenter.process());
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
