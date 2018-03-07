package com.facebook.bootstrapcache.core;

import com.facebook.common.file.FileTreeVisitor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: reason_phrase */
class BootstrapCacheUserDataFinder$FolderFlattenerVisitor implements FileTreeVisitor {
    private List<File> f5752a;

    BootstrapCacheUserDataFinder$FolderFlattenerVisitor(ArrayList arrayList) {
        this.f5752a = arrayList;
    }

    public final void m5977b(File file) {
        this.f5752a.add(file);
    }

    public final void m5976a(File file) {
    }

    public final void m5978c(File file) {
    }
}
