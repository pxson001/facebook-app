package com.facebook.debug.activitytracer;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.log.LogPrefixer;
import com.facebook.debug.tracer.AsyncTracer;
import com.facebook.debug.tracer.Tracer;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: video_story */
public class ActivityTracer {
    private static final Class<?> f1090a = ActivityTracer.class;
    private static volatile ActivityTracer f1091h;
    public final DefaultAndroidThreadUtil f1092b;
    private final DefaultAppChoreographer f1093c;
    private final ActivityTraceProvider f1094d;
    private final Set<Listener> f1095e;
    public final Handler f1096f = new Handler(Looper.getMainLooper());
    public ActivityTrace f1097g;

    /* compiled from: video_story */
    class C01041 implements Runnable {
        final /* synthetic */ ActivityTracer f1465a;

        /* compiled from: video_story */
        class C03871 implements IdleHandler {
            final /* synthetic */ C01041 f8835a;

            C03871(C01041 c01041) {
                this.f8835a = c01041;
            }

            public boolean queueIdle() {
                if (this.f8835a.f1465a.f1097g == null || ActivityTracer.m2213a(this.f8835a.f1465a, "idle")) {
                    return false;
                }
                return true;
            }
        }

        C01041(ActivityTracer activityTracer) {
            this.f1465a = activityTracer;
        }

        public void run() {
            Looper.myQueue().addIdleHandler(new C03871(this));
        }
    }

    public static com.facebook.debug.activitytracer.ActivityTracer m2212a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1091h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.debug.activitytracer.ActivityTracer.class;
        monitor-enter(r1);
        r0 = f1091h;	 Catch:{ all -> 0x003a }
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
        r0 = m2214b(r0);	 Catch:{ all -> 0x0035 }
        f1091h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1091h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.debug.activitytracer.ActivityTracer.a(com.facebook.inject.InjectorLike):com.facebook.debug.activitytracer.ActivityTracer");
    }

    private static ActivityTracer m2214b(InjectorLike injectorLike) {
        return new ActivityTracer(DefaultAndroidThreadUtil.m1646b(injectorLike), DefaultAppChoreographer.m1621a(injectorLike), (ActivityTraceProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityTraceProvider.class), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ActivityTracer_Listener(injectorLike)));
    }

    @Inject
    public ActivityTracer(AndroidThreadUtil androidThreadUtil, AppChoreographer appChoreographer, ActivityTraceProvider activityTraceProvider, Set<Listener> set) {
        this.f1092b = androidThreadUtil;
        this.f1093c = appChoreographer;
        this.f1094d = activityTraceProvider;
        this.f1095e = set;
    }

    @Nullable
    public final ActivityTrace m2219a(String str, String str2) {
        this.f1092b.m1649a();
        if (this.f1097g != null) {
            return null;
        }
        this.f1097g = this.f1094d.m2220a(AsyncTracer.m1032a(str2), str);
        m2215c();
        return this.f1097g;
    }

    @Nullable
    public final ActivityTrace m2218a(AsyncTracer asyncTracer, String str) {
        if (this.f1097g != null) {
            this.f1097g.m2791a("suppressed_tracer", str);
            return null;
        }
        this.f1097g = this.f1094d.m2220a(asyncTracer, str);
        m2215c();
        return this.f1097g;
    }

    @Nullable
    public final ActivityTrace m2217a() {
        return this.f1097g;
    }

    private void m2215c() {
        this.f1092b.m1652a(new C01041(this));
    }

    public static boolean m2213a(ActivityTracer activityTracer, String str) {
        Preconditions.checkState(activityTracer.f1097g != null);
        if (!activityTracer.f1093c.m1638a()) {
            Tracer.m888d("%s(%s):Waiting for application loaded", new Object[]{"ActivityTracer", str});
            return false;
        } else if (activityTracer.f1093c.m1640b()) {
            Tracer.m888d("%s(%s):Waiting for UI to finish loading", new Object[]{"ActivityTracer", str});
            if (str != "draw" || activityTracer.f1097g.f1463l) {
                return false;
            }
            long j = activityTracer.f1097g.f1464m;
            activityTracer.f1097g.f1463l = true;
            activityTracer.f1097g.m2793a("UILoadWait:" + Long.toString(j));
            return false;
        } else if (activityTracer.f1093c.m1641c()) {
            Tracer.m888d("%s(%s):UI is interactive", new Object[]{"ActivityTracer", str});
            activityTracer.m2216d();
            return true;
        } else {
            Tracer.m888d("%s(%s):Waiting for initialization to complete", new Object[]{"ActivityTracer", str});
            return false;
        }
    }

    private void m2216d() {
        ActivityTrace activityTrace = this.f1097g;
        activityTrace.f1464m = activityTrace.f1453b.m1035c();
        AsyncTracer asyncTracer = activityTrace.f1453b;
        asyncTracer.f498a.m906a(asyncTracer.f499b, 3, LogPrefixer.a(ActivityTracer.class));
        Iterator it = this.f1095e.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.f1097g = null;
    }
}
