public class Loader {
    public static void main(String args[]){
        String text = "More and more companies are generating energy themselves, using solar installations or systems that recover energy from manufacturing waste, in an effort to cut costs. Now, researchers from the Fraunhofer Institute for Factory Operation and Automation IFF in Magdeburg have developed dynamic energy management systems that manage distributed energy providers, storage and current energy consumption efficiently. Installed in a company, such a system determines whether enough renewable energy will still be available to charge the fleet of electric company cars once power has been supplied to the HVAC system. So that the system can operate fully automatically, the amount of energy required and the amount of power expected to be produced on a given day are measured at first for general planning. In the detailed planning stage, data are supplied for the next fifteen minutes. The researchers use neural networks trained specifically for the particular complex infrastructure to make a forecast, which the system then uses to optimize energy use in the next quarter of an hour automatically.";

        String[] sentences = text.split("\\s");
        for (int i = 0; i < sentences.length; i++){
            System.out.println(sentences[i].replaceAll("[^A-Za-z0-9]",""));
        }
    }
}
