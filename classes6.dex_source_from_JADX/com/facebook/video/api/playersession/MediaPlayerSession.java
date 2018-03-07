package com.facebook.video.api.playersession;

import android.media.MediaPlayer;
import com.facebook.common.callercontext.CallerContext;
import java.lang.ref.WeakReference;

/* compiled from: contacts_surface */
public class MediaPlayerSession extends VideoPlayerSessionBase {
    private static final Class<?> f18555c = MediaPlayerSession.class;
    private final WeakReference<MediaPlayer> f18556d;

    public MediaPlayerSession(MediaPlayer mediaPlayer, CallerContext callerContext) {
        super(callerContext);
        this.f18556d = new WeakReference(mediaPlayer);
    }

    public final int m27172a() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f18556d.get();
        if (mediaPlayer == null) {
            return -1;
        }
        try {
            int currentPosition;
            if (mediaPlayer.isPlaying()) {
                currentPosition = mediaPlayer.getCurrentPosition();
            } else {
                currentPosition = -1;
            }
            return currentPosition;
        } catch (IllegalStateException e) {
            return -1;
        }
    }

    public final synchronized int m27173b() {
        return this.b;
    }

    public final boolean m27174c() {
        return false;
    }
}
