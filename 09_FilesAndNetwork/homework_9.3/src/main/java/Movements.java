import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {
    public static List<Double> movementIncome;
    public static List<Double> movementExpense;

    public Movements(String pathMovementsCsv) {
        Movements.getIncome(pathMovementsCsv);
        Movements.getExpense(pathMovementsCsv);
    }

    private static List<Double> getExpense(String pathMovementsCsv){
        movementExpense = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                String[] fragments = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                if (!line.startsWith("Тип")){
                    movementExpense.add(Double.parseDouble(fragments[7].replace(",",".").replace("\"","")));
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return movementExpense;
    }

    private static List<Double> getIncome(String pathMovementsCsv){
        movementIncome = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                String[] fragments = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                if (!line.startsWith("Тип")) {
                    movementIncome.add(Double.parseDouble(fragments[6].replace(",", ".").replace("\"", "")));
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return movementIncome;
    }

    public double getExpenseSum() {
        double expenseSum = 0.0;
        for (Double aDouble : movementExpense) {
            expenseSum += aDouble;
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0.0;
        for (Double aDouble : movementIncome){
            incomeSum += aDouble;
        }
        return incomeSum;
    }
}
