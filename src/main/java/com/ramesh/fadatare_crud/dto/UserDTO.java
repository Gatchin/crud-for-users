package com.ramesh.fadatare_crud.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "Введи имя нормальное")
    private String firstName;
    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "А фамилия где???")
    private String lastName;
    @Schema(
            description = "User email"
    )
    @NotEmpty(message = "Нету почты")
    @Email(message = "Введи почту нормальную")
    private String email;
}
