package com.facebook.photos.upload.uploaders;

import android.os.Bundle;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.InterpretedException;
import com.facebook.photos.base.analytics.TranscodingFailedException;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.photos.upload.disk.TempFiles;
import com.facebook.photos.upload.disk.UploadTempFileManager;
import com.facebook.photos.upload.operation.TranscodeInfo;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.uploaders.VideoUploader.ResizeProgressListener;
import com.facebook.photos.upload.uploaders.VideoUploader.VideoProcessException;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.qe.schema.Locators;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.policy.DefaultVideoResizingPolicy;
import com.facebook.videocodec.policy.HighRateVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.videocodec.policy.VideoSizeEstimator;
import com.facebook.videocodec.policy.VideoSizeEstimator$Estimate;
import com.facebook.videocodec.policy.VideoTranscodeParams;
import com.facebook.videocodec.policy.VideoTranscodeProfileLevelParams;
import com.facebook.videocodec.resizer.VideoResizeResult;
import com.facebook.videocodec.resizer.VideoResizer;
import com.facebook.videocodec.resizer.VideoResizerParams;
import com.facebook.videocodec.resizer.VideoResizerParamsBuilder;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friend_suggestion_ignore */
public class VideoUploadResizeHandler {
    private static final Class<?> f14499a = VideoUploadResizeHandler.class;
    private final Clock f14500b;
    private final VideoResizer f14501c;
    private final UploadTempFileManager f14502d;
    private final DefaultVideoResizingPolicy f14503e;
    private final HighRateVideoResizingPolicy f14504f;
    private final Provider<TriState> f14505g;
    private final VideoMetadataExtractor f14506h;
    private final VideoSizeEstimator f14507i;
    private final QeAccessor f14508j;

    public static VideoUploadResizeHandler m22087a(InjectorLike injectorLike) {
        return new VideoUploadResizeHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike), VideoResizer.m8280a(injectorLike), UploadTempFileManager.m21320a(injectorLike), DefaultVideoResizingPolicy.m8245a(injectorLike), new HighRateVideoResizingPolicy(), IdBasedProvider.a(injectorLike, 735), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.b(injectorLike), UploadVideoSizeEstimator.m22077a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public VideoUploadResizeHandler(Clock clock, VideoResizer videoResizer, UploadTempFileManager uploadTempFileManager, DefaultVideoResizingPolicy defaultVideoResizingPolicy, HighRateVideoResizingPolicy highRateVideoResizingPolicy, Provider<TriState> provider, VideoMetadataExtractor videoMetadataExtractor, UploadVideoSizeEstimator uploadVideoSizeEstimator, QeAccessor qeAccessor) {
        this.f14500b = clock;
        this.f14501c = videoResizer;
        this.f14502d = uploadTempFileManager;
        this.f14503e = defaultVideoResizingPolicy;
        this.f14504f = highRateVideoResizingPolicy;
        this.f14505g = provider;
        this.f14506h = videoMetadataExtractor;
        this.f14507i = uploadVideoSizeEstimator;
        this.f14508j = qeAccessor;
    }

    public final boolean m22100a(UploadSessionContext uploadSessionContext, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadOperation uploadOperation) {
        boolean z = true;
        boolean z2 = false;
        if (uploadSessionContext.f14466T.f14439c && !uploadSessionContext.f14454H) {
            return false;
        }
        boolean z3;
        TranscodeItem a = m22084a(uploadSessionContext, defaultPhotoFlowLogger, m22090a(defaultPhotoFlowLogger.f12594j, uploadSessionContext.f14482p));
        if (a != null) {
            uploadSessionContext.f14476j = a.f14435a;
            uploadOperation.f13767P = true;
            z3 = true;
        } else {
            z3 = false;
        }
        if (uploadSessionContext.f14454H && !z3) {
            return true;
        }
        boolean z4;
        if (z3) {
            z4 = false;
        } else {
            if (uploadSessionContext.f14448B.transcodeInfo.transcodeSuccessCount > 0) {
                defaultPhotoFlowLogger.m19911b(uploadSessionContext.f14492z, uploadSessionContext.f14448B.transcodeInfo.transcodeSuccessCount);
            }
            z4 = m22094a(uploadSessionContext);
        }
        if (!(z3 || r3)) {
            z = false;
        }
        if (!z) {
            if (((TriState) this.f14505g.get()).asBoolean(false)) {
                z2 = m22093a(uploadOperation, uploadSessionContext, defaultPhotoFlowLogger);
            } else {
                defaultPhotoFlowLogger.m19862a(uploadSessionContext.f14492z, uploadSessionContext.f14479m, false);
            }
        }
        if (!z2) {
            return z2;
        }
        m22097c(uploadSessionContext);
        return z2;
    }

