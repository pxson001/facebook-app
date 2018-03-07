package com.facebook.video.server.cache;

import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.file.FileUtils;
import com.google.common.primitives.Longs;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.maps.MapActivity */
public class PlayerReadableCache implements DiskTrimmable {
    private static final Comparator<File> f19577c = new C14601();
    private final File f19578a;
    private final int f19579b;

    /* compiled from: com.google.android.maps.MapActivity */
    final class C14601 implements Comparator<File> {
        C14601() {
        }

        public final int compare(Object obj, Object obj2) {
            return Longs.a(((File) obj).lastModified(), ((File) obj2).lastModified());
        }
    }

    public PlayerReadableCache(File file, int i) {
        this.f19578a = file;
        this.f19579b = i;
    }

    public final File m28285a(String str) {
        FileUtils.a(this.f19578a);
        return new File(this.f19578a, str);
    }

    private void m28284a(int i) {
        File[] listFiles = this.f19578a.listFiles();
        if (listFiles != null) {
            List asList = Arrays.asList(listFiles);
            if (asList.size() > i) {
                Collections.sort(asList, f19577c);
                for (File delete : asList.subList(0, asList.size() - i)) {
                    delete.delete();
                }
            }
        }
    }

    public final void ai_() {
        m28284a(this.f19579b);
    }

    public final void m28286b() {
        m28284a(0);
    }
}
