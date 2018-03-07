package com.facebook.bitmaps;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: android.support.content.wakelockid */
public class WebpTranscoder {
    private static volatile WebpTranscoder f10397c;
    public final NativeImageLibraries f10398a;
    public final boolean f10399b = this.f10398a.ah_();

    /* compiled from: android.support.content.wakelockid */
    public /* synthetic */ class C10001 {
        public static final /* synthetic */ int[] f10396a = new int[ImageFormat.values().length];

        static {
            try {
                f10396a[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10396a[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10396a[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10396a[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static com.facebook.bitmaps.WebpTranscoder m18492a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10397c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bitmaps.WebpTranscoder.class;
        monitor-enter(r1);
        r0 = f10397c;	 Catch:{ all -> 0x003a }
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
        r0 = m18493b(r0);	 Catch:{ all -> 0x0035 }
        f10397c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10397c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bitmaps.WebpTranscoder.a(com.facebook.inject.InjectorLike):com.facebook.bitmaps.WebpTranscoder");
    }

    private static WebpTranscoder m18493b(InjectorLike injectorLike) {
        return new WebpTranscoder(NativeImageLibraries.a(injectorLike));
    }

    @Inject
    public WebpTranscoder(NativeImageLibraries nativeImageLibraries) {
        this.f10398a = nativeImageLibraries;
    }

    public final void m18494a(InputStream inputStream, OutputStream outputStream, int i) {
        ImageFormat a = ImageFormatChecker.a(inputStream);
        if (a.equals(ImageFormat.WEBP_LOSSLESS) || a.equals(ImageFormat.WEBP_EXTENDED_WITH_ALPHA)) {
            Preconditions.checkState(this.f10399b, "Transcode to Png invoked when isAvailable() returns false");
            Preconditions.checkNotNull(inputStream);
            Preconditions.checkNotNull(outputStream);
            this.f10398a.transcode2Png(inputStream, outputStream);
            return;
        }
        Preconditions.checkState(this.f10399b, "Transcode to Jpeg invoked when isAvailable() returns false");
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        this.f10398a.transcode2Jpeg(inputStream, outputStream, i);
    }
}
