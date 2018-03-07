package com.facebook.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: nux_type */
public class FbSwipeRefreshLayout extends SwipeRefreshLayout {
    private int f11675c;
    private float f11676d;
    private boolean f11677e;

    public FbSwipeRefreshLayout(Context context) {
        this(context, null);
        m16959a(context);
    }

    public FbSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16959a(context);
    }

    private void m16959a(Context context) {
        this.f11675c = ViewConfiguration.get(context).getScaledTouchSlop();
        setColorSchemeResources(2131361916);
        setProgressBackgroundColorSchemeResource(2131361864);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f11676d = motionEvent.getX();
                this.f11677e = false;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                float abs = Math.abs(motionEvent.getX() - this.f11676d);
                if (this.f11677e || abs > ((float) this.f11675c)) {
                    this.f11677e = true;
                    return false;
                }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
