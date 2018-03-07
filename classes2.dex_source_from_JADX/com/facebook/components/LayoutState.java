package com.facebook.components;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.displaylist.DisplayList;
import com.facebook.components.displaylist.DisplayListException;
import com.facebook.components.fb.logger.QPLComponentsLogger;
import com.facebook.components.reference.Reference;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.CSSDirection;
import com.facebook.csslayout.CSSLayoutContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: geofenceEndTimestampMs */
public class LayoutState {
    public ComponentContext f22646a;
    public Component<?> f22647b;
    private int f22648c;
    private int f22649d;
    private final CSSLayoutContext f22650e = new CSSLayoutContext();
    private final List<LayoutOutput> f22651f = new ArrayList(8);
    public final LongSparseArray<Integer> f22652g = new LongSparseArray(8);
    private final LayoutOutputIdCalculator f22653h = new LayoutOutputIdCalculator();
    private DiffNode f22654i;
    public final AtomicInteger f22655j = new AtomicInteger(-1);
    public int f22656k;
    public int f22657l;
    private int f22658m;
    private int f22659n;
    private int f22660o = 0;
    private long f22661p = -1;
    private int f22662q = -1;
    private boolean f22663r = true;
    private boolean f22664s = false;
    private int f22665t = -1;
    public boolean f22666u = false;

    LayoutState() {
    }

    private static LayoutOutput m30585a(InternalNode internalNode, LayoutState layoutState) {
        Component F = internalNode.m30759F();
        if (F == null) {
            return null;
        }
        if (F.m30511e().mo3146f() == MountType.NONE) {
            return null;
        }
        LayoutOutput a = m30582a(F, layoutState, internalNode.m30809i(), internalNode.b_(), internalNode.c_(), internalNode.m30790c(), internalNode.m30793d(), internalNode.m30805h(), internalNode.m30796e(), internalNode.d_(), internalNode.m30801g(), internalNode.m30761G(), layoutState.f22663r, internalNode.m30752B() != null);
        if (Component.m30505e(F)) {
            a.f22634j = internalNode.m30755D();
            a.f22632h = internalNode.m30752B();
            a.f22633i = internalNode.m30754C();
        }
        return a;
    }

    private static LayoutOutput m30583a(Component<?> component, LayoutState layoutState, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        return m30582a(component, layoutState, i, i2, i3, i4, i5, 0, 0, 0, 0, i6, z, z2);
    }

    private static LayoutOutput m30582a(Component<?> component, LayoutState layoutState, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, boolean z2) {
        int i11;
        boolean e = Component.m30505e(component);
        LayoutOutput b = e ? ComponentsPools.m30527b() : ComponentsPools.m30513a();
        b.m30549a((Component) component);
        b.m30556e(i10);
        b.m30547a(layoutState.f22661p);
        if (layoutState.f22662q >= 0) {
            Rect b2 = ((LayoutOutput) layoutState.f22651f.get(layoutState.f22662q)).m30551b();
            b.m30545a(b2.left);
            b.m30552b(b2.top);
        }
        int i12 = layoutState.f22658m + i2;
        int i13 = layoutState.f22659n + i3;
        int i14 = i12 + i4;
        int i15 = i13 + i5;
        if (e) {
            ViewLayoutOutput viewLayoutOutput = (ViewLayoutOutput) b;
            viewLayoutOutput.m30564b(i6, i7, i8, i9);
            viewLayoutOutput.m30566f(i);
            i11 = i15;
            i15 = i14;
            i14 = i13;
            i13 = i12;
        } else {
            i11 = i15 - i9;
            i15 = i14 - i8;
            i14 = i13 + i7;
            i13 = i12 + i6;
        }
        b.m30546a(i13, i14, i15, i11);
        i11 = 0;
        if (z) {
            i11 = 1;
        }
        if (z2) {
            i11 |= 2;
        }
        b.m30554c(i11);
        return b;
    }

