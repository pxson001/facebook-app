package com.facebook.catalyst.shadow.flat;

import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.image.ReactImageManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: look_now */
public class FlatUIImplementation extends UIImplementation {
    private final MoveProxy f5691a = new MoveProxy();
    private final StateBuilder f5692b;
    @Nullable
    private ReactImageManager f5693c;

    public static FlatUIImplementation m7022a(ReactApplicationContext reactApplicationContext, List<ViewManager> list) {
        ReactImageManager a = m7024a((List) list);
        if (a != null) {
            Object obj = a.f11440c;
            if (obj != null) {
                RCTImageView.f5784h = obj;
            }
        }
        DraweeRequestHelper.f5652a = new GenericDraweeHierarchyBuilder(reactApplicationContext.getResources());
        TypefaceCache.f5832e = reactApplicationContext.getAssets();
        List arrayList = new ArrayList(list);
        arrayList.add(new RCTViewManager());
        arrayList.add(new RCTTextManager());
        arrayList.add(new RCTRawTextManager());
        arrayList.add(new RCTVirtualTextManager());
        arrayList.add(new RCTTextInlineImageManager());
        arrayList.add(new RCTImageViewManager());
        arrayList.add(new RCTTextInputManager());
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(arrayList);
        return new FlatUIImplementation(a, viewManagerRegistry, new FlatUIViewOperationQueue(reactApplicationContext, new FlatNativeViewHierarchyManager(viewManagerRegistry)));
    }

    private FlatUIImplementation(@Nullable ReactImageManager reactImageManager, ViewManagerRegistry viewManagerRegistry, FlatUIViewOperationQueue flatUIViewOperationQueue) {
        super(viewManagerRegistry, flatUIViewOperationQueue);
        this.f5692b = new StateBuilder(flatUIViewOperationQueue);
        this.f5693c = reactImageManager;
    }

    protected final ReactShadowNode m7031a() {
        if (this.f5693c != null) {
            DraweeRequestHelper.f5653b = this.f5693c.m11851d();
            this.f5693c = null;
        }
        return new FlatRootShadowNode();
    }

    protected final ReactShadowNode m7032a(String str) {
        ReactShadowNode a = super.a(str);
        return ((a instanceof FlatShadowNode) || a.s()) ? a : new NativeViewWrapper(b(str));
    }

    protected final void m7041a(ReactShadowNode reactShadowNode, int i, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        if (reactShadowNode instanceof FlatShadowNode) {
            FlatShadowNode flatShadowNode = (FlatShadowNode) reactShadowNode;
            if (reactStylesDiffMap != null) {
                flatShadowNode.mo161b(reactStylesDiffMap);
            }
            if (flatShadowNode.af()) {
                this.f5692b.m7238a(flatShadowNode, reactStylesDiffMap);
                return;
            }
            return;
        }
        super.a(reactShadowNode, i, reactStylesDiffMap);
    }

