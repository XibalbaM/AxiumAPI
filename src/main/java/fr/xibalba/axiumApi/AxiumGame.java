package fr.xibalba.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AxiumGame {

    Integer id;

    String name;

    String icon_url;

    String download_url;

    String version;

    Date last_update;
}
