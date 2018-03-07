package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaReadReceipt;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: preview_image_thumb_width */
public class DeltaReadReceiptHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4577g = new Object();
    private final DbFetchThreadHandler f4578a;
    private final DbInsertThreadsHandler f4579b;
    private final DeltaUiChangesCache f4580c;
    private final ThriftModelUtil f4581d;
    private final MessagesReliabilityLogger f4582e;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4583f = UltralightRuntime.b;

    private static DeltaReadReceiptHandler m4145b(InjectorLike injectorLike) {
        DeltaReadReceiptHandler deltaReadReceiptHandler = new DeltaReadReceiptHandler(DbFetchThreadHandler.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), MessagesReliabilityLogger.b(injectorLike));
        deltaReadReceiptHandler.f4583f = IdBasedLazy.a(injectorLike, 7693);
        return deltaReadReceiptHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaReadReceiptHandler m4144a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4577g;	 Catch:{ all -> 0x006c }
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
        r1 = m4145b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4577g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaReadReceiptHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaReadReceiptHandler) r0;	 Catch:{  }
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
        r0 = f4577g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaReadReceiptHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaReadReceiptHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaReadReceiptHandler");
    }

    @Inject
    private DeltaReadReceiptHandler(DbFetchThreadHandler dbFetchThreadHandler, DbInsertThreadsHandler dbInsertThreadsHandler, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, MessagesReliabilityLogger messagesReliabilityLogger) {
        this.f4578a = dbFetchThreadHandler;
        this.f4579b = dbInsertThreadsHandler;
        this.f4580c = deltaUiChangesCache;
        this.f4581d = thriftModelUtil;
        this.f4582e = messagesReliabilityLogger;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4581d.m4262a(deltaWrapper.s().threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return false;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        UserKey b;
        DeltaReadReceipt s = ((DeltaWrapper) deltaWithSequenceId.a).s();
        ThreadKey a = this.f4581d.m4262a(s.threadKey);
        if (a.a == Type.ONE_TO_ONE) {
            b = UserKey.b(Long.toString(a.d));
        } else {
            b = UserKey.b(Long.toString(s.actorFbId.longValue()));
        }
        this.f4579b.a(a, b, s.actionTimestampMs.longValue(), deltaWithSequenceId.b);
        FetchThreadResult a2 = this.f4578a.a(a, 0);
        ThreadSummary threadSummary = a2.c;
        Bundle bundle = new Bundle();
        if (threadSummary != null) {
            bundle.putParcelable("threadSummary", threadSummary);
            bundle.putLong("fetchTimeMs", a2.f);
        }
        return bundle;
    }

    public final void m4148a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ThreadSummary threadSummary = (ThreadSummary) bundle.getParcelable("threadSummary");
        if (threadSummary != null) {
            long longValue = ((DeltaWrapper) deltaWithSequenceId.a).s().actionTimestampMs.longValue();
            ((CacheInsertThreadsHandler) this.f4583f.get()).a(threadSummary, bundle.getLong("fetchTimeMs"));
            DeltaUiChangesCache deltaUiChangesCache = this.f4580c;
            deltaUiChangesCache.f4355d.put(threadSummary.a, deltaUiChangesCache.f4352a.a(threadSummary, longValue));
        }
    }
}
