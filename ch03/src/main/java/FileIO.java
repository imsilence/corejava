
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.util.Date;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Paths.get("in.txt"), "UTF-8");
        while(in.hasNextLine()) {
            System.out.println(in.nextLine());
        }

        PrintWriter out = new PrintWriter("output.txt", "UTF-8");
        out.println("1");
        out.printf("%tY-%<tm-%<td %<tH:%<tM:%<tS\n", new Date());
        out.close();
    }
}