package lesson10.online;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    /*
    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
    Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
    делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner)...
     */
    private final Map<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String number, String surname) {
        phoneBook.put(number, surname);
    }

    public Set<String> get(String surname) {
        Set<String> phoneNumbers = new HashSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (surname.equals(entry.getValue())) {
                phoneNumbers.add(entry.getKey());
            }
        }
        return phoneNumbers;
    }
}
