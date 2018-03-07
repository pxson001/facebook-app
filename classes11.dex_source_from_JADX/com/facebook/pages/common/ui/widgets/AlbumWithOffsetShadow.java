package com.facebook.pages.common.ui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

/* compiled from: red_space_friend */
public class AlbumWithOffsetShadow extends FbDraweeView {
    private int f2710c;
    private int f2711d;
    private Drawable f2712e;

    public AlbumWithOffsetShadow(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        m3649c();
    }

    public AlbumWithOffsetShadow(Context context) {
        super(context);
        m3649c();
    }

    public AlbumWithOffsetShadow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3649c();
    }

    public AlbumWithOffsetShadow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3649c();
    }

    private void m3649c() {
        this.f2710c = getContext().getResources().getDimensionPixelSize(2131429812);
        this.f2711d = 0;
    }

    public void setShadow(Drawable drawable) {
        m3650a(drawable, 1);
    }

    public final void m3650a(Drawable drawable, int i) {
        this.f2712e = drawable;
        this.f2711d = i;
        setPadding(0, 0, this.f2710c * this.f2711d, this.f2710c * this.f2711d);
    }

    public void setOffset(int i) {
        this.f2710c = i;
        setPadding(0, 0, this.f2710c * this.f2711d, this.f2710c * this.f2711d);
    }

    public void onDraw(Canvas canvas) {
        if (this.f2712e != null) {
            int measuredWidth = getMeasuredWidth() - getPaddingRight();
            int measuredHeight = getMeasuredHeight() - getPaddingBottom();
            for (int i = this.f2711d; i >= 0; i--) {
                int i2 = this.f2710c * i;
                this.f2712e.setBounds(i2, i2, measuredWidth + i2, measuredHeight + i2);
                this.f2712e.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }
}
