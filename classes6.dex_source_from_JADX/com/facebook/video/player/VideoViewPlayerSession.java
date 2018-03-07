package com.facebook.video.player;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.video.api.playersession.VideoPlayerSessionBase;
import java.lang.ref.WeakReference;

/* compiled from: composer_friend_tag_click */
public class VideoViewPlayerSession extends VideoPlayerSessionBase {
    private static final Class<?> f19258c = VideoViewPlayerSession.class;
    private final WeakReference<VideoViewController> f19259d;

    public VideoViewPlayerSession(VideoViewController videoViewController, CallerContext callerContext) {
        super(callerContext);
        this.f19259d = new WeakReference(videoViewController);
    }

    public final int m28058a() {
        VideoViewController videoViewController = (VideoViewController) this.f19259d.get();
        if (videoViewController != null) {
            try {
                return videoViewController.getVideoViewCurrentPosition();
            } catch (IllegalStateException e) {
            }
        }
        return -1;
    }

    public final int m28059b() {
        VideoViewController videoViewController = (VideoViewController) this.f19259d.get();
        if (videoViewController != null) {
            try {
                return videoViewController.getVideoViewDurationInMillis();
            } catch (IllegalStateException e) {
            }
        }
        return -1;
    }

    public final boolean m28060c() {
        return true;
    }
}
