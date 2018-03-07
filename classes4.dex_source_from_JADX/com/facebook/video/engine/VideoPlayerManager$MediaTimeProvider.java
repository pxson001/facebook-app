package com.facebook.video.engine;

import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;

@VisibleForTesting
/* compiled from: percentile_99 */
public class VideoPlayerManager$MediaTimeProvider implements SubtitleMediaTimeProvider {
    private final WeakReference<VideoPlayerManager> f5151a;
    private WeakReference<VideoPlayerManager$VideoManagerPlayer> f5152b = new WeakReference(null);

    VideoPlayerManager$MediaTimeProvider(VideoPlayerManager videoPlayerManager) {
        this.f5151a = new WeakReference(videoPlayerManager);
    }

    public final void m5593a(VideoPlayerManager$VideoManagerPlayer videoPlayerManager$VideoManagerPlayer) {
        this.f5152b = new WeakReference(videoPlayerManager$VideoManagerPlayer);
    }

    public final int mo384a() {
        if (this.f5151a == null || this.f5151a.get() == null) {
            return 0;
        }
        return ((VideoPlayerManager) this.f5151a.get()).d((VideoPlayerManager$VideoManagerPlayer) this.f5152b.get());
    }
}
