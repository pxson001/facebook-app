package com.facebook.facecastdisplay;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: attempt */
public class VideoLiveIndicator extends CustomFrameLayout {
    @Inject
    public GlyphColorizer f19016a;
    private final GradientDrawable f19017b;
    private final ImageView f19018c;
    private final ImageView f19019d;
    private final ImageView f19020e;
    private final ImageView f19021f;
    private final Animation f19022g;
    private final Animation f19023h;

    /* compiled from: attempt */
    public enum LiveIndicatorColor {
        RED,
        WHITE
    }

    private static <T extends View> void m22593a(Class<T> cls, T t) {
        m22594a((Object) t, t.getContext());
    }

    private static void m22594a(Object obj, Context context) {
        ((VideoLiveIndicator) obj).f19016a = GlyphColorizer.a(FbInjector.get(context));
    }

    public VideoLiveIndicator(Context context) {
        this(context, null);
    }

    public VideoLiveIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoLiveIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22593a(VideoLiveIndicator.class, (View) this);
        setContentView(2130905088);
        this.f19018c = (ImageView) c(2131563498);
        this.f19019d = (ImageView) c(2131563499);
        this.f19020e = (ImageView) c(2131563500);
        this.f19021f = (ImageView) c(2131563496);
        this.f19017b = (GradientDrawable) c(2131563497).getBackground();
        this.f19022g = AnimationUtils.loadAnimation(context, 2130968658);
        this.f19023h = AnimationUtils.loadAnimation(context, 2130968657);
    }

    public void setColor(LiveIndicatorColor liveIndicatorColor) {
        switch (liveIndicatorColor) {
            case RED:
                this.f19017b.setColor(getResources().getColor(2131362609));
                this.f19018c.setImageDrawable(getResources().getDrawable(2130837852));
                this.f19020e.setImageDrawable(getResources().getDrawable(2130837851));
                this.f19019d.setImageDrawable(getResources().getDrawable(2130837853));
                return;
            case WHITE:
                this.f19017b.setColor(getResources().getColor(2131361920));
                this.f19018c.setImageDrawable(this.f19016a.a(2130837852, getResources().getColor(2131362610)));
                this.f19020e.setImageDrawable(this.f19016a.a(2130837851, getResources().getColor(2131362610)));
                this.f19019d.setImageDrawable(this.f19016a.a(2130837853, getResources().getColor(2131362610)));
                return;
            default:
                return;
        }
    }

    private void m22592a(GlyphColorizer glyphColorizer) {
        this.f19016a = glyphColorizer;
    }

    public final void m22595a() {
        this.f19020e.startAnimation(this.f19023h);
        this.f19022g.setStartOffset(160);
        this.f19019d.startAnimation(this.f19022g);
    }

    public final void m22596b() {
        this.f19020e.clearAnimation();
        this.f19019d.clearAnimation();
        this.f19021f.clearAnimation();
    }
}
