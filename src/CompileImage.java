import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CompileImage {

    public CompileImage(String folderPath, String path) throws IOException {
        new SliceImage(folderPath, path);

        ImageProperties imgp = new ImageProperties(folderPath);
        SliceImage simg = new SliceImage(folderPath, path);
        File [] files = imgp.files;
        int height = imgp.height;
        int width = simg.sliceWidth * files.length;

        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        //testing
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                File f = new File(path + "\\slicedImages\\" + Integer.toString(i) + ".png");
                BufferedImage bimg = ImageIO.read(f);

                Graphics g = combined.getGraphics();
                g.drawImage(bimg, simg.sliceWidth * i, 0, null);

                g.dispose();

                if (Files.exists(Path.of(path + "\\export\\"))) {
                    ImageIO.write(combined, "png", new File(path + "\\export\\EXPORT.png"));
                } else {
                    new File(path + "\\export\\").mkdirs();
                    ImageIO.write(combined, "png", new File(path + "\\export\\EXPORT.png"));
                }
            }
        }
    }
}
