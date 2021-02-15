import java.io.File;

public class FileUtils {
    public static long calculateFolderSize(String path) {
        File source = new File(path);
        long filesSize = 0L;
        try {
            if (source.isDirectory()){
                File[] newFile = source.listFiles();
                for (File file : newFile){
                    filesSize += calculateFolderSize(file.getAbsolutePath());
                }
            }
            else filesSize = source.length();
        } catch (NullPointerException ex){
            ex.getStackTrace();
        }
        return filesSize;
    }
}
