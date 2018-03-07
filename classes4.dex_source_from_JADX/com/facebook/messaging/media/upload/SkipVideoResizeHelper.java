package com.facebook.messaging.media.upload;

import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager.ConfidenceLevel;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager.ConnectionQualityMeasurement;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager.QualityLevel;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource$Type;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mCoinflipSampleRate */
public class SkipVideoResizeHelper {
    private static volatile SkipVideoResizeHelper f8723d;
    private final FbNetworkManager f8724a;
    private final BackingFileResolver f8725b;
    private final MediaBandwidthManager f8726c;

    public static com.facebook.messaging.media.upload.SkipVideoResizeHelper m9019a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8723d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.SkipVideoResizeHelper.class;
        monitor-enter(r1);
        r0 = f8723d;	 Catch:{ all -> 0x003a }
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
        r0 = m9021b(r0);	 Catch:{ all -> 0x0035 }
        f8723d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8723d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.SkipVideoResizeHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.SkipVideoResizeHelper");
    }

    private static SkipVideoResizeHelper m9021b(InjectorLike injectorLike) {
        return new SkipVideoResizeHelper(FbNetworkManager.a(injectorLike), BackingFileResolver.m8895a(injectorLike), MediaBandwidthManager.m9026a(injectorLike));
    }

    @Inject
    public SkipVideoResizeHelper(FbNetworkManager fbNetworkManager, BackingFileResolver backingFileResolver, MediaBandwidthManager mediaBandwidthManager) {
        this.f8724a = fbNetworkManager;
        this.f8725b = backingFileResolver;
        this.f8726c = mediaBandwidthManager;
    }

    public final boolean m9023a(MediaResource mediaResource, int i, boolean z) {
        if (mediaResource.d != MediaResource$Type.VIDEO) {
            return false;
        }
        boolean c = MediaResourceHelper.m8959c(mediaResource);
        if (m9020a(z, c)) {
            return true;
        }
        if (c) {
            return false;
        }
        long j = mediaResource.p;
        if (j == 0) {
            return false;
        }
        if (((long) i) >= j) {
            Long.valueOf(j);
            Integer.valueOf(i);
            return true;
        } else if (j <= 1048576) {
            return true;
        } else {
            int i2;
            if (i > 0) {
                i2 = (int) (((j - ((long) i)) * 100) / j);
                Long.valueOf(j);
                Integer.valueOf(i);
                Integer.valueOf(i2);
                Integer.valueOf(10);
                if (i2 < 10) {
                    return true;
                }
            }
            ConnectionQualityMeasurement b = this.f8726c.m9033b();
            ConfidenceLevel confidenceLevel = b.b;
            QualityLevel qualityLevel = b.a;
            c = confidenceLevel.equals(ConfidenceLevel.HIGH);
            qualityLevel.name();
            confidenceLevel.name();
            Double.valueOf(((double) mediaResource.p) / 1048576.0d);
            if (c) {
                i2 = this.f8724a.h() ? 1048576 : 16777216;
                switch (1.a[qualityLevel.ordinal()]) {
                    case 1:
                    case 2:
                        if (j <= ((long) i2)) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
    }

    private static boolean m9020a(boolean z, boolean z2) {
        if (z || z2) {
            return false;
        }
        return true;
    }

    public final boolean m9022a(MediaResource mediaResource) {
        if (MediaResourceHelper.m8959c(mediaResource)) {
            return false;
        }
        long j = mediaResource.p;
        if (j == 0) {
            j = this.f8725b.m8901b(mediaResource.c);
            if (j == 0) {
                return false;
            }
        }
        if (j <= 1048576) {
            return true;
        }
        ConnectionQualityMeasurement b = this.f8726c.m9033b();
        ConfidenceLevel confidenceLevel = b.b;
        QualityLevel qualityLevel = b.a;
        boolean equals = confidenceLevel.equals(ConfidenceLevel.HIGH);
        qualityLevel.name();
        confidenceLevel.name();
        Double.valueOf(((double) mediaResource.p) / 1048576.0d);
        if (equals) {
            int i = this.f8724a.h() ? 1048576 : 26214400;
            switch (1.a[qualityLevel.ordinal()]) {
                case 1:
                case 2:
                    if (j <= ((long) i)) {
                        return true;
                    }
                    break;
            }
        }
        if (!this.f8724a.v() || j > 10485760) {
            return false;
        }
        return true;
    }

    public static int m9018a() {
        return 2;
    }
}
