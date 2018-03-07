package com.facebook.common.tempfile;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: should_upsell_as_viewer_profile_picture */
class TempFileDirectoryManager$TempFileFilter implements FilenameFilter {
    TempFileDirectoryManager$TempFileFilter() {
    }

    public boolean accept(File file, String str) {
        return !".nomedia".equals(str);
    }
}
