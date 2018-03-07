package com.facebook.feedback.reactions.ui;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: setting_value */
public class ReactionsOverlayVectorBasedView extends View {
    private final ReactionsVectorDrawable f3889a;

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f3889a.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1965091523);
        super.onAttachedToWindow();
        this.f3889a.m4542a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1947023613, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 495879306);
        super.onDetachedFromWindow();
        this.f3889a.m4543b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1357248964, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f3889a.m4543b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f3889a.m4542a();
    }

    protected void onDraw(Canvas canvas) {
        this.f3889a.draw(canvas);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3889a;
    }
}