    public final SegmentedUploadItem m22098a(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, ResizeProgressListener resizeProgressListener, MediaUploadCancelHandler mediaUploadCancelHandler) {
        uploadOperation.m21530b(this.f14500b.a());
        SegmentedUploadItem a = SegmentedUploadItem.m22061a(uploadSessionContext.f14483q, uploadSessionContext.f14485s);
        int i = a.f14433a;
        resizeProgressListener.m22111a(uploadOperation, i);
        defaultPhotoFlowLogger.m19847a(uploadSessionContext.f14492z, a.m22066b(), uploadSessionContext.f14483q);
        long j = 0;
        int i2 = 0;
        while (i2 < a.m22066b()) {
            UploadAssetSegment a2 = a.m22064a(i2);
            if (i2 < i) {
                resizeProgressListener.m22110a(i2);
            }
            TranscodeItem a3 = m22086a(uploadSessionContext, uploadOperation, defaultPhotoFlowLogger, resizeProgressListener, mediaUploadCancelHandler, a2);
            if (a3 != null) {
                a2.m22072a(a3.f14435a, a3.f14436b, j);
                j = a2.f14445f;
                i2++;
            } else {
                resizeProgressListener.m22112b();
                defaultPhotoFlowLogger.m19848a(uploadSessionContext.f14492z, a.m22066b(), uploadSessionContext.f14483q, i2, a2.f14442c.getValue(), a2.f14446g.f5638d, a2.f14446g.f5639e);
                return null;
            }
        }
        uploadOperation.m21534c(true);
        resizeProgressListener.m22112b();
        defaultPhotoFlowLogger.m19910b(uploadSessionContext.f14492z, a.m22066b(), uploadSessionContext.f14483q);
        return a;
    }

    private TranscodeItem m22086a(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, ResizeProgressListener resizeProgressListener, MediaUploadCancelHandler mediaUploadCancelHandler, UploadAssetSegment uploadAssetSegment) {
        uploadAssetSegment.m22071a(defaultPhotoFlowLogger.m19838a());
        String a = uploadAssetSegment.m22070a();
        File a2 = m22090a(a, uploadSessionContext.f14482p);
        TranscodeItem a3 = m22084a(uploadSessionContext, defaultPhotoFlowLogger, a2);
        if (a3 != null) {
            return a3;
        }
        return m22085a(uploadSessionContext, uploadOperation, defaultPhotoFlowLogger, uploadAssetSegment, uploadSessionContext.f14482p, a, a2, resizeProgressListener, mediaUploadCancelHandler);
    }

    public final TranscodeItem m22101b(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, ResizeProgressListener resizeProgressListener, MediaUploadCancelHandler mediaUploadCancelHandler) {
        uploadOperation.m21530b(this.f14500b.a());
        String str = uploadSessionContext.f14482p;
        resizeProgressListener.m22111a(uploadOperation, 1);
        String a = defaultPhotoFlowLogger.m19838a();
        TranscodeItem a2 = m22085a(uploadSessionContext, uploadOperation, defaultPhotoFlowLogger, null, str, a, m22090a(a, uploadSessionContext.f14482p), resizeProgressListener, mediaUploadCancelHandler);
        if (a2 != null) {
            uploadOperation.f13767P = true;
        }
        return a2;
    }

