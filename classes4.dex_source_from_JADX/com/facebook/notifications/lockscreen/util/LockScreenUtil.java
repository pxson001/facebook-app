package com.facebook.notifications.lockscreen.util;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.KeyguardManagerMethodAutoProvider;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.push.fbpushdata.Fb4aPushNotificationIntentHelper;
import com.facebook.notifications.lockscreen.db.PushNotificationDatabaseSupplier;
import com.facebook.notifications.lockscreen.db.PushNotificationDbHelper;
import com.facebook.notifications.lockscreen.db.PushNotificationsDbSchemaPart.PushNotificationsTable.Columns;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotification;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: login/identify?ctx=recover&allow_token_login=1 */
public class LockScreenUtil {
    private static final String f8888a = LockScreenUtil.class.getSimpleName();
    private static volatile LockScreenUtil f8889p;
    private final Context f8890b;
    private final QuickExperimentController f8891c;
    public final FbSharedPreferences f8892d;
    private final Product f8893e;
    private final PackageManager f8894f;
    private final AnalyticsLogger f8895g;
    private final Fb4aPushNotificationIntentHelper f8896h;
    private final PushNotificationDatabaseSupplier f8897i;
    private final KeyguardManager f8898j;
    private final LockscreenThirdPartyActivityHelper f8899k;
    public final ExecutorService f8900l;
    public final Lazy<PushNotificationDbHelper> f8901m;
    public final Provider<TriState> f8902n;
    public final Provider<TriState> f8903o;

