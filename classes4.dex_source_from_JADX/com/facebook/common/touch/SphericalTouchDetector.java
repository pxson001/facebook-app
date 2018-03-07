package com.facebook.common.touch;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.touch.SphericalDragDetector.DragListener;
import com.facebook.common.touch.SphericalZoomDetector.1;
import com.facebook.common.touch.SphericalZoomDetector.ZoomListener;
import com.facebook.common.touch.SphericalZoomDetector.ZoomState;

/* compiled from: ping_process_failure */
public class SphericalTouchDetector {
    private final SphericalZoomDetector f4682a;
    private final SphericalDragDetector f4683b;
    private final TouchSlopDetector f4684c;
    private boolean f4685d;

    public SphericalTouchDetector(Context context, DragListener dragListener, ZoomListener zoomListener, boolean z) {
        this.f4684c = new TouchSlopDetector(ViewConfiguration.get(context).getScaledTouchSlop());
        this.f4683b = new SphericalDragDetector(dragListener, this.f4684c);
        this.f4682a = new SphericalZoomDetector(context, zoomListener);
        this.f4685d = z;
    }

    public final boolean m5170a(MotionEvent motionEvent) {
        if (!this.f4685d) {
            return this.f4683b.m5176a(motionEvent);
        }
        SphericalZoomDetector sphericalZoomDetector = this.f4682a;
        Object obj = null;
        sphericalZoomDetector.f4712d = ZoomState.UNSET;
        sphericalZoomDetector.f4709a.onTouchEvent(motionEvent);
        switch (1.a[sphericalZoomDetector.f4712d.ordinal()]) {
            case 1:
            case 2:
                obj = 1;
                break;
        }
        if (obj != null || this.f4683b.m5176a(motionEvent)) {
            return true;
        }
        return false;
    }
}
