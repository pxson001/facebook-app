package com.facebook.messaging.sync.delta;

import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.deliveryreceipt.DefaultSendDeliveryReceiptManager;
import com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptManager;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.NewMessageNotificationHandler;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.MessagesSyncDbHandler;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache.DeletedMessages;
import com.facebook.messaging.sync.model.thrift.SyncPayload;
import com.facebook.orca.push.MessagesPushHandler;
import com.facebook.sync.delta.DeltaEnsuredDataFetcher;
import com.facebook.sync.delta.SyncPayloadHandler;
import com.facebook.sync.delta.SyncPayloadHandler.DbResult;
import com.facebook.sync.delta.SyncPayloadHandler.SyncPayloadHandlerCallback;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Provider;

@UserScoped
/* compiled from: profile_share_closed */
public class MessagesSyncPayloadHandler implements SyncPayloadHandlerCallback {
    private static final Object f4402o = new Object();
    private final MessagesSyncDbHandler f4403a;
    private final MessagesDeltaHandlerSupplier f4404b;
    private final SyncPayloadHandler f4405c;
    public final DeltaUiChangesCache f4406d;
    public final NewMessageNotificationHandler f4407e;
    public final MessagesBroadcaster f4408f;
    public final MessagesNotificationClient f4409g;
    public final Provider<DataCache> f4410h;
    private final DefaultSendDeliveryReceiptManager f4411i;
    private final MessageUtil f4412j;
    private final MessagesDeltaNoOpSniffer f4413k;
    private final Product f4414l;
    @Inject
    @Lazy
    @FacebookMessages
    public com.facebook.inject.Lazy<CacheInsertThreadsHandler> f4415m = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessagesDeltaEnsuredDataFetcher> f4416n = UltralightRuntime.b;

