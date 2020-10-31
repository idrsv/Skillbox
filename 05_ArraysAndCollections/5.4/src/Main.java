import java.util.*;
public class Main {
    private static TreeMap<String, String> phoneBook = new TreeMap<>();
    public static void main(String[] args) {
        // Map <K, V> Данил 89853685585
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String input = scanner.nextLine();
            String nameOrNumber = input.trim();
            String subscribersName = nameOrNumber.replaceAll("([\\d]+)", "").trim();
            String subscribersPhoneNumber = nameOrNumber.replaceAll("([А-Яа-я]+)", "").trim();

            if (nameOrNumber.equals("LIST")) {
                printPhoneBook(phoneBook);
                continue;
            }
            if (phoneBook.containsKey(subscribersName)) {
                System.out.println("Абонент - " + subscribersName + " с номером " + phoneBook.get(subscribersName));
            } else if (phoneBook.containsValue(subscribersPhoneNumber)) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()){
                    if (entry.getValue().equals(subscribersPhoneNumber)){
                        System.out.println("По номеру " + subscribersPhoneNumber + " зарегистрирован абонент - " + entry.getKey());
                    }
                }
            } else phoneBook.put(subscribersName, subscribersPhoneNumber);
        }
    }

    private static void printPhoneBook(Map<String, String> map) {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
