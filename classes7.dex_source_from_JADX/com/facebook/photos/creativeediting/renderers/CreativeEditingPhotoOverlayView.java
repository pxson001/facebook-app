package com.facebook.photos.creativeediting.renderers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: mTargetUid */
public class CreativeEditingPhotoOverlayView extends CustomFrameLayout {
    public OverlayViewEventListener f9581a;

    /* compiled from: mTargetUid */
    public interface OverlayViewEventListener {
        void mo497a();

        void mo498a(Canvas canvas);

        boolean mo499a(Drawable drawable);

        void mo500b();
    }

    public CreativeEditingPhotoOverlayView(Context context) {
        super(context);
    }

    public CreativeEditingPhotoOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CreativeEditingPhotoOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOverlayViewEventListener(OverlayViewEventListener overlayViewEventListener) {
        this.f9581a = overlayViewEventListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1252207046);
        super.onAttachedToWindow();
        if (this.f9581a != null) {
            this.f9581a.mo497a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1316339730, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f9581a != null) {
            this.f9581a.mo500b();
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f9581a != null) {
            this.f9581a.mo497a();
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -377208043);
        super.onDetachedFromWindow();
        if (this.f9581a != null) {
            this.f9581a.mo500b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1903659101, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f9581a != null) {
            this.f9581a.mo498a(canvas);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        if (this.f9581a == null || !this.f9581a.mo499a(drawable)) {
            return false;
        }
        return true;
    }
}
