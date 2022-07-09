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

    public static PublicAxiumAccount getPublicInfos(String username) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/user/?username=" + username;

        return restTemplate.getForObject(new URI(url), PublicAxiumAccount.class);
    }

    public static PublicAxiumAccount getPublicInfos(Integer id) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/user/?id=" + id;

        return restTemplate.getForObject(new URI(url), PublicAxiumAccount.class);
    }

    public static AxiumRole getRole(Integer id) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/roles/?id=" + id;

        return restTemplate.getForObject(new URI(url), AxiumRole.class);
    }

    public static AxiumRole getRole(String name) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/roles/?name=" + name;

        return restTemplate.getForObject(new URI(url), AxiumRole.class);
    }

    public static AxiumRole[] getRoles() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/roles/";

        return restTemplate.getForObject(new URI(url), AxiumRole[].class);
    }

    public static AxiumGame getGame(Integer id) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/game/?id=" + id;

        return restTemplate.getForObject(new URI(url), AxiumGame.class);
    }

    public static AxiumGame getGame(String name) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/game/?name=" + name;

        return restTemplate.getForObject(new URI(url), AxiumGame.class);
    }

    public static AxiumGame[] getGames() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/game/";

        return restTemplate.getForObject(new URI(url), AxiumGame[].class);
    }
}