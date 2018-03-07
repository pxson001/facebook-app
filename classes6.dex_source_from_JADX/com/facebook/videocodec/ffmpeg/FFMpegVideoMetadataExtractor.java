package com.facebook.videocodec.ffmpeg;

import android.annotation.TargetApi;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.ffmpeg.FFMpegLibMethodAutoProvider;
import com.facebook.ffmpeg.FFMpegMediaMetadataRetrieverProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.base.SphericalMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(16)
/* compiled from: retail_receipt */
public class FFMpegVideoMetadataExtractor implements VideoMetadataExtractor {
    private static volatile FFMpegVideoMetadataExtractor f5554d;
    private final BackingFileResolver f5555a;
    private final FFMpegMediaMetadataRetrieverProvider f5556b;
    private final AnalyticsLogger f5557c;

    public static com.facebook.videocodec.ffmpeg.FFMpegVideoMetadataExtractor m8231a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5554d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.videocodec.ffmpeg.FFMpegVideoMetadataExtractor.class;
        monitor-enter(r1);
        r0 = f5554d;	 Catch:{ all -> 0x003a }
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
        r0 = m8234b(r0);	 Catch:{ all -> 0x0035 }
        f5554d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5554d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.ffmpeg.FFMpegVideoMetadataExtractor.a(com.facebook.inject.InjectorLike):com.facebook.videocodec.ffmpeg.FFMpegVideoMetadataExtractor");
    }

    public final com.facebook.videocodec.base.VideoMetadata m8235a(android.net.Uri r19) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:29:0x0071 in {12, 14, 15, 20, 24, 26, 28, 31, 34, 36} preds:[]
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
        r18 = this;
        r0 = r18;	 Catch:{ FFMpegBadDataException -> 0x0075 }
        r2 = r0.f5555a;	 Catch:{ FFMpegBadDataException -> 0x0075 }
        r3 = com.facebook.common.tempfile.TempFileManager.Privacy.PREFER_SDCARD;	 Catch:{ FFMpegBadDataException -> 0x0075 }
        r0 = r19;	 Catch:{ FFMpegBadDataException -> 0x0075 }
        r16 = r2.a(r0, r3);	 Catch:{ FFMpegBadDataException -> 0x0075 }
        r0 = r18;	 Catch:{ all -> 0x0070 }
        r2 = r0.f5556b;	 Catch:{ all -> 0x0070 }
        r0 = r16;	 Catch:{ all -> 0x0070 }
        r3 = r0.a;	 Catch:{ all -> 0x0070 }
        r3 = r3.getPath();	 Catch:{ all -> 0x0070 }
        r2 = r2.a(r3);	 Catch:{ all -> 0x0070 }
        r17 = r2.a();	 Catch:{ all -> 0x0070 }
        r4 = r17.d();	 Catch:{ all -> 0x006b }
        r6 = r17.e();	 Catch:{ all -> 0x006b }
        r7 = r17.f();	 Catch:{ all -> 0x006b }
        r8 = r17.c();	 Catch:{ all -> 0x006b }
        r9 = r17.g();	 Catch:{ all -> 0x006b }
        r0 = r16;	 Catch:{ all -> 0x006b }
        r2 = r0.a;	 Catch:{ all -> 0x006b }
        r10 = r2.length();	 Catch:{ all -> 0x006b }
        r12 = r17.h();	 Catch:{ all -> 0x006b }
        r3 = 0;
        r13 = r17.i();	 Catch:{ Exception -> 0x0063 }
        if (r13 == 0) goto L_0x004d;	 Catch:{ Exception -> 0x0063 }
    L_0x0047:
        r2 = new com.facebook.videocodec.base.SphericalMetadata;	 Catch:{ Exception -> 0x0063 }
        r2.<init>(r13);	 Catch:{ Exception -> 0x0063 }
        r3 = r2;	 Catch:{ Exception -> 0x0063 }
    L_0x004d:
        if (r3 == 0) goto L_0x0054;	 Catch:{ Exception -> 0x0063 }
    L_0x004f:
        r0 = r18;	 Catch:{ Exception -> 0x0063 }
        r0.m8232a(r3);	 Catch:{ Exception -> 0x0063 }
    L_0x0054:
        r13 = r3;
    L_0x0055:
        r3 = new com.facebook.videocodec.base.VideoMetadata;	 Catch:{  }
        r14 = 0;	 Catch:{  }
        r15 = 0;	 Catch:{  }
        r3.<init>(r4, r6, r7, r8, r9, r10, r12, r13, r14, r15);	 Catch:{  }
        r17.b();
        r16.a();
        return r3;
    L_0x0063:
        r2 = move-exception;
        r0 = r18;	 Catch:{  }
        r0.m8233a(r2);	 Catch:{  }
        r13 = r3;
        goto L_0x0055;
    L_0x006b:
        r2 = move-exception;
        r17.b();	 Catch:{ all -> 0x006b }
        throw r2;	 Catch:{ all -> 0x006b }
    L_0x0070:
        r2 = move-exception;
        r16.a();	 Catch:{ all -> 0x0070 }
        throw r2;	 Catch:{ all -> 0x0070 }
    L_0x0075:
        r2 = move-exception;
        r3 = new java.io.IOException;
        r3.<init>(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.ffmpeg.FFMpegVideoMetadataExtractor.a(android.net.Uri):com.facebook.videocodec.base.VideoMetadata");
    }

    private static FFMpegVideoMetadataExtractor m8234b(InjectorLike injectorLike) {
        return new FFMpegVideoMetadataExtractor(new FFMpegMediaMetadataRetrieverProvider(FFMpegLibMethodAutoProvider.a(injectorLike)), BackingFileResolver.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FFMpegVideoMetadataExtractor(FFMpegMediaMetadataRetrieverProvider fFMpegMediaMetadataRetrieverProvider, BackingFileResolver backingFileResolver, AnalyticsLogger analyticsLogger) {
        this.f5555a = backingFileResolver;
        this.f5556b = fFMpegMediaMetadataRetrieverProvider;
        this.f5557c = analyticsLogger;
    }

    private void m8232a(SphericalMetadata sphericalMetadata) {
        HoneyClientEventFast a = this.f5557c.a("video_upload_spherical_metadata_found", true);
        if (a.a()) {
            a.a("isSpherical", sphericalMetadata.f5477a ? "true" : "false");
            a.a("projectionType", sphericalMetadata.f5478b);
            a.a("stereoMode", sphericalMetadata.f5479c);
            a.b();
        }
    }

    private void m8233a(Exception exception) {
        HoneyClientEventFast a = this.f5557c.a("video_upload_spherical_metadata_exception", true);
        if (a.a()) {
            a.a("exception", exception.toString());
            a.b();
        }
    }
}
