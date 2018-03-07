package com.facebook.appupdate;

import android.content.Context;
import com.facebook.debug.log.BLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: rangeRequestForVideo */
public class AppUpdateFilesManager {
    private static final Class<?> f8291a = AppUpdateFilesManager.class;
    private final Context f8292b;

    public AppUpdateFilesManager(Context context) {
        this.f8292b = context;
    }

    public final File m12813a(long j) {
        return new File(m12812a(), "temp_" + j + ".apk");
    }

    public final void m12814a(Collection<File> collection) {
        Set hashSet = new HashSet();
        for (File canonicalFile : collection) {
            hashSet.add(canonicalFile.getCanonicalFile());
        }
        File canonicalFile2 = m12812a();
        if (canonicalFile2.exists()) {
            Preconditions.m12787a(canonicalFile2.isDirectory());
            File[] listFiles = canonicalFile2.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    Object obj = null;
                    try {
                        obj = file.getCanonicalFile();
                    } catch (IOException e) {
                        BLog.b(f8291a, "Could not get canonical file for %s, skipping.", new Object[]{file});
                    }
                    if (!(obj == null || hashSet.contains(obj))) {
                        file.delete();
                    }
                }
            }
        }
    }

    private File m12812a() {
        return this.f8292b.getDir("appupdate", 0);
    }
}
