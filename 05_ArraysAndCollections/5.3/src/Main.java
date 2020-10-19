import java.util.Scanner;
import java.util.TreeSet;
//sdsd
public class Main {
    public static void main(String args[]) {
        TreeSet<String> emails = new TreeSet<>();
        emails.add("idrisovds@gmail.com");
        emails.add("savchinvm@gmail.com");
        emails.add("bogatirevmn@gmail.com");
        System.out.println("\n-------------------------------- \nВведите команду: \nADD \nLIST \n--------------------------------");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine() + " ";

            String command = input.substring(0, input.indexOf(" ")).toUpperCase().trim();
            String description = input.substring(command.length()).trim();
            String address = description.replaceAll("(\\w+)(@[a-zA-Z_]+)([.][a-zA-z]{2,6})", "");

            switch (command) {
                case "ADD":
                    if (address.equals("")) {
                        emails.add(description);
                    }
                    else {
                        System.out.println("Неправильно введен адрес электронной почты");
                    }
                    break;
                case "LIST":
                    System.out.println("Список адресов электронной почты: ");
                    for (String email: emails) {
                        System.out.println(email);
                    }
                    break;
            }
        }
    }
}


