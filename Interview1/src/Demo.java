public class Demo {

    public static int getSmallestNumber(int input1) {
        int res = 0;
        for (int i = 2; i < 10000; i++) {
            if (getSum(input1 * i) == input1) {
                res = input1 * i;
                break;
            }

        }
        return res;
    }

    static int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
       /* 3=>12
        2=20
        4=20
        4=40
       */
        int n =4;
        int result = getSmallestNumber(n);
        System.out.println(result);

    }
}