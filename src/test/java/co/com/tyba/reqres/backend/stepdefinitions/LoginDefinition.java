package co.com.tyba.reqres.backend.stepdefinitions;

import co.com.tyba.reqres.backend.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static co.com.tyba.reqres.backend.util.Generate.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.StringContains.containsString;

public class LoginDefinition {

    public static EnvironmentVariables environmentVariables;

    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl"))));
    }

    @Dado("que {string} desea loguearse en reqres")
    public void theUserWantsTologinToReqresBackEnd(String name) {
        theActorCalled(name).entersTheScene();
    }

    @Cuando("ingresa el email y contrasenia correcta")
    public void enterTheEmailAndCorrectPassword() {
        theActorInTheSpotlight().attemptsTo(Login.withCredentials(
                authentication(
                        environmentVariables.getProperty("restapi.username"),
                        environmentVariables.getProperty("restapi.password"))));
    }

    @Cuando("ingresa el email y contrasenia incorrecta")
    public void enterTheWrongEmailAndPassword() {
        theActorInTheSpotlight().attemptsTo(Login.withCredentials(random()));
    }

    @Entonces("verifica que el usuario se autentica correctamente")
    public void verifiesThatTheUserIsAuthenticatedCorrectly() {
        theActorInTheSpotlight().should(seeThatResponse("Status code is 200 - OK",
                response -> response.statusCode(200).body(containsString("token"))));
    }

    @Entonces("verifica que el usuario no se autentica correctamente")
    public void verifiesThatTheUserIsNotAuthenticatedCorrectly() {
        theActorInTheSpotlight().should(seeThatResponse( "Status code is 400 - Bad Request",
                response -> response.statusCode(400).
                        body(containsString("user not found"))));
    }
}
