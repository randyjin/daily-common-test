import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Sets;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * InvoiceFileRename
 *
 * @author 奕超
 */
public class InvoiceFileRename {

    public static void main(String[] args) {
        renameFile("/Users/aguda/Desktop/online-invoice/7-7");
//        getFileExt("/Users/aguda/Desktop/online-invoice/7-1");
    }

    private static void getFileExt(String path) {
        boolean isDirectory = FileUtil.isDirectory(path);
        if(!isDirectory) {
            System.out.println(path + "不是个目录");
            return;
        }
        List<File> fileList = FileUtil.loopFiles(path);
        Set<String> extName = Sets.newHashSet();
        for (File file : fileList) {
            extName.add(FileUtil.extName(file));
        }
        System.out.println(extName);
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
