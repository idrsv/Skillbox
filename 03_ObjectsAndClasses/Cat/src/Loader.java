public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat(55500.00,"Мурка", "Grey");
        Cat bobo = new Cat(6000.00,"Бобо", "Grey");
        murka.meow();



        System.out.println(murka.getWeight());
        System.out.println(bobo.getWeight());
        System.out.println(Cat.catCount);

    }
}