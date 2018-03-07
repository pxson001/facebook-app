package com.facebook.facecastdisplay;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: audio/mpeg */
public class LiveVideoStatusMessage extends BetterTextView {
    public final ObjectAnimator f18967a;

    /* compiled from: audio/mpeg */
    public enum VideoState {
        WEAK,
        PAUSED,
        PLAYBACK_STALLED,
        BROADCAST_PAUSED,
        BROADCAST_INTERRUPTED
    }

    public LiveVideoStatusMessage(Context context) {
        this(context, null, 0);
    }

    public LiveVideoStatusMessage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveVideoStatusMessage(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTextAppearance(context, 2131624713);
        this.f18967a = FacecastUiUtil.m3098a((View) this);
    }

    public ObjectAnimator getLiveAnimator() {
        return this.f18967a;
    }

    public void setLiveText(VideoState videoState) {
        switch (videoState) {
            case WEAK:
                setText(2131232698);
                return;
            case PAUSED:
                setText(2131232673);
                return;
            case PLAYBACK_STALLED:
                setText(2131232676);
                return;
            case BROADCAST_PAUSED:
                setText(2131232674);
                return;
            case BROADCAST_INTERRUPTED:
                setText(2131232675);
                return;
            default:
                return;
        }
    }

    public void setIsSmall(boolean z) {
        if (z) {
            setTextSize(0, getResources().getDimension(2131427398));
        }
    }
}
