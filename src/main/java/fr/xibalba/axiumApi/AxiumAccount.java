package fr.xibalba.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AxiumAccount {

    Integer id;

    String username;

    String email;

    String token;

    Date tokenExpiration;

    String icon_url;

    Date creationDate;

    int xp;

    int fidelity;

    int premium;

    boolean emailVerified;

    boolean enabled;

    List<AxiumGame> games;

    List<AxiumRole> roles;

    public void logout() throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        URL url = new URL("https://axium-website.herokuapp.com/api/user/tokenDisonnect?token=" + this.token);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        con.disconnect();
        this.token = null;
    }
}
