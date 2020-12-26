import java.time.LocalDate;
// Реализация класса депозитарного счета
public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;
    private LocalDate nowDate = LocalDate.now();

    @Override
    public void put(double amountToPut) {
        lastIncome = DatePut();
        super.put(amountToPut); }

    @Override
    public void take(double amountToTake) {
        if (lastIncome.isBefore(nowDate)){
            if (lastIncome.getMonthValue() == nowDate.getMonthValue()){
                System.out.println("Рано");
            }
        }
        super.take(amountToTake);
    }
    public LocalDate DatePut(){
        LocalDate date = LocalDate.now();
        return date; }
}