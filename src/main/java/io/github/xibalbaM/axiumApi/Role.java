package io.github.xibalbaM.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

/**
 * A role on Axium.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {

    /**
     * The id of the role.
     */
    Integer id;

    /**
     * The name of the role.
     */
    String name;

    /**
     * The priority of the role.
     * Used to show prefixes.
     */
    int priority;

    /**
     * The prefix of the role.
     */
    String prefix;

    /**
     * If the role allows to have multiple role's {@link #prefix} shown at same time.
     */
    boolean multiple_prefix;

    /**
     * The color of the {@link #prefix}.
     */
    String prefix_color;

    /**
     * The suffix of the role.
     */
    String suffix;

    /**
     * If the role allows to have multiple role's {@link #suffix} shown at same time.
     */
    boolean multiple_suffix;

    /**
     * The color of the {@link #suffix}.
     */
    String suffix_color;

    /**
     * The list of accounts who have this role.
     */
    List<Account> accounts;
}