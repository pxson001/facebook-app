package com.facebook.media.transcode;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.media.common.MediaLogger;
import com.facebook.media.common.MediaLoggerProvider;
import com.facebook.media.transcode.video.VideoTranscodeSession;
import com.facebook.photos.base.media.VideoItem;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: keywords_all_types */
public class MediaTranscoder {
    public final ListeningExecutorService f11837a;
    private Provider<VideoTranscodeSession> f11838b;
    public Map<String, VideoTranscodeSession> f11839c = new HashMap();
    private MediaLoggerProvider f11840d;

    public static MediaTranscoder m18812a(InjectorLike injectorLike) {
        return new MediaTranscoder(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 7492), (MediaLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MediaLoggerProvider.class));
    }

    @Inject
    public MediaTranscoder(ListeningExecutorService listeningExecutorService, Provider<VideoTranscodeSession> provider, MediaLoggerProvider mediaLoggerProvider) {
        this.f11837a = listeningExecutorService;
        this.f11838b = provider;
        this.f11840d = mediaLoggerProvider;
    }

    public final ListenableFuture<MediaTranscodeResult> m18814a(final String str, MediaItem mediaItem, MediaTranscodeParameters mediaTranscodeParameters, String str2) {
        final String str3 = str;
        final MediaItem mediaItem2 = mediaItem;
        final MediaTranscodeParameters mediaTranscodeParameters2 = mediaTranscodeParameters;
        final MediaLogger a = this.f11840d.m18809a(mediaItem.m(), str, str2);
        ListenableFuture<MediaTranscodeResult> a2 = this.f11837a.a(new Callable<MediaTranscodeResult>(this) {
            final /* synthetic */ MediaTranscoder f11834e;

            public Object call() {
                return MediaTranscoder.m18813b(this.f11834e, str3, mediaItem2, mediaTranscodeParameters2, a);
            }
        });
        Futures.a(a2, new FutureCallback<MediaTranscodeResult>(this) {
            final /* synthetic */ MediaTranscoder f11836b;

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                MediaTranscoder mediaTranscoder = this.f11836b;
                String str = str;
                VideoTranscodeSession videoTranscodeSession = (VideoTranscodeSession) mediaTranscoder.f11839c.get(str);
                if (videoTranscodeSession != null) {
                    if (!(videoTranscodeSession.f11885e == null || videoTranscodeSession.f11885e.isDone())) {
                        videoTranscodeSession.f11885e.cancel(true);
                    }
                    mediaTranscoder.f11839c.remove(str);
                }
            }
        }, this.f11837a);
        return a2;
    }

    public static MediaTranscodeResult m18813b(MediaTranscoder mediaTranscoder, String str, MediaItem mediaItem, MediaTranscodeParameters mediaTranscodeParameters, MediaLogger mediaLogger) {
        if (mediaItem == null) {
            throw new IllegalArgumentException("Must provide non null item to transcode");
        }
        MediaType m = mediaItem.m();
        if (m == MediaType.VIDEO) {
            VideoTranscodeSession videoTranscodeSession = (VideoTranscodeSession) mediaTranscoder.f11838b.get();
            mediaTranscoder.f11839c.put(str, videoTranscodeSession);
            MediaTranscodeResult a = videoTranscodeSession.m18844a((VideoItem) mediaItem, mediaTranscodeParameters, mediaLogger);
            mediaTranscoder.f11839c.remove(str);
            return a;
        } else if (m == MediaType.PHOTO) {
            throw new UnsupportedOperationException("Photo transcodes are currently unsupported");
        } else {
            throw new UnsupportedOperationException("Unsupported media type passed into transcoder");
        }
    }
}
