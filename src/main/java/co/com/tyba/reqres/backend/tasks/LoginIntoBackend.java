package co.com.tyba.reqres.backend.tasks;

import co.com.tyba.reqres.backend.model.UserAuthentication;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.screenplay.rest.interactions.Post;
import io.restassured.http.ContentType;

public class LoginIntoBackend implements Task {

    private final UserAuthentication credentials;
    public static EnvironmentVariables environmentVariables;

    public LoginIntoBackend(UserAuthentication credentials) {
        this.credentials = credentials;
    }

    @Override
    @Step("{0} ingresa los datos en el body del servicio y realiza la petición")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(environmentVariables.getProperty("restapi.login"))
                .with(request -> request.contentType(ContentType.JSON)
                        .body(credentials)));
    }

    public static LoginIntoBackend withCredentials(UserAuthentication credentials) {
        return Tasks.instrumented(LoginIntoBackend.class, credentials);
    }
}
