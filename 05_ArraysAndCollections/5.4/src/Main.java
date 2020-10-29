import java.util.*;
public class Main {

    public static void main(String[] args) {

        HashMap<String, String> phoneBook = new HashMap<>();
        // Map <K, V> Данил 89853685585
        for(;;){

            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            String nameOrNumber = input.trim();
            String subscribersName = nameOrNumber.replaceAll("([\\d]+)","").trim();
            String subscribersPhoneNumber = nameOrNumber.replaceAll("([А-Яа-я]+)","").trim();

            if(nameOrNumber.equals("LIST")){
                printPhoneBook(phoneBook);
                continue;
            }
            if (phoneBook.containsKey(subscribersName)){
                System.out.println("Абонент - " + subscribersName + " с номером " +  phoneBook.get(subscribersName));
            }
            else if (phoneBook.containsValue(subscribersPhoneNumber)){
                System.out.println("По номеру " + subscribersPhoneNumber + " зарегистрирован абонент - " + phoneBook.get(subscribersPhoneNumber));
            }
            else phoneBook.put(subscribersName,subscribersPhoneNumber);
        }
    }

   private static void printPhoneBook(HashMap<String, String> phoneBook){
        System.out.println("Телефонный справочник: ");
        for(Map.Entry<String,String> k: phoneBook.entrySet()){
            System.out.println(k.getKey()+" - "+ k.getValue());
        }
   }
}
