package com.facebook.messaging.media.upload.segmented;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Cancelable;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.MaxVideoSizeHelper;
import com.facebook.messaging.media.upload.util.MediaUploadStateHelper;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@UserScoped
/* compiled from: last_updated_email */
public class VideoSegmentTranscodeUploadHandler implements BlueServiceHandler, Cancelable {
    private static final Class<?> f12092f = VideoSegmentTranscodeUploadHandler.class;
    private static final Object f12093h = new Object();
    @Inject
    MediaResourceHelper f12094a;
    @Inject
    MediaUploadStateHelper f12095b;
    @Inject
    MaxVideoSizeHelper f12096c;
    @Inject
    VideoSegmentTranscodeUploadAnalyticsLogger f12097d;
    @Inject
    VideoSegmentTranscodeUploadOperationProvider f12098e;
    private final Cache<Uri, VideoSegmentTranscodeUploadOperation> f12099g = CacheBuilder.newBuilder().a(2, TimeUnit.DAYS).q();

    private static VideoSegmentTranscodeUploadHandler m12618b(InjectorLike injectorLike) {
        VideoSegmentTranscodeUploadHandler videoSegmentTranscodeUploadHandler = new VideoSegmentTranscodeUploadHandler();
        videoSegmentTranscodeUploadHandler.m12615a(MediaResourceHelper.a(injectorLike), MediaUploadStateHelper.m12723a(injectorLike), MaxVideoSizeHelper.m12454b(injectorLike), new VideoSegmentTranscodeUploadAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), (VideoSegmentTranscodeUploadOperationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoSegmentTranscodeUploadOperationProvider.class));
        return videoSegmentTranscodeUploadHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.segmented.VideoSegmentTranscodeUploadHandler m12613a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f12093h;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m12618b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12093h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.segmented.VideoSegmentTranscodeUploadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.segmented.VideoSegmentTranscodeUploadHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f12093h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.segmented.VideoSegmentTranscodeUploadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.segmented.VideoSegmentTranscodeUploadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.segmented.VideoSegmentTranscodeUploadHandler");
    }

    public final OperationResult m12619a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("video_segment_transcode_upload".equals(str)) {
            return m12617b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    private OperationResult m12617b(OperationParams operationParams) {
        Bundle b = operationParams.b();
        MediaResource mediaResource = (MediaResource) b.getParcelable("mediaResource");
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        synchronizedMap.put("media_source", mediaResource.e.toString());
        VideoSegmentTranscodeUploadOperation videoSegmentTranscodeUploadOperation = (VideoSegmentTranscodeUploadOperation) this.f12099g.a(mediaResource.c);
        if (videoSegmentTranscodeUploadOperation == null) {
            if (!MediaResourceHelper.a(mediaResource)) {
                mediaResource = this.f12094a.b(mediaResource);
            }
            if (mediaResource.d != Type.VIDEO) {
                return OperationResult.a(ErrorCode.OTHER, "MediaResource is not a video.");
            }
            boolean z = b.getBoolean("isOutOfSpace", false);
            boolean a = m12616a(mediaResource);
            if ((MediaResourceHelper.c(mediaResource) || a) && z) {
                return OperationResult.a(ErrorCode.OTHER, "Not enough disk space to create new trimmed video.");
            }
            videoSegmentTranscodeUploadOperation = this.f12098e.m12638a(mediaResource);
            this.f12099g.a(mediaResource.c, videoSegmentTranscodeUploadOperation);
        }
        MediaResource mediaResource2 = mediaResource;
        OperationResult a2;
        try {
            Object a3 = videoSegmentTranscodeUploadOperation.m12633a();
            if (StringUtil.a(a3)) {
                a2 = OperationResult.a(ErrorCode.OTHER, "Empty fbid returned");
                return a2;
            }
            this.f12099g.b(mediaResource2.c);
            a2 = OperationResult.a(a3);
            m12614a(videoSegmentTranscodeUploadOperation, synchronizedMap);
            return a2;
        } catch (Throwable th) {
            this.f12099g.b(mediaResource2.c);
            synchronizedMap.put("failure_exception_message", th.toString() + ", " + Log.getStackTraceString(th));
            videoSegmentTranscodeUploadOperation.m12635b();
            a2 = OperationResult.a(ErrorCode.OTHER, "Segmented transcode upload is failed.");
            return a2;
        } finally {
            m12614a(videoSegmentTranscodeUploadOperation, synchronizedMap);
        }
    }

    public final boolean m12620a(String str) {
        return this.f12095b.m12724a(str);
    }

    private boolean m12616a(MediaResource mediaResource) {
        return mediaResource.p > ((long) this.f12096c.m12455a());
    }

    private void m12614a(VideoSegmentTranscodeUploadOperation videoSegmentTranscodeUploadOperation, Map<String, String> map) {
        map.put("media_source", videoSegmentTranscodeUploadOperation.f12122k.e.toString());
        map.put("session_id", videoSegmentTranscodeUploadOperation.m12636c());
        map.put("stream _id", videoSegmentTranscodeUploadOperation.f12125n);
        if (!(videoSegmentTranscodeUploadOperation.m12637e() == null || videoSegmentTranscodeUploadOperation.m12637e().isEmpty())) {
            map.put("segment_partition_status", "1");
            map.put("segment_count", Integer.toString(videoSegmentTranscodeUploadOperation.m12637e().size()));
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int i = 0; i < videoSegmentTranscodeUploadOperation.m12637e().size(); i++) {
                if (((VideoSegmentTranscodeUploadItem) videoSegmentTranscodeUploadOperation.m12637e().get(i)).f12101b != null) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(Integer.toString(i));
                }
                if (((VideoSegmentTranscodeUploadItem) videoSegmentTranscodeUploadOperation.m12637e().get(i)).f12102c) {
                    if (stringBuilder2.length() != 0) {
                        stringBuilder2.append(", ");
                    }
                    stringBuilder2.append(Integer.toString(i));
                }
            }
            map.put("segment_transcode_status", stringBuilder.toString());
            map.put("segment_upload_status", stringBuilder2.toString());
            if (videoSegmentTranscodeUploadOperation.f12126o) {
                map.put("upload_success_ratio", "1");
            }
            if (videoSegmentTranscodeUploadOperation.f12127p) {
                map.put("upload_cancelled_ratio", "1");
            }
        }
        VideoSegmentTranscodeUploadAnalyticsLogger videoSegmentTranscodeUploadAnalyticsLogger = this.f12097d;
        if (map != null) {
            videoSegmentTranscodeUploadAnalyticsLogger.f12091a.a("messenger_segmented_transcode_upload", map);
        }
    }

    private void m12615a(MediaResourceHelper mediaResourceHelper, MediaUploadStateHelper mediaUploadStateHelper, MaxVideoSizeHelper maxVideoSizeHelper, VideoSegmentTranscodeUploadAnalyticsLogger videoSegmentTranscodeUploadAnalyticsLogger, VideoSegmentTranscodeUploadOperationProvider videoSegmentTranscodeUploadOperationProvider) {
        this.f12094a = mediaResourceHelper;
        this.f12095b = mediaUploadStateHelper;
        this.f12096c = maxVideoSizeHelper;
        this.f12097d = videoSegmentTranscodeUploadAnalyticsLogger;
        this.f12098e = videoSegmentTranscodeUploadOperationProvider;
    }
}
