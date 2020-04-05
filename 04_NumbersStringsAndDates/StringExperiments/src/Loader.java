public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);

        Integer vasyaSum = Integer.parseInt(text.substring(15, text.indexOf("руб")).trim());
        Integer mashaSum = Integer.parseInt(text.substring(text.indexOf("Маша - ") + 6, text.lastIndexOf("руб")).trim());

        int sum = vasyaSum + mashaSum;
        System.out.println(sum);
    }
}