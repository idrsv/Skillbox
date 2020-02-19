
public class Cat
{
    private static final int QUANTITY_OF_EYES = 2;
    private static final int MIN_WEIGHT = 1500;
    private static final int MAX_WEIGHT = 15000;
    public static int catCount;

    private double weight;
    private double originWeight;
    private double food;
    private String colorOfCat;
    private String name;


    public Cat(double weight, String name, String colorOfCat)
    {
        this.weight = weight;
        this.name = name;
        this.colorOfCat = colorOfCat;
        originWeight = weight;
        catCount++;

    }

    public void setColorOfCat(String colorOfCat)
    {
        this.colorOfCat = colorOfCat;
    }

    public String getColorOfCat()
    {
        return colorOfCat;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void meow()
    {
        weight = weight - 500;

            if (weight >= MAX_WEIGHT || weight <= MIN_WEIGHT)

            catCount--;

            System.out.println("Meow");

    }

    public void feed(Double amount)
    {
        food += amount;
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }


    public void pee()
    {
        weight = weight * 0.97;
        if (weight >= MAX_WEIGHT || weight <= MIN_WEIGHT)
            catCount--;
        System.out.println("Weight: " + getWeight());
    }

    public Double getWeight()
    {
        return weight;
    }

    public Double getFood()
    {
        return food;
    }
    public int getCount()
    {
        return catCount;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT)
        {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT)
        {
            return "Exploded";
        }
        else if(weight > originWeight)
        {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}