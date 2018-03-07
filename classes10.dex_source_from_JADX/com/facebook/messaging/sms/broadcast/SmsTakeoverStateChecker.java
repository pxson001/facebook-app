package com.facebook.messaging.sms.broadcast;

import android.content.Intent;
import android.os.Build.VERSION;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.time.Clock;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.analytics.SmsTakeoverState;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.messaging.sms.readonly.ReadOnlyModeObserver;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: qrcode_import_oom */
public class SmsTakeoverStateChecker {
    private static final Object f4092a = new Object();
    private static SmsTakeoverContactsObserver f4093b;
    private static final Object f4094p = new Object();
    public final SmsIntegrationState f4095c;
    private final Lazy<SmsTakeoverStateChangedHandler> f4096d;
    private final Provider<SmsTakeoverContactsObserver> f4097e;
    private final FbSharedPreferences f4098f;
    public final Lazy<SmsPermissionsUtil> f4099g;
    public final Lazy<ReadOnlyModeObserver> f4100h;
    private final Lazy<SmsTakeoverAnalyticsLogger> f4101i;
    private final Lazy<SmsDefaultAppManager> f4102j;
    private final Lazy<SmsGatekeepers> f4103k;
    private final Lazy<SmsTakeoverMultiverseExperimentHelper> f4104l;
    private final Lazy<Clock> f4105m;
    public int f4106n;
    public boolean f4107o;

    /* compiled from: qrcode_import_oom */
    class C06131 implements Runnable {
        final /* synthetic */ SmsTakeoverStateChecker f4091a;

        C06131(SmsTakeoverStateChecker smsTakeoverStateChecker) {
            this.f4091a = smsTakeoverStateChecker;
        }

        public void run() {
            ((SmsPermissionsUtil) this.f4091a.f4099g.get()).a();
            ((ReadOnlyModeObserver) this.f4091a.f4100h.get()).a();
            SmsTakeoverStateChecker.m3766c(this.f4091a);
            this.f4091a.f4107o = false;
        }
    }

