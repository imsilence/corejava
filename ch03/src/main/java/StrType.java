
public class StrType {

    public static void main(String[] args) {
        String name = "Silence";

        String article = "十年磨一剑, 霜刃未曾试. 今日把示君, 谁有不平事?";

        System.out.println(article);

        System.out.println(article.substring(0, 13));

        System.out.println("Hi " + name);

        System.out.println("i'm " + 29 + " year old");

        System.out.println(String.join("/", "S", "M", "L", "XL"));

        System.out.println("name length: " + name.length());

        System.out.println("name codePointCount: "+ name.codePointCount(0, name.length()));

        System.out.println("article length: " + article.length());

        System.out.println("article codePointCount: "+ article.codePointCount(0, article.length()));

    }
}