package com.facebook.facecastdisplay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: submitSurveyResponseParamsKey */
public class FacecastSquareView extends View {
    public FacecastSquareView(Context context) {
        this(context, null);
    }

    public FacecastSquareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastSquareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(0, i);
        setMeasuredDimension(defaultSize, View.resolveSize(defaultSize, i2));
    }
}
