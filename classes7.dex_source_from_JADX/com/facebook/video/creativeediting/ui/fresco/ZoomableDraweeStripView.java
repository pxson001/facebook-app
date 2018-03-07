package com.facebook.video.creativeediting.ui.fresco;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.facebook.video.creativeediting.trimmer.VideoStripController.VideoStripAdapter;

/* compiled from: doodle_strokes_count */
public class ZoomableDraweeStripView extends DraweeStripView {
    private VideoStripAdapter f15641a;
    private VideoStripAdapter f15642b;
    private boolean f15643c;
    private ObjectAnimator f15644d;
    private AnimationType f15645e;
    private int f15646f;
    private int f15647g;

    /* compiled from: doodle_strokes_count */
    enum AnimationType {
        EXPAND,
        COLLAPSE
    }

    public ZoomableDraweeStripView(Context context) {
        super(context);
        m19593c();
    }

    public ZoomableDraweeStripView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19593c();
    }

    public ZoomableDraweeStripView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19593c();
    }

    private void m19593c() {
        this.f15644d = ObjectAnimator.ofInt(this, "animationProgress", new int[]{0});
    }

    public final void m19598a(VideoStripAdapter videoStripAdapter, VideoStripAdapter videoStripAdapter2) {
        this.f15641a = videoStripAdapter;
        this.f15642b = videoStripAdapter2;
        m19592a(this.f15641a, 0);
    }

    public final boolean m19599a(int i) {
        int scrollX = getScrollX();
        if (scrollX <= 0) {
            return false;
        }
        setScrollX(Math.max(0, scrollX - i));
        return true;
    }

    public final boolean m19601b(int i) {
        int scrollX = getScrollX();
        if (getWidth() + scrollX >= this.f15642b.f15605b) {
            return false;
        }
        setScrollX(Math.min(scrollX + i, this.f15642b.f15605b - getWidth()));
        return true;
    }

    public final void m19602c(int i) {
        this.f15643c = true;
        int i2 = (this.f15642b.f15606c * (i - this.f15641a.f15607d)) / this.f15641a.f15606c;
        m19592a(this.f15642b, (i2 - i) + this.f15641a.f15607d);
        m19594d(i2);
    }

    public final void m19596a(float f) {
        this.f15643c = false;
        m19592a(this.f15641a, 0);
        m19595e((int) f);
    }

    public final boolean m19600b() {
        return this.f15643c;
    }

    public int getZoomedInLeftOffset() {
        return -getScrollX();
    }

    public int getZoomedInWidth() {
        return this.f15642b.f15605b;
    }

    public int getZoomedOutWidth() {
        return getWidth();
    }

    protected final void mo1203a(Rect rect) {
        int i;
        if (this.f15645e == AnimationType.EXPAND) {
            i = (((this.f15646f - rect.left) / 2) * this.f15647g) / 100;
            rect.left += i;
            rect.right = i + rect.right;
        } else if (this.f15645e == AnimationType.COLLAPSE) {
            i = (((rect.left - this.f15646f) / 2) * this.f15647g) / 100;
            rect.left += i;
            rect.right = i + rect.right;
        }
    }

    protected final int getAnimatedAlpha$134621() {
        return ((100 - this.f15647g) * 255) / 100;
    }

    private void m19594d(int i) {
        this.f15645e = AnimationType.EXPAND;
        this.f15646f = i;
        this.f15644d.setIntValues(new int[]{100, 0});
        this.f15644d.start();
    }

    private void m19595e(int i) {
        this.f15645e = AnimationType.COLLAPSE;
        this.f15646f = i;
        this.f15644d.setIntValues(new int[]{100, 0});
        this.f15644d.start();
    }

    public int getAnimationProgress() {
        return this.f15647g;
    }

    public void setAnimationProgress(int i) {
        this.f15647g = i;
        invalidate();
    }

    public int getZoomedOutStripContentWidth() {
        return this.f15641a.f15606c;
    }

    public int getZoomedInStripContentWidth() {
        return this.f15642b.f15606c;
    }
}
