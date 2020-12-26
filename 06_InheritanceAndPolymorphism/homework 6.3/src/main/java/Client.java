public abstract class Client {
    public double balance;
    public double getAmount(){
        return balance;
    }
    public void put(double amountToPut){
        balance += amountToPut;
    }
    public void take(double amountToTake){
        balance -= amountToTake;
    }
}