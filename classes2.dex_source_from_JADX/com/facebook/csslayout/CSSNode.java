package com.facebook.csslayout;

import com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: image_medium_width */
public class CSSNode {
    public final CSSStyle f22780a = new CSSStyle();
    public final CSSLayout f22781b = new CSSLayout();
    public final CachedCSSLayout f22782c = new CachedCSSLayout();
    public int f22783d = 0;
    CSSNode f22784e;
    CSSNode f22785f;
    @Nullable
    private ArrayList<CSSNode> f22786g;
    @Nullable
    private CSSNode f22787h;
    @Nullable
    private MeasureFunction f22788i = null;
    public LayoutState f22789j = LayoutState.DIRTY;

    /* compiled from: image_medium_width */
    public interface MeasureFunction {
        void mo3136a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput);
    }

    /* compiled from: image_medium_width */
    public enum LayoutState {
        DIRTY,
        HAS_NEW_LAYOUT,
        UP_TO_DATE
    }

    public final int m30841a() {
        return this.f22786g == null ? 0 : this.f22786g.size();
    }

    public CSSNode a_(int i) {
        Assertions.m5471b(this.f22786g);
        return (CSSNode) this.f22786g.get(i);
    }

    public void m30850a(CSSNode cSSNode, int i) {
        if (cSSNode.f22787h != null) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
        if (this.f22786g == null) {
            this.f22786g = new ArrayList(4);
        }
        this.f22786g.add(i, cSSNode);
        cSSNode.f22787h = this;
        m30861f();
    }

    public CSSNode b_(int i) {
        Assertions.m5471b(this.f22786g);
        CSSNode cSSNode = (CSSNode) this.f22786g.remove(i);
        cSSNode.f22787h = null;
        m30861f();
        return cSSNode;
    }

    @Nullable
    public CSSNode m30853b() {
        return this.f22787h;
    }

    public final int m30842a(CSSNode cSSNode) {
        Assertions.m5471b(this.f22786g);
        return this.f22786g.indexOf(cSSNode);
    }

    public final void m30849a(MeasureFunction measureFunction) {
        if (this.f22788i != measureFunction) {
            this.f22788i = measureFunction;
            m30861f();
        }
    }

    public final boolean e_() {
        return this.f22788i != null;
    }

    final MeasureOutput m30843a(MeasureOutput measureOutput, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2) {
        if (e_()) {
            measureOutput.f22746b = Float.NaN;
            measureOutput.f22745a = Float.NaN;
            ((MeasureFunction) Assertions.m5471b(this.f22788i)).mo3136a(this, f, cSSMeasureMode, f2, cSSMeasureMode2, measureOutput);
            return measureOutput;
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public final void m30848a(CSSLayoutContext cSSLayoutContext) {
        this.f22781b.m30948a();
        LayoutEngine.m31098a(cSSLayoutContext, this, Float.NaN, Float.NaN, null);
    }

    public final boolean f_() {
        return this.f22789j == LayoutState.DIRTY;
    }

    public final boolean g_() {
        return this.f22789j == LayoutState.HAS_NEW_LAYOUT;
    }

    public void m30861f() {
        if (this.f22789j != LayoutState.DIRTY) {
            if (this.f22789j == LayoutState.HAS_NEW_LAYOUT) {
                throw new IllegalStateException("Previous layout was ignored! markLayoutSeen() never called");
            }
            this.f22789j = LayoutState.DIRTY;
            if (this.f22787h != null) {
                this.f22787h.m30861f();
            }
        }
    }

    public final void i_() {
        if (g_()) {
            this.f22789j = LayoutState.UP_TO_DATE;
            return;
        }
        throw new IllegalStateException("Expected node to have a new layout to be seen!");
    }

    private void m30840a(StringBuilder stringBuilder, int i) {
        int i2 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i3 = 0; i3 < i; i3++) {
            stringBuilder2.append("__");
        }
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(this.f22781b.toString());
        if (m30841a() != 0) {
            stringBuilder.append(", children: [\n");
            while (i2 < m30841a()) {
                a_(i2).m30840a(stringBuilder, i + 1);
                stringBuilder.append("\n");
                i2++;
            }
            stringBuilder.append(stringBuilder2 + "]");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m30840a(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public final void m30846a(CSSFlexDirection cSSFlexDirection) {
        if (this.f22780a.f22803b != cSSFlexDirection) {
            this.f22780a.f22803b = cSSFlexDirection;
            m30861f();
        }
    }

    public final void m30847a(CSSJustify cSSJustify) {
        if (this.f22780a.f22804c != cSSJustify) {
            this.f22780a.f22804c = cSSJustify;
            m30861f();
        }
    }

    public final void m30845a(CSSAlign cSSAlign) {
        if (this.f22780a.f22806e != cSSAlign) {
            this.f22780a.f22806e = cSSAlign;
            m30861f();
        }
    }

    public final void m30855b(CSSAlign cSSAlign) {
        if (this.f22780a.f22807f != cSSAlign) {
            this.f22780a.f22807f = cSSAlign;
            m30861f();
        }
    }

    public final void m30851a(CSSPositionType cSSPositionType) {
        if (this.f22780a.f22808g != cSSPositionType) {
            this.f22780a.f22808g = cSSPositionType;
            m30861f();
        }
    }

    public final void m30852a(CSSWrap cSSWrap) {
        if (this.f22780a.f22809h != cSSWrap) {
            this.f22780a.f22809h = cSSWrap;
            m30861f();
        }
    }

    public void setFlex(float f) {
        if (!FloatUtil.m30999a(this.f22780a.f22810i, f)) {
            this.f22780a.f22810i = f;
            m30861f();
        }
    }

    public final void m30844a(int i, float f) {
        if (this.f22780a.f22811j.m30945a(i, f)) {
            m30861f();
        }
    }

    public final Spacing k_() {
        return this.f22780a.f22812k;
    }

    public void m30854b(int i, float f) {
        if (this.f22780a.f22812k.m30945a(i, f)) {
            m30861f();
        }
    }

    public void m30857c(int i, float f) {
        if (this.f22780a.f22813l.m30945a(i, f)) {
            m30861f();
        }
    }

    public final void a_(float f) {
        if (!FloatUtil.m30999a(this.f22780a.f22814m[1], f)) {
            this.f22780a.f22814m[1] = f;
            m30861f();
        }
    }

    public final void b_(float f) {
        if (!FloatUtil.m30999a(this.f22780a.f22814m[3], f)) {
            this.f22780a.f22814m[3] = f;
            m30861f();
        }
    }

    public final void m30856c(float f) {
        if (!FloatUtil.m30999a(this.f22780a.f22814m[0], f)) {
            this.f22780a.f22814m[0] = f;
            m30861f();
        }
    }

    public final void m30858d(float f) {
        if (!FloatUtil.m30999a(this.f22780a.f22814m[2], f)) {
            this.f22780a.f22814m[2] = f;
            m30861f();
        }
    }

    public final float m30863k() {
        return this.f22780a.f22815n[0];
    }

    public void m30860e(float f) {
        if (!FloatUtil.m30999a(this.f22780a.f22815n[0], f)) {
            this.f22780a.f22815n[0] = f;
            m30861f();
        }
    }

    public final float m30864l() {
        return this.f22780a.f22815n[1];
    }

    public void m30862f(float f) {
        if (!FloatUtil.m30999a(this.f22780a.f22815n[1], f)) {
            this.f22780a.f22815n[1] = f;
            m30861f();
        }
    }

    public final float m30865m() {
        return this.f22781b.f22825a[0];
    }

    public final float m30866n() {
        return this.f22781b.f22825a[1];
    }

    public final float m30867o() {
        return this.f22781b.f22826b[0];
    }

    public final float m30868p() {
        return this.f22781b.f22826b[1];
    }

    public final CSSDirection m30869q() {
        return this.f22781b.f22827c;
    }

    public final void m30859d(int i, float f) {
        if (this.f22780a.f22812k.m30947b(i, f)) {
            m30861f();
        }
    }

    public final void m30870r() {
        if (this.f22787h != null || (this.f22786g != null && this.f22786g.size() > 0)) {
            throw new IllegalStateException("You should not reset an attached CSSNode");
        }
        this.f22780a.m30940a();
        this.f22781b.m30948a();
        this.f22783d = 0;
        this.f22789j = LayoutState.DIRTY;
    }
}
