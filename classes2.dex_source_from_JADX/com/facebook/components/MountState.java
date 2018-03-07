package com.facebook.components;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.fb.logger.QPLComponentsLogger;
import com.facebook.components.reference.Reference;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: getGoogleAppId or isMeasurementEnabled failed with exception */
public class MountState {
    private static final Rect f22571f = new Rect();
    private static final Rect f22572g = new Rect();
    private final LongSparseArray<MountItem> f22573a = new LongSparseArray();
    private long[] f22574b;
    public boolean f22575c;
    private final LongSparseArray<ComponentHost> f22576d = new LongSparseArray();
    public int f22577e;
    public final ComponentContext f22578h;
    private final ComponentView f22579i;
    private MountStats f22580j = new MountStats();
    private int f22581k;
    private final MountItem f22582l;

    /* compiled from: getGoogleAppId or isMeasurementEnabled failed with exception */
    public class MountStats {
        public int f22583a = 0;
        public int f22584b = 0;
        public int f22585c = 0;
    }

    private boolean m30488a(LayoutOutput layoutOutput, MountItem mountItem, boolean z) {
        Component component = layoutOutput.f22626b;
        Component component2 = mountItem.f22615a;
        boolean b = m30495b(layoutOutput, mountItem, z);
        if (b) {
            m30494b(mountItem);
        }
        m30482a(mountItem, layoutOutput);
        if (b) {
            Component component3 = layoutOutput.f22626b;
            if (!Component.m30503b(component3)) {
                Object obj = mountItem.f22616b;
                ComponentLifecycle componentLifecycle = component3.f22589c;
                if (mountItem.f22621g) {
                    componentLifecycle.mo3367h(this.f22578h, obj, component2);
                    mountItem.f22621g = false;
                }
                componentLifecycle.m28131d(this.f22578h, obj, component2);
                componentLifecycle.m28117a(this.f22578h, obj, component3);
            }
            m30480a(mountItem);
        }
        Object obj2 = mountItem.f22616b;
        m30493b(layoutOutput, mountItem);
        component.f22589c.m28125b(this.f22578h, obj2, component);
        mountItem.f22621g = true;
        ComponentHostUtils.m30651a(mountItem);
        return b;
    }

