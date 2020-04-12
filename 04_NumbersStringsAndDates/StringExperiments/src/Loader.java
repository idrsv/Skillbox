public class Loader
{
    public static void main(String[] args)
//    {
//        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
//        System.out.println(text);
//
//        Integer vasyaSum = Integer.parseInt(text.substring(15, text.indexOf("руб")).trim());
//        Integer mashaSum = Integer.parseInt(text.substring(text.indexOf("Маша - ") + 6, text.lastIndexOf("руб")).trim());
//
//        int sum = vasyaSum + mashaSum;
//        System.out.println(sum);
//    }
    {
        String text2 = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей , Катя - 200000 рублей";
        System.out.println(text2);

        String[] sentences =  text2.split(",\\s");
        int sum = 0;

        for(int i = 0; i < sentences.length; i++)
        {
            sum += Integer.parseInt((sentences[i].replaceAll("[^0-9]","")).trim());
        }
        {
            System.out.println("Вместе они все заработали: " + sum);
        }
    }
}