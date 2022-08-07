package test;

import io.github.xibalbaM.axiumApi.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {

    @Test
    public void testLogin() throws URISyntaxException, IOException {

        RestResponse<Account> login = AxiumAPI.login("test", "testMDP");

        assertFalse(login.hasError());

        login.getData().logout();

        assertNull(login.getData().getToken());
        assertEquals(1, login.getData().getId());
        assertEquals(login.getData().getUsername(), "test");
    }

    @Test
    public void testRole() throws URISyntaxException {

        RestResponse<Role[]> response = AxiumAPI.getRoles();

        assertFalse(response.hasError());

        Role[] role = response.getData();
        assertEquals(3, role.length);
        assertEquals(role[0].getName(), "role");
    }


    @Test
    public void testGame() throws URISyntaxException {

        RestResponse<Game[]> response = AxiumAPI.getGames();

        assertFalse(response.hasError());

        Game[] role = response.getData();
        assertEquals(2, role.length);
        assertEquals(role[0].getName(), "Test");
    }
}
