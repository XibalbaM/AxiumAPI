package fr.xibalba.axiumApi;

import lombok.SneakyThrows;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * The core of the Axium API, from here you can get servers object to do actions on.
 */
public class AxiumAPI {

    /**
     * Used to obtain or generate the token for the account.
     * It is reset by the logout method and after one month.
     * <h2>Never store the password, store only the token.</h2>
     *
     * @param username The username of the account to connect to.
     * @param password The password of the account to connect to.
     *
     * @return The account.
     */
    @SneakyThrows
    public static AxiumAccount login(String username, String password) {

        RestTemplate restTemplate = new RestTemplate();

        String url =
                "https://axium-website.herokuapp.com/api/user/connect?username=" + username + "&password=" + password;

        return restTemplate.getForObject(new URI(url), AxiumAccount.class);
    }

    /**
     * Used to obtain the public information of the account.
     *
     * @param username The username of the account.
     *
     * @return The account.
     */
    @SneakyThrows
    public static PublicAxiumAccount getAccountPublicInfos(String username) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/user/?username=" + username;

        return restTemplate.getForObject(new URI(url), PublicAxiumAccount.class);
    }

    /**
     * Used to obtain the public information of the account.
     *
     * @param id The id of the account.
     *
     * @return The account publics datas.
     */
    @SneakyThrows
    public static PublicAxiumAccount getAccountPublicInfos(int id) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/user/?id=" + id;

        return restTemplate.getForObject(new URI(url), PublicAxiumAccount.class);
    }

    /**
     * Used to obtain a role from his id.
     *
     * @param id The id of the role.
     *
     * @return The role information.
     */
    @SneakyThrows
    public static AxiumRole getRole(int id) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/roles/?id=" + id;

        return restTemplate.getForObject(new URI(url), AxiumRole.class);
    }

    /**
     * Used to obtain a role from his name.
     *
     * @param name The name of the role.
     *
     * @return The role information.
     */
    @SneakyThrows
    public static AxiumRole getRole(String name) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/roles/?name=" + name;

        return restTemplate.getForObject(new URI(url), AxiumRole.class);
    }

    /**
     * Used to obtain the list of the roles, and the accounts who have each role.
     *
     * @return The role list.
     */
    @SneakyThrows
    public static AxiumRole[] getRoles() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/roles/";

        return restTemplate.getForObject(new URI(url), AxiumRole[].class);
    }

    /**
     * Used to obtain a game from his id.
     *
     * @param id The id of the game.
     *
     * @return The game information.
     */
    @SneakyThrows
    public static AxiumGame getGame(int id) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/game/?id=" + id;

        return restTemplate.getForObject(new URI(url), AxiumGame.class);
    }

    /**
     * Used to obtain a game from his name.
     *
     * @param name The name of the game.
     *
     * @return The game information.
     */
    @SneakyThrows
    public static AxiumGame getGame(String name) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/game/?name=" + name;

        return restTemplate.getForObject(new URI(url), AxiumGame.class);
    }

    /**
     * Used to obtain the list of the games, and the accounts who have each of them.
     *
     * @return The game list.
     */
    @SneakyThrows
    public static AxiumGame[] getGames() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://axium-website.herokuapp.com/api/game/";

        return restTemplate.getForObject(new URI(url), AxiumGame[].class);
    }
}