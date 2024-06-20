package co.com.tyba.reqres.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAuthentication {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    public UserAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAuthentication{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
