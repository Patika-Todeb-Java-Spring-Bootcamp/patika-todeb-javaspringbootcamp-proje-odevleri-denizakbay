package org.patika.advertproject.model.dto;

import lombok.Data;
import org.patika.advertproject.model.entity.Role;

import java.util.List;

@Data
public class UserResponseDTO {

    private Integer id;
    private String username;
    private String email;
    private List<Role> roles;

}
