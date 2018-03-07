package com.facebook.react.views.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;

/* compiled from: SEND_BULK_PRIVACY_EDIT */
public class ARTSurfaceViewShadowNode extends LayoutShadowNode {
    public final boolean m11795s() {
        return false;
    }

    public final boolean m11796t() {
        return true;
    }

    public final void m11794a(UIViewOperationQueue uIViewOperationQueue) {
        super.a(uIViewOperationQueue);
        uIViewOperationQueue.a(this.g, m11793O());
    }

    private Object m11793O() {
        Bitmap createBitmap = Bitmap.createBitmap((int) o(), (int) p(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        for (int i = 0; i < a(); i++) {
            ARTVirtualNode aRTVirtualNode = (ARTVirtualNode) e(i);
            aRTVirtualNode.mo305a(canvas, paint, 1.0f);
            aRTVirtualNode.w();
        }
        return createBitmap;
    }
}
