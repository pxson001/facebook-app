package com.facebook.catalyst.shadow.flat;

import com.facebook.catalyst.shadow.flat.FlatUIViewOperationQueue.DetachAllChildrenFromViews;
import com.facebook.catalyst.shadow.flat.FlatUIViewOperationQueue.UpdateViewBounds;
import com.facebook.csslayout.Spacing;
import com.facebook.react.uimanager.OnLayoutEvent;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: lightweight_place_picker_first_scroll */
public final class StateBuilder {
    private static final int[] f5813a = new int[0];
    public final FlatUIViewOperationQueue f5814b;
    private final ElementsList<DrawCommand> f5815c = new ElementsList(DrawCommand.f5606b);
    private final ElementsList<AttachDetachListener> f5816d = new ElementsList(AttachDetachListener.f5623a);
    private final ElementsList<NodeRegion> f5817e = new ElementsList(NodeRegion.f5771a);
    private final ElementsList<FlatShadowNode> f5818f = new ElementsList(FlatShadowNode.f5664g);
    private final ArrayList<FlatShadowNode> f5819g = new ArrayList();
    private final ArrayList<FlatShadowNode> f5820h = new ArrayList();
    public final ArrayList<FlatShadowNode> f5821i = new ArrayList();
    public final ArrayList<FlatShadowNode> f5822j = new ArrayList();
    public final ArrayList<ReactStylesDiffMap> f5823k = new ArrayList();
    private final ArrayList<OnLayoutEvent> f5824l = new ArrayList();
    private final ArrayList<UpdateViewBounds> f5825m = new ArrayList();
    @Nullable
    private DetachAllChildrenFromViews f5826n;

    StateBuilder(FlatUIViewOperationQueue flatUIViewOperationQueue) {
        this.f5814b = flatUIViewOperationQueue;
    }

