package com.facebook.catalyst.shadow.flat;

import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.csslayout.Spacing;
import com.facebook.fbui.widget.text.staticlayouthelper.StaticLayoutHelper;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: loadPagesAlbumsListFromCache_%s */
final class RCTText extends RCTVirtualText implements MeasureFunction {
    private static final TextPaint f5789h = new TextPaint(1);
    @Nullable
    private static Metrics f5790i;
    @Nullable
    private CharSequence f5791j;
    @Nullable
    private DrawTextLayout f5792k;
    @Nullable
    private Metrics f5793l;
    private float f5794m = 1.0f;
    private float f5795n = 0.0f;
    private int f5796o = Integer.MAX_VALUE;
    private Alignment f5797p = Alignment.ALIGN_NORMAL;

    public RCTText() {
        a(this);
        al().f5753d = aj();
    }

    public final boolean mo173s() {
        return false;
    }

    public final boolean m7152t() {
        return true;
    }

    public final void m7149a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput) {
        CharSequence am = am();
        if (TextUtils.isEmpty(am)) {
            this.f5791j = null;
            measureOutput.a = 0.0f;
            measureOutput.b = 0.0f;
            return;
        }
        int i;
        this.f5791j = am;
        Object obj = (cSSMeasureMode == CSSMeasureMode.UNDEFINED || f < 0.0f) ? 1 : null;
        Metrics isBoring = BoringLayout.isBoring(am, f5789h, f5790i);
        if (isBoring != null) {
            Metrics metrics = this.f5793l;
            f5790i = metrics;
            if (metrics != null) {
                f5790i.top = 0;
                f5790i.ascent = 0;
                f5790i.descent = 0;
                f5790i.bottom = 0;
                f5790i.leading = 0;
            }
            this.f5793l = isBoring;
            float f3 = (float) isBoring.width;
            if (obj != null || f3 <= f) {
                measureOutput.a = f3;
                measureOutput.b = (float) m7146a(isBoring, true);
                this.f5792k = null;
                return;
            }
        }
        if (obj != null) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) f;
        }
        f5789h.setTextSize((float) ak());
        Layout a = StaticLayoutHelper.a(am, 0, am.length(), f5789h, i, this.f5797p, this.f5794m, this.f5795n, true, TruncateAt.END, i, this.f5796o, TextDirectionHeuristicsCompat.c);
        if (this.f5792k == null || this.f5792k.m6929l()) {
            this.f5792k = new DrawTextLayout(a);
        } else {
            this.f5792k.m6961a(a);
        }
        measureOutput.a = this.f5792k.m6964f();
        measureOutput.b = this.f5792k.m6965g();
    }

    protected final void mo166a(StateBuilder stateBuilder, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        super.mo166a(stateBuilder, f, f2, f3, f4, f5, f6, f7, f8);
        if (this.f5791j != null) {
            Object obj;
            if (this.f5792k == null) {
                this.f5792k = new DrawTextLayout(new BoringLayout(this.f5791j, f5789h, (int) (f3 - f), this.f5797p, this.f5794m, this.f5795n, this.f5793l, true));
                obj = 1;
            } else {
                obj = null;
            }
            Spacing k_ = k_();
            float a = k_.a(0) + f;
            float a2 = f2 + k_.a(1);
            this.f5792k = (DrawTextLayout) this.f5792k.m6924a(a, a2, a + this.f5792k.m6964f(), a2 + this.f5792k.m6965g(), f5, f6, f7, f8);
            stateBuilder.m7235a(this.f5792k);
            if (obj != null) {
                NodeRegion Z = m6998Z();
                if (Z instanceof TextNodeRegion) {
                    ((TextNodeRegion) Z).m7241a(this.f5792k.m6963e());
                }
            }
            mo168a(stateBuilder);
        }
    }

    @ReactProp(a = Double.NaN, name = "lineHeight")
    public final void setLineHeight(double d) {
        if (Double.isNaN(d)) {
            this.f5794m = 1.0f;
            this.f5795n = 0.0f;
        } else {
            this.f5794m = 0.0f;
            this.f5795n = PixelUtil.b((float) d);
        }
        mo172b(true);
    }

    @ReactProp(c = Integer.MAX_VALUE, name = "numberOfLines")
    public final void setNumberOfLines(int i) {
        this.f5796o = i;
        mo172b(true);
    }

    final void mo170a(float f, float f2, float f3, float f4, boolean z) {
        NodeRegion nodeRegion = this.f5674l;
        if (this.f5792k != null) {
            Layout layout;
            if (nodeRegion instanceof TextNodeRegion) {
                layout = ((TextNodeRegion) nodeRegion).f5827i;
            } else {
                layout = null;
            }
            Layout layout2 = this.f5792k.f5648c;
            if (nodeRegion.f5773c != f || nodeRegion.f5774d != f2 || nodeRegion.f5775e != f3 || nodeRegion.f5776f != f4 || nodeRegion.f5778h != z || r0 != layout2) {
                this.f5674l = new TextNodeRegion(f, f2, f3, f4, this.g, z, layout2);
            }
        } else if (nodeRegion.f5773c != f || nodeRegion.f5774d != f2 || nodeRegion.f5775e != f3 || nodeRegion.f5776f != f4 || nodeRegion.f5778h != z) {
            this.f5674l = new TextNodeRegion(f, f2, f3, f4, this.g, z, null);
        }
    }

    protected final int aj() {
        return RCTVirtualText.m7141g(14.0f);
    }

    protected final void mo172b(boolean z) {
        f();
    }

    @ReactProp(name = "textAlign")
    public final void setTextAlign(@Nullable String str) {
        if (str == null || "auto".equals(str)) {
            this.f5797p = Alignment.ALIGN_NORMAL;
        } else if ("left".equals(str)) {
            this.f5797p = Alignment.ALIGN_NORMAL;
        } else if ("right".equals(str)) {
            this.f5797p = Alignment.ALIGN_OPPOSITE;
        } else if ("center".equals(str)) {
            this.f5797p = Alignment.ALIGN_CENTER;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
        }
        mo172b(false);
    }

    private static int m7146a(Metrics metrics, boolean z) {
        if (z) {
            return metrics.bottom - metrics.top;
        }
        return metrics.descent - metrics.ascent;
    }
}
