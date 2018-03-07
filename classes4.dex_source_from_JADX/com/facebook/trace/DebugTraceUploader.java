package com.facebook.trace;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.base.broadcast.BackgroundBroadcastThread;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: libcore.icu.AlphabeticIndex$ImmutableIndex */
public class DebugTraceUploader {
    private static final Class<?> f9380a = DebugTraceUploader.class;
    private static volatile DebugTraceUploader f9381j;
    private final Lazy<FbBroadcastManager> f9382b;
    public final Lazy<FbNetworkManager> f9383c;
    private final Context f9384d;
    @BackgroundBroadcastThread
    private final Handler f9385e;
    public final DebugTraceData f9386f;
    private final DebugTraceUtils f9387g;
    public final Clock f9388h;
    public SelfRegistrableReceiverImpl f9389i;

    public static com.facebook.trace.DebugTraceUploader m9770a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9381j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.trace.DebugTraceUploader.class;
        monitor-enter(r1);
        r0 = f9381j;	 Catch:{ all -> 0x003a }
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
        r0 = m9773b(r0);	 Catch:{ all -> 0x0035 }
        f9381j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9381j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.trace.DebugTraceUploader.a(com.facebook.inject.InjectorLike):com.facebook.trace.DebugTraceUploader");
    }

    private static DebugTraceUploader m9773b(InjectorLike injectorLike) {
        return new DebugTraceUploader((Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 401), IdBasedSingletonScopeProvider.b(injectorLike, 585), Handler_BackgroundBroadcastThreadMethodAutoProvider.a(injectorLike), DebugTraceData.m9779a(injectorLike), DebugTraceUtils.m9784a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DebugTraceUploader(Context context, Lazy<FbBroadcastManager> lazy, Lazy<FbNetworkManager> lazy2, Handler handler, DebugTraceData debugTraceData, DebugTraceUtils debugTraceUtils, Clock clock) {
        this.f9384d = context;
        this.f9382b = lazy;
        this.f9383c = lazy2;
        this.f9385e = handler;
        this.f9386f = debugTraceData;
        this.f9387g = debugTraceUtils;
        this.f9388h = clock;
    }

    private void m9774b() {
        if (this.f9389i == null || !this.f9389i.a()) {
            this.f9389i = ((BaseFbBroadcastManager) this.f9382b.get()).a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new 1(this)).a(this.f9385e).a();
            this.f9389i.b();
        }
    }

    public final synchronized boolean m9778a() {
        boolean z;
        if (m9775c() || !m9777e()) {
            z = false;
        } else {
            if (((FbNetworkManager) this.f9383c.get()).v()) {
                m9776d(this);
            } else {
                m9774b();
            }
            z = true;
        }
        return z;
    }

    private boolean m9775c() {
        long a = this.f9388h.a() - this.f9386f.f9391a.getLong("LastRunTime", 0);
        if (a < 0) {
            this.f9386f.m9782b();
            return true;
        } else if (a >= 900000) {
            return false;
        } else {
            return true;
        }
    }

    public static void m9776d(DebugTraceUploader debugTraceUploader) {
        debugTraceUploader.f9386f.m9782b();
        debugTraceUploader.f9384d.startService(new Intent(debugTraceUploader.f9384d, DebugTraceUploadService.class));
    }

    private boolean m9777e() {
        return m9772a(this.f9387g.m9787a()) || m9772a(this.f9387g.m9788b());
    }

    private boolean m9772a(File[] fileArr) {
        boolean z = false;
        if (fileArr != null) {
            for (File file : fileArr) {
                Object obj = 1;
                long a = this.f9388h.a() - file.lastModified();
                if (a >= 0 && a <= 604800000 && !this.f9386f.m9783c(file)) {
                    obj = null;
                }
                if (obj != null) {
                    m9771a(file);
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    private void m9771a(File file) {
        if (file.delete()) {
            DebugTraceData debugTraceData = this.f9386f;
            if (debugTraceData.m9783c(file)) {
                debugTraceData.f9391a.edit().remove(file.getAbsolutePath()).commit();
                return;
            }
            return;
        }
        this.f9386f.m9781a(file);
        BLog.a(f9380a, "Error: failed to delete traceFile %s", new Object[]{file.getName()});
    }
}
