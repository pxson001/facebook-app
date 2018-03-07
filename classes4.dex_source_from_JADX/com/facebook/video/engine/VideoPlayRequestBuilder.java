package com.facebook.video.engine;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import com.facebook.androidcompat.MemoryFileUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.exoplayer.ipc.VideoPlayRequest;
import com.facebook.exoplayer.ipc.VideoPlayRequest.VideoUriSourceType;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"BadMethodUse-java.lang.String.length"})
/* compiled from: oxygen_map_static_map_image_download_error */
public class VideoPlayRequestBuilder {
    private static final String f5614a = VideoPlayRequestBuilder.class.getSimpleName();
    private static volatile VideoPlayRequestBuilder f5615g;
    private final QeAccessor f5616b;
    private VideoExoplayerConfig f5617c;
    private DeviceConditionHelper f5618d;
    private VideoDashConfig f5619e;
    private final VideoLivePlaybackConfig f5620f;

    public static com.facebook.video.engine.VideoPlayRequestBuilder m6101a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5615g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.VideoPlayRequestBuilder.class;
        monitor-enter(r1);
        r0 = f5615g;	 Catch:{ all -> 0x003a }
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
        r0 = m6102b(r0);	 Catch:{ all -> 0x0035 }
        f5615g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5615g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.VideoPlayRequestBuilder.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.VideoPlayRequestBuilder");
    }

    private static VideoPlayRequestBuilder m6102b(InjectorLike injectorLike) {
        return new VideoPlayRequestBuilder((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), VideoExoplayerConfig.b(injectorLike), DeviceConditionHelper.a(injectorLike), VideoDashConfig.a(injectorLike), VideoLivePlaybackConfig.a(injectorLike));
    }

    @Inject
    VideoPlayRequestBuilder(QeAccessor qeAccessor, VideoExoplayerConfig videoExoplayerConfig, DeviceConditionHelper deviceConditionHelper, VideoDashConfig videoDashConfig, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f5616b = qeAccessor;
        this.f5617c = videoExoplayerConfig;
        this.f5618d = deviceConditionHelper;
        this.f5619e = videoDashConfig;
        this.f5620f = videoLivePlaybackConfig;
    }

    public final boolean m6104a(String str) {
        return !StringUtil.a(str) && this.f5617c.h && this.f5619e.a(this.f5618d);
    }

    private VideoUriSourceType m6100a(Uri uri, Uri uri2) {
        if (uri == null) {
            return VideoUriSourceType.UNKNOWN;
        }
        if (uri.getScheme().matches("rtmps?")) {
            return VideoUriSourceType.RTMP_LIVE;
        }
        if (uri.toString().contains(".m3u8")) {
            if (uri2 != null && uri2.getPath().endsWith(".mpd") && this.f5620f.f) {
                return VideoUriSourceType.DASH_LIVE;
            }
            return VideoUriSourceType.HLS_LIVE;
        } else if (uri2 == null || !uri2.getPath().endsWith(".mpd")) {
            return VideoUriSourceType.PROGRESSIVE;
        } else {
            return VideoUriSourceType.DASH_VOD;
        }
    }

    public final VideoPlayRequest m6103a(String str, String str2, Uri uri, Uri uri2, String str3) {
        Throwable e;
        Uri uri3;
        VideoUriSourceType a = m6100a(uri, uri2);
        if (m6104a(str3)) {
            if (str3.length() <= this.f5617c.r) {
                return new VideoPlayRequest(uri, str, str2, uri2, str3, null, a);
            }
            MemoryFile memoryFile = null;
            try {
                MemoryFile memoryFile2 = new MemoryFile("ExoService_AbrManifest", str3.length());
                try {
                    memoryFile2.writeBytes(str3.getBytes("UTF-8"), 0, 0, str3.length());
                    return new VideoPlayRequest(uri, str, str2, uri2, null, ParcelFileDescriptor.dup(MemoryFileUtil.fdOf(memoryFile2)), a);
                } catch (IOException e2) {
                    e = e2;
                    memoryFile = memoryFile2;
                }
            } catch (IOException e3) {
                e = e3;
                BLog.b(f5614a, e, "Failed to create Dash manifest memory file", new Object[0]);
                if (memoryFile != null) {
                    memoryFile.close();
                }
                if (a != VideoUriSourceType.DASH_LIVE) {
                    uri3 = null;
                } else {
                    uri3 = uri2;
                }
                return new VideoPlayRequest(uri, str, str2, uri3, null, null, a);
            }
        }
        if (a != VideoUriSourceType.DASH_LIVE) {
            uri3 = uri2;
        } else {
            uri3 = null;
        }
        return new VideoPlayRequest(uri, str, str2, uri3, null, null, a);
    }
}
