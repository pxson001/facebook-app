package com.facebook.common.executors;

import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.backgroundworklog.observer.OnBackgroundWorkObservedChanged;
import com.facebook.common.executors.BackgroundWorkLogger.OnTrackingChangeListener;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.common.executors.FbHandlerThreadFactory.FbHandlerThread.C01231;
import com.facebook.inject.InjectorLike;
import com.facebook.systrace.TraceConfig;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: weekend_photo_reminder_data */
public class BaseBackgroundWorkLogger implements BackgroundWorkLogger {
    private static volatile BaseBackgroundWorkLogger f871b;
    @Nullable
    private MultiplexBackgroundWorkObserver f872a;

    public static com.facebook.common.executors.BaseBackgroundWorkLogger m1660a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f871b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.executors.BaseBackgroundWorkLogger.class;
        monitor-enter(r1);
        r0 = f871b;	 Catch:{ all -> 0x003a }
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
        r0 = m1661b(r0);	 Catch:{ all -> 0x0035 }
        f871b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f871b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.BaseBackgroundWorkLogger.a(com.facebook.inject.InjectorLike):com.facebook.common.executors.BaseBackgroundWorkLogger");
    }

    private static BaseBackgroundWorkLogger m1661b(InjectorLike injectorLike) {
        return new BaseBackgroundWorkLogger(MultiplexBackgroundWorkObserver.m1670a(injectorLike));
    }

    @Nullable
    public /* synthetic */ List mo230a(C01231 c01231) {
        return m1666b(c01231);
    }

    @Inject
    public BaseBackgroundWorkLogger(@Nullable MultiplexBackgroundWorkObserver multiplexBackgroundWorkObserver) {
        this.f872a = multiplexBackgroundWorkObserver;
    }

    public StatsCollector mo229a(String str, Object obj) {
        if (TraceConfig.a(128)) {
            return new SystraceStatsCollector(str, obj);
        }
        if (m1662b()) {
            return new BackgroundWorkLogCollector(this.f872a, str, obj);
        }
        return NoOpBackgroundWorkLogger.f14986a;
    }

    private boolean m1662b() {
        return this.f872a != null && this.f872a.mo238a();
    }

    public boolean mo231a() {
        return TraceConfig.a(128) || m1662b();
    }

    @Nullable
    public ArrayList<Object> m1666b(final OnTrackingChangeListener onTrackingChangeListener) {
        if (this.f872a == null) {
            return null;
        }
        OnBackgroundWorkObservedChanged c01241 = new OnBackgroundWorkObservedChanged(this) {
            final /* synthetic */ BaseBackgroundWorkLogger f1850b;

            public final void mo366a() {
                onTrackingChangeListener.m3690a(this.f1850b.mo231a());
            }
        };
        this.f872a.mo237a(c01241);
        ArrayList<Object> arrayList = new ArrayList(2);
        arrayList.add(c01241);
        return arrayList;
    }
}
