package com.facebook.media.transcode.video;

import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.transcode.MediaTranscodeParameters;
import com.facebook.media.transcode.MediaTranscodeResult;
import com.facebook.photos.base.media.MediaItemFactory$VideoItemBuilder;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.resizer.VideoResizeException;
import com.facebook.videocodec.resizer.VideoResizeResult;
import com.facebook.videocodec.resizer.VideoResizer;
import com.facebook.videocodec.resizer.VideoResizerParams;
import com.facebook.videocodec.resizer.VideoResizerParamsBuilder;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* compiled from: keyword_internal_id */
public class VideoTranscodeSession {
    private final VideoMetadataExtractor f11881a;
    private final GatekeeperStoreImpl f11882b;
    private final VideoResizer f11883c;
    private final TempFileManager f11884d;
    public ListenableFuture<VideoResizeResult> f11885e = null;
    private File f11886f = null;

    public static VideoTranscodeSession m18840b(InjectorLike injectorLike) {
        return new VideoTranscodeSession(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.b(injectorLike), TempFileManager.a(injectorLike), VideoResizer.m8280a(injectorLike));
    }

    @Inject
    public VideoTranscodeSession(GatekeeperStoreImpl gatekeeperStoreImpl, VideoMetadataExtractor videoMetadataExtractor, TempFileManager tempFileManager, VideoResizer videoResizer) {
        this.f11882b = gatekeeperStoreImpl;
        this.f11881a = videoMetadataExtractor;
        this.f11883c = videoResizer;
        this.f11884d = tempFileManager;
    }

    public final boolean m18845a(VideoItem videoItem) {
        return m18842b() && m18843c(videoItem) != null;
    }

    public final MediaTranscodeResult m18844a(VideoItem videoItem, MediaTranscodeParameters mediaTranscodeParameters, MediaLogger mediaLogger) {
        Preconditions.checkArgument(mediaTranscodeParameters != null, "Media Transcode Parmeters cannot be null");
        Preconditions.checkArgument(mediaTranscodeParameters instanceof VideoTranscodeParameters, "Mediatranscode Parameters not instance of videotranscode parameters");
        VideoTranscodeParameters videoTranscodeParameters = (VideoTranscodeParameters) mediaTranscodeParameters;
        VideoTranscodeResizingPolicy a = m18835a(videoTranscodeParameters);
        boolean z = videoTranscodeParameters.f11878c != null;
        VideoMetadata c = m18843c(videoItem);
        if (m18839a(c)) {
            if (z) {
                mediaLogger.m18798a(true);
            } else if (!m18838a(m18841b(videoItem).length(), c, a, mediaLogger)) {
                return new MediaTranscodeResult(false, videoItem);
            }
            this.f11886f = this.f11884d.a("video_transcode", "mp4", Privacy.REQUIRE_PRIVATE);
            try {
                m18837a(videoItem, this.f11886f, a, videoTranscodeParameters, mediaLogger);
                return new MediaTranscodeResult(true, new MediaItemFactory$VideoItemBuilder().m20107b(this.f11886f.getPath()).m20108c("video/mp4").m20105a());
            } catch (VideoResizeException e) {
                if (!z) {
                    return new MediaTranscodeResult(false, videoItem);
                }
                throw e;
            }
        }
        mediaLogger.m18798a(false);
        if (!z) {
            return new MediaTranscodeResult(false, videoItem);
        }
        throw new VideoResizeException("Transcoding not supported for this videoItem");
    }

    private void m18837a(VideoItem videoItem, File file, VideoTranscodeResizingPolicy videoTranscodeResizingPolicy, VideoTranscodeParameters videoTranscodeParameters, MediaLogger mediaLogger) {
        File b = m18841b(videoItem);
        Preconditions.checkNotNull(file, "Transcoded File Path cannot be null");
        VideoResizerParams a = m18836a(b, file, videoTranscodeParameters, (AbstractVideoResizingPolicy) videoTranscodeResizingPolicy);
        try {
            VideoEditConfig videoEditConfig = videoTranscodeParameters.f11878c;
            if (videoEditConfig == null) {
                videoEditConfig = VideoEditConfig.m18830a();
            }
            mediaLogger.m18787a(videoTranscodeResizingPolicy.m18833a().f5565b, videoEditConfig.f11870a, videoEditConfig.f11871b, videoEditConfig.f11872c, videoEditConfig.f11874e, videoEditConfig.f11873d, videoEditConfig.f11875f);
            this.f11885e = this.f11883c.m8282a(a);
            try {
                VideoResizeResult videoResizeResult = (VideoResizeResult) FutureDetour.a(this.f11885e, -1691150859);
                if (file.length() < 1) {
                    throw new VideoResizeException("empty resized file");
                }
                mediaLogger.m18793a("mp4", videoResizeResult.f5653d, videoResizeResult.f5654e, videoResizeResult.f5655f, videoResizeResult.f5656g, videoResizeResult.f5657h, videoResizeResult.f5658i, videoResizeResult.f5659j, videoResizeResult.f5660k, videoResizeResult.f5661l, videoResizeResult.f5651b, videoResizeResult.f5652c);
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                throw new VideoResizeException("Resizing video failed. Reason: " + cause.getMessage(), cause);
            }
        } catch (InterruptedException e2) {
            mediaLogger.m18808e();
            throw e2;
        } catch (Exception e3) {
            mediaLogger.m18804c(e3);
            if (file != null) {
                file.delete();
            }
            throw e3;
        }
    }

