public class Operator implements Employee{
    private final int salary;
    Company company;

    public Operator(int salary){
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
