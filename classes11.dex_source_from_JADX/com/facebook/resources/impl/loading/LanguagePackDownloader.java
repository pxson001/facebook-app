package com.facebook.resources.impl.loading;

import android.content.Context;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.ConnectionStatusLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.cdn.handler.CdnHttpRequestHandler;
import com.facebook.cdn.handlerimpl.CdnHttpRequestHandlerImpl;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.impl.FbResourcesImplModule;
import com.facebook.resources.impl.FbResourcesLogger;
import com.facebook.resources.impl.loading.GetLanguagePackInfoMethod.Params;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.facebook.ui.media.fetch.MediaDownloader;
import java.io.File;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_APP_ONLY */
public class LanguagePackDownloader {
    private static volatile LanguagePackDownloader f12519g;
    private final MediaDownloader f12520a;
    private final GetLanguagePackInfoMethod f12521b;
    private final AbstractSingleMethodRunner f12522c;
    private final DefaultAndroidThreadUtil f12523d;
    public final DownloadedLanguagePackProcessor f12524e;
    private final FbResourcesLogger f12525f;

    /* compiled from: PRIVACY_CHECKUP_APP_STEP_DELETE_DIALOG_DELETE_APP_ONLY */
    class LanguagePackDownloadResultHandler implements DownloadResultResponseHandler<Void> {
        final /* synthetic */ LanguagePackDownloader f12516a;
        private final LanguagePackInfo f12517b;
        private final File f12518c;

        public LanguagePackDownloadResultHandler(LanguagePackDownloader languagePackDownloader, LanguagePackInfo languagePackInfo, File file) {
            this.f12516a = languagePackDownloader;
            this.f12517b = languagePackInfo;
            this.f12518c = file;
        }

        public final Object m12923a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
            this.f12516a.f12524e.m12915a(inputStream, this.f12517b.checksum, this.f12518c);
            return null;
        }
    }

    public static com.facebook.resources.impl.loading.LanguagePackDownloader m12924a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12519g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.loading.LanguagePackDownloader.class;
        monitor-enter(r1);
        r0 = f12519g;	 Catch:{ all -> 0x003a }
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
        r0 = m12925b(r0);	 Catch:{ all -> 0x0035 }
        f12519g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12519g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.loading.LanguagePackDownloader.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.loading.LanguagePackDownloader");
    }

    private static LanguagePackDownloader m12925b(InjectorLike injectorLike) {
        return new LanguagePackDownloader(FbResourcesImplModule.m12912a((Context) injectorLike.getInstance(Context.class, ForAppContext.class), FbHttpRequestProcessor.a(injectorLike), WebRequestCounters.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), TimeWindowThrottlingPolicy.a(injectorLike), NetworkDataLogUtils.a(injectorLike), (CdnHttpRequestHandler) CdnHttpRequestHandlerImpl.a(injectorLike), ConnectionStatusLogger.a(injectorLike)), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), GetLanguagePackInfoMethod.m12920b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), DownloadedLanguagePackProcessor.m12913a(injectorLike), FbResourcesLogger.a(injectorLike));
    }

    @Inject
    public LanguagePackDownloader(MediaDownloader mediaDownloader, AbstractSingleMethodRunner abstractSingleMethodRunner, GetLanguagePackInfoMethod getLanguagePackInfoMethod, DefaultAndroidThreadUtil defaultAndroidThreadUtil, DownloadedLanguagePackProcessor downloadedLanguagePackProcessor, FbResourcesLogger fbResourcesLogger) {
        this.f12520a = mediaDownloader;
        this.f12522c = abstractSingleMethodRunner;
        this.f12521b = getLanguagePackInfoMethod;
        this.f12523d = defaultAndroidThreadUtil;
        this.f12524e = downloadedLanguagePackProcessor;
        this.f12525f = fbResourcesLogger;
    }

    public final void m12926a(LanguageRequest languageRequest, File file) {
        this.f12523d.b();
        try {
            this.f12525f.j();
            LanguagePackInfo languagePackInfo = (LanguagePackInfo) this.f12522c.a(this.f12521b, new Params(languageRequest), CallerContext.a(getClass()));
            this.f12520a.a(new MediaDownloadRequest(Uri.parse(languagePackInfo.downloadUrl), new LanguagePackDownloadResultHandler(this, languagePackInfo, file), CallerContext.a(getClass()), languageRequest.g()));
            this.f12525f.k();
        } catch (Exception e) {
            this.f12525f.l();
            throw e;
        }
    }
}
