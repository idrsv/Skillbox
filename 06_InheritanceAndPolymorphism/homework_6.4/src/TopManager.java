public class TopManager implements Employee{
    private Company company;
    private int salary;

    public TopManager(int salary){
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        if (Company.getIncome() > 10000000){
            return (int) (2.5 * salary);
        }
        return salary;
    }
}