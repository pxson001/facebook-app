package com.facebook.videocodec.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.widget.CustomViewGroup;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: com.google.android.gms.maps.internal.IOnMyLocationChangeListener */
public class VideoTrimmingFilmStripClipsLayout extends CustomViewGroup {
    private List<ImageView> f19704a;
    private int f19705b;
    private int f19706c;

    public VideoTrimmingFilmStripClipsLayout(Context context) {
        super(context);
        m28414a(context);
    }

    public VideoTrimmingFilmStripClipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28414a(context);
    }

    public VideoTrimmingFilmStripClipsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28414a(context);
    }

    private void m28414a(Context context) {
        this.f19705b = getResources().getDimensionPixelSize(2131429573);
        this.f19704a = Lists.a();
        for (int i = 0; i < 7; i++) {
            View imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.CENTER_CROP);
            addView(imageView, i);
            this.f19704a.add(imageView);
        }
    }

    public int getNumPreviewImages() {
        return 7;
    }

    public final void m28415a(int i, Bitmap bitmap) {
        ((ImageView) this.f19704a.get(i)).setImageBitmap(bitmap);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        MeasureSpec.getMode(i2);
        MeasureSpec.getSize(i2);
        this.f19706c = (size - ((this.f19705b * 7) + (getPaddingLeft() + getPaddingRight()))) / 7;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f19706c, 1073741824);
        for (ImageView measure : this.f19704a) {
            measure.measure(makeMeasureSpec, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        getRight();
        getLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        int i5 = paddingLeft;
        for (ImageView imageView : this.f19704a) {
            int measuredWidth = imageView.getMeasuredWidth();
            imageView.layout(i5, paddingTop, imageView.getMeasuredWidth() + i5, bottom);
            i5 = (this.f19705b + measuredWidth) + i5;
        }
    }
}
