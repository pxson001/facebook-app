package com.facebook.push.externalcloud;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.AppInfo;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.fbns.FbnsRegistrar;
import com.facebook.push.fbns.FbnsRegistrar.2;
import com.facebook.push.fbnslite.FbnsLiteRegistrar;
import com.facebook.push.fbnslite.FbnsLiteRegistrar.C04702;
import com.facebook.push.registration.ServiceType;
import com.facebook.rti.orca.FbnsLiteInitializer;
import com.facebook.rti.orca.MqttLiteBroadcastReceiverRegistrar;
import com.facebook.rti.orca.MqttLiteInitializer;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: interactors_not_friend */
public class PushServiceSelector {
    private static final Class<?> f10228a = PushServiceSelector.class;
    private static volatile PushServiceSelector f10229o;
    private final HashSet<ServiceType> f10230b = Sets.a();
    private final Lazy<FbnsRegistrar> f10231c;
    private final Lazy<FbnsLiteRegistrar> f10232d;
    private final Provider<TriState> f10233e;
    public final PackageManager f10234f;
    public final Context f10235g;
    public final Lazy<MqttLiteInitializer> f10236h;
    public final Lazy<FbnsLiteInitializer> f10237i;
    public final Product f10238j;
    private final ExecutorService f10239k;
    public final MqttLiteBroadcastReceiverRegistrar f10240l;
    public final AppInfo f10241m;
    public final Runnable f10242n = new C04641(this);

    /* compiled from: interactors_not_friend */
    class C04641 implements Runnable {
        final /* synthetic */ PushServiceSelector f10303a;

        C04641(PushServiceSelector pushServiceSelector) {
            this.f10303a = pushServiceSelector;
        }

        public void run() {
            this.f10303a.m10729a();
        }
    }

    /* compiled from: interactors_not_friend */
    class C04652 implements Runnable {
        final /* synthetic */ PushServiceSelector f10304a;

        C04652(PushServiceSelector pushServiceSelector) {
            this.f10304a = pushServiceSelector;
        }

        public void run() {
            this.f10304a.f10240l.a(this.f10304a.f10242n);
        }
    }

