package com.facebook.katana.orca;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.config.server.BootstrapPlatformAppHttpConfig;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.config.server.PresenceAwarePlatformHttpConfig;
import com.facebook.config.server.ServerConfig;
import com.facebook.config.server.UserAgentFactory;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.useragent.UserAgent;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: server_address_stage */
public class FbandroidProductionConfig implements ServerConfig {
    private static volatile FbandroidProductionConfig f5549f;
    public final Context f5550a;
    private final Provider<Boolean> f5551b;
    private final PlatformAppHttpConfig f5552c = new FbAndroidHttpConfig(this);
    private final PlatformAppHttpConfig f5553d;
    private final Provider<String> f5554e;

    /* compiled from: server_address_stage */
    class FbAndroidHttpConfig implements PlatformAppHttpConfig {
        final /* synthetic */ FbandroidProductionConfig f5567a;

        FbAndroidHttpConfig(FbandroidProductionConfig fbandroidProductionConfig) {
            this.f5567a = fbandroidProductionConfig;
        }

        private Builder m9481a(String str) {
            return Uri.parse(NetworkLogUrl.m12161a(this.f5567a.f5550a, "https://" + str + ".%s")).buildUpon();
        }

        public final Builder mo1359a() {
            return m9481a("api");
        }

        public final Builder mo1360b() {
            return m9481a("graph");
        }

        public final Builder mo1361c() {
            return m9481a("graph-video");
        }

        public final Builder mo1362d() {
            return Uri.parse("https://rupload.facebook.com").buildUpon();
        }

        public final Builder mo1363e() {
            return m9481a("graph.secure");
        }

        public final Builder mo1364f() {
            return m9481a("secure");
        }

        public final Builder mo1365g() {
            return Uri.parse(NetworkLogUrl.m12161a(this.f5567a.f5550a, "http://h.%s")).buildUpon();
        }

        public final String mo1366h() {
            return HttpOperation.m12197b(this.f5567a.f5550a);
        }

        public final String mo1367i() {
            return HttpOperation.m12195a(this.f5567a.f5550a);
        }
    }

    public static com.facebook.katana.orca.FbandroidProductionConfig m9456a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5549f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.orca.FbandroidProductionConfig.class;
        monitor-enter(r1);
        r0 = f5549f;	 Catch:{ all -> 0x003a }
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
        r0 = m9457b(r0);	 Catch:{ all -> 0x0035 }
        f5549f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5549f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.orca.FbandroidProductionConfig.a(com.facebook.inject.InjectorLike):com.facebook.katana.orca.FbandroidProductionConfig");
    }

    private static FbandroidProductionConfig m9457b(InjectorLike injectorLike) {
        return new FbandroidProductionConfig((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 3934), AppStateManager.m2245a(injectorLike), UserAgentFactory.m9470b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4448));
    }

    @Inject
    public FbandroidProductionConfig(Context context, Provider<Boolean> provider, AppStateManager appStateManager, UserAgentFactory userAgentFactory, Provider<String> provider2) {
        this.f5550a = context;
        this.f5551b = provider;
        this.f5554e = provider2;
        if (((Boolean) this.f5551b.get()).booleanValue()) {
            this.f5553d = new PresenceAwarePlatformHttpConfig(new BootstrapPlatformAppHttpConfig(this.f5554e), appStateManager, userAgentFactory.m9471a());
        } else {
            this.f5553d = this.f5552c;
        }
    }

    public final String mo1357d() {
        return UserAgent.m9521a(this.f5550a, Boolean.valueOf(false));
    }

    public final String mo1358e() {
        Context context = this.f5550a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("[%s/%s;%s/%s;]", "FBAN", UserAgent.m9523a(UserAgent.m9525b()), "FBAV", UserAgent.m9523a(UserAgent.m9530c(context))));
        return stringBuilder.toString();
    }

    public final PlatformAppHttpConfig mo1354a() {
        return this.f5552c;
    }

    public final PlatformAppHttpConfig mo1355b() {
        return this.f5552c;
    }

    public final PlatformAppHttpConfig mo1356c() {
        return this.f5553d;
    }
}
