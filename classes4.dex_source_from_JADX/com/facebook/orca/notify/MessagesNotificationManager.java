package com.facebook.orca.notify;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.broadcast.SafeLocalBroadcastReceiver;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.database.ContactUpdateHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.peer.MessageNotificationPeerContract;
import com.facebook.messages.ipc.peer.MessageNotificationPeerHelper;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.messaging.analytics.reliability.MessagesReliabilityLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.AlertDisposition;
import com.facebook.messaging.notify.CalleeReadyNotification;
import com.facebook.messaging.notify.FailedToSendMessageNotification;
import com.facebook.messaging.notify.FriendInstallNotification;
import com.facebook.messaging.notify.IncomingCallNotification;
import com.facebook.messaging.notify.JoinRequestNotification;
import com.facebook.messaging.notify.LoggedOutMessageNotification;
import com.facebook.messaging.notify.MessageRequestNotification;
import com.facebook.messaging.notify.MessagingNotification;
import com.facebook.messaging.notify.MessagingNotification$Type;
import com.facebook.messaging.notify.MissedCallNotification;
import com.facebook.messaging.notify.MultipleAccountsNewMessagesNotification;
import com.facebook.messaging.notify.NewBuildNotification;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.NewMessageNotification.PresenceLevel;
import com.facebook.messaging.notify.NewMessageNotificationFactory;
import com.facebook.messaging.notify.PaymentNotification;
import com.facebook.messaging.notify.PromotionNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.messaging.notify.SimpleMessageNotification;
import com.facebook.messaging.notify.StaleNotification;
import com.facebook.messaging.notify.TincanMessageRequestNotification;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.multiprocess.peer.state.PeerStateObserver;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.facebook.push.externalcloud.PrimaryPushTokenHolder;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: is_composer_capable */
public final class MessagesNotificationManager implements INeedInit {
    public static final PrefKey f10050a = ((PrefKey) MessagingPrefKeys.a.a("processed_logout_notification"));
    public static final Class<?> f10051b = MessagesNotificationManager.class;
    private static volatile MessagesNotificationManager f10052z;
    private final Context f10053c;
    private final Provider<DataCache> f10054d;
    private final Handler f10055e;
    private final StatefulPeerManagerImpl f10056f;
    private final PeerStateObserver f10057g;
    private final PeerStateObserver f10058h;
    private final boolean f10059i;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AppStateManager> f10060j = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AndroidThreadUtil> f10061k = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<Clock> f10062l = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ContactUpdateHelper> f10063m = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbSharedPreferences> f10064n = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LoggedInUserAuthDataStore> f10065o = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MessagesReliabilityLogger> f10066p = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NewMessageNotificationFactory> f10067q = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NotificationSettingsUtil> f10068r = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PrimaryPushTokenHolder> f10069s = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReliabilityAnalyticsLogger> f10070t = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Set<MessagingNotificationHandler>> f10071u = UltralightRuntime.b;
    @Inject
    @LoggedInUserId
    private Provider<String> f10072v;
    @GuardedBy("itself")
    private final Map<String, AlertDisposition> f10073w = Maps.c();
    private volatile long f10074x;
    private volatile FolderCounts f10075y;

    /* compiled from: is_composer_capable */
    class C04531 implements PeerStateObserver {
        final /* synthetic */ MessagesNotificationManager f10076a;

        C04531(MessagesNotificationManager messagesNotificationManager) {
            this.f10076a = messagesNotificationManager;
        }

        public final void m10553a(Uri uri, boolean z) {
            if (!z) {
                Class cls = MessagesNotificationManager.f10051b;
                ThreadKey a = ThreadKey.a(Uri.decode(uri.getLastPathSegment()));
                if (a != null) {
                    this.f10076a.m10526a(a, "peerstate:" + uri);
                }
            }
        }
    }

    /* compiled from: is_composer_capable */
    class C04542 implements PeerStateObserver {
        final /* synthetic */ MessagesNotificationManager f10077a;

        C04542(MessagesNotificationManager messagesNotificationManager) {
            this.f10077a = messagesNotificationManager;
        }

        public final void m10554a(Uri uri, boolean z) {
            if (!z) {
                Class cls = MessagesNotificationManager.f10051b;
                this.f10077a.m10550b("peerstate:" + uri);
            }
        }
    }

