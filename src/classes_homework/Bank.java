package classes_homework;

public class Bank
{
    private static String bankName;
    private static deposit [] deposites = new deposit[10];
    private int count = 0;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addDeposit (deposit aa){
        deposites[count] = aa;
        count++;
    }

    public double[] getMoney (int years){

        double []bb = new double[3];
        for (int i = 0; i < 3; i++){
            bb[i] = deposites[i].profit(years);
        }
        return bb;
    }


}
