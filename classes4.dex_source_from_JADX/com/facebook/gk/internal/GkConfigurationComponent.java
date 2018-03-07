package com.facebook.gk.internal;

import android.os.Bundle;
import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.component.persistent.PersistentComponent.ComponentType;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.config.background.ConfigurationComponent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.internal.FetchGatekeepersParams.Session;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperStoreManager;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: suppress_http_code */
public class GkConfigurationComponent implements PersistentComponent, ConfigurationComponent {
    private static final Class<?> f1541a = GkConfigurationComponent.class;
    private static volatile GkConfigurationComponent f1542j;
    public final FbSharedPreferences f1543b;
    public final Lazy<FetchMobileGatekeepersMethod> f1544c;
    private final Lazy<Set<GatekeeperFetchListener>> f1545d;
    public final AppStateManager f1546e;
    private final Provider<Long> f1547f;
    private final GatekeeperStoreImpl f1548g;
    private final Provider<String> f1549h;
    private List<GatekeeperFetchListener> f1550i;

    /* compiled from: suppress_http_code */
    public class MyBatchComponent implements BatchComponent {
        public final /* synthetic */ GkConfigurationComponent f1552a;

        public MyBatchComponent(GkConfigurationComponent gkConfigurationComponent) {
            this.f1552a = gkConfigurationComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a((ApiMethod) this.f1552a.f1544c.get(), new FetchGatekeepersParams(RegularImmutableSet.a, Session.IS_NOT_SESSIONLESS));
            a.f11927c = "gk";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            Bundle bundle = (Bundle) map.get("gk");
            if (bundle != null) {
                List f = GkConfigurationComponent.m1761f(this.f1552a);
                if (!f.isEmpty()) {
                    int size = f.size();
                    for (int i = 0; i < size; i++) {
                        ((GatekeeperFetchListener) f.get(i)).mo84a(bundle);
                    }
                    GkConfigurationComponent gkConfigurationComponent = this.f1552a;
                    AppStateManager appStateManager = gkConfigurationComponent.f1546e;
                    if (appStateManager.W == Long.MIN_VALUE) {
                        AppStateManager.A(appStateManager);
                    }
                    long j = appStateManager.W;
                    gkConfigurationComponent.f1543b.edit().a(GkPrefKeys.e, j).commit();
                    Long.valueOf(j);
                }
            }
        }
    }

    public static com.facebook.gk.internal.GkConfigurationComponent m1759a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1542j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gk.internal.GkConfigurationComponent.class;
        monitor-enter(r1);
        r0 = f1542j;	 Catch:{ all -> 0x003a }
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
        r0 = m1760b(r0);	 Catch:{ all -> 0x0035 }
        f1542j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1542j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gk.internal.GkConfigurationComponent.a(com.facebook.inject.InjectorLike):com.facebook.gk.internal.GkConfigurationComponent");
    }

    private static GkConfigurationComponent m1760b(InjectorLike injectorLike) {
        return new GkConfigurationComponent((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 2109), ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$GatekeeperFetchListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), AppStateManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4429), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public GkConfigurationComponent(FbSharedPreferences fbSharedPreferences, Lazy<FetchMobileGatekeepersMethod> lazy, Lazy<Set<GatekeeperFetchListener>> lazy2, AppStateManager appStateManager, Provider<Long> provider, GatekeeperStoreManager gatekeeperStoreManager, Provider<String> provider2) {
        this.f1543b = fbSharedPreferences;
        this.f1544c = lazy;
        this.f1545d = lazy2;
        this.f1546e = appStateManager;
        this.f1547f = provider;
        this.f1548g = gatekeeperStoreManager;
        this.f1549h = provider2;
    }

    public final void mo94a() {
        String str = (String) this.f1549h.get();
        if (str != null) {
            this.f1548g.c(str);
        }
    }

    public final boolean cn_() {
        return this.f1548g.d();
    }

    public final BatchComponent mo95c() {
        return new MyBatchComponent(this);
    }

    public final void mo97d() {
        String str = (String) this.f1549h.get();
        if (str == null) {
            this.f1548g.c();
            return;
        }
        GatekeeperStoreImpl gatekeeperStoreImpl = this.f1548g;
        if (gatekeeperStoreImpl.e != null) {
            gatekeeperStoreImpl.e.a(str, gatekeeperStoreImpl.h);
        }
        gatekeeperStoreImpl.c();
    }

    public final ComponentType mo98e() {
        return ComponentType.OTHER;
    }

    public final BatchComponent mo101b() {
        return new MyBatchComponent(this);
    }

    public final long co_() {
        return ((Long) this.f1547f.get()).longValue();
    }

    public static synchronized List m1761f(GkConfigurationComponent gkConfigurationComponent) {
        List list;
        synchronized (gkConfigurationComponent) {
            if (gkConfigurationComponent.f1550i == null) {
                Set set = (Set) gkConfigurationComponent.f1545d.get();
                if (set.isEmpty()) {
                    gkConfigurationComponent.f1550i = Collections.emptyList();
                } else {
                    gkConfigurationComponent.f1550i = new ArrayList(set);
                }
            }
            list = gkConfigurationComponent.f1550i;
        }
        return list;
    }
}
