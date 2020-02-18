
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat(50.0);

        System.out.println(murka.getWeightCat());
    }
    private static Cat getKitten()
    {
        return new Cat(1100.0);
    }
}