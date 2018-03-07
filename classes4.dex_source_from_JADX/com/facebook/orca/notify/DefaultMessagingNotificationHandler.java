package com.facebook.orca.notify;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.android.KeyguardManagerMethodAutoProvider;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecurePendingIntent;
import com.facebook.datasource.DataSource;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.katana.orca.FbandroidMessagingIntentUris;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.ipc.MessagingNotificationPreferences;
import com.facebook.messages.ipc.peer.MessageNotificationPeerHelper;
import com.facebook.messages.ipc.peer.StatefulPeerManager_MessageNotificationPeerMethodAutoProvider;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.messaging.captiveportal.CaptivePortalUtil;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.mutators.ThreadNotificationsDialogActivity;
import com.facebook.messaging.notify.AlertDisposition;
import com.facebook.messaging.notify.CalleeReadyNotification;
import com.facebook.messaging.notify.FailedToSendMessageNotification;
import com.facebook.messaging.notify.FailedToSendMessageNotification.FailureReason;
import com.facebook.messaging.notify.FriendInstallNotification;
import com.facebook.messaging.notify.IncomingCallNotification;
import com.facebook.messaging.notify.IncomingCallNotification.CallType;
import com.facebook.messaging.notify.JoinRequestNotification;
import com.facebook.messaging.notify.LoggedOutMessageNotification;
import com.facebook.messaging.notify.MessageRequestNotification;
import com.facebook.messaging.notify.MessagingNotification;
import com.facebook.messaging.notify.MessagingNotification$Type;
import com.facebook.messaging.notify.MissedCallNotification;
import com.facebook.messaging.notify.MissedCallNotification.MissCallType;
import com.facebook.messaging.notify.MultipleAccountsNewMessagesNotification;
import com.facebook.messaging.notify.NewBuildNotification;
import com.facebook.messaging.notify.NewEphemeralMessageNotification;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.NewMessageNotification.PresenceLevel;
import com.facebook.messaging.notify.PaymentNotification;
import com.facebook.messaging.notify.PromotionNotification;
import com.facebook.messaging.notify.ReadThreadNotification;
import com.facebook.messaging.notify.SimpleMessageNotification;
import com.facebook.messaging.notify.StaleNotification;
import com.facebook.messaging.notify.TincanMessageRequestNotification;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgProperties;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.facebook.orca.notify.MuteNotificationHelper.MuteOption;
import com.facebook.orca.notify.abtest.ExperimentsForNotificationExperimentsModule;
import com.facebook.orca.notify.abtest.NotificationsOnSendRetryFailureExperimentController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.wear.NotificationManagerCompatMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: setupDeviceFromServer */
public class DefaultMessagingNotificationHandler extends AbstractMessagingNotificationHandler {
    private static volatile DefaultMessagingNotificationHandler f2257K;
    private static final String f2258a = (MessengerLinks.f2316c + "accounts");
    private final Lazy<FbErrorReporter> f2259A;
    public final FbAppType f2260B;
    private final GatekeeperStoreImpl f2261C;
    private final DynamicSecureBroadcastReceiver f2262D = new DynamicSecureBroadcastReceiver("com.facebook.orca.notify.NEW_MESSAGE_NOTIFICATION_CLEARED", m2508b());
    public final DefaultThreadKeyFactory f2263E;
    public final RtcCallHandler f2264F;
    private final PackageManager f2265G;
    public final FacebookOnlyIntentActionFactory f2266H;
    private final CaptivePortalUtil f2267I;
    private NotificationsOnSendRetryFailureExperimentController f2268J;
    public final Context f2269b;
    public final Resources f2270c;
    public final NotificationManagerCompat f2271d;
    public final FbAndroidMessagingNotificationPreferences f2272e;
    public final MessagingNotificationFeedback f2273f;
    private final MessagingIntentUris f2274g;
    public final FbSharedPreferences f2275h;
    public final KeyguardManager f2276i;
    public final PowerManager f2277j;
    private final Provider<Boolean> f2278k;
    public final Random f2279l;
    public final ReliabilityAnalyticsLogger f2280m;
    public final StatefulPeerManagerImpl f2281n;
    public final Product f2282o;
    private final MessagesForegroundActivityListener f2283p;
    private final ThreadSystemTrayNotificationManager f2284q;
    public final MessagingNotificationUtil f2285r;
    private final MessageUtil f2286s;
    public final AudioManager f2287t;
    public final ScreenPowerState f2288u;
    private final MuteNotificationHelper f2289v;
    public final Clock f2290w;
    public final NotificationSettingsUtil f2291x;
    public final EphemeralMessageNotificationManager f2292y;
    private final EphemeralGatingUtil f2293z;

    /* compiled from: setupDeviceFromServer */
    class C01251 implements ActionReceiver {
        final /* synthetic */ DefaultMessagingNotificationHandler f2826a;