    private static TranscodeItem m22084a(UploadSessionContext uploadSessionContext, DefaultPhotoFlowLogger defaultPhotoFlowLogger, File file) {
        if (file == null) {
            return null;
        }
        long length = file.length();
        if (length < 1024 || length >= uploadSessionContext.f14479m) {
            return null;
        }
        TranscodeItem transcodeItem = new TranscodeItem(file.getAbsolutePath(), length);
        defaultPhotoFlowLogger.m19851a(uploadSessionContext.f14492z, length);
        return transcodeItem;
    }

    private static boolean m22094a(UploadSessionContext uploadSessionContext) {
        TranscodeInfo transcodeInfo = uploadSessionContext.f14448B.transcodeInfo;
        if (!m22096b(uploadSessionContext)) {
            return false;
        }
        uploadSessionContext.f14490x.m19856a(uploadSessionContext.f14492z, transcodeInfo.flowStartCount, transcodeInfo.transcodeStartCount, transcodeInfo.transcodeSuccessCount, transcodeInfo.transcodeFailCount, transcodeInfo.isSegmentedTranscode);
        return true;
    }

    private static boolean m22096b(UploadSessionContext uploadSessionContext) {
        TranscodeInfo transcodeInfo = uploadSessionContext.f14448B.transcodeInfo;
        long j = transcodeInfo.transcodeFailCount;
        long j2 = transcodeInfo.transcodeStartCount - (transcodeInfo.transcodeFailCount + transcodeInfo.transcodeSuccessCount);
        if (j >= uploadSessionContext.f14462P || j2 >= uploadSessionContext.f14463Q) {
            return true;
        }
        return false;
    }

    public static boolean m22095a(boolean z, UploadSessionContext uploadSessionContext) {
        if (z || !uploadSessionContext.f14461O || m22096b(uploadSessionContext)) {
            return false;
        }
        return true;
    }

    private void m22097c(UploadSessionContext uploadSessionContext) {
        if (this.f14508j.a((short) -28510, false)) {
            uploadSessionContext.f14461O = true;
            uploadSessionContext.f14462P = this.f14508j.a(Locators.sL, 5);
            uploadSessionContext.f14463Q = this.f14508j.a(Locators.sK, 5);
        }
    }

    private TranscodeItem m22085a(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadAssetSegment uploadAssetSegment, String str, String str2, File file, ResizeProgressListener resizeProgressListener, MediaUploadCancelHandler mediaUploadCancelHandler) {
        TranscodeItem transcodeItem;
        TranscodingFailedException e;
        try {
            TempFiles a = m22083a(uploadSessionContext, str, defaultPhotoFlowLogger, uploadSessionContext.f14492z, uploadAssetSegment, str2, file, resizeProgressListener, mediaUploadCancelHandler);
            if (a != null) {
                long length = a.m21316b().length();
                if (length < uploadSessionContext.f14479m) {
                    transcodeItem = new TranscodeItem(a.m21316b().getAbsolutePath(), length);
                    uploadOperation.m21531b(true);
                    return transcodeItem;
                }
            }
            transcodeItem = null;
            try {
                uploadOperation.m21531b(true);
            } catch (TranscodingFailedException e2) {
                e = e2;
                if (mediaUploadCancelHandler.m22007e()) {
                    uploadOperation.m21531b(true);
                    return transcodeItem;
                }
                throw e;
            }
        } catch (TranscodingFailedException e3) {
            e = e3;
            transcodeItem = null;
            if (mediaUploadCancelHandler.m22007e()) {
                uploadOperation.m21531b(true);
                return transcodeItem;
            }
            throw e;
        }
        return transcodeItem;
    }

    public static VideoItem m22082a(UploadOperation uploadOperation) {
        for (MediaItem mediaItem : uploadOperation.f13778a) {
            if (mediaItem instanceof VideoItem) {
                return (VideoItem) mediaItem;
            }
        }
        throw new IllegalStateException("UploadOperation doesn't contain VideoItem");
    }

