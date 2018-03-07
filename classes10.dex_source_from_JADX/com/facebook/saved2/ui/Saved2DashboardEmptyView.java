package com.facebook.saved2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.facebook.fbui.widget.text.ImageWithTextView;
import javax.annotation.Nullable;

/* compiled from: instant_shopping_audio_state */
public class Saved2DashboardEmptyView extends ImageWithTextView {
    @Nullable
    public OnAfterDrawListener f9488a;

    /* compiled from: instant_shopping_audio_state */
    public interface OnAfterDrawListener {
        void mo442a();
    }

    public Saved2DashboardEmptyView(Context context) {
        super(context);
    }

    public Saved2DashboardEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Saved2DashboardEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnAfterDrawListener(OnAfterDrawListener onAfterDrawListener) {
        this.f9488a = onAfterDrawListener;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9488a != null) {
            this.f9488a.mo442a();
        }
    }
}
