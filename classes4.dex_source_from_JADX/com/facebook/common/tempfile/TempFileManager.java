package com.facebook.common.tempfile;

import android.content.Context;
import android.os.Environment;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.delayedworker.DelayedWorkerManager;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mLastRefreshTimestamp */
public class TempFileManager {
    private static final Class<?> f8655a = TempFileManager.class;
    private static volatile TempFileManager f8656g;
    private final DelayedWorkerManager f8657b;
    private final TempFileDirectoryManager f8658c;
    private final TempFileDirectoryManager f8659d;
    private final TempFileDirectoryManager f8660e;
    private final TempFileDirectoryManager f8661f = new TempFileDirectoryManager(new File(Environment.getExternalStorageDirectory(), "orcatemp"));

    public static com.facebook.common.tempfile.TempFileManager m8903a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8656g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.tempfile.TempFileManager.class;
        monitor-enter(r1);
        r0 = f8656g;	 Catch:{ all -> 0x003a }
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
        r0 = m8904b(r0);	 Catch:{ all -> 0x0035 }
        f8656g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8656g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.tempfile.TempFileManager.a(com.facebook.inject.InjectorLike):com.facebook.common.tempfile.TempFileManager");
    }

    private static TempFileManager m8904b(InjectorLike injectorLike) {
        return new TempFileManager((Context) injectorLike.getInstance(Context.class), DelayedWorkerManager.m8911a(injectorLike), String_PackageNameMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TempFileManager(Context context, DelayedWorkerManager delayedWorkerManager, String str) {
        this.f8658c = new TempFileDirectoryManager(new File(context.getCacheDir(), "fb_temp"));
        this.f8659d = new TempFileDirectoryManager(new File(new File(Environment.getExternalStorageDirectory(), str), "fb_temp"));
        this.f8660e = new TempFileDirectoryManager(new File(context.getCacheDir(), "orcatemp"));
        this.f8657b = delayedWorkerManager;
    }

    public final File m8907a(String str, String str2, Privacy privacy) {
        m8906d();
        return m8902a(privacy).m8921a(str, str2);
    }

    @Deprecated
    public final File m8908a(String str, String str2, boolean z) {
        return m8907a(str, str2, z ? Privacy.REQUIRE_PRIVATE : Privacy.PREFER_SDCARD);
    }

    private TempFileDirectoryManager m8902a(Privacy privacy) {
        if (privacy == Privacy.REQUIRE_PRIVATE) {
            return this.f8658c;
        }
        if (privacy == Privacy.REQUIRE_SDCARD) {
            return this.f8659d;
        }
        if (privacy != Privacy.PREFER_SDCARD) {
            throw new IllegalArgumentException();
        } else if (m8905c()) {
            return this.f8659d;
        } else {
            return this.f8658c;
        }
    }

    public final void m8909a() {
        if (((((this.f8659d.m8922a(86400000) | 0) | this.f8658c.m8922a(86400000)) | this.f8660e.m8922a(86400000)) | this.f8661f.m8922a(86400000)) != 0) {
            m8906d();
        }
    }

    @VisibleForTesting
    private static boolean m8905c() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private void m8906d() {
        this.f8657b.m8917a(TempFileDelayedWorker.class, TimeUnit.SECONDS.convert(86400000, TimeUnit.MILLISECONDS));
    }
}
