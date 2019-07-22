import java.io.File;
import java.net.URL;

public class ResourceExtractor {

    public File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    //get the path of the project resource folder
    public String getResourceFolderPath(String resourceFilename){
        String path;
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(resourceFilename);
        if(resource != null){
            path = resource.getPath();
            int endIndex = resource.getPath().indexOf("main") + 4;
            return path.substring(1, endIndex);
        }
        return "";
    }
}
