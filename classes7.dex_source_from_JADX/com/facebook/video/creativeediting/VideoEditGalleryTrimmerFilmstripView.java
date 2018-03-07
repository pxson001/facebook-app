package com.facebook.video.creativeediting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.video.creativeediting.ui.fresco.ZoomableDraweeStripView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: e2ab9d66cd645c0a358c519a7fc7c434 */
public class VideoEditGalleryTrimmerFilmstripView extends CustomFrameLayout {
    public ZoomableDraweeStripView f15448a;
    public View f15449b;
    public View f15450c;
    public View f15451d;
    public View f15452e;
    public View f15453f;
    public View f15454g;

    public VideoEditGalleryTrimmerFilmstripView(Context context) {
        super(context);
        m19483a();
    }

    public VideoEditGalleryTrimmerFilmstripView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19483a();
    }

    public VideoEditGalleryTrimmerFilmstripView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19483a();
    }

    private void m19483a() {
        setContentView(2130907667);
        setLayoutParams(new LayoutParams(-2, -2));
        this.f15448a = (ZoomableDraweeStripView) c(2131568315);
        this.f15449b = c(2131568319);
        this.f15450c = c(2131568320);
        this.f15451d = c(2131568316);
        this.f15452e = c(2131568317);
        this.f15453f = c(2131568318);
        this.f15454g = c(2131568321);
    }

    public ZoomableDraweeStripView getStripView() {
        return this.f15448a;
    }

    public View getTrimmingStartHandle() {
        return this.f15449b;
    }

    public View getTrimmingEndHandle() {
        return this.f15450c;
    }

    public View getFilmstripLeftMask() {
        return this.f15451d;
    }

    public View getFilmstripRightMask() {
        return this.f15452e;
    }

    public View getFilmstripBorder() {
        return this.f15453f;
    }

    public View getFilmstripScrubber() {
        return this.f15454g;
    }
}
