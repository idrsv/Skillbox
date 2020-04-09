import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Введите: Фамилию Имя Отчество");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();

        int firstIndex = fullName.indexOf(' ');
        int lastIndex = fullName.lastIndexOf(' ');
        int space = 0;
        int fullName2 = 0;

        for (int i = 0; i < fullName.length(); i++) {
            if (Character.isWhitespace(fullName.charAt(i))) {
                space++;
            }
            if ((fullName.charAt(i) >= '0' && fullName.charAt(i) <= '9')) {
                fullName2 = 1;
            }
        }
        if (fullName2 == 1 || space != 2) {
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