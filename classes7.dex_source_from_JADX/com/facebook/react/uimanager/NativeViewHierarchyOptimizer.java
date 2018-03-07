package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import javax.annotation.Nullable;

/* compiled from: friend_finder_how_many_seen */
public class NativeViewHierarchyOptimizer {
    private final UIViewOperationQueue f11746a;
    private final ShadowNodeRegistry f11747b;
    private final SparseBooleanArray f11748c = new SparseBooleanArray();

    public NativeViewHierarchyOptimizer(UIViewOperationQueue uIViewOperationQueue, ShadowNodeRegistry shadowNodeRegistry) {
        this.f11746a = uIViewOperationQueue;
        this.f11747b = shadowNodeRegistry;
    }

    public final void m13902a(ReactShadowNode reactShadowNode, ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        boolean z = reactShadowNode.m13853u().equals("RCTView") && m13894a(reactStylesDiffMap);
        reactShadowNode.m13842a(z);
        if (!z) {
            this.f11746a.m14081a(themedReactContext, reactShadowNode.f11717g, reactShadowNode.m13853u(), reactStylesDiffMap);
        }
    }

    public static void m13889a(ReactShadowNode reactShadowNode) {
        reactShadowNode.m13826G();
    }

    public final void m13904a(ReactShadowNode reactShadowNode, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        int i = 0;
        for (int i2 : iArr) {
            boolean z;
            for (int i3 : iArr2) {
                if (i3 == i2) {
                    z = true;
                    break;
                }
            }
            z = false;
            m13893a(this.f11747b.m13970c(i2), z);
        }
        while (i < viewAtIndexArr.length) {
            ViewAtIndex viewAtIndex = viewAtIndexArr[i];
            m13891a(reactShadowNode, this.f11747b.m13970c(viewAtIndex.f11860b), viewAtIndex.f11861c);
            i++;
        }
    }