    private static SmsTakeoverStateChecker m3765b(InjectorLike injectorLike) {
        return new SmsTakeoverStateChecker(SmsIntegrationState.a(injectorLike), IdBasedLazy.a(injectorLike, 8449), IdBasedProvider.a(injectorLike, 8448), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8460), IdBasedLazy.a(injectorLike, 8485), IdBasedLazy.a(injectorLike, 2706), IdBasedSingletonScopeProvider.b(injectorLike, 2709), IdBasedLazy.a(injectorLike, 2703), IdBasedLazy.a(injectorLike, 2705), IdBasedSingletonScopeProvider.b(injectorLike, 609));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sms.broadcast.SmsTakeoverStateChecker m3763a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4094p;	 Catch:{ all -> 0x006c }
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
        r1 = m3765b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4094p;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.broadcast.SmsTakeoverStateChecker) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sms.broadcast.SmsTakeoverStateChecker) r0;	 Catch:{  }
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
        r0 = f4094p;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.broadcast.SmsTakeoverStateChecker) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.broadcast.SmsTakeoverStateChecker.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.broadcast.SmsTakeoverStateChecker");
    }

    @Inject
    public SmsTakeoverStateChecker(SmsIntegrationState smsIntegrationState, Lazy<SmsTakeoverStateChangedHandler> lazy, Provider<SmsTakeoverContactsObserver> provider, FbSharedPreferences fbSharedPreferences, Lazy<SmsPermissionsUtil> lazy2, Lazy<ReadOnlyModeObserver> lazy3, Lazy<SmsTakeoverAnalyticsLogger> lazy4, Lazy<SmsDefaultAppManager> lazy5, Lazy<SmsGatekeepers> lazy6, Lazy<SmsTakeoverMultiverseExperimentHelper> lazy7, Lazy<Clock> lazy8) {
        this.f4095c = smsIntegrationState;
        this.f4096d = lazy;
        this.f4097e = provider;
        this.f4098f = fbSharedPreferences;
        this.f4099g = lazy2;
        this.f4100h = lazy3;
        this.f4102j = lazy5;
        this.f4101i = lazy4;
        this.f4103k = lazy6;
        this.f4104l = lazy7;
        this.f4105m = lazy8;
    }

    public final void m3768a(DefaultAppChoreographer defaultAppChoreographer) {
        synchronized (f4092a) {
            if (this.f4107o) {
                return;
            }
            this.f4107o = true;
            defaultAppChoreographer.a("Maybe update and check for SMS states change", new C06131(this), Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.BACKGROUND);
        }
    }

    public static void m3766c(SmsTakeoverStateChecker smsTakeoverStateChecker) {
        synchronized (f4092a) {
            boolean a = smsTakeoverStateChecker.f4098f.a(SmsPrefKeys.A, false);
            boolean a2 = smsTakeoverStateChecker.f4098f.a(SmsPrefKeys.z, false);
            boolean d = smsTakeoverStateChecker.f4095c.d();
            if (d) {
                Editor edit = smsTakeoverStateChecker.f4098f.edit();
                if (smsTakeoverStateChecker.f4098f.a(SmsPrefKeys.b)) {
                    edit.a(SmsPrefKeys.b);
                }
                ((SmsDefaultAppManager) smsTakeoverStateChecker.f4102j.get()).d();
                if (smsTakeoverStateChecker.f4098f.a(SmsPrefKeys.D)) {
                    edit.a(SmsPrefKeys.D);
                }
                if (!smsTakeoverStateChecker.f4098f.a(SmsPrefKeys.B, false)) {
                    edit.putBoolean(SmsPrefKeys.B, true);
                }
                edit.commit();
            } else if (!smsTakeoverStateChecker.f4098f.a(SmsPrefKeys.b) && ((SmsPermissionsUtil) smsTakeoverStateChecker.f4099g.get()).b() && smsTakeoverStateChecker.m3767d()) {
                Object obj;
                SmsTakeoverState smsTakeoverState;
                ((SmsDefaultAppManager) smsTakeoverStateChecker.f4102j.get()).c();
                SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger = (SmsTakeoverAnalyticsLogger) smsTakeoverStateChecker.f4101i.get();
                if (a) {
                    obj = SmsCallerContext.SYSTEM_CHANGE;
                } else {
                    SmsCallerContext smsCallerContext = SmsCallerContext.AUTO_ENROLL;
                }
                if (a) {
                    smsTakeoverState = SmsTakeoverState.FULL;
                } else {
                    smsTakeoverState = SmsTakeoverState.NONE;
                }
                smsTakeoverAnalyticsLogger.a(obj, smsTakeoverState, SmsTakeoverState.READONLY);
            } else if (!smsTakeoverStateChecker.f4098f.a(SmsPrefKeys.d) && ((SmsTakeoverMultiverseExperimentHelper) smsTakeoverStateChecker.f4104l.get()).a(true)) {
                smsTakeoverStateChecker.f4098f.edit().putBoolean(SmsPrefKeys.d, true).commit();
            }
            boolean a3 = smsTakeoverStateChecker.f4095c.a();
            if (a3) {
                if (f4093b == null) {
                    SmsTakeoverContactsObserver smsTakeoverContactsObserver = (SmsTakeoverContactsObserver) smsTakeoverStateChecker.f4097e.get();
                    f4093b = smsTakeoverContactsObserver;
                    smsTakeoverContactsObserver.m3761a();
                }
            } else if (f4093b != null) {
                f4093b.m3762b();
                f4093b = null;
            }
            smsTakeoverStateChecker.m3764a(a, d, a2, a3);
        }
    }

    private void m3764a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z2 != z || z4 != z3) {
            Editor edit = this.f4098f.edit();
            if (z2 && !z) {
                edit.putBoolean(SmsPrefKeys.E, false).putBoolean(SmsPrefKeys.x, false);
                if (!this.f4098f.a(SmsPrefKeys.u)) {
                    edit.a(SmsPrefKeys.u, ((Clock) this.f4105m.get()).a());
                }
            }
            if (z4 && this.f4098f.a(SmsPrefKeys.I, false)) {
                edit.putBoolean(SmsPrefKeys.I, false);
            }
            edit.putBoolean(SmsPrefKeys.A, z2).putBoolean(SmsPrefKeys.z, z4).commit();
            SmsTakeoverStateChangedHandler smsTakeoverStateChangedHandler = (SmsTakeoverStateChangedHandler) this.f4096d.get();
            Boolean.valueOf(z2);
            Boolean.valueOf(z4);
            if (z2) {
                smsTakeoverStateChangedHandler.f4086a.sendBroadcast(new Intent("com.facebook.messaging.sms.REQUEST_SEND_MESSAGE", null, smsTakeoverStateChangedHandler.f4086a, SmsReceiver.class));
            } else {
                smsTakeoverStateChangedHandler.f4090e.a();
            }
            smsTakeoverStateChangedHandler.f4087b.clearUserData();
            smsTakeoverStateChangedHandler.f4088c.a();
            Intent intent = new Intent(MessagesBroadcastIntents.y);
            intent.putExtra("default_sms", z2);
            intent.putExtra("sms_enabled", z4);
            smsTakeoverStateChangedHandler.f4089d.a(intent);
        }
    }

    private boolean m3767d() {
        if (VERSION.SDK_INT < 19 || ((SmsGatekeepers) this.f4103k.get()).e()) {
            return false;
        }
        return this.f4098f.a(SmsPrefKeys.B, false);
    }
}
