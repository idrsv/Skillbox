
public class Cat
{
    private double originWeight;
    private double weight;

    private String colorOfCat;
    private String name;

    private double minWeight;
    private double maxWeight;

    public Cat(double weight, String name, String colorOfCat)
    {
        this.weight = weight;
        originWeight = weight;
        this.colorOfCat = colorOfCat;
        this.name = name;
    }
    private static Cat copyCat(Cat cat)
    {
        Cat newCat = new Cat(cat.getWeight(), cat.getColorOfCat(), cat.getName());
        return newCat;
    }


    public void setColorOfCat(String colorOfCat) {
        this.colorOfCat = colorOfCat;
    }

    public String getColorOfCat() {
        return colorOfCat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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