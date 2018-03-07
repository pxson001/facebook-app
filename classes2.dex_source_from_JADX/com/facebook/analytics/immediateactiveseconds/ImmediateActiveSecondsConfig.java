package com.facebook.analytics.immediateactiveseconds;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import java.util.zip.CRC32;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: map_url_image */
public class ImmediateActiveSecondsConfig {
    private static volatile ImmediateActiveSecondsConfig f15184f;
    public final Provider<String> f15185a;
    private final QeAccessor f15186b;
    private final FbAppType f15187c;
    private Params f15188d;
    public final AuthComponent f15189e = new AuthComponent(this);

    @Immutable
    /* compiled from: map_url_image */
    public class AuthComponent extends AbstractAuthComponent {
        final /* synthetic */ ImmediateActiveSecondsConfig f15190a;

        protected AuthComponent(ImmediateActiveSecondsConfig immediateActiveSecondsConfig) {
            this.f15190a = immediateActiveSecondsConfig;
        }

        public final void mo2846h() {
            this.f15190a.m21701b();
        }

        public final void mo2665a(@Nullable AuthenticationResult authenticationResult) {
            this.f15190a.m21701b();
        }
    }

    public static com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondsConfig m21698a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15184f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondsConfig.class;
        monitor-enter(r1);
        r0 = f15184f;	 Catch:{ all -> 0x003a }
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
        r0 = m21699b(r0);	 Catch:{ all -> 0x0035 }
        f15184f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15184f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondsConfig.a(com.facebook.inject.InjectorLike):com.facebook.analytics.immediateactiveseconds.ImmediateActiveSecondsConfig");
    }

    private static ImmediateActiveSecondsConfig m21699b(InjectorLike injectorLike) {
        return new ImmediateActiveSecondsConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4443), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    @Inject
    public ImmediateActiveSecondsConfig(QeAccessor qeAccessor, Provider<String> provider, FbAppType fbAppType) {
        this.f15186b = qeAccessor;
        this.f15185a = provider;
        this.f15187c = fbAppType;
    }

    protected final Params m21700a() {
        if (this.f15188d != null) {
            return this.f15188d;
        }
        long j;
        long j2;
        QeAccessor qeAccessor = this.f15186b;
        Liveness liveness = Liveness.Cached;
        ExposureLogging exposureLogging = ExposureLogging.Off;
        if (this.f15187c.j == Product.MESSENGER) {
            j = ExperimentsForImmediateActiveSecondsModule.a;
        } else {
            j = ExperimentsForImmediateActiveSecondsModule.b;
        }
        long a = qeAccessor.mo577a(liveness, exposureLogging, j, 2003);
        String str = (String) this.f15185a.get();
        if (str == null || a < 1) {
            j2 = -1;
        } else {
            CRC32 crc32 = new CRC32();
            crc32.update(str.getBytes());
            j2 = crc32.getValue() % a;
        }
        this.f15188d = new Params(a, j2);
        return this.f15188d;
    }

    @VisibleForTesting
    protected final void m21701b() {
        this.f15188d = null;
    }
}
