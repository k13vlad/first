package classes_homework;


public class deposit {

    private int depositeSum;
    private int percent;
    private String clientName;

    public deposit(int depositeSum, int percent, String clientName) {
        this.depositeSum = depositeSum;
        this.percent = percent;
        this.clientName = clientName;
    }

    public double profit(int depYears) {

        double profit = this.depositeSum;

        for (int i = 0; i < depYears; i++) {
            profit = profit + profit * this.percent / 100;
        }
        return profit - depositeSum;
    }

}

