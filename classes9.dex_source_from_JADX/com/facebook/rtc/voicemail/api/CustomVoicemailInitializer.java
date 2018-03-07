package com.facebook.rtc.voicemail.api;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.assetdownloader.AssetDownloader;
import com.facebook.rtc.assetdownloader.DownloadListener;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.voicemail.VoicemailHandler;
import com.facebook.rtc.voicemail.api.VoicemailPromptReadMethod.Result;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: app_discovery_lite */
public class CustomVoicemailInitializer {
    public static final CallerContext f20373a = CallerContext.a(CustomVoicemailInitializer.class, "voip_voicemail_audio");
    public final VoicemailPromptReadMethod f20374b;
    public final ApiMethodRunnerImpl f20375c;
    public final AssetDownloader f20376d;
    @BackgroundExecutorService
    private final ExecutorService f20377e;
    private final QeAccessor f20378f;
    public final VoicemailHandler f20379g;

    public static CustomVoicemailInitializer m19937a(InjectorLike injectorLike) {
        return new CustomVoicemailInitializer(new VoicemailPromptReadMethod(), ApiMethodRunnerImpl.a(injectorLike), AssetDownloader.b(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), VoicemailHandler.a(injectorLike));
    }

    @Inject
    public CustomVoicemailInitializer(VoicemailPromptReadMethod voicemailPromptReadMethod, ApiMethodRunnerImpl apiMethodRunnerImpl, AssetDownloader assetDownloader, ExecutorService executorService, QeAccessor qeAccessor, VoicemailHandler voicemailHandler) {
        this.f20374b = voicemailPromptReadMethod;
        this.f20375c = apiMethodRunnerImpl;
        this.f20376d = assetDownloader;
        this.f20377e = executorService;
        this.f20378f = qeAccessor;
        this.f20379g = voicemailHandler;
    }

    public final void m19938a(final long j) {
        if (this.f20378f.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.db, false)) {
            ExecutorDetour.a(this.f20377e, new Runnable(this) {
                final /* synthetic */ CustomVoicemailInitializer f20372b;

                public void run() {
                    try {
                        Result result = (Result) this.f20372b.f20375c.a(this.f20372b.f20374b, String.valueOf(j));
                        if (result != null) {
                            final String a = result.m19945a();
                            this.f20372b.f20376d.a(a, new DownloadListener(this) {
                                final /* synthetic */ C24021 f20370b;

                                public final void m19936a(String str, File file) {
                                    String a = this.f20370b.f20372b.f20376d.d.a(AssetDownloader.b(j), null);
                                    if (!a.equals(a)) {
                                        this.f20370b.f20372b.f20376d.b(a);
                                        AssetDownloader assetDownloader = this.f20370b.f20372b.f20376d;
                                        long j = j;
                                        assetDownloader.d.edit().a(AssetDownloader.b(j), a).commit();
                                    }
                                    this.f20370b.f20372b.f20379g.q = file;
                                }

                                public final void m19935a() {
                                    this.f20370b.f20372b.f20379g.q = null;
                                }
                            }, CustomVoicemailInitializer.f20373a);
                            return;
                        }
                        this.f20372b.f20379g.a(null);
                    } catch (Exception e) {
                        this.f20372b.f20379g.a(null);
                    }
                }
            }, 962322019);
        }
    }
}
