package com.facebook.video.chromecast.logging;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.chromecast.VideoCastParams;
import com.facebook.video.engine.VideoLoggingUtils;
import com.google.android.gms.cast.MediaStatus;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logoSizeType */
public class VideoCastLoggingUtils {
    public static final String f9698a = EventTriggerType.BY_USER.value;
    public static final String f9699d = PlayerType.CHROMECAST_PLAYER.value;
    private static final ChannelEligibility f9700e = ChannelEligibility.NO_INFO;
    private static volatile VideoCastLoggingUtils f9701f;
    public final VideoLoggingUtils f9702b;
    public final AbstractFbErrorReporter f9703c;

    public static com.facebook.video.chromecast.logging.VideoCastLoggingUtils m11428a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9701f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.chromecast.logging.VideoCastLoggingUtils.class;
        monitor-enter(r1);
        r0 = f9701f;	 Catch:{ all -> 0x003a }
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
        r0 = m11429b(r0);	 Catch:{ all -> 0x0035 }
        f9701f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9701f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.chromecast.logging.VideoCastLoggingUtils.a(com.facebook.inject.InjectorLike):com.facebook.video.chromecast.logging.VideoCastLoggingUtils");
    }

    private static VideoCastLoggingUtils m11429b(InjectorLike injectorLike) {
        return new VideoCastLoggingUtils(VideoLoggingUtils.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public VideoCastLoggingUtils(VideoLoggingUtils videoLoggingUtils, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9702b = videoLoggingUtils;
        this.f9703c = abstractFbErrorReporter;
    }

    public final void m11433a(VideoCastParams videoCastParams) {
        if (videoCastParams != null) {
            this.f9702b.a(videoCastParams.f9669e, f9699d, videoCastParams.f9665a, videoCastParams.f9674j, videoCastParams.f9670f);
        } else {
            this.f9703c.a(SoftError.a("CHROMECAST_LOGGING_ERROR", "logCastAppConnected() : VideoCastParams is null when trying to connect").g());
        }
    }

    public final void m11436a(String str, VideoCastParams videoCastParams, boolean z, int i) {
        if (videoCastParams != null) {
            if (z) {
                m11432c(videoCastParams, i);
            }
            this.f9702b.a(f9699d, str, videoCastParams.f9669e, videoCastParams.f9665a, videoCastParams.f9674j, videoCastParams.f9670f);
            return;
        }
        this.f9702b.a(PlayerType.CHROMECAST_PLAYER.value, str, null, null, null, false);
    }

    public final void m11434a(VideoCastParams videoCastParams, int i) {
        if (videoCastParams != null) {
            this.f9702b.a(videoCastParams.m11390m(), f9699d, PlayerType.INLINE_PLAYER.value, videoCastParams.m11389h(), videoCastParams.m11392o(), f9698a, i, videoCastParams.m11393p(), videoCastParams.m11391n(), videoCastParams, null, null);
            return;
        }
        this.f9703c.a(SoftError.a("CHROMECAST_LOGGING_ERROR", "logEnterChromecastMode() : VideoCastParams is null").g());
    }

    public final void m11435a(VideoCastParams videoCastParams, int i, MediaStatus mediaStatus, boolean z) {
        if (mediaStatus != null) {
            switch (mediaStatus.f10022e) {
                case 1:
                    if (mediaStatus.f10023f == 1) {
                        m11431c(videoCastParams);
                        return;
                    } else if (z) {
                        m11432c(videoCastParams, i);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    if (!z) {
                        m11430b(videoCastParams, i);
                        return;
                    }
                    return;
                case 3:
                case 4:
                    if (z) {
                        m11432c(videoCastParams, i);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void m11431c(VideoCastParams videoCastParams) {
        if (videoCastParams != null) {
            this.f9702b.a(videoCastParams.f9669e, f9699d, null, videoCastParams.m11388d(), videoCastParams.m11393p(), videoCastParams.m11389h(), videoCastParams.m11392o(), f9698a, null, videoCastParams.m11391n(), null, videoCastParams);
            return;
        }
        this.f9703c.a(SoftError.a("CHROMECAST_LOGGING_ERROR", "logVideoCompleteEvent() : VideoCastParams is null").g());
    }

    private void m11430b(VideoCastParams videoCastParams, int i) {
        if (videoCastParams != null) {
            this.f9702b.b(videoCastParams.m11390m(), f9699d, null, f9698a, i, null, videoCastParams.m11389h(), videoCastParams.m11392o(), null, f9698a, null, f9700e, videoCastParams.m11391n(), null, videoCastParams);
            return;
        }
        this.f9703c.a(SoftError.a("CHROMECAST_LOGGING_ERROR", "logVideoStartOrUnPausedEvent() : VideoCastParams is null").g());
    }

    private void m11432c(VideoCastParams videoCastParams, int i) {
        if (videoCastParams != null) {
            this.f9702b.b(videoCastParams.m11390m(), f9699d, null, f9698a, i, videoCastParams.m11393p(), videoCastParams.m11389h(), videoCastParams.m11392o(), f9698a, null, videoCastParams.m11391n(), null, videoCastParams);
            return;
        }
        this.f9703c.a(SoftError.a("CHROMECAST_LOGGING_ERROR", "logVideoPausedEvent() : VideoCastParams is null").g());
    }
}
