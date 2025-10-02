package ru.makhov232.repository;

import ru.makhov232.model.Gender;
import ru.makhov232.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class UsersRepository {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idSequence = new AtomicLong(0);

    public User addUser(String name, int age, Gender gender) {
        long id = idSequence.incrementAndGet();
        User user = new User(id, name, age, gender);
        users.add(user);
        return user;
    }

    public List<User> getAll() {
        return Collections.unmodifiableList(users);
    }

    public List<User> getMales() {
        return users.stream().filter(u -> u.getGender() == Gender.MALE).collect(Collectors.toList());
    }

    public List<User> getFemales() {
        return users.stream().filter(u -> u.getGender() == Gender.FEMALE).collect(Collectors.toList());
    }

    public int getTotalCount() {
        return users.size();
    }

    public double getAverageAge() {
        if (users.isEmpty()) {
            return 0.0;
        }
        return users.stream().mapToInt(User::getAge).average().orElse(0.0);
    }

    public String printAllToString() {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(String.format("%d. %s, %d, %s%n", user.getId(), user.getName(), user.getAge(), user.getGender()));
        }
        return sb.toString();
    }
}


