public class Cat
{
    public static int catCount;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private String name;


    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    public Cat(String name)
    {
        this();
        this.name = name;

        if (weight >= maxWeight)
            catCount = catCount - 1;
        else if (weight <= minWeight)
            catCount = catCount - 1;
        else catCount = catCount + 1;
    }

    public String getName()
    {
        return name;
    }

    public int getCount()
    {
        return catCount;
    }


    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }


    public void feed(Double amount)
    {
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }


    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}