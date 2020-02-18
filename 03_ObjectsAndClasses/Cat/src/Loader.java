public class Loader
{
    public static void main(String[] args)
    {
        Cat vaska = new Cat("Васька");
        Cat murka = new Cat("Мурка");
        System.out.println(vaska.getWeight());
        System.out.println(murka.getWeight());
        System.out.println(Cat.catCount);
    }
}