    private static VideoTranscodeResizingPolicy m18835a(VideoTranscodeParameters videoTranscodeParameters) {
        if (!videoTranscodeParameters.f11876a) {
            return VideoTranscodeResizingPolicy.m18832b();
        }
        Preconditions.checkArgument(videoTranscodeParameters.f11877b > 0, "Specified Transcoding");
        return VideoTranscodeResizingPolicy.m18831a(videoTranscodeParameters.f11877b * 1000);
    }

    private static VideoResizerParams m18836a(File file, File file2, VideoTranscodeParameters videoTranscodeParameters, AbstractVideoResizingPolicy abstractVideoResizingPolicy) {
        VideoEditConfig videoEditConfig = videoTranscodeParameters.f11878c;
        VideoResizerParamsBuilder newBuilder = VideoResizerParams.newBuilder();
        newBuilder.f5684a = file;
        newBuilder = newBuilder;
        newBuilder.f5685b = file2;
        newBuilder = newBuilder;
        newBuilder.f5686c = abstractVideoResizingPolicy;
        newBuilder = newBuilder;
        newBuilder.f5691h = videoTranscodeParameters.f11879d;
        newBuilder = newBuilder;
        if (videoEditConfig != null) {
            if (videoEditConfig.f11870a) {
                newBuilder.f5689f = videoEditConfig.f11871b;
                newBuilder.f5690g = videoEditConfig.f11872c;
            }
            if (videoEditConfig.f11873d != 0) {
                newBuilder.m8293c(videoEditConfig.f11873d);
            }
            if (videoEditConfig.f11874e) {
                newBuilder.f5692i = true;
            }
            if (videoEditConfig.f11875f != null) {
                newBuilder.f5687d = videoEditConfig.f11875f;
            }
        }
        return newBuilder.m8294o();
    }

    private static boolean m18838a(long j, VideoMetadata videoMetadata, VideoTranscodeResizingPolicy videoTranscodeResizingPolicy, MediaLogger mediaLogger) {
        Preconditions.checkArgument(videoMetadata != null, "Video Metadata cannot be null");
        Preconditions.checkArgument(videoTranscodeResizingPolicy != null, "Resizing Policy cannot be null");
        mediaLogger.m18789a(j);
        int i = videoTranscodeResizingPolicy.m18833a().f5565b;
        long a = m18834a(videoMetadata, -1, -2, i);
        boolean z = ((float) a) / ((float) j) < 0.8f && j - a > 5242880;
        mediaLogger.m18790a(j, a, z, i, videoMetadata.f5486g);
        return z;
    }

    private boolean m18839a(VideoMetadata videoMetadata) {
        return m18842b() && videoMetadata != null;
    }

    private boolean m18842b() {
        return this.f11882b.a(492, false) && this.f11882b.a(497, false);
    }

    public static File m18841b(VideoItem videoItem) {
        String e = videoItem.e();
        Preconditions.checkNotNull(e, "Input File Path cannot be null");
        File file = new File(e);
        Preconditions.checkArgument(file.isFile(), "Input file is not a file");
        return file;
    }

    private VideoMetadata m18843c(VideoItem videoItem) {
        Preconditions.checkNotNull(videoItem);
        try {
            return this.f11881a.a(videoItem.f());
        } catch (Exception e) {
            return null;
        }
    }

    private static long m18834a(VideoMetadata videoMetadata, int i, int i2, int i3) {
        int i4 = 0;
        if (i == -1) {
            i = 0;
        }
        if (i2 == -2) {
            i2 = (int) videoMetadata.f5480a;
        }
        int i5 = i2 - i;
        if (videoMetadata.f5486g > 0) {
            i4 = videoMetadata.f5486g;
        }
        return (long) (((i4 + i3) / 8) * (i5 / 1000));
    }
}
