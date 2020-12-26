public class PhysicalPerson extends Client{
    @Override
    public void put(double amountToPut) {
        if (amountToPut < 0.0){
            amountToPut = 0.0;
        }super.put(amountToPut);
    }
    @Override
    public void take(double amountToTake) {
        if (amountToTake > balance){
            amountToTake = 0.0;
        }super.take(amountToTake);
    }
}