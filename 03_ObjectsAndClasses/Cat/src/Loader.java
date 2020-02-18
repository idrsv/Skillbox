public class Loader
{
    public static void main(String[] args)
    {
        Cat Bobo = new Cat();
        System.out.println(Bobo.getWeight());
        Bobo.feed(200.00);
        System.out.println(Bobo.getWeight());
        Bobo.pee();
        System.out.println(Bobo.getFood());
    }
}