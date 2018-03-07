package com.facebook.bitmaps;

import android.util.Base64;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.NativeLibrary;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: overly large log entry skipped */
public class NativeImageLibraries extends NativeLibrary {
    private static String f10658a = NativeImageLibraries.class.getName();
    private static volatile NativeImageLibraries f10659c;
    private AbstractFbErrorReporter f10660b;

    public static com.facebook.bitmaps.NativeImageLibraries m15933a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10659c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bitmaps.NativeImageLibraries.class;
        monitor-enter(r1);
        r0 = f10659c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m15934b(r0);	 Catch:{ all -> 0x0035 }
        f10659c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10659c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bitmaps.NativeImageLibraries.a(com.facebook.inject.InjectorLike):com.facebook.bitmaps.NativeImageLibraries");
    }

    @DoNotStrip
    private native int nativeCheck();

    @DoNotStrip
    native byte[] extractXmpMetadata(InputStream inputStream);

    @DoNotStrip
    public native void transcode2Jpeg(InputStream inputStream, OutputStream outputStream, int i);

    @DoNotStrip
    public native void transcode2Png(InputStream inputStream, OutputStream outputStream);

    private static NativeImageLibraries m15934b(InjectorLike injectorLike) {
        return new NativeImageLibraries(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public NativeImageLibraries(@Nullable AbstractFbErrorReporter abstractFbErrorReporter) {
        super(ImmutableList.of("fb_imgproc"));
        this.f10660b = abstractFbErrorReporter;
    }

    protected final void m15936c() {
        nativeCheck();
        try {
            m15935d();
        } catch (Throwable e) {
            if (this.f10660b != null) {
                this.f10660b.m2343a(f10658a, "LIBRARY_HALF_LOADED - Native didn't load all methods", e);
            }
            throw e;
        }
    }

    private void m15935d() {
        try {
            transcode2Jpeg(new ByteArrayInputStream(Base64.decode("UklGRiIAAABXRUJQVlA4IBYAAAAwAQCdASoBAAEADsD+JaQAA3AAAAAA", 0)), ByteStreams.a(), 80);
        } catch (Throwable e) {
            if (this.f10660b != null) {
                this.f10660b.m2343a(f10658a, "IOException thrown while testing if library is loaded", e);
            } else {
                BLog.b(f10658a, "IOException thrown while testing if library is loaded", e);
            }
        }
    }
}
