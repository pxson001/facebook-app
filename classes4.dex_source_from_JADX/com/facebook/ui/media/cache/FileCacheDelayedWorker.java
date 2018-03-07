package com.facebook.ui.media.cache;

import android.content.Context;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.cache.disk.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.common.time.TimeConversions;
import com.facebook.delayedworker.AbstractDelayedWorker;
import com.facebook.inject.FbInjector;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;

/* compiled from: folder_photo_count */
public class FileCacheDelayedWorker extends AbstractDelayedWorker {
    public Set<FileCache> f11494a;
    public FileCacheDelayedWorkerScheduler f11495b;

    public static void m11978a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FileCacheDelayedWorker fileCacheDelayedWorker = (FileCacheDelayedWorker) obj;
        Set multiBinderSet = new MultiBinderSet(fbInjector.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER.FileCache(fbInjector));
        FileCacheDelayedWorkerScheduler a = FileCacheDelayedWorkerScheduler.m9794a(fbInjector);
        fileCacheDelayedWorker.f11494a = multiBinderSet;
        fileCacheDelayedWorker.f11495b = a;
    }

    public final void mo851a() {
        Class cls = FileCacheDelayedWorker.class;
        m11978a(this, getContext());
    }

    public final void mo852b() {
        long j;
        if (this.f11494a != null) {
            j = 0;
            for (DiskStorageCache a : this.f11494a) {
                j = Math.max(a.a(5184000000L), j);
            }
        } else {
            j = 0;
        }
        FileCacheDelayedWorkerScheduler fileCacheDelayedWorkerScheduler = this.f11495b;
        if (j > 0) {
            fileCacheDelayedWorkerScheduler.f9409a.m8917a(FileCacheDelayedWorker.class, 86400 + TimeConversions.m(5184000000L - j));
        } else {
            fileCacheDelayedWorkerScheduler.f9409a.m8917a(FileCacheDelayedWorker.class, TimeConversions.m(5184000000L));
        }
    }
}
