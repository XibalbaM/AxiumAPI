package io.github.xibalbaM.axiumApi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import static org.springframework.web.reactive.function.client.WebClient.UriSpec;

/**
 * The core of the Axium API, from here you can get servers object to do actions on.
 */
@SuppressWarnings("unckecked")
public class AxiumAPI {

    private static String API_URL = "https://axium-centrality.herokuapp.com/api";
    private static WebClient client = WebClient.create(API_URL);

    /**
     * Change the API URL. Used for testing.
     *
     * @param API_URL The new API URL.
     */
    public static void setApiUrl(String API_URL) {

        AxiumAPI.API_URL = API_URL;
        client = WebClient.create(API_URL);
    }

    /**
     * Used to obtain or generate the token for the account, witch is reset by the logout method and after one month.
     * IMPORTANT: Never store the password, store only the token. Else the password could be stolen.
     *
     * @param username The username of the account to connect to.
     * @param password The password of the account to connect to.
     *
     * @return The account.
     */
    public static RestResponse<Account> login(String username, String password) {

        return doRequest("/user/connect?username=" + username + "&password=" + password,
                new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to relog to an account, without having to save the password.
     *
     * @param token The current token of the account. Can be obtained by login with the username and password.
     *
     * @return The account.
     */
    public static RestResponse<Account> login(String token) {

        return doRequest("/user/tokenConnect?token=" + token,
                new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the public information of the account.
     *
     * @param username The username of the account.
     *
     * @return The account.
     */
    public static RestResponse<PublicAccount> getAccountPublicInfos(String username) {

        return doRequest("/user/?username=" + username, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the public information of the account.
     *
     * @param id The id of the account.
     *
     * @return The account publics datas.
     */
    public static RestResponse<PublicAccount> getAccountPublicInfos(int id) {

        return doRequest("/user/?id=" + id, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a role from his id.
     *
     * @param id The id of the role.
     *
     * @return The role information.
     */
    public static RestResponse<Role> getRole(int id) {

        return doRequest("/api/roles/?id=" + id, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a role from his name.
     *
     * @param name The name of the role.
     *
     * @return The role information.
     */
    public static RestResponse<Role> getRole(String name) {

        return doRequest("/roles/?name=" + name, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the list of the roles, and the accounts who have each role.
     *
     * @return The role list.
     */
    public static RestResponse<Role[]> getRoles() {

        return doRequest("/roles/", new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a game from his id.
     *
     * @param id The id of the game.
     *
     * @return The game information.
     */
    public static RestResponse<Game> getGame(int id) {

        return doRequest("/game/?id=" + id, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a game from his name.
     *
     * @param name The name of the game.
     *
     * @return The game information.
     */
    public static RestResponse<Game> getGame(String name) {

        return doRequest("/game/?name=" + name, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the list of the games, and the accounts who have each of them.
     *
     * @return The game list.
     */
    public static RestResponse<Game[]> getGames() {

        return doRequest("/game/", new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to do a request to the api, if the request is not already implemented.
     *
     * @param relativeUrl The url of the api, relative to API_URL.
     * @param type        Just put {@code new ParameterizedTypeReference<>() {}}, obligatory to avoid errors
     * @param <T>         The type of the data that the api should return.
     *
     * @return A RestResponse witch contains the data if there is no error, or the error if there is one.
     */
    public static <T> RestResponse<T> doRequest(String relativeUrl, ParameterizedTypeReference<RestResponse<T>> type) {

        UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri(relativeUrl);
        return bodySpec.retrieve().bodyToMono(type).block();
    }
}