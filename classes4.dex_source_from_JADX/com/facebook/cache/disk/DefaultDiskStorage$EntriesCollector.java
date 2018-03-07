package com.facebook.cache.disk;

import com.facebook.cache.disk.DefaultDiskStorage.EntryImpl;
import com.facebook.cache.disk.DefaultDiskStorage.FileInfo;
import com.facebook.cache.disk.DefaultDiskStorage.FileType;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.common.file.FileTreeVisitor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: seekTo */
public class DefaultDiskStorage$EntriesCollector implements FileTreeVisitor {
    final /* synthetic */ DefaultDiskStorage f2922a;
    public final List<Entry> f2923b = new ArrayList();

    public DefaultDiskStorage$EntriesCollector(DefaultDiskStorage defaultDiskStorage) {
        this.f2922a = defaultDiskStorage;
    }

    public final void mo260a(File file) {
    }

    public final void mo261b(File file) {
        FileInfo b = DefaultDiskStorage.b(this.f2922a, file);
        if (b != null && b.a == FileType.CONTENT) {
            this.f2923b.add(new EntryImpl(b.b, file));
        }
    }

    public final void mo262c(File file) {
    }
}
