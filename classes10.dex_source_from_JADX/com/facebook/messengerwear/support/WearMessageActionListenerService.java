package com.facebook.messengerwear.support;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInput.Builder;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.propertybag.PropertyBagHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.intents.OrcaMessagingIntentUris;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.send.client.OfflineThreadingIdGenerator;
import com.facebook.messaging.send.client.OutgoingMessageFactory;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.messengerwear.shared.ActionMessage;
import com.facebook.messengerwear.shared.MessengerWearCrypto;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Inject;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

/* compiled from: photo_fetch_start_cursor */
public class WearMessageActionListenerService extends WearableListenerService implements PropertyBag {
    private static final String f5086a = WearMessageActionListenerService.class.getSimpleName();
    private final PropertyBagHelper f5087b = new PropertyBagHelper();
    @Inject
    public SendMessageManager f5088c;
    @Inject
    private OutgoingMessageFactory f5089d;
    @Inject
    private OfflineThreadingIdGenerator f5090e;
    @Inject
    private Provider<MessagesNotificationClient> f5091f;
    @Inject
    @ForUiThread
    private ExecutorService f5092g;
    @Inject
    public MessagingPerformanceLogger f5093h;
    @Inject
    private SecureContextHelper f5094i;
    @Inject
    private OrcaMessagingIntentUris f5095j;

    private static <T extends Context> void m4568a(Class<T> cls, T t) {
        m4569a((Object) t, (Context) t);
    }

    private static void m4569a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((WearMessageActionListenerService) obj).m4567a(SendMessageManager.a(fbInjector), OutgoingMessageFactory.a(fbInjector), OfflineThreadingIdGenerator.a(fbInjector), IdBasedProvider.a(fbInjector, 8006), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), MessagingPerformanceLogger.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), OrcaMessagingIntentUris.a(fbInjector));
    }

    private void m4567a(SendMessageManager sendMessageManager, OutgoingMessageFactory outgoingMessageFactory, OfflineThreadingIdGenerator offlineThreadingIdGenerator, Provider<MessagesNotificationClient> provider, ExecutorService executorService, MessagingPerformanceLogger messagingPerformanceLogger, SecureContextHelper secureContextHelper, OrcaMessagingIntentUris orcaMessagingIntentUris) {
        this.f5088c = sendMessageManager;
        this.f5089d = outgoingMessageFactory;
        this.f5090e = offlineThreadingIdGenerator;
        this.f5091f = provider;
        this.f5092g = executorService;
        this.f5093h = messagingPerformanceLogger;
        this.f5094i = secureContextHelper;
        this.f5095j = orcaMessagingIntentUris;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1684686963);
        super.onCreate();
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1339992640, a);
    }

    public final void mo135a(MessageEvent messageEvent) {
        if (messageEvent.mo581a().endsWith("/action")) {
            m4568a(WearMessageActionListenerService.class, (Context) this);
            try {
                byte[] b = MessengerWearCrypto.m4508b(messageEvent.mo582b());
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(b, 0, b.length);
                obtain.setDataPosition(0);
                ActionMessage actionMessage = (ActionMessage) ActionMessage.CREATOR.createFromParcel(obtain);
                ThreadKey a = ThreadKey.a(actionMessage.f4942b);
                if (a == null) {
                    BLog.b(f5086a, "Error decoding Thread Key from %s", new Object[]{actionMessage.f4942b});
                    return;
                }
                switch (actionMessage.f4943c) {
                    case REPLY_STICKER:
                        m4564a(this.f5089d.b(a, actionMessage.f4941a));
                        return;
                    case REPLY_LIKE:
                        m4564a(this.f5089d.b(a, "369239263222822", Long.toString(this.f5090e.a())));
                        return;
                    case REPLY_TEXT:
                        m4564a(this.f5089d.a(a, actionMessage.f4941a));
                        return;
                    case MUTE:
                        m4566a(a, actionMessage.f4941a);
                        return;
                    case OPEN_ON_PHONE:
                        m4565a(a);
                        return;
                    default:
                        return;
                }
            } catch (Throwable e) {
                BLog.b(f5086a, "Error parsing message", e);
            }
        }
    }

    private void m4565a(ThreadKey threadKey) {
        Intent b = this.f5095j.b(threadKey);
        b.putExtra("from_notification", true);
        b.setFlags(335544320);
        this.f5094i.a(b, this);
    }

    private void m4566a(ThreadKey threadKey, String str) {
        Intent intent = new Intent();
        intent.setClassName(this, "com.facebook.messaging.mutators.ThreadNotificationsDialogActivity");
        intent.putExtra("thread_key", threadKey);
        intent.addFlags(268435456);
        Builder builder = new Builder("voice_reply");
        builder.b = "Mute";
        builder = builder;
        builder.d = false;
        RemoteInput a = builder.a();
        Bundle bundle = new Bundle();
        bundle.putString(a.a(), str);
        RemoteInput.g.a(new RemoteInput[]{a}, intent, bundle);
        this.f5094i.a(intent, this);
    }

    private void m4564a(final Message message) {
        ((MessagesNotificationClient) this.f5091f.get()).a(message.b);
        ExecutorDetour.a(this.f5092g, new Runnable(this) {
            final /* synthetic */ WearMessageActionListenerService f5084b;

            public void run() {
                this.f5084b.f5093h.a(message.n);
                this.f5084b.f5088c.a(message, "app", NavigationTrigger.b("messenger_wear_reply"), MessageSendTrigger.NEW_MESSAGE);
            }
        }, -1331925984);
    }

    public final void m4573a(Object obj, Object obj2) {
        this.f5087b.a(obj, obj2);
    }

    public final Object m4571a(Object obj) {
        return this.f5087b.a(obj);
    }
}
