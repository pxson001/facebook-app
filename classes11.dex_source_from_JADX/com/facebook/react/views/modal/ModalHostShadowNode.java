package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.csslayout.CSSNode;
import com.facebook.react.uimanager.LayoutShadowNode;

/* compiled from: SCHEDULED_POSTS */
class ModalHostShadowNode extends LayoutShadowNode {
    private final Point f11465g = new Point();
    private final Point f11466h = new Point();

    ModalHostShadowNode() {
    }

    @TargetApi(16)
    public final void m11876a(CSSNode cSSNode, int i) {
        int i2;
        super.a(cSSNode, i);
        Display defaultDisplay = ((WindowManager) E().getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getCurrentSizeRange(this.f11465g, this.f11466h);
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0 || rotation == 2) {
            i2 = this.f11465g.x;
            rotation = this.f11466h.y;
        } else {
            i2 = this.f11466h.x;
            rotation = this.f11465g.y;
        }
        cSSNode.e((float) i2);
        cSSNode.f((float) rotation);
    }
}
