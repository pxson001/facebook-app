package com.facebook.video.api.playersession;

import com.facebook.common.callercontext.CallerContext;
import java.lang.ref.WeakReference;

/* compiled from: oxygen_map_empty_cluster_error */
public class VideoPlayerSession extends VideoPlayerSessionBase {
    private static final Class<?> f5636c = VideoPlayerSession.class;
    private final WeakReference<VideoPlayerBase> f5637d;

    public VideoPlayerSession(VideoPlayerBase videoPlayerBase, CallerContext callerContext) {
        super(callerContext);
        this.f5637d = new WeakReference(videoPlayerBase);
    }

    public final int mo533a() {
        VideoPlayerBase videoPlayerBase = (VideoPlayerBase) this.f5637d.get();
        if (videoPlayerBase == null) {
            return -1;
        }
        try {
            int b;
            if (videoPlayerBase.mo486a()) {
                b = videoPlayerBase.mo487b();
            } else {
                b = -1;
            }
            return b;
        } catch (IllegalStateException e) {
            return -1;
        }
    }

    public final synchronized int mo534b() {
        return this.f5639b;
    }

    public final boolean mo535c() {
        return false;
    }
}
