package co.com.tyba.reqres.backend.tasks;

import co.com.tyba.reqres.backend.model.User;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.model.util.EnvironmentVariables;

public class Create implements Task {
    private final User credentials;
    public static EnvironmentVariables environmentVariables;

    public Create(User credentials) {
        this.credentials = credentials;
    }

    @Override
    @Step("{0} ingresa los datos en el body del servicio y realiza la petición de creación")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(environmentVariables.getProperty("restapi.create"))
                .with(request -> request.contentType(ContentType.JSON)
                        .body(credentials)));
    }

    public static Create withTheInformation(User credentials) {
        return Tasks.instrumented(Create.class, credentials);
    }
}
