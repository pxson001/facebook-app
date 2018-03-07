package com.facebook.messaging.analytics.perf;

import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.android.FbLocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.classmarkers.ClassMarkerLoader;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.tracer.AsyncTracer;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mCancellingTask= */
public class MessagingPerformanceLogger {
    private static volatile MessagingPerformanceLogger f8742l;
    public final DefaultAndroidThreadUtil f8743a;
    public final DefaultAppChoreographer f8744b;
    public final AppStateManager f8745c;
    public final QuickPerformanceLogger f8746d;
    public final FbLocalBroadcastManager f8747e;
    public boolean f8748f;
    public int f8749g = 0;
    @GuardedBy("ui thread")
    private int f8750h = 0;
    public final Map<String, AsyncTracer> f8751i = new HashMap();
    public volatile boolean f8752j;
    private volatile boolean f8753k;

    public static com.facebook.messaging.analytics.perf.MessagingPerformanceLogger m9038a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8742l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.analytics.perf.MessagingPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f8742l;	 Catch:{ all -> 0x003a }
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
        r0 = m9041b(r0);	 Catch:{ all -> 0x0035 }
        f8742l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8742l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.analytics.perf.MessagingPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.analytics.perf.MessagingPerformanceLogger");
    }

    private static MessagingPerformanceLogger m9041b(InjectorLike injectorLike) {
        return new MessagingPerformanceLogger(DefaultAndroidThreadUtil.b(injectorLike), DefaultAppChoreographer.a(injectorLike), AppStateManager.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), FbLocalBroadcastManagerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessagingPerformanceLogger(DefaultAndroidThreadUtil defaultAndroidThreadUtil, DefaultAppChoreographer defaultAppChoreographer, AppStateManager appStateManager, QuickPerformanceLogger quickPerformanceLogger, FbLocalBroadcastManager fbLocalBroadcastManager) {
        this.f8744b = defaultAppChoreographer;
        this.f8745c = appStateManager;
        this.f8743a = defaultAndroidThreadUtil;
        this.f8746d = quickPerformanceLogger;
        this.f8747e = fbLocalBroadcastManager;
        this.f8746d.b(5505041, 100);
        this.f8746d.b(5505060, 1000);
        this.f8746d.b(5505042, 10);
        this.f8746d.b(5505025, 10);
        this.f8746d.b(5505049, 10);
        this.f8746d.b(5505047, 10);
    }

    public final void m9049a(String str) {
        this.f8746d.g(5505025, str.hashCode());
        if (null != null) {
            this.f8749g = 0;
        }
        if (!this.f8748f) {
            this.f8743a.a(new 1(this));
        }
        this.f8751i.put(str, AsyncTracer.b("send_message: %s", new Object[]{str}));
    }

    public final void m9051a(String str, short s) {
        this.f8746d.a(5505025, str.hashCode(), s);
    }

    public final void m9050a(String str, String str2) {
        this.f8746d.b(5505025, str.hashCode(), str2);
    }

    public final void m9053a(boolean z) {
        this.f8746d.a(5505028, "dst_THREADLIST");
        this.f8746d.a(5505026, "dst_THREADLIST");
        this.f8746d.a(5505027, "dst_THREADLIST");
        if (z) {
            this.f8746d.a(5505028, "is_in_chat_heads");
            this.f8746d.a(5505026, "is_in_chat_heads");
            this.f8746d.a(5505027, "is_in_chat_heads");
        }
        m9043c(this, 5505026, "draw_complete");
        m9043c(this, 5505028, "draw_complete");
        m9040a((short) 5);
    }

    private void m9040a(short s) {
        if (this.f8746d.f(5505027)) {
            this.f8746d.b(5505027, s);
            if (s == (short) 4 || this.f8745c.k() == TriState.YES || this.f8745c.j()) {
                ClassMarkerLoader.loadIsNotColdStartRunMarker();
            } else {
                ClassMarkerLoader.loadIsColdStartRunMarker();
            }
        }
    }

    public static void m9043c(MessagingPerformanceLogger messagingPerformanceLogger, int i, String str) {
        messagingPerformanceLogger.f8746d.a(i, str);
        messagingPerformanceLogger.f8746d.b(i, (short) 2);
    }

    public final void m9052a(String str, boolean z) {
        this.f8746d.b(5505034, str.hashCode(), (short) 5);
        this.f8746d.b(5505032, (short) 5);
        this.f8746d.a(5505028, "dst_THREADVIEW");
        this.f8746d.a(5505026, "dst_THREADVIEW");
        this.f8746d.a(5505027, "dst_THREADVIEW");
        if (z) {
            this.f8746d.a(5505028, "is_in_chat_heads");
            this.f8746d.a(5505026, "is_in_chat_heads");
            this.f8746d.a(5505027, "is_in_chat_heads");
        }
        m9043c(this, 5505026, "draw_complete");
        m9043c(this, 5505028, "draw_complete");
        m9040a((short) 5);
    }

    public final void m9048a(int i, String str) {
        this.f8746d.e(5505042, i);
        this.f8746d.b(5505042, i, str);
        m9042b(5505042, i);
    }

    public final void m9055b(int i) {
        this.f8746d.a(5505042, i, (short) 23);
    }

    public final void m9059d(int i) {
        this.f8746d.a(5505042, i, (short) 30);
    }

    public final void m9047a(int i, @Nullable DataFetchDisposition dataFetchDisposition) {
        if (dataFetchDisposition == null || dataFetchDisposition.m == null) {
            this.f8746d.a(5505042, i, (short) 33);
            return;
        }
        m9039a(5505042, i, dataFetchDisposition);
        switch (2.a[dataFetchDisposition.m.ordinal()]) {
            case 1:
                this.f8746d.a(5505042, i, (short) 25);
                return;
            case 2:
                this.f8746d.a(5505042, i, (short) 26);
                return;
            case 3:
                this.f8746d.a(5505042, i, (short) 28);
                return;
            case 4:
                this.f8746d.a(5505042, i, (short) 27);
                return;
            default:
                return;
        }
    }

    public final void m9062f(int i) {
        this.f8746d.b(5505042, i, (short) 2);
    }

    public final void m9063g(int i) {
        this.f8746d.b(5505042, i, (short) 3);
    }

    public final void m9057b(int i, String str) {
        this.f8746d.e(5505041, i);
        this.f8746d.b(5505041, i, str);
        m9042b(5505041, i);
    }

    public final void m9064i(int i) {
        this.f8746d.a(5505041, i, (short) 34);
    }

    public final void m9065j(int i) {
        this.f8746d.a(5505041, i, (short) 23);
    }

    public final void m9066k(int i) {
        this.f8746d.a(5505041, i, (short) 29);
    }

    public final void m9067l(int i) {
        this.f8746d.a(5505041, i, (short) 30);
    }

    public final void m9068m(int i) {
        this.f8746d.a(5505041, i, (short) 31);
    }

    public final void m9056b(int i, @Nullable DataFetchDisposition dataFetchDisposition) {
        if (dataFetchDisposition == null || dataFetchDisposition.m == null) {
            this.f8746d.a(5505041, i, (short) 33);
            return;
        }
        m9039a(5505041, i, dataFetchDisposition);
        switch (2.a[dataFetchDisposition.m.ordinal()]) {
            case 1:
                this.f8746d.a(5505041, i, (short) 25);
                return;
            case 2:
                this.f8746d.a(5505041, i, (short) 26);
                return;
            case 3:
                this.f8746d.a(5505041, i, (short) 28);
                return;
            case 4:
                this.f8746d.a(5505041, i, (short) 27);
                return;
            default:
                return;
        }
    }

    public final void m9069n(int i) {
        this.f8746d.b(5505041, i, (short) 2);
    }

    public final void m9070o(int i) {
        this.f8746d.b(5505041, i, (short) 3);
    }

    public final void m9054b() {
        m9040a((short) 4);
        this.f8746d.b(5505026, (short) 4);
        this.f8746d.b(5505028, (short) 4);
    }

    public final void m9060d(String str) {
        this.f8746d.b(5505026, (short) 4);
        this.f8746d.b(5505028, (short) 4);
        m9040a((short) 4);
        this.f8746d.b(5505034, str.hashCode(), (short) 4);
        this.f8746d.b(5505032, (short) 4);
        this.f8746d.b(5505025, (short) 4);
    }

    private void m9039a(int i, int i2, DataFetchDisposition dataFetchDisposition) {
        this.f8746d.b(i, i2, "data_fetch_disposition_has_data", String.valueOf(dataFetchDisposition.l));
        if (dataFetchDisposition.o.isSet()) {
            this.f8746d.b(i, i2, "data_fetch_disposition_stale_data", String.valueOf(dataFetchDisposition.o.asBoolean()));
        }
        if (dataFetchDisposition.m != null) {
            this.f8746d.b(i, i2, "data_fetch_disposition_data_source", dataFetchDisposition.m.toString());
        }
        if (dataFetchDisposition.s.isSet()) {
            this.f8746d.b(i, i2, "data_fetch_disposition_synchronous_fetch", String.valueOf(dataFetchDisposition.s.asBoolean()));
        }
        if (dataFetchDisposition.p.isSet()) {
            this.f8746d.b(i, i2, "data_fetch_disposition_incomplete_data", String.valueOf(dataFetchDisposition.p.asBoolean()));
        }
        if (dataFetchDisposition.q.isSet()) {
            this.f8746d.b(i, i2, "data_fetch_disposition_server_error_fallback", String.valueOf(dataFetchDisposition.q.asBoolean()));
        }
    }

    private void m9042b(int i, int i2) {
        if (this.f8746d.a(5505028)) {
            this.f8746d.b(i, i2, "luke_warm_start");
        } else if (this.f8746d.a(5505026)) {
            this.f8746d.b(i, i2, "warm_start");
        } else if (this.f8746d.a(5505027)) {
            Object obj;
            if (this.f8745c.U || this.f8745c.V) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f8746d.b(i, i2, "first_cold_start");
                this.f8753k = true;
                return;
            }
            this.f8746d.b(i, i2, "cold_start");
        }
    }

    public final void m9045a(int i, int i2, String str) {
        if (!this.f8746d.j(i, i2)) {
            this.f8746d.e(i, i2);
            this.f8746d.b(i, i2, "starting_location", str);
        }
    }

    public final void m9046a(int i, int i2, short s) {
        this.f8746d.a(i, i2, s);
    }

    public final void m9044a(int i, int i2) {
        this.f8746d.b(i, i2, (short) 42);
    }

    public final void m9061e(String str) {
        int i = this.f8750h;
        this.f8750h = i + 1;
        if (i == 0) {
            this.f8746d.b(5505060);
        }
        this.f8746d.a(5505060, str);
    }

    public final void m9058d() {
        int i = this.f8750h - 1;
        this.f8750h = i;
        if (i == 0) {
            this.f8746d.b(5505060, (short) 2);
        }
    }
}