    public static com.facebook.notifications.lockscreen.util.LockScreenUtil m9246a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8889p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.lockscreen.util.LockScreenUtil.class;
        monitor-enter(r1);
        r0 = f8889p;	 Catch:{ all -> 0x003a }
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
        r0 = m9248b(r0);	 Catch:{ all -> 0x0035 }
        f8889p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8889p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.lockscreen.util.LockScreenUtil.a(com.facebook.inject.InjectorLike):com.facebook.notifications.lockscreen.util.LockScreenUtil");
    }

    private static LockScreenUtil m9248b(InjectorLike injectorLike) {
        return new LockScreenUtil((Context) injectorLike.getInstance(Context.class), (QuickExperimentController) QuickExperimentControllerImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), Fb4aPushNotificationIntentHelper.m9268b(injectorLike), PushNotificationDatabaseSupplier.m9271a(injectorLike), KeyguardManagerMethodAutoProvider.b(injectorLike), LockscreenThirdPartyActivityHelper.m9275a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8695), IdBasedProvider.a(injectorLike, 720), IdBasedProvider.a(injectorLike, 719));
    }

    public static String m9247a() {
        return "[show on lockscreen]=" + "hipri [show Messenger messages]=" + false + " [turn screen on]=false" + " [default timeout]=-1" + " [default priority]=100";
    }

    @Inject
    public LockScreenUtil(Context context, QuickExperimentController quickExperimentController, FbSharedPreferences fbSharedPreferences, Product product, PackageManager packageManager, AnalyticsLogger analyticsLogger, PushNotificationIntentHelper pushNotificationIntentHelper, PushNotificationDatabaseSupplier pushNotificationDatabaseSupplier, KeyguardManager keyguardManager, LockscreenThirdPartyActivityHelper lockscreenThirdPartyActivityHelper, ExecutorService executorService, Lazy<PushNotificationDbHelper> lazy, Provider<TriState> provider, Provider<TriState> provider2) {
        this.f8890b = context;
        this.f8891c = quickExperimentController;
        this.f8892d = fbSharedPreferences;
        this.f8893e = product;
        this.f8894f = packageManager;
        this.f8895g = analyticsLogger;
        this.f8896h = pushNotificationIntentHelper;
        this.f8897i = pushNotificationDatabaseSupplier;
        this.f8898j = keyguardManager;
        this.f8899k = lockscreenThirdPartyActivityHelper;
        this.f8900l = executorService;
        this.f8901m = lazy;
        this.f8902n = provider;
        this.f8903o = provider2;
    }

    public final boolean m9260a(boolean z) {
        return m9249b(z, null);
    }

    public final boolean m9262b(boolean z) {
        return m9261a(z, null);
    }

    public final boolean m9261a(boolean z, @Nullable String str) {
        if (m9249b(z, str)) {
            boolean a = this.f8892d.a(NotificationsPreferenceConstants.f7733j, true);
            if (!a && z) {
                m9258a("user turned off master setting", "ndid", str);
            }
            if (a) {
                return true;
            }
        }
        return false;
    }

    public final boolean m9264c(boolean z) {
        return m9262b(z) && null != null;
    }

    private boolean m9253f(boolean z, @Nullable String str) {
        boolean z2;
        if ("hipri".equals("none")) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z3 = z2;
        if (!z3 && z) {
            m9258a("experiment group", "experiment_params", m9247a(), "ndid", str);
        }
        return z3;
    }

    public final boolean m9263c() {
        return this.f8892d.a(NotificationsPreferenceConstants.f7716E, false);
    }

    public final boolean m9265e() {
        return this.f8892d.a(NotificationsPreferenceConstants.f7713B, true);
    }

    public static int m9252f() {
        return -1;
    }

    private boolean m9255m() {
        return this.f8893e == Product.FB4A;
    }

    public static boolean m9254g() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG");
    }

    private boolean m9249b(boolean z, @Nullable String str) {
        if (((TriState) this.f8902n.get()).asBoolean(false)) {
            int i;
            if (VERSION.SDK_INT <= 19 || ((TriState) this.f8903o.get()).asBoolean(false)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0 && z) {
                m9258a("sdk", "sdk_version", Integer.toString(VERSION.SDK_INT), "ndid", str);
            }
            if (i != 0 && m9255m() && m9250d(z, str) && !m9251e(z, str) && m9253f(z, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean m9250d(boolean z, @Nullable String str) {
        boolean a = this.f8892d.a();
        if (!a && z) {
            m9258a("shared_preferences_not_initialized", "ndid", str);
        }
        return a;
    }

    private boolean m9251e(boolean z, @Nullable String str) {
        try {
            if (this.f8894f.getApplicationInfo("com.motorola.aon", 0).enabled) {
                if (!z) {
                    return true;
                }
                m9258a("moto_active_display_on", "ndid", str);
                return true;
            }
        } catch (NameNotFoundException e) {
        } catch (RuntimeException e2) {
        }
        return false;
    }

    public final void m9258a(String str, String... strArr) {
        int length = strArr.length;
        if ((length & 1) == 1) {
            throw new IllegalArgumentException("Number of parameters should be even");
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("lockscreen_notification_dropped");
        honeyClientEvent.c = "notifications";
        HoneyClientEvent b = honeyClientEvent.b("reason", str);
        int i = 0;
        while (i < length) {
            if (!(StringUtil.a(strArr[i]) || StringUtil.a(strArr[i + 1]))) {
                b.b(strArr[i], strArr[i + 1]);
            }
            i += 2;
        }
        this.f8895g.c(b);
    }

    public final boolean m9259a(SystemTrayNotification systemTrayNotification) {
        if (!m9255m()) {
            return false;
        }
        boolean z;
        int i = 100;
        int intValue = ((Integer) systemTrayNotification.m12315d("tp").or(Integer.valueOf(1000))).intValue();
        int intValue2 = ((Integer) systemTrayNotification.m12315d("af").or(Integer.valueOf(0))).intValue();
        if (m9261a(true, (String) systemTrayNotification.m12318g().orNull())) {
            if (1 == 0 || intValue <= i) {
                if (!m9265e() || (intValue <= i && intValue2 == 1)) {
                    z = true;
                } else {
                    m9258a("notif not from friend for nux", "ndid", (String) systemTrayNotification.m12318g().orNull());
                    z = false;
                }
                return z;
            }
            m9258a("notif type not hipri", "ndid", (String) systemTrayNotification.m12318g().orNull());
        }
        z = false;
        return z;
    }

    @TargetApi(8)
    public final void m9257a(NotificationLogObject notificationLogObject, SystemTrayNotification systemTrayNotification, long j) {
        String d = notificationLogObject.d() == null ? "notag" : notificationLogObject.d();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f8913a.a(), Long.valueOf(notificationLogObject.f()));
        contentValues.put(Columns.f8914b.a(), d);
        contentValues.put(Columns.f8916d.a(), systemTrayNotification.mMessage);
        contentValues.put(Columns.f8917e.a(), Long.valueOf(j));
        contentValues.put(Columns.f8918f.a(), systemTrayNotification.m12307a().toString());
        if (systemTrayNotification.m12314d().isPresent()) {
            contentValues.put(Columns.f8915c.a(), (String) systemTrayNotification.m12314d().get());
        }
        d = this.f8896h.m9270a(systemTrayNotification);
        if (d != null) {
            contentValues.put(Columns.f8919g.a(), d);
        }
        contentValues.put(Columns.f8920h.a(), (String) systemTrayNotification.m12318g().get());
        SQLiteDatabase a = this.f8897i.a();
        try {
            SQLiteDetour.a(-976762579);
            a.insertWithOnConflict("push_notifications", null, contentValues, 5);
            SQLiteDetour.a(-461991390);
        } catch (Throwable e) {
            BLog.b(f8888a, "lockscreen database was full", e);
        }
    }

    public final void m9266h() {
        if (m9260a(true) && this.f8898j.inKeyguardRestrictedInputMode() && !this.f8899k.m9279a()) {
            try {
                this.f8890b.startService(m9256p());
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private Intent m9256p() {
        Intent intent;
        try {
            intent = new Intent(this.f8890b.getApplicationContext(), Class.forName("com.facebook.notifications.lockscreenservice.LockScreenService"));
        } catch (ClassNotFoundException e) {
            intent = new Intent();
        }
        intent.setAction("com.facebook.notifications.lockscreen.ACTION_LAUNCH_LOCKSCREEN_NOTIFICATIONS");
        return intent;
    }
}
