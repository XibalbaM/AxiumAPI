package fr.xibalba.axiumApi;

import lombok.SneakyThrows;
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

    public static final String API_URL = "https://axium-centrality.herokuapp.com/api";
    private static final WebClient client = WebClient.create(API_URL);

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
    public static RestResponse<AxiumAccount> login(String username, String password) {

        return doRequest("/user/connect?username=" + username + "&password=" + password,
                new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the public information of the account.
     *
     * @param username The username of the account.
     *
     * @return The account.
     */
    @SneakyThrows
    public static RestResponse<PublicAxiumAccount> getAccountPublicInfos(String username) {

        return doRequest("/user/?username=" + username, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the public information of the account.
     *
     * @param id The id of the account.
     *
     * @return The account publics datas.
     */
    @SneakyThrows
    public static RestResponse<PublicAxiumAccount> getAccountPublicInfos(int id) {

        return doRequest("/user/?id=" + id, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a role from his id.
     *
     * @param id The id of the role.
     *
     * @return The role information.
     */
    @SneakyThrows
    public static RestResponse<AxiumRole> getRole(int id) {

        return doRequest("/api/roles/?id=" + id, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a role from his name.
     *
     * @param name The name of the role.
     *
     * @return The role information.
     */
    @SneakyThrows
    public static RestResponse<AxiumRole> getRole(String name) {

        return doRequest("/roles/?name=" + name, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the list of the roles, and the accounts who have each role.
     *
     * @return The role list.
     */
    @SneakyThrows
    public static RestResponse<AxiumRole[]> getRoles() {

        return doRequest("/roles/", new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a game from his id.
     *
     * @param id The id of the game.
     *
     * @return The game information.
     */
    @SneakyThrows
    public static RestResponse<AxiumGame> getGame(int id) {

        return doRequest("/game/?id=" + id, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain a game from his name.
     *
     * @param name The name of the game.
     *
     * @return The game information.
     */
    @SneakyThrows
    public static RestResponse<AxiumGame> getGame(String name) {

        return doRequest("/game/?name=" + name, new ParameterizedTypeReference<>() {});
    }

    /**
     * Used to obtain the list of the games, and the accounts who have each of them.
     *
     * @return The game list.
     */
    @SneakyThrows
    public static RestResponse<AxiumGame[]> getGames() {

        return doRequest("/game/", new ParameterizedTypeReference<>() {});
    }

    private static <T> RestResponse<T> doRequest(String relativeUrl, ParameterizedTypeReference<RestResponse<T>> type) {

        UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
        RequestBodySpec bodySpec = uriSpec.uri(relativeUrl);
        System.out.println(bodySpec.retrieve().bodyToMono(String.class).block());
        return bodySpec.retrieve().bodyToMono(type).block();
    }
}