import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //총 몇개의 숫자를 입력 받을 것인지
        int count = 0;
        int input = 0;
        count = sc.nextInt();
        int[] lst;

        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();



        if (count > 0) {

            for (int i = 0; i < count; i++) {
                input = sc.nextInt();
                list.clear();

                sum = 0;

                //약수 구하기
                for (int z = 1; z < input; z++) {
                    if (input % z == 0) {
                        list.add(z);
                        sum = sum + z;
                    }
                }

                //배열로 변환
                lst = new int[list.size()];
                for (int c = 0; c < list.size(); c++) {
                    lst[c] = list.get(c);
                }

                //체크
                if (input > sum || isWeirds(lst, lst.length - 1, 0, input)) {
                    System.out.println("not weird");
                } else {
                    System.out.println("weird");
                }
            }
        }
    }

    public static boolean isWeirds(int[] lst, int index, int sum, int input) {


        if (input == sum) {
            return true;
        } else if (input < sum || index == -1) {
            return false;
        } else {
            return (isWeirds(lst, index - 1, sum + lst[index], input) || isWeirds(lst, index - 1, sum, input));
        }
    }
}