public class DataType {

    public static void main(String[] args) {
        byte age = 30;
        short height = 168;
        int weight = 68;
        long id = 1000L;
        System.out.printf("id:%d, age: %d, height: %d, weight: %d\n", id, age, height, weight);

        System.out.printf("byte min: %d, max: %d\n", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("byte min: %d, max: %d\n", (byte)0X80, 0X7F);
        System.out.printf("short min: %d, max: %d\n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("short min: %d, max: %d\n", (short)0X80_00, 0X7F_FF);
        System.out.printf("int min: %d, max: %d\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("int min: %d, max: %d\n", 0X80_00_00_00, 0X7F_FF_FF_FF);
        System.out.printf("long min: %d, max: %d\n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("long min: %d, max: %d\n", 0X80_00_00_00_00_00_00_00L, 0X7F_FF_FF_FF_FF_FF_FF_FFL);

        float pi = 3.14F;
        double money = 1000.31D;

        System.out.printf("pi: %f\n", pi);
        System.out.printf("money: %f\n", money);

        System.out.printf("float min: %e, max: %e\n", Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("double min: %e, max: %e\n", Double.MIN_VALUE, Double.MAX_VALUE);


        char ch = 'A';
        char registerNotation = '\u2122';
        char doubleQuote = '"';

        System.out.printf("a: %c, register notation: %c, double quote: %c\n", ch, registerNotation, doubleQuote);

        boolean isBoy = true;

        System.out.println(isBoy);

        System.out.println(Math.sqrt(4));
        System.out.println(Math.pow(4, 2));

        final float PI = 3.1415936F;

        System.out.printf("final PI: %f", PI);

        byte bsum = (byte)(age + age);
        short ssum = (short)(height + height);
        int isum = weight + weight;
        long lsum = id + id;

        System.out.printf("bsum: %d, ssum: %d, isum: %d, lsum: %d\n", bsum, ssum, isum, lsum);

        float fsum = pi + pi;
        double dsum = money + money;

        System.out.printf("fsum: %f, dsum: %f\n", fsum, dsum);
    }
}