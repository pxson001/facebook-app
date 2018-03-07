package com.facebook.timeline.header.favphotos;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: fetch_story_info_ */
public class TimelineHeaderSuggestedPhotosView extends CustomLinearLayout {
    public TimelineHeaderFeaturedPhotosMosaicView f11755a;
    private View f11756b;
    private View f11757c;
    private FrameLayout f11758d;
    private GlyphWithTextView f11759e;

    public TimelineHeaderSuggestedPhotosView(Context context) {
        super(context);
        m11840a();
    }

    public TimelineHeaderSuggestedPhotosView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11840a();
    }

    private void m11840a() {
        setContentView(2130907459);
        setOrientation(1);
        m11841b();
        this.f11756b = a(2131567944);
        this.f11757c = a(2131567946);
        this.f11758d = (FrameLayout) a(2131567942);
        this.f11759e = (GlyphWithTextView) a(2131567945);
    }

    private void m11841b() {
        this.f11755a = (TimelineHeaderFeaturedPhotosMosaicView) a(2131567943);
        this.f11755a.m11834a(0, 0, 0, 0);
    }

    public TimelineHeaderFeaturedPhotosMosaicView getSuggestedPhotosMosaicView() {
        return this.f11755a;
    }

    public void setOnEditListener(OnClickListener onClickListener) {
        this.f11756b.setOnClickListener(onClickListener);
    }

    public void setOnCloseListener(OnClickListener onClickListener) {
        this.f11757c.setOnClickListener(onClickListener);
    }

    public void setClickableColor(@ColorRes int i) {
        this.f11758d.setBackgroundResource(i);
        int b = ContextCompat.b(getContext(), i);
        this.f11759e.setGlyphColor(b);
        this.f11759e.setTextColor(b);
    }
}
