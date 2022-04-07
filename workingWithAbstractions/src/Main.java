import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
//        red -> green -> yellow -> red

            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(scanner.nextLine());


            StringBuilder out = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < input.length; j++) {
                    Light light = new Light(Color.valueOf(input[j]));
                    light.changeColor();
                    input[j] = light.toString();
                    out.append(light.getColor()).append(" ");
                }
                out.append(System.lineSeparator());

            }
            System.out.print(out);

        }
}