    public final void m13901a(ReactShadowNode reactShadowNode, ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            m13891a(reactShadowNode, this.f11747b.m13970c(readableArray.getInt(i)), i);
        }
    }

    public final void m13905b(ReactShadowNode reactShadowNode) {
        m13896c(reactShadowNode);
    }

    private void m13896c(ReactShadowNode reactShadowNode) {
        int i = reactShadowNode.f11717g;
        if (!this.f11748c.get(i)) {
            this.f11748c.put(i, true);
            ReactShadowNode D = reactShadowNode.m13823D();
            int K = reactShadowNode.m13830K();
            i = reactShadowNode.m13831L();
            while (D != null && D.f11723m) {
                K += Math.round(D.m());
                i += Math.round(D.n());
                D = D.m13823D();
            }
            m13890a(reactShadowNode, K, i);
        }
    }

    public final void m13900a() {
        this.f11748c.clear();
    }

    private void m13891a(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        int c = reactShadowNode.m13845c(reactShadowNode.m13848e(i));
        boolean z = reactShadowNode.f11723m;
        boolean z2 = reactShadowNode2.f11723m;
        if (!z && !z2) {
            m13899e(reactShadowNode, reactShadowNode2, c);
        } else if (!z2) {
            m13897c(reactShadowNode, reactShadowNode2, c);
        } else if (z) {
            m13895b(reactShadowNode, reactShadowNode2, c);
        } else {
            m13898d(reactShadowNode, reactShadowNode2, c);
        }
    }

    private void m13893a(ReactShadowNode reactShadowNode, boolean z) {
        ReactShadowNode reactShadowNode2 = reactShadowNode.f11725o;
        if (reactShadowNode2 != null) {
            reactShadowNode2.m13849f(reactShadowNode2.m13843b(reactShadowNode));
            this.f11746a.m14079a(reactShadowNode2.f11717g, new int[]{reactShadowNode2.m13843b(reactShadowNode)}, null, z ? new int[]{reactShadowNode.f11717g} : null);
            return;
        }
        for (int a = reactShadowNode.a() - 1; a >= 0; a--) {
            m13893a(reactShadowNode.m13848e(a), z);
        }
    }

    private void m13895b(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        ReactShadowNode D = reactShadowNode.m13823D();
        if (D != null) {
            int c = D.m13845c(reactShadowNode) + i;
            if (D.f11723m) {
                m13895b(D, reactShadowNode2, c);
            } else {
                m13898d(D, reactShadowNode2, c);
            }
        }
    }

    private void m13897c(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        ReactShadowNode D = reactShadowNode.m13823D();
        if (D != null) {
            int c = D.m13845c(reactShadowNode) + i;
            if (D.f11723m) {
                m13897c(D, reactShadowNode2, c);
            } else {
                m13899e(D, reactShadowNode2, c);
            }
        }
    }

    private void m13898d(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        for (int i2 = 0; i2 < reactShadowNode2.a(); i2++) {
            boolean z;
            ReactShadowNode e = reactShadowNode2.m13848e(i2);
            if (e.f11725o == null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.a(z);
            if (e.f11723m) {
                int H = reactShadowNode.m13827H();
                m13898d(reactShadowNode, e, i);
                i += reactShadowNode.m13827H() - H;
            } else {
                m13899e(reactShadowNode, e, i);
                i++;
            }
        }
    }

    private void m13890a(ReactShadowNode reactShadowNode, int i, int i2) {
        if (reactShadowNode.f11723m || reactShadowNode.f11725o == null) {
            for (int i3 = 0; i3 < reactShadowNode.a(); i3++) {
                ReactShadowNode e = reactShadowNode.m13848e(i3);
                int i4 = e.f11717g;
                if (!this.f11748c.get(i4)) {
                    this.f11748c.put(i4, true);
                    m13890a(e, e.m13830K() + i, e.m13831L() + i2);
                }
            }
            return;
        }
        this.f11746a.m14071a(reactShadowNode.f11725o.f11717g, reactShadowNode.f11717g, i, i2, reactShadowNode.m13832M(), reactShadowNode.m13833N());
    }

    public final void m13903a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        Object obj;
        if (!reactShadowNode.f11723m || m13894a(reactStylesDiffMap)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m13892a(reactShadowNode, reactStylesDiffMap);
        } else if (!reactShadowNode.f11723m) {
            this.f11746a.m14076a(reactShadowNode.f11717g, reactStylesDiffMap);
        }
    }

    private void m13899e(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        reactShadowNode.m13837a(reactShadowNode2, i);
        this.f11746a.m14079a(reactShadowNode.f11717g, null, new ViewAtIndex[]{new ViewAtIndex(reactShadowNode2.f11717g, i)}, null);
    }

    private void m13892a(ReactShadowNode reactShadowNode, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        int i = 0;
        ReactShadowNode D = reactShadowNode.m13823D();
        if (D == null) {
            reactShadowNode.m13842a(false);
            return;
        }
        boolean z;
        int a = D.a(reactShadowNode);
        D.m13846c(a);
        m13893a(reactShadowNode, false);
        reactShadowNode.m13842a(false);
        this.f11746a.m14081a(reactShadowNode.m13822C().m13824E(), reactShadowNode.f11717g, reactShadowNode.m13853u(), reactStylesDiffMap);
        D.a(reactShadowNode, a);
        m13891a(D, reactShadowNode, a);
        for (int i2 = 0; i2 < reactShadowNode.a(); i2++) {
            m13891a(reactShadowNode, reactShadowNode.m13848e(i2), i2);
        }
        if (this.f11748c.size() == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.a(z);
        m13896c(reactShadowNode);
        while (i < reactShadowNode.a()) {
            m13896c(reactShadowNode.m13848e(i));
            i++;
        }
        this.f11748c.clear();
    }

    private static boolean m13894a(@Nullable ReactStylesDiffMap reactStylesDiffMap) {
        if (reactStylesDiffMap == null) {
            return true;
        }
        if (reactStylesDiffMap.m13942a("collapsable") && !reactStylesDiffMap.m13943a("collapsable", true)) {
            return false;
        }
        ReadableMapKeySetIterator a = reactStylesDiffMap.f11766a.mo679a();
        while (a.hasNextKey()) {
            if (!ViewProps.m14122a(a.nextKey())) {
                return false;
            }
        }
        return true;
    }
}