    final void m7237a(FlatShadowNode flatShadowNode) {
        float o = flatShadowNode.o();
        float p = flatShadowNode.p();
        float m = flatShadowNode.m();
        float n = flatShadowNode.n();
        float f = m + o;
        float f2 = n + p;
        m7230a(flatShadowNode, m, n, f, f2, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        m7226a(flatShadowNode, m, n, f, f2);
    }

    final void m7239a(EventDispatcher eventDispatcher) {
        int i;
        int i2 = 0;
        if (this.f5826n != null) {
            int[] a = m7233a(this.f5819g);
            this.f5819g.clear();
            this.f5826n.f5695b = a;
            this.f5826n = null;
        }
        int size = this.f5825m.size();
        for (i = 0; i != size; i++) {
            this.f5814b.a((UpdateViewBounds) this.f5825m.get(i));
        }
        this.f5825m.clear();
        i = this.f5824l.size();
        while (i2 != i) {
            eventDispatcher.a((Event) this.f5824l.get(i2));
            i2++;
        }
        this.f5824l.clear();
        if (!this.f5821i.isEmpty()) {
            this.f5814b.m7063a(m7233a(this.f5821i));
            this.f5821i.clear();
        }
        this.f5814b.m7065e();
    }

    final void m7235a(AbstractDrawCommand abstractDrawCommand) {
        this.f5815c.m6969a((Object) abstractDrawCommand);
    }

    final void m7236a(AttachDetachListener attachDetachListener) {
        this.f5816d.m6969a((Object) attachDetachListener);
    }

    final void m7238a(FlatShadowNode flatShadowNode, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        this.f5822j.add(flatShadowNode);
        this.f5823k.add(reactStylesDiffMap);
    }

    private void m7227a(FlatShadowNode flatShadowNode, float f, float f2, float f3, float f4, boolean z) {
        if (f != f3 && f2 != f4) {
            flatShadowNode.mo170a(f, f2, f3, f4, z);
            this.f5817e.m6969a((Object) flatShadowNode.f5674l);
        }
    }

    private void m7234d(FlatShadowNode flatShadowNode) {
        this.f5818f.m6969a((Object) flatShadowNode);
    }

    private void m7226a(FlatShadowNode flatShadowNode, float f, float f2, float f3, float f4) {
        int round = Math.round(f);
        int round2 = Math.round(f2);
        int round3 = Math.round(f3);
        int round4 = Math.round(f4);
        if (flatShadowNode.f5676n != round || flatShadowNode.f5677o != round2 || flatShadowNode.f5678p != round3 || flatShadowNode.f5679q != round4) {
            flatShadowNode.m7000a(round, round2, round3, round4);
            this.f5825m.add(this.f5814b.m7058a(flatShadowNode.g, round, round2, round3, round4));
        }
    }

    private boolean m7230a(FlatShadowNode flatShadowNode, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        Object obj = (flatShadowNode.g_() || flatShadowNode.m6989Q() || flatShadowNode.m7007a(f5, f6, f7, f8)) ? 1 : null;
        if (obj == null) {
            return false;
        }
        float f9;
        float f10;
        float f11;
        Object obj2;
        flatShadowNode.m7009b(f5, f6, f7, f8);
        this.f5815c.m6970a(flatShadowNode.m6991S());
        this.f5816d.m6970a(flatShadowNode.m6992T());
        this.f5817e.m6970a(flatShadowNode.m6995W());
        this.f5818f.m6970a(flatShadowNode.m6993U());
        boolean z = false;
        boolean z2 = false;
        if (flatShadowNode instanceof AndroidView) {
            AndroidView androidView = (AndroidView) flatShadowNode;
            m7225a(androidView, flatShadowNode.B());
            z = true;
            z2 = androidView.nZ_();
            f5 = Float.NEGATIVE_INFINITY;
            f9 = Float.NEGATIVE_INFINITY;
            f10 = Float.POSITIVE_INFINITY;
            f11 = Float.POSITIVE_INFINITY;
        } else {
            f11 = f8;
            f10 = f7;
            f9 = f6;
        }
        if (!z && flatShadowNode.t()) {
            m7227a(flatShadowNode, f, f2, f3, f4, true);
        }
        boolean a = m7231a(flatShadowNode, f, f2, f3, f4, f5, f9, f10, f11, z, z2);
        obj = null;
        DrawCommand[] drawCommandArr = (DrawCommand[]) this.f5815c.m6971a();
        if (drawCommandArr != null) {
            obj = 1;
            flatShadowNode.m7004a(drawCommandArr);
        }
        AttachDetachListener[] attachDetachListenerArr = (AttachDetachListener[]) this.f5816d.m6971a();
        if (attachDetachListenerArr != null) {
            obj = 1;
            flatShadowNode.m7003a(attachDetachListenerArr);
        }
        NodeRegion[] nodeRegionArr = (NodeRegion[]) this.f5817e.m6971a();
        if (nodeRegionArr != null) {
            flatShadowNode.m7006a(nodeRegionArr);
            obj2 = 1;
        } else {
            if (a) {
                flatShadowNode.m6996X();
            }
            obj2 = obj;
        }
        if (obj2 != null) {
            this.f5814b.m7061a(flatShadowNode.B(), drawCommandArr, attachDetachListenerArr, nodeRegionArr, flatShadowNode.m6997Y());
        }
        if (flatShadowNode.y()) {
            flatShadowNode.a(this.f5814b);
            flatShadowNode.w();
        }
        FlatShadowNode[] flatShadowNodeArr = (FlatShadowNode[]) this.f5818f.m6971a();
        if (flatShadowNodeArr != null) {
            m7228a(flatShadowNode, flatShadowNode.m6993U(), flatShadowNodeArr);
        }
        if (obj2 == null && flatShadowNodeArr == null && !a) {
            return false;
        }
        return true;
    }

    private void m7228a(FlatShadowNode flatShadowNode, FlatShadowNode[] flatShadowNodeArr, FlatShadowNode[] flatShadowNodeArr2) {
        int[] iArr;
        int i;
        int i2 = 0;
        flatShadowNode.f5673k = flatShadowNodeArr2;
        if (this.f5826n == null) {
            this.f5826n = this.f5814b.m7066f();
        }
        if (flatShadowNodeArr.length != 0) {
            this.f5819g.add(flatShadowNode);
        }
        int i3 = flatShadowNode.g;
        int length = flatShadowNodeArr2.length;
        if (length == 0) {
            iArr = f5813a;
        } else {
            iArr = new int[length];
            i = 0;
            for (FlatShadowNode flatShadowNode2 : flatShadowNodeArr2) {
                if (flatShadowNode2.f5675m == i3) {
                    iArr[i] = -flatShadowNode2.g;
                } else {
                    iArr[i] = flatShadowNode2.g;
                }
                flatShadowNode2.f5675m = -1;
                i++;
            }
        }
        for (FlatShadowNode flatShadowNode3 : flatShadowNodeArr) {
            if (flatShadowNode3.f5675m == i3) {
                this.f5820h.add(flatShadowNode3);
                flatShadowNode3.f5675m = -1;
            }
        }
        int[] a = m7233a(this.f5820h);
        this.f5820h.clear();
        i = flatShadowNodeArr2.length;
        while (i2 < i) {
            flatShadowNodeArr2[i2].f5675m = i3;
            i2++;
        }
        this.f5814b.m7060a(i3, iArr, a);
    }

    final void m7240b(FlatShadowNode flatShadowNode) {
        if (!flatShadowNode.f5680r) {
            this.f5814b.a(flatShadowNode.E(), flatShadowNode.g, flatShadowNode.u(), null);
            flatShadowNode.ah();
        }
    }

    private boolean m7231a(FlatShadowNode flatShadowNode, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
        float min;
        if (flatShadowNode.g_()) {
            flatShadowNode.i_();
        }
        float a = m7224a(f);
        float a2 = m7224a(f2);
        float a3 = m7224a(f3);
        float a4 = m7224a(f4);
        if (flatShadowNode.F()) {
            OnLayoutEvent b = flatShadowNode.m7008b(Math.round(flatShadowNode.m()), Math.round(flatShadowNode.n()), (int) (a3 - a), (int) (a4 - a2));
            if (b != null) {
                this.f5824l.add(b);
            }
        }
        if (flatShadowNode.m6987O()) {
            f5 = Math.max(f, f5);
            f6 = Math.max(f2, f6);
            f7 = Math.min(f3, f7);
            min = Math.min(f4, f8);
        } else {
            min = f8;
        }
        flatShadowNode.mo166a(this, a, a2, a3, a4, m7224a(f5), m7224a(f6), m7224a(f7), min);
        int a5 = flatShadowNode.a();
        boolean z3 = false;
        for (int i = 0; i != a5; i++) {
            ReactShadowNode e = flatShadowNode.e(i);
            if (e.s()) {
                m7229a(e);
            } else {
                z3 |= m7232a((FlatShadowNode) e, f, f2, f5, f6, f7, min, z, z2);
            }
        }
        flatShadowNode.m6990R();
        return z3;
    }

    private void m7229a(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.g_()) {
            reactShadowNode.i_();
        }
        int a = reactShadowNode.a();
        for (int i = 0; i != a; i++) {
            m7229a(reactShadowNode.e(i));
        }
    }

