package org.trlove.common.test.util.file;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by aguda on 16/6/3.
 */
public class FileUtil {

    public static void createFile(String path) throws IOException {
        if(StringUtils.isBlank(path)) {
            return;
        }
        File file = new File(path);
        file.mkdirs();
        file.createNewFile();
        System.out.println(file.getParent());
    }
}
