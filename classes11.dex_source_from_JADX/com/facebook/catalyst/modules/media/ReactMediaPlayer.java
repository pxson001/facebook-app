package com.facebook.catalyst.modules.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import java.io.FileDescriptor;
import java.io.IOException;

/* compiled from: market_place */
public class ReactMediaPlayer {
    public final MediaPlayer f5572a;
    public boolean f5573b;
    public boolean f5574c = false;
    public float f5575d;

    /* compiled from: market_place */
    final class C07181 implements OnPreparedListener {
        final /* synthetic */ ReactMediaPlayer f5571a;

        C07181(ReactMediaPlayer reactMediaPlayer) {
            this.f5571a = reactMediaPlayer;
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            this.f5571a.f5573b = true;
        }
    }

    private ReactMediaPlayer(MediaPlayer mediaPlayer, boolean z) {
        this.f5572a = mediaPlayer;
        this.f5573b = z;
        this.f5575d = 0.0f;
    }

    static ReactMediaPlayer m6887a(Context context, String str) {
        int identifier = context.getResources().getIdentifier(m6888a(str), "raw", context.getPackageName());
        if (identifier == 0) {
            throw new JSApplicationCausedNativeException("Could not find audio asset: " + str);
        }
        MediaPlayer create;
        if (MediaPlayerUtils.a(context, identifier) != null) {
            create = MediaPlayer.create(context, identifier);
        } else {
            FileDescriptor b = MediaPlayerUtils.b(context, identifier);
            if (b != null) {
                create = new MediaPlayer();
                try {
                    create.setDataSource(b);
                } catch (IOException e) {
                    create = null;
                }
            } else {
                create = null;
            }
        }
        if (create != null) {
            return new ReactMediaPlayer(create, true);
        }
        throw new JSApplicationCausedNativeException("Could not create audio: " + str);
    }

    static ReactMediaPlayer m6886a(Context context, Uri uri) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        try {
            mediaPlayer.setDataSource(context, uri);
            ReactMediaPlayer reactMediaPlayer = new ReactMediaPlayer(mediaPlayer, false);
            mediaPlayer.setOnPreparedListener(new C07181(reactMediaPlayer));
            mediaPlayer.prepareAsync();
            return reactMediaPlayer;
        } catch (Throwable e) {
            FLog.b("React", "ReactMediaPlayer failed to set data source", e);
            return new ReactMediaPlayer(new MediaPlayer(), false);
        }
    }

    public final void m6889a() {
        if (this.f5573b) {
            this.f5572a.start();
        }
    }

    public final void m6891b() {
        this.f5574c = true;
        if (this.f5573b && this.f5572a.isPlaying()) {
            this.f5572a.pause();
        }
    }

    public final void m6890a(float f) {
        this.f5575d = f;
        if (this.f5573b) {
            this.f5572a.setVolume(f, f);
        }
    }

    public final double m6892d() {
        if (this.f5573b) {
            return m6885a(this.f5572a.getCurrentPosition());
        }
        return 0.0d;
    }

    public static double m6885a(int i) {
        return ((double) i) / 1000.0d;
    }

    private static String m6888a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(0, lastIndexOf);
    }
}
