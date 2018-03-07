package com.facebook.video.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import com.facebook.common.time.MonotonicClock;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.google.common.base.Preconditions;

/* compiled from: pages_db */
public class PreparingMediaPlayer implements OnErrorListener, OnPreparedListener, MediaPlayerWrapper {
    static final String f5383a = PreparingMediaPlayer.class.getSimpleName();
    private final MediaPlayer f5384b;
    private final long f5385c;
    private final MonotonicClock f5386d;
    private final Uri f5387e;
    private PlayerState f5388f = PlayerState.STATE_PREPARING;

    public PreparingMediaPlayer(MediaPlayer mediaPlayer, Context context, Uri uri, MonotonicClock monotonicClock) {
        this.f5384b = mediaPlayer;
        this.f5386d = monotonicClock;
        this.f5384b.setDataSource(context, uri);
        this.f5384b.setOnPreparedListener(this);
        mediaPlayer.setOnErrorListener(this);
        this.f5384b.prepareAsync();
        this.f5385c = this.f5386d.now();
        this.f5387e = uri;
    }

    public final PlayerState mo523c() {
        return this.f5388f;
    }

    public final MediaPlayer mo522b() {
        return this.f5384b;
    }

    public final void mo521a() {
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        Preconditions.checkArgument(mediaPlayer == this.f5384b);
        Long.valueOf(this.f5386d.now() - this.f5385c);
        this.f5388f = PlayerState.STATE_PREPARED;
    }

    public final long mo524d() {
        return this.f5385c;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f5388f = PlayerState.STATE_ERROR;
        Integer.valueOf(i);
        Integer.valueOf(i2);
        return true;
    }
}
