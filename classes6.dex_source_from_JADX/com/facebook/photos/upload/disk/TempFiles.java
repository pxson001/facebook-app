package com.facebook.photos.upload.disk;

import java.io.File;
import javax.annotation.Nullable;

/* compiled from: graph_search_v2_pull_to_refresh */
public class TempFiles {
    public final File f13610a;
    public final File f13611b;
    private boolean f13612c;

    public TempFiles(File file, @Nullable File file2, boolean z) {
        this.f13610a = file;
        this.f13611b = file2;
        this.f13612c = z;
    }

    public final void m21314a() {
        if (this.f13611b != null) {
            this.f13611b.delete();
        }
        if (!this.f13612c && this.f13610a != null) {
            this.f13610a.delete();
        }
    }

    public final File m21316b() {
        return this.f13610a;
    }

    public final File m21317c() {
        return this.f13611b;
    }

    public final void m21315a(boolean z) {
        this.f13612c = z;
    }
}
