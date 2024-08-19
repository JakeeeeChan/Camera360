import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SliceImage {

    public int sliceWidth;

    public SliceImage(String path) throws IOException {
        String folderPath = path + "photos/";

        ImageProperties imgp = new ImageProperties(folderPath);
        File [] files = imgp.files;
        int height = imgp.height;
        int width = imgp.width;
        int posX = width/2;
        int posY = 0;
        int sliceWidth = 3;


        for (int i = 0; i < files.length; i++) {
            if (!files[i].getPath().equals("skip")){
                //slice image and export as new

                BufferedImage bimg = ImageIO.read(files[i]);
                BufferedImage slicedImage = bimg.getSubimage(posX, posY, sliceWidth, height);

                //check if dir is already created for sliced images
                if (Files.exists(Path.of(path + "/tempSlicedImages/"))) {
                    File slicedPath = new File(path + "/tempSlicedImages/");

                    File outputFile = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");

                    ImageIO.write(slicedImage, "png", outputFile);
                } else {
                    new File(path + "/tempSlicedImages/").mkdirs();

                    File outputFile = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");

                    ImageIO.write(slicedImage, "png", outputFile);
                }
            }
        }

        this.sliceWidth = sliceWidth;
    }

    public SliceImage(String path, int sliceWidth) throws IOException {
        String folderPath = path + "photos/";

        ImageProperties imgp = new ImageProperties(folderPath);
        File [] files = imgp.files;
        int height = imgp.height;
        int width = imgp.width;
        int posX = width/2;
        int posY = 0;

        for (int i = 0; i < files.length; i++) {
            if (!files[i].getPath().equals("skip")){
                //slice image and export as new

                BufferedImage bimg = ImageIO.read(files[i]);
                BufferedImage slicedImage = bimg.getSubimage(posX, posY, sliceWidth, height);

                //check if dir is already created for sliced images
                if (Files.exists(Path.of(path + "/tempSlicedImages/"))) {
                    File slicedPath = new File(path + "/tempSlicedImages/");

                    File outputFile = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");

                    ImageIO.write(slicedImage, "png", outputFile);
                } else {
                    new File(path + "/tempSlicedImages/").mkdirs();

                    File outputFile = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");

                    ImageIO.write(slicedImage, "png", outputFile);
                }
            }
        }

        this.sliceWidth = sliceWidth;
    }

    public SliceImage(String path, int sliceWidth, int sliceHeight) throws IOException {
        String folderPath = path + "photos/";

        ImageProperties imgp = new ImageProperties(folderPath);
        File [] files = imgp.files;
        int width = imgp.width;
        int posX = width/2;
        int posY = 0;

        for (int i = 0; i < files.length; i++) {
            if (!files[i].getPath().equals("skip")){
                //slice image and export as new

                BufferedImage bimg = ImageIO.read(files[i]);
                BufferedImage slicedImage = bimg.getSubimage(posX, posY, sliceWidth, sliceHeight);

                //check if dir is already created for sliced images
                if (Files.exists(Path.of(path + "/tempSlicedImages/"))) {
                    File slicedPath = new File(path + "/tempSlicedImages/");

                    File outputFile = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");

                    ImageIO.write(slicedImage, "png", outputFile);
                } else {
                    new File(path + "/tempSlicedImages/").mkdirs();

                    File outputFile = new File(path + "/tempSlicedImages/" + Integer.toString(i) + ".png");

                    ImageIO.write(slicedImage, "png", outputFile);
                }
            }
        }

        this.sliceWidth = sliceWidth;
    }
}