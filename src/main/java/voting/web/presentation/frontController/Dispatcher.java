package voting.web.presentation.frontController;

import voting.web.http.HttpRequest;
import voting.web.http.HttpResponse;
import voting.web.presentation.models.Model;
import voting.web.presentation.presenters.ThemePresenter;
import voting.web.presentation.presenters.VotePresenter;
import voting.web.presentation.views.ErrorView;
import voting.web.presentation.views.ThemeView;
import voting.web.presentation.views.View;
import voting.web.presentation.views.VoteView;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "VotePresenter":
            VotePresenter votePresenter = new VotePresenter();
            //Injectar parámetros mediante helper1Presenter.setters()
            nextView = votePresenter.process(model);
            break;
        case "ThemePresenter":
            ThemePresenter themePresenter = new ThemePresenter();
            //Injectar parámetros mediante helper2Presenter.setters()
            nextView = themePresenter.process(model);
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

        switch (presenter) {
        case "VotePresenter":
            VotePresenter votePresenter = new VotePresenter();
            if ("createTheme".equals(action)) {
                // comentado
                //votingPresenter.setParam1((request.getParams().get("param1")));
                //Injectar parámetros mediante helper1Presenter.setters()
                nextView = votePresenter.action1(model);
            } else if ("action2".equals(action)) {
                // comentado
                //votingPresenter.setParam2((request.getParams().get("param2")));
                //Injectar parámetros mediante helper2Presenter.setters()
                nextView = votePresenter.action2(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "ThemePresenter":
            ThemePresenter themeManagerPresenter = new ThemePresenter();
            if ("action1".equals(action)) {
                // comentado
                //themeManagerPresenter.setParam1(Integer.valueOf(request.getParams().get("param1")));
                nextView = themeManagerPresenter.action1(model);
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
            view = new VoteView();
            break;
        case "ThemeManagerView":
            view = new ThemeView();
            break;        
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
