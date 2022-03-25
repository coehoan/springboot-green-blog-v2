package site.metacoding.blogv2.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateDto {
    private String password;
    private String email;
    private String addr;
}