    private boolean m22093a(UploadOperation uploadOperation, UploadSessionContext uploadSessionContext, DefaultPhotoFlowLogger defaultPhotoFlowLogger) {
        if (uploadOperation.m21510O() == Type.PROFILE_VIDEO) {
            return false;
        }
        boolean z;
        try {
            defaultPhotoFlowLogger.m19881a(uploadSessionContext.f14492z, m22091a(uploadSessionContext.f14482p), uploadSessionContext.f14479m);
            uploadSessionContext.f14453G = null;
            TranscodeSettings transcodeSettings = uploadSessionContext.f14466T;
            Preconditions.checkArgument(transcodeSettings != null);
            if (!transcodeSettings.m22068b()) {
                this.f14504f.m8251a(uploadSessionContext.f14466T.f14437a, uploadSessionContext.f14466T.f14438b);
                uploadSessionContext.f14453G = this.f14504f;
            }
            VideoSizeEstimator$Estimate a = m22088a(uploadSessionContext, uploadOperation);
            int i = a.f5570c;
            z = ((float) i) / ((float) uploadSessionContext.f14479m) < 0.8f && uploadSessionContext.f14479m - ((long) i) > 10485760;
            defaultPhotoFlowLogger.m19853a(uploadSessionContext.f14492z, uploadSessionContext.f14479m, i, z, uploadSessionContext.f14452F, uploadSessionContext.f14466T.f14437a, a.f5572e, a.f5573f);
        } catch (Throwable e) {
            BLog.a(f14499a, "Could not read video metadata for original file.", e);
            defaultPhotoFlowLogger.m19863a(uploadSessionContext.f14492z, uploadSessionContext.f14479m, false, new ExceptionInterpreter(e, true));
            z = false;
        } catch (Throwable e2) {
            BLog.a(f14499a, "Error estimating transcoded file size", e2);
            defaultPhotoFlowLogger.m19863a(uploadSessionContext.f14492z, uploadSessionContext.f14479m, false, new ExceptionInterpreter(e2, true));
            z = false;
        }
        return z;
    }

    public final VideoMetadata m22099a(VideoItem videoItem) {
        Preconditions.checkNotNull(videoItem);
        return this.f14506h.a(videoItem.f());
    }

    private VideoSizeEstimator$Estimate m22088a(UploadSessionContext uploadSessionContext, UploadOperation uploadOperation) {
        VideoMetadata a = m22099a(m22082a(uploadOperation));
        if (uploadSessionContext.f14453G == null) {
            return this.f14507i.a(a, -1, -2);
        }
        int i;
        int i2;
        VideoSizeEstimator videoSizeEstimator = this.f14507i;
        HighRateVideoResizingPolicy highRateVideoResizingPolicy = uploadSessionContext.f14453G;
        VideoTranscodeParams videoTranscodeParams = null;
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(highRateVideoResizingPolicy);
        boolean booleanValue = ((Boolean) videoSizeEstimator.c.get()).booleanValue();
        if (booleanValue) {
            videoTranscodeParams = highRateVideoResizingPolicy.a(a, 0, VideoSizeEstimator.a, VideoMirroringMode.NONE, null, null);
            i = videoTranscodeParams.f5577d;
            i2 = videoTranscodeParams.f5578e;
        } else {
            i = a.f5481b;
            i2 = a.f5482c;
        }
        return VideoSizeEstimator.a(a, -1, -2, i, i2, VideoSizeEstimator.a(a, videoTranscodeParams, booleanValue));
    }

    private File m22090a(String str, String str2) {
        return this.f14502d.m21336a(str, str2, "mp4");
    }

