package com.facebook.media.transcode.video;

import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.transcode.MediaTranscodeResult;
import com.facebook.media.transcode.SegmentedTranscodeItemInfo;
import com.facebook.media.transcode.SegmentedTranscodeItemInfo.SegmentType;
import com.facebook.photos.base.media.MediaItemFactory$VideoItemBuilder;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.policy.AbstractVideoResizingPolicy;
import com.facebook.videocodec.resizer.SegmentTranscodeSettings;
import com.facebook.videocodec.resizer.VideoResizeException;
import com.facebook.videocodec.resizer.VideoResizeResult;
import com.facebook.videocodec.resizer.VideoResizer;
import com.facebook.videocodec.resizer.VideoResizerParams;
import com.facebook.videocodec.resizer.VideoResizerParamsBuilder;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* compiled from: keyword_source */
public class SegmentedVideoTranscodeSession {
    private final VideoMetadataExtractor f11859a;
    private final VideoResizer f11860b;
    private final TempFileManager f11861c;
    public ListenableFuture<VideoResizeResult> f11862d = null;
    private File f11863e = null;

    @Inject
    public SegmentedVideoTranscodeSession(VideoResizer videoResizer, TempFileManager tempFileManager, VideoMetadataExtractor videoMetadataExtractor) {
        this.f11861c = tempFileManager;
        this.f11859a = videoMetadataExtractor;
        this.f11860b = videoResizer;
    }

    public final List<SegmentedTranscodeItemInfo> m18829a(VideoItem videoItem) {
        VideoMetadata a;
        try {
            a = this.f11859a.a(videoItem.f());
        } catch (Exception e) {
            a = null;
        }
        if (a == null) {
            return null;
        }
        return m18825a(a.f5480a, a.f5486g);
    }

    public final MediaTranscodeResult m18828a(VideoItem videoItem, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo, VideoTranscodeParameters videoTranscodeParameters, MediaLogger mediaLogger) {
        this.f11863e = this.f11861c.a("video_transcode", "mp4", Privacy.REQUIRE_PRIVATE);
        try {
            m18826a(videoItem, this.f11863e, segmentedTranscodeItemInfo, videoTranscodeParameters, mediaLogger);
            return new MediaTranscodeResult(true, new MediaItemFactory$VideoItemBuilder().m20107b(this.f11863e.getPath()).m20108c("video/mp4").m20105a());
        } catch (VideoResizeException e) {
            throw e;
        }
    }

    public static boolean m18827a(long j) {
        return j >= 5000;
    }

    private static List<SegmentedTranscodeItemInfo> m18825a(long j, int i) {
        if (j < 5000) {
            return null;
        }
        int i2;
        int i3 = 2;
        if (j >= 10000) {
            i3 = 4;
        }
        int i4 = (int) (j / ((long) i3));
        List<SegmentedTranscodeItemInfo> arrayList = new ArrayList();
        if (i > 0) {
            i2 = i3 + 1;
        } else {
            i2 = i3;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            SegmentType segmentType;
            if (i5 < i3) {
                segmentType = SegmentType.Video;
            } else {
                segmentType = SegmentType.Audio;
            }
            SegmentedTranscodeItemInfo segmentedTranscodeItemInfo = new SegmentedTranscodeItemInfo(segmentType, i5);
            segmentedTranscodeItemInfo.f11858c = m18823a(segmentedTranscodeItemInfo.f11856a, i3, i5, i4);
            arrayList.add(segmentedTranscodeItemInfo);
        }
        return arrayList;
    }

