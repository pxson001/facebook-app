package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger;
import com.facebook.messaging.analytics.reliability.NetworkChannel;
import com.facebook.messaging.cache.CacheFetchThreadsHandler;
import com.facebook.messaging.cache.CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider;
import com.facebook.messaging.media.prefetch.MediaPrefetchHandler;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notificationpolicy.NotificationDelayTestManager;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.NewMessageHandlerHelper;
import com.facebook.messaging.sync.delta.handlerbase.SingleThreadDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaNewMessage;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.tempcache.UncommittedThreadModificationsCache;
import com.facebook.messaging.sync.util.MessageFromDeltaFactory;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: privacy_checkup */
public class DeltaNewMessageHandler extends SingleThreadDeltaHandler {
    private static final Object f4531l = new Object();
    private final MessageFromDeltaFactory f4532a;
    private final ThriftModelUtil f4533b;
    private final Lazy<MessageSyncAnalyticsLogger> f4534c;
    private final UncommittedThreadModificationsCache f4535d;
    private final CacheFetchThreadsHandler f4536e;
    private final Provider<Boolean> f4537f;
    private final MediaPrefetchHandler f4538g;
    private final NotificationDelayTestManager f4539h;
    private final AggregatedReliabilityLogger f4540i;
    private final Provider<String> f4541j;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<NewMessageHandlerHelper> f4542k = UltralightRuntime.b;

    private static DeltaNewMessageHandler m4104b(InjectorLike injectorLike) {
        DeltaNewMessageHandler deltaNewMessageHandler = new DeltaNewMessageHandler(MessageFromDeltaFactory.m4243a(injectorLike), ThriftModelUtil.m4260a(injectorLike), IdBasedLazy.a(injectorLike, 11051), UncommittedThreadModificationsCache.m4224a(injectorLike), CacheFetchThreadsHandler_FacebookMessagesMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4202), MediaPrefetchHandler.m3132b(injectorLike), NotificationDelayTestManager.m3279a(injectorLike), AggregatedReliabilityLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 4443));
        deltaNewMessageHandler.f4542k = IdBasedLazy.a(injectorLike, 8502);
        return deltaNewMessageHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaNewMessageHandler m4103a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4531l;	 Catch:{ all -> 0x006c }
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
        r1 = m4104b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4531l;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaNewMessageHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaNewMessageHandler) r0;	 Catch:{  }
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
        r0 = f4531l;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaNewMessageHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaNewMessageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaNewMessageHandler");
    }

    @Inject
    public DeltaNewMessageHandler(MessageFromDeltaFactory messageFromDeltaFactory, ThriftModelUtil thriftModelUtil, Lazy<MessageSyncAnalyticsLogger> lazy, UncommittedThreadModificationsCache uncommittedThreadModificationsCache, CacheFetchThreadsHandler cacheFetchThreadsHandler, Provider<Boolean> provider, MediaPrefetchHandler mediaPrefetchHandler, NotificationDelayTestManager notificationDelayTestManager, AggregatedReliabilityLogger aggregatedReliabilityLogger, Provider<String> provider2) {
        super(lazy);
        this.f4532a = messageFromDeltaFactory;
        this.f4533b = thriftModelUtil;
        this.f4534c = lazy;
        this.f4535d = uncommittedThreadModificationsCache;
        this.f4536e = cacheFetchThreadsHandler;
        this.f4537f = provider;
        this.f4538g = mediaPrefetchHandler;
        this.f4539h = notificationDelayTestManager;
        this.f4540i = aggregatedReliabilityLogger;
        this.f4541j = provider2;
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        return ImmutableSet.of(this.f4533b.m4262a(deltaWrapper.d().messageMetadata.threadKey));
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return true;
    }

    public final Bundle mo125a(ThreadSummary threadSummary, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaNewMessage d = ((DeltaWrapper) deltaWithSequenceId.a).d();
        this.f4539h.m3282a(d.messageMetadata.actorFbId, d.messageMetadata.messageId);
        return m4105a(threadSummary, d, deltaWithSequenceId.b);
    }

    final Bundle m4105a(ThreadSummary threadSummary, DeltaNewMessage deltaNewMessage, long j) {
        Message a;
        long j2 = -1;
        Message a2 = this.f4535d.m4228a(Long.toString(deltaNewMessage.messageMetadata.offlineThreadingId.longValue()));
        if (a2 == null) {
            a = this.f4532a.m4250a(deltaNewMessage, threadSummary);
        } else {
            a = a2;
        }
        NewMessageResult a3 = ((NewMessageHandlerHelper) this.f4542k.get()).m3992a(a, j, false);
        if (a3.a == null) {
            String str = deltaNewMessage.messageMetadata.messageId;
            String threadKey = deltaNewMessage.messageMetadata.threadKey.toString();
            long longValue = deltaNewMessage.messageMetadata.timestamp != null ? deltaNewMessage.messageMetadata.timestamp.longValue() : -1;
            if (deltaNewMessage.messageMetadata.offlineThreadingId != null) {
                j2 = deltaNewMessage.messageMetadata.offlineThreadingId.longValue();
            }
            ((MessageSyncAnalyticsLogger) this.f4534c.get()).a(str, threadKey, longValue, j2);
        }
        this.f4538g.m3135a(a);
        Bundle bundle = new Bundle();
        bundle.putParcelable("newMessageResult", a3);
        return bundle;
    }

    public final void m4108a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        m4109a(((DeltaWrapper) deltaWithSequenceId.a).d(), (NewMessageResult) bundle.getParcelable("newMessageResult"), deltaWithSequenceId.b);
    }

    final void m4109a(DeltaNewMessage deltaNewMessage, NewMessageResult newMessageResult, long j) {
        TriState triState = TriState.UNSET;
        if (((Boolean) this.f4537f.get()).booleanValue()) {
            triState = TriState.valueOf(deltaNewMessage.messageMetadata.shouldBuzzDevice);
        }
        ((NewMessageHandlerHelper) this.f4542k.get()).m3993a(newMessageResult, j, triState);
        if (deltaNewMessage.messageMetadata.actorFbId.toString().equals(this.f4541j.get())) {
            this.f4540i.a(NetworkChannel.GRAPH, deltaNewMessage.messageMetadata.offlineThreadingId.toString(), true);
        }
    }
}
