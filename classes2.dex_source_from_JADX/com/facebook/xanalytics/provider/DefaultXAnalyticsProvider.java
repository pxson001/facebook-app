package com.facebook.xanalytics.provider;

import android.content.Context;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.C0109x696ccb0c;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.xanalytics.XAnalyticsNative;
import com.facebook.xanalytics.XAnalyticsNative.XAnalyticsPropertiesProvider;
import com.facebook.xanalytics.XAnalyticsParams.Builder;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mAnimationDuration */
public class DefaultXAnalyticsProvider extends AbstractAuthComponent {
    private static final String f15717a = DefaultXAnalyticsProvider.class.toString();
    private static volatile DefaultXAnalyticsProvider f15718g;
    public final Context f15719b;
    public final XAnalyticsNative f15720c = new XAnalyticsNative();
    private final PlatformAppConfig f15721d;
    public final UniqueIdForDeviceHolderImpl f15722e;
    public final AppVersionInfo f15723f;

    /* compiled from: mAnimationDuration */
    class C07012 implements Runnable {
        final /* synthetic */ DefaultXAnalyticsProvider f16184a;

        C07012(DefaultXAnalyticsProvider defaultXAnalyticsProvider) {
            this.f16184a = defaultXAnalyticsProvider;
        }

        public void run() {
            this.f16184a.f15720c.resumeUploading(this.f16184a.f15719b.getCacheDir().getAbsolutePath());
        }
    }

    /* compiled from: mAnimationDuration */
    class C07023 implements Runnable {
        final /* synthetic */ DefaultXAnalyticsProvider f16185a;

        C07023(DefaultXAnalyticsProvider defaultXAnalyticsProvider) {
            this.f16185a = defaultXAnalyticsProvider;
        }

        public void run() {
            this.f16185a.f15720c.flush();
        }
    }

    public static com.facebook.xanalytics.provider.DefaultXAnalyticsProvider m22403a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15718g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.xanalytics.provider.DefaultXAnalyticsProvider.class;
        monitor-enter(r1);
        r0 = f15718g;	 Catch:{ all -> 0x003a }
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
        r0 = m22404b(r0);	 Catch:{ all -> 0x0035 }
        f15718g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15718g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.xanalytics.provider.DefaultXAnalyticsProvider.a(com.facebook.inject.InjectorLike):com.facebook.xanalytics.provider.DefaultXAnalyticsProvider");
    }

    private static DefaultXAnalyticsProvider m22404b(InjectorLike injectorLike) {
        return new DefaultXAnalyticsProvider(C0109x696ccb0c.m2944a(injectorLike), (PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), (Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 4442), AppVersionInfoMethodAutoProvider.m2629a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.m4339b(injectorLike));
    }

    @Inject
    DefaultXAnalyticsProvider(ScheduledExecutorService scheduledExecutorService, PlatformAppConfig platformAppConfig, Context context, final Provider<String> provider, AppVersionInfo appVersionInfo, UniqueIdForDeviceHolder uniqueIdForDeviceHolder) {
        this.f15721d = platformAppConfig;
        this.f15719b = context;
        this.f15722e = uniqueIdForDeviceHolder;
        this.f15723f = appVersionInfo;
        Builder builder = new Builder();
        builder.f16168a = this.f15721d.c();
        builder = builder;
        builder.f16169b = this.f15721d.e();
        builder = builder;
        builder.f16170c = this.f15719b.getCacheDir().getAbsolutePath();
        builder = builder;
        builder.f16171d = "graph.facebook.com";
        builder = builder;
        builder.f16172e = 11;
        builder = builder;
        builder.f16173f = 11;
        builder = builder;
        builder.f16174g = null;
        long a = this.f15720c.m22407a(builder.m23017a(), new XAnalyticsPropertiesProvider(this) {
            final /* synthetic */ DefaultXAnalyticsProvider f16183b;

            public String[] get() {
                return new String[]{this.f16183b.f15723f.mo367a(), (String) provider.get(), this.f16183b.f15722e.m4346a()};
            }
        });
        if (BuildConstants.i && a == 0) {
            throw new AssertionError(f15717a + ": FBAnalyticsCore Failed to Initialize.");
        }
        scheduledExecutorService.schedule(new C07012(this), 30000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new C07023(this), 30000, 1800000, TimeUnit.MILLISECONDS);
    }

    public final XAnalyticsNative r_() {
        return this.f15720c;
    }

    public final void mo2666c() {
        this.f15720c.onSwitchUserId();
    }

    public final void mo2901a() {
        this.f15720c.onSwitchUserId();
    }
}
