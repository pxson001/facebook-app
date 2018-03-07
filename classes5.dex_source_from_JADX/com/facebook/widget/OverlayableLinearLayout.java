package com.facebook.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms.dynamic.IObjectWrapper */
public class OverlayableLinearLayout extends CustomLinearLayout {
    @Nullable
    public Drawable f5682a;

    public OverlayableLinearLayout(Context context) {
        super(context);
    }

    @Nullable
    public Drawable getOverlayDrawable() {
        return this.f5682a;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f5682a != null) {
            this.f5682a.setBounds(0, 0, getWidth(), getHeight());
            this.f5682a.draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -536443830);
        if (this.f5682a != null) {
            Logger.a(2, EntryType.UI_INPUT_END, -1216302736, a);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-1285985548, a);
        return onTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5682a != null || super.onInterceptTouchEvent(motionEvent);
    }
}
