package co.com.tyba.reqres.backend.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/register.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "co.com.tyba.reqres.backend.stepdefinitions")
public class Register {
}
