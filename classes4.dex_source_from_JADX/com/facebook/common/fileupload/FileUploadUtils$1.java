package com.facebook.common.fileupload;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: is_non_authoritative */
public class FileUploadUtils$1 implements FilenameFilter {
    final /* synthetic */ Pattern f9940a;
    final /* synthetic */ FileUploadUtils f9941b;

    public FileUploadUtils$1(FileUploadUtils fileUploadUtils, Pattern pattern) {
        this.f9941b = fileUploadUtils;
        this.f9940a = pattern;
    }

    public boolean accept(File file, String str) {
        return this.f9940a.matcher(str).matches();
    }
}
