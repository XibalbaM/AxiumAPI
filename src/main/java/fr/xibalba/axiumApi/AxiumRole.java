package fr.xibalba.axiumApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AxiumRole {

    Integer id;

    String name;

    int priority;

    String prefix;

    boolean multiple_prefix;

    String prefix_color;

    String suffix;

    boolean multiple_suffix;

    String suffix_color;

    List<AxiumAccount> accounts;
}