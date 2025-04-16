package br.com.rpe.data;

import br.com.rpe.dto.UserDTO;

public class UserFactory {

    public static UserDTO validUser() {
        return new UserDTO("Camila", "QA Engineer");
    }

    public static UserDTO updatedUser() {
        return new UserDTO("Camila Atualizada", "QA Sênior");
    }

    public static UserDTO partialUpdate() {
        return new UserDTO(null, "QA Líder");
    }
}
