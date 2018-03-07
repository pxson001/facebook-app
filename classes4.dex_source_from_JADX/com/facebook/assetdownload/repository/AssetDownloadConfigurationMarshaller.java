package com.facebook.assetdownload.repository;

import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbJsonUtil;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: facewebUriMap */
public class AssetDownloadConfigurationMarshaller {
    private static volatile AssetDownloadConfigurationMarshaller f12340d;
    private final JsonFactory f12341a;
    private final FbJsonUtil f12342b;
    private final AbstractFbErrorReporter f12343c;

    public static com.facebook.assetdownload.repository.AssetDownloadConfigurationMarshaller m13022a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12340d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.assetdownload.repository.AssetDownloadConfigurationMarshaller.class;
        monitor-enter(r1);
        r0 = f12340d;	 Catch:{ all -> 0x003a }
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
        r0 = m13023b(r0);	 Catch:{ all -> 0x0035 }
        f12340d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12340d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.assetdownload.repository.AssetDownloadConfigurationMarshaller.a(com.facebook.inject.InjectorLike):com.facebook.assetdownload.repository.AssetDownloadConfigurationMarshaller");
    }

    private static AssetDownloadConfigurationMarshaller m13023b(InjectorLike injectorLike) {
        return new AssetDownloadConfigurationMarshaller(JsonFactoryMethodAutoProvider.a(injectorLike), FbJsonUtil.m13027a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public AssetDownloadConfigurationMarshaller(JsonFactory jsonFactory, FbJsonUtil fbJsonUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12341a = jsonFactory;
        this.f12342b = fbJsonUtil;
        this.f12343c = abstractFbErrorReporter;
    }

    public final byte[] m13025a(AssetDownloadConfiguration assetDownloadConfiguration) {
        try {
            return FbJsonUtil.m13028a(this.f12341a, assetDownloadConfiguration);
        } catch (Throwable e) {
            this.f12343c.a("download_task_marshal_io_exception", StringFormatUtil.a("Cannot marshal %s", new Object[]{assetDownloadConfiguration}), e);
            return null;
        }
    }

    public final AssetDownloadConfiguration m13024a(byte[] bArr) {
        try {
            return (AssetDownloadConfiguration) this.f12341a.a(bArr).a(AssetDownloadConfiguration.class);
        } catch (Throwable e) {
            this.f12343c.a("download_task_unmarshal_io_exception", StringFormatUtil.a("Cannot unmarshal rawBytes[%d]", new Object[]{Integer.valueOf(bArr.length)}), e);
            return null;
        }
    }
}
