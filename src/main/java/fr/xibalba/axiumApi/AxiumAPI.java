package fr.xibalba.axiumApi;

import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class AxiumAPI {

    public static AxiumAccount login(String username, String password) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url =
                "https://axium-website.herokuapp.com/api/user/connect?username=" + username + "&password=" + password;

        return restTemplate.getForObject(new URI(url), AxiumAccount.class);
    }

    public static AxiumAccount login(String token) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/user/tokenConnect?token=" + token;

        return restTemplate.getForObject(new URI(url), AxiumAccount.class);
    }
}