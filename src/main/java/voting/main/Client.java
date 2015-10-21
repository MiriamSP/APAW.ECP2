package voting.main;

import voting.web.http.HttpRequest;
import voting.web.http.HttpResponse;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
