package com.facebook.messaging.media.upload;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.policy.VideoSizeEstimator;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: mGlobalLock set to %d */
public class MediaResourceSizeEstimator {
    private static final Class<?> f8707a = MediaResourceSizeEstimator.class;
    public final VideoMetadataExtractor f8708b;
    private final MessagesVideoSizeEstimator f8709c;
    private final MmsVideoSizeEstimator f8710d;
    private final ListeningExecutorService f8711e;

    public static MediaResourceSizeEstimator m8988b(InjectorLike injectorLike) {
        return new MediaResourceSizeEstimator(DefaultVideoMetadataExtractor.m8969b(injectorLike), MessagesVideoSizeEstimator.m8990a(injectorLike), MmsVideoSizeEstimator.m8998a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MediaResourceSizeEstimator(VideoMetadataExtractor videoMetadataExtractor, MessagesVideoSizeEstimator messagesVideoSizeEstimator, MmsVideoSizeEstimator mmsVideoSizeEstimator, ListeningExecutorService listeningExecutorService) {
        this.f8708b = videoMetadataExtractor;
        this.f8709c = messagesVideoSizeEstimator;
        this.f8710d = mmsVideoSizeEstimator;
        this.f8711e = listeningExecutorService;
    }

    public final int m8989a(MediaResource mediaResource) {
        try {
            VideoMetadata videoMetadata = (VideoMetadata) FutureDetour.a(this.f8711e.a(new 1(this, mediaResource)), 300, TimeUnit.MILLISECONDS, -1427041124);
            if (videoMetadata == null) {
                return -1;
            }
            VideoSizeEstimator videoSizeEstimator;
            if (mediaResource.e == Source.VIDEO_MMS) {
                videoSizeEstimator = this.f8710d;
            } else {
                videoSizeEstimator = this.f8709c;
            }
            return videoSizeEstimator.m8996a(videoMetadata, mediaResource.s, mediaResource.t).c;
        } catch (Throwable e) {
            BLog.b(f8707a, "Timed out.", e);
            return -2;
        } catch (Throwable e2) {
            BLog.b(f8707a, "Cannot estimate num bytes in Media.", e2);
            return -3;
        }
    }

    public static MediaResourceSizeEstimator m8987a(InjectorLike injectorLike) {
        return m8988b(injectorLike);
    }
}
