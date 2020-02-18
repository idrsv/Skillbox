
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();
        System.out.println("Murka weight: " + murka.getWeight());

        Cat vaska = new Cat();
        System.out.println("Vaska weight: " + vaska.getWeight());

        Cat pushok = new Cat();
        System.out.println("Pushok weight: " + pushok.getWeight());

        Cat charley = new Cat();
        System.out.println("Charley weight: " + charley.getWeight());

        Cat bobo = new Cat();
        System.out.println("Bobo weight: " + bobo.getWeight());
        ////Напечатать в консоли вес созданных кошек
        murka.feed(5.0);
        System.out.println("Murka weight: " + murka.getWeight());

        vaska.feed(10.0);
        System.out.println("Vaska weight: " + vaska.getWeight());
        ////Покормить 2 кошки и распечатать их вес

        charley.feed(9000.0);
        System.out.println("Charley weight: " + charley.getStatus());
        ////Перекормить кошку, чтобы она "взорвалась"

        while (murka.getWeight() >= 1000.0)
            murka.meow();
        System.out.println("Charley weight: " + murka.getStatus());
        ////Замяукал кошку до смерти
    }
}