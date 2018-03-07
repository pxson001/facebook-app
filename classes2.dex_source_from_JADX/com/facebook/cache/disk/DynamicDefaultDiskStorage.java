package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.disk.DefaultDiskStorage.EntryImpl;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: optin */
public class DynamicDefaultDiskStorage implements DiskStorage {
    private static final Class<?> f10919b = DynamicDefaultDiskStorage.class;
    @VisibleForTesting
    volatile State f10920a = new State(null, null);
    private final int f10921c;
    private final Supplier<File> f10922d;
    private final String f10923e;
    private final CacheErrorLogger f10924f;

    @VisibleForTesting
    /* compiled from: optin */
    class State {
        @Nullable
        public final DiskStorage f10925a;
        @Nullable
        public final File f10926b;

        @VisibleForTesting
        State(@Nullable File file, @Nullable DiskStorage diskStorage) {
            this.f10925a = diskStorage;
            this.f10926b = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.f10921c = i;
        this.f10924f = cacheErrorLogger;
        this.f10922d = supplier;
        this.f10923e = str;
    }

    public final BinaryResource mo2080b(String str, Object obj) {
        return m16189d().mo2080b(str, obj);
    }

    public final boolean mo2083c(String str, Object obj) {
        return m16189d().mo2083c(str, obj);
    }

    public final boolean mo2084d(String str, Object obj) {
        return m16189d().mo2084d(str, obj);
    }

    public final void mo2079a() {
        try {
            m16189d().mo2079a();
        } catch (Throwable e) {
            FLog.a(f10919b, "purgeUnexpectedResources", e);
        }
    }

    public final Inserter mo2078a(String str, Object obj) {
        return m16189d().mo2078a(str, obj);
    }

    public final Collection<Entry> mo2082c() {
        return m16189d().mo2082c();
    }

    public final long mo2077a(EntryImpl entryImpl) {
        return m16189d().mo2077a(entryImpl);
    }

    public final void mo2081b() {
        m16189d().mo2081b();
    }

    @VisibleForTesting
    private synchronized DiskStorage m16189d() {
        if (m16190e()) {
            m16191f();
            m16192g();
        }
        return (DiskStorage) Preconditions.a(this.f10920a.f10925a);
    }

    private boolean m16190e() {
        State state = this.f10920a;
        return state.f10925a == null || state.f10926b == null || !state.f10926b.exists();
    }

    @VisibleForTesting
    private void m16191f() {
        if (this.f10920a.f10925a != null && this.f10920a.f10926b != null) {
            FileTree.b(this.f10920a.f10926b);
        }
    }

    private void m16192g() {
        File file = new File((File) this.f10922d.mo2058a(), this.f10923e);
        m16188a(file);
        this.f10920a = new State(file, new DefaultDiskStorage(file, this.f10921c, this.f10924f));
    }

    @VisibleForTesting
    private void m16188a(File file) {
        try {
            FileUtils.a(file);
            file.getAbsolutePath();
        } catch (CreateDirectoryException e) {
            this.f10924f.mo2056a(CacheErrorCategory.WRITE_CREATE_DIR, f10919b, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