    private static void m30480a(MountItem mountItem) {
        Component component = mountItem.f22615a;
        if (Component.m30505e(component)) {
            View view = (View) mountItem.f22616b;
            EventHandler eventHandler = mountItem.f22620f;
            if (eventHandler != null) {
                ComponentClickListener b = m30490b(view);
                if (b == null) {
                    b = new ComponentClickListener();
                    m30476a(view, b);
                }
                b.f22645a = eventHandler;
            }
            view.setClickable(eventHandler != null);
            m30477a(view, mountItem);
            CharSequence charSequence = mountItem.f22618d;
            if (!TextUtils.isEmpty(charSequence)) {
                view.setContentDescription(charSequence);
            }
            int i = mountItem.f22622h;
            if (i != 0) {
                ViewCompat.m10958d(view, i);
            }
            if ((mountItem instanceof ViewMountItem) && !Component.m30503b(component)) {
                ViewMountItem viewMountItem = (ViewMountItem) mountItem;
                if (viewMountItem.m30536r()) {
                    view.setPadding(viewMountItem.f22611a.left, viewMountItem.f22611a.top, viewMountItem.f22611a.right, viewMountItem.f22611a.bottom);
                }
                Reference reference = viewMountItem.f22612b;
                if (reference != null) {
                    view.setBackground((Drawable) Reference.m30531a((ComponentContext) view.getContext(), reference));
                }
                if (VERSION.SDK_INT >= 23) {
                    reference = viewMountItem.f22613c;
                    if (reference != null) {
                        view.setForeground((Drawable) Reference.m30531a((ComponentContext) view.getContext(), reference));
                    }
                }
                if (VERSION.SDK_INT >= 17) {
                    int i2;
                    switch (viewMountItem.f22614d) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            i2 = 0;
                            break;
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            i2 = 1;
                            break;
                        default:
                            i2 = 2;
                            break;
                    }
                    view.setLayoutDirection(i2);
                }
            }
        }
    }

    private static void m30481a(MountItem mountItem, Rect rect) {
        if (Component.m30505e(mountItem.f22615a)) {
            m30475a((View) mountItem.f22616b, rect);
        }
    }

    private static void m30494b(MountItem mountItem) {
        Component component = mountItem.f22615a;
        if (Component.m30505e(component)) {
            View view = (View) mountItem.f22616b;
            if (mountItem.f22620f != null) {
                ComponentClickListener b = m30490b(view);
                if (b != null) {
                    b.f22645a = null;
                }
            }
            m30492b(view, mountItem);
            if (!TextUtils.isEmpty(mountItem.f22618d)) {
                view.setContentDescription(null);
            }
            if (mountItem.f22622h != 0) {
                ViewCompat.m10958d(view, 0);
            }
            if ((mountItem instanceof ViewMountItem) && !Component.m30503b(component)) {
                ViewMountItem viewMountItem = (ViewMountItem) mountItem;
                if (viewMountItem.m30536r()) {
                    view.setPadding(0, 0, 0, 0);
                }
                Reference reference = viewMountItem.f22612b;
                if (reference != null) {
                    Reference.m30532a((ComponentContext) view.getContext(), view.getBackground(), reference);
                    view.setBackground(null);
                }
                if (VERSION.SDK_INT >= 23) {
                    reference = viewMountItem.f22613c;
                    if (reference != null) {
                        Reference.m30532a((ComponentContext) view.getContext(), view.getForeground(), reference);
                        view.setForeground(null);
                    }
                }
                if (VERSION.SDK_INT >= 17) {
                    view.setLayoutDirection(2);
                }
            }
        }
    }

    public MountState(ComponentView componentView) {
        this.f22578h = (ComponentContext) componentView.getContext();
        this.f22579i = componentView;
        this.f22575c = true;
        this.f22582l = ComponentsPools.m30516a(HostComponent.m30500j(), this.f22579i, this.f22579i, null, null, null, 0, 0, 0, new Rect(), null, null);
    }

    private static void m30477a(View view, MountItem mountItem) {
        SparseArray sparseArray = mountItem.f22619e;
        if (sparseArray != null) {
            if (view instanceof ComponentHost) {
                ((ComponentHost) view).setViewTags(sparseArray);
                return;
            }
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                view.setTag(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    private Object m30472a(Component<?> component, ComponentHost componentHost) {
        ComponentLifecycle componentLifecycle = component.f22589c;
        if (!Component.m30503b(component)) {
            return ComponentsPools.m30517a(this.f22578h, componentLifecycle.f20396d);
        }
        View view;
        if (componentHost.f22543g.size() > 0) {
            view = (ComponentHost) componentHost.f22543g.remove(0);
            if (VERSION.SDK_INT < 17) {
                componentHost.bringChildToFront(view);
            }
        } else {
            view = null;
        }
        return view;
    }

    private static boolean m30486a(Component<?> component) {
        return component.f22589c.m28132d();
    }

    private static ComponentHost m30469a(LayoutOutput layoutOutput, LongSparseArray<ComponentHost> longSparseArray) {
        return (ComponentHost) longSparseArray.m4358a(layoutOutput.f22631g);
    }

    private static void m30493b(LayoutOutput layoutOutput, MountItem mountItem) {
        if (layoutOutput.f22625a != 0) {
            boolean z;
            layoutOutput.m30548a(f22571f);
            if ((mountItem instanceof ViewMountItem) && !Component.m30503b(mountItem.f22615a) && ((View) mountItem.f22616b).isLayoutRequested()) {
                z = true;
            } else {
                z = false;
            }
            m30484a(mountItem.f22616b, f22571f.left, f22571f.top, f22571f.right, f22571f.bottom, z);
        }
    }

    public final void m30496a(LayoutState layoutState, Rect rect, boolean z) {
        ThreadUtils.m30579b();
        int e = layoutState.m30605e();
        ComponentsSystrace.m30654a("mount");
        QPLComponentsLogger logger = this.f22579i.getLogger();
        ComponentTree component = this.f22579i.getComponent();
        String logTag = this.f22579i.getLogTag();
        if (logger != null) {
            logger.m30612a(6, component);
        }
        if (this.f22575c) {
            if (!z) {
                m30497d();
            }
            m30485a(true);
            m30479a(layoutState);
            this.f22575c = false;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int a = layoutState.m30599a();
        for (int i5 = 0; i5 < a; i5++) {
            LayoutOutput b = layoutState.m30602b(i5);
            MountItem a2 = m30470a(i5);
            boolean a3 = m30487a(b, rect);
            Object obj = a2 != null ? 1 : null;
            if (a3 && obj == null) {
                m30473a(i5, b);
                i++;
            } else if (!a3 && obj != null) {
                m30478a(this.f22578h, i5, this.f22576d);
                i2++;
            } else if (obj != null) {
                obj = (rect == null || rect.isEmpty()) ? 1 : null;
                if (obj == null && m30486a(b.m30544a())) {
                    m30481a(a2, rect);
                }
                if (z || b.m30555e() == 0) {
                    boolean z2 = e >= 0 && e == this.f22581k;
                    if (m30488a(b, a2, z2)) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
            }
        }
        m30485a(false);
        if (logger != null) {
            m30483a(logger, logTag, component, i, i2, i3, i4);
        }
        this.f22581k = e;
        ComponentsSystrace.m30653a();
    }

    final void m30497d() {
        if (this.f22574b != null) {
            for (int length = this.f22574b.length - 1; length >= 0; length--) {
                m30478a(this.f22578h, length, this.f22576d);
            }
            this.f22574b = null;
            this.f22576d.m4362b();
            this.f22575c = true;
        }
    }

    private void m30474a(long j, ComponentHost componentHost) {
        componentHost.m30440a(true);
        this.f22576d.m4364b(j, componentHost);
    }

    private void m30485a(boolean z) {
        for (int a = this.f22576d.m4356a() - 1; a >= 0; a--) {
            ((ComponentHost) this.f22576d.m4365c(a)).m30440a(z);
        }
    }

    private static boolean m30495b(LayoutOutput layoutOutput, MountItem mountItem, boolean z) {
        int i = layoutOutput.f22635k;
        if (z) {
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        Component component = mountItem.f22615a;
        ComponentLifecycle componentLifecycle = component.f22589c;
        if (!componentLifecycle.mo3368i()) {
            return true;
        }
        Object obj;
        Rect rect = layoutOutput.f22627c;
        Object obj2 = mountItem.f22616b;
        if (rect.width() == m30468a(obj2) && rect.height() == m30489b(obj2)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return componentLifecycle.m28123a(component, layoutOutput.f22626b);
        }
        return true;
    }

    public static int m30468a(Object obj) {
        return obj instanceof Drawable ? ((Drawable) obj).getBounds().width() : ((View) obj).getWidth();
    }

    public static int m30489b(Object obj) {
        return obj instanceof Drawable ? ((Drawable) obj).getBounds().height() : ((View) obj).getHeight();
    }

    private static void m30482a(MountItem mountItem, LayoutOutput layoutOutput) {
        if (layoutOutput instanceof ViewLayoutOutput) {
            ((ViewMountItem) mountItem).m30535a(layoutOutput.f22626b, mountItem.m30540b(), mountItem.m30541c(), layoutOutput.m30558g(), layoutOutput.m30559h(), layoutOutput.m30557f(), layoutOutput.m30553c(), layoutOutput.m30560j(), ((ViewLayoutOutput) layoutOutput).m30571p(), ((ViewLayoutOutput) layoutOutput).m30570o(), ((ViewLayoutOutput) layoutOutput).m30568m(), ((ViewLayoutOutput) layoutOutput).m30569n());
            return;
        }
        mountItem.m30539a(layoutOutput.m30544a(), mountItem.m30540b(), mountItem.m30541c(), layoutOutput.m30558g(), layoutOutput.m30559h(), layoutOutput.m30557f(), layoutOutput.m30561k(), layoutOutput.m30553c(), layoutOutput.m30560j());
    }

    private void m30479a(LayoutState layoutState) {
        QPLComponentsLogger logger = this.f22579i.getLogger();
        ComponentTree componentTree = this.f22579i.f22534a;
        String logTag = this.f22579i.getLogTag();
        if (logger != null) {
            logger.m30612a(5, componentTree);
        }
        MountStats b = m30491b(layoutState);
        if (logger != null) {
            logger.m30615b(5, componentTree, "log_tag", logTag);
            logger.m30615b(5, componentTree, "unmounted_count", String.valueOf(b.f22583a));
            logger.m30615b(5, componentTree, "moved_count", String.valueOf(b.f22584b));
            logger.m30615b(5, componentTree, "unchanged_count", String.valueOf(b.f22585c));
        }
        if (this.f22576d.m4358a(0) == null) {
            m30474a(0, this.f22579i);
            this.f22573a.m4364b(0, this.f22582l);
        }
        int a = layoutState.m30599a();
        if (this.f22574b == null || a != this.f22574b.length) {
            this.f22574b = new long[layoutState.m30599a()];
        }
        for (int i = 0; i < a; i++) {
            this.f22574b[i] = layoutState.m30602b(i).f22625a;
        }
        if (logger != null) {
            logger.m30613a(5, componentTree, 16);
        }
    }

    private MountStats m30491b(LayoutState layoutState) {
        MountStats mountStats = this.f22580j;
        mountStats.f22585c = 0;
        mountStats.f22584b = 0;
        mountStats.f22583a = 0;
        if (this.f22574b == null) {
            return this.f22580j;
        }
        int length = this.f22574b.length - 1;
        while (length >= 0) {
            int intValue = ((Integer) layoutState.f22652g.m4359a(this.f22574b[length], Integer.valueOf(-1))).intValue();
            MountStats mountStats2;
            if (intValue == -1) {
                m30478a(this.f22578h, length, this.f22576d);
                mountStats2 = this.f22580j;
                mountStats2.f22583a++;
            } else {
                long j = layoutState.m30602b(intValue).f22631g;
                MountItem a = m30470a(length);
                if (a != null && a.f22617c != this.f22576d.m4358a(j)) {
                    m30478a(this.f22578h, length, this.f22576d);
                    mountStats2 = this.f22580j;
                    mountStats2.f22583a++;
                } else if (a == null || intValue == length) {
                    mountStats2 = this.f22580j;
                    mountStats2.f22585c++;
                } else {
                    a.f22617c.m30439a(a, length, intValue);
                    mountStats2 = this.f22580j;
                    mountStats2.f22584b++;
                }
            }
            length--;
        }
        return this.f22580j;
    }

    private boolean m30487a(LayoutOutput layoutOutput, Rect rect) {
        boolean z;
        if (rect == null || rect.isEmpty() || Rect.intersects(rect, layoutOutput.f22627c)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        Object obj;
        Component component = layoutOutput.f22626b;
        if (component == null || component.f22589c.mo3146f() != MountType.DRAWABLE) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return false;
        }
        if (m30469a(layoutOutput, this.f22576d) == null) {
            return false;
        }
        return true;
    }

    private void m30473a(int i, LayoutOutput layoutOutput) {
        ComponentHost a = m30469a(layoutOutput, this.f22576d);
        Component component = layoutOutput.f22626b;
        ComponentLifecycle componentLifecycle = component.f22589c;
        Object a2 = componentLifecycle.m28117a(this.f22578h, m30472a(component, a), component);
        if (Component.m30503b(component)) {
            ComponentHost componentHost = (ComponentHost) a2;
            componentHost.f22546j = layoutOutput.f22631g;
            m30474a(layoutOutput.m30555e(), componentHost);
        }
        MountItem a3 = m30471a(i, component, a2, a, layoutOutput);
        componentLifecycle.m28125b(this.f22578h, a2, component);
        a3.f22621g = true;
    }

    private MountItem m30471a(int i, Component<?> component, Object obj, ComponentHost componentHost, LayoutOutput layoutOutput) {
        MountItem a;
        if (layoutOutput instanceof ViewLayoutOutput) {
            a = ComponentsPools.m30516a(component, componentHost, obj, layoutOutput.m30558g(), layoutOutput.m30559h(), layoutOutput.m30557f(), layoutOutput.m30553c(), layoutOutput.m30560j(), ((ViewLayoutOutput) layoutOutput).m30571p(), ((ViewLayoutOutput) layoutOutput).m30570o(), ((ViewLayoutOutput) layoutOutput).m30568m(), ((ViewLayoutOutput) layoutOutput).m30569n());
        } else {
            a = ComponentsPools.m30515a(component, componentHost, obj, layoutOutput.m30558g(), layoutOutput.m30557f(), layoutOutput.m30559h(), layoutOutput.m30561k(), layoutOutput.m30553c(), layoutOutput.m30560j());
        }
        this.f22573a.m4364b(this.f22574b[i], a);
        componentHost.m30438a(i, a);
        m30480a(a);
        layoutOutput.m30548a(f22571f);
        m30484a(obj, f22571f.left, f22571f.top, f22571f.right, f22571f.bottom, true);
        if (m30486a((Component) component)) {
            this.f22577e++;
        }
        return a;
    }

    private static void m30484a(Object obj, int i, int i2, int i3, int i4, boolean z) {
        ThreadUtils.m30579b();
        if (obj instanceof View) {
            View view = (View) obj;
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (!(!z && view.getMeasuredHeight() == i6 && view.getMeasuredWidth() == i5)) {
                view.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), MeasureSpec.makeMeasureSpec(i6, 1073741824));
            }
            if (z || view.getLeft() != i || view.getTop() != i2 || view.getRight() != i3 || view.getBottom() != i4) {
                view.layout(i, i2, i3, i4);
            }
        } else if (obj instanceof Drawable) {
            Drawable drawable = (Drawable) obj;
            Rect bounds = drawable.getBounds();
            if (bounds.left != i || bounds.top != i2 || bounds.right != i3 || bounds.bottom != i4) {
                drawable.setBounds(i, i2, i3, i4);
            }
        } else {
            throw new IllegalStateException("Unsupported mounted content " + obj);
        }
    }

    public static ComponentClickListener m30490b(View view) {
        if (view instanceof ComponentHost) {
            return ((ComponentHost) view).f22541e.f22562g;
        }
        return (ComponentClickListener) view.getTag(2131558413);
    }

    public static void m30476a(View view, ComponentClickListener componentClickListener) {
        if (view instanceof ComponentHost) {
            DrawableHostHolder drawableHostHolder = ((ComponentHost) view).f22541e;
            drawableHostHolder.f22562g = componentClickListener;
            drawableHostHolder.f22566k.setOnClickListener(componentClickListener);
            return;
        }
        view.setOnClickListener(componentClickListener);
        view.setTag(2131558413, componentClickListener);
    }

    private static void m30492b(View view, MountItem mountItem) {
        if (view instanceof ComponentHost) {
            ((ComponentHost) view).setViewTags(null);
            return;
        }
        SparseArray sparseArray = mountItem.f22619e;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                view.setTag(sparseArray.keyAt(i), null);
            }
        }
    }

    private static void m30475a(View view, Rect rect) {
        ThreadUtils.m30579b();
        f22572g.set(rect);
        if (!f22572g.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            return;
        }
        if (view instanceof ComponentView) {
            ((ComponentView) view).m30426a(f22572g);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = f22572g.left;
            int i2 = f22572g.top;
            int i3 = f22572g.right;
            int i4 = f22572g.bottom;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                f22572g.set(i, i2, i3, i4);
                m30475a(viewGroup.getChildAt(i5), f22572g);
            }
        }
    }

    private void m30478a(ComponentContext componentContext, int i, LongSparseArray<ComponentHost> longSparseArray) {
        MountItem a = m30470a(i);
        if (a != null && this.f22574b[i] != 0) {
            a.f22617c.m30442b(i, a);
            m30494b(a);
            Component component = a.f22615a;
            Object obj = a.f22616b;
            if (Component.m30503b(component)) {
                int a2 = longSparseArray.m4357a((ComponentHost) obj);
                if (longSparseArray.f2214d[a2] != LongSparseArray.f2211a) {
                    longSparseArray.f2214d[a2] = LongSparseArray.f2211a;
                    longSparseArray.f2212b = true;
                }
            }
            if (m30486a(component)) {
                this.f22577e--;
            }
            ComponentLifecycle componentLifecycle = component.f22589c;
            if (a.f22621g) {
                componentLifecycle.mo3367h(componentContext, obj, component);
                a.f22621g = false;
            }
            componentLifecycle.m28131d(componentContext, obj, component);
            this.f22573a.m4363b(this.f22574b[i]);
            ComponentsPools.m30520a((Context) componentContext, a);
        }
    }

    private MountItem m30470a(int i) {
        return (MountItem) this.f22573a.m4358a(this.f22574b[i]);
    }

    private void m30483a(QPLComponentsLogger qPLComponentsLogger, String str, ComponentTree componentTree, int i, int i2, int i3, int i4) {
        qPLComponentsLogger.m30615b(6, componentTree, "log_tag", str);
        qPLComponentsLogger.m30615b(6, componentTree, "mounted_count", String.valueOf(i));
        qPLComponentsLogger.m30615b(6, componentTree, "unmounted_count", String.valueOf(i2));
        qPLComponentsLogger.m30615b(6, componentTree, "updated_count", String.valueOf(i3));
        qPLComponentsLogger.m30615b(6, componentTree, "no_op_count", String.valueOf(i4));
        qPLComponentsLogger.m30615b(6, componentTree, "is_dirty", String.valueOf(this.f22575c));
        qPLComponentsLogger.m30613a(6, componentTree, 16);
    }

    final void m30498e() {
        if (this.f22574b != null) {
            int length = this.f22574b.length;
            for (int i = 0; i < length; i++) {
                MountItem a = m30470a(i);
                if (a != null && a.f22621g) {
                    Component component = a.f22615a;
                    component.f22589c.m28128c(this.f22578h, a.f22616b, component);
                    a.f22621g = false;
                }
            }
        }
    }

    final void m30499f() {
        if (this.f22574b != null) {
            int length = this.f22574b.length;
            for (int i = 0; i < length; i++) {
                MountItem a = m30470a(i);
                if (!(a == null || a.f22621g)) {
                    Component component = a.f22615a;
                    component.f22589c.m28125b(this.f22578h, a.f22616b, component);
                    a.f22621g = true;
                }
            }
        }
    }
}
