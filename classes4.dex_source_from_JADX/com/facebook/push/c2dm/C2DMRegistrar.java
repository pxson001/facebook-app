package com.facebook.push.c2dm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.AppInfo;
import com.facebook.content.SecurePendingIntent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.analytics.GooglePlayServicesDetector;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.c2dm.configs.GcmTokenRefreshParameters;
import com.facebook.push.c2dm.configs.GcmTokenRefreshXConfigController;
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
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: in_deploy_group */
public class C2DMRegistrar implements Registrar {
    public static final Class<?> f10406b = C2DMRegistrar.class;
    private static volatile C2DMRegistrar f10407p;
    public final Callback f10408a = new C04721(this);
    public final Context f10409c;
    private final FbSharedPreferences f10410d;
    public final PushNotifAnalyticsLogger f10411e;
    private final FbNetworkManager f10412f;
    public final FacebookPushServerRegistrar f10413g;
    public final PushTokenHolder f10414h;
    private final Clock f10415i;
    private final Product f10416j;
    public final RegistrarHelper f10417k;
    private final PushPrefKeys f10418l;
    private final GcmTokenRefreshXConfigController f10419m;
    private final GooglePlayServicesDetector f10420n;
    public final AppInfo f10421o;

    /* compiled from: in_deploy_group */
    class C04721 implements Callback {
        final /* synthetic */ C2DMRegistrar f10433a;

        C04721(C2DMRegistrar c2DMRegistrar) {
            this.f10433a = c2DMRegistrar;
        }

        public final void mo802a() {
            this.f10433a.f10417k.m10935a(this.f10433a);
        }
    }