    private static void m30592a(InternalNode internalNode, LayoutState layoutState, DiffNode diffNode) {
        DiffNode diffNode2;
        LayoutOutput a;
        if (internalNode.g_()) {
            internalNode.i_();
        }
        Component F = internalNode.m30759F();
        boolean z = layoutState.f22664s;
        DiffNode y = internalNode.m30837y();
        Object obj = (!Component.m30504c(F) || y == null) ? null : 1;
        boolean z2 = obj != null && internalNode.m30839z();
        if (z) {
            DiffNode a2 = m30580a(internalNode, diffNode);
            if (diffNode == null) {
                layoutState.f22654i = a2;
                diffNode2 = a2;
            } else {
                diffNode2 = a2;
            }
        } else {
            diffNode2 = null;
        }
        boolean c = m30597c(internalNode, layoutState);
        long j = layoutState.f22661p;
        int i = layoutState.f22662q;
        if (c) {
            int b = m30594b(internalNode, layoutState, diffNode2);
            layoutState.f22660o++;
            layoutState.f22661p = ((LayoutOutput) layoutState.f22651f.get(b)).m30555e();
            layoutState.f22662q = b;
        }
        boolean z3 = layoutState.f22663r;
        boolean z4 = c || (z3 && internalNode.m30764H());
        layoutState.f22663r = z4;
        LayoutOutput a3 = m30585a(internalNode, layoutState);
        if (a3 != null) {
            layoutState.f22653h.m30713a(a3, layoutState.f22660o, 0, obj != null ? y.m31124g().m30555e() : -1, z2);
        }
        if (z2) {
            a3.m30550a(y.m31124g().m30561k());
        }
        Reference s = internalNode.m30829s();
        if (s != null) {
            if (a3 instanceof ViewLayoutOutput) {
                ((ViewLayoutOutput) a3).m30563a(s);
            } else {
                a = m30586a(internalNode, layoutState, y != null ? y.m31125h() : null, s, 1, c, z2);
                if (diffNode2 != null) {
                    diffNode2.m31117b(a);
                }
            }
        }
        if (Component.m30504c(F)) {
            F.m30511e().mo3142a(layoutState.f22646a, internalNode, F);
            layoutState.f22651f.add(a3);
            m30588a(layoutState.f22652g, a3, layoutState.f22651f.size() - 1);
            if (diffNode2 != null) {
                diffNode2.m31114a(a3);
            }
        }
        layoutState.f22658m += internalNode.b_();
        layoutState.f22659n += internalNode.c_();
        int a4 = internalNode.m30841a();
        for (int i2 = 0; i2 < a4; i2++) {
            m30592a((InternalNode) internalNode.a_(i2), layoutState, diffNode2);
        }
        layoutState.f22658m -= internalNode.b_();
        layoutState.f22659n -= internalNode.c_();
        s = internalNode.m30831t();
        if (s != null) {
            if (a3 instanceof ViewLayoutOutput) {
                ((ViewLayoutOutput) a3).m30565b(s);
            } else {
                a = m30586a(internalNode, layoutState, y != null ? y.m31126i() : null, s, 2, c, z2);
                if (diffNode2 != null) {
                    diffNode2.m31120c(a);
                }
            }
        }
        if (layoutState.f22661p != j) {
            layoutState.f22661p = j;
            layoutState.f22662q = i;
            layoutState.f22660o--;
        }
        layoutState.f22663r = z3;
    }

    private static void m30591a(InternalNode internalNode, LayoutOutput layoutOutput, LayoutState layoutState, boolean z) {
        if (internalNode.m30853b() == null) {
            layoutOutput.f22625a = 0;
            layoutOutput.f22631g = 0;
            layoutOutput.f22635k = 2;
            return;
        }
        layoutState.f22653h.m30713a(layoutOutput, layoutState.f22660o, 3, -1, z);
    }

    private static LayoutOutput m30586a(InternalNode internalNode, LayoutState layoutState, LayoutOutput layoutOutput, Reference<Drawable> reference, int i, boolean z, boolean z2) {
        boolean z3;
        Component a = DrawableComponent.m31127a(reference);
        if (layoutOutput != null) {
            boolean z4 = z2 || !((DrawableComponent) a.m30511e()).m28123a(layoutOutput.m30544a(), a);
            z3 = z4;
        } else {
            z3 = false;
        }
        return m30584a(a, layoutState, internalNode, z, i, layoutOutput != null ? layoutOutput.m30555e() : -1, z3);
    }

    private static void m30588a(LongSparseArray longSparseArray, LayoutOutput layoutOutput, int i) {
        if (longSparseArray != null) {
            longSparseArray.m4364b(layoutOutput.f22625a, Integer.valueOf(i));
        }
    }

    private static LayoutOutput m30584a(Component<DrawableComponent> component, LayoutState layoutState, ComponentLayout componentLayout, boolean z, int i, long j, boolean z2) {
        ((DrawableComponent) component.m30511e()).mo3142a(layoutState.f22646a, componentLayout, component);
        LayoutOutput a = m30583a(component, layoutState, componentLayout.m30809i(), componentLayout.b_(), componentLayout.c_(), componentLayout.m30790c(), componentLayout.m30793d(), 2, z, false);
        layoutState.f22653h.m30713a(a, layoutState.f22660o, i, j, z2);
        layoutState.f22651f.add(a);
        m30588a(layoutState.f22652g, a, layoutState.f22651f.size() - 1);
        return a;
    }

