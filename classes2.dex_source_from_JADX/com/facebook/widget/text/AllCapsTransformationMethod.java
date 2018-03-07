package com.facebook.widget.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: return_intent */
public class AllCapsTransformationMethod implements TransformationMethod {
    private final Locale f6727a;

    public AllCapsTransformationMethod(Context context) {
        this.f6727a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return charSequence != null ? charSequence.toString().toUpperCase(this.f6727a) : null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
