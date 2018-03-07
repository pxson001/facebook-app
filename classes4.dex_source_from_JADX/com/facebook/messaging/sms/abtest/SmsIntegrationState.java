package com.facebook.messaging.sms.abtest;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Telephony.Sms;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_deprecated */
public class SmsIntegrationState {
    private static final boolean f10035a = (VERSION.SDK_INT >= 19);
    private static volatile SmsIntegrationState f10036i;
    public final Context f10037b;
    private final Handler f10038c;
    private final SmsGatekeepers f10039d;
    private final FbSharedPreferences f10040e;
    private final Object f10041f = new Object();
    public ContentObserver f10042g;
    private TriState f10043h = TriState.UNSET;

    public static com.facebook.messaging.sms.abtest.SmsIntegrationState m10491a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10036i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.abtest.SmsIntegrationState.class;
        monitor-enter(r1);
        r0 = f10036i;	 Catch:{ all -> 0x003a }
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
        r0 = m10492b(r0);	 Catch:{ all -> 0x0035 }
        f10036i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10036i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.abtest.SmsIntegrationState.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.abtest.SmsIntegrationState");
    }

    private static SmsIntegrationState m10492b(InjectorLike injectorLike) {
        return new SmsIntegrationState((Context) injectorLike.getInstance(Context.class), Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), SmsGatekeepers.m10502b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public SmsIntegrationState(Context context, Handler handler, SmsGatekeepers smsGatekeepers, FbSharedPreferences fbSharedPreferences) {
        this.f10037b = context;
        this.f10038c = handler;
        this.f10039d = smsGatekeepers;
        this.f10040e = fbSharedPreferences;
    }

    public final boolean m10496a() {
        if (this.f10039d.f10044a.a(324, false) || m10497b() || m10499d()) {
            return true;
        }
        return false;
    }

    public final boolean m10497b() {
        return f10035a && !this.f10039d.m10505e() && this.f10040e.a(SmsPrefKeys.f13579b, false);
    }

    public final boolean m10498c() {
        return f10035a && this.f10040e.a(SmsPrefKeys.f13581d, false) && !m10496a();
    }

    public final boolean m10499d() {
        if (!this.f10039d.m10506g()) {
            return m10495h();
        }
        m10493f();
        Boolean asBooleanObject = this.f10043h.asBooleanObject();
        if (asBooleanObject != null) {
            return asBooleanObject.booleanValue();
        }
        boolean asBoolean;
        synchronized (this.f10041f) {
            if (this.f10043h == TriState.UNSET) {
                this.f10043h = m10495h() ? TriState.YES : TriState.NO;
            }
            asBoolean = this.f10043h.asBoolean();
        }
        return asBoolean;
    }

    public final void m10500e() {
        synchronized (this.f10041f) {
            this.f10043h = TriState.UNSET;
        }
        HandlerDetour.a(this.f10038c, new 1(this), -715986828);
    }

    private void m10493f() {
        if (this.f10042g == null) {
            synchronized (this.f10041f) {
                if (this.f10042g != null) {
                    return;
                }
                this.f10042g = m10494g();
                HandlerDetour.a(this.f10038c, new 2(this), 1179922269);
            }
        }
    }

    private ContentObserver m10494g() {
        return new 3(this, this.f10038c);
    }

    @TargetApi(19)
    private boolean m10495h() {
        try {
            if (!f10035a) {
                return false;
            }
            String defaultSmsPackage = Sms.getDefaultSmsPackage(this.f10037b);
            if (defaultSmsPackage == null || !defaultSmsPackage.equals(this.f10037b.getPackageName())) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            BLog.c("SmsIntegrationState", th, "Exception in detecting sms default app", new Object[0]);
            return false;
        }
    }
}
