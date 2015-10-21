package voting.web.presentation.frontController;

import voting.web.http.HttpRequest;
import voting.web.http.HttpResponse;
import voting.web.presentation.models.Model;
import voting.web.presentation.presenters.ThemePresenter;
import voting.web.presentation.presenters.VotingPresenter;
import voting.web.presentation.views.ErrorView;
import voting.web.presentation.views.ThemeView;
import voting.web.presentation.views.View;
import voting.web.presentation.views.VotingView;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            //Injectar parámetros mediante helper1Presenter.setters()
            nextView = votingPresenter.process(model);
            break;
        case "ThemeManagerPresenter":
            ThemePresenter themeManagerPresenter = new ThemePresenter();
            //Injectar parámetros mediante helper2Presenter.setters()
            nextView = themeManagerPresenter.process(model);
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
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            if ("action1".equals(action)) {
                votingPresenter.setParam1((request.getParams().get("param1")));
                //Injectar parámetros mediante helper1Presenter.setters()
                nextView = votingPresenter.action1(model);
            } else if ("action2".equals(action)) {
                votingPresenter.setParam2((request.getParams().get("param2")));
                //Injectar parámetros mediante helper2Presenter.setters()
                nextView = votingPresenter.action2(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "ThemeManagerPresenter":
            ThemePresenter themeManagerPresenter = new ThemePresenter();
            if ("action1".equals(action)) {
                themeManagerPresenter.setParam1(Integer.valueOf(request.getParams().get("param1")));
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
            view = new VotingView();
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