    private boolean m7232a(FlatShadowNode flatShadowNode, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2) {
        float m = flatShadowNode.m() + f;
        float n = flatShadowNode.n() + f2;
        float o = m + flatShadowNode.o();
        float p = n + flatShadowNode.p();
        boolean af = flatShadowNode.af();
        if (!z) {
            m7227a(flatShadowNode, m, n, o, p, !af);
        }
        if (!af) {
            return m7231a(flatShadowNode, m, n, o, p, f3, f4, f5, f6, false, false);
        }
        m7240b(flatShadowNode);
        m7234d(flatShadowNode);
        if (!z) {
            this.f5815c.m6969a(flatShadowNode.m7011c(f3, f4, f5, f6));
        }
        boolean a = m7230a(flatShadowNode, m - m, n - n, o - m, p - n, f3 - m, f4 - n, f5 - m, f6 - n);
        if (z2) {
            return a;
        }
        m7226a(flatShadowNode, m, n, o, p);
        return a;
    }

    private void m7225a(AndroidView androidView, int i) {
        if (androidView.oa_()) {
            Spacing k_ = androidView.k_();
            this.f5814b.m7064b(i, Math.round(k_.a(0)), Math.round(k_.a(1)), Math.round(k_.a(2)), Math.round(k_.a(3)));
            androidView.mo162c();
        }
    }

    private static int[] m7233a(ArrayList<FlatShadowNode> arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return f5813a;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((FlatShadowNode) arrayList.get(i)).g;
        }
        return iArr;
    }

    private static float m7224a(float f) {
        return (float) Math.floor((double) (0.5f + f));
    }
}
