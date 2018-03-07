package com.facebook.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: result_content_length */
public class FbImageView extends ImageView {
    private boolean f6744a = false;

    public FbImageView(Context context) {
        super(context);
    }

    public FbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable != null) {
            boolean z;
            if (getVisibility() == 0 && this.f6744a) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            boolean z;
            if (getVisibility() == 0 && this.f6744a) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
    }

    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable != null) {
            drawable.setVisible(false, false);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 683826328);
        super.onAttachedToWindow();
        this.f6744a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 872201248, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1712327359);
        super.onDetachedFromWindow();
        this.f6744a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1640492301, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setVisible(false, false);
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            boolean z;
            if (getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
    }
}
