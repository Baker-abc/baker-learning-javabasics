package com.baker.learning.javabasics.tool;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.jhlabs.image.PerspectiveFilter;

/**
 * @author ylp
 * @Description   图片操作---透视
 * @date 2020/7/9 10:27 上午
 * @see
 */
public class RemoteImage {

    public static void main(String[] args) throws IOException {
        File[] files = new File("/Users/ylp/Downloads/透视/").listFiles();
        for (File file : files) {
            InputStream is = null;
            BufferedImage dst = null;
            try {
                //File file = new File("/Users/yanglepeng/Downloads/IMG_6A45E17D6F69-1.jpeg");
                is = new FileInputStream(file);
                // 如果是MultipartFile类型，那么自身也有转换成流的方法：is = file.getInputStream();
                BufferedImage bi = ImageIO.read(is);


                PerspectiveFilter perspectiveFilter = new PerspectiveFilter(0, 0.2f, 1, 0.2f, 1f, 0.8f, 0, 0.8f);
                //PerspectiveFilter perspectiveFilter = new PerspectiveFilter();
                perspectiveFilter.setClip(true);
                //perspectiveFilter.setInterpolation(2);
                //perspectiveFilter.setEdgeAction();

                dst = perspectiveFilter.filter(bi,dst);

                String newPath = file.getName().split("\\.")[0] + "_new_." + file.getName().split("\\.")[1];
                ImageIO.write(dst, "png", new File("/Users/ylp/Downloads/透视/" + newPath));// 直接输出文件
            }finally {
                if (is != null) {
                    is.close();
                }
            }

        }


    }
}
