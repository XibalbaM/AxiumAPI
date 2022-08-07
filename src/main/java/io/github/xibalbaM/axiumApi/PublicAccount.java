package io.github.xibalbaM.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Date;
import java.util.List;

/**
 * The public version of the {@link Account}.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicAccount {

    /**
     * The id of the account.
     */
    Integer id;

    /**
     * The username of the account.
     */
    String username;

    /**
     * The email of the account.
     */
    String email;

    /**
     * The date of the self-destruction of the token.
     */
    Date tokenExpiration;

    /**
     * The URL of the avatar of the account.
     */
    String icon_url;

    /**
     * The date of creation of the account.
     */
    Date creationDate;

    /**
     * The xp amount of the account.
     */
    int xp;

    /**
     * The fidelity points amount of the account.
     */
    int fidelity;

    /**
     * The premium points amount of the account.
     */
    int premium;

    /**
     * If the {@Link #email} is verified.
     */
    boolean emailVerified;

    /**
     * If the account is enabled.
     * False if the account have a role like BANNED or DISABLED.
     */
    boolean enabled;

    /**
     * The games of the account.
     */
    List<Game> games;

    /**
     * The roles of the account.
     */
    List<Role> roles;
}
