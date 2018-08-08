
import java.util.Scanner;
import java.io.Console;


public class ConsoleInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("请输入你的名字: ");
        System.out.println("你输入的是:" + in.nextLine());

        System.out.println("你输入的是:" + in.next());
        System.out.println("你输入的是: " + in.next());

        System.out.println("你输入的是:" + in.nextInt());

        Console console = System.console();

        System.out.println("你输入的是:" + console.readLine("请输入你的名字: "));
        System.out.println("你输入的是:" + console.readPassword("请输入你的密码: "));
    }
}