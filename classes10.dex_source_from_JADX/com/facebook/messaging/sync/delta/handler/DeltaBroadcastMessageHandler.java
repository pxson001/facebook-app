package com.facebook.messaging.sync.delta.handler;

import android.os.Bundle;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.NewMessageHandlerHelper;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.delta.handlerbase.AbstractMessagesDeltaHandler;
import com.facebook.messaging.sync.model.thrift.DeltaBroadcastMessage;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.messaging.sync.model.thrift.MessageMetadata;
import com.facebook.messaging.sync.util.MessageFromDeltaFactory;
import com.facebook.messaging.sync.util.ThriftModelUtil;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@UserScoped
/* compiled from: profile_context_query_result */
public class DeltaBroadcastMessageHandler extends AbstractMessagesDeltaHandler {
    private static final Object f4469e = new Object();
    private final ThriftModelUtil f4470a;
    private final MessageFromDeltaFactory f4471b;
    private final Lazy<MessageSyncAnalyticsLogger> f4472c;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<NewMessageHandlerHelper> f4473d = UltralightRuntime.b;

    @Immutable
    /* compiled from: profile_context_query_result */
    public class HandleNewMessageInDBResult {
        public final PassReason f4467a;
        @Nullable
        public final NewMessageResult f4468b;

        public HandleNewMessageInDBResult(PassReason passReason, NewMessageResult newMessageResult) {
            this.f4467a = passReason;
            this.f4468b = newMessageResult;
        }
    }

    /* compiled from: profile_context_query_result */
    public enum PassReason {
        NOT_PASSED,
        THREAD_FETCHED,
        THREAD_NONEXISTENT
    }

    private static DeltaBroadcastMessageHandler m4035b(InjectorLike injectorLike) {
        DeltaBroadcastMessageHandler deltaBroadcastMessageHandler = new DeltaBroadcastMessageHandler(ThriftModelUtil.m4260a(injectorLike), MessageFromDeltaFactory.m4243a(injectorLike), IdBasedLazy.a(injectorLike, 11051));
        deltaBroadcastMessageHandler.f4473d = IdBasedLazy.a(injectorLike, 8502);
        return deltaBroadcastMessageHandler;
    }

    @Inject
    public DeltaBroadcastMessageHandler(ThriftModelUtil thriftModelUtil, MessageFromDeltaFactory messageFromDeltaFactory, Lazy<MessageSyncAnalyticsLogger> lazy) {
        this.f4470a = thriftModelUtil;
        this.f4471b = messageFromDeltaFactory;
        this.f4472c = lazy;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.handler.DeltaBroadcastMessageHandler m4034a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4469e;	 Catch:{ all -> 0x006c }
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
        r1 = m4035b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4469e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaBroadcastMessageHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaBroadcastMessageHandler) r0;	 Catch:{  }
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
        r0 = f4469e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.handler.DeltaBroadcastMessageHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.handler.DeltaBroadcastMessageHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.handler.DeltaBroadcastMessageHandler");
    }

    public final ImmutableSet<ThreadKey> mo126a(DeltaWrapper deltaWrapper) {
        List<MessageMetadata> list = deltaWrapper.t().messageMetadatas;
        Builder builder = ImmutableSet.builder();
        for (MessageMetadata messageMetadata : list) {
            builder.c(this.f4470a.m4262a(messageMetadata.threadKey));
        }
        return builder.b();
    }

    public final boolean mo127b(DeltaWrapper deltaWrapper) {
        return true;
    }

    public final Bundle mo124a(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaBroadcastMessage t = ((DeltaWrapper) deltaWithSequenceId.a).t();
        List<MessageMetadata> list = t.messageMetadatas;
        ArrayList a = Lists.a();
        int i = 0;
        int i2 = 0;
        for (MessageMetadata a2 : list) {
            HandleNewMessageInDBResult a3 = m4033a(a2, prefetchedSyncData, t, deltaWithSequenceId.b);
            switch (a3.f4467a) {
                case THREAD_FETCHED:
                    i2++;
                    break;
                case THREAD_NONEXISTENT:
                    i++;
                    break;
                case NOT_PASSED:
                    a.add(a3.f4468b);
                    break;
                default:
                    break;
            }
        }
        if (!(i2 == 0 && i == 0)) {
            MessageSyncAnalyticsLogger messageSyncAnalyticsLogger = (MessageSyncAnalyticsLogger) this.f4472c.get();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sync_broadcast_thread_passed_over");
            honeyClientEvent.a("num_passed_because_of_fetch", i2);
            honeyClientEvent.a("num_passed_because_of_nonexistent", i);
            messageSyncAnalyticsLogger.a.a(honeyClientEvent, IrisQueueTypes.MESSAGES_QUEUE_TYPE);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("newMessageResults", a);
        return bundle;
    }

    private HandleNewMessageInDBResult m4033a(MessageMetadata messageMetadata, PrefetchedSyncData prefetchedSyncData, DeltaBroadcastMessage deltaBroadcastMessage, long j) {
        ThreadKey a = this.f4470a.m4262a(messageMetadata.threadKey);
        ThreadSummary a2 = prefetchedSyncData.m3994a(a);
        if (prefetchedSyncData.f4426c.contains(a)) {
            return new HandleNewMessageInDBResult(PassReason.THREAD_FETCHED, null);
        }
        if (prefetchedSyncData.f4427d.contains(a)) {
            return new HandleNewMessageInDBResult(PassReason.THREAD_NONEXISTENT, null);
        }
        return new HandleNewMessageInDBResult(PassReason.NOT_PASSED, ((NewMessageHandlerHelper) this.f4473d.get()).m3992a(this.f4471b.m4249a(deltaBroadcastMessage, messageMetadata, a2), j, false));
    }

    public final void m4038a(Bundle bundle, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("newMessageResults");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            int size = parcelableArrayList.size();
            for (int i = 0; i < size; i++) {
                ((NewMessageHandlerHelper) this.f4473d.get()).m3993a((NewMessageResult) parcelableArrayList.get(i), deltaWithSequenceId.b, TriState.UNSET);
            }
        }
    }
}
