package com.facebook.bootstrapcache.core;

import android.content.Context;
import com.facebook.common.file.FileTree;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: sync_token */
public class BootstrapCacheUserDataFinder {
    static final Set<String> f1402a = ImmutableSet.of("graphql_cache", "graphql_cache-journal", "newsfeed_db", "newsfeed_db-journal");
    public final Context f1403b;

    @Inject
    public BootstrapCacheUserDataFinder(Context context) {
        this.f1403b = context;
    }

    public final List<File> m1645a() {
        List<File> arrayList = new ArrayList(100);
        FolderFlattenerVisitor folderFlattenerVisitor = new FolderFlattenerVisitor(arrayList);
        FileTree.m3116a(this.f1403b.getFilesDir(), folderFlattenerVisitor);
        for (File a : this.f1403b.getCacheDir().listFiles()) {
            FileTree.m3116a(a, folderFlattenerVisitor);
        }
        for (File file : new File(this.f1403b.getFilesDir().getParentFile(), "databases").listFiles()) {
            if (f1402a.contains(file.getName())) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new LastModifiedComparator());
        return arrayList;
    }
}
