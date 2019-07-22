import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Main {

    private static final String FILE_NAME = "receipt.jpg";
    private static final String TRAINING_DATA = "eng.traineddata";

    public static void main(String[] args){
        ResourceExtractor resourceExtractor = new ResourceExtractor();
        File tmpFile = resourceExtractor.getFileFromResources(FILE_NAME);
        try {
            Tesseract tesseract = new Tesseract();

            tesseract.setDatapath(resourceExtractor.getResourceFolderPath(TRAINING_DATA));
            String imageText = tesseract.doOCR(tmpFile);
            System.out.println(imageText);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }



}
