import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ImageProperties {

    public File [] files;
    public int width;
    public int height;

    public ImageProperties(String folderPath) throws IOException {
        BufferedImage bimg;

        File path = new File(folderPath);

        File [] files = path.listFiles();

        int[] width = new int[files.length];
        int[] height = new int[files.length];

        for (int i = 0; i < files.length; i++) {
            switch (files[i].getAbsolutePath().substring(((files[i].getAbsolutePath().length())) - 4).toLowerCase(Locale.ROOT)) {
                case(".png"), (".jpg"):
                    bimg = ImageIO.read(files[i]);
                    width[i] = bimg.getWidth();
                    height[i] = bimg.getHeight();
                    this.width = width[i];
                    this.height = height[i];
                    break;
                default:
                    files[i] = new File("skip");
                    //delete the element out of the array.

                    break;
            }
        }

        this.files = files;
    }
}