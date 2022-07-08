package test;

import fr.xibalba.axiumApi.AxiumAPI;
import fr.xibalba.axiumApi.AxiumAccount;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApiTest {

    @Test
    public void testLogin() throws URISyntaxException, IOException {

        AxiumAccount login = AxiumAPI.login("test", "testMDP");

        System.out.println(login);

        login.logout();

        assertNull(login.getToken());
        assertEquals(1, login.getId());
        assertEquals(login.getUsername(), "test");
    }
}
