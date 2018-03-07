package com.facebook.photos.imageprocessing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.ImageDecodeExecutorService;
import com.facebook.common.executors.ImageTransformExecutorService;
import com.facebook.common.executors.ListeningExecutorService_ImageDecodeExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ImageTransformExecutorServiceMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.creativeediting.model.CreativeEditingUploadParams;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: heightPercentage */
public class FiltersEngine {
    private static final String f13030a = FiltersEngine.class.getSimpleName();
    private static final String f13031b = (f13030a + "-Init");
    private static final String f13032c = (f13030a + "-InitAndApply");
    private static final String f13033d = (f13030a + "-ApplyToFile");
    private static final RectF f13034e = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public static boolean f13035j;
    private static Throwable f13036k;
    private static Lazy<FbErrorReporter> f13037n;
    private static volatile FiltersEngine f13038o;
    @ImageTransformExecutorService
    private final ListeningExecutorService f13039f;
    @ImageDecodeExecutorService
    private final ListeningExecutorService f13040g;
    private final ImageDupeDetector f13041h;
    private final AtomicInteger f13042i = new AtomicInteger(0);
    private final BitmapUtils f13043l;
    @Nullable
    private final PerformanceLogger f13044m;

    @NotThreadSafe
    /* compiled from: heightPercentage */
    public class Session implements Closeable {
        private long f13027a = 0;
        private FiltersEngine f13028b;
        private boolean f13029c = false;

        public Session(FiltersEngine filtersEngine, Bitmap bitmap) {
            this.f13028b = filtersEngine;
            this.f13027a = FiltersEngine.init(bitmap);
        }

        public final synchronized void m20372a(RectF[] rectFArr) {
            if (this.f13027a != 0) {
                FiltersEngine.preprocess(rectFArr, this.f13027a);
                this.f13029c = true;
            }
        }

        public final synchronized boolean m20373a(Bitmap bitmap, String str) {
            boolean z;
            if (this.f13027a == 0 || !this.f13029c) {
                z = false;
            } else {
                FiltersEngine.m20377a(this.f13027a, Filter.getValue(str).name(), bitmap);
                z = true;
            }
            return z;
        }

        public void close() {
            if (this.f13027a != 0) {
                FiltersEngine.releaseSession(this.f13027a);
                this.f13027a = 0;
            }
        }
    }

