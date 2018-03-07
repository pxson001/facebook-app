package com.facebook.video.player;

import android.content.Context;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.engine.DelayedCompletionHandler;
import com.facebook.video.engine.DelayedCompletionHandler.DelayedCompletionListener;
import com.facebook.video.engine.DirectPlayPreparer;
import com.facebook.video.engine.DirectPlayPreparer.C13991;
import com.facebook.video.engine.DirectPlayPreparer.Callback;
import com.facebook.video.engine.PlayPosition;
import javax.annotation.Nullable;

/* compiled from: composer_post_success */
public class AndroidVideoViewController extends VideoView implements Callback, VideoViewController {
    private DirectPlayPreparer f18976a;
    private int f18977b;
    private int f18978c;
    private int f18979d;
    public final DelayedCompletionHandler f18980e;
    public DelayedCompletionListener f18981f;

    public AndroidVideoViewController(Context context) {
        this(context, null);
    }

    private AndroidVideoViewController(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AndroidVideoViewController(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18976a = null;
        this.f18977b = 0;
        this.f18980e = new DelayedCompletionHandler();
    }

    public void setVideoViewClickable(boolean z) {
        super.setClickable(z);
    }

    public void setVideoViewOnPreparedListener(OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
    }

    public void setVideoViewOnCompletionListener(OnCompletionListener onCompletionListener) {
        super.setOnCompletionListener(onCompletionListener);
    }

    public void setVideoViewOnErrorListener(OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
    }

    public final void i_(int i) {
        this.f18977b = i;
        if (this.f18978c > 0) {
            this.f18977b += this.f18978c;
        }
        super.seekTo(this.f18977b);
    }

    public final boolean mo1425a() {
        return super.isPlaying();
    }

    public final void setVideoViewPath$48ad1708(Uri uri) {
        this.f18977b = 0;
        if (this.f18976a != null) {
            this.f18976a.m27506b();
            this.f18976a = null;
        }
        super.setVideoURI(uri);
    }

    public final void mo1431a(Uri uri, DirectPlayPreparer directPlayPreparer) {
        this.f18977b = 0;
        if (this.f18976a != null) {
            this.f18976a.m27506b();
            this.f18976a = null;
        }
        if (directPlayPreparer == null) {
            super.setVideoURI(uri);
            return;
        }
        this.f18976a = directPlayPreparer;
        this.f18976a.f18781m = this;
        DirectPlayPreparer directPlayPreparer2 = this.f18976a;
        if (directPlayPreparer2.f18778j.compareAndSet(false, true)) {
            directPlayPreparer2.f18779k = false;
            ExecutorDetour.a(directPlayPreparer2.f18777i, new C13991(directPlayPreparer2), 182987451);
        }
    }

    public final void mo1426b() {
        super.pause();
        if (this.f18976a != null) {
            this.f18976a.m27506b();
        }
        this.f18980e.removeMessages(DelayedCompletionHandler.a);
    }

    public int getVideoViewDuration() {
        if (this.f18979d > 0) {
            return this.f18979d - this.f18978c;
        }
        return super.getDuration();
    }

    public int getVideoViewDurationInMillis() {
        if (this.f18979d > 0) {
            return this.f18979d - this.f18978c;
        }
        return super.getDuration();
    }

    public final void mo1430a(int i, int i2) {
        this.f18978c = i;
        this.f18979d = i2;
    }

    public int getTrimStartPositionMs() {
        return this.f18978c;
    }

    public int getVideoViewCurrentPosition() {
        return super.getCurrentPosition();
    }

    public final void mo1432a(PlayPosition playPosition) {
        if (playPosition.b()) {
            seekTo(playPosition.c);
        }
        start();
        if (this.f18979d > 0) {
            int currentPosition = getCurrentPosition();
            if (currentPosition == 0) {
                currentPosition = this.f18977b;
            }
            currentPosition = this.f18979d - currentPosition;
            Message obtainMessage = this.f18980e.obtainMessage(DelayedCompletionHandler.a);
            obtainMessage.obj = this.f18981f;
            this.f18980e.sendMessageDelayed(obtainMessage, currentPosition > 0 ? (long) currentPosition : 0);
        }
    }

    public void setVideoViewMediaController(MediaController mediaController) {
        super.setMediaController(mediaController);
    }

    public int getVideoViewHeight() {
        return super.getHeight();
    }

    public final View mo1433c() {
        return this;
    }

    public final boolean mo1434d() {
        return false;
    }

    public void setVideoViewRotation(float f) {
    }

    public VideoMetadata getMetadata() {
        return null;
    }

    public void setDataSource(Uri uri) {
        super.setVideoURI(uri);
    }

    public final boolean mo1435e() {
        return this.f18976a != null;
    }

    public int getSeekPosition() {
        return this.f18977b;
    }

    public void setDelayedCompletionListener(DelayedCompletionListener delayedCompletionListener) {
        this.f18981f = delayedCompletionListener;
    }
}
