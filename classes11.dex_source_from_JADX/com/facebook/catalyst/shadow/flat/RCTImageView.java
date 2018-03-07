package com.facebook.catalyst.shadow.flat;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ImageResizeMode;
import javax.annotation.Nullable;

/* compiled from: locationServicesDialog */
public class RCTImageView<T extends AbstractDrawCommand & DrawImage> extends FlatShadowNode {
    public static Object f5784h = RCTImageView.class;
    private T f5785i;

    static void m7116a(Object obj) {
        f5784h = obj;
    }

    static Object ai() {
        return f5784h;
    }

    RCTImageView(T t) {
        this.f5785i = t;
    }

    protected final void mo166a(StateBuilder stateBuilder, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        super.mo166a(stateBuilder, f, f2, f3, f4, f5, f6, f7, f8);
        if (((DrawImageWithDrawee) this.f5785i).nV_()) {
            this.f5785i = this.f5785i.m6924a(f, f2, f3, f4, f5, f6, f7, f8);
            stateBuilder.m7235a(this.f5785i);
            stateBuilder.m7236a((AttachDetachListener) this.f5785i);
        }
    }

    @ReactProp(name = "shouldNotifyLoadEvents")
    public void setShouldNotifyLoadEvents(boolean z) {
        int i;
        DrawImageWithDrawee drawImageWithDrawee = (DrawImageWithDrawee) aj();
        if (z) {
            i = this.g;
        } else {
            i = 0;
        }
        drawImageWithDrawee.f5645i = i;
    }

    @ReactProp(name = "src")
    public void setSource(@Nullable String str) {
        DrawImageWithDrawee drawImageWithDrawee = (DrawImageWithDrawee) aj();
        ImageRequest a = ImageRequestHelper.m7087a(E(), str);
        if (a == null) {
            drawImageWithDrawee.f5639c = null;
        } else {
            drawImageWithDrawee.f5639c = new DraweeRequestHelper(a, drawImageWithDrawee);
        }
    }

    @ReactProp(name = "tintColor")
    public void setTintColor(int i) {
        DrawImageWithDrawee drawImageWithDrawee = (DrawImageWithDrawee) aj();
        if (i == 0) {
            drawImageWithDrawee.f5640d = null;
        } else {
            drawImageWithDrawee.f5640d = new PorterDuffColorFilter(i, Mode.SRC_ATOP);
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(@Nullable String str) {
        ScaleType a = ImageResizeMode.m11845a(str);
        if (((DrawImageWithDrawee) this.f5785i).f5641e != a) {
            ((DrawImageWithDrawee) aj()).f5641e = a;
        }
    }

    @ReactProp(customType = "Color", name = "borderColor")
    public void setBorderColor(int i) {
        if (((DrawImageWithDrawee) this.f5785i).f5644h != i) {
            ((DrawImageWithDrawee) aj()).f5644h = i;
        }
    }

    public final void m7118c(int i, float f) {
        super.c(i, f);
        if (i == 8 && ((DrawImageWithDrawee) this.f5785i).f5642f != f) {
            ((DrawImageWithDrawee) aj()).f5642f = f;
        }
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(float f) {
        if (((DrawImageWithDrawee) this.f5785i).f5643g != f) {
            ((DrawImageWithDrawee) aj()).f5643g = PixelUtil.a(f);
        }
    }

    @ReactProp(name = "fadeDuration")
    public void setFadeDuration(int i) {
        ((DrawImageWithDrawee) aj()).f5646j = i;
    }

    private T aj() {
        if (this.f5785i.f5615g) {
            this.f5785i = this.f5785i.m6928k();
            m6988P();
        }
        return this.f5785i;
    }
}
