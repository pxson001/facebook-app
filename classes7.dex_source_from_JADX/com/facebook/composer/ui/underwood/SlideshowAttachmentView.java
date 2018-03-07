package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.composer.ui.underwood.UnderwoodAttachmentUtils.MeasureSpecs;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: component_id */
public class SlideshowAttachmentView extends CustomFrameLayout {
    public float f17119a;
    public float f17120b;
    public View f17121c;
    public FbDraweeView f17122d;
    public ImageView f17123e;
    public View f17124f;

    public SlideshowAttachmentView(Context context) {
        this(context, null);
    }

    private SlideshowAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SlideshowAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907635);
        this.f17121c = findViewById(2131567238);
        this.f17121c.setVisibility(0);
        this.f17122d = (FbDraweeView) c(2131559119);
        this.f17123e = (ImageView) c(2131560526);
        this.f17124f = c(2131568150);
    }

    public void setController(DraweeController draweeController) {
        this.f17122d.setController(draweeController);
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecs a = UnderwoodAttachmentUtils.m21132a(this.f17120b, (LayoutParams) getLayoutParams(), new MeasureSpecs(i, i2));
        super.onMeasure(a.f17170a, a.f17171b);
    }

    public void setScale(float f) {
        this.f17119a = f;
        setScaleX(f);
        setScaleY(f);
    }
}