    public static com.facebook.push.c2dm.C2DMRegistrar m10954a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10407p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.c2dm.C2DMRegistrar.class;
        monitor-enter(r1);
        r0 = f10407p;	 Catch:{ all -> 0x003a }
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
        r0 = m10955b(r0);	 Catch:{ all -> 0x0035 }
        f10407p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10407p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.c2dm.C2DMRegistrar.a(com.facebook.inject.InjectorLike):com.facebook.push.c2dm.C2DMRegistrar");
    }

    private static C2DMRegistrar m10955b(InjectorLike injectorLike) {
        return new C2DMRegistrar((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PushNotifAnalyticsLogger.m10876a(injectorLike), FbNetworkManager.a(injectorLike), FacebookPushServerRegistrar.m10784a(injectorLike), PushPreferenceSelector.m10869a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), PushPrefKeysSelector.m10873a(injectorLike), (RegistrarHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RegistrarHelperProvider.class), ProductMethodAutoProvider.b(injectorLike), GooglePlayServicesDetector.m10963a(injectorLike), AppInfo.a(injectorLike), GcmTokenRefreshXConfigController.m10966a(injectorLike));
    }

    @Inject
    public C2DMRegistrar(Context context, FbSharedPreferences fbSharedPreferences, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, FbNetworkManager fbNetworkManager, FacebookPushServerRegistrar facebookPushServerRegistrar, PushPreferenceSelector pushPreferenceSelector, Clock clock, PushPrefKeysSelector pushPrefKeysSelector, RegistrarHelperProvider registrarHelperProvider, Product product, GooglePlayServicesDetector googlePlayServicesDetector, AppInfo appInfo, GcmTokenRefreshXConfigController gcmTokenRefreshXConfigController) {
        this.f10409c = context;
        this.f10410d = fbSharedPreferences;
        this.f10411e = pushNotifAnalyticsLogger;
        this.f10412f = fbNetworkManager;
        this.f10413g = facebookPushServerRegistrar;
        this.f10415i = clock;
        this.f10416j = product;
        this.f10420n = googlePlayServicesDetector;
        this.f10421o = appInfo;
        this.f10419m = gcmTokenRefreshXConfigController;
        this.f10414h = pushPreferenceSelector.m10871a(ServiceType.GCM);
        this.f10418l = pushPrefKeysSelector.m10875a(ServiceType.GCM);
        this.f10417k = registrarHelperProvider.m10868a(ServiceType.GCM, this.f10418l, this.f10414h);
    }

    public final void mo799a() {
        Intent a = m10953a("com.google.android.c2dm.intent.REGISTER");
        this.f10417k.m10936a(PushServerRegistrationClientEvent.ATTEMPT.name(), a != null ? a.getPackage() : "missing-package");
        if (a != null) {
            this.f10417k.m10933a();
            Parcelable b = SecurePendingIntent.m10163b(this.f10409c, 0, new Intent(), 0);
            boolean equals = "com.google.android.gsf".equals(a.getPackage());
            a.putExtra("app", b);
            a.putExtra("sender", equals ? "facebook.android@gmail.com" : "15057814354");
            this.f10414h.m10912a(ServiceType.GCM.name(), equals);
            try {
                ComponentName startService = this.f10409c.startService(a);
                new StringBuilder("startService=").append(startService);
                if (startService == null) {
                    this.f10417k.m10936a(PushServerRegistrationClientEvent.MISSING_COMPONENT.name(), null);
                }
            } catch (Throwable e) {
                BLog.b(f10406b, e, "Cannot start registraiton service %s", new Object[]{"com.google.android.c2dm.intent.REGISTER"});
                this.f10417k.m10939c();
                this.f10417k.m10936a(PushServerRegistrationClientEvent.PERMISSION_DENIED.name(), null);
            }
        }
    }

    private void m10956c() {
        this.f10411e.m10879a(PushServerUnregistrationClientEvent.ATTEMPT.name(), this.f10414h.m10910a());
        Intent a = m10953a("com.google.android.c2dm.intent.UNREGISTER");
        if (a != null) {
            a.putExtra("app", SecurePendingIntent.m10163b(this.f10409c, 0, new Intent(), 0));
            try {
                this.f10409c.startService(a);
            } catch (SecurityException e) {
            }
        }
        this.f10413g.m10798a(ServiceType.GCM);
        this.f10414h.m10918h();
    }

    private TokenStatus m10957d() {
        if (StringUtil.a(this.f10414h.m10910a())) {
            return TokenStatus.NONE;
        }
        if (this.f10414h.m10914c()) {
            return TokenStatus.UPGRADED;
        }
        if (m10958e() && this.f10414h.m10916f()) {
            return TokenStatus.WRONG_TYPE;
        }
        long a = this.f10415i.a();
        long l = this.f10414h.m10921l();
        long a2 = this.f10410d.a(this.f10418l.f10377f, 0);
        GcmTokenRefreshParameters a3 = this.f10419m.m10968a(this.f10416j.name());
        if (a - l <= a3.a * 1000 || a - a2 <= a3.b * 1000) {
            return TokenStatus.CURRENT;
        }
        Long.valueOf((a / 1000) - a3.a);
        Long.valueOf(l);
        Long.valueOf((a / 1000) - a3.b);
        Long.valueOf(a2);
        return TokenStatus.EXPIRED;
    }

    public final void m10960a(boolean z) {
        TokenStatus d = m10957d();
        d.toString();
        Boolean.valueOf(z);
        Map c = Maps.c();
        c.put("force_fb_reg", String.valueOf(z));
        if (TokenStatus.NONE == d || TokenStatus.UPGRADED == d || TokenStatus.WRONG_TYPE == d) {
            c.putAll(this.f10420n.m10965a());
            c.toString();
        }
        if (d != TokenStatus.CURRENT) {
            this.f10411e.m10884a(d.name(), this.f10414h.m10910a(), c);
        }
        switch (d) {
            case CURRENT:
                if (z) {
                    this.f10413g.m10797a(ServiceType.GCM, this.f10408a);
                    return;
                } else {
                    this.f10413g.m10799b(ServiceType.GCM, this.f10408a);
                    return;
                }
            case WRONG_TYPE:
                m10956c();
                break;
            case EXPIRED:
                if (!this.f10412f.d()) {
                    return;
                }
                break;
            case UPGRADED:
            case NONE:
                break;
            default:
                return;
        }
        mo799a();
    }

    private Intent m10953a(String str) {
        String b = m10961b();
        if (b == null) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(b);
        return intent;
    }

    public final String m10961b() {
        if (m10958e()) {
            return "com.google.android.gms";
        }
        int i = 0;
        if (this.f10421o.d("com.google.android.gsf", 0) != null) {
            i = 1;
        }
        if (i != 0) {
            return "com.google.android.gsf";
        }
        return null;
    }

    private boolean m10958e() {
        return this.f10421o.d("com.google.android.gms", 0) != null;
    }
}
