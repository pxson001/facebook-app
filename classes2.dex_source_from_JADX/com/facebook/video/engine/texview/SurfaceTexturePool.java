package com.facebook.video.engine.texview;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gl.GLHelpers;
import com.facebook.gl.GlPbufferSurface;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.SurfaceTexturePoolEvents;
import com.facebook.video.engine.VideoLoggingUtils;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(17)
/* compiled from: prev_action_id */
public class SurfaceTexturePool implements MemoryTrimmable {
    private static volatile SurfaceTexturePool f9090f;
    private final GatekeeperStoreImpl f9091a;
    private final Lazy<VideoLoggingUtils> f9092b;
    private final Lazy<FbErrorReporter> f9093c;
    private GlPbufferSurface f9094d;
    private final List<SurfaceTexture> f9095e = new ArrayList(5);

    public static com.facebook.video.engine.texview.SurfaceTexturePool m13985a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9090f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.texview.SurfaceTexturePool.class;
        monitor-enter(r1);
        r0 = f9090f;	 Catch:{ all -> 0x003a }
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
        r0 = m13988b(r0);	 Catch:{ all -> 0x0035 }
        f9090f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9090f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.texview.SurfaceTexturePool.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.texview.SurfaceTexturePool");
    }

    private static SurfaceTexturePool m13988b(InjectorLike injectorLike) {
        return new SurfaceTexturePool(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), MemoryManager.m9807a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3663), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
    }

    @Inject
    public SurfaceTexturePool(GatekeeperStore gatekeeperStore, MemoryTrimmableRegistry memoryTrimmableRegistry, Lazy<VideoLoggingUtils> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f9091a = gatekeeperStore;
        this.f9092b = lazy;
        this.f9093c = lazy2;
        if (memoryTrimmableRegistry != null) {
            memoryTrimmableRegistry.mo1390a(this);
        }
    }

    private boolean m13990c() {
        if (this.f9094d != null) {
            return true;
        }
        try {
            this.f9094d = new GlPbufferSurface(1, 1);
            return true;
        } catch (Throwable e) {
            m13987a("setupPbufferSurface", "Error encountered in creating 1x1 PbufferSurface", e);
            m13992e();
            return false;
        }
    }

    private int m13991d() {
        int i;
        Throwable th;
        int[] iArr = new int[1];
        try {
            this.f9094d.a();
            GLES20.glGenTextures(1, iArr, 0);
            GLHelpers.a("glGenTextures");
            int i2 = iArr[0];
            try {
                GLES20.glBindTexture(36197, i2);
                GLHelpers.a("glBindTexture");
                GLES20.glTexParameterf(36197, 10241, 9728.0f);
                GLES20.glTexParameterf(36197, 10240, 9729.0f);
                GLES20.glTexParameteri(36197, 10242, 33071);
                GLES20.glTexParameteri(36197, 10243, 33071);
                GLHelpers.a("glTexParameter");
                return i2;
            } catch (Throwable e) {
                Throwable th2 = e;
                i = i2;
                th = th2;
            }
        } catch (RuntimeException e2) {
            th = e2;
            i = 0;
            m13987a("generateExternalTexture", "Error encountered in creating an external texture", th);
            if (i != 0) {
                GLES20.glDeleteTextures(1, iArr, 0);
            }
            m13992e();
            return 0;
        }
    }

    private SurfaceTexture m13984a(boolean z) {
        m13994g();
        if (z) {
            if (!(this.f9091a.m2189a(500, false) || this.f9091a.m2189a(501, false))) {
                return null;
            }
        } else if (!(this.f9091a.m2189a(502, false) || this.f9091a.m2189a(503, false))) {
            return null;
        }
        if (this.f9094d != null) {
            try {
                this.f9094d.a();
            } catch (Throwable e) {
                m13987a("getSurfaceTexture", "Error encountered in makeCurrent with PbufferSurface", e);
                m13992e();
            }
            if (!this.f9095e.isEmpty()) {
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.f9095e.remove(0);
                ((VideoLoggingUtils) this.f9092b.get()).m27048a(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_HIT, this.f9095e.size(), z);
                return surfaceTexture;
            }
        }
        if (m13990c()) {
            int d = m13991d();
            if (d == 0) {
                ((VideoLoggingUtils) this.f9092b.get()).m27048a(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_FAILED, this.f9095e.size(), z);
                return null;
            }
            ((VideoLoggingUtils) this.f9092b.get()).m27048a(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_MISSED, this.f9095e.size(), z);
            surfaceTexture = new SurfaceTexture(d);
            surfaceTexture.detachFromGLContext();
            return surfaceTexture;
        }
        ((VideoLoggingUtils) this.f9092b.get()).m27048a(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_FAILED, this.f9095e.size(), z);
        return null;
    }

    public final SurfaceTexture m13995a() {
        return m13984a(true);
    }

    public final SurfaceTexture m13998b() {
        return m13984a(false);
    }

    private void m13986a(SurfaceTexture surfaceTexture, boolean z) {
        m13994g();
        if (z) {
            if (!this.f9091a.m2189a(501, false)) {
                surfaceTexture.release();
                return;
            }
        } else if (!this.f9091a.m2189a(503, false)) {
            surfaceTexture.release();
            return;
        }
        if (this.f9095e.size() >= 5) {
            surfaceTexture.release();
            ((VideoLoggingUtils) this.f9092b.get()).m27048a(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_OVERFLOWED, this.f9095e.size(), z);
            return;
        }
        if (!z) {
            try {
                this.f9094d.b(surfaceTexture);
            } catch (Throwable e) {
                m13987a("recycleSurfaceTexture", "Error encountered in clearing SurfaceTexture", e);
                surfaceTexture.release();
                ((VideoLoggingUtils) this.f9092b.get()).m27048a(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_FAILED, this.f9095e.size(), z);
                return;
            }
        }
        this.f9095e.add(surfaceTexture);
        ((VideoLoggingUtils) this.f9092b.get()).m27048a(SurfaceTexturePoolEvents.SURFACE_TEXTURE_POOL_POOLED, this.f9095e.size(), z);
    }

    public final void m13996a(SurfaceTexture surfaceTexture) {
        m13986a(surfaceTexture, true);
    }

    public final void m13999b(SurfaceTexture surfaceTexture) {
        m13986a(surfaceTexture, false);
    }

    private void m13992e() {
        m13994g();
        for (SurfaceTexture release : this.f9095e) {
            release.release();
        }
        this.f9095e.clear();
        if (this.f9094d != null) {
            this.f9094d.c();
            this.f9094d = null;
        }
    }

    public static void m13989b(SurfaceTexturePool surfaceTexturePool, MemoryTrimType memoryTrimType) {
        m13994g();
        if (!surfaceTexturePool.f9095e.isEmpty()) {
            ((VideoLoggingUtils) surfaceTexturePool.f9092b.get()).m27047a(surfaceTexturePool.f9095e.size(), memoryTrimType);
            surfaceTexturePool.m13992e();
        }
    }

    public final void mo1395a(MemoryTrimType memoryTrimType) {
        if (m13993f()) {
            m13989b(this, memoryTrimType);
        } else {
            HandlerDetour.a(new Handler(Looper.getMainLooper()), new 1(this, memoryTrimType), 170193376);
        }
    }

    private static boolean m13993f() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private static void m13994g() {
        Preconditions.checkState(m13993f());
    }

    private void m13987a(String str, String str2, Throwable th) {
        SoftErrorBuilder a = SoftError.a("SurfaceTexturePool." + str, str2);
        a.c = th;
        ((AbstractFbErrorReporter) this.f9093c.get()).mo336a(a.g());
    }
}
