import java.util.Scanner;

public class Loader
{
    public static void main(String[] args)
    {
        System.out.println("Введите: Фамилию Имя Отчество");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();

        int firstIndex = fullName.indexOf(' ');
        int lastIndex = fullName.lastIndexOf(' ');

        String firstName = fullName.substring(0, firstIndex);
        String lastName = fullName.substring(firstIndex + 1, lastIndex);
        String middleName = fullName.substring(lastIndex + 1);

        System.out.println("Фамилия: " + firstName);
        System.out.println("Имя: " + lastName);
        System.out.println("Отчество: " + middleName);
    }
}