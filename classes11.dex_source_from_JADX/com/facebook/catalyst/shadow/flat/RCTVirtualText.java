package com.facebook.catalyst.shadow.flat;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.facebook.csslayout.CSSNode;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: load_attempts */
public class RCTVirtualText extends FlatTextShadowNode {
    private FontStylingSpan f5787h = FontStylingSpan.f5750a;
    private ShadowStyleSpan f5788i = ShadowStyleSpan.f5807a;

    RCTVirtualText() {
    }

    public void m7144a(CSSNode cSSNode, int i) {
        super.a(cSSNode, i);
        mo172b(true);
    }

    protected void mo169c(SpannableStringBuilder spannableStringBuilder) {
        int a = a();
        for (int i = 0; i < a; i++) {
            ((FlatTextShadowNode) e(i)).m7015a(spannableStringBuilder);
        }
    }

    protected final void mo167a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.f5787h.f5757h = true;
        int i3 = i == 0 ? 18 : 34;
        spannableStringBuilder.setSpan(this.f5787h, i, i2, i3);
        if (!(this.f5788i.f5811e == 0 || this.f5788i.f5810d == 0.0f)) {
            this.f5788i.f5812f = true;
            spannableStringBuilder.setSpan(this.f5788i, i, i2, i3);
        }
        int a = a();
        for (int i4 = 0; i4 < a; i4++) {
            ((FlatTextShadowNode) e(i4)).m7018b(spannableStringBuilder);
        }
    }

    protected final void mo168a(StateBuilder stateBuilder) {
        int a = a();
        for (int i = 0; i < a; i++) {
            ((FlatTextShadowNode) e(i)).mo168a(stateBuilder);
        }
    }

    @ReactProp(b = Float.NaN, name = "fontSize")
    public void setFontSize(float f) {
        int aj;
        if (Float.isNaN(f)) {
            aj = aj();
        } else {
            aj = m7141g(f);
        }
        if (this.f5787h.f5753d != aj) {
            al().f5753d = aj;
            mo172b(true);
        }
    }

    @ReactProp(a = Double.NaN, name = "color")
    public void setColor(double d) {
        if (this.f5787h.f5751b != d) {
            al().f5751b = d;
            mo172b(false);
        }
    }

    public void setBackgroundColor(int i) {
        if (!s()) {
            super.setBackgroundColor(i);
        } else if (this.f5787h.f5752c != i) {
            al().f5752c = i;
            mo172b(false);
        }
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(@Nullable String str) {
        if (!TextUtils.equals(this.f5787h.f5756g, str)) {
            al().f5756g = str;
            mo172b(true);
        }
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(@Nullable String str) {
        int i = -1;
        if (str != null) {
            if ("bold".equals(str)) {
                i = 1;
            } else {
                if (!"normal".equals(str)) {
                    int b = m7140b(str);
                    if (b == -1) {
                        throw new RuntimeException("invalid font weight " + str);
                    } else if (b >= 500) {
                        i = 1;
                    }
                }
                i = 0;
            }
        }
        if (this.f5787h.f5755f != i) {
            al().f5755f = i;
            mo172b(true);
        }
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(@Nullable String str) {
        int i;
        if (str == null) {
            i = -1;
        } else if ("italic".equals(str)) {
            i = 2;
        } else if ("normal".equals(str)) {
            i = 0;
        } else {
            throw new RuntimeException("invalid font style " + str);
        }
        if (this.f5787h.f5754e != i) {
            al().f5754e = i;
            mo172b(true);
        }
    }

    @ReactProp(name = "textShadowOffset")
    public void setTextShadowOffset(@Nullable ReadableMap readableMap) {
        float a;
        Object obj;
        float f = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width")) {
                a = PixelUtil.a(readableMap.getDouble("width"));
            } else {
                a = 0.0f;
            }
            if (readableMap.hasKey("height")) {
                f = PixelUtil.a(readableMap.getDouble("height"));
            }
        } else {
            a = 0.0f;
        }
        ShadowStyleSpan shadowStyleSpan = this.f5788i;
        if (shadowStyleSpan.f5808b == a && shadowStyleSpan.f5809c == f) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            shadowStyleSpan = an();
            shadowStyleSpan.f5808b = a;
            shadowStyleSpan.f5809c = f;
            mo172b(false);
        }
    }

    @ReactProp(name = "textShadowRadius")
    public void setTextShadowRadius(float f) {
        float a = PixelUtil.a(f);
        if (this.f5788i.f5810d != a) {
            an().f5810d = a;
            mo172b(false);
        }
    }

    @ReactProp(c = 1426063360, customType = "Color", name = "textShadowColor")
    public void setTextShadowColor(int i) {
        if (this.f5788i.f5811e != i) {
            an().f5811e = i;
            mo172b(false);
        }
    }

    protected final int ak() {
        return this.f5787h.f5753d;
    }

    protected int aj() {
        return -1;
    }

    static int m7141g(float f) {
        return (int) Math.ceil((double) PixelUtil.b(f));
    }

    protected final FontStylingSpan al() {
        if (this.f5787h.f5757h) {
            FontStylingSpan fontStylingSpan = this.f5787h;
            this.f5787h = new FontStylingSpan(fontStylingSpan.f5751b, fontStylingSpan.f5752c, fontStylingSpan.f5753d, fontStylingSpan.f5754e, fontStylingSpan.f5755f, fontStylingSpan.f5756g, false);
        }
        return this.f5787h;
    }

    final SpannableStringBuilder am() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        m7015a(spannableStringBuilder);
        m7018b(spannableStringBuilder);
        return spannableStringBuilder;
    }

    private final ShadowStyleSpan an() {
        if (this.f5788i.f5812f) {
            ShadowStyleSpan shadowStyleSpan = this.f5788i;
            this.f5788i = new ShadowStyleSpan(shadowStyleSpan.f5808b, shadowStyleSpan.f5809c, shadowStyleSpan.f5810d, shadowStyleSpan.f5811e, false);
        }
        return this.f5788i;
    }

    private static int m7140b(String str) {
        return (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') ? -1 : (str.charAt(0) - 48) * 100;
    }
}
