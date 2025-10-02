package ru.makhov232;

import ru.makhov232.model.Gender;
import ru.makhov232.repository.UsersRepository;

public class App {
    public static void main(String[] args) {
        UsersRepository repo = new UsersRepository();
        repo.addUser("Иван", 20, Gender.MALE);
        repo.addUser("Мария", 22, Gender.FEMALE);
        repo.addUser("Пётр", 30, Gender.MALE);

        System.out.print(repo.printAllToString());
        System.out.println("Мужчин: " + repo.getMales().size());
        System.out.println("Женщин: " + repo.getFemales().size());
        System.out.println("Всего: " + repo.getTotalCount());
        System.out.println("Средний возраст: " + repo.getAverageAge());
    }
}


