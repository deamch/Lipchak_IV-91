
/**
 * C2 = 9118 % 2 = 0   O1 = "+"
 * C3 = 9118 % 3 = 1   C = 1
 * C5 = 9118 % 5 = 3   O2 = "+"
 * C7 = 9118 % 7 = 4   тип індексів i та j = char
 */
class Main {
    public static void main(String[] args) {
        double S = 0;
        int a = 1;
        int n = 2;
        int b = 1;
        int m = 2;
        final int C = 1;
//        char i = (char)a;
//        char j = (char)b;
        for (char i = (char)a; i <= n; i++) {
            for (char j = (char)b; j <= m; j++) {
                S = S + ((double)(i+j)/(i+C));
            }
        }
        System.out.println(S);
    }
}