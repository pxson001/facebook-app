package com.facebook.react.uimanager;

import com.facebook.csslayout.CSSLayoutContext;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: frame_ignored_asset_missing */
public class UIImplementation {
    private final ShadowNodeRegistry f11774a;
    private final ViewManagerRegistry f11775b;
    private final CSSLayoutContext f11776c;
    private final UIViewOperationQueue f11777d;
    private final NativeViewHierarchyOptimizer f11778e;
    private final int[] f11779f;

    public UIImplementation(ReactApplicationContext reactApplicationContext, List<ViewManager> list) {
        this(reactApplicationContext, new ViewManagerRegistry(list));
    }

    private UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry) {
        this(viewManagerRegistry, new UIViewOperationQueue(reactApplicationContext, new NativeViewHierarchyManager(viewManagerRegistry)));
    }

    protected UIImplementation(ViewManagerRegistry viewManagerRegistry, UIViewOperationQueue uIViewOperationQueue) {
        this.f11774a = new ShadowNodeRegistry();
        this.f11776c = new CSSLayoutContext();
        this.f11779f = new int[4];
        this.f11775b = viewManagerRegistry;
        this.f11777d = uIViewOperationQueue;
        this.f11778e = new NativeViewHierarchyOptimizer(this.f11777d, this.f11774a);
    }

    protected ReactShadowNode m13993a() {
        ReactShadowNode reactShadowNode = new ReactShadowNode();
        reactShadowNode.f11718h = "Root";
        return reactShadowNode;
    }

    protected ReactShadowNode m13995a(String str) {
        return this.f11775b.m14101a(str).mo742c();
    }

    protected final ReactShadowNode m13994a(int i) {
        return this.f11774a.m13970c(i);
    }

    protected final ViewManager m14019b(String str) {
        return this.f11775b.m14101a(str);
    }

    public final void m14014a(SizeMonitoringFrameLayout sizeMonitoringFrameLayout, int i, int i2, int i3, ThemedReactContext themedReactContext) {
        ReactShadowNode a = m13993a();
        a.f11717g = i;
        a.m13839a(themedReactContext);
        a.e((float) i2);
        a.f((float) i3);
        this.f11774a.m13967a(a);
        this.f11777d.m14077a(i, sizeMonitoringFrameLayout, themedReactContext);
    }

    protected final void m14010a(ReactShadowNode reactShadowNode) {
        reactShadowNode.m13826G();
        this.f11774a.m13968b(reactShadowNode.f11717g);
        for (int a = reactShadowNode.a() - 1; a >= 0; a--) {
            m14010a(reactShadowNode.m13848e(a));
        }
        reactShadowNode.m13858z();
    }

    public void m14021b(int i) {
        this.f11774a.m13966a(i);
        this.f11777d.m14068a(i);
    }

    public final void m13998a(int i, int i2, int i3, EventDispatcher eventDispatcher) {
        ReactShadowNode c = this.f11774a.m13970c(i);
        c.e((float) i2);
        c.f((float) i3);
        if (this.f11777d.m14085a()) {
            m14017a(eventDispatcher, -1);
        }
    }

    public final void m14006a(int i, String str, int i2, ReadableMap readableMap) {
        ReactShadowNode a = m13995a(str);
        ReactShadowNode c = this.f11774a.m13970c(i2);
        a.f11717g = i;
        a.f11718h = str;
        a.f11719i = c;
        a.m13839a(c.m13824E());
        this.f11774a.m13969b(a);
        ReactStylesDiffMap reactStylesDiffMap = null;
        if (readableMap != null) {
            reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
            ViewManagerPropertyUpdater.m14097a(a, reactStylesDiffMap);
        }
        m14012a(a, i2, reactStylesDiffMap);
    }

    protected void m14012a(ReactShadowNode reactShadowNode, int i, @Nullable ReactStylesDiffMap reactStylesDiffMap) {
        if (!reactShadowNode.m13851s()) {
            this.f11778e.m13902a(reactShadowNode, reactShadowNode.m13824E(), reactStylesDiffMap);
        }
    }

    public final void m14007a(int i, String str, ReadableMap readableMap) {
        if (this.f11775b.m14101a(str) == null) {
            throw new IllegalViewOperationException("Got unknown view type: " + str);
        }
        ReactShadowNode c = this.f11774a.m13970c(i);
        if (c == null) {
            throw new IllegalViewOperationException("Trying to update non-existent view with tag " + i);
        } else if (readableMap != null) {
            ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
            ViewManagerPropertyUpdater.m14097a(c, reactStylesDiffMap);
            m14013a(c, str, reactStylesDiffMap);
        }
    }

    protected void m14013a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        if (!reactShadowNode.m13851s()) {
            this.f11778e.m13903a(reactShadowNode, str, reactStylesDiffMap);
        }
    }

    public void m14005a(int i, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3, @Nullable ReadableArray readableArray4, @Nullable ReadableArray readableArray5) {
        ReactShadowNode c = this.f11774a.m13970c(i);
        int size = readableArray == null ? 0 : readableArray.size();
        int size2 = readableArray3 == null ? 0 : readableArray3.size();
        int size3 = readableArray5 == null ? 0 : readableArray5.size();
        if (size != 0 && (readableArray2 == null || size != readableArray2.size())) {
            throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
        } else if (size2 == 0 || (readableArray4 != null && size2 == readableArray4.size())) {
            int i2;
            int i3;
            ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[(size + size2)];
            int[] iArr = new int[(size + size3)];
            int[] iArr2 = new int[iArr.length];
            int[] iArr3 = new int[size3];
            if (size > 0) {
                Assertions.b(readableArray);
                Assertions.b(readableArray2);
                for (i2 = 0; i2 < size; i2++) {
                    i3 = readableArray.getInt(i2);
                    int B = c.m13848e(i3).m13821B();
                    viewAtIndexArr[i2] = new ViewAtIndex(B, readableArray2.getInt(i2));
                    iArr[i2] = i3;
                    iArr2[i2] = B;
                }
            }
            if (size2 > 0) {
                Assertions.b(readableArray3);
                Assertions.b(readableArray4);
                for (i2 = 0; i2 < size2; i2++) {
                    viewAtIndexArr[size + i2] = new ViewAtIndex(readableArray3.getInt(i2), readableArray4.getInt(i2));
                }
            }
            if (size3 > 0) {
                Assertions.b(readableArray5);
                for (i2 = 0; i2 < size3; i2++) {
                    size2 = readableArray5.getInt(i2);
                    i3 = c.m13848e(size2).m13821B();
                    iArr[size + i2] = size2;
                    iArr2[size + i2] = i3;
                    iArr3[i2] = i3;
                }
            }
            Arrays.sort(viewAtIndexArr, ViewAtIndex.f11859a);
            Arrays.sort(iArr);
            size3 = -1;
            for (i2 = iArr.length - 1; i2 >= 0; i2--) {
                if (iArr[i2] == size3) {
                    throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + i);
                }
                c.m13846c(iArr[i2]);
                size3 = iArr[i2];
            }
            for (ViewAtIndex viewAtIndex : viewAtIndexArr) {
                ReactShadowNode c2 = this.f11774a.m13970c(viewAtIndex.f11860b);
                if (c2 == null) {
                    throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.f11860b);
                }
                c.a(c2, viewAtIndex.f11861c);
            }
            if (!(c.m13851s() || c.m13852t())) {
                this.f11778e.m13904a(c, iArr2, viewAtIndexArr, iArr3);
            }
            for (int size22 : iArr3) {
                m14010a(this.f11774a.m13970c(size22));
            }
        } else {
            throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
        }
    }

    public void m14003a(int i, ReadableArray readableArray) {
        ReactShadowNode c = this.f11774a.m13970c(i);
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReactShadowNode c2 = this.f11774a.m13970c(readableArray.getInt(i2));
            if (c2 == null) {
                throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i2));
            }
            c.a(c2, i2);
        }
        if (!c.m13851s() && !c.m13852t()) {
            this.f11778e.m13901a(c, readableArray);
        }
    }

    public final void m13997a(int i, int i2) {
        if (this.f11774a.m13971d(i) || this.f11774a.m13971d(i2)) {
            throw new IllegalViewOperationException("Trying to add or replace a root tag!");
        }
        ReactShadowNode c = this.f11774a.m13970c(i);
        if (c == null) {
            throw new IllegalViewOperationException("Trying to replace unknown view tag: " + i);
        }
        ReactShadowNode D = c.m13823D();
        if (D == null) {
            throw new IllegalViewOperationException("Node is not attached to a parent: " + i);
        }
        int a = D.a(c);
        if (a < 0) {
            throw new IllegalStateException("Didn't find child tag in parent");
        }
        ReadableArray a2 = Arguments.m13384a();
        a2.pushInt(i2);
        ReadableArray a3 = Arguments.m13384a();
        a3.pushInt(a);
        ReadableArray a4 = Arguments.m13384a();
        a4.pushInt(a);
        m14005a(D.f11717g, null, null, a2, a3, a4);
    }

    public final void m14025c(int i) {
        ReactShadowNode c = this.f11774a.m13970c(i);
        if (c == null) {
            throw new IllegalViewOperationException("Trying to remove subviews of an unknown view tag: " + i);
        }
        ReadableArray a = Arguments.m13384a();
        for (int i2 = 0; i2 < c.a(); i2++) {
            a.pushInt(i2);
        }
        m14005a(i, null, null, null, null, a);
    }

    public void m13996a(int i, float f, float f2, Callback callback) {
        this.f11777d.m14069a(i, f, f2, callback);
    }

    public void m14001a(int i, Callback callback) {
        this.f11777d.m14074a(i, callback);
    }

    public void m14023b(int i, Callback callback) {
        this.f11777d.m14088b(i, callback);
    }

    public final void m13999a(int i, int i2, Callback callback, Callback callback2) {
        try {
            m13986a(i, i2, this.f11779f);
            float c = PixelUtil.m13926c((float) this.f11779f[0]);
            float c2 = PixelUtil.m13926c((float) this.f11779f[1]);
            float c3 = PixelUtil.m13926c((float) this.f11779f[2]);
            float c4 = PixelUtil.m13926c((float) this.f11779f[3]);
            callback2.mo642a(Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4));
        } catch (IllegalViewOperationException e) {
            callback.mo642a(e.getMessage());
        }
    }

    public final void m14002a(int i, Callback callback, Callback callback2) {
        try {
            m13988a(i, this.f11779f);
            float c = PixelUtil.m13926c((float) this.f11779f[0]);
            float c2 = PixelUtil.m13926c((float) this.f11779f[1]);
            float c3 = PixelUtil.m13926c((float) this.f11779f[2]);
            float c4 = PixelUtil.m13926c((float) this.f11779f[3]);
            callback2.mo642a(Float.valueOf(c), Float.valueOf(c2), Float.valueOf(c3), Float.valueOf(c4));
        } catch (IllegalViewOperationException e) {
            callback.mo642a(e.getMessage());
        }
    }

    public final void m14017a(EventDispatcher eventDispatcher, int i) {
        m14016a(eventDispatcher);
        this.f11778e.m13900a();
        this.f11777d.m14087b(i);
    }

    protected void m14016a(EventDispatcher eventDispatcher) {
        for (int i = 0; i < this.f11774a.m13965a(); i++) {
            ReactShadowNode c = this.f11774a.m13970c(this.f11774a.m13972e(i));
            m13991c(c);
            m13992d(c);
            m14011a(c, 0.0f, 0.0f, eventDispatcher);
        }
    }

    public final void m14018a(boolean z) {
        this.f11777d.m14084a(z);
    }

    public final void m14009a(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.f11777d.m14080a(readableMap);
    }

    public void m14008a(int i, boolean z) {
        m13987a(i, "setJSResponder");
        ReactShadowNode c = this.f11774a.m13970c(i);
        while (true) {
            if (c.m13851s() || c.f11723m) {
                c = c.m13823D();
            } else {
                this.f11777d.m14073a(c.f11717g, i, z);
                return;
            }
        }
    }

    public final void m14020b() {
        this.f11777d.m14086b();
    }

    public void m14000a(int i, int i2, ReadableArray readableArray) {
        m13987a(i, "dispatchViewManagerCommand");
        this.f11777d.m14072a(i, i2, readableArray);
    }

    public void m14004a(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        m13987a(i, "showPopupMenu");
        this.f11777d.m14075a(i, readableArray, callback2);
    }

    public void m14022b(int i, int i2) {
        this.f11777d.m14070a(i, i2);
    }

    public final void m14024c() {
        this.f11777d.m14089c();
    }

    public final void m14026d() {
        this.f11777d.m14090d();
    }

    public final void m14015a(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.f11777d.f11858k = notThreadSafeViewHierarchyUpdateDebugListener;
    }

    private void m13986a(int i, int i2, int[] iArr) {
        ReactShadowNode c = this.f11774a.m13970c(i);
        ReactShadowNode c2 = this.f11774a.m13970c(i2);
        if (c == null || c2 == null) {
            StringBuilder stringBuilder = new StringBuilder("Tag ");
            if (c != null) {
                i = i2;
            }
            throw new IllegalViewOperationException(stringBuilder.append(i).append(" does not exist").toString());
        }
        if (c != c2) {
            for (ReactShadowNode D = c.m13823D(); D != c2; D = D.m13823D()) {
                if (D == null) {
                    throw new IllegalViewOperationException("Tag " + i2 + " is not an ancestor of tag " + i);
                }
            }
        }
        m13989a(c, c2, iArr);
    }

    private void m13988a(int i, int[] iArr) {
        ReactShadowNode c = this.f11774a.m13970c(i);
        if (c == null) {
            throw new IllegalViewOperationException("No native view for tag " + i + " exists!");
        }
        ReactShadowNode D = c.m13823D();
        if (D == null) {
            throw new IllegalViewOperationException("View with tag " + i + " doesn't have a parent!");
        }
        m13989a(c, D, iArr);
    }

    private void m13989a(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int[] iArr) {
        int round;
        int i;
        if (reactShadowNode != reactShadowNode2) {
            int round2 = Math.round(reactShadowNode.m());
            round = Math.round(reactShadowNode.n());
            i = round;
            round = round2;
            ReactShadowNode D = reactShadowNode.m13823D();
            while (D != reactShadowNode2) {
                Assertions.b(D);
                m13990b(D);
                int round3 = Math.round(D.m()) + round;
                round = Math.round(D.n()) + i;
                D = D.m13823D();
                i = round;
                round = round3;
            }
            m13990b(reactShadowNode2);
        } else {
            i = 0;
            round = 0;
        }
        iArr[0] = round;
        iArr[1] = i;
        iArr[2] = reactShadowNode.m13832M();
        iArr[3] = reactShadowNode.m13833N();
    }

    private void m13987a(int i, String str) {
        if (this.f11774a.m13970c(i) == null) {
            throw new IllegalViewOperationException("Unable to execute operation " + str + " on view with tag: " + i + ", since the view does not exists");
        }
    }

    private void m13990b(ReactShadowNode reactShadowNode) {
        ViewManager viewManager = (ViewManager) Assertions.b(this.f11775b.m14101a(reactShadowNode.m13853u()));
        if (viewManager instanceof ViewGroupManager) {
            ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
            if (viewGroupManager != null && viewGroupManager.m13961e()) {
                throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + reactShadowNode.m13853u() + "). Use measure instead.");
            }
            return;
        }
        throw new IllegalViewOperationException("Trying to use view " + reactShadowNode.m13853u() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }

    private void m13991c(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.m13854v()) {
            for (int i = 0; i < reactShadowNode.a(); i++) {
                m13991c(reactShadowNode.m13848e(i));
            }
            reactShadowNode.m13820A();
        }
    }

    private void m13992d(ReactShadowNode reactShadowNode) {
        SystraceMessage.a(8192, "cssRoot.calculateLayout").a("rootTag", reactShadowNode.m13821B()).a();
        try {
            reactShadowNode.a(this.f11776c);
        } finally {
            Systrace.a(8192);
        }
    }

    protected void m14011a(ReactShadowNode reactShadowNode, float f, float f2, EventDispatcher eventDispatcher) {
        if (reactShadowNode.m13854v()) {
            int i;
            if (!reactShadowNode.m13852t()) {
                for (i = 0; i < reactShadowNode.a(); i++) {
                    m14011a(reactShadowNode.m13848e(i), reactShadowNode.m() + f, reactShadowNode.n() + f2, eventDispatcher);
                }
            }
            i = reactShadowNode.f11717g;
            if (!this.f11774a.m13971d(i)) {
                reactShadowNode.m13834a(f, f2, this.f11777d, this.f11778e);
                if (reactShadowNode.f11721k) {
                    eventDispatcher.m14159a(OnLayoutEvent.m13918a(i, reactShadowNode.m13830K(), reactShadowNode.m13831L(), reactShadowNode.m13832M(), reactShadowNode.m13833N()));
                }
            }
            reactShadowNode.m13855w();
        }
    }
}
