package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: simplepicker_media_store_size */
public class MediaGallerySuggestedLocationView extends CustomLinearLayout {
    public static final CallerContext f2823a = CallerContext.a(MediaGallerySuggestedLocationView.class);
    public FbDraweeView f2824b;
    public BetterTextView f2825c;
    private View f2826d;
    private View f2827e;
    private ImageView f2828f;
    private View f2829g;
    private int f2830h;

    public MediaGallerySuggestedLocationView(Context context) {
        super(context);
        m2872a();
    }

    public MediaGallerySuggestedLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2872a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2829g != null) {
            int[] iArr = new int[2];
            this.f2829g.getLocationOnScreen(iArr);
            int width = iArr[0] + (this.f2829g.getWidth() / 2);
            this.f2828f.layout((width - (this.f2828f.getWidth() / 2)) - this.f2830h, 0, (width + (this.f2828f.getWidth() / 2)) - this.f2830h, this.f2828f.getHeight());
        }
    }

    public void setAnchor(View view) {
        this.f2829g = view;
        requestLayout();
    }

    public void setAcceptSuggestedLocationListener(OnClickListener onClickListener) {
        this.f2826d.setOnClickListener(onClickListener);
    }

    public void setRejectSuggestedLocationListener(OnClickListener onClickListener) {
        this.f2827e.setOnClickListener(onClickListener);
    }

    private final void m2872a() {
        setContentView(2130905176);
        this.f2824b = (FbDraweeView) a(2131563713);
        this.f2825c = (BetterTextView) a(2131563714);
        this.f2826d = a(2131563712);
        this.f2827e = a(2131563715);
        this.f2828f = (ImageView) a(2131563711);
        this.f2830h = getContext().getResources().getDimensionPixelSize(2131431942);
    }
}
