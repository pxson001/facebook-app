package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.composer.ui.underwood.UnderwoodAttachmentUtils.MeasureSpecs;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: use_cropping */
public class SphericalPhotoAttachmentView extends CustomFrameLayout {
    public float f17138a;
    public float f17139b;
    public FbDraweeView f17140c;
    public ImageView f17141d;

    public SphericalPhotoAttachmentView(Context context) {
        this(context, null);
    }

    private SphericalPhotoAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SphericalPhotoAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907636);
        this.f17140c = (FbDraweeView) c(2131559119);
        this.f17141d = (ImageView) c(2131560526);
    }

    public void setController(DraweeController draweeController) {
        this.f17140c.setController(draweeController);
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecs a = UnderwoodAttachmentUtils.m21132a(this.f17139b, (LayoutParams) getLayoutParams(), new MeasureSpecs(i, i2));
        super.onMeasure(a.f17170a, a.f17171b);
    }

    public void setScale(float f) {
        this.f17138a = f;
        setScaleX(f);
        setScaleY(f);
        setAlpha(f);
    }
}
