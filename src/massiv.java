
public class massiv {

    public static void main(String[] args) {
       int a[] = {0,1,2,3,4,5};

        for (int t = 0; t < a.length; t++){
            System.out.println(a[t] + "\n");
        }

        double r = 0;
        for (int i = 0; i < a.length; i++) {
            r = r + a[i];
        }
        double m = r / a.length;
        System.out.println(m);


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
        System.out.println(min + " & " + max + "\n");
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



}


