package com.facebook.push.adm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.PushSource;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.externalcloud.PushPrefKeysSelector;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.fbpushtoken.PushPrefKeys;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.FacebookPushServerRegistrar.Callback;
import com.facebook.push.registration.Registrar;
import com.facebook.push.registration.Registrar.TokenStatus;
import com.facebook.push.registration.RegistrarHelper;
import com.facebook.push.registration.RegistrarHelperProvider;
import com.facebook.push.registration.ServiceType;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: instant_article/?article_id=%s */
public class ADMRegistrar implements Registrar {
    private static final Class<?> f10262b = ADMRegistrar.class;
    private static volatile ADMRegistrar f10263l;
    public final Callback f10264a = new 1(this);
    private final Context f10265c;
    public final FbSharedPreferences f10266d;
    private final PushNotifAnalyticsLogger f10267e;
    private final FbNetworkManager f10268f;
    private final FacebookPushServerRegistrar f10269g;
    public final PushTokenHolder f10270h;
    public final Clock f10271i;
    public final RegistrarHelper f10272j;
    public final PushPrefKeys f10273k;

    public static com.facebook.push.adm.ADMRegistrar m10766a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10263l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.adm.ADMRegistrar.class;
        monitor-enter(r1);
        r0 = f10263l;	 Catch:{ all -> 0x003a }
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
        r0 = m10767b(r0);	 Catch:{ all -> 0x0035 }
        f10263l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10263l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.adm.ADMRegistrar.a(com.facebook.inject.InjectorLike):com.facebook.push.adm.ADMRegistrar");
    }

    private static ADMRegistrar m10767b(InjectorLike injectorLike) {
        return new ADMRegistrar((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PushNotifAnalyticsLogger.m10876a(injectorLike), FbNetworkManager.a(injectorLike), FacebookPushServerRegistrar.m10784a(injectorLike), PushPreferenceSelector.m10869a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PushPrefKeysSelector.m10873a(injectorLike), (RegistrarHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RegistrarHelperProvider.class));
    }

    @Inject
    public ADMRegistrar(Context context, FbSharedPreferences fbSharedPreferences, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, FbNetworkManager fbNetworkManager, FacebookPushServerRegistrar facebookPushServerRegistrar, PushPreferenceSelector pushPreferenceSelector, Clock clock, PushPrefKeysSelector pushPrefKeysSelector, RegistrarHelperProvider registrarHelperProvider) {
        this.f10265c = context;
        this.f10266d = fbSharedPreferences;
        this.f10267e = pushNotifAnalyticsLogger;
        this.f10268f = fbNetworkManager;
        this.f10269g = facebookPushServerRegistrar;
        this.f10271i = clock;
        this.f10270h = pushPreferenceSelector.m10871a(ServiceType.ADM);
        this.f10273k = pushPrefKeysSelector.m10875a(ServiceType.ADM);
        this.f10272j = registrarHelperProvider.m10868a(ServiceType.ADM, this.f10273k, this.f10270h);
    }

    public final void mo799a() {
        this.f10272j.m10936a(PushServerRegistrationClientEvent.ATTEMPT.name(), null);
        this.f10272j.m10933a();
        Intent intent = new Intent(this.f10265c, ADMRegistrarService.class);
        intent.putExtra("app", PendingIntent.getBroadcast(this.f10265c, 0, new Intent(), 0));
        intent.putExtra("REQUEST", "REGISTER");
        this.f10266d.edit().a(this.f10273k.f10378g, ServiceType.ADM.name()).commit();
        new StringBuilder("startService=").append(this.f10265c.startService(intent));
    }

    private void m10768b() {
        this.f10272j.m10938b(PushServerUnregistrationClientEvent.ATTEMPT.name(), null);
        Intent intent = new Intent(this.f10265c, ADMRegistrarService.class);
        intent.putExtra("REQUEST", "UNREGISTER");
        intent.putExtra("app", PendingIntent.getBroadcast(this.f10265c, 0, new Intent(), 0));
        this.f10265c.startService(intent);
        this.f10269g.m10798a(ServiceType.ADM);
        this.f10270h.m10918h();
    }

    public final void m10771a(boolean z) {
        TokenStatus tokenStatus;
        if (StringUtil.a(this.f10270h.m10910a())) {
            tokenStatus = TokenStatus.NONE;
        } else if (this.f10270h.m10914c()) {
            tokenStatus = TokenStatus.UPGRADED;
        } else {
            long a = this.f10271i.a();
            long l = this.f10270h.m10921l();
            long a2 = this.f10266d.a(this.f10273k.f10377f, 0);
            if (a - l <= 604800000 || a - a2 <= 172800000) {
                tokenStatus = TokenStatus.CURRENT;
            } else {
                tokenStatus = TokenStatus.EXPIRED;
            }
        }
        TokenStatus tokenStatus2 = tokenStatus;
        tokenStatus2.toString();
        Boolean.valueOf(z);
        this.f10267e.m10880a(PushSource.ADM.toString(), tokenStatus2.toString(), this.f10270h.m10910a());
        switch (2.a[tokenStatus2.ordinal()]) {
            case 1:
                if (z) {
                    this.f10269g.m10797a(ServiceType.ADM, this.f10264a);
                    return;
                } else {
                    this.f10269g.m10799b(ServiceType.ADM, this.f10264a);
                    return;
                }
            case 2:
                m10768b();
                break;
            case 3:
                if (!this.f10268f.d()) {
                    return;
                }
                break;
            case 4:
            case 5:
                break;
            default:
                return;
        }
        mo799a();
    }

    final void m10770a(String str, String str2, boolean z) {
        Boolean.valueOf(z);
        this.f10270h.m10910a();
        if (z) {
            this.f10270h.m10918h();
            this.f10272j.m10938b(PushServerUnregistrationClientEvent.SUCCESS.name(), null);
            return;
        }
        this.f10272j.m10939c();
        if (str2 != null) {
            this.f10270h.m10918h();
            BLog.b(f10262b, "Registration error " + str2);
            if ("ERROR_AUTHENTICATION_FAILED".equals(str2)) {
                Intent intent = new Intent(this.f10265c, ADMRegistrarService.class);
                PendingIntent broadcast = PendingIntent.getBroadcast(this.f10265c, 0, intent, 0);
                intent.putExtra("app", broadcast);
                intent.putExtra("REQUEST", "REGISTER");
                this.f10272j.m10934a(broadcast);
            }
            this.f10272j.m10936a(str2.toLowerCase(Locale.US), null);
            return;
        }
        this.f10270h.m10911a(str, this.f10270h.m10913b());
        this.f10272j.m10936a(PushServerRegistrationClientEvent.SUCCESS.name(), null);
        this.f10269g.m10797a(ServiceType.ADM, this.f10264a);
    }
}
