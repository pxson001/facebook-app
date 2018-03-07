package com.facebook.photos.upload.disk;

import android.content.Context;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: graph_search_v2_null_state_trending */
public class UploadTempFileManager {
    private static volatile UploadTempFileManager f13613g;
    private final Class<?> f13614a = getClass();
    private final Context f13615b;
    private final StatFsHelper f13616c;
    private final MoreFileUtils f13617d;
    private final Provider<TriState> f13618e;
    private boolean f13619f = false;

    public static com.facebook.photos.upload.disk.UploadTempFileManager m21320a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13613g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.disk.UploadTempFileManager.class;
        monitor-enter(r1);
        r0 = f13613g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21325b(r0);	 Catch:{ all -> 0x0035 }
        f13613g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13613g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.disk.UploadTempFileManager.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.disk.UploadTempFileManager");
    }

    private static UploadTempFileManager m21325b(InjectorLike injectorLike) {
        return new UploadTempFileManager((Context) injectorLike.getInstance(Context.class), StatFsHelperMethodAutoProvider.a(injectorLike), MoreFileUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 732));
    }

    @Inject
    protected UploadTempFileManager(Context context, StatFsHelper statFsHelper, MoreFileUtils moreFileUtils, Provider<TriState> provider) {
        this.f13615b = context;
        this.f13616c = statFsHelper;
        this.f13617d = moreFileUtils;
        this.f13618e = provider;
    }

    private File m21329c() {
        return this.f13615b.getDir("uploads", 0);
    }

    @Nullable
    private File m21323a(String str, boolean z) {
        if (this.f13619f) {
            return null;
        }
        File file = new File(m21329c(), str);
        if (!z) {
            return file;
        }
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }

    @Nullable
    public final File m21335a(String str, String str2) {
        return m21336a(str, str2, "tmp");
    }

    @Nullable
    public final File m21336a(String str, String str2, String str3) {
        String b = m21328b(str2);
        if (!((TriState) this.f13618e.get()).asBoolean(true)) {
            return null;
        }
        File a = m21323a(str, true);
        if (a == null) {
            return null;
        }
        return new File(a, StringFormatUtil.a("%s.%s", new Object[]{b, str3}));
    }

    private static String m21328b(String str) {
        return Integer.toHexString(str.hashCode()) + "-" + Long.toHexString(StringUtil.b(str));
    }

    @Nullable
    public final TempFiles m21332a(@Nullable File file, int i, String str) {
        return m21318a(file, true, i, str);
    }

    @Nullable
    private TempFiles m21318a(@Nullable File file, boolean z, int i, String str) {
        if (file == null || !m21324a(i)) {
            return null;
        }
        File file2 = new File(StringFormatUtil.a("%s.%s", new Object[]{file.getAbsolutePath(), str}));
        TempFiles tempFiles;
        try {
            tempFiles = file2.createNewFile() ? z ? new TempFiles(file, file2, true) : new TempFiles(file2, file, true) : null;
            return tempFiles == null ? tempFiles : tempFiles;
        } catch (IOException e) {
            tempFiles = e;
            file2.delete();
            return null;
        } finally {
            m21330d();
        }
    }

    @Nullable
    public final TempFiles m21331a(@Nullable File file, int i) {
        return m21332a(file, i, "scratch");
    }

    @Nullable
    public final TempFiles m21339b(File file, int i) {
        return m21318a(file, false, i, "tmp");
    }

    public final TempFiles m21333a(String str, int i, int i2) {
        return m21319a(str, i, i2, "tmp", "scratch");
    }

    private TempFiles m21319a(String str, int i, int i2, String str2, String str3) {
        File a = m21321a(i, i2);
        return new TempFiles(new File(a, StringFormatUtil.a("%s.%s", new Object[]{str, str2})), new File(a, StringFormatUtil.a("%s.%s.%s", new Object[]{str, str2, str3})), false);
    }

    public final TempFiles m21334a(String str, String str2, int i, int i2, String str3, String str4) {
        String b = m21328b(str2);
        File b2 = m21327b(str, i, i2);
        return new TempFiles(new File(b2, StringFormatUtil.a("%s.%s", new Object[]{b, str3})), new File(b2, StringFormatUtil.a("%s.%s.%s", new Object[]{b, str3, str4})), false);
    }

    private File m21327b(String str, int i, int i2) {
        return m21326b(m21321a(i, i2), str);
    }

    private boolean m21324a(int i) {
        this.f13616c.b();
        return !this.f13616c.a(StorageType.INTERNAL, (long) i);
    }

    public final void m21338a(String str) {
        File a = m21323a(str, false);
        if (a != null) {
            if (a.isDirectory()) {
                FileTree.a(a);
            }
            a.delete();
        }
        if (this.f13619f && m21329c().delete()) {
            this.f13619f = false;
        }
    }

    public final void m21337a() {
        File c = m21329c();
        FileTree.a(c);
        if (this.f13619f) {
            this.f13619f = false;
            c.delete();
        }
    }

    private void m21330d() {
        this.f13619f = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File m21321a(int r7, int r8) {
        /*
        r6 = this;
        r0 = r6.f13616c;
        r1 = com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL;
        r2 = r0.a(r1);
        r0 = (long) r7;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x001c;
    L_0x000d:
        r0 = r6.f13615b;
        r0 = r0.getCacheDir();
        r1 = "uploads";
        r0 = m21322a(r0, r1);
        if (r0 == 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        r0 = r6.f13616c;
        r1 = com.facebook.common.statfs.StatFsHelper.StorageType.EXTERNAL;
        r4 = r0.a(r1);
        r0 = (long) r7;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0032;
    L_0x0029:
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0040;
    L_0x002d:
        r0 = (long) r8;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x0040;
    L_0x0032:
        r0 = r6.f13615b;
        r0 = r0.getExternalCacheDir();
        r1 = "uploads";
        r0 = m21322a(r0, r1);
        if (r0 != 0) goto L_0x001b;
    L_0x0040:
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x0057;
    L_0x0044:
        r0 = (long) r8;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 < 0) goto L_0x0057;
    L_0x0049:
        r0 = r6.f13615b;
        r0 = r0.getCacheDir();
        r1 = "uploads";
        r0 = m21322a(r0, r1);
        if (r0 != 0) goto L_0x001b;
    L_0x0057:
        r0 = new com.facebook.photos.upload.disk.NoDiskSpaceException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.disk.UploadTempFileManager.a(int, int):java.io.File");
    }

    private static File m21322a(File file, String str) {
        File file2 = new File(file, str);
        return (file2.isDirectory() || file2.mkdir()) ? file2 : null;
    }

    public final void m21340b() {
        m21326b(this.f13615b.getCacheDir(), "uploads");
        m21326b(this.f13615b.getExternalCacheDir(), "uploads");
    }

    private File m21326b(File file, String str) {
        File file2 = new File(file, str);
        if (file2.isDirectory()) {
            FileTree.a(file2);
        }
        file2.delete();
        file2.mkdir();
        return file2;
    }
}
