package com.facebook.push.fbnslite;

import android.content.Context;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.push.externalcloud.PushPrefKeysSelector;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.FacebookPushServerRegistrar.Callback;
import com.facebook.push.registration.Registrar;
import com.facebook.push.registration.Registrar.TokenStatus;
import com.facebook.push.registration.RegistrarHelper;
import com.facebook.push.registration.RegistrarHelperProvider;
import com.facebook.push.registration.ServiceType;
import com.facebook.rti.push.client.FbnsClientWrapper;
import com.facebook.rti.push.service.FbnsService;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: initial_fetch_complete */
public class FbnsLiteRegistrar implements Registrar {
    private static final Class<?> f10330b = FbnsLiteRegistrar.class;
    private static volatile FbnsLiteRegistrar f10331k;
    public final Callback f10332a = new C04691(this);
    public final RegistrarHelper f10333c;
    private final PushNotifAnalyticsLogger f10334d;
    private final PushTokenHolder f10335e;
    private final FacebookPushServerRegistrar f10336f;
    private final FbnsClientWrapper f10337g;
    private final FbAppType f10338h;
    private final Provider<String> f10339i;
    public final ExecutorService f10340j;

    /* compiled from: initial_fetch_complete */
    class C04691 implements Callback {
        final /* synthetic */ FbnsLiteRegistrar f10394a;

        C04691(FbnsLiteRegistrar fbnsLiteRegistrar) {
            this.f10394a = fbnsLiteRegistrar;
        }

        public final void mo802a() {
            this.f10394a.f10333c.m10935a(this.f10394a);
        }
    }

    /* compiled from: initial_fetch_complete */
    public class C04702 implements Runnable {
        final /* synthetic */ FbnsLiteRegistrar f10395a;

        public C04702(FbnsLiteRegistrar fbnsLiteRegistrar) {
            this.f10395a = fbnsLiteRegistrar;
        }

        public void run() {
            FbnsLiteRegistrar.m10862a(this.f10395a, "gk_off");
        }
    }

    public static com.facebook.push.fbnslite.FbnsLiteRegistrar m10861a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10331k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.fbnslite.FbnsLiteRegistrar.class;
        monitor-enter(r1);
        r0 = f10331k;	 Catch:{ all -> 0x003a }
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
        r0 = m10863b(r0);	 Catch:{ all -> 0x0035 }
        f10331k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10331k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.fbnslite.FbnsLiteRegistrar.a(com.facebook.inject.InjectorLike):com.facebook.push.fbnslite.FbnsLiteRegistrar");
    }

    private static FbnsLiteRegistrar m10863b(InjectorLike injectorLike) {
        return new FbnsLiteRegistrar((RegistrarHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RegistrarHelperProvider.class), PushPreferenceSelector.m10869a(injectorLike), PushPrefKeysSelector.m10873a(injectorLike), PushNotifAnalyticsLogger.m10876a(injectorLike), FacebookPushServerRegistrar.m10784a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), (Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4442), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FbnsLiteRegistrar(RegistrarHelperProvider registrarHelperProvider, PushPreferenceSelector pushPreferenceSelector, PushPrefKeysSelector pushPrefKeysSelector, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, FacebookPushServerRegistrar facebookPushServerRegistrar, FbAppType fbAppType, Context context, Provider<String> provider, ExecutorService executorService) {
        this.f10334d = pushNotifAnalyticsLogger;
        this.f10336f = facebookPushServerRegistrar;
        this.f10338h = fbAppType;
        this.f10339i = provider;
        this.f10340j = executorService;
        this.f10337g = new FbnsClientWrapper(context, FbnsService.class.getName());
        this.f10335e = pushPreferenceSelector.m10871a(ServiceType.FBNS_LITE);
        this.f10333c = registrarHelperProvider.m10868a(ServiceType.FBNS_LITE, pushPrefKeysSelector.m10875a(ServiceType.FBNS_LITE), this.f10335e);
    }

    public final void mo799a() {
        if (!StringUtil.a((CharSequence) this.f10339i.get())) {
            this.f10333c.m10936a(PushServerRegistrationClientEvent.ATTEMPT.name(), null);
            this.f10337g.a(this.f10338h.c());
            this.f10333c.m10936a(PushServerRegistrationClientEvent.SUCCESS.name(), null);
            this.f10333c.m10933a();
        }
    }

    public static void m10862a(@Nullable FbnsLiteRegistrar fbnsLiteRegistrar, String str) {
        if (fbnsLiteRegistrar.m10864f() != TokenStatus.NONE) {
            fbnsLiteRegistrar.f10337g.d();
            fbnsLiteRegistrar.m10867e();
            fbnsLiteRegistrar.f10333c.m10938b(PushServerUnregistrationClientEvent.ATTEMPT.name(), str);
            if (fbnsLiteRegistrar.f10336f.m10798a(ServiceType.FBNS_LITE)) {
                fbnsLiteRegistrar.f10335e.m10918h();
                fbnsLiteRegistrar.f10333c.m10938b(PushServerUnregistrationClientEvent.SUCCESS.name(), str);
                return;
            }
            fbnsLiteRegistrar.f10333c.m10938b(PushServerUnregistrationClientEvent.FAILED.name(), str);
        }
    }

    public final void m10866a(boolean z) {
        if (!StringUtil.a((CharSequence) this.f10339i.get())) {
            TokenStatus f = m10864f();
            this.f10334d.m10880a(ServiceType.FBNS_LITE.name(), f.name(), this.f10335e.m10910a());
            switch (3.a[f.ordinal()]) {
                case 1:
                    if (z) {
                        this.f10336f.m10797a(ServiceType.FBNS_LITE, this.f10332a);
                        return;
                    } else {
                        this.f10336f.m10799b(ServiceType.FBNS_LITE, this.f10332a);
                        return;
                    }
                case 2:
                case 3:
                    mo799a();
                    return;
                default:
                    throw new IllegalStateException(f.name());
            }
        }
    }

    private TokenStatus m10864f() {
        if (StringUtil.a(this.f10335e.m10910a())) {
            return TokenStatus.NONE;
        }
        if (this.f10335e.m10914c()) {
            return TokenStatus.UPGRADED;
        }
        return TokenStatus.CURRENT;
    }

    public final void m10867e() {
        this.f10333c.m10939c();
    }
}
