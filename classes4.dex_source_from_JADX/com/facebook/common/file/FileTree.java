package com.facebook.common.file;

import java.io.File;

/* compiled from: send_anr_traces_async */
public class FileTree {
    public static void m3116a(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.mo260a(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m3116a(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.mo261b(file2);
                }
            }
        }
        fileTreeVisitor.mo262c(file);
    }

    public static boolean m3117a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            int i = 0;
            while (i < listFiles.length) {
                boolean b = m3118b(listFiles[i]) & z;
                i++;
                z = b;
            }
        }
        return z;
    }

    public static boolean m3118b(File file) {
        if (file.isDirectory()) {
            m3117a(file);
        }
        return file.delete();
    }
}
