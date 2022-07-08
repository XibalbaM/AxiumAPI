package fr.xibalba.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicAxiumAccount {

    Integer id;

    String username;

    String email;

    Date tokenExpiration;

    String icon_url;

    Date creationDate;

    int xp;

    int fidelity;

    int premium;

    boolean emailVerified;

    boolean enabled;

    List<AxiumGame> games;

    List<AxiumRole> roles;
}
