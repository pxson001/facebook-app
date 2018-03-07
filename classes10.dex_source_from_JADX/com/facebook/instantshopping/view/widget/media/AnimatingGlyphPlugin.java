package com.facebook.instantshopping.view.widget.media;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import com.facebook.common.util.SizeUtil;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.BaseMediaFramePlugin;

/* compiled from: SET_IMAGE */
public class AnimatingGlyphPlugin extends BaseMediaFramePlugin<Void> {
    private final ImageView f23938a = ((ImageView) this.f23942e.b().findViewById(2131563256));
    private final Display f23939b = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
    private final Point f23940c = new Point();
    private GlyphType f23941d;
    private MediaFrame f23942e;

    /* compiled from: SET_IMAGE */
    public enum GlyphType {
        TILT_TO_PAN,
        EXPANDABLE,
        LINK,
        HIDDEN
    }

    public AnimatingGlyphPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        this.f23942e = mediaFrame;
        this.f23939b.getSize(this.f23940c);
    }

    public final void m25209a(MediaTransitionState mediaTransitionState) {
        if (this.f23938a != null && !this.f23941d.equals(GlyphType.HIDDEN)) {
            if (MediaTransitionState.a.equals(mediaTransitionState)) {
                m25208a(GlyphType.EXPANDABLE);
            } else if (MediaTransitionState.b.equals(mediaTransitionState)) {
                m25208a(GlyphType.TILT_TO_PAN);
            }
        }
    }

    public final void m25208a(GlyphType glyphType) {
        if (this.f23938a != null) {
            switch (glyphType) {
                case TILT_TO_PAN:
                    this.f23938a.setImageResource(2130840999);
                    this.f23941d = GlyphType.TILT_TO_PAN;
                    break;
                case EXPANDABLE:
                    this.f23938a.setImageResource(2130840996);
                    this.f23941d = GlyphType.EXPANDABLE;
                    break;
                case LINK:
                    this.f23938a.setImageResource(2130840998);
                    this.f23941d = GlyphType.LINK;
                    break;
                case HIDDEN:
                    m25207a();
                    this.f23941d = GlyphType.HIDDEN;
                    return;
                default:
                    m25207a();
                    return;
            }
            m25211k();
        }
    }

    public final void m25207a() {
        this.f23938a.setAlpha(1.0f);
        this.f23938a.animate().alpha(0.0f).setDuration(1000);
        this.f23938a.setVisibility(8);
    }

    public final void m25211k() {
        this.f23938a.setAlpha(0.0f);
        this.f23938a.setVisibility(0);
        this.f23938a.animate().alpha(1.0f).setDuration(1000);
    }

    public final void m25210a(ViewLayout viewLayout) {
        if (this.f23938a != null) {
            int a = SizeUtil.a(getContext(), 8.0f);
            int measuredWidth = (this.f23940c.x - this.f23938a.getMeasuredWidth()) - SizeUtil.a(getContext(), 10.0f);
            this.f23942e.a(this.f23938a, new Rect(measuredWidth, a, this.f23938a.getMeasuredWidth() + measuredWidth, this.f23938a.getMeasuredHeight() + a));
        }
    }
}
