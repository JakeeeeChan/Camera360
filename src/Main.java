import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        String path = "";
        int sliceWidth, sliceHeight = 0;

        if (args.length == 0) {
            System.out.println("Please follow the instructions on the READ<E file. ");
        }

        for (int i = 0; i < args.length; i++) {
            switch (args[i].charAt(0)) {
                case ('d'):
                    path = args[i].substring(2);
                    System.out.println(path);
                    break;
                case ('w'):
                    sliceWidth = Integer.parseInt(args[i].substring(2));
                    System.out.println(sliceWidth);
                    break;
                case ('h'):
                    sliceHeight = Integer.parseInt(args[i].substring(2));
                    System.out.println(sliceHeight);
                    break;
                default:
                    System.out.println("Please follow the instructions on the README file. ");
                    break;
            }
        }

        try {
            new CompileImage(path);
            System.out.println("Successful.");
        } catch (IOException e) {
            System.out.println("Failed.");
            e.printStackTrace();
        }

    }
}
