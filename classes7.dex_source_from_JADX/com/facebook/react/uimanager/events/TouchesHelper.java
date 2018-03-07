package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

/* compiled from: follow */
class TouchesHelper {
    TouchesHelper() {
    }

    private static WritableArray m14176a(int i, TouchEvent touchEvent) {
        WritableArray a = Arguments.m13384a();
        MotionEvent j = touchEvent.m14168j();
        float x = j.getX() - touchEvent.f11912e;
        float y = j.getY() - touchEvent.f11913f;
        for (int i2 = 0; i2 < j.getPointerCount(); i2++) {
            WritableMap b = Arguments.m13388b();
            b.putDouble("pageX", (double) PixelUtil.m13926c(j.getX(i2)));
            b.putDouble("pageY", (double) PixelUtil.m13926c(j.getY(i2)));
            float y2 = j.getY(i2) - y;
            b.putDouble("locationX", (double) PixelUtil.m13926c(j.getX(i2) - x));
            b.putDouble("locationY", (double) PixelUtil.m13926c(y2));
            b.putInt("target", i);
            b.putDouble("timeStamp", (double) touchEvent.m13912d());
            b.putDouble("identifier", (double) j.getPointerId(i2));
            a.mo689a(b);
        }
        return a;
    }

    public static void m14177a(RCTEventEmitter rCTEventEmitter, TouchEventType touchEventType, int i, TouchEvent touchEvent) {
        WritableArray a = m14176a(i, touchEvent);
        MotionEvent j = touchEvent.m14168j();
        WritableArray a2 = Arguments.m13384a();
        if (touchEventType == TouchEventType.MOVE || touchEventType == TouchEventType.CANCEL) {
            for (int i2 = 0; i2 < j.getPointerCount(); i2++) {
                a2.pushInt(i2);
            }
        } else if (touchEventType == TouchEventType.START || touchEventType == TouchEventType.END) {
            a2.pushInt(j.getActionIndex());
        } else {
            throw new RuntimeException("Unknown touch type: " + touchEventType);
        }
        rCTEventEmitter.receiveTouches(touchEventType.getJSEventName(), a, a2);
    }
}