    public static com.facebook.photos.imageprocessing.FiltersEngine m20374a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13038o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.imageprocessing.FiltersEngine.class;
        monitor-enter(r1);
        r0 = f13038o;	 Catch:{ all -> 0x003a }
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
        r0 = m20384b(r0);	 Catch:{ all -> 0x0035 }
        f13038o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13038o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.imageprocessing.FiltersEngine.a(com.facebook.inject.InjectorLike):com.facebook.photos.imageprocessing.FiltersEngine");
    }

    @DoNotStrip
    private static native void applyAutoEnhanceFilter(long j, Bitmap bitmap, String str, String str2);

    @DoNotStrip
    private static native boolean applyAutoEnhanceFilterToJpegFile(String str, String str2, int i, RectF[] rectFArr, int i2, String str3, String str4);

    @DoNotStrip
    private static native long init(Bitmap bitmap);

    @DoNotStrip
    private static native void preprocess(RectF[] rectFArr, long j);

    @DoNotStrip
    public static native void releaseSession(long j);

    private static FiltersEngine m20384b(InjectorLike injectorLike) {
        return new FiltersEngine(ListeningExecutorService_ImageTransformExecutorServiceMethodAutoProvider.a(injectorLike), ListeningExecutorService_ImageDecodeExecutorServiceMethodAutoProvider.a(injectorLike), BitmapUtils.a(injectorLike), ImageDupeDetector.m20403b(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    static {
        f13035j = false;
        f13036k = null;
        try {
            SoLoader.a("fb_creativeediting");
            f13035j = true;
        } catch (Throwable th) {
            f13036k = th;
        }
    }

    @Inject
    public FiltersEngine(ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, BitmapUtils bitmapUtils, ImageDupeDetector imageDupeDetector, PerformanceLogger performanceLogger, Lazy<FbErrorReporter> lazy) {
        this.f13039f = listeningExecutorService;
        this.f13040g = listeningExecutorService2;
        this.f13043l = bitmapUtils;
        this.f13041h = imageDupeDetector;
        this.f13044m = performanceLogger;
        f13037n = lazy;
        m20385b();
    }

    private static void m20385b() {
        if (f13036k != null) {
            SoftErrorBuilder a = SoftError.a("test", "Failed to load the creative editing library.");
            a.c = f13036k;
            ((AbstractFbErrorReporter) f13037n.get()).a(a.g());
            f13036k = null;
        }
    }

    public final Session m20386a(Bitmap bitmap) {
        return new Session(this, bitmap);
    }

    public static boolean m20380a() {
        return f13035j;
    }

    public final boolean m20387a(String str, String str2, CreativeEditingUploadParams creativeEditingUploadParams, int i, int i2) {
        boolean z;
        Preconditions.checkNotNull(creativeEditingUploadParams);
        Preconditions.checkNotNull(creativeEditingUploadParams.f3381a);
        Preconditions.checkState(creativeEditingUploadParams.m4459a().m4449l());
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        if (Strings.isNullOrEmpty(str2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        if (this.f13044m != null && this.f13044m.b()) {
            this.f13044m.d(1310737, f13033d);
        }
        if (m20381a(str, str2, i, Filter.getValue(creativeEditingUploadParams.m4459a().m4438a()), m20382a(creativeEditingUploadParams), i2)) {
            BitmapUtils.a(str, str2, 1);
            if (this.f13044m != null && this.f13044m.b()) {
                this.f13044m.c(1310737, f13033d);
            }
            return true;
        } else if (this.f13044m == null || !this.f13044m.b()) {
            return false;
        } else {
            this.f13044m.f(1310737, f13033d);
            return false;
        }
    }

    private static RectF[] m20382a(CreativeEditingUploadParams creativeEditingUploadParams) {
        if (creativeEditingUploadParams.f3381a.m4440c() == null || creativeEditingUploadParams.f3382b.isEmpty()) {
            return (RectF[]) creativeEditingUploadParams.f3382b.toArray(new RectF[0]);
        }
        List a = Lists.a();
        RectF c = creativeEditingUploadParams.f3381a.m4440c();
        Matrix matrix = new Matrix();
        matrix.setRectToRect(c, f13034e, ScaleToFit.FILL);
        ImmutableList immutableList = creativeEditingUploadParams.f3382b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RectF rectF = (RectF) immutableList.get(i);
            if (c.contains(rectF)) {
                RectF rectF2 = new RectF(rectF);
                matrix.mapRect(rectF2);
                a.add(rectF2);
            }
        }
        return (RectF[]) a.toArray(new RectF[0]);
    }

    private static void m20377a(long j, String str, Bitmap bitmap) {
        String str2 = "";
        if (Filter.AE08bit.name().equals(str)) {
            str2 = m20375a(0.2f);
        }
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        applyAutoEnhanceFilter(j, bitmap, str, str2);
    }

    private static boolean m20381a(String str, String str2, int i, Filter filter, RectF[] rectFArr, int i2) {
        String str3 = "";
        if (filter == Filter.AE08bit) {
            str3 = m20375a(0.2f);
        }
        Preconditions.checkNotNull(filter.name());
        Preconditions.checkNotNull(str3);
        return applyAutoEnhanceFilterToJpegFile(str, str2, i, rectFArr, i2, filter.name(), str3);
    }

    private static String m20375a(float f) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("slider=");
        stringBuilder.append(f);
        stringBuilder.append(";");
        return stringBuilder.toString();
    }
}
