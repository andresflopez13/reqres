package co.com.tyba.reqres.backend.stepdefinitions;

import co.com.tyba.reqres.backend.tasks.Create;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.model.util.EnvironmentVariables;

import static co.com.tyba.reqres.backend.util.Generate.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.StringContains.containsString;

public class RegisterDefinition {

    public static EnvironmentVariables environmentVariables;

    @Dado("que {string} desea crear un usuario en reqres")
    public void theUserWantsToCreateAUser(String name) {
        theActorCalled(name).entersTheScene();
    }

    @Cuando("ingresa el email y contrasenia para el nuevo usuario")
    public void enterTheNewUserInformation() {
        theActorInTheSpotlight().attemptsTo(Create.withTheInformation(authentication(
                environmentVariables.getProperty("restapi.username"),
                environmentVariables.getProperty("restapi.password")
        )));
    }

    @Cuando("ingresa solo el email para el nuevo usuario")
    public void enterOnlyTheEmailForTheNewUser() {
        theActorInTheSpotlight().attemptsTo(Create.withTheInformation(onlyEmail()));
    }

    @Entonces("verifica que el usuario se ha creado correctamente")
    public void verifiesThatTheUserIsAuthenticatedCorrectly() {
        theActorInTheSpotlight().should(seeThatResponse("Status code is 200 - OK",
                response -> response.statusCode(200).body("id", notNullValue())
                        .body(containsString("token"))));
    }

    @Entonces("verifica que el usuario no se ha creado")
    public void verifyThatTheUserHasNotBeenCreated() {
        theActorInTheSpotlight().should(seeThatResponse("Status code is 400 - Bad Request",
                response -> response.statusCode(400).body(containsString("error"))
                        .body(containsString("Missing password"))));
    }
}