    private static MessagesSyncPayloadHandler m3984b(InjectorLike injectorLike) {
        MessagesSyncPayloadHandler messagesSyncPayloadHandler = new MessagesSyncPayloadHandler(MessagesSyncDbHandler.m3882a(injectorLike), MessagesDeltaHandlerSupplier.m3974a(injectorLike), SyncPayloadHandler.a(injectorLike), DeltaUiChangesCache.m3961a(injectorLike), (NewMessageNotificationHandler) MessagesPushHandler.m5978a(injectorLike), MessagesBroadcaster.a(injectorLike), MessagesNotificationClient.a(injectorLike), IdBasedProvider.a(injectorLike, 2567), DefaultSendDeliveryReceiptManager.b(injectorLike), MessageUtil.a(injectorLike), MessagesDeltaNoOpSniffer.m3979a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 7693);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 8498);
        messagesSyncPayloadHandler.f4415m = a;
        messagesSyncPayloadHandler.f4416n = a2;
        return messagesSyncPayloadHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.delta.MessagesSyncPayloadHandler m3982a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4402o;	 Catch:{ all -> 0x006c }
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
        r1 = m3984b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4402o;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.MessagesSyncPayloadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.delta.MessagesSyncPayloadHandler) r0;	 Catch:{  }
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
        r0 = f4402o;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.delta.MessagesSyncPayloadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.delta.MessagesSyncPayloadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.delta.MessagesSyncPayloadHandler");
    }

    @Inject
    private MessagesSyncPayloadHandler(MessagesSyncDbHandler messagesSyncDbHandler, MessagesDeltaHandlerSupplier messagesDeltaHandlerSupplier, SyncPayloadHandler syncPayloadHandler, DeltaUiChangesCache deltaUiChangesCache, NewMessageNotificationHandler newMessageNotificationHandler, MessagesBroadcaster messagesBroadcaster, MessagesNotificationClient messagesNotificationClient, Provider<DataCache> provider, SendDeliveryReceiptManager sendDeliveryReceiptManager, MessageUtil messageUtil, MessagesDeltaNoOpSniffer messagesDeltaNoOpSniffer, Product product) {
        this.f4403a = messagesSyncDbHandler;
        this.f4404b = messagesDeltaHandlerSupplier;
        this.f4405c = syncPayloadHandler;
        this.f4406d = deltaUiChangesCache;
        this.f4407e = newMessageNotificationHandler;
        this.f4408f = messagesBroadcaster;
        this.f4409g = messagesNotificationClient;
        this.f4410h = provider;
        this.f4411i = sendDeliveryReceiptManager;
        this.f4412j = messageUtil;
        this.f4413k = messagesDeltaNoOpSniffer;
        this.f4414l = product;
    }

    public final void m3988a(SyncPayload syncPayload, FbTraceNode fbTraceNode) {
        UserKey a = this.f4412j.a();
        if (a == null) {
            throw new Exception("No user is logged in!");
        }
        DbResult a2 = this.f4405c.a(IrisQueueTypes.MESSAGES_QUEUE_TYPE, syncPayload.deltas, syncPayload.firstDeltaSeqId.longValue(), this.f4413k, (DeltaEnsuredDataFetcher) this.f4416n.get(), this.f4403a, this.f4404b, fbTraceNode, this);
        if (Objects.equal(a, this.f4412j.a())) {
            m3983a(a2);
            return;
        }
        throw new Exception("Logged in user has changed during delta processing!");
    }

    private void m3983a(DbResult dbResult) {
        Builder builder = ImmutableList.builder();
        if (this.f4414l != Product.PAA) {
            ImmutableMap b = ImmutableSortedMap.b(dbResult.a, (Ordering) ImmutableSortedMap.a);
            UserKey a = this.f4412j.a();
            if (a != null) {
                String b2 = a.b();
                Iterator it = b.values().iterator();
                while (it.hasNext()) {
                    NewMessageResult newMessageResult = (NewMessageResult) ((Bundle) it.next()).getParcelable("newMessageResult");
                    if (newMessageResult != null) {
                        Message message = newMessageResult.a;
                        if (!(message == null || message.b == null || message.e == null || b2.equals(message.e.b.b()))) {
                            builder.c(message);
                        }
                    }
                }
                ImmutableList b3 = builder.b();
                if (!b3.isEmpty()) {
                    this.f4411i.a(b3);
                }
            }
        }
    }

    public final void m3987a() {
        ((CacheInsertThreadsHandler) this.f4415m.get()).a();
        this.f4408f.a();
    }

    public final void m3989b() {
        DeltaUiChangesCache deltaUiChangesCache = this.f4406d;
        Builder builder = ImmutableList.builder();
        for (List b : deltaUiChangesCache.f4353b.values()) {
            builder.b(b);
        }
        for (NewMessageNotification a : builder.b()) {
            this.f4407e.a(a);
        }
        m3985d();
        this.f4406d.m3968e();
    }

    private void m3985d() {
        List<ThreadKey> copyOf = ImmutableList.copyOf(this.f4406d.f4354c);
        for (ThreadKey threadKey : copyOf) {
            this.f4408f.c(threadKey);
            ThreadSummary a = ((DataCache) this.f4410h.get()).a(threadKey);
            if (a != null) {
                this.f4409g.a(a.a);
            }
        }
        if (!copyOf.isEmpty()) {
            this.f4408f.b();
        }
        m3986f();
        ImmutableList copyOf2 = ImmutableList.copyOf(this.f4406d.f4357f.values());
        int size = copyOf2.size();
        for (int i = 0; i < size; i++) {
            DeletedMessages deletedMessages = (DeletedMessages) copyOf2.get(i);
            this.f4408f.a(deletedMessages.f4348a, ImmutableList.copyOf(deletedMessages.f4349b), ImmutableList.copyOf(deletedMessages.f4350c));
        }
    }

    private void m3986f() {
        DeltaUiChangesCache deltaUiChangesCache = this.f4406d;
        Map c = Maps.c();
        Bundle bundle = new Bundle();
        for (ThreadKey put : deltaUiChangesCache.f4353b.keySet()) {
            c.put(put, bundle);
        }
        for (ThreadKey put2 : deltaUiChangesCache.f4357f.keySet()) {
            c.put(put2, bundle);
        }
        c.putAll(deltaUiChangesCache.f4358g);
        c.putAll(deltaUiChangesCache.f4356e);
        for (Entry entry : deltaUiChangesCache.f4355d.entrySet()) {
            ThreadKey threadKey = (ThreadKey) entry.getKey();
            Bundle bundle2 = (Bundle) entry.getValue();
            Bundle bundle3 = (Bundle) deltaUiChangesCache.f4356e.get(threadKey);
            if (bundle3 == null || bundle3.getLong("sequence_id") <= bundle2.getLong("sequence_id")) {
                c.put(threadKey, bundle2);
            }
        }
        Iterator it = ImmutableMap.copyOf(c).entrySet().iterator();
        while (it.hasNext()) {
            Entry entry2 = (Entry) it.next();
            this.f4408f.a((ThreadKey) entry2.getKey(), (Bundle) entry2.getValue());
        }
    }
}
