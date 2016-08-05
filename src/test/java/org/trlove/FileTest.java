package org.trlove;

import org.junit.Assert;
import org.junit.Test;
import org.trlove.common.test.util.file.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by aguda on 16/6/3.
 */
public class FileTest {

    @Test
    public void testCreateFile() throws IOException {
        String path = "/Users/aguda/workspace/temp/a.txt";
        FileUtil.createFile(path);
        File file = new File(path);
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
