package com.facebook.bootstrapcache.core;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.logging.FLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sync_user_experiments */
public class BootstrapCache implements DiskTrimmable {
    private static final String f1397a = BootstrapCache.class.getName();
    private final Provider<String> f1398b;
    public final Context f1399c;
    private final BootstrapCacheUserDataFinder f1400d;
    private final ExecutorService f1401e;

    public static BootstrapCache m1634b(InjectorLike injectorLike) {
        return new BootstrapCache(IdBasedProvider.a(injectorLike, 4443), (Context) injectorLike.getInstance(Context.class), DiskCacheManager.a(injectorLike), new BootstrapCacheUserDataFinder((Context) injectorLike.getInstance(Context.class)), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BootstrapCache(Provider<String> provider, Context context, DiskCacheManager diskCacheManager, BootstrapCacheUserDataFinder bootstrapCacheUserDataFinder, ExecutorService executorService) {
        this.f1398b = provider;
        this.f1399c = context;
        this.f1400d = bootstrapCacheUserDataFinder;
        this.f1401e = executorService;
        diskCacheManager.a(this);
    }

    public final void m1642b() {
        TracerDetour.a("BootstrapCache.trimToNothing", 1271518149);
        try {
            BootstrapCacheFileUtils.a(this.f1401e, m1636e());
        } finally {
            TracerDetour.a(1167519731);
        }
    }

    public final void ai_() {
        m1642b();
    }

    public final void m1641a(String str) {
        TracerDetour.a("BootstrapCache.purgeRecentlyUsedFiles", 1437792290);
        try {
            m1638g();
            BootstrapCacheFileUtils.a(this.f1401e, m1635b(str));
        } finally {
            TracerDetour.a(-1364738437);
        }
    }

    public final void m1643c() {
        TracerDetour.a("BootstrapCache.persistRecentlyUsedFiles", 1367017890);
        try {
            m1638g();
            m1637f();
            File i = m1640i();
            if (i != null) {
                URI toURI = i.toURI();
                URI h = m1639h();
                int i2 = 0;
                for (File file : this.f1400d.m1645a()) {
                    try {
                        File parentFile = new File(toURI.resolve(h.relativize(file.toURI()))).getParentFile();
                        if (parentFile.exists() || parentFile.mkdirs()) {
                            BootstrapCacheFileUtils.a(file, parentFile);
                            int length = (int) (file.length() + ((long) i2));
                            if (length > 33554432) {
                                break;
                            }
                            i2 = length;
                        }
                    } catch (Throwable e) {
                        FLog.a(f1397a, e, "Exception copying into bootstrap cache", new Object[0]);
                    }
                }
                TracerDetour.a(2063059337);
            }
        } finally {
            TracerDetour.a(2077212678);
        }
    }

    public final void m1644d() {
        TracerDetour.a("BootstrapCache.restoreRecentlyUsedFiles", -1597825492);
        try {
            File b = m1635b((String) this.f1398b.get());
            if (b != null) {
                File file = new File(m1639h());
                for (File a : b.listFiles()) {
                    BootstrapCacheFileUtils.a(this.f1401e, a, file);
                }
                BootstrapCacheFileUtils.a(this.f1401e, b);
                TracerDetour.a(1970816610);
            }
        } finally {
            TracerDetour.a(-1465716589);
        }
    }

    @VisibleForTesting
    private File m1636e() {
        return this.f1399c.getDir("bootstrap", 0);
    }

    private void m1637f() {
        int i = 0;
        File e = m1636e();
        if (e.exists()) {
            File[] listFiles = e.listFiles();
            if (listFiles != null) {
                if (r5 != 0) {
                    long j = Long.MIN_VALUE;
                    for (File file : listFiles) {
                        if (file.lastModified() > j) {
                            j = file.lastModified();
                        }
                    }
                    while (i < r5) {
                        File file2 = listFiles[i];
                        long lastModified = file2.lastModified();
                        if (lastModified == 0 || lastModified < j) {
                            BootstrapCacheFileUtils.a(this.f1401e, file2);
                        }
                        i++;
                    }
                }
            }
        }
    }

    private void m1638g() {
        BootstrapCacheFileUtils.a(this.f1401e, new File(this.f1399c.getCacheDir(), "bootstrap"));
        File e = m1636e();
        if (e.exists()) {
            File[] listFiles = e.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    Object obj;
                    if (file == null || !file.isDirectory()) {
                        obj = null;
                    } else {
                        String name = file.getName();
                        int length = name.length();
                        int i = 0;
                        for (int i2 = 0; i2 < length; i2++) {
                            char charAt = name.charAt(i2);
                            if (charAt == '.') {
                                i++;
                            } else if (charAt < '0' || charAt > '9') {
                                obj = null;
                                break;
                            }
                        }
                        obj = i == 4 ? 1 : null;
                    }
                    if (obj != null) {
                        BootstrapCacheFileUtils.a(this.f1401e, file);
                    }
                }
            }
        }
    }

    private URI m1639h() {
        return new File(this.f1399c.getApplicationInfo().dataDir).toURI();
    }

    @Nullable
    private File m1635b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File e = m1636e();
        if (!e.exists()) {
            return null;
        }
        e = m1633a(e, str);
        if (e.exists()) {
            return e;
        }
        return null;
    }

    @Nullable
    private File m1640i() {
        String str = (String) this.f1398b.get();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File e = m1636e();
        if (!e.exists() && !e.mkdir()) {
            return null;
        }
        File a = m1633a(e, str);
        if (a.exists() || a.mkdir()) {
            return a;
        }
        return null;
    }

    private static File m1633a(File file, String str) {
        return new File(file, str);
    }
}
