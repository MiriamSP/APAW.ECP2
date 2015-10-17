package es.upm.miw.apaw.web.presentation.frontController;

import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "Helper1Presenter":
            Helper1Presenter helper1Presenter = new Helper1Presenter();
            //Injectar parámetros mediante helper1Presenter.setters()
            nextView = helper1Presenter.process(model);
            break;
        case "Helper2Presenter":
            Helper2Presenter helper2Presenter = new Helper2Presenter();
            //Injectar parámetros mediante helper2Presenter.setters()
            nextView = helper2Presenter.process(model);
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "Helper1Presenter":
            Helper1Presenter helper1Presenter = new Helper1Presenter();
            if ("action1".equals(action)) {
                helper1Presenter.setParam1((request.getParams().get("param1")));
                //Injectar parámetros mediante helper1Presenter.setters()
                nextView = helper1Presenter.action1(model);
            } else if ("action2".equals(action)) {
                helper1Presenter.setParam2((request.getParams().get("param2")));
                //Injectar parámetros mediante helper2Presenter.setters()
                nextView = helper1Presenter.action2(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "Helper2Presenter":
            Helper2Presenter helper2Presenter = new Helper2Presenter();
            if ("action1".equals(action)) {
                helper2Presenter.setParam1(Integer.valueOf(request.getParams().get("param1")));
                nextView = helper2Presenter.action1(model);
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
        case "Helper1View":
            view = new Helper1View();
            break;
        case "Helper2View":
            view = new Helper2View();
            break;
        case "Helper3View":
            view = new Helper3View();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
