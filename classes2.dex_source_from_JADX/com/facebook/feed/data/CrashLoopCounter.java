package com.facebook.feed.data;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.xconfig.NewsFeedXConfig;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.common.init.INeedInit;
import com.facebook.debug.log.BLog;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandlerProvider;
import com.facebook.inject.InjectorLike;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: snaptu_feed */
public class CrashLoopCounter implements INeedInit {
    private static final Class<?> f4476a = CrashLoopCounter.class;
    private static volatile CrashLoopCounter f4477h;
    private final DefaultFlatBufferCorruptionHandlerProvider f4478b;
    private final Context f4479c;
    public final AnalyticsLogger f4480d;
    private final NewsFeedXConfigReader f4481e;
    private final GatekeeperStoreImpl f4482f;
    private final AtomicBoolean f4483g = new AtomicBoolean(false);

    public static com.facebook.feed.data.CrashLoopCounter m8180a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4477h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.data.CrashLoopCounter.class;
        monitor-enter(r1);
        r0 = f4477h;	 Catch:{ all -> 0x003a }
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
        r0 = m8183b(r0);	 Catch:{ all -> 0x0035 }
        f4477h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4477h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.CrashLoopCounter.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.CrashLoopCounter");
    }

    private static CrashLoopCounter m8183b(InjectorLike injectorLike) {
        return new CrashLoopCounter((Context) injectorLike.getInstance(Context.class), (DefaultFlatBufferCorruptionHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultFlatBufferCorruptionHandlerProvider.class), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedXConfigReader.m8187a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public CrashLoopCounter(Context context, DefaultFlatBufferCorruptionHandlerProvider defaultFlatBufferCorruptionHandlerProvider, AnalyticsLogger analyticsLogger, NewsFeedXConfigReader newsFeedXConfigReader, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f4479c = context;
        this.f4478b = defaultFlatBufferCorruptionHandlerProvider;
        this.f4480d = analyticsLogger;
        this.f4481e = newsFeedXConfigReader;
        this.f4482f = gatekeeperStoreImpl;
    }

    public void init() {
        m8181a(0);
    }

    public final void m8184a() {
        if (this.f4482f.m2189a(654, false) && !this.f4483g.getAndSet(true)) {
            int b = m8182b();
            NewsFeedXConfigReader newsFeedXConfigReader = this.f4481e;
            if (newsFeedXConfigReader.f4505o == -1) {
                newsFeedXConfigReader.f4505o = newsFeedXConfigReader.f4491a.m2683a(NewsFeedXConfig.f5015u, 2);
            }
            if (b < newsFeedXConfigReader.f4505o) {
                m8181a(b + 1);
                return;
            }
            HoneyClientEventFast a = this.f4480d.mo535a("android_crash_loop_counter_max_reached", false);
            if (a.m17388a()) {
                a.m17390b();
            }
            this.f4478b.m8185a(FeedPrefKeys.f5758v).m21221a();
            m8181a(0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m8182b() {
        /*
        r5 = this;
        r1 = 0;
        r0 = r5.f4479c;	 Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x0020 }
        r2 = "crash_count";
        r2 = r0.openFileInput(r2);	 Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x0020 }
        r0 = 4;
        r0 = java.nio.ByteBuffer.allocate(r0);	 Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x0020 }
        r3 = r0.array();	 Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x0020 }
        r2.read(r3);	 Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x0020 }
        r0 = r0.getInt();	 Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x0020 }
        r2.close();	 Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x002c }
    L_0x001c:
        return r0;
    L_0x001d:
        r0 = move-exception;
        r0 = r1;
        goto L_0x001c;
    L_0x0020:
        r0 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r4;
    L_0x0024:
        r2 = f4476a;
        r3 = "Exception when attempting to read crash count file";
        com.facebook.debug.log.BLog.a(r2, r3, r1);
        goto L_0x001c;
    L_0x002c:
        r1 = move-exception;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.CrashLoopCounter.b():int");
    }

    private synchronized void m8181a(int i) {
        try {
            FileOutputStream openFileOutput = this.f4479c.openFileOutput("crash_count", 0);
            openFileOutput.write(ByteBuffer.allocate(4).putInt(i).array());
            openFileOutput.close();
        } catch (Throwable e) {
            BLog.a(f4476a, "Exception when attempting to write crash count file", e);
        }
    }
}
