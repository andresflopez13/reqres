package co.com.tyba.reqres.backend.util;

import co.com.tyba.reqres.backend.model.UserAuthentication;
import net.datafaker.Faker;

public class Generate {

    private static final Faker faker = new Faker();

    public static UserAuthentication userForSuccessfulAuthentication(String email, String pass) {
        return new UserAuthentication(email, pass);
    }

    public static UserAuthentication userForFailAuthentication() {
        return new UserAuthentication(
                faker.internet().emailAddress(), faker.numerify("######"));
    }
}
