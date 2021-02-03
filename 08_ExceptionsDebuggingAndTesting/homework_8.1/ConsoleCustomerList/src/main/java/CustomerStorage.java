import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
            String[] components = data.split("\\s+");
            if (components.length != 4){
                throw new IllegalArgumentException("Wrong format. Correct format \n" +
                        "add Василий Петров vasily.petrov@gmail.com +79215637722");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            Pattern VALID_EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
            Pattern VALID_PHONE_REGEX = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
            Matcher matcherEmail = VALID_EMAIL_REGEX.matcher(components[INDEX_EMAIL]);
            Matcher matcherPhone = VALID_PHONE_REGEX.matcher(components[INDEX_PHONE]);
            if (!matcherEmail.find()){
                throw new IllegalArgumentException("Wrong format. Correct format email \n" +
                    "vasily.petrov@gmail.com");
            }
            if (!matcherPhone.find()){
                throw new IllegalArgumentException("Wrong format. Correct format phone number \n" +
                        "+79215637722");
            }
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}