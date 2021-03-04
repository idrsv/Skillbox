import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Movements {
    public static List<Transaction> transactionList;
    private static final int INCOME = 6;
    private static final int EXPENSE = 7;
    private static final int DESCRIPTION = 5;

    public Movements(String pathMovementsCsv) {
        loadFromFileCSV(pathMovementsCsv);
        Map<String, Map<Double, List<Transaction>>> collect = transactionList.stream().collect(Collectors.groupingBy(Transaction::getDescription, Collectors.groupingBy(Transaction::getExpense)));
        System.out.println(collect);
    }

    private static List<Transaction> loadFromFileCSV(String pathMovementsCsv){
        transactionList = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                String[] fragments = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                if (!line.startsWith("Тип")){
                    transactionList.add(new Transaction(
                            Double.parseDouble(fragments[INCOME].replace(",",".").replace("\"","")),
                            Double.parseDouble(fragments[EXPENSE].replace(",",".").replace("\"","")),
                            fragments[DESCRIPTION].substring(16,68)));
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return transactionList;
    }

    public double getExpenseSum() {
        return transactionList.stream().flatMapToDouble(tr -> DoubleStream.of(tr.getExpense())).sum();
    }

    public double getIncomeSum() {
        return transactionList.stream().flatMapToDouble(tr -> DoubleStream.of(tr.getIncome())).sum();
    }
}