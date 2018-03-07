package com.facebook.saved2.ui.itemadapters;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import javax.annotation.Nullable;

/* compiled from: iner1277qwve */
public class Saved2DashboardItemView extends ContentViewWithButton {
    @Nullable
    public OnAfterDrawListener f9595h;

    /* compiled from: iner1277qwve */
    public interface OnAfterDrawListener {
        void mo450a();
    }

    public Saved2DashboardItemView(Context context) {
        super(context);
    }

    public Saved2DashboardItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Saved2DashboardItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnAfterDrawListener(OnAfterDrawListener onAfterDrawListener) {
        this.f9595h = onAfterDrawListener;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9595h != null) {
            this.f9595h.mo450a();
        }
    }
}
