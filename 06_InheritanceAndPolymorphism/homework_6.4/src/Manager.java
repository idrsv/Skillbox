public class Manager implements Employee{
    private Company company;
    private int salary;
    private int min = 115000;
    private int max = 140000;

    public Manager(int salary){
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        int percent = (int) (0.05 * (int) (Math.random() * (max - min) + min));
        return (salary + percent);
    }
}
