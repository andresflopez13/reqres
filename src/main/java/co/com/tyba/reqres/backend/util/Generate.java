package co.com.tyba.reqres.backend.util;

import co.com.tyba.reqres.backend.model.User;
import net.datafaker.Faker;

public class Generate {

    private static final Faker faker = new Faker();

    public static User authentication(String email, String pass) {
        return new User(email, pass);
    }

    public static User random() {
        return new User(faker.internet().emailAddress(), faker.internet().password(5,6));
    }

    public static User onlyEmail() {
        return new User(faker.internet().emailAddress());
    }

    public static User register(){
        return new User(faker.internet().emailAddress(),faker.internet().password(5,6),faker.internet().username());
    }
}
