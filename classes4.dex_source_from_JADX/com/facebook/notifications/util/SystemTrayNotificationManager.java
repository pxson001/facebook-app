package com.facebook.notifications.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.notifications.intent.NotificationsLoggingIntentBuilder;
import com.facebook.notifications.lockscreen.util.LockScreenUtil;
import com.facebook.notifications.lockscreen.util.LockScreenUtil.1;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.Event;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotification;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.service.SystemTrayLogService;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_gravity_settings_operation */
public class SystemTrayNotificationManager implements IHaveUserData {
    private static volatile SystemTrayNotificationManager f11649j;
    public final Context f11650a;
    private final NotificationManager f11651b;
    private final NotificationsLogger f11652c;
    private final NotificationsLoggingIntentBuilder f11653d;
    public final ViewPermalinkIntentFactory f11654e;
    private final MonotonicClock f11655f;
    public final UriIntentMapper f11656g;
    private final Lazy<LockScreenUtil> f11657h;
    public final FbSharedPreferences f11658i;

    public static com.facebook.notifications.util.SystemTrayNotificationManager m12194a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11649j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.SystemTrayNotificationManager.class;
        monitor-enter(r1);
        r0 = f11649j;	 Catch:{ all -> 0x003a }
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
        r0 = m12198b(r0);	 Catch:{ all -> 0x0035 }
        f11649j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11649j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.SystemTrayNotificationManager.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.SystemTrayNotificationManager");
    }

    private static SystemTrayNotificationManager m12198b(InjectorLike injectorLike) {
        return new SystemTrayNotificationManager((Context) injectorLike.getInstance(Context.class), NotificationManagerMethodAutoProvider.m8723b(injectorLike), NotificationsLogger.m12207a(injectorLike), NotificationsLoggingIntentBuilder.m12213b(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2802), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public SystemTrayNotificationManager(Context context, NotificationManager notificationManager, NotificationsLogger notificationsLogger, NotificationsLoggingIntentBuilder notificationsLoggingIntentBuilder, ViewPermalinkIntentFactory viewPermalinkIntentFactory, MonotonicClock monotonicClock, UriIntentMapper uriIntentMapper, Lazy<LockScreenUtil> lazy, FbSharedPreferences fbSharedPreferences) {
        this.f11650a = context;
        this.f11651b = notificationManager;
        this.f11652c = notificationsLogger;
        this.f11653d = notificationsLoggingIntentBuilder;
        this.f11654e = viewPermalinkIntentFactory;
        this.f11655f = monotonicClock;
        this.f11656g = uriIntentMapper;
        this.f11657h = lazy;
        this.f11658i = fbSharedPreferences;
    }

    public final void m12205a(NotificationType notificationType, SystemTrayNotificationBuilder systemTrayNotificationBuilder, Intent intent, Component component, NotificationLogObject notificationLogObject) {
        if (notificationLogObject.b() == NotificationType.UNKNOWN) {
            notificationLogObject.b = notificationType;
        }
        m12203a(0, systemTrayNotificationBuilder, intent, component, notificationLogObject);
    }

    public final void m12203a(int i, SystemTrayNotificationBuilder systemTrayNotificationBuilder, Intent intent, Component component, NotificationLogObject notificationLogObject) {
        intent.putExtra("notification_launch_source", "source_system_tray");
        Intent a = this.f11653d.m12214a(notificationLogObject, intent, component, null, i);
        Intent putExtra = new Intent(this.f11653d.f11666a, SystemTrayLogService.class).putExtra("NOTIF_LOG", notificationLogObject).putExtra("EVENT_TYPE", Event.CLEAR_FROM_TRAY);
        int now = (int) this.f11655f.now();
        systemTrayNotificationBuilder.k.f6d = PendingIntent.getService(this.f11650a, now, a, 268435456);
        if (putExtra != null) {
            systemTrayNotificationBuilder.k.m18b(PendingIntent.getService(this.f11650a, now + 1, putExtra, 0));
        }
        this.f11652c.m12210a(notificationLogObject, Event.ADD_TO_TRAY);
        m12196a(i, systemTrayNotificationBuilder.d(), notificationLogObject);
        if (systemTrayNotificationBuilder.i) {
            ((LockScreenUtil) this.f11657h.get()).m9266h();
        }
    }

    private void m12196a(int i, Notification notification, NotificationLogObject notificationLogObject) {
        NotificationType b = notificationLogObject.b();
        if (b == NotificationType.FRIEND_REQUEST || SystemTrayNotification.m12301a(b)) {
            long j = notificationLogObject.e;
            PrefKey prefKey = b == NotificationType.FRIEND_REQUEST ? NotificationsPreferenceConstants.f7718G : NotificationsPreferenceConstants.f7717F;
            String a = this.f11658i.a(prefKey, null);
            if (Strings.isNullOrEmpty(a)) {
                a = Long.toString(j);
            } else {
                a = a + ',' + Long.toString(j);
            }
            this.f11658i.edit().a(prefKey, a).commit();
            this.f11651b.notify(Long.toString(j), 0, notification);
            return;
        }
        if (i == 0) {
            i = b.ordinal();
        }
        this.f11651b.notify(i, notification);
    }

    public final void m12202a(int i) {
        this.f11651b.cancel(i);
    }

    public final void m12204a(NotificationType notificationType) {
        if (notificationType == NotificationType.FRIEND_REQUEST) {
            m12206b();
        } else if (SystemTrayNotification.m12301a(notificationType)) {
            m12201a();
        } else {
            this.f11651b.cancel(notificationType.ordinal());
        }
    }

    public final void m12201a() {
        if (m12197a(NotificationsPreferenceConstants.f7717F)) {
            LockScreenUtil lockScreenUtil = (LockScreenUtil) this.f11657h.get();
            ExecutorDetour.a(lockScreenUtil.f8900l, new 1(lockScreenUtil, "LockScreenUtil", "DeletePushNotifications"), -1948279991);
        }
    }

    public final void m12206b() {
        m12197a(NotificationsPreferenceConstants.f7718G);
    }

    private boolean m12197a(PrefKey prefKey) {
        String a = this.f11658i.a(prefKey, null);
        if (Strings.isNullOrEmpty(a)) {
            return false;
        }
        for (Long longValue : m12195a(a)) {
            try {
                this.f11651b.cancel(Long.toString(longValue.longValue()), 0);
            } catch (IllegalStateException e) {
            }
        }
        m12199b(prefKey);
        return true;
    }

    public final String m12200a(GraphQLStory graphQLStory) {
        return (StoryActorHelper.b(graphQLStory) == null || StoryActorHelper.b(graphQLStory).ai() == null) ? null : StoryActorHelper.b(graphQLStory).ai().b();
    }

    public void clearUserData() {
        this.f11651b.cancelAll();
        m12199b(NotificationsPreferenceConstants.f7717F);
        m12199b(NotificationsPreferenceConstants.f7718G);
    }

    private void m12199b(PrefKey prefKey) {
        this.f11658i.edit().a(prefKey).commit();
    }

    private static List<Long> m12195a(@Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            return Lists.a();
        }
        Iterable<String> split = Splitter.on(',').split(str);
        List<Long> a = Lists.a();
        for (String parseLong : split) {
            a.add(Long.valueOf(Long.parseLong(parseLong)));
        }
        return a;
    }
}
