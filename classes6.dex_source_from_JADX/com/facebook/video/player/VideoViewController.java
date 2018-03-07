package com.facebook.video.player;

import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View;
import android.widget.MediaController;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.engine.DelayedCompletionHandler.DelayedCompletionListener;
import com.facebook.video.engine.DirectPlayPreparer;

/* compiled from: nearbyAlertFilter */
public interface VideoViewController extends VideoControllable {
    void mo1431a(Uri uri, DirectPlayPreparer directPlayPreparer);

    boolean mo1425a();

    void mo1426b();

    View mo1433c();

    boolean mo1434d();

    boolean mo1435e();

    VideoMetadata getMetadata();

    int getSeekPosition();

    int getVideoViewCurrentPosition();

    int getVideoViewDurationInMillis();

    void i_(int i);

    void setDelayedCompletionListener(DelayedCompletionListener delayedCompletionListener);

    void setVideoViewClickable(boolean z);

    void setVideoViewMediaController(MediaController mediaController);

    void setVideoViewOnCompletionListener(OnCompletionListener onCompletionListener);

    void setVideoViewOnErrorListener(OnErrorListener onErrorListener);

    void setVideoViewOnPreparedListener(OnPreparedListener onPreparedListener);

    void setVideoViewPath$48ad1708(Uri uri);

    void setVideoViewRotation(float f);
}
