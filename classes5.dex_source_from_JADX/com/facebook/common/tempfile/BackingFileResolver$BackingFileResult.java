package com.facebook.common.tempfile;

import java.io.File;

/* compiled from: showSoftInputUnchecked */
public class BackingFileResolver$BackingFileResult {
    public final File f2732a;
    public final boolean f2733b;

    public BackingFileResolver$BackingFileResult(File file, boolean z) {
        this.f2732a = file;
        this.f2733b = z;
    }

    public final void m3845a() {
        if (this.f2733b) {
            this.f2732a.delete();
        }
    }
}
