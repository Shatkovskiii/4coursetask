package ru.makhov232.repository;

import org.junit.jupiter.api.Test;
import ru.makhov232.model.Gender;

import static org.junit.jupiter.api.Assertions.*;

public class UsersRepositoryTest {

    @Test
    void add_and_print_users() {
        UsersRepository repo = new UsersRepository();
        repo.addUser("Иван", 20, Gender.MALE);
        repo.addUser("Мария", 22, Gender.FEMALE);

        String printed = repo.printAllToString();
        assertTrue(printed.contains("1. Иван, 20, MALE"));
        assertTrue(printed.contains("2. Мария, 22, FEMALE"));
    }

    @Test
    void filter_by_gender() {
        UsersRepository repo = new UsersRepository();
        repo.addUser("Иван", 20, Gender.MALE);
        repo.addUser("Мария", 22, Gender.FEMALE);
        repo.addUser("Пётр", 30, Gender.MALE);

        assertEquals(2, repo.getMales().size());
        assertEquals(1, repo.getFemales().size());
    }

    @Test
    void count_and_average_age() {
        UsersRepository repo = new UsersRepository();
        repo.addUser("Иван", 20, Gender.MALE);
        repo.addUser("Мария", 22, Gender.FEMALE);
        repo.addUser("Пётр", 30, Gender.MALE);

        assertEquals(3, repo.getTotalCount());
        assertEquals((20 + 22 + 30) / 3.0, repo.getAverageAge(), 1e-9);
    }
}


