package com.facebook.video.creativeediting;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: e9d5f6a79927b9b531402a412e940f33 */
public class VideoEditGalleryPreviewLayout extends CustomLinearLayout {
    public VideoEditGalleryTrimmerFilmstripView f15446a;
    public VideoEditGalleryVideoPreviewView f15447b;

    public VideoEditGalleryPreviewLayout(Context context) {
        super(context);
        m19482a();
    }

    public VideoEditGalleryPreviewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19482a();
    }

    public VideoEditGalleryPreviewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19482a();
    }

    private void m19482a() {
        setContentView(2130907665);
        setOrientation(1);
        this.f15446a = (VideoEditGalleryTrimmerFilmstripView) findViewById(2131568311);
        this.f15447b = (VideoEditGalleryVideoPreviewView) findViewById(2131568310);
        this.f15447b.f15464g = this.f15446a;
    }

    public VideoEditGalleryTrimmerFilmstripView getFilmstrip() {
        return this.f15446a;
    }

    public VideoEditGalleryVideoPreviewView getVideoPreviewView() {
        return this.f15447b;
    }
}
