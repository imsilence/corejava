import java.util.Arrays;

public class ArrayType {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        System.out.println(Arrays.toString(numbers));
        numbers[1] = 1;
        for(int idx=0; idx < numbers.length; ++idx) {
            System.out.println(numbers[idx]);
        }
        numbers[2] = 2;
        for(int number : numbers) {
            System.out.println(number);
        }
        int[] numbers2 = numbers;
        int[] numbers3 = Arrays.copyOf(numbers, numbers.length);
        numbers2[3] = 3;
        numbers3[4] = 4;
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbers2));
        System.out.println(Arrays.toString(numbers3));

        System.out.println(Arrays.toString(args));

        Arrays.sort(args);

        System.out.println(Arrays.toString(args));


        int[][] multi = {{1, 2, 3, 4, 5}, {6, 7, 8, 9}};
        System.out.println(Arrays.deepToString(multi));
        for(int i=0; i < multi.length; ++i) {
            for(int j=0; j < multi[i].length; ++j) {
                System.out.println(multi[i][j]);
            }
        }
        for(int[] line : multi) {
            for(int e : line) {
                System.out.println(e);
            }
        }
    }
}