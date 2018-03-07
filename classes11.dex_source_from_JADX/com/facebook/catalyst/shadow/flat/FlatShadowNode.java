package com.facebook.catalyst.shadow.flat;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.OnLayoutEvent;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: look_now_story */
public class FlatShadowNode extends LayoutShadowNode {
    static final FlatShadowNode[] f5664g = new FlatShadowNode[0];
    private boolean f5665A;
    private int f5666B;
    private int f5667C;
    private int f5668D;
    private int f5669E;
    private DrawCommand[] f5670h = DrawCommand.f5606b;
    private AttachDetachListener[] f5671i = AttachDetachListener.f5623a;
    private NodeRegion[] f5672j = NodeRegion.f5771a;
    public FlatShadowNode[] f5673k = f5664g;
    public NodeRegion f5674l = NodeRegion.f5772b;
    public int f5675m;
    public int f5676n;
    public int f5677o;
    public int f5678p;
    public int f5679q;
    public boolean f5680r;
    @Nullable
    private DrawView f5681s;
    @Nullable
    private DrawBackgroundColor f5682t;
    private boolean f5683u = false;
    private boolean f5684v = true;
    private float f5685w;
    private float f5686x;
    private float f5687y;
    private float f5688z;

    FlatShadowNode() {
    }

    void mo161b(ReactStylesDiffMap reactStylesDiffMap) {
        if (!af()) {
            if (reactStylesDiffMap.a("decomposedMatrix") || reactStylesDiffMap.a("opacity") || reactStylesDiffMap.a("renderToHardwareTextureAndroid") || reactStylesDiffMap.a("testID") || reactStylesDiffMap.a("accessibilityLabel") || reactStylesDiffMap.a("accessibilityComponentType") || reactStylesDiffMap.a("accessibilityLiveRegion") || reactStylesDiffMap.a("transform") || reactStylesDiffMap.a("importantForAccessibility") || reactStylesDiffMap.a("removeClippedSubviews")) {
                ae();
            }
        }
    }

