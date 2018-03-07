package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger;
import com.facebook.messaging.analytics.reliability.NetworkChannel;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notificationpolicy.NotificationPolicyEngine;
import com.facebook.messaging.notificationpolicy.NotificationPolicyMessageCheck;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.client.SendMessageManager.8;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.util.MessageFromDeltaFactory;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;

@UserScoped
/* compiled from: preview_id */
public class DeltaSentMessageHandler extends SingleThreadDeltaHandler {
    private static final Object f4589k = new Object();
    private final DbInsertThreadsHandler f4590a;
    private final MessageFromDeltaFactory f4591b;
    private final ThriftModelUtil f4592c;
    private final DeltaUiChangesCache f4593d;
    private final NotificationPolicyEngine f4594e;
    private final MessagesBroadcaster f4595f;
    private final SendMessageManager f4596g;
    private final AggregatedReliabilityLogger f4597h;
    private final GatekeeperStoreImpl f4598i;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4599j = UltralightRuntime.b;

    private static DeltaSentMessageHandler m4157b(InjectorLike injectorLike) {
        DeltaSentMessageHandler deltaSentMessageHandler = new DeltaSentMessageHandler(DbInsertThreadsHandler.a(injectorLike), MessageFromDeltaFactory.m4243a(injectorLike), ThriftModelUtil.m4260a(injectorLike), IdBasedLazy.a(injectorLike, 11051), DeltaUiChangesCache.m3961a(injectorLike), NotificationPolicyEngine.m3311a(injectorLike), MessagesBroadcaster.a(injectorLike), SendMessageManager.a(injectorLike), AggregatedReliabilityLogger.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
        deltaSentMessageHandler.f4599j = IdBasedLazy.a(injectorLike, 7693);
        return deltaSentMessageHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaSentMessageHandler m4156a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4589k;	 Catch:{ all -> 0x006c }
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
        r1 = m4157b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4589k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaSentMessageHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaSentMessageHandler) r0;	 Catch:{  }
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
        r0 = f4589k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaSentMessageHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaSentMessageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaSentMessageHandler");
    }

    @Inject
    private DeltaSentMessageHandler(DbInsertThreadsHandler dbInsertThreadsHandler, MessageFromDeltaFactory messageFromDeltaFactory, ThriftModelUtil thriftModelUtil, com.facebook.inject.Lazy<MessageSyncAnalyticsLogger> lazy, DeltaUiChangesCache deltaUiChangesCache, NotificationPolicyEngine notificationPolicyEngine, MessagesBroadcaster messagesBroadcaster, SendMessageManager sendMessageManager, AggregatedReliabilityLogger aggregatedReliabilityLogger, GatekeeperStore gatekeeperStore) {
        super(lazy);
        this.f4590a = dbInsertThreadsHandler;
        this.f4591b = messageFromDeltaFactory;
        this.f4592c = thriftModelUtil;
        this.f4593d = deltaUiChangesCache;
        this.f4594e = notificationPolicyEngine;
        this.f4595f = messagesBroadcaster;
        this.f4596g = sendMessageManager;
        this.f4597h = aggregatedReliabilityLogger;
        this.f4598i = gatekeeperStore;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4592c.m4262a(deltaWrapper.u().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return true;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        Message a = this.f4591b.m4255a(((DeltaWrapper) deltaWithSequenceId.a).u(), threadSummary);
        Message a2 = this.f4590a.a(a, deltaWithSequenceId.b);
        Bundle bundle = new Bundle();
        bundle.putParcelable("sentMessage", a2);
        this.f4595f.a(a.a, a.n);
        return bundle;
    }

    public final void m4160a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        Message message = (Message) bundle.getParcelable("sentMessage");
        if (message != null) {
            for (NotificationPolicyMessageCheck c : this.f4594e.f3412c) {
                c.mo116c();
            }
            ((CacheInsertThreadsHandler) this.f4599j.get()).a.a(message, null, deltaWithSequenceId.b);
            this.f4593d.m3965a(message.b, deltaWithSequenceId.b);
            if (this.f4598i.a(369, false) && message.i.isEmpty()) {
                SendMessageManager sendMessageManager = this.f4596g;
                ExecutorDetour.a(sendMessageManager.d, new 8(sendMessageManager, message), -867392962);
            }
        }
        this.f4597h.a(NetworkChannel.MQTT, ((DeltaWrapper) deltaWithSequenceId.a).u().messageMetadata.offlineThreadingId.toString(), true);
    }
}
