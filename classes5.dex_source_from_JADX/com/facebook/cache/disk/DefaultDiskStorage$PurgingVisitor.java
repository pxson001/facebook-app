package com.facebook.cache.disk;

import com.facebook.cache.disk.DefaultDiskStorage.FileInfo;
import com.facebook.cache.disk.DefaultDiskStorage.FileType;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.internal.Preconditions;
import java.io.File;

/* compiled from: android.intent.extra.EMAIL */
public class DefaultDiskStorage$PurgingVisitor implements FileTreeVisitor {
    public final /* synthetic */ DefaultDiskStorage f10773a;
    private boolean f10774b;

    public DefaultDiskStorage$PurgingVisitor(DefaultDiskStorage defaultDiskStorage) {
        this.f10773a = defaultDiskStorage;
    }

    public final void m18798a(File file) {
        if (!this.f10774b && file.equals(this.f10773a.d)) {
            this.f10774b = true;
        }
    }

    public final void m18799b(File file) {
        if (this.f10774b) {
            boolean z = false;
            FileInfo b = DefaultDiskStorage.b(this.f10773a, file);
            if (b != null) {
                if (b.a == FileType.TEMP) {
                    boolean z2;
                    if (file.lastModified() > this.f10773a.f.a() - DefaultDiskStorage.a) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z = z2;
                } else {
                    if (b.a == FileType.CONTENT) {
                        z = true;
                    }
                    Preconditions.b(z);
                    z = true;
                }
            }
            if (z) {
                return;
            }
        }
        file.delete();
    }

    public final void m18800c(File file) {
        if (!(this.f10773a.c.equals(file) || this.f10774b)) {
            file.delete();
        }
        if (this.f10774b && file.equals(this.f10773a.d)) {
            this.f10774b = false;
        }
    }
}
