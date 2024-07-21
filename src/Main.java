import java.io.IOException;

public class Main {

    private static String folderPath = "C:\\Users\\jakes\\Documents\\JakesStuff\\Coding\\Java\\Camera360\\photos\\";

    private  static String path = "C:\\Users\\jakes\\Documents\\JakesStuff\\Coding\\Java\\Camera360\\";

    public static void main(String[] args) throws IOException {

        //new GUI(folderPath);

        new CompileImage(folderPath, path);
    }
}
