public class IndividualBusinessman extends PhysicalPerson {

    @Override
    public void put(double amountToPut) {
        if (amountToPut >= 1000.0){
            amountToPut -= 0.005 * amountToPut;
        }
        else {
            amountToPut -= 0.01 * amountToPut;
        }
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake);
    }
}