    public static com.facebook.push.externalcloud.PushServiceSelector m10724a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10229o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.externalcloud.PushServiceSelector.class;
        monitor-enter(r1);
        r0 = f10229o;	 Catch:{ all -> 0x003a }
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
        r0 = m10725b(r0);	 Catch:{ all -> 0x0035 }
        f10229o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10229o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.externalcloud.PushServiceSelector.a(com.facebook.inject.InjectorLike):com.facebook.push.externalcloud.PushServiceSelector");
    }

    private static PushServiceSelector m10725b(InjectorLike injectorLike) {
        return new PushServiceSelector(IdBasedLazy.a(injectorLike, 3175), IdBasedSingletonScopeProvider.b(injectorLike, 3178), IdBasedProvider.a(injectorLike, 750), PackageManagerMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 3361), IdBasedSingletonScopeProvider.b(injectorLike, 3359), ProductMethodAutoProvider.b(injectorLike), MqttLiteBroadcastReceiverRegistrar.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), AppInfo.a(injectorLike));
    }

    @Inject
    public PushServiceSelector(Lazy<FbnsRegistrar> lazy, Lazy<FbnsLiteRegistrar> lazy2, Provider<TriState> provider, PackageManager packageManager, Context context, Lazy<MqttLiteInitializer> lazy3, Lazy<FbnsLiteInitializer> lazy4, Product product, MqttLiteBroadcastReceiverRegistrar mqttLiteBroadcastReceiverRegistrar, ExecutorService executorService, AppInfo appInfo) {
        this.f10233e = provider;
        this.f10231c = lazy;
        this.f10232d = lazy2;
        this.f10234f = packageManager;
        this.f10235g = context;
        this.f10236h = lazy3;
        this.f10237i = lazy4;
        this.f10238j = product;
        this.f10239k = executorService;
        this.f10240l = mqttLiteBroadcastReceiverRegistrar;
        this.f10241m = appInfo;
        if (m10727e()) {
            this.f10230b.add(ServiceType.ADM);
        } else if (m10728f()) {
            this.f10230b.add(ServiceType.NNA);
        } else {
            this.f10230b.add(ServiceType.GCM);
        }
        m10726c();
    }

    private void m10726c() {
        if (Product.MESSENGER == this.f10238j || Product.FB4A == this.f10238j) {
            ExecutorDetour.a(this.f10239k, new C04652(this), -690812016);
        }
    }

    public final void m10730a(final String str, final Class... clsArr) {
        ExecutorDetour.a(this.f10239k, new Runnable(this) {
            final /* synthetic */ PushServiceSelector f10449c;

            public void run() {
                for (Class componentName : clsArr) {
                    ComponentName componentName2 = new ComponentName(this.f10449c.f10235g, componentName);
                    Object obj = 1;
                    if (1 != this.f10449c.f10234f.getComponentEnabledSetting(componentName2)) {
                        obj = null;
                    }
                    if (obj != null) {
                        componentName2.toString();
                    } else if (this.f10449c.f10241m.e(str)) {
                        this.f10449c.f10234f.setComponentEnabledSetting(componentName2, 1, 1);
                        componentName2.toString();
                    }
                }
            }
        }, 1305879776);
    }

    public final boolean m10731a(ServiceType serviceType) {
        m10729a();
        return this.f10230b.contains(serviceType);
    }

    public final Set<ServiceType> m10729a() {
        if (!(m10727e() || m10728f())) {
            boolean z;
            if (Product.MESSENGER == this.f10238j || Product.FB4A == this.f10238j) {
                int j = ((MqttLiteInitializer) this.f10236h.get()).j();
                if (j < 0 || (j & 4) == 0) {
                    FbnsLiteInitializer fbnsLiteInitializer = (FbnsLiteInitializer) this.f10237i.get();
                    boolean z2 = (Product.MESSENGER == fbnsLiteInitializer.i || Product.FB4A == fbnsLiteInitializer.i) ? fbnsLiteInitializer.f.get() == null ? false : ((Boolean) fbnsLiteInitializer.c.get()).booleanValue() || ((Boolean) fbnsLiteInitializer.d.get()).booleanValue() : false;
                    z = z2;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            boolean z3 = z;
            Boolean.valueOf(z3);
            if (z3) {
                this.f10230b.add(ServiceType.FBNS_LITE);
            } else {
                FbnsLiteRegistrar fbnsLiteRegistrar = (FbnsLiteRegistrar) this.f10232d.get();
                ExecutorDetour.a(fbnsLiteRegistrar.f10340j, new C04702(fbnsLiteRegistrar), -1954795751);
                this.f10230b.remove(ServiceType.FBNS_LITE);
            }
            boolean equals = TriState.YES.equals(this.f10233e.get());
            if (z3 || !equals) {
                FbnsRegistrar fbnsRegistrar = (FbnsRegistrar) this.f10231c.get();
                if (!StringUtil.a(fbnsRegistrar.f10497e.m10910a())) {
                    ExecutorDetour.a(fbnsRegistrar.f10501i, new 2(fbnsRegistrar), -1417846747);
                }
                this.f10230b.remove(ServiceType.FBNS);
            } else {
                this.f10230b.add(ServiceType.FBNS);
            }
        }
        this.f10230b.toString();
        return Sets.b(this.f10230b);
    }

    public static boolean m10727e() {
        return "Amazon".equals(Build.MANUFACTURER) || "SD4930UR".equals(Build.MODEL);
    }

    public static boolean m10728f() {
        return "Nokia".equals(Build.MANUFACTURER) && !"N1".equals(Build.MODEL);
    }
}
