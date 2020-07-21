import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberNewDeal;
        String newDeal;
        int dealNumber;
        String descriptionOfTheEditedCase;
         ArrayList<String> todoList = new ArrayList<>() {{
            add(0, "Сходить в магазин");
            add(1, "Сходить на тренировку");
            add(2, "Сделать домашнюю работу на Skillbox.ru");
            add(3, "Отнести посылку на почту");
        }};
        while (true) {
            System.out.println("\n-------------------------------- \nВведите нужный номер команды: \n1 - ADD \n2 - EDIT \n3 - DELETE \n4 - LIST \n--------------------------------");
            Scanner scanner = new Scanner(System.in);
            String deals = scanner.nextLine();
            switch (deals) {
                case "1":
                    System.out.println("Введите порядковый номер нового дела");
                    Scanner scanner1 = new Scanner(System.in);
                    numberNewDeal = scanner1.nextInt() - 1;
                    System.out.println("Введите описание нового дела");
                    Scanner scanner2 = new Scanner(System.in);
                    newDeal = scanner2.nextLine();
                    todoList.add(numberNewDeal, newDeal);
                    System.out.println("Выполнено!");
                    continue;
                case "2":
                    System.out.println("Введите порядковый номер дела из списка, который вы хотите редактировать");
                    Scanner scanner3 = new Scanner(System.in);
                    dealNumber = scanner3.nextInt() - 1;
                    System.out.println("Введите новое описание дела ");
                    Scanner scanner4 = new Scanner(System.in);
                    descriptionOfTheEditedCase = scanner4.nextLine();
                    todoList.set(dealNumber, descriptionOfTheEditedCase );
                    System.out.println("Выполнено!");
                    continue;
                case "3":
                    System.out.println("Введите порядковый номер дела, которое необходимо удалить и списка");
                    todoList.remove(scanner.nextInt() - 1);
                    System.out.println("Выполнено!");
                    continue;
                case "4":
                    System.out.println("Ваш список дел: ");
                    for (int i = 0; i < todoList.size(); i++)
                    {
                        System.out.println((i + 1) + " " + todoList.get(i));
                    };
                    break;
            }
        }

    }
}
