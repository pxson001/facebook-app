package com.facebook.assetdownload;

import com.facebook.assetdownload.background.AssetDownloadConditionalWorker;
import com.facebook.assetdownload.local.DownloadLocalFileMapper;
import com.facebook.assetdownload.repository.AssetDownloadConfigurationRepository;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: failed trying to get cursor during query */
public class AssetDownloadManager {
    private static volatile AssetDownloadManager f12320g;
    private final AssetDownloadConfigurationRepository f12321a;
    private final DownloadLocalFileMapper f12322b;
    private final Provider<Boolean> f12323c;
    private final DefaultAndroidThreadUtil f12324d;
    public final Provider<AssetDownloadConditionalWorker> f12325e;
    private Pattern f12326f = null;

    public static com.facebook.assetdownload.AssetDownloadManager m12999a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12320g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.assetdownload.AssetDownloadManager.class;
        monitor-enter(r1);
        r0 = f12320g;	 Catch:{ all -> 0x003a }
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
        r0 = m13001b(r0);	 Catch:{ all -> 0x0035 }
        f12320g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12320g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.assetdownload.AssetDownloadManager.a(com.facebook.inject.InjectorLike):com.facebook.assetdownload.AssetDownloadManager");
    }

    private static AssetDownloadManager m13001b(InjectorLike injectorLike) {
        return new AssetDownloadManager(AssetDownloadConfigurationRepository.m13009b(injectorLike), DownloadLocalFileMapper.m13029b(injectorLike), IdBasedProvider.a(injectorLike, 3898), DefaultAndroidThreadUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 4868));
    }

    @Inject
    public AssetDownloadManager(AssetDownloadConfigurationRepository assetDownloadConfigurationRepository, DownloadLocalFileMapper downloadLocalFileMapper, Provider<Boolean> provider, AndroidThreadUtil androidThreadUtil, Provider<AssetDownloadConditionalWorker> provider2) {
        this.f12321a = assetDownloadConfigurationRepository;
        this.f12322b = downloadLocalFileMapper;
        this.f12323c = provider;
        this.f12324d = androidThreadUtil;
        this.f12325e = provider2;
    }

    public final boolean m13003a(AssetDownloadConfiguration assetDownloadConfiguration, boolean z) {
        if (!((Boolean) this.f12323c.get()).booleanValue() && !z) {
            return false;
        }
        this.f12324d.b();
        Preconditions.checkArgument(m13000a(assetDownloadConfiguration.mIdentifier), "The identifier of the given configuration is not valid");
        Preconditions.checkNotNull(assetDownloadConfiguration.a(), "The source of the configuration must not be null");
        return this.f12321a.m13013a(assetDownloadConfiguration, true);
    }

    private boolean m13000a(String str) {
        if (StringUtil.a(str)) {
            return false;
        }
        return m13002b().matcher(str).matches();
    }

    private synchronized Pattern m13002b() {
        if (this.f12326f == null) {
            this.f12326f = Pattern.compile("[a-zA-Z0-9_]+");
        }
        return this.f12326f;
    }
}