    private static void m30589a(InternalNode internalNode) {
        for (int a = internalNode.m30841a() - 1; a >= 0; a--) {
            InternalNode internalNode2 = (InternalNode) internalNode.a_(a);
            internalNode.b_(a);
            m30589a(internalNode2);
        }
        internalNode.m30870r();
        internalNode.m30849a(null);
        internalNode.f22767n.m30677e();
        internalNode.f22779z = Float.NaN;
        internalNode.f22760A = Float.NaN;
        internalNode.f22768o = null;
        internalNode.f22769p = null;
        internalNode.f22770q = null;
        internalNode.f22771r = 0;
        internalNode.f22772s = false;
        internalNode.f22773t = null;
        internalNode.f22774u = null;
        internalNode.f22775v = false;
        internalNode.f22776w = null;
        internalNode.f22777x = null;
        internalNode.f22778y = null;
        internalNode.f22761B = -1;
        internalNode.f22762C = -1;
        internalNode.f22764E = -1.0f;
        internalNode.f22763D = -1.0f;
        internalNode.f22765F = null;
        internalNode.f22766G = false;
        ComponentsPools.f22593c.mo741a(internalNode);
    }

    private static int m30594b(InternalNode internalNode, LayoutState layoutState, DiffNode diffNode) {
        if (!Component.m30505e(internalNode.f22770q) || internalNode.m30853b() == null) {
            boolean z;
            EventHandler B = internalNode.m30752B();
            int i = internalNode.m30809i();
            int b_ = internalNode.b_();
            int c_ = internalNode.c_();
            int c = internalNode.m30790c();
            int d = internalNode.m30793d();
            int G = internalNode.m30761G();
            boolean H = internalNode.m30764H();
            if (B != null) {
                z = true;
            } else {
                z = false;
            }
            LayoutOutput a = m30583a(null, layoutState, i, b_, c_, c, d, G, H, z);
            a.f22632h = B;
            a.f22634j = internalNode.m30755D();
            a.f22633i = internalNode.m30754C();
            layoutState.f22651f.add(a);
            int size = layoutState.f22651f.size() - 1;
            if (diffNode != null) {
                diffNode.f22997d = a;
            }
            a.f22626b = HostComponent.m30500j();
            m30591a(internalNode, a, layoutState, false);
            m30588a(layoutState.f22652g, a, size);
            return size;
        }
        throw new IllegalArgumentException("We shouldn't insert a host as a parent of a View");
    }

    static <T extends ComponentLifecycle> LayoutState m30587a(ComponentContext componentContext, Component<T> component, int i, int i2, int i3, boolean z, DiffNode diffNode, String str, ComponentsLogger componentsLogger) {
        component.m30506a();
        LayoutState a = ComponentsPools.m30514a(componentContext);
        a.f22664s = z;
        a.f22665t = i;
        a.f22666u = AccessibilityUtils.m30467a(componentContext);
        a.f22647b = component;
        a.f22648c = i2;
        a.f22649d = i3;
        InternalNode a2 = m30581a((Component) component, a, str, (QPLComponentsLogger) componentsLogger);
        m30590a(a2, i2, i3, a, diffNode, str, (QPLComponentsLogger) componentsLogger);
        a.f22656k = a2.m30790c();
        a.f22657l = a2.m30793d();
        a.f22653h.m30712a();
        a.f22661p = -1;
        ComponentsSystrace.m30654a("collectResults");
        if (componentsLogger != null) {
            componentsLogger.m30614a(2, component, "log_tag", str);
        }
        m30592a(a2, a, null);
        if (componentsLogger != null) {
            componentsLogger.m30613a(2, component, 16);
        }
        ComponentsSystrace.m30653a();
        m30589a(a2);
        if (ComponentsConstants.f22749b) {
            m30593a(a);
        }
        return a;
    }

