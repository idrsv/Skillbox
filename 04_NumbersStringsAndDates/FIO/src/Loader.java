import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Введите: Фамилию Имя Отчество");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();

        int firstIndex = fullName.indexOf(' ');
        int lastIndex = fullName.lastIndexOf(' ');
        int space = 0;

        boolean fullName2 = true;
        for (int i = 0; i < fullName.length(); i++) {
            if (Character.isWhitespace(fullName.charAt(i))) {
                space++;
            }
            if ((fullName.charAt(i) >= '0' && fullName.charAt(i) <= '9') || (space < 2 | space > 2)) {
                fullName2 = false;
            }
        }
        if (fullName2 == false) {
            System.out.println("Вы допустили ошибку при вводе данных");
        }
            else {
                String firstName = fullName.substring(0, firstIndex);
                String lastName = fullName.substring(firstIndex + 1, lastIndex);
                String middleName = fullName.substring(lastIndex + 1);
                System.out.println("Фамилия: " + firstName);
                System.out.println("Имя: " + lastName);
                System.out.println("Отчество: " + middleName);
            }
    }
}