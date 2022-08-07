package io.github.xibalbaM.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.List;

/**
 * An account on Axium.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    /**
     * The id of the account.
     */
    Integer id;

    /**
     * The username of the account.
     */
    String username;

    /**
     * The email of the account.
     */
    String email;

    /**
     * The token of the account, which is used to authenticate.
     * It is reset by the logout method and after one month.
     * Generated by the server, on call of {@link AxiumAPI#login(String, String)}.
     */
    String token;

    /**
     * The date of the self-destruction of the token.
     * Generated at the same time as the {@link #token}.
     */
    Date tokenExpiration;

    /**
     * The URL of the avatar of the account.
     * May be null if the account has no avatar.
     */
    String icon_url;

    /**
     * The date of the creation of the account.
     */
    Date creationDate;

    /**
     * The xp amount of the account.
     */
    int xp;

    /**
     * The fidelity amount of the account.
     */
    int fidelity;

    /**
     * The premium amount of the account.
     */
    int premium;

    /**
     * If the email of the account is confirmed.
     * Default value is false.
     */
    boolean emailVerified;

    /**
     * If the account is enabled.
     * False if the account have a role like BANNED or DISABLED.
     */
    boolean enabled;

    /**
     * The list of the games owned by the account.
     */
    List<Game> games;

    /**
     * The list of the roles of the account.
     */
    List<Role> roles;

    /**
     * Used to reset the token.
     * Useful when the user want to log out from everywhere.
     *
     * @throws IOException
     */
    public void logout() throws IOException {

        URL url = new URL("https://axium-website.herokuapp.com/api/user/tokenDisonnect?token=" + this.token);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        con.disconnect();
        this.token = null;
    }
}