    private static void m30593a(LayoutState layoutState) {
        Rect rect = new Rect();
        ComponentContext componentContext = layoutState.f22646a;
        Activity c = m30596c(componentContext);
        if (c != null) {
            int a = layoutState.m30599a();
            for (int i = 0; i < a; i++) {
                LayoutOutput b = layoutState.m30602b(i);
                Component a2 = b.m30544a();
                ComponentLifecycle e = a2.m30511e();
                if (e.mo3373e()) {
                    b.m30548a(rect);
                    if (b.m30561k() != null && b.m30561k().m30576a()) {
                        try {
                            b.m30561k().m30574a(rect.left, rect.top, rect.right, rect.bottom);
                        } catch (DisplayListException e2) {
                        }
                    }
                    DisplayList a3 = DisplayList.m30572a(c, e.getClass().getSimpleName());
                    if (a3 != null) {
                        Drawable drawable = (Drawable) e.m28117a(componentContext, ComponentsPools.m30517a((Context) componentContext, e.m28114a()), a2);
                        e.m28125b(componentContext, drawable, a2);
                        b.m30548a(rect);
                        drawable.setBounds(0, 0, rect.width(), rect.height());
                        try {
                            Canvas a4 = a3.m30573a(rect.width(), rect.height());
                            drawable.draw(a4);
                            a3.m30575a(a4);
                            a3.m30574a(rect.left, rect.top, rect.right, rect.bottom);
                            b.m30550a(a3);
                        } catch (DisplayListException e3) {
                            b.m30550a(null);
                        }
                        e.m28128c(componentContext, drawable, a2);
                        e.m28131d(componentContext, drawable, a2);
                        ComponentsPools.m30519a(componentContext, e.m28114a(), drawable);
                    }
                }
            }
        }
    }

    private static Activity m30596c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m30596c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static <T extends ComponentLifecycle> InternalNode m30581a(Component<T> component, LayoutState layoutState, String str, ComponentsLogger componentsLogger) {
        ComponentsSystrace.m30654a("create-layout");
        if (componentsLogger != null) {
            componentsLogger.m30614a(0, component, "log_tag", str);
        }
        InternalNode internalNode = (InternalNode) layoutState.f22646a.m30447a((Component) component, 0);
        if (componentsLogger != null) {
            componentsLogger.m30613a(0, component, 16);
        }
        ComponentsSystrace.m30653a();
        if (internalNode.f22780a.f22802a == CSSDirection.INHERIT) {
            Context context = layoutState.f22646a;
            Object obj = 1;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (VERSION.SDK_INT < 17 || (applicationInfo.flags & 4194304) == 0) {
                obj = null;
            } else if (context.getResources().getConfiguration().getLayoutDirection() != 1) {
                obj = null;
            }
            if (obj != null) {
                internalNode.m30768L(2);
            }
        }
        return internalNode;
    }

    private static void m30590a(InternalNode internalNode, int i, int i2, LayoutState layoutState, DiffNode diffNode, String str, QPLComponentsLogger qPLComponentsLogger) {
        internalNode.f22761B = i;
        internalNode.f22762C = i2;
        if (CSSConstants.m31000a(internalNode.m30863k())) {
            internalNode.m30860e(SizeSpec.m30708c(i));
        }
        if (CSSConstants.m31000a(internalNode.m30864l())) {
            internalNode.m30862f(SizeSpec.m30708c(i2));
        }
        ComponentsSystrace.m30654a("apply-cached-results");
        if (diffNode != null && diffNode.f23001h == i && diffNode.f23002i == i2) {
            m30595b(internalNode, diffNode);
        }
        ComponentsSystrace.m30653a();
        ComponentsSystrace.m30654a("csslayout");
        if (qPLComponentsLogger != null) {
            Component component = internalNode.f22770q;
            qPLComponentsLogger.m30614a(1, component, "log_tag", str);
            qPLComponentsLogger.m30615b(1, component, "tree_diff_enabled", String.valueOf(layoutState.f22664s));
        }
        internalNode.m30848a(layoutState.f22650e);
        if (qPLComponentsLogger != null) {
            qPLComponentsLogger.m30613a(1, internalNode.f22770q, 16);
        }
        ComponentsSystrace.m30653a();
    }

    private static DiffNode m30580a(InternalNode internalNode, DiffNode diffNode) {
        ComponentsSystrace.m30654a("diff_node_creation");
        DiffNode diffNode2 = (DiffNode) ComponentsPools.f22600j.mo740a();
        if (diffNode2 == null) {
            diffNode2 = new DiffNode();
        }
        DiffNode diffNode3 = diffNode2;
        diffNode3.f23001h = internalNode.f22761B;
        diffNode3.f23002i = internalNode.f22762C;
        diffNode3.f22999f = internalNode.f22763D;
        diffNode3.f23000g = internalNode.f22764E;
        diffNode3.f22998e = internalNode.f22770q;
        if (diffNode != null) {
            diffNode.f23003j.add(diffNode3);
        }
        ComponentsSystrace.m30653a();
        return diffNode3;
    }

