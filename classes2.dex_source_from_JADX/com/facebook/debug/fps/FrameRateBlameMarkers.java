package com.facebook.debug.fps;

import android.util.SparseIntArray;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: omni_c */
public class FrameRateBlameMarkers {
    private static volatile FrameRateBlameMarkers f11243e;
    private final List<Marker> f11244a = new ArrayList();
    private final List<Marker> f11245b = new ArrayList();
    private final SparseIntArray f11246c = new SparseIntArray();
    private boolean f11247d;

    /* compiled from: omni_c */
    public enum Priority {
        GARBAGE_COLLECTION,
        DATA_CHANGED,
        VIDEO_BIND,
        GET_VIEW_AFTER_DATA_CHANGED,
        HSCROLL_RENDER,
        GET_VIEW,
        IMAGE_LOADING,
        AUTOPLAY
    }

    /* compiled from: omni_c */
    public interface Marker {
        String mo2656a();

        Priority mo2657b();
    }

    public static com.facebook.debug.fps.FrameRateBlameMarkers m16545a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f11243e;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.debug.fps.FrameRateBlameMarkers.class;
        monitor-enter(r1);
        r0 = f11243e;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m16546e();	 Catch:{ all -> 0x0034 }
        f11243e = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11243e;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.fps.FrameRateBlameMarkers.a(com.facebook.inject.InjectorLike):com.facebook.debug.fps.FrameRateBlameMarkers");
    }

    private static FrameRateBlameMarkers m16546e() {
        return new FrameRateBlameMarkers();
    }

    public final void m16548a(Marker marker) {
        int ordinal = marker.mo2657b().ordinal();
        int i = this.f11246c.get(ordinal);
        this.f11246c.put(ordinal, i + 1);
        if (i == 0) {
            this.f11244a.add(marker);
        }
    }

    public final void m16550b(Marker marker) {
        int ordinal = marker.mo2657b().ordinal();
        int i = this.f11246c.get(ordinal) - 1;
        if (i < 0) {
            throw new IllegalStateException("Unset a marker which was not set.");
        }
        this.f11246c.put(ordinal, i);
        if (i == 0) {
            this.f11244a.remove(marker);
        }
    }

    public final void m16552c(Marker marker) {
        if (this.f11247d && !this.f11245b.contains(marker)) {
            this.f11245b.add(marker);
            m16548a(marker);
        }
    }

    @Nullable
    public final Marker m16547a() {
        Marker marker = null;
        int i = 0;
        while (i < this.f11244a.size()) {
            Marker marker2 = (Marker) this.f11244a.get(i);
            if (marker != null && marker2.mo2657b().compareTo(marker.mo2657b()) >= 0) {
                marker2 = marker;
            }
            i++;
            marker = marker2;
        }
        return marker;
    }

    @VisibleForTesting
    protected final void m16549b() {
        this.f11247d = true;
    }

    @VisibleForTesting
    protected final void m16551c() {
        this.f11247d = false;
    }

    @VisibleForTesting
    protected final void m16553d() {
        for (int i = 0; i < this.f11245b.size(); i++) {
            m16550b((Marker) this.f11245b.get(i));
        }
        this.f11245b.clear();
    }
}
