package com.facebook.sync.connection;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.sync.model.thrift.GetIrisDiffs;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feed_topics_classification */
public class SyncQueueTrackerImpl {
    private static volatile SyncQueueTrackerImpl f14503f;
    private final Map<SyncConnectionStateManager$QueueKey, SyncConnectionHandler> f14504a = new HashMap();
    private final List<SyncConnectionStateManager$QueueKey> f14505b = new ArrayList();
    private final Clock f14506c;
    private final SyncConnectionStateManager f14507d;
    private boolean f14508e;

    public static com.facebook.sync.connection.SyncQueueTrackerImpl m18400a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14503f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.connection.SyncQueueTrackerImpl.class;
        monitor-enter(r1);
        r0 = f14503f;	 Catch:{ all -> 0x003a }
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
        r0 = m18401b(r0);	 Catch:{ all -> 0x0035 }
        f14503f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14503f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.connection.SyncQueueTrackerImpl.a(com.facebook.inject.InjectorLike):com.facebook.sync.connection.SyncQueueTrackerImpl");
    }

    private static SyncQueueTrackerImpl m18401b(InjectorLike injectorLike) {
        return new SyncQueueTrackerImpl((Clock) SystemClockMethodAutoProvider.a(injectorLike), SyncConnectionStateManager.a(injectorLike));
    }

    @Inject
    public SyncQueueTrackerImpl(Clock clock, SyncConnectionStateManager syncConnectionStateManager) {
        this.f14506c = clock;
        this.f14507d = syncConnectionStateManager;
    }

    public final synchronized void m18404a(SyncConnectionStateManager$QueueKey syncConnectionStateManager$QueueKey, SyncConnectionHandler syncConnectionHandler) {
        syncConnectionHandler.m18359b();
        this.f14504a.put(syncConnectionStateManager$QueueKey, syncConnectionHandler);
    }

    public final synchronized void m18403a(SyncConnectionStateManager$QueueKey syncConnectionStateManager$QueueKey) {
        this.f14504a.remove(syncConnectionStateManager$QueueKey);
    }

    public final synchronized void m18406c() {
        Boolean.valueOf(this.f14508e);
        this.f14508e = true;
    }

    public final synchronized boolean m18407d() {
        Boolean.valueOf(this.f14508e);
        return this.f14508e;
    }

    public final synchronized List m18402a() {
        List arrayList;
        TSerializer tSerializer = new TSerializer(new Factory());
        arrayList = new ArrayList();
        this.f14505b.clear();
        for (SyncConnectionHandler syncConnectionHandler : this.f14504a.values()) {
            try {
                GetIrisDiffs c = syncConnectionHandler.m18360c();
                if (c != null) {
                    Object a = tSerializer.a(c);
                    syncConnectionHandler.m18359b();
                    Integer.valueOf(a.length);
                    arrayList.add(a);
                    this.f14505b.add(syncConnectionHandler.m18359b());
                }
            } catch (TException e) {
                BLog.a("SyncQueueTrackerImpl", e, "Failed to serialize get_diffs message in getDiffsForConnect.", new Object[0]);
            }
        }
        return arrayList;
    }

    public final synchronized void m18405b() {
        for (SyncConnectionStateManager$QueueKey syncConnectionStateManager$QueueKey : this.f14505b) {
            if (this.f14504a.containsKey(syncConnectionStateManager$QueueKey)) {
                this.f14507d.a(syncConnectionStateManager$QueueKey, this.f14506c.a());
                ((SyncConnectionHandler) this.f14504a.get(syncConnectionStateManager$QueueKey)).m18361d();
            } else {
                BLog.a("SyncQueueTrackerImpl", "onConackReceived queue not tracked %s", new Object[]{syncConnectionStateManager$QueueKey});
            }
        }
        this.f14505b.clear();
    }
}
