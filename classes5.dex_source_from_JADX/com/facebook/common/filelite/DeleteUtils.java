package com.facebook.common.filelite;

import java.io.File;

/* compiled from: sports_match_data */
public class DeleteUtils {
    public static boolean m3693a(File file) {
        if (file.isDirectory()) {
            int i = 0;
            int i2;
            if (file.isDirectory()) {
                i2 = 1;
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    while (i < listFiles.length) {
                        i2 &= m3693a(listFiles[i]);
                        i++;
                    }
                }
            } else {
                i2 = 0;
            }
        }
        return file.delete();
    }
}
