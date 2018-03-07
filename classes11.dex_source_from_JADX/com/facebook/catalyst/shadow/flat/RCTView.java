package com.facebook.catalyst.shadow.flat;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import javax.annotation.Nullable;

/* compiled from: line-through */
final class RCTView extends FlatShadowNode {
    @Nullable
    private DrawBorder f5805h;

    RCTView() {
    }

    protected final void mo166a(StateBuilder stateBuilder, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        super.mo166a(stateBuilder, f, f2, f3, f4, f5, f6, f7, f8);
        if (this.f5805h != null) {
            this.f5805h = (DrawBorder) this.f5805h.m6924a(f, f2, f3, f4, f5, f6, f7, f8);
            stateBuilder.m7235a(this.f5805h);
        }
    }

    public final void setBackgroundColor(int i) {
        ai().f5637n = i;
    }

    public final void setBorderWidths(int i, float f) {
        super.setBorderWidths(i, f);
        int i2 = ViewProps.a[i];
        AbstractDrawBorder ai = ai();
        float a = PixelUtil.a(f);
        switch (i2) {
            case 0:
                ai.f5628e = a;
                return;
            case 1:
                ai.f5629f = a;
                return;
            case 2:
                ai.f5630g = a;
                return;
            case 3:
                ai.f5631h = a;
                return;
            case 8:
                ai.f5620g = a;
                ai.m6935c(1);
                return;
            default:
                return;
        }
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public final void setHotspot(@Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            ae();
        }
    }

    @ReactPropGroup(a = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"}, c = Double.NaN, customType = "Color")
    public final void setBorderColor(int i, double d) {
        int i2 = ViewProps.a[i];
        AbstractDrawBorder ai;
        if (Double.isNaN(d)) {
            ai = ai();
            switch (i2) {
                case 0:
                    ai.m6936d(2);
                    return;
                case 1:
                    ai.m6936d(4);
                    return;
                case 2:
                    ai.m6936d(8);
                    return;
                case 3:
                    ai.m6936d(16);
                    return;
                case 8:
                    ai.f5619f = -16777216;
                    return;
                default:
                    return;
            }
        }
        ai = ai();
        int i3 = (int) d;
        switch (i2) {
            case 0:
                ai.f5632i = i3;
                ai.m6935c(2);
                break;
            case 1:
                ai.f5633j = i3;
                ai.m6935c(4);
                break;
            case 2:
                ai.f5634k = i3;
                ai.m6935c(8);
                break;
            case 3:
                ai.f5635l = i3;
                ai.m6935c(16);
                break;
            case 8:
                ai.f5619f = i3;
                break;
        }
    }

    @ReactProp(name = "borderRadius")
    public final void setBorderRadius(float f) {
        AbstractDrawBorder ai = ai();
        ai.f5621h = PixelUtil.a(f);
        ai.m6935c(1);
    }

    @ReactProp(name = "borderStyle")
    public final void setBorderStyle(@Nullable String str) {
        AbstractDrawBorder ai = ai();
        if ("dotted".equals(str)) {
            ai.f5636m = 1;
        } else if ("dashed".equals(str)) {
            ai.f5636m = 2;
        } else {
            ai.f5636m = 0;
        }
        ai.m6935c(32);
    }

    @ReactProp(name = "pointerEvents")
    public final void setPointerEvents(@Nullable String str) {
        ae();
    }

    private DrawBorder ai() {
        if (this.f5805h == null) {
            this.f5805h = new DrawBorder();
        } else if (this.f5805h.f5615g) {
            this.f5805h = (DrawBorder) this.f5805h.m6928k();
        }
        m6988P();
        return this.f5805h;
    }
}
