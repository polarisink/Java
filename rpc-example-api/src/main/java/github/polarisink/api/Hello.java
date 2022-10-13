package github.polarisink.api;

import lombok.*;

import java.io.Serializable;

/**
 * @author hzsk
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Hello implements Serializable {
    private String message;
    private String description;
}