    public final boolean m30600a(int i, int i2) {
        return (SizeSpec.m30704a(i) == 0 || this.f22648c == i) && (SizeSpec.m30704a(i2) == 0 || this.f22649d == i2);
    }

    private static boolean m30595b(InternalNode internalNode, DiffNode diffNode) {
        boolean z;
        Component component;
        boolean z2 = true;
        int i = 0;
        if (diffNode == null) {
            z = false;
        } else {
            boolean z3;
            component = internalNode.f22770q;
            Component component2 = diffNode.f22998e;
            if (component == component2) {
                z3 = true;
            } else if (component == null || component2 == null) {
                z3 = false;
            } else {
                z3 = component.f22589c.getClass().equals(component2.f22589c.getClass());
            }
            z = z3;
        }
        if (z) {
            int i2;
            internalNode.f22765F = diffNode;
            int a = internalNode.m30841a();
            if (diffNode.f23003j == null) {
                i2 = 0;
            } else {
                i2 = diffNode.f23003j.size();
            }
            int i3 = i2;
            if (a == i3) {
                z2 = false;
            }
            int i4 = z2;
            while (i < a && i < i3) {
                i++;
                i4 = m30595b((InternalNode) internalNode.a_(i), (DiffNode) diffNode.f23003j.get(i)) | i4;
            }
            z2 = m30598e(internalNode, diffNode) | i4;
            if (!z2) {
                component = internalNode.f22770q;
                if (component != null) {
                    component.mo3374a(diffNode.f22998e);
                }
                internalNode.f22766G = true;
            }
        }
        return z2;
    }

    private static boolean m30598e(InternalNode internalNode, DiffNode diffNode) {
        if (diffNode == null) {
            return true;
        }
        Component component = internalNode.f22770q;
        if (component != null) {
            return component.f22589c.m28123a(component, diffNode.f22998e);
        }
        return true;
    }

    final int m30599a() {
        return this.f22651f.size();
    }

    final LayoutOutput m30602b(int i) {
        return (LayoutOutput) this.f22651f.get(i);
    }

    public final DiffNode m30601b() {
        return this.f22654i;
    }

    final int m30603c() {
        return this.f22656k;
    }

    final int m30604d() {
        return this.f22657l;
    }

    final int m30605e() {
        return this.f22665t;
    }

    final void m30606f() {
        int decrementAndGet = this.f22655j.decrementAndGet();
        if (decrementAndGet < 0) {
            throw new IllegalStateException("Trying to releaseRef a recycled LayoutState");
        } else if (decrementAndGet == 0) {
            this.f22646a = null;
            this.f22647b = null;
            this.f22656k = 0;
            this.f22657l = 0;
            this.f22658m = 0;
            this.f22659n = 0;
            this.f22661p = -1;
            this.f22662q = -1;
            this.f22665t = -1;
            this.f22663r = true;
            int size = this.f22651f.size();
            for (int i = 0; i < size; i++) {
                ComponentsPools.m30525a((LayoutOutput) this.f22651f.get(i));
            }
            this.f22651f.clear();
            this.f22652g.m4362b();
            this.f22664s = false;
            this.f22666u = false;
            if (this.f22654i != null) {
                ComponentsPools.m30524a(this.f22654i);
                this.f22654i = null;
            }
            this.f22653h.m30712a();
            ComponentsPools.f22592b.mo741a(this);
        }
    }

    final LayoutState m30607g() {
        if (this.f22655j.getAndIncrement() != 0) {
            return this;
        }
        throw new IllegalStateException("Trying to use a released LayoutState");
    }

    private static boolean m30597c(InternalNode internalNode, LayoutState layoutState) {
        if (internalNode.m30853b() != null) {
            Object obj;
            Object obj2;
            Object obj3 = null;
            Component component = internalNode.f22770q;
            if (component == null || !component.f22589c.mo3147g()) {
                obj = null;
            } else {
                obj = 1;
            }
            int i = internalNode.f22771r;
            if (!layoutState.f22666u || i == 2 || (r1 == null && TextUtils.isEmpty(internalNode.f22777x) && i == 0)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (internalNode.f22776w != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            Object obj4;
            if (internalNode.f22778y != null) {
                obj4 = 1;
            } else {
                obj4 = null;
            }
            if (!(obj2 == null && r5 == null && r1 == null)) {
                obj3 = 1;
            }
            if ((obj3 == null || Component.m30505e(internalNode.f22770q)) && (!internalNode.f22775v || Component.m30505e(internalNode.f22770q))) {
                return false;
            }
        }
        return true;
    }
}
