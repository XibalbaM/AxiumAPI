package test;

import fr.xibalba.axiumApi.AxiumAPI;
import fr.xibalba.axiumApi.AxiumAccount;
import fr.xibalba.axiumApi.AxiumGame;
import fr.xibalba.axiumApi.AxiumRole;
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
        System.out.println(AxiumAPI.getAccountPublicInfos(0));

        login.logout();

        assertNull(login.getToken());
        assertEquals(1, login.getId());
        assertEquals(login.getUsername(), "test");
    }

    @Test
    public void testRole() throws URISyntaxException {

        AxiumRole[] role = AxiumAPI.getRoles();
        assertEquals(3, role.length);
        assertEquals(role[0].getName(), "role");
    }


    @Test
    public void testGame() throws URISyntaxException {

        AxiumGame[] role = AxiumAPI.getGames();
        assertEquals(2, role.length);
        assertEquals(role[0].getName(), "Test");
    }
}
