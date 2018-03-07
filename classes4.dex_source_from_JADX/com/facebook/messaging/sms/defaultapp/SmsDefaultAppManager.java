package com.facebook.messaging.sms.defaultapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android_src.mmsv2.MmsManager;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.chatheads.intents.ChatHeadsIntentDispatcher;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.analytics.SmsTakeoverState;
import com.facebook.messaging.sms.defaultapp.action.MmsSmsCacheUpdateAction;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sms.readonly.AnonymousSmsThreadHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sync_older_photos */
public class SmsDefaultAppManager {
    private static volatile SmsDefaultAppManager f1433n;
    private final SmsTakeoverAnalyticsLogger f1434a;
    public final Context f1435b;
    public final SecureContextHelper f1436c;
    public final SmsIntegrationState f1437d;
    public final FbSharedPreferences f1438e;
    private final SmsGatekeepers f1439f;
    private final DefaultAndroidThreadUtil f1440g;
    public final DefaultAppChoreographer f1441h;
    private final Lazy<Clock> f1442i;
    public final Lazy<MmsSmsCacheUpdateAction> f1443j;
    private final ChatHeadsIntentDispatcher f1444k;
    public final List<Runnable> f1445l = new ArrayList(1);
    public final Runnable f1446m = new C00771(this);

    /* compiled from: sync_older_photos */
    class C00771 implements Runnable {
        final /* synthetic */ SmsDefaultAppManager f1486a;

        C00771(SmsDefaultAppManager smsDefaultAppManager) {
            this.f1486a = smsDefaultAppManager;
        }

        public void run() {
            for (Runnable run : this.f1486a.f1445l) {
                run.run();
            }
            this.f1486a.f1445l.clear();
        }
    }

    public static com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager m1673a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1433n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager.class;
        monitor-enter(r1);
        r0 = f1433n;	 Catch:{ all -> 0x003a }
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
        r0 = m1675b(r0);	 Catch:{ all -> 0x0035 }
        f1433n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1433n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager");
    }

    private static SmsDefaultAppManager m1675b(InjectorLike injectorLike) {
        return new SmsDefaultAppManager(SmsTakeoverAnalyticsLogger.m14218b(injectorLike), (Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SmsIntegrationState.m10491a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SmsGatekeepers.m10502b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), DefaultAppChoreographer.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedLazy.a(injectorLike, 8461), ChatHeadsIntentDispatcher.m1684a(injectorLike));
    }

    @Inject
    public SmsDefaultAppManager(SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, Context context, SecureContextHelper secureContextHelper, SmsIntegrationState smsIntegrationState, FbSharedPreferences fbSharedPreferences, SmsGatekeepers smsGatekeepers, AndroidThreadUtil androidThreadUtil, AppChoreographer appChoreographer, Lazy<Clock> lazy, Lazy<MmsSmsCacheUpdateAction> lazy2, ChatHeadsIntentDispatcher chatHeadsIntentDispatcher) {
        this.f1434a = smsTakeoverAnalyticsLogger;
        this.f1435b = context;
        this.f1436c = secureContextHelper;
        this.f1437d = smsIntegrationState;
        this.f1438e = fbSharedPreferences;
        this.f1439f = smsGatekeepers;
        this.f1440g = androidThreadUtil;
        this.f1441h = appChoreographer;
        this.f1442i = lazy;
        this.f1443j = lazy2;
        this.f1444k = chatHeadsIntentDispatcher;
    }

    public static boolean m1674a(Context context) {
        try {
            ComponentName componentName = new ComponentName(context, ComposeSmsActivity.class);
            ComponentName componentName2 = new ComponentName(context, PrivilegedSmsReceiver.class);
            PackageManager packageManager = context.getPackageManager();
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            int componentEnabledSetting2 = packageManager.getComponentEnabledSetting(componentName2);
            if (componentEnabledSetting == 1 && componentEnabledSetting2 == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public final boolean m1679a(Object obj, Context context, boolean z) {
        try {
            ComponentName componentName = new ComponentName(context, ComposeSmsActivity.class);
            ComponentName componentName2 = new ComponentName(context, PrivilegedSmsReceiver.class);
            PackageManager packageManager = context.getPackageManager();
            SmsTakeoverState g = this.f1434a.m14248g();
            if (m1674a(context) != z) {
                packageManager.setComponentEnabledSetting(componentName, z ? 1 : 2, 1);
            }
            if (packageManager.getComponentEnabledSetting(componentName2) != 1) {
                packageManager.setComponentEnabledSetting(componentName2, 1, 1);
            }
            SmsTakeoverState g2 = this.f1434a.m14248g();
            if (g == g2) {
                return true;
            }
            this.f1434a.m14226a(obj, g, g2);
            return true;
        } catch (Throwable e) {
            BLog.c("SmsDefaultAppManager", e, "Failed to enable SMS components", new Object[0]);
            return false;
        }
    }

    public final void m1677a(SmsCallerContext smsCallerContext, @Nullable Runnable runnable) {
        boolean z = runnable == null || this.f1440g.c();
        Preconditions.checkState(z);
        this.f1434a.m14225a(smsCallerContext);
        if (runnable != null) {
            this.f1445l.add(runnable);
        }
        Intent intent = new Intent(this.f1435b, SmsDefaultAppDialogActivity.class);
        intent.setFlags(805306368);
        intent.putExtra("analytics_caller_context", smsCallerContext);
        if (null == null) {
            this.f1436c.a(intent, this.f1435b);
        } else {
            this.f1436c.a(intent, 2357, null);
        }
    }

    public final boolean m1678a(ThreadKey threadKey) {
        return ThreadKey.d(threadKey) && !this.f1437d.m10499d();
    }

    public final boolean m1680a(boolean z) {
        return z && !this.f1437d.m10499d();
    }

    public final void m1681b() {
        boolean z = false;
        if (this.f1438e.a(SmsPrefKeys.f13575M, false) || this.f1439f.f10044a.a(1126, false)) {
            z = true;
        }
        MmsManager.a = z;
    }

    public final void m1682c() {
        m1683d();
        long a = ((Clock) this.f1442i.get()).a();
        Editor a2 = this.f1438e.edit().putBoolean(SmsPrefKeys.f13579b, true).a(SmsPrefKeys.f13566D).a(SmsPrefKeys.f13580c, a);
        if (!this.f1438e.a(SmsPrefKeys.f13598u)) {
            a2.a(SmsPrefKeys.f13598u, a);
        }
        a2.commit();
    }

    public final void m1676a(SmsCallerContext smsCallerContext) {
        m1682c();
        this.f1434a.m14226a((Object) smsCallerContext, SmsTakeoverState.NONE, SmsTakeoverState.READONLY);
        ((MmsSmsCacheUpdateAction) this.f1443j.get()).a();
    }

    public final void m1683d() {
        this.f1444k.m1695b(AnonymousSmsThreadHelper.b, "anonymous_thread_turned_off");
    }
}