    private void m18826a(VideoItem videoItem, File file, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo, VideoTranscodeParameters videoTranscodeParameters, MediaLogger mediaLogger) {
        File b = VideoTranscodeSession.m18841b(videoItem);
        Preconditions.checkNotNull(file, "Transcoded File Path cannot be null");
        VideoResizerParams a = m18824a(b, file, segmentedTranscodeItemInfo, videoTranscodeParameters, m18822a(videoTranscodeParameters));
        try {
            mediaLogger.m18788a(-1, false, -1, -2, false, 0, null, segmentedTranscodeItemInfo.f11857b, segmentedTranscodeItemInfo.f11856a.getValue(), segmentedTranscodeItemInfo.f11858c.f5638d, segmentedTranscodeItemInfo.f11858c.f5639e);
            this.f11862d = this.f11860b.m8282a(a);
            try {
                VideoResizeResult videoResizeResult = (VideoResizeResult) FutureDetour.a(this.f11862d, 1450232984);
                if (file.length() < 1) {
                    throw new VideoResizeException("empty resized file");
                }
                mediaLogger.m18785a(videoResizeResult.f5653d, videoResizeResult.f5654e, videoResizeResult.f5655f, videoResizeResult.f5656g, videoResizeResult.f5657h, videoResizeResult.f5658i, videoResizeResult.f5659j, videoResizeResult.f5660k, videoResizeResult.f5651b, videoResizeResult.f5652c, segmentedTranscodeItemInfo.f11857b, segmentedTranscodeItemInfo.f11856a.getValue(), segmentedTranscodeItemInfo.f11858c.f5638d, segmentedTranscodeItemInfo.f11858c.f5639e);
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                throw new VideoResizeException("Resizing video failed. Reason: " + cause.getMessage(), cause);
            }
        } catch (InterruptedException e2) {
            mediaLogger.m18784a(segmentedTranscodeItemInfo.f11857b, segmentedTranscodeItemInfo.f11856a.getValue(), segmentedTranscodeItemInfo.f11858c.f5638d, segmentedTranscodeItemInfo.f11858c.f5639e);
            throw e2;
        } catch (Exception e3) {
            mediaLogger.m18786a(segmentedTranscodeItemInfo.f11857b, segmentedTranscodeItemInfo.f11856a.getValue(), segmentedTranscodeItemInfo.f11858c.f5638d, segmentedTranscodeItemInfo.f11858c.f5639e, e3);
            if (file != null) {
                file.delete();
            }
            throw e3;
        }
    }

    private static VideoResizerParams m18824a(File file, File file2, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo, VideoTranscodeParameters videoTranscodeParameters, AbstractVideoResizingPolicy abstractVideoResizingPolicy) {
        VideoResizerParamsBuilder newBuilder = VideoResizerParams.newBuilder();
        newBuilder.f5684a = file;
        newBuilder = newBuilder;
        newBuilder.f5685b = file2;
        newBuilder = newBuilder;
        newBuilder.f5686c = abstractVideoResizingPolicy;
        newBuilder = newBuilder;
        newBuilder.f5691h = videoTranscodeParameters.f11879d;
        newBuilder = newBuilder;
        segmentedTranscodeItemInfo.f11858c.m8265a(newBuilder);
        return newBuilder.m8294o();
    }

    private static SegmentTranscodeSettings m18823a(SegmentType segmentType, int i, int i2, int i3) {
        boolean z;
        int i4;
        boolean z2 = true;
        boolean z3 = false;
        int i5 = -1;
        int i6 = -2;
        if (segmentType == SegmentType.Video) {
            boolean z4;
            z = i2 == i + -1;
            if (i2 == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z) {
                z = false;
            } else {
                i6 = (i2 + 1) * i3;
                z = true;
            }
            if (!z4) {
                i5 = i2 * i3;
            }
            i4 = i5;
            z3 = true;
            z2 = false;
        } else {
            i4 = -1;
            z = false;
        }
        return new SegmentTranscodeSettings(z3, z2, z, i4, i6);
    }

    private static VideoTranscodeResizingPolicy m18822a(VideoTranscodeParameters videoTranscodeParameters) {
        if (!videoTranscodeParameters.f11876a) {
            return VideoTranscodeResizingPolicy.m18832b();
        }
        Preconditions.checkArgument(videoTranscodeParameters.f11877b > 0, "Specified Transcoding");
        return VideoTranscodeResizingPolicy.m18831a(videoTranscodeParameters.f11877b * 1000);
    }
}
