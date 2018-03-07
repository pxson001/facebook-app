package com.facebook.http.config;

import android.annotation.SuppressLint;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.util.StringUtil;
import com.facebook.http.config.NetworkConfig.Listener;
import com.facebook.http.config.NetworkConfigUpdater.1;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxy.ConnectionState;
import com.facebook.http.onion.TorProxy.State;
import com.facebook.http.onion.TorProxy.TorListener;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.HttpHost;

@Singleton
/* compiled from: refresh_feed */
public class DefaultNetworkConfig {
    public static final HttpHost f7800e = null;
    private static final Set<PrefKey> f7801f = ImmutableSet.of(InternalHttpPrefKeys.f2515j, InternalHttpPrefKeys.f2517l, InternalHttpPrefKeys.f2523r, InternalHttpPrefKeys.f2525t);
    private static volatile DefaultNetworkConfig f7802l;
    public final FbSharedPreferences f7803a;
    public final CopyOnWriteArrayList<Listener> f7804b;
    private final OnSharedPreferenceChangeListener f7805c;
    private final TorProxy f7806d;
    public boolean f7807g = true;
    public boolean f7808h = false;
    public boolean f7809i = false;
    public HttpHost f7810j = f7800e;
    private final Provider<Boolean> f7811k;

    /* compiled from: refresh_feed */
    class C03261 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ DefaultNetworkConfig f7812a;

        C03261(DefaultNetworkConfig defaultNetworkConfig) {
            this.f7812a = defaultNetworkConfig;
        }

        public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            DefaultNetworkConfig.m12351d(this.f7812a);
        }
    }

    /* compiled from: refresh_feed */
    class C03272 implements TorListener {
        final /* synthetic */ DefaultNetworkConfig f7813a;

        C03272(DefaultNetworkConfig defaultNetworkConfig) {
            this.f7813a = defaultNetworkConfig;
        }

        public final void mo1681a() {
            DefaultNetworkConfig.m12351d(this.f7813a);
        }

        public final void mo1682a(State state, ConnectionState connectionState) {
        }
    }

    public static com.facebook.http.config.DefaultNetworkConfig m12349a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7802l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.config.DefaultNetworkConfig.class;
        monitor-enter(r1);
        r0 = f7802l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12350b(r0);	 Catch:{ all -> 0x0035 }
        f7802l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7802l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.config.DefaultNetworkConfig.a(com.facebook.inject.InjectorLike):com.facebook.http.config.DefaultNetworkConfig");
    }

    private static DefaultNetworkConfig m12350b(InjectorLike injectorLike) {
        return new DefaultNetworkConfig(FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4023), TorProxyMethodAutoProvider.m3888b(injectorLike));
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public DefaultNetworkConfig(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider, TorProxy torProxy) {
        this.f7803a = fbSharedPreferences;
        this.f7804b = new CopyOnWriteArrayList();
        this.f7811k = provider;
        this.f7806d = torProxy;
        this.f7805c = new C03261(this);
        this.f7803a.mo283a(f7801f, this.f7805c);
        this.f7806d.mo561a(new C03272(this));
        if (this.f7803a.mo284a()) {
            m12351d(this);
        } else {
            this.f7803a.mo280a(new 3(this));
        }
    }

    public final HttpHost m12353a() {
        return this.f7810j;
    }

    public final boolean m12354c() {
        return this.f7808h;
    }

    public static void m12351d(DefaultNetworkConfig defaultNetworkConfig) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = null;
        boolean z = true;
        if (defaultNetworkConfig.f7803a.mo284a()) {
            z = defaultNetworkConfig.f7803a.mo286a(InternalHttpPrefKeys.f2515j, true);
        }
        boolean z2 = z;
        if (z2 != defaultNetworkConfig.f7807g) {
            defaultNetworkConfig.f7807g = z2;
            obj3 = 1;
        }
        z = true;
        if (defaultNetworkConfig.f7803a.mo284a()) {
            boolean z3 = !"facebook.com".equals(defaultNetworkConfig.f7803a.mo278a(InternalHttpPrefKeys.f2523r, "facebook.com"));
            if (z3) {
                z = z3;
            } else if (StringUtil.m3589a(defaultNetworkConfig.f7803a.mo278a(InternalHttpPrefKeys.f2525t, ""))) {
                z = false;
            }
        } else {
            z = false;
        }
        z2 = z;
        if (z2 != defaultNetworkConfig.f7808h) {
            defaultNetworkConfig.f7808h = z2;
            obj3 = 1;
        }
        HttpHost g = defaultNetworkConfig.m12352g();
        if (g == null) {
            g = defaultNetworkConfig.f7806d.mo565c();
        }
        if (Objects.equal(defaultNetworkConfig.f7810j, g)) {
            obj = obj3;
        } else {
            defaultNetworkConfig.f7810j = g;
            obj = 1;
        }
        boolean booleanValue = ((Boolean) defaultNetworkConfig.f7811k.get()).booleanValue();
        if (booleanValue != defaultNetworkConfig.f7809i) {
            defaultNetworkConfig.f7809i = booleanValue;
        } else {
            obj2 = obj;
        }
        if (obj2 != null) {
            Iterator it = defaultNetworkConfig.f7804b.iterator();
            while (it.hasNext()) {
                ((1) it.next()).a();
            }
        }
    }

    private HttpHost m12352g() {
        if (!BuildConstants.i) {
            return null;
        }
        CharSequence a = this.f7803a.mo278a(InternalHttpPrefKeys.f2517l, null);
        if (StringUtil.m3589a(a)) {
            return null;
        }
        int indexOf = a.indexOf(58);
        if (indexOf == -1) {
            return null;
        }
        return new HttpHost(a.substring(0, indexOf), Integer.parseInt(a.substring(indexOf + 1)));
    }
}
