package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.MessageFromDeltaFactory;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: previous_tab */
public class DeltaP2PPaymentMessageHandler extends SingleThreadDeltaHandler {
    private static final Object f4544g = new Object();
    private final Clock f4545a;
    private final DbInsertThreadsHandler f4546b;
    private final MessageFromDeltaFactory f4547c;
    private final DeltaUiChangesCache f4548d;
    private final ThriftModelUtil f4549e;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4550f = UltralightRuntime.b;

    private static DeltaP2PPaymentMessageHandler m4118b(InjectorLike injectorLike) {
        DeltaP2PPaymentMessageHandler deltaP2PPaymentMessageHandler = new DeltaP2PPaymentMessageHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), MessageFromDeltaFactory.m4243a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), ThriftModelUtil.m4260a(injectorLike), IdBasedLazy.a(injectorLike, 11051));
        deltaP2PPaymentMessageHandler.f4550f = IdBasedLazy.a(injectorLike, 7693);
        return deltaP2PPaymentMessageHandler;
    }

    @Inject
    private DeltaP2PPaymentMessageHandler(Clock clock, DbInsertThreadsHandler dbInsertThreadsHandler, MessageFromDeltaFactory messageFromDeltaFactory, DeltaUiChangesCache deltaUiChangesCache, ThriftModelUtil thriftModelUtil, com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy) {
        super(lazy);
        this.f4545a = clock;
        this.f4546b = dbInsertThreadsHandler;
        this.f4547c = messageFromDeltaFactory;
        this.f4548d = deltaUiChangesCache;
        this.f4549e = thriftModelUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaP2PPaymentMessageHandler m4117a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4544g;	 Catch:{ all -> 0x006c }
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
        r1 = m4118b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4544g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaP2PPaymentMessageHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaP2PPaymentMessageHandler) r0;	 Catch:{  }
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
        r0 = f4544g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaP2PPaymentMessageHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaP2PPaymentMessageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaP2PPaymentMessageHandler");
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4549e.m4262a(deltaWrapper.w().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return true;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ThreadSummary threadSummary2 = null;
        NewMessageResult a = this.f4546b.a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, this.f4547c.m4251a(((DeltaWrapper) deltaWithSequenceId.a).w(), threadSummary), null, threadSummary2, this.f4545a.a()), deltaWithSequenceId.b);
        Bundle bundle = new Bundle();
        bundle.putParcelable("newMessageResult", a);
        return bundle;
    }

    public final void m4121a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        NewMessageResult newMessageResult = (NewMessageResult) bundle.getParcelable("newMessageResult");
        if (newMessageResult != null) {
            ((CacheInsertThreadsHandler) this.f4550f.get()).a(newMessageResult, deltaWithSequenceId.b);
            this.f4548d.m3964a(newMessageResult.a.b);
        }
    }
}
