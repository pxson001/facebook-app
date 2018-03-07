package com.facebook.katana.push.fbpushdata;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.apptab.state.TabTag;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.log.BLog;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.katana.service.AppSession;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.common.JewelCounters.OnJewelCountChangeListener;
import com.facebook.notifications.lockscreen.util.PushNotificationIntentHelper;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.Event;
import com.facebook.notifications.model.SystemTrayNotification;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.util.SystemTrayNotificationHelper;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.notifications.util.SystemTrayNotificationUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.push.PushProperty;
import com.facebook.push.externalcloud.PrimaryPushTokenHolder;
import com.facebook.push.fbpushdata.BaseFbPushDataHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: xconfigs.txt */
public class FbandroidFbPushDataHandler extends BaseFbPushDataHandler {
    private static final Class<?> f64b = FbandroidFbPushDataHandler.class;
    private static final ImmutableSet<NotificationType> f65c = ImmutableSet.of(NotificationType.MSG, NotificationType.BACKGROUND_LOCATION, NotificationType.ANSIBLE_LOCKSCREEN_RESET, NotificationType.ZERO, NotificationType.WAKEUP_MQTT, NotificationType.BOOTSTRAP_UPDATED, new NotificationType[]{NotificationType.PLACE_FEED_NEARBY_CANCEL, NotificationType.EVENT_PHOTO_CHECK, NotificationType.TODAY_UNIT_UPDATE, NotificationType.MOBILE_ZERO_FREE_FACEBOOK_LAUNCH});
    private static final ImmutableMap<NotificationType, Integer> f66d = ImmutableMap.of(NotificationType.FRIEND_REQUEST, Integer.valueOf(2130843530), NotificationType.EVENT, Integer.valueOf(2130843531));
    private static final ImmutableMap<NotificationType, PrefKey> f67e = ImmutableMap.builder().b(NotificationType.WALL, NotificationsPreferenceConstants.n).b(NotificationType.SHARE_WALL_CREATE, NotificationsPreferenceConstants.n).b(NotificationType.FRIEND_REQUEST, NotificationsPreferenceConstants.p).b(NotificationType.FRIEND_CONFIRMED, NotificationsPreferenceConstants.q).b(NotificationType.PHOTO_TAG, NotificationsPreferenceConstants.r).b(NotificationType.PHOTO_TAG_REQUEST, NotificationsPreferenceConstants.r).b(NotificationType.PHOTO_TAGGED_BY_NON_OWNER, NotificationsPreferenceConstants.r).b(NotificationType.EVENT, NotificationsPreferenceConstants.s).b(NotificationType.COMMENT, NotificationsPreferenceConstants.o).b(NotificationType.COMMENT_MENTION, NotificationsPreferenceConstants.o).b(NotificationType.APP_REQUEST, NotificationsPreferenceConstants.t).b(NotificationType.GROUP_ACTIVITY, NotificationsPreferenceConstants.u).b(NotificationType.PLACE_FEED_NEARBY, NotificationsPreferenceConstants.v).b();
    private static volatile FbandroidFbPushDataHandler f68u;
    private final Provider<ViewerContext> f69f;
    private final Context f70g;
    private final PrimaryPushTokenHolder f71h;
    private final JewelCounters f72i;
    private OnJewelCountChangeListener f73j;
    public final SystemTrayNotificationManager f74k;
    private final NotificationsLogger f75l;
    private final SystemTrayNotificationUtil f76m;
    private final Provider<Boolean> f77n;
    public final AnalyticsLogger f78o;
    private final FbSharedPreferences f79p;
    private final Fb4aPushNotificationIntentHelper f80q;
    public final DefaultAndroidThreadUtil f81r;
    public final FriendingEventBus f82s;
    private final SystemTrayNotificationHelper f83t;

    /* compiled from: xconfigs.txt */
    class C00021 extends OnJewelCountChangeListener {
        final /* synthetic */ FbandroidFbPushDataHandler f59a;

