import java.io.IOException;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        String path = "";
        int sliceWidth = 0, sliceHeight = 0;
        int[] counter = new int[]{0,0,0};

        if (args.length == 0) {
            System.out.println("Please enter a path with d=*path*. ");
        }

        for (int i = 0; i < args.length; i++) {
            switch (args[i].substring(0,2)) {
                case ("d="):
                    path = args[i].substring(2) + "/";
                    counter[0] = 1;
                    break;
                case ("w="):
                    sliceWidth = Integer.parseInt(args[i].substring(2));
                    counter[1] = 1;
                    break;
                case ("h="):
                    sliceHeight = Integer.parseInt(args[i].substring(2));
                    System.out.println(sliceHeight);
                    counter[2] = 1;
                    break;
                default:
                    System.out.println("Please follow the instructions on the README file. ");
                    break;
            }
        }

        if (Arrays.equals(counter, new int[]{1,0,0})) {
            System.out.println("dir only");
            new CompileImage(path);
        } else if (Arrays.equals(counter, new int[]{1,1,0})) {
            System.out.println("dir and width");
            new CompileImage(path, sliceWidth);
        } else if (Arrays.equals(counter, new int[]{1,1,1})) {
            System.out.println("dir, width, and height");
            new CompileImage(path, sliceWidth, sliceHeight);
        } else if (Arrays.equals(counter, new int[]{0,1,0})) {
            System.out.println("Please enter a directory to run the program in.");
        } else {
            System.out.println("Please follow the instructions on the README file. ");
        }

        //new CompileImage(path);

        /*try {
            new CompileImage(path, sliceWidth, sliceHeight);
            System.out.println("Successful.");
        } catch (IOException e) {
            System.out.println("Failed.");
            e.printStackTrace();
        }*/

        System.out.println("DONE");
    }
}