
import java.util.Scanner;

public class FlowControl {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = "";

        System.out.print("请输入是否继续(Y/N):");
        input = in.next();
        System.out.println("input:" + input);
        if("Y".equals(input)) {
            System.out.println("确认");
        }

        System.out.print("请输入是否继续(Y/N):");
        input = in.next();
        System.out.println("input:" + input);
        if("Y".equals(input)) {
            System.out.println("确认");
        } else {
            System.out.println("取消");
        }

        System.out.print("请输入是否继续(Y/N):");
        input = in.next();
        System.out.println("input:" + input);
        if("Y".equals(input)) {
            System.out.println("确认");
        } else if("N".equals(input)) {
            System.out.println("取消");
        } else {
            System.out.println("输入错误");
        }

        System.out.print("请输入是否继续(Y/N):");
        input = in.next();
        System.out.println("input:" + input);
        switch(input) {
            case "Y":
                System.out.println("确认");
                break;
            case "N":
                System.out.println("取消");
                break;
            default:
                System.out.println("输入错误");
                break;
        }

        long total = 0;
        int idx = 0;

        while(idx <= 100) {
            total += idx;
            idx += 1;
        }
        System.out.println("1到100的和为:" + total);


        total = 0;
        idx = 0;
        do {
            total += idx;
            idx += 1;
        } while(idx <= 100);
        System.out.println("1到100的和为:" + total);

        total = 0;
        for(idx = 0; idx <= 100; ++idx) {
            total += idx;
        }
        System.out.println("1到100的和为:" + total);

        for(idx=0; idx<=5; ++idx) {
            if(idx == 3) {
                break;
            }
            System.out.println("break: " + idx);
        }


        for(idx=0; idx<=5; ++idx) {
            if(idx == 3) {
                continue;
            }
            System.out.println("continue: " + idx);
        }
    }
}