package com.facebook.orca.push;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.base.userscope.UserScopedCrossProcessBroadcastManager;
import com.facebook.common.init.AppInitLock;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.reliability.MessageItemLogger;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.notify.FriendInstallNotification;
import com.facebook.messaging.notify.MessageRequestNotification;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.NewMessageNotificationHandler;
import com.facebook.messaging.notify.PaymentNotification;
import com.facebook.messaging.notify.PromotionNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.messaging.notify.StaleNotification;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.quickpromotion.filter.QuickPromotionThreadActivityEvent;
import com.facebook.quickpromotion.filter.QuickPromotionUserEvent;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: new_fb_locale */
public class MessagesPushHandler implements NewMessageNotificationHandler {
    private static volatile MessagesPushHandler f6306j;
    private final Provider<String> f6307a;
    public final Provider<MessagesNotificationClient> f6308b;
    private final Provider<MessageUtil> f6309c;
    private final DefaultBlueServiceOperationFactory f6310d;
    private final AppInitLock f6311e;
    private final MessageItemLogger f6312f;
    private final UiCounters f6313g;
    private final MessagesReliabilityLogger f6314h;
    private final QuickPromotionThreadActivityEvent f6315i;

    public static com.facebook.orca.push.MessagesPushHandler m5978a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6306j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.push.MessagesPushHandler.class;
        monitor-enter(r1);
        r0 = f6306j;	 Catch:{ all -> 0x003a }
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
        r0 = m5980b(r0);	 Catch:{ all -> 0x0035 }
        f6306j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6306j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.push.MessagesPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.push.MessagesPushHandler");
    }

    private static MessagesPushHandler m5980b(InjectorLike injectorLike) {
        return new MessagesPushHandler(IdBasedProvider.a(injectorLike, 4443), IdBasedProvider.a(injectorLike, 8006), IdBasedProvider.a(injectorLike, 2664), DefaultBlueServiceOperationFactory.b(injectorLike), AppInitLock.a(injectorLike), MessageItemLogger.a(injectorLike), UiCounters.a(injectorLike), MessagesReliabilityLogger.b(injectorLike), QuickPromotionThreadActivityEvent.b(injectorLike));
    }

    @Inject
    public MessagesPushHandler(Provider<String> provider, Provider<MessagesNotificationClient> provider2, Provider<MessageUtil> provider3, BlueServiceOperationFactory blueServiceOperationFactory, AppInitLock appInitLock, MessageItemLogger messageItemLogger, UiCounters uiCounters, MessagesReliabilityLogger messagesReliabilityLogger, QuickPromotionThreadActivityEvent quickPromotionThreadActivityEvent) {
        this.f6308b = provider2;
        this.f6309c = provider3;
        this.f6310d = blueServiceOperationFactory;
        this.f6311e = appInitLock;
        this.f6312f = messageItemLogger;
        this.f6313g = uiCounters;
        this.f6314h = messagesReliabilityLogger;
        this.f6315i = quickPromotionThreadActivityEvent;
        this.f6307a = provider;
    }

    public final void m5986a(NewMessageNotification newMessageNotification, long j) {
        this.f6311e.b();
        Bundle bundle = new Bundle();
        bundle.putLong("prevLastVisibleActionId", j);
        bundle.putParcelable("message", newMessageNotification.c);
        bundle.putParcelable("pushProperty", newMessageNotification.g);
        BlueServiceOperationFactoryDetour.a(this.f6310d, "pushed_message", bundle, -170931697).a(true).a();
        m5985a(newMessageNotification);
    }

    public final void m5985a(NewMessageNotification newMessageNotification) {
        this.f6311e.b();
        MessagesReliabilityLogger messagesReliabilityLogger = this.f6314h;
        String str = newMessageNotification.c.a;
        ThreadKey threadKey = newMessageNotification.c.b;
        String str2 = newMessageNotification.c.n;
        String pushSource = newMessageNotification.g.a.toString();
        if (!((Boolean) messagesReliabilityLogger.g.get()).booleanValue()) {
            Map a = LoggerMapUtils.a(new String[]{"source", pushSource, "message_id", str});
            MessagesReliabilityLogger.a(a, threadKey);
            if (str2 != null) {
                a.put("offline_threading_id", str2);
            }
            messagesReliabilityLogger.f.a("messaging_received", null, a, null, null, null);
        }
        if (newMessageNotification.b != null) {
            m5981b(newMessageNotification);
            m5979a(newMessageNotification.c);
            this.f6312f.a(newMessageNotification.c);
        }
    }

    public final void m5983a(FriendInstallNotification friendInstallNotification) {
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.c);
        intent.putExtra("notification", friendInstallNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    public final void m5987a(PaymentNotification paymentNotification) {
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.d);
        intent.putExtra("notification", paymentNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    public final void m5989a(ReadThreadNotification readThreadNotification) {
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.h);
        intent.putExtra("notification", readThreadNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    public final void m5988a(PromotionNotification promotionNotification) {
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.s);
        intent.putExtra("notification", promotionNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    public final void m5990a(StaleNotification staleNotification) {
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.t);
        intent.putExtra("notification", staleNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    public final void m5984a(MessageRequestNotification messageRequestNotification) {
        MessagesNotificationClient messagesNotificationClient = (MessagesNotificationClient) this.f6308b.get();
        Intent intent = new Intent(MessagesNotificationIntents.u);
        intent.putExtra("notification", messageRequestNotification);
        ((UserScopedCrossProcessBroadcastManager) messagesNotificationClient.b.get()).a(intent, messagesNotificationClient.a);
    }

    private void m5981b(NewMessageNotification newMessageNotification) {
        if (m5982b(newMessageNotification.c)) {
            this.f6314h.a(newMessageNotification.c.a, newMessageNotification.c.b, newMessageNotification.g.a.toString(), newMessageNotification.g.b, "from_viewer");
            return;
        }
        this.f6309c.get();
        if (!MessageUtil.t(newMessageNotification.c) || ((MessageUtil) this.f6309c.get()).w(newMessageNotification.c)) {
            ((MessagesNotificationClient) this.f6308b.get()).a(newMessageNotification);
        }
    }

    private void m5979a(Message message) {
        if (!m5982b(message) && QuickPromotionUserEvent.MESSAGE_RECEIVED != null) {
            this.f6313g.c(QuickPromotionUserEvent.MESSAGE_RECEIVED.toEventName());
            if (message != null && message.b != null && message.b.a == Type.ONE_TO_ONE) {
                this.f6315i.a(message.b.d);
            }
        }
    }

    private boolean m5982b(Message message) {
        return Objects.equal(UserKey.b((String) this.f6307a.get()), message.e.b);
    }
}
