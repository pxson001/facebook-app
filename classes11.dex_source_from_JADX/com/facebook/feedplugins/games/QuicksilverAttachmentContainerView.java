package com.facebook.feedplugins.games;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.QuicksilverOverlayPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: device_code */
public class QuicksilverAttachmentContainerView extends CustomFrameLayout {
    public RichVideoPlayer f7636a = ((RichVideoPlayer) c(2131559719));
    public String f7637b = Integer.toHexString(System.identityHashCode(this.f7636a));
    public QuicksilverOverlayPlugin f7638c;

    public QuicksilverAttachmentContainerView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(2130906561, this, true);
        this.f7636a.a(new VideoPlugin(getContext()));
        this.f7638c = new QuicksilverOverlayPlugin(getContext());
        this.f7636a.a(this.f7638c);
        this.f7636a.a(new LoadingSpinnerPlugin(getContext()));
        this.f7636a.setPlayerType(PlayerType.INLINE_PLAYER);
        this.f7636a.a(true, EventTriggerType.BY_AUTOPLAY);
    }

    public final void m8853a(RichVideoPlayerParams richVideoPlayerParams) {
        setVisibility(0);
        requestLayout();
        this.f7636a.a(richVideoPlayerParams);
        QuicksilverOverlayPlugin quicksilverOverlayPlugin = this.f7638c;
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setStartOffset(1000);
        scaleAnimation.setFillAfter(true);
        quicksilverOverlayPlugin.a.startAnimation(scaleAnimation);
        scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.45f, 1, 0.45f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setStartOffset(1000);
        scaleAnimation.setFillAfter(true);
        quicksilverOverlayPlugin.b.startAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(1.0f, 0.0f);
        scaleAnimation.setStartOffset(1500);
        scaleAnimation.setDuration(50);
        scaleAnimation.setFillAfter(true);
        quicksilverOverlayPlugin.d.startAnimation(scaleAnimation);
        scaleAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 30.0f, 1, 0.0f);
        scaleAnimation.setDuration(500);
        scaleAnimation.setStartOffset(1500);
        scaleAnimation.setFillAfter(true);
        quicksilverOverlayPlugin.c.startAnimation(scaleAnimation);
        this.f7636a.a(EventTriggerType.BY_AUTOPLAY);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int paddingLeft = (int) (((double) ((size - getPaddingLeft()) - getPaddingRight())) / 1.875d);
        setMeasuredDimension(size, paddingLeft);
        measureChildren(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824));
    }
}
