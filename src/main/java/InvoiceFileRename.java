import cn.hutool.core.io.FileUtil;
import java.io.File;
import java.util.List;

/**
 * InvoiceFileRename
 *
 * @author 奕超
 */
public class InvoiceFileRename {

    public static void main(String[] args) {
        renameFile("/Users/aguda/Desktop/发票/test");
    }

    private static void renameFile(String path) {
        boolean isDirectory = FileUtil.isDirectory(path);
        if(!isDirectory) {
            System.out.println(path + "不是个目录");
            return;
        }
        List<File> fileList = FileUtil.loopFiles(path);
        int index = 1;
        for (File file : fileList) {
            System.out.println(file.getName() + "-->" + index);
            FileUtil.rename(file, String.valueOf(index), true, false);
            index++;
        }
    }
}
