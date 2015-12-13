package org.trlove.common.test.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class ImageUtil {

    public static InputStream resizeImg(int height, int width, InputStream origin) {
        if(null != origin) {
            try {
                Image originImg = ImageIO.read(origin);
            }catch(Exception e) {

            }
        }
        return null;
    }

}