    public static com.facebook.orca.notify.MessagesNotificationManager m10507a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10052z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.MessagesNotificationManager.class;
        monitor-enter(r1);
        r0 = f10052z;	 Catch:{ all -> 0x003a }
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
        r0 = m10514b(r0);	 Catch:{ all -> 0x0035 }
        f10052z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10052z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.MessagesNotificationManager.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.MessagesNotificationManager");
    }

    private static MessagesNotificationManager m10514b(InjectorLike injectorLike) {
        MessagesNotificationManager messagesNotificationManager = new MessagesNotificationManager((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 2567), StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
        messagesNotificationManager.m10508a(IdBasedSingletonScopeProvider.b(injectorLike, 476), IdBasedLazy.a(injectorLike, 517), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedSingletonScopeProvider.b(injectorLike, 910), IdBasedSingletonScopeProvider.b(injectorLike, 3078), IdBasedSingletonScopeProvider.b(injectorLike, 339), IdBasedLazy.a(injectorLike, 7514), IdBasedLazy.a(injectorLike, 2673), IdBasedLazy.a(injectorLike, 2906), IdBasedLazy.a(injectorLike, 9743), IdBasedSingletonScopeProvider.b(injectorLike, 144), STATICDI_MULTIBIND_PROVIDER$MessagingNotificationHandler.m10555a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
        return messagesNotificationManager;
    }

    private void m10519b(ReadThreadNotification readThreadNotification) {
        Iterator it = readThreadNotification.a.keySet().iterator();
        while (it.hasNext()) {
            MessageNotificationPeerHelper.a((ThreadKey) it.next(), this.f10056f);
        }
        m10511a((MessagingNotification) readThreadNotification);
    }

    private void m10515b(FriendInstallNotification friendInstallNotification) {
        String pushSource = friendInstallNotification.e.a.toString();
        String str = friendInstallNotification.e.b;
        String str2 = "10003";
        if (((LoggedInUserSessionManager) this.f10065o.get()).b()) {
            ((ContactUpdateHelper) this.f10063m.get()).m12220a(friendInstallNotification.a, true);
            if (((FbSharedPreferences) this.f10064n.get()).a(MessagingPrefKeys.ac, true) && m10523k()) {
                String str3;
                m10511a((MessagingNotification) friendInstallNotification);
                if (friendInstallNotification.f) {
                    str3 = "user_alerted_";
                } else {
                    str3 = "user_not_alerted_";
                }
                ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, str, str2, str3);
                return;
            }
            ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, str, str2, "notifications_disabled");
            return;
        }
        ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, str, str2, "logged_out_user");
    }

    private void m10511a(MessagingNotification messagingNotification) {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.m2453a(messagingNotification);
        }
        for (AbstractMessagingNotificationHandler a2 : (Set) this.f10071u.get()) {
            if (!messagingNotification.a) {
                a2.m2468b(messagingNotification);
            } else {
                return;
            }
        }
    }

    final void m10526a(ThreadKey threadKey, String str) {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.mo155a(threadKey, str);
        }
        MessageNotificationPeerHelper.a(threadKey, this.f10056f);
    }

    final void m10544a(String str) {
        for (AbstractMessagingNotificationHandler b : (Set) this.f10071u.get()) {
            b.mo187b(str);
        }
    }

    final void m10546a(List<String> list) {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.mo185a((List) list);
        }
    }

    final void m10547b() {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.mo174a(MessagingNotification$Type.NEW_BUILD);
        }
    }

    final void m10548b(ThreadKey threadKey, String str) {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.mo169a(threadKey);
        }
    }

    final void m10550b(String str) {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.mo158a(str);
        }
    }

    final void m10551c() {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.mo174a(MessagingNotification$Type.TINCAN_MESSAGE_REQUEST);
        }
    }

    final void m10552d() {
        for (AbstractMessagingNotificationHandler a : (Set) this.f10071u.get()) {
            a.mo168a();
        }
    }

    @Inject
    private MessagesNotificationManager(Context context, Provider<DataCache> provider, StatefulPeerManager statefulPeerManager, Boolean bool) {
        this.f10053c = context;
        this.f10054d = provider;
        this.f10055e = new Handler(Looper.getMainLooper());
        this.f10056f = statefulPeerManager;
        this.f10059i = bool.booleanValue();
        this.f10057g = new C04531(this);
        this.f10058h = new C04542(this);
    }

    private void m10508a(com.facebook.inject.Lazy<AppStateManager> lazy, com.facebook.inject.Lazy<AndroidThreadUtil> lazy2, com.facebook.inject.Lazy<Clock> lazy3, com.facebook.inject.Lazy<ContactUpdateHelper> lazy4, com.facebook.inject.Lazy<FbSharedPreferences> lazy5, com.facebook.inject.Lazy<LoggedInUserAuthDataStore> lazy6, com.facebook.inject.Lazy<MessagesReliabilityLogger> lazy7, com.facebook.inject.Lazy<NewMessageNotificationFactory> lazy8, com.facebook.inject.Lazy<NotificationSettingsUtil> lazy9, com.facebook.inject.Lazy<PrimaryPushTokenHolder> lazy10, com.facebook.inject.Lazy<ReliabilityAnalyticsLogger> lazy11, com.facebook.inject.Lazy<Set<MessagingNotificationHandler>> lazy12, Provider<String> provider) {
        this.f10060j = lazy;
        this.f10061k = lazy2;
        this.f10062l = lazy3;
        this.f10063m = lazy4;
        this.f10064n = lazy5;
        this.f10065o = lazy6;
        this.f10066p = lazy7;
        this.f10067q = lazy8;
        this.f10068r = lazy9;
        this.f10069s = lazy10;
        this.f10070t = lazy11;
        this.f10071u = lazy12;
        this.f10072v = provider;
    }

    final void m10537a(NewMessageNotification newMessageNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10517b(newMessageNotification);
    }

    final void m10541a(SimpleMessageNotification simpleMessageNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) simpleMessageNotification);
    }

    final void m10549b(SimpleMessageNotification simpleMessageNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) simpleMessageNotification);
    }

    final void m10528a(FailedToSendMessageNotification failedToSendMessageNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) failedToSendMessageNotification);
    }

    final void m10532a(LoggedOutMessageNotification loggedOutMessageNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10516b(loggedOutMessageNotification);
    }

    final void m10524a() {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10521g();
    }

    final void m10529a(FriendInstallNotification friendInstallNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10515b(friendInstallNotification);
    }

    final void m10538a(PaymentNotification paymentNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10518b(paymentNotification);
    }

    final void m10534a(MissedCallNotification missedCallNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) missedCallNotification);
    }

    final void m10530a(IncomingCallNotification incomingCallNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) incomingCallNotification);
    }

    final void m10527a(CalleeReadyNotification calleeReadyNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) calleeReadyNotification);
    }

    final void m10540a(ReadThreadNotification readThreadNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10519b(readThreadNotification);
    }

    final void m10536a(NewBuildNotification newBuildNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) newBuildNotification);
    }

    final void m10539a(PromotionNotification promotionNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) promotionNotification);
    }

    final void m10542a(StaleNotification staleNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) staleNotification);
    }

    final void m10533a(MessageRequestNotification messageRequestNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) messageRequestNotification);
    }

    final void m10543a(TincanMessageRequestNotification tincanMessageRequestNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) tincanMessageRequestNotification);
    }

    final void m10535a(MultipleAccountsNewMessagesNotification multipleAccountsNewMessagesNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) multipleAccountsNewMessagesNotification);
    }

    final void m10531a(JoinRequestNotification joinRequestNotification) {
        ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
        m10511a((MessagingNotification) joinRequestNotification);
    }

    private void m10509a(Message message, PushProperty pushProperty, String str) {
        ((MessagesReliabilityLogger) this.f10066p.get()).a(message.a, message.b, pushProperty.a.toString(), pushProperty.b, str);
    }

    private synchronized void m10517b(NewMessageNotification newMessageNotification) {
        String str = newMessageNotification.b;
        Message message = newMessageNotification.c;
        PushProperty pushProperty = newMessageNotification.g;
        ThreadKey threadKey = newMessageNotification.d;
        if (threadKey != null) {
            if (StringUtil.a(((PrimaryPushTokenHolder) this.f10069s.get()).a())) {
                m10509a(message, pushProperty, "no_user");
            } else if (!((LoggedInUserSessionManager) this.f10065o.get()).b()) {
                m10509a(message, pushProperty, "logged_out_user");
            } else if (!m10523k()) {
                m10509a(message, pushProperty, "notifications_disabled");
            } else if (!m10512a(threadKey)) {
                m10509a(message, pushProperty, "notifications_disabled_thread");
            } else if (ThreadKey.g(message.b) || !((DataCache) this.f10054d.get()).m10358a(message)) {
                PresenceLevel presenceLevel;
                this.f10074x = ((Clock) this.f10062l.get()).a();
                if (!((AppStateManager) this.f10060j.get()).l()) {
                    presenceLevel = PresenceLevel.NOT_IN_APP;
                } else if (((AppStateManager) this.f10060j.get()).b(10000)) {
                    presenceLevel = PresenceLevel.IN_APP_ACTIVE_10S;
                } else if (((AppStateManager) this.f10060j.get()).b(30000)) {
                    presenceLevel = PresenceLevel.IN_APP_ACTIVE_30S;
                } else {
                    presenceLevel = PresenceLevel.IN_APP_IDLE;
                }
                m10510a(message, pushProperty.a);
                AlertDisposition b = m10513b(message, pushProperty.a);
                boolean l = b.l();
                if (!l) {
                    MessageNotificationPeerHelper.b(newMessageNotification.d, message.a, this.f10056f);
                }
                m10511a(((NewMessageNotificationFactory) this.f10067q.get()).a(str, message, newMessageNotification.d, newMessageNotification.e, presenceLevel, pushProperty, b, newMessageNotification.i, newMessageNotification.k));
                if (b.l() && !l) {
                    m10509a(message, pushProperty, "user_alerted_" + presenceLevel.toString());
                } else if (l) {
                    m10509a(message, pushProperty, "has_recent_message");
                } else {
                    m10509a(message, pushProperty, "user_not_alerted_" + presenceLevel.toString());
                }
                m10522j();
            } else {
                m10509a(message, pushProperty, "notification_dropped_message_read_locally");
            }
        }
    }

    private void m10510a(Message message, PushSource pushSource) {
        AlertDisposition alertDisposition;
        synchronized (this.f10073w) {
            AlertDisposition alertDisposition2 = (AlertDisposition) this.f10073w.get(message.a);
            if (alertDisposition2 != null || message.n == null) {
                alertDisposition = alertDisposition2;
            } else {
                alertDisposition = (AlertDisposition) this.f10073w.get(message.n);
            }
        }
        if (alertDisposition != null) {
            ((MessagesReliabilityLogger) this.f10066p.get()).a(alertDisposition.o(), pushSource.toString(), ((Clock) this.f10062l.get()).a() - alertDisposition.a(), message.a);
        }
    }

    private void m10516b(LoggedOutMessageNotification loggedOutMessageNotification) {
        String pushSource = loggedOutMessageNotification.d().toString();
        String e = loggedOutMessageNotification.e();
        String str = "10004";
        if (m10523k()) {
            String str2;
            m10511a((MessagingNotification) loggedOutMessageNotification);
            if (loggedOutMessageNotification.d) {
                str2 = "user_alerted_";
            } else {
                str2 = "user_not_alerted_";
            }
            ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, e, str, str2);
            return;
        }
        ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, e, str, "notifications_disabled");
    }

    private void m10521g() {
        boolean z;
        if (((FbSharedPreferences) this.f10064n.get()).a(f10050a, false) || ((AppStateManager) this.f10060j.get()).l()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ((FbSharedPreferences) this.f10064n.get()).edit().putBoolean(f10050a, true).commit();
            m10511a(new LoggedOutNotification(this.f10053c.getString(2131231003), this.f10053c.getString(this.f10059i ? 2131231007 : 2131231005), this.f10053c.getString(this.f10059i ? 2131231006 : 2131231004)));
        }
    }

    private void m10518b(PaymentNotification paymentNotification) {
        String pushSource = paymentNotification.h.a.toString();
        String str = paymentNotification.h.b;
        String str2 = "10014";
        if (!((LoggedInUserSessionManager) this.f10065o.get()).b()) {
            ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, str, str2, "logged_out_user");
        } else if (m10523k()) {
            String str3;
            m10511a((MessagingNotification) paymentNotification);
            if (paymentNotification.k) {
                str3 = "user_alerted_";
            } else {
                str3 = "user_not_alerted_";
            }
            ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, str, str2, str3);
        } else {
            ((ReliabilityAnalyticsLogger) this.f10070t.get()).m12288a(pushSource, str, str2, "notifications_disabled");
        }
    }

    private AlertDisposition m10513b(Message message, PushSource pushSource) {
        AlertDisposition alertDisposition;
        synchronized (this.f10073w) {
            AlertDisposition alertDisposition2 = (AlertDisposition) this.f10073w.get(message.a);
            if (alertDisposition2 == null && message.n != null) {
                alertDisposition2 = (AlertDisposition) this.f10073w.get(message.n);
            }
            if (alertDisposition2 == null) {
                alertDisposition = new AlertDisposition();
            } else {
                alertDisposition = alertDisposition2;
            }
            this.f10073w.put(message.a, alertDisposition);
            if (message.n != null) {
                this.f10073w.put(message.n, alertDisposition);
            }
            alertDisposition.a(pushSource.toString());
            alertDisposition.a(((Clock) this.f10062l.get()).a());
            alertDisposition.a(false);
            alertDisposition.b(false);
        }
        return alertDisposition;
    }

    private void m10522j() {
        synchronized (this.f10073w) {
            if (this.f10073w.size() < 100) {
                return;
            }
            long a = ((Clock) this.f10062l.get()).a();
            Iterator it = this.f10073w.values().iterator();
            while (it.hasNext()) {
                if (a - Long.valueOf(((AlertDisposition) it.next()).a()).longValue() > 3600000) {
                    it.remove();
                }
            }
        }
    }

    private boolean m10523k() {
        return ((NotificationSettingsUtil) this.f10068r.get()).m9291a().b();
    }

    private boolean m10512a(ThreadKey threadKey) {
        return ((NotificationSettingsUtil) this.f10068r.get()).m9292a(threadKey).b();
    }

    final void m10525a(FolderCounts folderCounts) {
        this.f10075y = folderCounts;
        HandlerDetour.a(this.f10055e, new 3(this), 7936068);
    }

    public static void m10520c(MessagesNotificationManager messagesNotificationManager, String str) {
        FolderCounts folderCounts = messagesNotificationManager.f10075y;
        if (folderCounts != null && folderCounts.c == 0) {
            long j = messagesNotificationManager.f10074x + 120000;
            long currentTimeMillis = System.currentTimeMillis();
            if (j <= currentTimeMillis) {
                messagesNotificationManager.m10550b(str);
                return;
            }
            j -= currentTimeMillis;
            HandlerDetour.b(messagesNotificationManager.f10055e, new 4(messagesNotificationManager, j), j, -1124142297);
        }
    }

    final void m10545a(String str, String str2) {
        if (!Objects.equal(str, (String) this.f10072v.get())) {
            ((DefaultAndroidThreadUtil) this.f10061k.get()).b();
            m10511a(new SwitchToFbAccountNotification(this.f10053c.getString(2131230720), this.f10053c.getString(2131231833, new Object[]{str2}), this.f10053c.getString(2131231834)));
        }
    }

    public final void init() {
        this.f10056f.a(Uri.parse("peer://msg_notification_unread_count/clear_thread"), this.f10057g);
        this.f10056f.a(MessageNotificationPeerContract.p, this.f10058h);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE");
        new SafeLocalBroadcastReceiver(this, this.f10053c, intentFilter) {
            final /* synthetic */ MessagesNotificationManager f10079a;

            public final void m10556a(Context context, Intent intent) {
                if ("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE".equals(intent.getAction())) {
                    MessagesNotificationManager messagesNotificationManager = this.f10079a;
                    for (AbstractMessagingNotificationHandler a : (Set) messagesNotificationManager.f10071u.get()) {
                        a.mo174a(MessagingNotification$Type.USER_LOGGED_OUT);
                    }
                    ((FbSharedPreferences) messagesNotificationManager.f10064n.get()).edit().putBoolean(MessagesNotificationManager.f10050a, false).commit();
                }
            }
        }.a();
    }
}