    protected final void m7042a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        if (reactShadowNode instanceof FlatShadowNode) {
            FlatShadowNode flatShadowNode = (FlatShadowNode) reactShadowNode;
            flatShadowNode.mo161b(reactStylesDiffMap);
            if (flatShadowNode.af()) {
                this.f5692b.m7238a(flatShadowNode, reactStylesDiffMap);
                return;
            }
            return;
        }
        super.a(reactShadowNode, str, reactStylesDiffMap);
    }

    public final void m7038a(int i, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3, @Nullable ReadableArray readableArray4, @Nullable ReadableArray readableArray5) {
        ReactShadowNode a = a(i);
        m7027a(a, readableArray, readableArray2, readableArray5);
        m7026a(a, readableArray3, readableArray4);
    }

    public final void m7036a(int i, ReadableArray readableArray) {
        ReactShadowNode a = a(i);
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            m7028a(a, a(readableArray.getInt(i2)), i2, i2 - 1);
        }
    }

    public final void m7035a(int i, Callback callback) {
        ReactShadowNode reactShadowNode = (FlatShadowNode) a(i);
        if (reactShadowNode.af()) {
            this.f5692b.m7240b(reactShadowNode);
            super.a(i, callback);
            return;
        }
        float o = reactShadowNode.o();
        float p = reactShadowNode.p();
        float m = reactShadowNode.m();
        float n = reactShadowNode.n();
        while (true) {
            FlatShadowNode flatShadowNode = (FlatShadowNode) reactShadowNode.D();
            if (flatShadowNode.af()) {
                this.f5692b.m7240b(flatShadowNode);
                float o2 = flatShadowNode.o();
                float p2 = flatShadowNode.p();
                this.f5692b.f5814b.m7059a(flatShadowNode.g, m / o2, n / p2, o / o2, p / p2, callback);
                return;
            }
            m += flatShadowNode.m();
            n = flatShadowNode.n() + n;
            reactShadowNode = flatShadowNode;
        }
    }

    private void m7030d(int i) {
        FlatShadowNode flatShadowNode = (FlatShadowNode) a(i);
        flatShadowNode.ae();
        this.f5692b.m7240b(flatShadowNode);
    }

    public final void m7033a(int i, float f, float f2, Callback callback) {
        m7030d(i);
        super.a(i, f, f2, callback);
    }

    public final void m7046b(int i, Callback callback) {
        m7030d(i);
        super.b(i, callback);
    }

    public final void m7034a(int i, int i2, ReadableArray readableArray) {
        m7030d(i);
        super.a(i, i2, readableArray);
    }

    public final void m7037a(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        m7030d(i);
        super.a(i, readableArray, callback, callback2);
    }

    public final void m7045b(int i, int i2) {
        m7030d(i);
        super.b(i, i2);
    }

    private void m7027a(ReactShadowNode reactShadowNode, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3) {
        int i;
        int i2;
        int i3;
        this.f5691a.m7097a(readableArray, readableArray2);
        int i4 = this.f5691a.f5765b - 1;
        int b = i4 == -1 ? -1 : this.f5691a.m7098b(i4);
        if (readableArray3 == null) {
            i = -1;
            i2 = Integer.MAX_VALUE;
            i3 = i4;
            i4 = b;
            b = -1;
        } else {
            i = readableArray3.size() - 1;
            i2 = Integer.MAX_VALUE;
            i3 = i4;
            i4 = b;
            b = i;
            i = readableArray3.getInt(i);
        }
        while (true) {
            if (i4 > i) {
                m7025a(m7023a(reactShadowNode, i4, i2), i3);
                i3--;
                if (i3 == -1) {
                    i2 = -1;
                } else {
                    i2 = this.f5691a.m7098b(i3);
                }
                int i5 = i2;
                i2 = i4;
                i4 = i5;
            } else if (i > i4) {
                m7029b(m7023a(reactShadowNode, i, i2));
                b--;
                i2 = i;
                i = b == -1 ? -1 : readableArray3.getInt(b);
            } else {
                return;
            }
        }
    }

    private void m7029b(ReactShadowNode reactShadowNode) {
        if (reactShadowNode instanceof FlatShadowNode) {
            FlatShadowNode flatShadowNode = (FlatShadowNode) reactShadowNode;
            if (flatShadowNode.af() && flatShadowNode.f5680r) {
                this.f5692b.f5821i.add(flatShadowNode);
                a(flatShadowNode);
                return;
            }
        }
        int a = reactShadowNode.a();
        for (int i = 0; i != a; i++) {
            m7029b(reactShadowNode.e(i));
        }
        a(reactShadowNode);
    }

    private void m7025a(ReactShadowNode reactShadowNode, int i) {
        this.f5691a.m7096a(i, reactShadowNode);
    }

    private void m7026a(ReactShadowNode reactShadowNode, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (this.f5691a.f5765b == 0) {
            i = Integer.MAX_VALUE;
            i2 = Integer.MAX_VALUE;
        } else {
            i = this.f5691a.m7099c(0);
            i2 = 0;
        }
        if (readableArray2 == null) {
            i3 = Integer.MAX_VALUE;
            i4 = -1;
            i5 = i2;
            i2 = i;
            i = 0;
            i6 = Integer.MAX_VALUE;
        } else {
            i4 = readableArray2.size();
            i3 = readableArray2.getInt(0);
            int i7 = i4;
            i4 = -1;
            i5 = i2;
            i2 = i;
            i = i7;
        }
        while (true) {
            if (i3 < i2) {
                m7028a(reactShadowNode, a(readableArray.getInt(i6)), i3, i4);
                i4 = i6 + 1;
                if (i4 == i) {
                    i6 = i4;
                    i4 = i3;
                    i3 = Integer.MAX_VALUE;
                } else {
                    i7 = readableArray2.getInt(i4);
                    i6 = i4;
                    i4 = i3;
                    i3 = i7;
                }
            } else if (i2 < i3) {
                m7028a(reactShadowNode, this.f5691a.f5767d[i5], i2, i4);
                i5++;
                if (i5 == this.f5691a.f5765b) {
                    i4 = i2;
                    i2 = Integer.MAX_VALUE;
                } else {
                    i4 = i2;
                    i2 = this.f5691a.m7099c(i5);
                }
            } else {
                return;
            }
        }
    }

    private static ReactShadowNode m7023a(ReactShadowNode reactShadowNode, int i, int i2) {
        if (i < i2) {
            return reactShadowNode.c(i);
        }
        throw new RuntimeException("Invariant failure, needs sorting! " + i + " >= " + i2);
    }

    private static void m7028a(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i, int i2) {
        if (i <= i2) {
            throw new RuntimeException("Invariant failure, needs sorting! " + i + " <= " + i2);
        }
        reactShadowNode.a(reactShadowNode2, i);
    }

    protected final void m7043a(EventDispatcher eventDispatcher) {
        StateBuilder stateBuilder = this.f5692b;
        int size = stateBuilder.f5822j.size();
        for (int i = 0; i != size; i++) {
            FlatShadowNode flatShadowNode = (FlatShadowNode) stateBuilder.f5822j.get(i);
            if (flatShadowNode.D() != null) {
                if (flatShadowNode.f5680r) {
                    FlatUIViewOperationQueue flatUIViewOperationQueue = stateBuilder.f5814b;
                    int i2 = flatShadowNode.g;
                    flatShadowNode.u();
                    flatUIViewOperationQueue.a(i2, (ReactStylesDiffMap) stateBuilder.f5823k.get(i));
                } else {
                    stateBuilder.f5814b.a(flatShadowNode.E(), flatShadowNode.g, flatShadowNode.u(), (ReactStylesDiffMap) stateBuilder.f5823k.get(i));
                    flatShadowNode.ah();
                }
            }
        }
        stateBuilder.f5822j.clear();
        stateBuilder.f5823k.clear();
        super.a(eventDispatcher);
        this.f5692b.m7239a(eventDispatcher);
    }

    protected final void m7040a(ReactShadowNode reactShadowNode, float f, float f2, EventDispatcher eventDispatcher) {
        this.f5692b.m7237a((FlatRootShadowNode) reactShadowNode);
    }

    public final void m7044b(int i) {
        StateBuilder stateBuilder = this.f5692b;
        for (int size = stateBuilder.f5821i.size() - 1; size >= 0; size--) {
            if (((FlatShadowNode) stateBuilder.f5821i.get(size)).C().g == i) {
                stateBuilder.f5821i.remove(size);
            }
        }
        super.b(i);
    }

    public final void m7039a(int i, boolean z) {
        int i2;
        ReactShadowNode a = a(i);
        while (a.s()) {
            a = a.D();
        }
        int i3 = a.g;
        ReactShadowNode reactShadowNode = a;
        while ((reactShadowNode instanceof FlatShadowNode) && !((FlatShadowNode) reactShadowNode).af()) {
            reactShadowNode = reactShadowNode.D();
        }
        UIViewOperationQueue uIViewOperationQueue = this.f5692b.f5814b;
        if (reactShadowNode == null) {
            i2 = i3;
        } else {
            i2 = reactShadowNode.g;
        }
        uIViewOperationQueue.a(i2, i, z);
    }

    @Nullable
    private static ReactImageManager m7024a(List<ViewManager> list) {
        int size = list.size();
        for (int i = 0; i != size; i++) {
            if (list.get(i) instanceof ReactImageManager) {
                return (ReactImageManager) list.get(i);
            }
        }
        return null;
    }
}