        C01251(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler) {
            this.f2826a = defaultMessagingNotificationHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1108082170);
            String stringExtra = intent.getStringExtra("com.facebook.orca.notify.EXTRA_CLEARED_NOTIFICATION_TYPE");
            if (stringExtra.equals("ephemeral")) {
                ThreadKey threadKey = (ThreadKey) intent.getParcelableExtra("thread_key_string");
                this.f2826a.f2292y.m2733a(threadKey);
            } else {
                DefaultMessagingNotificationHandler defaultMessagingNotificationHandler = this.f2826a;
                Map c = Maps.c();
                c.put("type", stringExtra);
                defaultMessagingNotificationHandler.f2280m.m12294b("notification_dismissed_from_tray", null, c, null, null, null);
            }
            LogUtils.e(537960188, a);
        }
    }

    public static com.facebook.orca.notify.DefaultMessagingNotificationHandler m2502a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2257K;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.DefaultMessagingNotificationHandler.class;
        monitor-enter(r1);
        r0 = f2257K;	 Catch:{ all -> 0x003a }
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
        r0 = m2509b(r0);	 Catch:{ all -> 0x0035 }
        f2257K = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2257K;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.DefaultMessagingNotificationHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.DefaultMessagingNotificationHandler");
    }

    private static DefaultMessagingNotificationHandler m2509b(InjectorLike injectorLike) {
        return new DefaultMessagingNotificationHandler((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), NotificationManagerCompatMethodAutoProvider.m2551a(injectorLike), FbAndroidMessagingNotificationPreferences.m10901a(injectorLike), MessagingNotificationFeedback.m2571a(injectorLike), FbandroidMessagingIntentUris.m2487a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), KeyguardManagerMethodAutoProvider.a(injectorLike), PowerManagerMethodAutoProvider.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4134), ReliabilityAnalyticsLogger.m12278a(injectorLike), StatefulPeerManager_MessageNotificationPeerMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), MessagesForegroundActivityListener.a(injectorLike), MessagingNotificationUtil.m2639a(injectorLike), MessageUtil.a(injectorLike), ThreadSystemTrayNotificationManager.m2688a(injectorLike), AudioManagerMethodAutoProvider.a(injectorLike), ScreenPowerState.a(injectorLike), MuteNotificationHelper.m2746a(injectorLike), RtcCallHandler.m2762a(injectorLike), DefaultThreadKeyFactory.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), NotificationSettingsUtil.m9289a(injectorLike), EphemeralMessageNotificationManager.m2728a(injectorLike), EphemeralGatingUtil.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), (FbAppType) injectorLike.getInstance(FbAppType.class), FacebookOnlyIntentActionFactory.a(injectorLike), CaptivePortalUtil.m10328a(injectorLike), NotificationsOnSendRetryFailureExperimentController.m3100a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    protected final void mo186b(SimpleMessageNotification simpleMessageNotification) {
        String pushSource = simpleMessageNotification.b.a.toString();
        String str = simpleMessageNotification.b.b;
        String str2 = "pre_reg_push";
        String packageName = this.f2269b.getPackageName();
        this.f2280m.m12293b(null, pushSource, str, str2);
        m2506a(simpleMessageNotification, 10019, new Intent(this.f2269b, MessagesSystemTrayLogService.class).putExtra("push_source", pushSource).putExtra("push_id", str).putExtra("push_type", str2).putExtra("redirect_intent", this.f2265G.getLaunchIntentForPackage(packageName)).addFlags(268435456));
    }

    protected final void mo157a(ReadThreadNotification readThreadNotification) {
        Iterator it = readThreadNotification.a.keySet().iterator();
        while (it.hasNext()) {
            mo155a((ThreadKey) it.next(), null);
        }
    }

    @Inject
    public DefaultMessagingNotificationHandler(Context context, Resources resources, NotificationManagerCompat notificationManagerCompat, MessagingNotificationPreferences messagingNotificationPreferences, MessagingNotificationFeedback messagingNotificationFeedback, MessagingIntentUris messagingIntentUris, FbSharedPreferences fbSharedPreferences, KeyguardManager keyguardManager, PowerManager powerManager, Random random, Provider<Boolean> provider, ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, StatefulPeerManager statefulPeerManager, Product product, MessagesForegroundActivityListener messagesForegroundActivityListener, MessagingNotificationUtil messagingNotificationUtil, MessageUtil messageUtil, ThreadSystemTrayNotificationManager threadSystemTrayNotificationManager, AudioManager audioManager, ScreenPowerState screenPowerState, MuteNotificationHelper muteNotificationHelper, RtcCallHandler rtcCallHandler, ThreadKeyFactory threadKeyFactory, Clock clock, PackageManager packageManager, NotificationSettingsUtil notificationSettingsUtil, EphemeralMessageNotificationManager ephemeralMessageNotificationManager, EphemeralGatingUtil ephemeralGatingUtil, Lazy<FbErrorReporter> lazy, FbAppType fbAppType, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, CaptivePortalUtil captivePortalUtil, NotificationsOnSendRetryFailureExperimentController notificationsOnSendRetryFailureExperimentController, GatekeeperStore gatekeeperStore) {
        this.f2269b = context;
        this.f2270c = resources;
        this.f2271d = notificationManagerCompat;
        this.f2273f = messagingNotificationFeedback;
        this.f2272e = messagingNotificationPreferences;
        this.f2274g = messagingIntentUris;
        this.f2275h = fbSharedPreferences;
        this.f2276i = keyguardManager;
        this.f2277j = powerManager;
        this.f2279l = random;
        this.f2278k = provider;
        this.f2280m = reliabilityAnalyticsLogger;
        this.f2281n = statefulPeerManager;
        this.f2282o = product;
        this.f2283p = messagesForegroundActivityListener;
        this.f2284q = threadSystemTrayNotificationManager;
        this.f2285r = messagingNotificationUtil;
        this.f2286s = messageUtil;
        this.f2287t = audioManager;
        this.f2288u = screenPowerState;
        this.f2289v = muteNotificationHelper;
        this.f2264F = rtcCallHandler;
        this.f2263E = threadKeyFactory;
        this.f2290w = clock;
        this.f2265G = packageManager;
        this.f2291x = notificationSettingsUtil;
        this.f2292y = ephemeralMessageNotificationManager;
        this.f2293z = ephemeralGatingUtil;
        this.f2259A = lazy;
        this.f2260B = fbAppType;
        this.f2266H = facebookOnlyIntentActionFactory;
        this.f2267I = captivePortalUtil;
        this.f2269b.registerReceiver(this.f2262D, new IntentFilter("com.facebook.orca.notify.NEW_MESSAGE_NOTIFICATION_CLEARED"));
        this.f2268J = notificationsOnSendRetryFailureExperimentController;
        this.f2261C = gatekeeperStore;
    }

    private ActionReceiver m2508b() {
        return new C01251(this);
    }

    protected final void mo156a(NewMessageNotification newMessageNotification) {
        this.f2285r.m2657a(newMessageNotification);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void mo159b(com.facebook.messaging.notify.NewMessageNotification r9) {
        /*
        r8 = this;
        r0 = com.facebook.push.PushSource.SMS_READONLY_MODE;
        r1 = r9.g;
        r1 = r1.a;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r4 = 0;
        r3 = 1;
        r2 = com.facebook.orca.notify.DefaultMessagingNotificationHandler.11.a;
        r5 = r9.f;
        r5 = r5.ordinal();
        r2 = r2[r5];
        switch(r2) {
            case 1: goto L_0x005d;
            case 2: goto L_0x005f;
            case 3: goto L_0x005f;
            default: goto L_0x001c;
        };
    L_0x001c:
        r2 = r9.b();
        if (r2 == 0) goto L_0x0069;
    L_0x0022:
        r2 = r8.f2287t;
        r2 = r2.isMusicActive();
        if (r2 == 0) goto L_0x0069;
    L_0x002a:
        r2 = r3;
    L_0x002b:
        r5 = r9.h;
        r7 = r5.d;
        r6 = r7;
        if (r6 != 0) goto L_0x006b;
    L_0x0032:
        r7 = r9.i;
        if (r7 == 0) goto L_0x006e;
    L_0x0036:
        r7 = r9.i;
        r7 = r7.a;
        if (r7 == 0) goto L_0x006e;
    L_0x003c:
        r7 = 1;
    L_0x003d:
        r6 = r7;
        if (r6 != 0) goto L_0x006b;
    L_0x0040:
        r6 = r8.f2264F;
        r6 = r6.m2799c();
        if (r6 != 0) goto L_0x006b;
    L_0x0048:
        if (r3 == 0) goto L_0x0059;
    L_0x004a:
        if (r2 == 0) goto L_0x0059;
    L_0x004c:
        r2 = r8.f2273f;
        r3 = r9.c;
        r2 = r2.m2579a(r3);
        if (r2 == 0) goto L_0x0059;
    L_0x0056:
        r5.c();
    L_0x0059:
        r8.m2515d(r9);
        goto L_0x000c;
    L_0x005d:
        r2 = r3;
        goto L_0x002b;
    L_0x005f:
        r2 = r8.f2282o;
        r5 = com.facebook.config.application.Product.MESSENGER;
        if (r2 != r5) goto L_0x0067;
    L_0x0065:
        r2 = r3;
        goto L_0x002b;
    L_0x0067:
        r2 = r4;
        goto L_0x002b;
    L_0x0069:
        r2 = r4;
        goto L_0x002b;
    L_0x006b:
        r3 = r4;
        goto L_0x0048;
    L_0x006e:
        r7 = 0;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.DefaultMessagingNotificationHandler.b(com.facebook.messaging.notify.NewMessageNotification):void");
    }

    protected final void mo180a(SimpleMessageNotification simpleMessageNotification) {
        m2506a(simpleMessageNotification, 10017, null);
    }

    private void m2506a(SimpleMessageNotification simpleMessageNotification, int i, @Nullable Intent intent) {
        this.f2270c.getString(2131230720);
        CharSequence charSequence = simpleMessageNotification.a;
        long a = this.f2290w.a();
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m2a(2130843533).m26e(charSequence).m6a(a);
        if (intent != null) {
            a2.f6d = SecurePendingIntent.m10164c(this.f2269b, 0, intent, 134217728);
        }
        a2.m13a(this.f2269b.getString(2131230720));
        a2.m23c(true);
        a2.m19b(charSequence);
        this.f2271d.m2557a(i, a2.m21c());
    }

    private void m2515d(NewMessageNotification newMessageNotification) {
        if (newMessageNotification.d != null) {
            boolean z;
            Message message = newMessageNotification.c;
            boolean b = newMessageNotification.b();
            if (newMessageNotification.f == PresenceLevel.IN_APP_ACTIVE_30S || newMessageNotification.f == PresenceLevel.IN_APP_ACTIVE_10S) {
                b = m2511b(newMessageNotification.d);
            }
            AlertDisposition alertDisposition = newMessageNotification.h;
            if (alertDisposition.h) {
                z = false;
            } else {
                z = true;
            }
            if (z && r0) {
                m2504a(message, newMessageNotification.d);
                if (this.f2286s.w(newMessageNotification.c)) {
                    RTCAdminMsgProperties v = this.f2286s.v(newMessageNotification.c);
                    String str = newMessageNotification.c.e.c;
                    String str2 = newMessageNotification.b;
                    if (StringUtil.a(str)) {
                        str = this.f2269b.getString(2131232134);
                    } else {
                        str2 = this.f2269b.getString(2131232048, new Object[]{newMessageNotification.c.e.c});
                    }
                    mo175a(new MissedCallNotification(str, str2, v.e, newMessageNotification.c.c, true, "missed_call", newMessageNotification.h, MissCallType.P2P, newMessageNotification.d));
                } else {
                    m2516e(newMessageNotification);
                }
                alertDisposition.h = true;
            }
        }
    }

    private boolean m2511b(ThreadKey threadKey) {
        if (this.f2282o != Product.MESSENGER) {
            return false;
        }
        Activity b = this.f2283p.b();
        if (b == null) {
            return false;
        }
        boolean e;
        while (b.isChild()) {
            b = b.getParent();
        }
        if (b instanceof ThreadViewStatusHostActivity) {
            ThreadViewStatusHostActivity threadViewStatusHostActivity = (ThreadViewStatusHostActivity) b;
            boolean equal = Objects.equal(threadViewStatusHostActivity.c(), threadKey);
            try {
                e = threadViewStatusHostActivity.e();
            } catch (Throwable e2) {
                ((AbstractFbErrorReporter) this.f2259A.get()).a("Messaging_Notification_CanSeeTopThreadIsUnread_Npe", e2);
                e = true;
            }
            e = (equal || e) ? false : true;
        } else {
            e = true;
        }
        return e;
    }

    protected final void mo162a(LoggedOutMessageNotification loggedOutMessageNotification) {
        this.f2280m.m12293b(null, loggedOutMessageNotification.d().toString(), loggedOutMessageNotification.e(), null);
        m2505a((MessagingNotification) loggedOutMessageNotification, loggedOutMessageNotification.a, loggedOutMessageNotification.b, loggedOutMessageNotification.b);
        loggedOutMessageNotification.d = true;
    }

    protected final void mo183a(LoggedOutNotification loggedOutNotification) {
        m2505a((MessagingNotification) loggedOutNotification, loggedOutNotification.a, loggedOutNotification.b, loggedOutNotification.c);
        loggedOutNotification.d = true;
    }

    private void m2505a(MessagingNotification messagingNotification, String str, String str2, String str3) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW", this.f2274g.mo164a());
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m13a((CharSequence) str).m19b((CharSequence) str2).m26e(str3).m2a(i);
        a2.f6d = a;
        a2 = a2.m23c(true);
        this.f2273f.m2575a(a2, new AlertDisposition(), null, null);
        this.f2271d.m2559a(null, 10004, a2.m21c());
        messagingNotification.i();
    }

    public final void mo174a(MessagingNotification$Type messagingNotification$Type) {
        if (messagingNotification$Type == MessagingNotification$Type.USER_LOGGED_OUT) {
            this.f2271d.m2556a(10004);
        } else if (messagingNotification$Type == MessagingNotification$Type.NEW_BUILD) {
            this.f2271d.m2556a(10007);
        } else if (messagingNotification$Type == MessagingNotification$Type.TINCAN_MESSAGE_REQUEST) {
            this.f2271d.m2556a(10030);
        }
    }

    protected final void mo161a(FriendInstallNotification friendInstallNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Uri a = this.f2274g.mo167a(friendInstallNotification.a);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(a);
        intent.putExtra("from_notification", true);
        DataSource a2 = this.f2285r.m2652a(new ParticipantInfo(new UserKey(Type.FACEBOOK, String.valueOf(friendInstallNotification.a)), null));
        if (a2 != null) {
            a2.a(new 2(this, intent, friendInstallNotification, i), MoreExecutors.a());
        }
    }

    protected final void mo178a(PaymentNotification paymentNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        DataSource a = this.f2285r.m2652a(new ParticipantInfo(new UserKey(Type.FACEBOOK, !StringUtil.a(paymentNotification.d) ? paymentNotification.d : paymentNotification.c), null));
        if (a != null) {
            a.a(new 3(this, paymentNotification, i), MoreExecutors.a());
        }
    }

    protected final void mo177a(NewBuildNotification newBuildNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, newBuildNotification.d, 134217728);
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m13a((CharSequence) newBuildNotification.a).m19b((CharSequence) newBuildNotification.b).m26e(newBuildNotification.c).m2a(i);
        a2.f6d = a;
        this.f2271d.m2559a(null, 10007, NotificationCompat.a.a(a2.m23c(true)));
        newBuildNotification.e = true;
        newBuildNotification.i();
    }

    protected final void mo179a(PromotionNotification promotionNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(promotionNotification.d));
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        PendingIntent d = m2514d(this, "promotion");
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m13a(promotionNotification.a).m19b(promotionNotification.b).m26e(promotionNotification.c).m2a(i).m12a(new BigTextStyle().b(promotionNotification.b));
        a2.f6d = a;
        a2 = a2.m18b(d).m23c(true);
        this.f2280m.m12293b(null, "PROMOTION_PUSH", null, null);
        this.f2271d.m2559a(null, 10015, a2.m21c());
        promotionNotification.e = true;
        promotionNotification.i();
    }

    protected final void mo181a(StaleNotification staleNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW", this.f2274g.mo164a());
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        PendingIntent d = m2514d(this, "stale");
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m13a(staleNotification.a).m19b(staleNotification.b).m26e(staleNotification.c).m2a(i);
        a2.f6d = a;
        a2 = a2.m18b(d).m23c(true);
        this.f2280m.m12293b(null, "STALE_PUSH", null, null);
        this.f2271d.m2559a(null, 10016, a2.m21c());
        staleNotification.d = true;
        staleNotification.i();
    }

    protected final void mo173a(MessageRequestNotification messageRequestNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MessengerLinks.f2298E));
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        PendingIntent d = m2514d(this, "message_request");
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m13a(messageRequestNotification.a).m19b(messageRequestNotification.b).m2a(i);
        a2.f6d = a;
        a2 = a2.m18b(d).m23c(true);
        this.f2280m.m12293b(null, "MESSAGE_REQUEST", null, null);
        this.f2271d.m2559a(null, 10018, a2.m21c());
        messageRequestNotification.c = true;
        messageRequestNotification.i();
    }

    protected final void mo182a(TincanMessageRequestNotification tincanMessageRequestNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(MessengerLinks.f2320g));
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        PendingIntent d = m2514d(this, "tincan_message_request");
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m13a(tincanMessageRequestNotification.a).m19b(tincanMessageRequestNotification.b).m2a(i);
        a2.f6d = a;
        a2 = a2.m18b(d).m23c(true);
        this.f2273f.m2578a(a2);
        this.f2271d.m2559a(null, 10030, a2.m21c());
        tincanMessageRequestNotification.c = true;
        tincanMessageRequestNotification.i();
    }

    protected final void mo172a(JoinRequestNotification joinRequestNotification) {
        ThreadKey threadKey = (ThreadKey) Preconditions.checkNotNull(joinRequestNotification.c);
        this.f2285r.m2656a(threadKey, new 4(this, threadKey, joinRequestNotification), null, null);
    }

    protected final void mo184a(SwitchToFbAccountNotification switchToFbAccountNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MessengerLinks.f2316c + "accounts/triggersso"));
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        NotificationCompat$Builder e = new NotificationCompat$Builder(this.f2269b).m13a(switchToFbAccountNotification.a).m19b(switchToFbAccountNotification.b).m26e(switchToFbAccountNotification.b);
        e.f12j = 1;
        NotificationCompat$Builder a2 = e.m12a(new BigTextStyle().b(switchToFbAccountNotification.b)).m2a(i);
        a2.f6d = a;
        a2 = a2.m23c(true).m5a(2130840815, switchToFbAccountNotification.c, a);
        this.f2273f.m2575a(a2, new AlertDisposition(), null, null);
        this.f2280m.m12293b(null, "SWITCH_TO_FB_ACCOUNT", null, null);
        this.f2271d.m2557a(10032, a2.m21c());
        switchToFbAccountNotification.d = true;
        switchToFbAccountNotification.i();
    }

    protected final void mo175a(MissedCallNotification missedCallNotification) {
        long parseLong = Long.parseLong(missedCallNotification.c);
        this.f2285r.m2656a(missedCallNotification.i, new 5(this, missedCallNotification, parseLong, VERSION.SDK_INT > 19 ? 2130844002 : 2130844001), new ParticipantInfo(new UserKey(Type.FACEBOOK, String.valueOf(parseLong)), null), null);
    }

    protected final void mo171a(IncomingCallNotification incomingCallNotification) {
        long parseLong = Long.parseLong(incomingCallNotification.c);
        ParticipantInfo participantInfo = new ParticipantInfo(new UserKey(Type.FACEBOOK, String.valueOf(parseLong)), null);
        if (incomingCallNotification.i == CallType.CONFERENCE) {
            this.f2285r.m2656a(incomingCallNotification.h, new 6(this, incomingCallNotification, parseLong), participantInfo, null);
            return;
        }
        DataSource a = this.f2285r.m2652a(participantInfo);
        if (a != null) {
            a.a(new 7(this, incomingCallNotification, parseLong), MoreExecutors.a());
        }
    }

    public static void m2507a(@Nullable DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, Bitmap bitmap, IncomingCallNotification incomingCallNotification, long j) {
        PendingIntent a = defaultMessagingNotificationHandler.m2499a(CallResponseType.DECLINE, j);
        PendingIntent a2 = defaultMessagingNotificationHandler.m2499a(CallResponseType.ANSWER, j);
        PendingIntent a3 = defaultMessagingNotificationHandler.m2499a(CallResponseType.SHOW_INCALL, j);
        CharSequence charSequence = incomingCallNotification.a;
        NotificationCompat$Builder a4 = new NotificationCompat$Builder(defaultMessagingNotificationHandler.f2269b).m13a(charSequence).m19b(incomingCallNotification.b).m2a(AppGlyphResolver.a());
        a4.f6d = a3;
        NotificationCompat$Builder a5 = a4.m8a(a3, true);
        a5.f12j = 2;
        a5 = a5.m6a(incomingCallNotification.d).m15a(true);
        a5.f27y = defaultMessagingNotificationHandler.f2269b.getResources().getColor(2131362241);
        a5 = a5.m23c(false);
        if (bitmap != null) {
            a5.f9g = bitmap;
        }
        if (incomingCallNotification.e.booleanValue()) {
            a5.m5a(2130843969, defaultMessagingNotificationHandler.f2269b.getString(2131232172), a);
            a5.m5a(2130843942, defaultMessagingNotificationHandler.f2269b.getString(2131232171), a2);
        }
        defaultMessagingNotificationHandler.f2271d.m2559a("10027", 10027, a5.m21c());
        incomingCallNotification.i();
    }

    protected final void mo170a(CalleeReadyNotification calleeReadyNotification) {
        long parseLong = Long.parseLong(calleeReadyNotification.c);
        ThreadKey a = this.f2263E.a(parseLong);
        DataSource a2 = this.f2285r.m2652a(new ParticipantInfo(new UserKey(Type.FACEBOOK, String.valueOf(parseLong)), null));
        if (a2 != null) {
            a2.a(new 8(this, calleeReadyNotification, a, parseLong), MoreExecutors.a());
        }
    }

    protected final void mo176a(MultipleAccountsNewMessagesNotification multipleAccountsNewMessagesNotification) {
        CharSequence string;
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(f2258a));
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        PendingIntent d = m2514d(this, "multiple_accounts");
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this.f2269b);
        if (StringUtil.a(multipleAccountsNewMessagesNotification.b)) {
            string = this.f2269b.getString(2131230720);
        } else {
            string = multipleAccountsNewMessagesNotification.b;
        }
        notificationCompat$Builder = notificationCompat$Builder.m13a(string).m19b(multipleAccountsNewMessagesNotification.c);
        if (StringUtil.a(multipleAccountsNewMessagesNotification.d)) {
            string = multipleAccountsNewMessagesNotification.c;
        } else {
            string = multipleAccountsNewMessagesNotification.d;
        }
        NotificationCompat$Builder a2 = notificationCompat$Builder.m26e(string).m2a(i).m12a(new BigTextStyle().b(multipleAccountsNewMessagesNotification.c));
        a2.f6d = a;
        a2 = a2.m18b(d).m23c(true);
        this.f2280m.m12293b(null, "MULTIPLE_ACCOUNTS", null, null);
        this.f2273f.m2575a(a2, new AlertDisposition(), null, null);
        this.f2271d.m2559a(multipleAccountsNewMessagesNotification.a, 10026, a2.m21c());
        multipleAccountsNewMessagesNotification.e = true;
        multipleAccountsNewMessagesNotification.i();
    }

    protected final void mo160a(FailedToSendMessageNotification failedToSendMessageNotification) {
        m2510b(failedToSendMessageNotification);
        failedToSendMessageNotification.c = true;
        failedToSendMessageNotification.i();
    }

    public final void mo155a(ThreadKey threadKey, String str) {
        threadKey.toString();
        this.f2271d.m2558a(threadKey.toString(), 10000);
        this.f2271d.m2558a(threadKey.toString(), 10020);
        this.f2292y.m2733a(threadKey);
        this.f2284q.m2712a(threadKey.g());
    }

    public final void mo169a(ThreadKey threadKey) {
        threadKey.toString();
        this.f2271d.m2558a(Long.toString(threadKey.i()), 10010);
    }

    public final void mo187b(String str) {
        this.f2271d.m2558a(str, 10003);
        this.f2271d.m2558a(str, 10010);
    }

    public final void mo185a(List<String> list) {
        for (String a : list) {
            this.f2271d.m2558a(a, 10026);
        }
    }

    public final void mo168a() {
        this.f2271d.m2556a(10032);
    }

    public final void m2542a(ContactsUploadNotification contactsUploadNotification) {
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        int i = 2130843533;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(MessengerLinks.f2322i));
        intent.putExtra("from_notification", true);
        PendingIntent a = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 134217728);
        NotificationCompat$Builder a2 = new NotificationCompat$Builder(this.f2269b).m13a(contactsUploadNotification.a).m19b(contactsUploadNotification.b).m26e(contactsUploadNotification.c).m12a(new BigTextStyle().b(contactsUploadNotification.b)).m2a(i);
        a2.f6d = a;
        a2 = a2.m23c(true);
        this.f2273f.m2575a(a2, new AlertDisposition(), null, null);
        this.f2280m.m12293b(null, "CONTACTS_UPLOAD", null, null);
        this.f2271d.m2557a(10004, a2.m21c());
        contactsUploadNotification.d = true;
        contactsUploadNotification.i();
    }

    private void m2516e(NewMessageNotification newMessageNotification) {
        ThreadKey threadKey = newMessageNotification.d;
        if (threadKey != null) {
            Object obj;
            Object obj2;
            int i;
            AlertDisposition alertDisposition;
            Object obj3;
            Object obj4;
            boolean a;
            PendingIntent b;
            AlertDisposition alertDisposition2 = newMessageNotification.h;
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this.f2269b);
            if (alertDisposition2.g) {
                if (this.f2276i.inKeyguardRestrictedInputMode() || !this.f2277j.isScreenOn()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null && !m2511b(threadKey)) {
                    notificationCompat$Builder.m26e("");
                    this.f2273f.m2575a(notificationCompat$Builder, alertDisposition2, newMessageNotification.i, newMessageNotification.d);
                    obj2 = null;
                    switch (11.a[newMessageNotification.f.ordinal()]) {
                        case 1:
                        case 2:
                            i = 1;
                            break;
                        case 4:
                            if (!newMessageNotification.b() && this.f2287t.isMusicActive()) {
                                i = 1;
                                break;
                            } else {
                                obj = null;
                                break;
                            }
                        default:
                            obj = null;
                            break;
                    }
                    alertDisposition = newMessageNotification.h;
                    if (!alertDisposition.e) {
                        if (newMessageNotification.i == null && newMessageNotification.i.b) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            obj4 = 1;
                            if (!(obj4 == null || r6 == null)) {
                                if (this.f2264F.m2799c() || this.f2288u.a() || newMessageNotification.f == PresenceLevel.IN_APP_ACTIVE_10S) {
                                    obj2 = 1;
                                }
                                if (obj2 == null) {
                                    a = this.f2273f.m2577a();
                                } else {
                                    a = this.f2273f.m2578a(notificationCompat$Builder);
                                }
                                if (a) {
                                    alertDisposition.e();
                                }
                            }
                            b = m2547b(threadKey, null);
                            notificationCompat$Builder.f6d = b;
                            this.f2284q.m2711a(newMessageNotification, notificationCompat$Builder, new 10(this, notificationCompat$Builder, b, newMessageNotification));
                        }
                    }
                    obj4 = null;
                    obj2 = 1;
                    if (obj2 == null) {
                        a = this.f2273f.m2578a(notificationCompat$Builder);
                    } else {
                        a = this.f2273f.m2577a();
                    }
                    if (a) {
                        alertDisposition.e();
                    }
                    b = m2547b(threadKey, null);
                    notificationCompat$Builder.f6d = b;
                    this.f2284q.m2711a(newMessageNotification, notificationCompat$Builder, new 10(this, notificationCompat$Builder, b, newMessageNotification));
                }
            }
            if (ThreadKey.g(threadKey)) {
                notificationCompat$Builder.m26e("");
            } else {
                notificationCompat$Builder.m26e(this.f2284q.m2708a(newMessageNotification));
            }
            this.f2273f.m2575a(notificationCompat$Builder, alertDisposition2, newMessageNotification.i, newMessageNotification.d);
            obj2 = null;
            switch (11.a[newMessageNotification.f.ordinal()]) {
                case 1:
                case 2:
                    i = 1;
                    break;
                case 4:
                    if (!newMessageNotification.b()) {
                        break;
                    }
                    obj = null;
                    break;
                default:
                    obj = null;
                    break;
            }
            alertDisposition = newMessageNotification.h;
            if (alertDisposition.e) {
                if (newMessageNotification.i == null) {
                }
                obj3 = null;
                if (obj3 == null) {
                    obj4 = 1;
                    obj2 = 1;
                    if (obj2 == null) {
                        a = this.f2273f.m2577a();
                    } else {
                        a = this.f2273f.m2578a(notificationCompat$Builder);
                    }
                    if (a) {
                        alertDisposition.e();
                    }
                    b = m2547b(threadKey, null);
                    notificationCompat$Builder.f6d = b;
                    this.f2284q.m2711a(newMessageNotification, notificationCompat$Builder, new 10(this, notificationCompat$Builder, b, newMessageNotification));
                }
            }
            obj4 = null;
            obj2 = 1;
            if (obj2 == null) {
                a = this.f2273f.m2578a(notificationCompat$Builder);
            } else {
                a = this.f2273f.m2577a();
            }
            if (a) {
                alertDisposition.e();
            }
            b = m2547b(threadKey, null);
            notificationCompat$Builder.f6d = b;
            this.f2284q.m2711a(newMessageNotification, notificationCompat$Builder, new 10(this, notificationCompat$Builder, b, newMessageNotification));
        }
    }

    @VisibleForTesting
    final void m2521a(WearableExtender wearableExtender, NotificationCompat$Builder notificationCompat$Builder, PendingIntent pendingIntent, NewMessageNotification newMessageNotification) {
        Object obj;
        Message message = newMessageNotification.c;
        ThreadKey threadKey = newMessageNotification.d;
        if (threadKey.a == ThreadKey.Type.SMS || ThreadKey.g(threadKey) || !this.f2272e.m10903b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            PendingIntent b = m2547b(threadKey, MessagingIntentUris.f2256b);
            notificationCompat$Builder.m5a(2130842045, this.f2269b.getString(2131230982), b);
            Builder builder = new Builder(2130842046, this.f2269b.getString(2131230982), b);
            new Action.WearableExtender().a(false).a(builder);
            wearableExtender.a(builder.b());
        }
        Builder builder2 = new Builder(2130842054, this.f2270c.getString(2131231665), pendingIntent);
        RemoteInput.Builder builder3 = new RemoteInput.Builder("voice_reply");
        builder3.b = this.f2270c.getString(2131231665);
        builder2.a(builder3.a());
        new Action.WearableExtender().a(false).a(builder2);
        wearableExtender.a(builder2.b());
        if (VERSION.RELEASE.equals("N") && this.f2261C.a(377, false)) {
            builder2 = new Builder(2130842054, this.f2270c.getString(2131231665), pendingIntent);
            builder3 = new RemoteInput.Builder("direct_reply");
            builder3.b = this.f2270c.getString(2131231665);
            builder2.a(builder3.a());
            notificationCompat$Builder.m11a(builder2.b());
        }
        if (this.f2284q.m2713a(threadKey)) {
            b = m2513d(threadKey);
            notificationCompat$Builder.m5a(2130842052, this.f2269b.getString(2131231758), b);
            Builder builder4 = new Builder(2130842053, this.f2269b.getString(2131231758), b);
            List<MuteOption> a = this.f2289v.m2747a(threadKey);
            CharSequence[] charSequenceArr = new String[a.size()];
            int i = 0;
            for (MuteOption muteOption : a) {
                int i2 = i + 1;
                charSequenceArr[i] = muteOption.b;
                i = i2;
            }
            RemoteInput.Builder builder5 = new RemoteInput.Builder("voice_reply");
            builder5.b = this.f2270c.getString(2131231140);
            builder5 = builder5;
            builder5.d = false;
            builder5 = builder5;
            builder5.c = charSequenceArr;
            builder4.a(builder5.a());
            new Action.WearableExtender().a(false).a(builder4);
            wearableExtender.a(builder4.b());
        }
        wearableExtender.b(false);
        if (this.f2293z.a(newMessageNotification.c)) {
            notificationCompat$Builder.m18b(m2500a("ephemeral", threadKey));
            EphemeralMessageNotificationManager ephemeralMessageNotificationManager = this.f2292y;
            NewEphemeralMessageNotification newEphemeralMessageNotification = (NewEphemeralMessageNotification) newMessageNotification;
            wearableExtender.a(notificationCompat$Builder);
            ephemeralMessageNotificationManager.m2734a(newEphemeralMessageNotification, threadKey, notificationCompat$Builder);
            return;
        }
        wearableExtender.a(notificationCompat$Builder);
        Notification c = notificationCompat$Builder.m21c();
        this.f2280m.m12293b(message.a, newMessageNotification.g.a.toString(), newMessageNotification.g.b, null);
        this.f2271d.m2559a(threadKey.toString(), newMessageNotification.a(), c);
    }

    @VisibleForTesting
    final PendingIntent m2547b(ThreadKey threadKey, @Nullable String str) {
        Intent b = this.f2274g.mo163b(threadKey);
        b.setFlags(67108864);
        b.putExtra("from_notification", true);
        b.putExtra("trigger", "notification");
        if (str != null) {
            b.setAction(str);
        }
        int nextInt = this.f2279l.nextInt();
        if (((Boolean) this.f2278k.get()).booleanValue() && !m2511b(threadKey)) {
            b.putExtra("prefer_chat_if_possible", true);
        }
        return SecurePendingIntent.m10162a(this.f2269b, nextInt, b, 134217728);
    }

    final PendingIntent m2519a(ThreadKey threadKey, long j, long j2, @Nullable String str) {
        Intent b = this.f2274g.mo163b(threadKey);
        b.setFlags(67108864);
        b.putExtra("from_notification", true);
        b.putExtra("CONTACT_ID", j);
        b.putExtra("trigger", "voip_notification");
        if (!StringUtil.a(str)) {
            b.putExtra("rtc_when", j2);
            b.putExtra("rtc_message", str);
        }
        if (((Boolean) this.f2278k.get()).booleanValue() && !m2511b(threadKey)) {
            b.putExtra("prefer_chat_if_possible", true);
        }
        return SecurePendingIntent.m10162a(this.f2269b, this.f2279l.nextInt(), b, 268435456);
    }

    final PendingIntent m2517a(long j, String str) {
        Intent intent = new Intent(this.f2266H.a("RTC_DISMISS_MISSED_CALL_ACTION"));
        intent.putExtra("CONTACT_ID", j).putExtra("trigger", str);
        return SecurePendingIntent.m10163b(this.f2269b, this.f2279l.nextInt(), intent, 1073741824);
    }

    private PendingIntent m2499a(CallResponseType callResponseType, long j) {
        String str = null;
        switch (11.b[callResponseType.ordinal()]) {
            case 1:
            case 2:
                str = this.f2266H.a("RTC_SHOW_IN_CALL_ACTION");
                break;
            case 3:
                str = this.f2266H.a("RTC_DECLINE_CALL_ACTION");
                break;
        }
        Intent intent = new Intent(str);
        intent.putExtra("CONTACT_ID", j);
        intent.putExtra("AUTO_ACCEPT", callResponseType == CallResponseType.ANSWER);
        return SecurePendingIntent.m10163b(this.f2269b, this.f2279l.nextInt(), intent, 268435456);
    }

    final PendingIntent m2518a(long j, boolean z, String str) {
        Intent intent = new Intent(this.f2266H.a("RTC_START_CALL_ACTION"));
        intent.putExtra("CONTACT_ID", j).putExtra("IS_VIDEO_CALL", z).putExtra("CALLBACK_NOTIF_TIME", this.f2290w.a()).putExtra("trigger", str);
        return SecurePendingIntent.m10163b(this.f2269b, this.f2279l.nextInt(), intent, 268435456);
    }

    public static PendingIntent m2514d(DefaultMessagingNotificationHandler defaultMessagingNotificationHandler, String str) {
        return defaultMessagingNotificationHandler.m2500a(str, null);
    }

    private PendingIntent m2500a(String str, @Nullable ThreadKey threadKey) {
        Intent putExtra = new Intent("com.facebook.orca.notify.NEW_MESSAGE_NOTIFICATION_CLEARED").putExtra("com.facebook.orca.notify.EXTRA_CLEARED_NOTIFICATION_TYPE", str);
        if (threadKey != null) {
            putExtra.putExtra("thread_key_string", threadKey);
        }
        return SecurePendingIntent.m10163b(this.f2269b, this.f2279l.nextInt(), putExtra, 1073741824);
    }

    private PendingIntent m2513d(ThreadKey threadKey) {
        Intent intent = new Intent(this.f2269b, ThreadNotificationsDialogActivity.class);
        intent.putExtra("thread_key", threadKey);
        return SecurePendingIntent.m10162a(this.f2269b, this.f2279l.nextInt(), intent, 0);
    }

    private void m2510b(FailedToSendMessageNotification failedToSendMessageNotification) {
        switch (11.c[failedToSendMessageNotification.b.ordinal()]) {
            case 1:
                if (this.f2268J.f2825a.a(ExperimentsForNotificationExperimentsModule.b, false)) {
                    m2512c();
                    return;
                }
                return;
            case 2:
                if (failedToSendMessageNotification.a != null && this.f2268J.f2825a.a(ExperimentsForNotificationExperimentsModule.c, false)) {
                    m2503a(this.f2274g.mo166a(failedToSendMessageNotification.a), this.f2270c.getString(2131231191), this.f2270c.getString(2131231193), failedToSendMessageNotification.b);
                    return;
                }
                return;
            case 3:
                if (failedToSendMessageNotification.a != null && this.f2268J.f2825a.a(ExperimentsForNotificationExperimentsModule.a, false)) {
                    m2503a(this.f2274g.mo166a(failedToSendMessageNotification.a), this.f2270c.getString(2131231191), this.f2270c.getString(2131231194), failedToSendMessageNotification.b);
                    return;
                }
                return;
            case 4:
                if (failedToSendMessageNotification.a != null) {
                    m2503a(this.f2274g.mo166a(failedToSendMessageNotification.a), this.f2270c.getString(2131231191), this.f2270c.getString(2131231195), failedToSendMessageNotification.b);
                    return;
                }
                return;
            case 5:
                if (failedToSendMessageNotification.a != null) {
                    m2503a(this.f2274g.mo166a(failedToSendMessageNotification.a), this.f2270c.getString(2131230720), this.f2270c.getString(2131231183), failedToSendMessageNotification.b);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @SuppressLint({"BadMethodUse-android.app.PendingIntent.getActivity"})
    private void m2512c() {
        NotificationCompat$Builder a = m2501a(this.f2270c.getString(2131231191), this.f2270c.getString(2131231192));
        a.f6d = PendingIntent.getActivity(this.f2269b, 0, new Intent("android.intent.action.VIEW", this.f2267I.m10330a()), 0);
        this.f2271d.m2556a(10011);
        this.f2271d.m2557a(10001, a.m21c());
    }

    private void m2503a(Uri uri, String str, String str2, FailureReason failureReason) {
        NotificationCompat$Builder a = m2501a(str, str2);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(67108864);
        intent.putExtra("from_notification", true);
        intent.putExtra("send_failure_reason", failureReason);
        a.f6d = SecurePendingIntent.m10162a(this.f2269b, 0, intent, 268435456);
        this.f2271d.m2557a(10001, a.m21c());
    }

    private NotificationCompat$Builder m2501a(String str, String str2) {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this.f2269b);
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2272e;
        notificationCompat$Builder = notificationCompat$Builder.m2a(2130843533).m6a(this.f2290w.a()).m13a((CharSequence) str).m19b((CharSequence) str2).m26e(str2).m23c(true);
        this.f2273f.m2575a(notificationCompat$Builder, new AlertDisposition(), null, null);
        return notificationCompat$Builder;
    }

    private void m2504a(Message message, ThreadKey threadKey) {
        PrefKey b = MessagingPrefKeys.b(threadKey);
        int a = MessageNotificationPeerHelper.a(threadKey, message.a, this.f2281n);
        Editor edit = this.f2275h.edit();
        edit.a(b, a);
        edit.commit();
    }

    public final void mo158a(String str) {
        Set<PrefKey> d = this.f2275h.d(MessagingPrefKeys.W);
        ImmutableList immutableList;
        if (d.isEmpty()) {
            immutableList = RegularImmutableList.a;
        } else {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (PrefKey b : d) {
                builder.c(Uri.decode(b.b(MessagingPrefKeys.W)));
            }
            immutableList = builder.b();
        }
        for (String str2 : r4) {
            this.f2271d.m2558a(str2, 10000);
            this.f2284q.m2712a(str2);
        }
        this.f2271d.m2556a(10001);
        this.f2271d.m2556a(10002);
        this.f2271d.m2556a(10004);
        EphemeralMessageNotificationManager ephemeralMessageNotificationManager = this.f2292y;
        for (ThreadKey a : ephemeralMessageNotificationManager.f2462h.keySet()) {
            ephemeralMessageNotificationManager.m2733a(a);
        }
        Editor edit = this.f2275h.edit();
        edit.b(MessagingPrefKeys.W);
        edit.commit();
    }
}
