package com.facebook.media.transcode;

import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.common.MediaLoggerProvider;
import com.facebook.media.transcode.video.SegmentedVideoTranscodeSession;
import com.facebook.media.transcode.video.VideoTranscodeParameters;
import com.facebook.photos.base.media.VideoItem;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: keyword_type */
public class SegmentedMediaTranscoder {
    private final ListeningExecutorService f11852a;
    private Provider<SegmentedVideoTranscodeSession> f11853b;
    public Map<String, SegmentedVideoTranscodeSession> f11854c = new HashMap();
    private MediaLoggerProvider f11855d;

    @Inject
    public SegmentedMediaTranscoder(ListeningExecutorService listeningExecutorService, Provider<SegmentedVideoTranscodeSession> provider, MediaLoggerProvider mediaLoggerProvider) {
        this.f11852a = listeningExecutorService;
        this.f11853b = provider;
        this.f11855d = mediaLoggerProvider;
    }

    public final List<SegmentedTranscodeItemInfo> m18821a(VideoItem videoItem) {
        if (videoItem != null) {
            return ((SegmentedVideoTranscodeSession) this.f11853b.get()).m18829a(videoItem);
        }
        throw new IllegalArgumentException("Must provide non null item to transcode");
    }

    public final ListenableFuture<SegmentedMediaTranscodeResult> m18820a(String str, VideoItem videoItem, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo, MediaTranscodeParameters mediaTranscodeParameters, String str2) {
        return m18818a(str, videoItem, segmentedTranscodeItemInfo, mediaTranscodeParameters, this.f11855d.m18809a(MediaType.VIDEO, str, str2));
    }

    private ListenableFuture<SegmentedMediaTranscodeResult> m18818a(final String str, VideoItem videoItem, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo, MediaTranscodeParameters mediaTranscodeParameters, MediaLogger mediaLogger) {
        final String str2 = str;
        final VideoItem videoItem2 = videoItem;
        final SegmentedTranscodeItemInfo segmentedTranscodeItemInfo2 = segmentedTranscodeItemInfo;
        final MediaTranscodeParameters mediaTranscodeParameters2 = mediaTranscodeParameters;
        final MediaLogger mediaLogger2 = mediaLogger;
        ListenableFuture<SegmentedMediaTranscodeResult> a = this.f11852a.a(new Callable<SegmentedMediaTranscodeResult>(this) {
            final /* synthetic */ SegmentedMediaTranscoder f11849f;

            public Object call() {
                return this.f11849f.m18819b(str2, videoItem2, segmentedTranscodeItemInfo2, mediaTranscodeParameters2, mediaLogger2);
            }
        });
        Futures.a(a, new FutureCallback<SegmentedMediaTranscodeResult>(this) {
            final /* synthetic */ SegmentedMediaTranscoder f11851b;

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                SegmentedMediaTranscoder segmentedMediaTranscoder = this.f11851b;
                String str = str;
                SegmentedVideoTranscodeSession segmentedVideoTranscodeSession = (SegmentedVideoTranscodeSession) segmentedMediaTranscoder.f11854c.get(str);
                if (segmentedVideoTranscodeSession != null) {
                    if (!(segmentedVideoTranscodeSession.f11862d == null || segmentedVideoTranscodeSession.f11862d.isDone())) {
                        segmentedVideoTranscodeSession.f11862d.cancel(true);
                    }
                    segmentedMediaTranscoder.f11854c.remove(str);
                }
            }
        }, this.f11852a);
        return a;
    }

    private SegmentedMediaTranscodeResult m18819b(String str, VideoItem videoItem, SegmentedTranscodeItemInfo segmentedTranscodeItemInfo, MediaTranscodeParameters mediaTranscodeParameters, MediaLogger mediaLogger) {
        if (videoItem == null) {
            throw new IllegalArgumentException("Must provide non null item to transcode");
        }
        SegmentedVideoTranscodeSession segmentedVideoTranscodeSession = (SegmentedVideoTranscodeSession) this.f11853b.get();
        this.f11854c.put(str, segmentedVideoTranscodeSession);
        MediaTranscodeResult a = segmentedVideoTranscodeSession.m18828a(videoItem, segmentedTranscodeItemInfo, (VideoTranscodeParameters) mediaTranscodeParameters, mediaLogger);
        this.f11854c.remove(str);
        return new SegmentedMediaTranscodeResult(a.f11828a, a.f11829b, segmentedTranscodeItemInfo);
    }
}
