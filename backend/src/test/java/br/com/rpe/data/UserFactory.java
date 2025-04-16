package br.com.rpe.data;

import br.com.rpe.dto.User;

public class UserFactory {

    public static User validUser() {
        return new User("Camila", "QA Backend");
    }

    public static User fullUpdate() {
        return new User("Camila Atualizada", "Senior QA");
    }

    public static User partialUpdate() {
        return new User(null, "Especialista em Testes");
    }
}