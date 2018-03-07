package com.facebook.cache.disk;

import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.File;

@VisibleForTesting
/* compiled from: android.intent.extra.EMAIL */
public class DefaultDiskStorage$EntryImpl {
    private final String f10769a;
    public final FileBinaryResource f10770b;
    private long f10771c = -1;
    private long f10772d = -1;

    public DefaultDiskStorage$EntryImpl(String str, File file) {
        Preconditions.a(file);
        this.f10769a = (String) Preconditions.a(str);
        this.f10770b = FileBinaryResource.a(file);
    }

    public final String m18795a() {
        return this.f10769a;
    }

    public final long m18796b() {
        if (this.f10772d < 0) {
            this.f10772d = this.f10770b.a.lastModified();
        }
        return this.f10772d;
    }

    public final long m18797d() {
        if (this.f10771c < 0) {
            this.f10771c = this.f10770b.c();
        }
        return this.f10771c;
    }
}
