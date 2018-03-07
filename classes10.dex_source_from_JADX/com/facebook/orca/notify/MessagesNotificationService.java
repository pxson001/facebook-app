package com.facebook.orca.notify;

import android.content.Intent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.CalleeReadyNotification;
import com.facebook.messaging.notify.FailedToSendMessageNotification;
import com.facebook.messaging.notify.FriendInstallNotification;
import com.facebook.messaging.notify.IncomingCallNotification;
import com.facebook.messaging.notify.JoinRequestNotification;
import com.facebook.messaging.notify.LoggedOutMessageNotification;
import com.facebook.messaging.notify.MessageRequestNotification;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.messaging.notify.MissedCallNotification;
import com.facebook.messaging.notify.MultipleAccountsNewMessagesNotification;
import com.facebook.messaging.notify.NewBuildNotification;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.PaymentNotification;
import com.facebook.messaging.notify.PromotionNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.messaging.notify.SimpleMessageNotification;
import com.facebook.messaging.notify.StaleNotification;
import com.facebook.messaging.notify.TincanMessageRequestNotification;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: no_megaphone */
public class MessagesNotificationService extends FbIntentService {
    private static final PrefKey f6242a = ((PrefKey) MessagingPrefKeys.a.a("debug_messenger_notificaiton_service_last_intent_action"));
    private static final PrefKey f6243b = ((PrefKey) MessagingPrefKeys.a.a("debug_messenger_notificaiton_service_last_intent_timestamp"));
    private MessagesNotificationManager f6244c;
    private Lazy<FbErrorReporter> f6245d;
    private FbSharedPreferences f6246e;
    private MonotonicClock f6247f;

    public MessagesNotificationService() {
        super("MessagesNotificationService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 650439343);
        super.onCreate();
        FbInjector a2 = a();
        this.f6244c = MessagesNotificationManager.a(a2);
        this.f6245d = IdBasedSingletonScopeProvider.b(a2, 494);
        this.f6246e = (FbSharedPreferences) FbSharedPreferencesImpl.a(a2);
        this.f6247f = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(a2);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 684790680, a);
    }

    protected final void m5950a(Intent intent) {
        AppInitLockHelper.a(this);
        if (intent == null) {
            m5949b();
            return;
        }
        String action = intent.getAction();
        this.f6246e.edit().a(f6242a, action).a(f6243b, this.f6247f.now()).commit();
        if (MessagesNotificationIntents.a.equals(action)) {
            NewMessageNotification newMessageNotification;
            try {
                newMessageNotification = (NewMessageNotification) intent.getParcelableExtra("notification");
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f6245d.get()).a("invalid_notification_parcelable", e);
                newMessageNotification = null;
            }
            if (newMessageNotification != null) {
                this.f6244c.a(newMessageNotification);
            }
        } else if (MessagesNotificationIntents.b.equals(action)) {
            this.f6244c.a((FailedToSendMessageNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.c.equals(action)) {
            this.f6244c.a((FriendInstallNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.d.equals(action)) {
            this.f6244c.a((PaymentNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.e.equals(action)) {
            this.f6244c.a((MissedCallNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.f.equals(action)) {
            this.f6244c.a((IncomingCallNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.g.equals(action)) {
            this.f6244c.a((CalleeReadyNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.h.equals(action)) {
            this.f6244c.a((ReadThreadNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.i.equals(action)) {
            this.f6244c.a((NewBuildNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.j.equals(action)) {
            this.f6244c.a((LoggedOutMessageNotification) intent.getParcelableExtra("notification"));
        } else if ("ACTION_MQTT_NO_AUTH".equals(action)) {
            this.f6244c.a();
        } else if (MessagesNotificationIntents.k.equals(action)) {
            r0 = ThreadKey.a(intent.getStringExtra("thread_key_string"));
            if (r0 != null) {
                this.f6244c.a(r0, "notification");
            }
        } else if (MessagesNotificationIntents.l.equals(action)) {
            r0 = ThreadKey.a(intent.getStringExtra("thread_key_string"));
            if (r0 != null) {
                this.f6244c.b(r0, "notification");
            }
        } else if (MessagesNotificationIntents.p.equals(action)) {
            this.f6244c.a(intent.getStringExtra("user_id"));
        } else if (MessagesNotificationIntents.m.equals(action)) {
            this.f6244c.b();
        } else if (MessagesNotificationIntents.q.equals(action)) {
            this.f6244c.a(intent.getStringArrayListExtra("multiple_accounts_user_ids"));
        } else if (MessagesNotificationIntents.o.equals(action)) {
            this.f6244c.b("notification");
        } else if (MessagesNotificationIntents.r.equals(action)) {
            this.f6244c.a((FolderCounts) intent.getParcelableExtra("folder_counts"));
        } else if (MessagesNotificationIntents.s.equals(action)) {
            this.f6244c.a((PromotionNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.t.equals(action)) {
            this.f6244c.a((StaleNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.u.equals(action)) {
            this.f6244c.a((MessageRequestNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.v.equals(action)) {
            this.f6244c.a((TincanMessageRequestNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.n.equals(action)) {
            this.f6244c.c();
        } else if (MessagesNotificationIntents.w.equals(action)) {
            this.f6244c.b((SimpleMessageNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.x.equals(action)) {
            this.f6244c.a((SimpleMessageNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.y.equals(action)) {
            this.f6244c.a((MultipleAccountsNewMessagesNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.z.equals(action)) {
            this.f6244c.a((JoinRequestNotification) intent.getParcelableExtra("notification"));
        } else if (MessagesNotificationIntents.A.equals(action)) {
            this.f6244c.a(intent.getStringExtra("user_id"), intent.getStringExtra("user_display_name"));
        } else if (MessagesNotificationIntents.B.equals(action)) {
            this.f6244c.d();
        }
    }

    private void m5949b() {
        ((AbstractFbErrorReporter) this.f6245d.get()).a("MessagesNotificationServiceError", StringFormatUtil.formatStrLocaleSafe("Service was started with a null intent. Most Recent Intent's Action: %s,Time since last intent %s", this.f6246e.a(f6242a, "<intent not found>"), Long.valueOf(this.f6247f.now() - this.f6246e.a(f6243b, 0))));
    }
}
