package com.facebook.search.quickpromotion;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.facebook.widget.FbImageView;

/* compiled from: TEXT_ELEMENT_UFI */
public class FitWidthCropBottomImageView extends FbImageView {
    public FitWidthCropBottomImageView(Context context) {
        super(context);
        setScaleType(ScaleType.MATRIX);
    }

    public FitWidthCropBottomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ScaleType.MATRIX);
    }

    public FitWidthCropBottomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ScaleType.MATRIX);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getDrawable() == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        Matrix imageMatrix = getImageMatrix();
        float width = ((float) getWidth()) / ((float) getDrawable().getIntrinsicWidth());
        imageMatrix.setScale(width, width, 0.0f, 0.0f);
        int intrinsicHeight = (int) (width * ((float) getDrawable().getIntrinsicHeight()));
        if (intrinsicHeight < getHeight()) {
            imageMatrix.postTranslate(0.0f, (float) (getHeight() - intrinsicHeight));
        }
        setImageMatrix(imageMatrix);
        super.onLayout(z, i, i2, i3, i4);
    }
}