        C00021(FbandroidFbPushDataHandler fbandroidFbPushDataHandler) {
            this.f59a = fbandroidFbPushDataHandler;
        }

        public final void m71a(Jewel jewel, int i) {
            if (i == 0) {
                switch (C00043.f63a[jewel.ordinal()]) {
                    case 1:
                        this.f59a.f74k.a();
                        break;
                    case 2:
                        this.f59a.f74k.b();
                        break;
                }
                HoneyClientEventFast a = this.f59a.f78o.a("clear_system_tray_on_zero_count", true);
                if (a.a()) {
                    a.a("notification_type", jewel.graphName);
                    a.b();
                }
            }
        }
    }

    /* compiled from: xconfigs.txt */
    /* synthetic */ class C00043 {
        static final /* synthetic */ int[] f63a = new int[Jewel.values().length];

        static {
            try {
                f63a[Jewel.NOTIFICATIONS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f63a[Jewel.FRIEND_REQUESTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.katana.push.fbpushdata.FbandroidFbPushDataHandler m72a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f68u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.push.fbpushdata.FbandroidFbPushDataHandler.class;
        monitor-enter(r1);
        r0 = f68u;	 Catch:{ all -> 0x003a }
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
        r0 = m76b(r0);	 Catch:{ all -> 0x0035 }
        f68u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f68u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.push.fbpushdata.FbandroidFbPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.katana.push.fbpushdata.FbandroidFbPushDataHandler");
    }

    private static FbandroidFbPushDataHandler m76b(InjectorLike injectorLike) {
        return new FbandroidFbPushDataHandler(IdBasedProvider.a(injectorLike, 372), (Context) injectorLike.getInstance(Context.class), ReliabilityAnalyticsLogger.a(injectorLike), PrimaryPushTokenHolder.a(injectorLike), JewelCounters.a(injectorLike), SystemTrayNotificationManager.a(injectorLike), NotificationsLogger.a(injectorLike), SystemTrayNotificationUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4064), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Fb4aPushNotificationIntentHelper.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), FriendingEventBus.a(injectorLike), SystemTrayNotificationHelper.a(injectorLike));
    }

    @Inject
    public FbandroidFbPushDataHandler(Provider<ViewerContext> provider, Context context, ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, PrimaryPushTokenHolder primaryPushTokenHolder, JewelCounters jewelCounters, SystemTrayNotificationManager systemTrayNotificationManager, NotificationsLogger notificationsLogger, SystemTrayNotificationUtil systemTrayNotificationUtil, Provider<Boolean> provider2, AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences, PushNotificationIntentHelper pushNotificationIntentHelper, AndroidThreadUtil androidThreadUtil, FriendingEventBus friendingEventBus, SystemTrayNotificationHelper systemTrayNotificationHelper) {
        super(reliabilityAnalyticsLogger);
        this.f69f = provider;
        this.f70g = context;
        this.f71h = primaryPushTokenHolder;
        this.f72i = jewelCounters;
        this.f74k = systemTrayNotificationManager;
        this.f75l = notificationsLogger;
        this.f76m = systemTrayNotificationUtil;
        this.f77n = provider2;
        this.f78o = analyticsLogger;
        this.f79p = fbSharedPreferences;
        this.f80q = pushNotificationIntentHelper;
        this.f81r = androidThreadUtil;
        this.f82s = friendingEventBus;
        this.f83t = systemTrayNotificationHelper;
        m73a();
    }

    private void m73a() {
        this.f73j = new C00021(this);
        this.f72i.a(this.f73j);
    }

    public final void m78b(JsonNode jsonNode, PushProperty pushProperty) {
        try {
            SystemTrayNotification a = this.f76m.a(jsonNode).a(pushProperty.b).b(pushProperty.a.toString()).a(pushProperty.c);
            this.f75l.a(a.c(), Event.PUSH_NOTIFICATION_RECEIVED);
            if (m75a(a, pushProperty)) {
                m74a(a);
                m77b(a);
            }
        } catch (Throwable e) {
            BLog.b(f64b, "IOException", e);
            this.a.a(pushProperty.a.toString(), pushProperty.b, e);
        }
    }

    private boolean m75a(SystemTrayNotification systemTrayNotification, PushProperty pushProperty) {
        NotificationType a = systemTrayNotification.a();
        if (NotificationType.NEKO_INSTALL_REMINDER == a && !NativeThirdPartyUriHelper.a(this.f70g, systemTrayNotification.mHref)) {
            return false;
        }
        AppSession b = AppSession.b(this.f70g, false);
        if (NotificationType.PRE_REG_PUSH == a) {
            return b == null;
        } else {
            if (b == null && !systemTrayNotification.l()) {
                a("logged_out_user", pushProperty);
                return false;
            } else if (b != null && systemTrayNotification.l()) {
                a("logged_in_user", pushProperty);
                return false;
            } else if (systemTrayNotification.y() && !Long.toString(systemTrayNotification.x()).equals(this.f71h.a())) {
                a("eaten_wrong_user", pushProperty);
                return false;
            } else if (!((Boolean) this.f77n.get()).booleanValue()) {
                this.f75l.a(systemTrayNotification.c(), Event.DROPPED_BY_OVERALL_SETTING);
                return false;
            } else if (f65c.contains(systemTrayNotification.a())) {
                this.f75l.a(systemTrayNotification.c(), Event.DROPPED_BY_WHITELIST_TYPES);
                return false;
            } else {
                PrefKey prefKey = (PrefKey) f67e.get(systemTrayNotification.a());
                if (prefKey == null || this.f79p.a(prefKey, true)) {
                    return true;
                }
                this.f75l.a(systemTrayNotification.c(), Event.DROPPED_BY_INDIVIDUAL_SETTING);
                return false;
            }
        }
    }

    private void m74a(SystemTrayNotification systemTrayNotification) {
        NotificationType a = systemTrayNotification.a();
        if ((a == NotificationType.FRIEND_REQUEST || a == NotificationType.FRIEND_CONFIRMED) && systemTrayNotification != null) {
            Long l;
            GraphQLFriendshipStatus graphQLFriendshipStatus;
            Object obj = systemTrayNotification.mParams.get("uid");
            if (obj instanceof Long) {
                l = (Long) obj;
            } else if (obj instanceof String) {
                l = Long.valueOf(Long.parseLong((String) obj));
            } else {
                return;
            }
            if (systemTrayNotification.a() == NotificationType.FRIEND_REQUEST) {
                graphQLFriendshipStatus = GraphQLFriendshipStatus.INCOMING_REQUEST;
            } else if (systemTrayNotification.a() == NotificationType.FRIEND_CONFIRMED) {
                graphQLFriendshipStatus = GraphQLFriendshipStatus.ARE_FRIENDS;
            } else {
                return;
            }
            this.f81r.a(new Runnable(this) {
                final /* synthetic */ FbandroidFbPushDataHandler f62c;

                public void run() {
                    this.f62c.f82s.a(new FriendshipStatusChangedEvent(l.longValue(), graphQLFriendshipStatus, false));
                }
            });
        }
    }

    private boolean m77b(SystemTrayNotification systemTrayNotification) {
        NotificationType a = systemTrayNotification.a();
        Integer num = (Integer) f66d.get(a);
        int intValue = num != null ? num.intValue() : 2130843529;
        Intent a2 = this.f80q.a(a, this.f80q.a(systemTrayNotification));
        if (!(a2 == null || a2.hasExtra("target_tab_name"))) {
            a2.putExtra("target_tab_name", TabTag.Notifications.name());
        }
        ViewerContext viewerContext = (ViewerContext) this.f69f.get();
        if (viewerContext != null) {
            this.f83t.a(systemTrayNotification, 0, intValue, a2, viewerContext);
        } else if (a2 != null) {
            this.f83t.a(systemTrayNotification, 0, intValue, a2);
        }
        return true;
    }
}
