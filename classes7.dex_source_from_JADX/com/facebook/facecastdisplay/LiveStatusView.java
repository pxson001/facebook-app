package com.facebook.facecastdisplay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.facecastdisplay.VideoLiveIndicator.LiveIndicatorColor;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: audio/vnd.dts.hd */
public class LiveStatusView extends CustomRelativeLayout {
    @Inject
    public NumberTruncationUtil f18925a;
    private final VideoLiveIndicator f18926b;
    private final ImageView f18927c;
    private final ImageView f18928d;
    private final FbTextView f18929e;
    private final FbTextView f18930f;
    private VideoState f18931g;
    private int f18932h;
    public int f18933i;

    /* compiled from: audio/vnd.dts.hd */
    public enum VideoState {
        INTERRUPT,
        PLAYING,
        PAUSED,
        RECONNECT,
        WEAK,
        PLAYBACK_STALLED,
        BROADCAST_PAUSED
    }

    private static <T extends View> void m22523a(Class<T> cls, T t) {
        m22524a((Object) t, t.getContext());
    }

    private static void m22524a(Object obj, Context context) {
        ((LiveStatusView) obj).f18925a = NumberTruncationUtil.a(FbInjector.get(context));
    }

    public LiveStatusView(Context context) {
        this(context, null);
    }

    public LiveStatusView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m22523a(LiveStatusView.class, (View) this);
        View inflate = LayoutInflater.from(context).inflate(2130905087, this, true);
        setClipChildren(false);
        this.f18926b = (VideoLiveIndicator) inflate.findViewById(2131563492);
        this.f18927c = (ImageView) inflate.findViewById(2131563493);
        this.f18928d = (ImageView) inflate.findViewById(2131563496);
        this.f18929e = (FbTextView) inflate.findViewById(2131563494);
        this.f18930f = (FbTextView) inflate.findViewById(2131563495);
    }

    private void m22522a(NumberTruncationUtil numberTruncationUtil) {
        this.f18925a = numberTruncationUtil;
    }

    public final void m22526a() {
        this.f18932h = 0;
        m22527a(VideoState.PLAYING);
    }

    public final void m22527a(VideoState videoState) {
        this.f18927c.clearAnimation();
        this.f18927c.setVisibility(8);
        this.f18926b.m22596b();
        this.f18926b.setVisibility(8);
        this.f18931g = videoState;
        switch (videoState) {
            case INTERRUPT:
                this.f18926b.setColor(LiveIndicatorColor.WHITE);
                this.f18926b.m22595a();
                this.f18926b.setVisibility(0);
                this.f18929e.setText(2131232673);
                return;
            case PLAYING:
                this.f18926b.setColor(LiveIndicatorColor.RED);
                this.f18926b.m22595a();
                this.f18926b.setVisibility(0);
                m22525c();
                return;
            case PAUSED:
                this.f18927c.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968660));
                this.f18927c.setVisibility(0);
                this.f18929e.setText(2131232673);
                return;
            case RECONNECT:
                this.f18926b.setColor(LiveIndicatorColor.WHITE);
                this.f18926b.m22595a();
                this.f18928d.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968659));
                this.f18926b.setVisibility(0);
                this.f18929e.setText(2131232672);
                return;
            case WEAK:
                this.f18926b.setColor(LiveIndicatorColor.RED);
                this.f18926b.m22595a();
                this.f18926b.setVisibility(0);
                this.f18929e.setText(2131232698);
                return;
            case PLAYBACK_STALLED:
                this.f18927c.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968660));
                this.f18927c.setVisibility(0);
                this.f18929e.setText(2131232676);
                return;
            case BROADCAST_PAUSED:
                this.f18927c.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968660));
                this.f18927c.setVisibility(0);
                this.f18929e.setText(2131232674);
                return;
            default:
                return;
        }
    }

    public void setViewerCount(int i) {
        this.f18932h = i;
        this.f18933i = Math.max(this.f18932h, this.f18933i);
        m22525c();
    }

    public final void m22528b() {
        this.f18930f.setVisibility(0);
        setTimeElapsed(0);
    }

    public void setTimeElapsed(long j) {
        this.f18930f.setText(FacecastUiUtil.m3100a(j));
    }

    public int getMaxViewersDisplayed() {
        return this.f18933i;
    }

    private void m22525c() {
        if (this.f18931g == VideoState.PLAYING) {
            if (this.f18932h > 0) {
                this.f18929e.setText(getResources().getQuantityString(2131689510, this.f18932h, new Object[]{this.f18925a.a(this.f18932h, 1)}));
                return;
            }
            this.f18929e.setText(2131232677);
        }
    }
}