    public static void m22092a(UploadOperation uploadOperation, UploadSessionContext uploadSessionContext) {
        boolean z;
        boolean z2 = false;
        List<MediaItem> list = uploadOperation.f13778a;
        int i = 0;
        for (MediaItem mediaItem : list) {
            if (mediaItem instanceof VideoItem) {
                z = true;
                break;
            }
            i++;
        }
        z = false;
        if (z) {
            List list2 = uploadOperation.f13779b;
            if (list2 != null) {
                if (list.size() == list2.size()) {
                    z2 = true;
                }
                Preconditions.checkState(z2, "mediaItems metadata needs to of same length as mediaItems");
                Bundle bundle = (Bundle) list2.get(i);
                bundle.setClassLoader(VideoCreativeEditingData.class.getClassLoader());
                VideoCreativeEditingData videoCreativeEditingData = (VideoCreativeEditingData) bundle.getParcelable("video_creative_editing_metadata");
                if (videoCreativeEditingData != null) {
                    VideoTrimParams a = videoCreativeEditingData.m27386a();
                    if (a != null) {
                        uploadSessionContext.f14457K = a.isTrimSpecified;
                        if (uploadSessionContext.f14457K) {
                            uploadSessionContext.f14454H = true;
                            uploadSessionContext.f14458L = a.videoTrimStartTimeMs;
                            uploadSessionContext.f14459M = a.videoTrimEndTimeMs;
                        }
                    }
                    int b = videoCreativeEditingData.m27387b();
                    boolean z3 = b == 0 || b == 90 || b == 180 || b == 270;
                    Preconditions.checkArgument(z3, "videoCreateiveEditingData.getRotationAngle() must be one of 0, 90, 180, 270");
                    if (b != 0) {
                        uploadSessionContext.f14455I = b;
                        uploadSessionContext.f14454H = true;
                    }
                    uploadSessionContext.f14456J = videoCreativeEditingData.m27388c();
                    if (uploadSessionContext.f14456J) {
                        uploadSessionContext.f14454H = true;
                    }
                    uploadSessionContext.f14460N = videoCreativeEditingData.m27390e();
                    if (uploadSessionContext.f14460N != null) {
                        uploadSessionContext.f14454H = true;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("UploadOperation doesn't contain VideoItem");
    }

    public static String m22091a(String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1).toLowerCase(Locale.ENGLISH);
    }

    private TempFiles m22083a(UploadSessionContext uploadSessionContext, String str, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, UploadAssetSegment uploadAssetSegment, String str2, File file, ResizeProgressListener resizeProgressListener, MediaUploadCancelHandler mediaUploadCancelHandler) {
        String str3;
        TempFiles a;
        TempFiles a2;
        boolean e;
        DefaultVideoResizingPolicy defaultVideoResizingPolicy;
        HighRateVideoResizingPolicy highRateVideoResizingPolicy;
        boolean z;
        VideoResizeResult videoResizeResult;
        long length;
        String str4 = "Baseline";
        if (uploadSessionContext.f14454H || !this.f14508j.a((short) -28496, false)) {
            str3 = str4;
        } else {
            str3 = this.f14508j.a('Ⴒ', "main");
        }
        TempFiles tempFiles = null;
        if (file != null) {
            try {
                if (file.exists() || file.createNewFile()) {
                    Preconditions.checkState(file.length() < 1024);
                    a = this.f14502d.m21332a(file, 10485760, "mp4");
                    if (a != null) {
                        try {
                            a2 = this.f14502d.m21334a(str2, str, 10485760, 2097152, "mp4", "mp4");
                        } catch (Exception e2) {
                            e = e2;
                            tempFiles = a;
                            e = mediaUploadCancelHandler.m22007e();
                            if (tempFiles != null) {
                                tempFiles.m21315a(false);
                                tempFiles.m21314a();
                            }
                            if (e) {
                                defaultPhotoFlowLogger.m19923c(uploadBaseParams);
                                mediaUploadCancelHandler.m22001a("processing");
                            }
                            defaultPhotoFlowLogger.m19926c(uploadBaseParams, new ExceptionInterpreter(e, true));
                            throw new TranscodingFailedException(e);
                        }
                    }
                    a2 = a;
                    mediaUploadCancelHandler.m22001a("video-processing");
                    defaultVideoResizingPolicy = this.f14503e;
                    if (uploadSessionContext.f14453G == null) {
                        highRateVideoResizingPolicy = uploadSessionContext.f14453G;
                    } else {
                        highRateVideoResizingPolicy = defaultVideoResizingPolicy;
                    }
                    UploadBaseParams uploadBaseParams2 = uploadSessionContext.f14492z;
                    if (uploadSessionContext.f14453G == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    defaultPhotoFlowLogger.m19890a(uploadBaseParams2, z, uploadSessionContext.f14466T.f14437a, str3, uploadSessionContext.f14457K, uploadSessionContext.f14458L, uploadSessionContext.f14459M, uploadSessionContext.f14456J, uploadSessionContext.f14455I, uploadSessionContext.f14460N, uploadSessionContext.f14464R);
                    ListenableFuture a3 = this.f14501c.m8282a(m22089a(uploadSessionContext, str, uploadAssetSegment, resizeProgressListener, str3, a2, highRateVideoResizingPolicy));
                    mediaUploadCancelHandler.m22000a(a3);
                    videoResizeResult = (VideoResizeResult) FutureDetour.a(a3, 687211057);
                    mediaUploadCancelHandler.m22003b();
                    length = a2.m21317c().length();
                    if (length < 1) {
                        throw new VideoProcessException("empty resized file", true);
                    } else if (!a2.m21317c().renameTo(a2.m21316b())) {
                        throw new VideoProcessException("can't rename scratch file", true);
                    } else if (a2.m21316b().length() == length) {
                        throw new VideoProcessException("move failed", true);
                    } else {
                        defaultPhotoFlowLogger.m19879a(uploadSessionContext.f14492z, "mp4", videoResizeResult.f5653d, videoResizeResult.f5654e, videoResizeResult.f5655f, videoResizeResult.f5656g, videoResizeResult.f5657h, videoResizeResult.f5658i, videoResizeResult.f5659j, videoResizeResult.f5660k, videoResizeResult.f5661l, videoResizeResult.f5651b, videoResizeResult.f5652c);
                        return a2;
                    }
                }
            } catch (Exception e3) {
                Throwable e4;
                e4 = e3;
                e = mediaUploadCancelHandler.m22007e();
                if (tempFiles != null) {
                    tempFiles.m21315a(false);
                    tempFiles.m21314a();
                }
                if (e) {
                    defaultPhotoFlowLogger.m19923c(uploadBaseParams);
                    mediaUploadCancelHandler.m22001a("processing");
                }
                defaultPhotoFlowLogger.m19926c(uploadBaseParams, new ExceptionInterpreter(e4, true));
                throw new TranscodingFailedException(e4);
            }
        }
        a = null;
        if (a != null) {
            a2 = a;
        } else {
            a2 = this.f14502d.m21334a(str2, str, 10485760, 2097152, "mp4", "mp4");
        }
        try {
            mediaUploadCancelHandler.m22001a("video-processing");
            defaultVideoResizingPolicy = this.f14503e;
            if (uploadSessionContext.f14453G == null) {
                highRateVideoResizingPolicy = defaultVideoResizingPolicy;
            } else {
                highRateVideoResizingPolicy = uploadSessionContext.f14453G;
            }
            UploadBaseParams uploadBaseParams22 = uploadSessionContext.f14492z;
            if (uploadSessionContext.f14453G == null) {
                z = false;
            } else {
                z = true;
            }
            defaultPhotoFlowLogger.m19890a(uploadBaseParams22, z, uploadSessionContext.f14466T.f14437a, str3, uploadSessionContext.f14457K, uploadSessionContext.f14458L, uploadSessionContext.f14459M, uploadSessionContext.f14456J, uploadSessionContext.f14455I, uploadSessionContext.f14460N, uploadSessionContext.f14464R);
            ListenableFuture a32 = this.f14501c.m8282a(m22089a(uploadSessionContext, str, uploadAssetSegment, resizeProgressListener, str3, a2, highRateVideoResizingPolicy));
            mediaUploadCancelHandler.m22000a(a32);
            try {
                videoResizeResult = (VideoResizeResult) FutureDetour.a(a32, 687211057);
                mediaUploadCancelHandler.m22003b();
                length = a2.m21317c().length();
                if (length < 1) {
                    throw new VideoProcessException("empty resized file", true);
                } else if (!a2.m21317c().renameTo(a2.m21316b())) {
                    throw new VideoProcessException("can't rename scratch file", true);
                } else if (a2.m21316b().length() == length) {
                    defaultPhotoFlowLogger.m19879a(uploadSessionContext.f14492z, "mp4", videoResizeResult.f5653d, videoResizeResult.f5654e, videoResizeResult.f5655f, videoResizeResult.f5656g, videoResizeResult.f5657h, videoResizeResult.f5658i, videoResizeResult.f5659j, videoResizeResult.f5660k, videoResizeResult.f5661l, videoResizeResult.f5651b, videoResizeResult.f5652c);
                    return a2;
                } else {
                    throw new VideoProcessException("move failed", true);
                }
            } catch (ExecutionException e5) {
                e4 = e5.getCause();
                throw new InterpretedException("Resizing video failed. Reason: " + e4.getMessage(), e4, true);
            } catch (Throwable th) {
                mediaUploadCancelHandler.m22003b();
            }
        } catch (Exception e6) {
            e4 = e6;
            tempFiles = a2;
            e = mediaUploadCancelHandler.m22007e();
            if (tempFiles != null) {
                tempFiles.m21315a(false);
                tempFiles.m21314a();
            }
            if (e) {
                defaultPhotoFlowLogger.m19923c(uploadBaseParams);
                mediaUploadCancelHandler.m22001a("processing");
            }
            defaultPhotoFlowLogger.m19926c(uploadBaseParams, new ExceptionInterpreter(e4, true));
            throw new TranscodingFailedException(e4);
        }
    }

    private static VideoResizerParams m22089a(UploadSessionContext uploadSessionContext, String str, UploadAssetSegment uploadAssetSegment, ResizeProgressListener resizeProgressListener, String str2, TempFiles tempFiles, AbstractVideoResizingPolicy abstractVideoResizingPolicy) {
        Object obj;
        VideoResizerParamsBuilder newBuilder = VideoResizerParams.newBuilder();
        newBuilder.f5684a = new File(str);
        newBuilder = newBuilder;
        newBuilder.f5685b = tempFiles.f13611b;
        newBuilder = newBuilder;
        newBuilder.f5686c = abstractVideoResizingPolicy;
        newBuilder = newBuilder;
        newBuilder.f5691h = resizeProgressListener;
        newBuilder = newBuilder;
        if ("Baseline".equalsIgnoreCase(str2)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            VideoTranscodeProfileLevelParams videoTranscodeProfileLevelParams;
            if ("High".equalsIgnoreCase(str2)) {
                videoTranscodeProfileLevelParams = new VideoTranscodeProfileLevelParams(8, 256);
            } else {
                videoTranscodeProfileLevelParams = new VideoTranscodeProfileLevelParams(2, 256);
            }
            newBuilder.f5695l = videoTranscodeProfileLevelParams;
        }
        if (uploadSessionContext.f14457K) {
            newBuilder.f5689f = uploadSessionContext.f14458L;
            newBuilder.f5690g = uploadSessionContext.f14459M;
        }
        if (uploadSessionContext.f14455I != 0) {
            newBuilder.m8293c(uploadSessionContext.f14455I);
        }
        if (uploadSessionContext.f14456J) {
            newBuilder.f5692i = true;
        }
        if (uploadSessionContext.f14460N != null) {
            newBuilder.f5687d = uploadSessionContext.f14460N;
        }
        if (uploadAssetSegment != null) {
            newBuilder = uploadAssetSegment.f14446g.m8265a(newBuilder);
        }
        return newBuilder.m8294o();
    }
}
