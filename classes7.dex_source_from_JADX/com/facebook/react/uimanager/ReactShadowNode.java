package com.facebook.react.uimanager;

import com.facebook.csslayout.CSSNode;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import java.util.ArrayList;
import javax.annotation.Nullable;

@ReactPropertyHolder
/* compiled from: friend_finder_legal_get_started */
public class ReactShadowNode extends CSSNode {
    public int f11717g;
    @Nullable
    public String f11718h;
    @Nullable
    public ReactShadowNode f11719i;
    @Nullable
    private ThemedReactContext f11720j;
    public boolean f11721k;
    private boolean f11722l = true;
    public boolean f11723m;
    public int f11724n = 0;
    @Nullable
    public ReactShadowNode f11725o;
    @Nullable
    private ArrayList<ReactShadowNode> f11726p;
    private float f11727q;
    private float f11728r;
    private float f11729s;
    private float f11730t;

    public final /* synthetic */ CSSNode a_(int i) {
        return m13848e(i);
    }

    @Nullable
    public final /* synthetic */ CSSNode m13844b() {
        return m13823D();
    }

    public final /* synthetic */ CSSNode b_(int i) {
        return m13846c(i);
    }

    public boolean m13851s() {
        return false;
    }

    public boolean m13852t() {
        return false;
    }

    public final String m13853u() {
        return (String) Assertions.b(this.f11718h);
    }

    public final boolean m13854v() {
        return this.f11722l || g_() || f_();
    }

    public final void m13855w() {
        this.f11722l = false;
        if (g_()) {
            i_();
        }
    }

    protected void m13856x() {
        if (!this.f11722l) {
            this.f11722l = true;
            ReactShadowNode D = m13823D();
            if (D != null) {
                D.m13856x();
            }
        }
    }

    public final boolean m13857y() {
        return this.f11722l;
    }

    protected final void m13850f() {
        if (!m13851s()) {
            super.f();
        }
    }

    public void m13835a(CSSNode cSSNode, int i) {
        super.a(cSSNode, i);
        m13856x();
        ReactShadowNode reactShadowNode = (ReactShadowNode) cSSNode;
        int i2 = reactShadowNode.f11723m ? reactShadowNode.f11724n : 1;
        this.f11724n += i2;
        m13819g(i2);
    }

    public final ReactShadowNode m13846c(int i) {
        ReactShadowNode reactShadowNode = (ReactShadowNode) super.b_(i);
        m13856x();
        int i2 = reactShadowNode.f11723m ? reactShadowNode.f11724n : 1;
        this.f11724n -= i2;
        m13819g(-i2);
        return reactShadowNode;
    }

    public final void m13858z() {
        int i = 0;
        for (int a = a() - 1; a >= 0; a--) {
            ReactShadowNode reactShadowNode = (ReactShadowNode) super.b_(a);
            i += reactShadowNode.f11723m ? reactShadowNode.f11724n : 1;
        }
        m13856x();
        this.f11724n -= i;
        m13819g(-i);
    }

    private void m13819g(int i) {
        if (this.f11723m) {
            ReactShadowNode D = m13823D();
            while (D != null) {
                D.f11724n += i;
                if (D.f11723m) {
                    D = D.m13823D();
                } else {
                    return;
                }
            }
        }
    }

    public void m13820A() {
    }

    public final void m13838a(ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.m14097a(this, reactStylesDiffMap);
    }

    public void m13840a(UIViewOperationQueue uIViewOperationQueue) {
    }

    final void m13834a(float f, float f2, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.f11722l) {
            m13840a(uIViewOperationQueue);
        }
        if (g_()) {
            this.f11727q = (float) Math.round(m() + f);
            this.f11728r = (float) Math.round(n() + f2);
            this.f11729s = (float) Math.round((m() + f) + o());
            this.f11730t = (float) Math.round((n() + f2) + p());
            nativeViewHierarchyOptimizer.m13905b(this);
        }
    }

    public final int m13821B() {
        return this.f11717g;
    }

    final void m13847d(int i) {
        this.f11717g = i;
    }

    public final ReactShadowNode m13822C() {
        return (ReactShadowNode) Assertions.b(this.f11719i);
    }

    final void m13836a(ReactShadowNode reactShadowNode) {
        this.f11719i = reactShadowNode;
    }

    final void m13841a(String str) {
        this.f11718h = str;
    }

    public final ReactShadowNode m13848e(int i) {
        return (ReactShadowNode) super.a_(i);
    }

    @Nullable
    public final ReactShadowNode m13823D() {
        return (ReactShadowNode) super.b();
    }

    public final ThemedReactContext m13824E() {
        return (ThemedReactContext) Assertions.b(this.f11720j);
    }

    public void m13839a(ThemedReactContext themedReactContext) {
        this.f11720j = themedReactContext;
    }

    public void setShouldNotifyOnLayout(boolean z) {
        this.f11721k = z;
    }

    public final boolean m13825F() {
        return this.f11721k;
    }

    public final void m13837a(ReactShadowNode reactShadowNode, int i) {
        boolean z = true;
        Assertions.a(!this.f11723m);
        if (reactShadowNode.f11723m) {
            z = false;
        }
        Assertions.a(z);
        if (this.f11726p == null) {
            this.f11726p = new ArrayList(4);
        }
        this.f11726p.add(i, reactShadowNode);
        reactShadowNode.f11725o = this;
    }

    public final ReactShadowNode m13849f(int i) {
        Assertions.b(this.f11726p);
        ReactShadowNode reactShadowNode = (ReactShadowNode) this.f11726p.remove(i);
        reactShadowNode.f11725o = null;
        return reactShadowNode;
    }

    public final void m13826G() {
        if (this.f11726p != null) {
            for (int size = this.f11726p.size() - 1; size >= 0; size--) {
                ((ReactShadowNode) this.f11726p.get(size)).f11725o = null;
            }
            this.f11726p.clear();
        }
    }

    public final int m13827H() {
        return this.f11726p == null ? 0 : this.f11726p.size();
    }

    public final int m13843b(ReactShadowNode reactShadowNode) {
        Assertions.b(this.f11726p);
        return this.f11726p.indexOf(reactShadowNode);
    }

    @Nullable
    public final ReactShadowNode m13828I() {
        return this.f11725o;
    }

    public final void m13842a(boolean z) {
        boolean z2;
        boolean z3 = true;
        if (m13823D() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2, "Must remove from no opt parent first");
        if (this.f11725o == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2, "Must remove from native parent first");
        if (m13827H() != 0) {
            z3 = false;
        }
        Assertions.a(z3, "Must remove all native children first");
        this.f11723m = z;
    }

    public final boolean m13829J() {
        return this.f11723m;
    }

    private int m13818O() {
        return this.f11724n;
    }

    public final int m13845c(ReactShadowNode reactShadowNode) {
        Object obj = 1;
        int i = 0;
        for (int i2 = 0; i2 < a(); i2++) {
            ReactShadowNode e = m13848e(i2);
            if (reactShadowNode == e) {
                break;
            }
            int i3;
            if (e.f11723m) {
                i3 = e.f11724n;
            } else {
                i3 = 1;
            }
            i += i3;
        }
        obj = null;
        if (obj != null) {
            return i;
        }
        throw new RuntimeException("Child " + reactShadowNode.f11717g + " was not a child of " + this.f11717g);
    }

    public int m13830K() {
        return Math.round(m());
    }

    public int m13831L() {
        return Math.round(n());
    }

    public int m13832M() {
        return Math.round(this.f11729s - this.f11727q);
    }

    public int m13833N() {
        return Math.round(this.f11730t - this.f11728r);
    }
}
