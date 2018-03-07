package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.LatencyLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.DeliveredReceiptParams;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaDeliveryReceipt;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

@UserScoped
/* compiled from: profileCache */
public class DeltaDeliveredReceiptHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4474j = new Object();
    private final DbFetchThreadHandler f4475a;
    private final DbInsertThreadsHandler f4476b;
    private final DeltaUiChangesCache f4477c;
    private final ThriftModelUtil f4478d;
    private final UncommittedThreadModificationsCache f4479e;
    private final FbTracer f4480f;
    private final MessagesReliabilityLogger f4481g;
    private final LatencyLogger f4482h;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4483i = UltralightRuntime.b;

    private static DeltaDeliveredReceiptHandler m4041b(InjectorLike injectorLike) {
        DeltaDeliveredReceiptHandler deltaDeliveredReceiptHandler = new DeltaDeliveredReceiptHandler(DbFetchThreadHandler.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), UncommittedThreadModificationsCache.m4224a(injectorLike), FbTracer.a(injectorLike), MessagesReliabilityLogger.b(injectorLike), LatencyLogger.a(injectorLike));
        deltaDeliveredReceiptHandler.f4483i = IdBasedLazy.a(injectorLike, 7693);
        return deltaDeliveredReceiptHandler;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return RegularImmutableSet.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaDeliveredReceiptHandler m4040a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f4474j;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m4041b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4474j;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaDeliveredReceiptHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaDeliveredReceiptHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f4474j;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaDeliveredReceiptHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaDeliveredReceiptHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaDeliveredReceiptHandler");
    }

    @Inject
    private DeltaDeliveredReceiptHandler(DbFetchThreadHandler dbFetchThreadHandler, DbInsertThreadsHandler dbInsertThreadsHandler, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, UncommittedThreadModificationsCache uncommittedThreadModificationsCache, FbTracer fbTracer, MessagesReliabilityLogger messagesReliabilityLogger, LatencyLogger latencyLogger) {
        this.f4475a = dbFetchThreadHandler;
        this.f4476b = dbInsertThreadsHandler;
        this.f4477c = deltaUiChangesCache;
        this.f4478d = thriftModelUtil;
        this.f4479e = uncommittedThreadModificationsCache;
        this.f4480f = fbTracer;
        this.f4481g = messagesReliabilityLogger;
        this.f4482h = latencyLogger;
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        UserKey b;
        DeltaDeliveryReceipt v = ((DeltaWrapper) deltaWithSequenceId.a).v();
        ThreadKey a = this.f4478d.m4262a(v.threadKey);
        if (a.a == Type.ONE_TO_ONE) {
            b = UserKey.b(Long.toString(a.d));
        } else {
            b = UserKey.b(Long.toString(v.actorFbId.longValue()));
        }
        FbTraceNode a2 = FbTracer.a(deltaWithSequenceId.c);
        FbTraceEventAnnotations a3 = FbTraceEventAnnotationsUtil.a(a2);
        a3.put("op", "handle_delivery_receipt");
        a3.put("other_fbid", b);
        a3.put("thread_key", a);
        a3.put("user_id", Long.valueOf(a.e));
        this.f4480f.a(a2, FbTraceEvent.REQUEST_SEND, a3);
        this.f4476b.a(new DeliveredReceiptParams(a, b, null, v.deliveredWatermarkTimestampMs.longValue(), deltaWithSequenceId.b));
        FetchThreadResult a4 = this.f4475a.a(a, 0);
        ThreadSummary threadSummary = a4.c;
        Bundle bundle = new Bundle();
        if (threadSummary != null) {
            bundle.putParcelable("threadSummary", threadSummary);
            bundle.putLong("fetchTimeMs", a4.f);
            bundle.putParcelable("fbTraceNode", a2);
        }
        return bundle;
    }

    public final void m4044a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ThreadSummary threadSummary = (ThreadSummary) bundle.getParcelable("threadSummary");
        if (threadSummary != null) {
            long longValue = ((DeltaWrapper) deltaWithSequenceId.a).v().deliveredWatermarkTimestampMs.longValue();
            ((CacheInsertThreadsHandler) this.f4483i.get()).b(threadSummary, bundle.getLong("fetchTimeMs"));
            FbTraceNode fbTraceNode = (FbTraceNode) bundle.getParcelable("fbTraceNode");
            DeltaUiChangesCache deltaUiChangesCache = this.f4477c;
            deltaUiChangesCache.f4356e.put(threadSummary.a, deltaUiChangesCache.f4352a.a(threadSummary, longValue, fbTraceNode));
        }
    }
}
