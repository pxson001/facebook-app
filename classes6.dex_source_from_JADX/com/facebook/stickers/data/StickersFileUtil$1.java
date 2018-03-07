package com.facebook.stickers.data;

import java.io.File;
import java.io.FileFilter;

/* compiled from: emailAddress */
public class StickersFileUtil$1 implements FileFilter {
    final /* synthetic */ StickersFileUtil f16493a;

    public StickersFileUtil$1(StickersFileUtil stickersFileUtil) {
        this.f16493a = stickersFileUtil;
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
