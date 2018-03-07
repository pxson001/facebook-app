package com.facebook.richdocument.view.widget.media;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.event.RichDocumentEvents.NativeAdsRecyclerViewFocusRequest;
import com.facebook.richdocument.event.RichDocumentEvents.NativeAdsRecyclerViewFocusRequest.RequestType;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.media.plugins.FullscreenVideoCTAPlugin;
import com.facebook.richdocument.view.widget.media.plugins.RichDocumentSoundWavePlugin;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nux_continue_tap */
public class NativeAdsMediaFrameWithPlugins extends MediaFrameWithPlugins {
    @Inject
    public HamDimensions f7605g;
    private int f7606h;
    private int f7607i;

    private static <T extends View> void m7856a(Class<T> cls, T t) {
        m7857a((Object) t, t.getContext());
    }

    private static void m7857a(Object obj, Context context) {
        ((NativeAdsMediaFrameWithPlugins) obj).f7605g = HamDimensions.m5268a(FbInjector.get(context));
    }

    public NativeAdsMediaFrameWithPlugins(Context context) {
        this(context, null);
    }

    public NativeAdsMediaFrameWithPlugins(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeAdsMediaFrameWithPlugins(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7856a(NativeAdsMediaFrameWithPlugins.class, (View) this);
        this.f7606h = this.f7605g.m5276b(2131558653);
        this.f7607i = this.f7605g.m5276b(2131558654);
    }

    public final void mo478a(MediaTransitionState mediaTransitionState) {
        if (mo481b(mediaTransitionState)) {
            ViewLayout currentLayout = getCurrentLayout();
            ViewLayout a = getTransitionStrategy().m7196a(mediaTransitionState, false);
            View view = (View) getParent();
            PresentationMode presentationMode = ((MediaTransitionState) a.mo427a()).f6981e;
            Orientation orientation = ((MediaTransitionState) a.mo427a()).f6982f;
            if (presentationMode == PresentationMode.EXPANDED) {
                m7854a(view, false);
            } else if (presentationMode == PresentationMode.COLLAPSED && (orientation == Orientation.LANDSCAPE_LEFT || orientation == Orientation.LANDSCAPE_RIGHT)) {
                m7854a(view, true);
            } else if (presentationMode == PresentationMode.COLLAPSED && orientation == Orientation.PORTRAIT) {
                m7858c(view);
            }
            if (currentLayout != null && a != null && !a.equals(currentLayout)) {
                getTransitionStrategy().m7204d(mediaTransitionState);
                if (getTransitionStrategy().mo426a(((MediaTransitionState) currentLayout.mo427a()).m7272e(), mediaTransitionState)) {
                    mo482c();
                }
                mo496c(mediaTransitionState);
            }
        }
    }

    private void m7854a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        ((MarginLayoutParams) layoutParams).setMargins(0, ((MarginLayoutParams) layoutParams).topMargin, 0, ((MarginLayoutParams) layoutParams).bottomMargin);
        if (VERSION.SDK_INT >= 17) {
            ((MarginLayoutParams) layoutParams).setMarginStart(0);
            ((MarginLayoutParams) layoutParams).setMarginEnd(0);
        }
        if (getMediaView() instanceof RichVideoPlayer) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) getMediaView();
            richVideoPlayer.a(false, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
            FullscreenVideoCTAPlugin fullscreenVideoCTAPlugin = (FullscreenVideoCTAPlugin) mo495b(FullscreenVideoCTAPlugin.class);
            if (z) {
                if (!StringUtil.a(fullscreenVideoCTAPlugin.f7630a.f7393d.getText())) {
                    fullscreenVideoCTAPlugin.f7633d = true;
                    fullscreenVideoCTAPlugin.f7630a.setVisibility(0);
                }
            } else if (!StringUtil.a(fullscreenVideoCTAPlugin.f7630a.f7393d.getText())) {
                fullscreenVideoCTAPlugin.f7633d = false;
                fullscreenVideoCTAPlugin.f7630a.setVisibility(0);
            }
            RichDocumentSoundWavePlugin richDocumentSoundWavePlugin = (RichDocumentSoundWavePlugin) richVideoPlayer.a(RichDocumentSoundWavePlugin.class);
            richDocumentSoundWavePlugin.f7696b = true;
            if (richDocumentSoundWavePlugin.a != null) {
                richDocumentSoundWavePlugin.a.setVisibility(8);
                richDocumentSoundWavePlugin.a.b();
            }
        }
    }

    private void m7858c(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        ((MarginLayoutParams) layoutParams).setMargins(this.f7606h, ((MarginLayoutParams) layoutParams).topMargin, this.f7607i, ((MarginLayoutParams) layoutParams).bottomMargin);
        if (VERSION.SDK_INT >= 17) {
            ((MarginLayoutParams) layoutParams).setMarginStart(this.f7606h);
            ((MarginLayoutParams) layoutParams).setMarginEnd(this.f7607i);
        }
        if (getMediaView() instanceof RichVideoPlayer) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) getMediaView();
            richVideoPlayer.a(true, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
            FullscreenVideoCTAPlugin fullscreenVideoCTAPlugin = (FullscreenVideoCTAPlugin) mo495b(FullscreenVideoCTAPlugin.class);
            if (fullscreenVideoCTAPlugin.f7630a != null) {
                fullscreenVideoCTAPlugin.f7633d = false;
                fullscreenVideoCTAPlugin.f7630a.setVisibility(8);
            }
            RichDocumentSoundWavePlugin richDocumentSoundWavePlugin = (RichDocumentSoundWavePlugin) richVideoPlayer.a(RichDocumentSoundWavePlugin.class);
            richDocumentSoundWavePlugin.f7696b = false;
            if (richVideoPlayer.m() && richDocumentSoundWavePlugin.a != null) {
                richDocumentSoundWavePlugin.a.a();
                richDocumentSoundWavePlugin.a.setVisibility(0);
            }
        }
    }

    public final void mo482c() {
        this.f7589d.a(new NativeAdsRecyclerViewFocusRequest(RequestType.NATIVE_ADS_VIDEO_SET_FOCUSED_VIEW, this, null));
    }

    protected final void mo501a(Rect rect) {
        if (rect != null) {
            this.f7589d.a(new NativeAdsRecyclerViewFocusRequest(RequestType.NATIVE_ADS_VIDEO_SCROLL_FOCUSED_VIEW_TO_RECT, this, rect));
        }
    }

    private void m7855a(HamDimensions hamDimensions) {
        this.f7605g = hamDimensions;
    }
}
