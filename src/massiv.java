
public class massiv {

    public static void main(String[] args) {
//      Иниализация и вывод массива

        int a[] = {0,1,2,3,4,5};
        System.out.println("Array: ");
        for (int t = 0; t < a.length; t++){
            System.out.println(a[t]);
        }

//      Вывод среднего значения
        double m = averageValue(a);
        System.out.println("\n" + "Average Value " + m);

//      Вывод минимума и максимума массива
        int b[] = minmax(a);
        System.out.println("Minimum value: " + b[0] + " & " +  "Maximum value: " + b[1] + "\n");

//      Вывод обратного массива
        System.out.println("Reverse array:");
        Reverse(a);
        for (int j = 0; j < a.length; j++){
            System.out.println(a[j]);
        }


    }

    public static int[] Reverse(int[]a) {
        int temp=0;
        for(int i=0;i<a.length /2;i++)
        {
            temp=a[i];
            a[i]=a[a.length-i-1];
            a[a.length -i-1]=temp;
        }
        return a;
    }

    public static double averageValue(int[]a){
        double r = 0;
        for (int i = 0; i < a.length; i++) {
            r = r + a[i];
        }
        r = r / a.length;
        return r;
    }

    public static int[] minmax(int[]a){

        int max = a[0];
        int min = a[0];
        for(int i = 0; i != a.length; i ++){
            if(a[i] > max){
                max = a[i];
            }
            if(a[i] < min){
                min = a[i];
            }
        }
        int []mmas = {min, max};

        return mmas;

    }

}