    protected void mo166a(StateBuilder stateBuilder, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (this.f5682t != null) {
            this.f5682t = (DrawBackgroundColor) this.f5682t.m6924a(f, f2, f3, f4, f5, f6, f7, f8);
            stateBuilder.m7235a(this.f5682t);
        }
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(int i) {
        this.f5682t = i == 0 ? null : new DrawBackgroundColor(i);
        m6988P();
    }

    @ReactProp(name = "overflow")
    public final void setOverflow(String str) {
        this.f5683u = "hidden".equals(str);
        if (this.f5683u) {
            this.f5665A = false;
        } else {
            m6996X();
        }
        m6988P();
    }

    public final boolean m6987O() {
        return this.f5683u;
    }

    public final int m6983K() {
        return this.f5676n;
    }

    public final int m6984L() {
        return this.f5677o;
    }

    public final int m6985M() {
        return this.f5678p - this.f5676n;
    }

    public final int m6986N() {
        return this.f5679q - this.f5677o;
    }

    protected final void m6988P() {
        while (true) {
            if (af()) {
                if (!this.f5684v) {
                    this.f5684v = true;
                } else {
                    return;
                }
            }
            ReactShadowNode D = D();
            if (D != null) {
                this = (FlatShadowNode) D;
            } else {
                return;
            }
        }
    }

    final boolean m6989Q() {
        return this.f5684v;
    }

    final void m6990R() {
        this.f5684v = false;
    }

    final boolean m7007a(float f, float f2, float f3, float f4) {
        return (this.f5685w == f && this.f5686x == f2 && this.f5687y == f3 && this.f5688z == f4) ? false : true;
    }

    final void m7009b(float f, float f2, float f3, float f4) {
        this.f5685w = f;
        this.f5686x = f2;
        this.f5687y = f3;
        this.f5688z = f4;
    }

    final DrawCommand[] m6991S() {
        return this.f5670h;
    }

    final void m7004a(DrawCommand[] drawCommandArr) {
        this.f5670h = drawCommandArr;
    }

    final void m7003a(AttachDetachListener[] attachDetachListenerArr) {
        this.f5671i = attachDetachListenerArr;
    }

    final AttachDetachListener[] m6992T() {
        return this.f5671i;
    }

    final FlatShadowNode[] m6993U() {
        return this.f5673k;
    }

    final void m7005a(FlatShadowNode[] flatShadowNodeArr) {
        this.f5673k = flatShadowNodeArr;
    }

    final int m6994V() {
        return this.f5675m;
    }

    final void m7012g(int i) {
        this.f5675m = i;
    }

    final NodeRegion[] m6995W() {
        return this.f5672j;
    }

    final void m7006a(NodeRegion[] nodeRegionArr) {
        this.f5672j = nodeRegionArr;
        m6996X();
    }

    final void m6996X() {
        boolean z;
        boolean z2;
        int i = (int) (this.f5674l.f5775e - this.f5674l.f5773c);
        int i2 = (int) (this.f5674l.f5776f - this.f5674l.f5774d);
        if (!this.f5683u && i2 > 0 && i > 0) {
            for (NodeRegion nodeRegion : this.f5672j) {
                if (nodeRegion.f5776f - nodeRegion.f5774d > ((float) i2) || nodeRegion.f5775e - nodeRegion.f5773c > ((float) i)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            i2 = a();
            for (i = 0; i < i2; i++) {
                ReactShadowNode e = e(i);
                if ((e instanceof FlatShadowNode) && ((FlatShadowNode) e).f5665A) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = z;
        if (this.f5665A != z2) {
            this.f5665A = z2;
        }
    }

    final boolean m6997Y() {
        return this.f5665A;
    }

    void mo170a(float f, float f2, float f3, float f4, boolean z) {
        if (this.f5674l.f5773c != f || this.f5674l.f5774d != f2 || this.f5674l.f5775e != f3 || this.f5674l.f5776f != f4 || this.f5674l.f5778h != z) {
            this.f5674l = new NodeRegion(f, f2, f3, f4, this.g, z);
        }
    }

    protected final void m7001a(NodeRegion nodeRegion) {
        this.f5674l = nodeRegion;
    }

    final NodeRegion m6998Z() {
        return this.f5674l;
    }

    final void m7000a(int i, int i2, int i3, int i4) {
        this.f5676n = i;
        this.f5677o = i2;
        this.f5678p = i3;
        this.f5679q = i4;
    }

    final int aa() {
        return this.f5676n;
    }

    final int ab() {
        return this.f5677o;
    }

    final int ac() {
        return this.f5678p;
    }

    final int ad() {
        return this.f5679q;
    }

    public final void ae() {
        if (!s() && this.f5681s == null) {
            this.f5681s = new DrawView(this.g, 0.0f, 0.0f, 0.0f, 0.0f);
            m6988P();
            this.f5674l = NodeRegion.f5772b;
        }
    }

    final DrawView m7011c(float f, float f2, float f3, float f4) {
        if (!this.f5681s.m6920a(f, f2, f3, f4)) {
            this.f5681s = new DrawView(this.g, f, f2, f3, f4);
        }
        return this.f5681s;
    }

    @Nullable
    final OnLayoutEvent m7008b(int i, int i2, int i3, int i4) {
        if (this.f5666B == i && this.f5667C == i2 && this.f5668D == i3 && this.f5669E == i4) {
            return null;
        }
        this.f5666B = i;
        this.f5667C = i2;
        this.f5668D = i3;
        this.f5669E = i4;
        return OnLayoutEvent.a(this.g, i, i2, i3, i4);
    }

    final boolean af() {
        return this.f5681s != null;
    }

    final boolean ag() {
        return this.f5680r;
    }

    public final void ah() {
        this.f5680r = true;
    }
}
