public class LegalPerson extends PhysicalPerson {

    @Override
    public void take(double amountToTake) {
        double percentToTake = amountToTake * 0.01;
        super.take(amountToTake + percentToTake);
    }
    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }
}