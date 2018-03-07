package com.facebook.components;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: image_pipeline_counters */
public abstract class ComponentLifecycle {
    protected static Handler f20393a = new Handler(Looper.getMainLooper());
    private static final AtomicInteger f20394b = new AtomicInteger();
    public static final MeasureFunction f20395c = new C08261();
    public final int f20396d = f20394b.incrementAndGet();

    /* compiled from: image_pipeline_counters */
    final class C08261 implements MeasureFunction {
        private final Pools$SynchronizedPool<Size> f20397a = new Pools$SynchronizedPool(2);

        C08261() {
        }

        private Size m28142a(int i) {
            Size size = (Size) this.f20397a.mo740a();
            if (size == null) {
                size = new Size();
            }
            size.f22987a = i;
            size.f22988b = i;
            return size;
        }

        private void m28143a(Size size) {
            this.f20397a.mo741a(size);
        }

        @SuppressLint({"WrongCall"})
        public final void mo3136a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput) {
            int e;
            InternalNode internalNode = (InternalNode) cSSNode;
            DiffNode y = internalNode.m30839z() ? internalNode.m30837y() : null;
            Component F = internalNode.m30759F();
            ComponentsSystrace.m30654a("csslayout-custom-measure");
            int a = SizeSpec.m30703a(f, cSSMeasureMode);
            int a2 = SizeSpec.m30703a(f2, cSSMeasureMode2);
            internalNode.m30766J(a);
            internalNode.m30767K(a2);
            int f3;
            if (y != null) {
                e = y.m31122e();
                f3 = y.m31123f();
            } else {
                f3 = 0;
                e = -1;
            }
            if (e == -1 || r1 == -1 || e != a || r1 != a2) {
                Size a3 = m28142a(Integer.MIN_VALUE);
                try {
                    F.m30511e().mo3141a(internalNode.m30757E(), internalNode, a, a2, a3, F);
                    if (a3.f22987a < 0 || a3.f22988b < 0) {
                        throw new IllegalStateException("MeasureOutput not set, ComponentLifecycle is: " + F.m30511e());
                    }
                    measureOutput.f22745a = (float) a3.f22987a;
                    measureOutput.f22746b = (float) a3.f22988b;
                    if (internalNode.m30837y() != null) {
                        internalNode.m30837y().m31116b(a);
                        internalNode.m30837y().m31119c(a2);
                        internalNode.m30837y().m31113a(measureOutput.f22745a);
                        internalNode.m30837y().m31115b(measureOutput.f22746b);
                    }
                    m28143a(a3);
                } catch (Throwable th) {
                    m28143a(a3);
                }
            } else {
                measureOutput.f22745a = y.m31118c();
                measureOutput.f22746b = y.m31121d();
            }
            internalNode.m30804g(measureOutput.f22745a);
            internalNode.m30808h(measureOutput.f22746b);
            ComponentsSystrace.m30653a();
        }
    }

    /* compiled from: image_pipeline_counters */
    public enum MountType {
        NONE,
        DRAWABLE,
        VIEW
    }

    public static EventHandler m28112a(ComponentContext componentContext, int i, Object[] objArr) {
        return new EventHandler(componentContext.f22549a, i, objArr);
    }

    protected ComponentLifecycle() {
    }

    final int m28114a() {
        return this.f20396d;
    }

    public final Object m28117a(ComponentContext componentContext, Object obj, Component<?> component) {
        ThreadUtils.m30579b();
        Object e = mo3145e(componentContext, obj, component);
        if (obj == null || obj == e) {
            return e;
        }
        throw new IllegalStateException("Convert content argument not returned for component: " + getClass().getSimpleName() + " When mounting you have to re-use the convertContent (if not null) and return it");
    }

    final void m28125b(ComponentContext componentContext, Object obj, Component<?> component) {
        ThreadUtils.m30579b();
        mo3366g(componentContext, obj, component);
    }

    final void m28128c(ComponentContext componentContext, Object obj, Component<?> component) {
        ThreadUtils.m30579b();
        mo3367h(componentContext, obj, component);
    }

    public final void m28131d(ComponentContext componentContext, Object obj, Component<?> component) {
        ThreadUtils.m30579b();
        mo3150f(componentContext, obj, component);
    }

    protected static void m28113a(Output output) {
        ComponentsPools.m30526a(output);
    }

    protected static <T> Diff<T> m28111a(T t, T t2) {
        Diff<T> diff = (Diff) ComponentsPools.f22601k.mo740a();
        if (diff == null) {
            diff = new Diff();
        }
        Diff<T> diff2 = diff;
        diff2.a = t;
        diff2.b = t2;
        return diff2;
    }

    public ComponentLayout mo3135b(ComponentContext componentContext, Component<?> component) {
        return Container.m30723a(componentContext).mo3343j();
    }

    public void mo3149c(ComponentContext componentContext, Component<?> component) {
    }

    public void mo3372d(ComponentContext componentContext, Component<?> component) {
    }

    protected void mo3142a(ComponentContext componentContext, ComponentLayout componentLayout, Component<?> component) {
    }

    public boolean mo3144c() {
        return false;
    }

    protected void mo3141a(ComponentContext componentContext, ComponentLayout componentLayout, int i, int i2, Size size, Component<?> component) {
        throw new IllegalStateException("You must override onMeasure() if you return true in canMeasure(), ComponentLifecycle is: " + component.f22589c);
    }

    protected boolean m28132d() {
        return false;
    }

    protected boolean mo3373e() {
        return false;
    }

    protected Object mo3145e(ComponentContext componentContext, Object obj, Component<?> component) {
        return null;
    }

    protected void mo3150f(ComponentContext componentContext, Object obj, Component<?> component) {
    }

    protected void mo3366g(ComponentContext componentContext, Object obj, Component<?> component) {
    }

    public void mo3367h(ComponentContext componentContext, Object obj, Component<?> component) {
    }

    public MountType mo3146f() {
        return MountType.NONE;
    }

    protected void mo3140a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Component<?> component) {
    }

    protected void mo3371a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i, int i2, int i3, Component<?> component) {
    }

    protected int mo3369a(int i, int i2, Component<?> component) {
        return Integer.MIN_VALUE;
    }

    protected int mo3370a(Component<?> component) {
        return 0;
    }

    public boolean mo3147g() {
        return false;
    }

    public void mo3134a(EventHandler eventHandler, Object obj) {
    }

    protected boolean mo3148h() {
        return false;
    }

    protected boolean mo3368i() {
        return false;
    }

    final boolean m28123a(Component component, Component component2) {
        if (mo3148h()) {
            return mo3143b(component, component2);
        }
        return true;
    }

    protected boolean mo3143b(Component component, Component component2) {
        return !component.equals(component2);
    }
}
