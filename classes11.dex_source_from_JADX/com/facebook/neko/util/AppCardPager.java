package com.facebook.neko.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: topDrawerClosed */
public class AppCardPager extends ViewPager {
    private float f825a;
    private float f826b;
    public AppUnitState f827c;

    public AppCardPager(Context context) {
        super(context);
    }

    public AppCardPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAppUnitState(AppUnitState appUnitState) {
        this.f827c = appUnitState;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f827c != AppUnitState.Apps || getChildCount() <= 1) {
            return false;
        }
        return m1117a(motionEvent);
    }

    private boolean m1117a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f825a = motionEvent.getX();
            this.f826b = motionEvent.getY();
        } else if (action == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            x = Math.abs(this.f825a - x);
            if (Math.abs(this.f826b - y) > x + 20.0f) {
                return true;
            }
            if (x > 20.0f) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1777021243);
        if (this.f827c != AppUnitState.Apps || getChildCount() <= 1) {
            LogUtils.a(1883289138, a);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1749322962, a);
        return onTouchEvent;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i3) {
                i3 = measuredHeight;
            }
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }
}
