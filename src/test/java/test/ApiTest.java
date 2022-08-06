package test;

import fr.xibalba.axiumApi.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {

    @Test
    public void testLogin() throws URISyntaxException, IOException {

        RestResponse<AxiumAccount> login = AxiumAPI.login("test", "testMDP");

        assertFalse(login.hasError());

        login.getData().logout();

        assertNull(login.getData().getToken());
        assertEquals(1, login.getData().getId());
        assertEquals(login.getData().getUsername(), "test");
    }

    @Test
    public void testRole() throws URISyntaxException {

        RestResponse<AxiumRole[]> response = AxiumAPI.getRoles();

        assertFalse(response.hasError());

        AxiumRole[] role = response.getData();
        assertEquals(3, role.length);
        assertEquals(role[0].getName(), "role");
    }


    @Test
    public void testGame() throws URISyntaxException {

        RestResponse<AxiumGame[]> response = AxiumAPI.getGames();

        assertFalse(response.hasError());

        AxiumGame[] role = response.getData();
        assertEquals(2, role.length);
        assertEquals(role[0].getName(), "Test");
    }
}
