package fr.xibalba.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Date;

/**
 * A game on Axium.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AxiumGame {

    /**
     * The id of the game.
     */
    Integer id;

    /**
     * The name of the game.
     */
    String name;

    /**
     * The url to the game's icon.
     */
    String icon_url;

    /**
     * The game's download url.
     */
    String download_url;

    /**
     * The game's current version.
     */
    String version;

    /**
     * The game's last update date.
     */
    Date last_update;
}
