package com.facebook.components.widget;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Looper;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.StringRes;
import android.support.v4.util.Pools$SynchronizedPool;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: from_primed_result */
public final class Text extends ComponentLifecycle {
    public static Text f22898b = null;
    public static final Pools$SynchronizedPool<Builder> f22899c = new Pools$SynchronizedPool(2);
    private final TextSpec f22900d = new TextSpec();

    /* compiled from: from_primed_result */
    public class State extends Component<Text> implements Cloneable {
        boolean f22901A;
        CharSequence f22902a;
        TruncateAt f22903b;
        boolean f22904c = true;
        public int f22905d = Integer.MIN_VALUE;
        int f22906e = Integer.MAX_VALUE;
        float f22907f;
        float f22908g;
        float f22909h;
        int f22910i = -7829368;
        boolean f22911j;
        int f22912k = -16777216;
        ColorStateList f22913l = TextSpec.f22928a;
        int f22914m = -16777216;
        public int f22915n = 13;
        public float f22916o;
        float f22917p = 1.0f;
        int f22918q = TextSpec.f22929b;
        Typeface f22919r = TextSpec.f22930c;
        Alignment f22920s = TextSpec.f22932e;
        boolean f22921t = false;
        Layout f22922u;
        VerticalGravity f22923v = TextSpec.f22931d;
        Layout f22924w;
        Float f22925x;
        ClickableSpan[] f22926y;
        int f22927z;

        public State() {
            super(Text.m31013j());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.f22588b == state.f22588b) {
                return true;
            }
            if (this.f22902a == null ? state.f22902a != null : !this.f22902a.equals(state.f22902a)) {
                return false;
            }
            if (this.f22903b == null ? state.f22903b != null : !this.f22903b.equals(state.f22903b)) {
                return false;
            }
            if (this.f22904c != state.f22904c) {
                return false;
            }
            if (this.f22905d != state.f22905d) {
                return false;
            }
            if (this.f22906e != state.f22906e) {
                return false;
            }
            if (Float.compare(this.f22907f, state.f22907f) != 0) {
                return false;
            }
            if (Float.compare(this.f22908g, state.f22908g) != 0) {
                return false;
            }
            if (Float.compare(this.f22909h, state.f22909h) != 0) {
                return false;
            }
            if (this.f22910i != state.f22910i) {
                return false;
            }
            if (this.f22911j != state.f22911j) {
                return false;
            }
            if (this.f22912k != state.f22912k) {
                return false;
            }
            if (this.f22913l == null ? state.f22913l != null : !this.f22913l.equals(state.f22913l)) {
                return false;
            }
            if (this.f22914m != state.f22914m) {
                return false;
            }
            if (this.f22915n != state.f22915n) {
                return false;
            }
            if (Float.compare(this.f22916o, state.f22916o) != 0) {
                return false;
            }
            if (Float.compare(this.f22917p, state.f22917p) != 0) {
                return false;
            }
            if (this.f22918q != state.f22918q) {
                return false;
            }
            if (this.f22919r == null ? state.f22919r != null : !this.f22919r.equals(state.f22919r)) {
                return false;
            }
            if (this.f22920s == null ? state.f22920s != null : !this.f22920s.equals(state.f22920s)) {
                return false;
            }
            if (this.f22921t != state.f22921t) {
                return false;
            }
            if (this.f22923v == null ? state.f22923v != null : !this.f22923v.equals(state.f22923v)) {
                return false;
            }
            if (this.f22927z != state.f22927z) {
                return false;
            }
            if (this.f22901A != state.f22901A) {
                return false;
            }
            return true;
        }

        protected final void mo3374a(Component<Text> component) {
            State state = (State) component;
            this.f22922u = state.f22922u;
            this.f22924w = state.f22924w;
            this.f22925x = state.f22925x;
            this.f22926y = state.f22926y;
        }
    }

    /* compiled from: from_primed_result */
    public class Builder extends com.facebook.components.Component.Builder<Text> {
        private static String[] f22940b = new String[]{"text"};
        private static int f22941c = 1;
        public State f22942a;
        private BitSet f22943d = new BitSet(f22941c);

        public static void m31037a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22942a = state;
            builder.f22943d.clear();
        }

        public final Builder m31042a(CharSequence charSequence) {
            this.f22942a.f22902a = charSequence;
            this.f22943d.set(0);
            return this;
        }

        public final Builder m31052h(@StringRes int i) {
            this.f22942a.f22902a = m30671b(i);
            this.f22943d.set(0);
            return this;
        }

        public final Builder m31040a(TruncateAt truncateAt) {
            this.f22942a.f22903b = truncateAt;
            return this;
        }

        public final Builder m31043a(boolean z) {
            this.f22942a.f22904c = z;
            return this;
        }

        public final Builder m31053j(int i) {
            this.f22942a.f22906e = i;
            return this;
        }

        public final Builder m31045b(boolean z) {
            this.f22942a.f22911j = z;
            return this;
        }

        public final Builder m31054k(int i) {
            this.f22942a.f22912k = i;
            return this;
        }

        public final Builder m31055l(@ColorRes int i) {
            this.f22942a.f22912k = m30673d(i);
            return this;
        }

        public final Builder m31051f(@AttrRes int i, @ColorRes int i2) {
            this.f22942a.f22912k = m30667a(i, i2);
            return this;
        }

        public final Builder m31056m(@AttrRes int i) {
            return m31051f(i, 0);
        }

        public final Builder m31057n(int i) {
            this.f22942a.f22915n = i;
            return this;
        }

        public final Builder m31058o(@DimenRes int i) {
            this.f22942a.f22915n = m30675e(i);
            return this;
        }

        public final Builder m31059q(@DimenRes int i) {
            this.f22942a.f22916o = (float) m30678f(i);
            return this;
        }

        public final Builder m31046c(float f) {
            this.f22942a.f22916o = (float) m30665a(f);
            return this;
        }

        public final Builder m31049d(float f) {
            this.f22942a.f22917p = f;
            return this;
        }

        public final Builder m31060r(int i) {
            this.f22942a.f22918q = i;
            return this;
        }

        public final Builder m31038a(Typeface typeface) {
            this.f22942a.f22919r = typeface;
            return this;
        }

        public final Builder m31039a(Alignment alignment) {
            this.f22942a.f22920s = alignment;
            return this;
        }

        public final Builder m31047c(boolean z) {
            this.f22942a.f22921t = z;
            return this;
        }

        public final Builder m31041a(VerticalGravity verticalGravity) {
            this.f22942a.f22923v = verticalGravity;
            return this;
        }

        public final Builder m31061s(@ColorRes int i) {
            this.f22942a.f22927z = m30673d(i);
            return this;
        }

        public final Builder m31050d(boolean z) {
            this.f22942a.f22901A = z;
            return this;
        }

        public final Component<Text> mo3296d() {
            int i = 0;
            if (this.f22943d == null || this.f22943d.nextClearBit(0) >= f22941c) {
                Component component = this.f22942a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < f22941c) {
                if (!this.f22943d.get(i)) {
                    arrayList.add(f22940b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22942a = null;
            Text.f22899c.mo741a(this);
        }
    }

    private Text() {
    }

    public static synchronized Text m31013j() {
        Text text;
        synchronized (Text.class) {
            if (f22898b == null) {
                f22898b = new Text();
            }
            text = f22898b;
        }
        return text;
    }

    public final boolean mo3148h() {
        return true;
    }

    protected final boolean mo3144c() {
        return true;
    }

    protected final void mo3141a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.m30528c();
        TextSpec.m31035a(internalNode, i, i2, size, state.f22902a, state.f22903b, state.f22904c, state.f22905d, state.f22906e, state.f22907f, state.f22908g, state.f22909h, state.f22910i, state.f22911j, state.f22912k, state.f22913l, state.f22914m, state.f22915n, state.f22916o, state.f22917p, state.f22918q, state.f22919r, state.f22920s, state.f22921t, c);
        if (c.m31109a() != null) {
            state.f22922u = (Layout) c.m31109a();
        }
        ComponentLifecycle.m28113a(c);
    }

    protected final void mo3142a(ComponentContext componentContext, InternalNode internalNode, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.m30528c();
        Output c2 = ComponentsPools.m30528c();
        Output c3 = ComponentsPools.m30528c();
        TextSpec.m31036a(internalNode, state.f22902a, state.f22903b, state.f22904c, state.f22906e, state.f22907f, state.f22908g, state.f22909h, state.f22910i, state.f22911j, state.f22912k, state.f22913l, state.f22914m, state.f22915n, state.f22916o, state.f22917p, state.f22923v, state.f22918q, state.f22919r, state.f22920s, state.f22921t, state.f22922u, c, c2, c3);
        if (c.m31109a() != null) {
            state.f22924w = (Layout) c.m31109a();
        }
        ComponentLifecycle.m28113a(c);
        if (c2.m31109a() != null) {
            state.f22925x = (Float) c2.m31109a();
        }
        ComponentLifecycle.m28113a(c2);
        if (c3.m31109a() != null) {
            state.f22926y = (ClickableSpan[]) c3.m31109a();
        }
        ComponentLifecycle.m28113a(c3);
    }

    public final MountType mo3146f() {
        return MountType.DRAWABLE;
    }

    protected final Object mo3145e(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        return TextSpec.m31032a((TextDrawable) obj, state.f22902a, state.f22912k, state.f22927z, state.f22913l, state.f22924w, state.f22925x, state.f22926y);
    }

    protected final void mo3150f(ComponentContext componentContext, Object obj, Component component) {
        TextDrawable textDrawable = (TextDrawable) obj;
        textDrawable.f23044a = null;
        textDrawable.f23045c = 0.0f;
        textDrawable.f23047e = null;
        textDrawable.f23051i = null;
        textDrawable.f23046d = false;
        textDrawable.f23050h = 0;
        textDrawable.f23048f = null;
        textDrawable.f23049g = 0;
    }

    protected final void mo3140a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Component component) {
        accessibilityNodeInfoCompat.c(((State) component).f22902a);
    }

    protected final void mo3371a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i, int i2, int i3, Component component) {
        State state = (State) component;
        TextSpec.m31033a(accessibilityNodeInfoCompat, i, i2, i3, state.f22902a, state.f22924w, state.f22926y);
    }

    protected final int mo3369a(int i, int i2, Component component) {
        State state = (State) component;
        return TextSpec.m31030a(i, i2, state.f22902a, state.f22924w, state.f22926y);
    }

    protected final int mo3370a(Component component) {
        State state = (State) component;
        boolean z = state.f22901A;
        ClickableSpan[] clickableSpanArr = state.f22926y;
        int length = (!z || clickableSpanArr == null) ? 0 : clickableSpanArr.length;
        return length;
    }

    public final boolean mo3147g() {
        return true;
    }

    public final boolean mo3373e() {
        return true;
    }

    protected final void mo3372d(ComponentContext componentContext, Component<?> component) {
        Output c = ComponentsPools.m30528c();
        Output c2 = ComponentsPools.m30528c();
        Output c3 = ComponentsPools.m30528c();
        Output c4 = ComponentsPools.m30528c();
        Output c5 = ComponentsPools.m30528c();
        Output c6 = ComponentsPools.m30528c();
        Output c7 = ComponentsPools.m30528c();
        Output c8 = ComponentsPools.m30528c();
        Output c9 = ComponentsPools.m30528c();
        Output c10 = ComponentsPools.m30528c();
        Output c11 = ComponentsPools.m30528c();
        Output c12 = ComponentsPools.m30528c();
        Output c13 = ComponentsPools.m30528c();
        TextSpec.m31034a(componentContext, c, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13);
        State state = (State) component;
        if (c.m31109a() != null) {
            state.f22903b = (TruncateAt) c.m31109a();
        }
        ComponentsPools.m30526a(c);
        if (c2.m31109a() != null) {
            state.f22904c = ((Boolean) c2.m31109a()).booleanValue();
        }
        ComponentsPools.m30526a(c2);
        if (c3.m31109a() != null) {
            state.f22917p = ((Float) c3.m31109a()).floatValue();
        }
        ComponentsPools.m30526a(c3);
        if (c4.m31109a() != null) {
            state.f22905d = ((Integer) c4.m31109a()).intValue();
        }
        ComponentsPools.m30526a(c4);
        if (c5.m31109a() != null) {
            state.f22906e = ((Integer) c5.m31109a()).intValue();
        }
        ComponentsPools.m30526a(c5);
        if (c6.m31109a() != null) {
            state.f22911j = ((Boolean) c6.m31109a()).booleanValue();
        }
        ComponentsPools.m30526a(c6);
        if (c7.m31109a() != null) {
            state.f22902a = (CharSequence) c7.m31109a();
        }
        ComponentsPools.m30526a(c7);
        if (c8.m31109a() != null) {
            state.f22913l = (ColorStateList) c8.m31109a();
        }
        ComponentsPools.m30526a(c8);
        if (c9.m31109a() != null) {
            state.f22914m = ((Integer) c9.m31109a()).intValue();
        }
        ComponentsPools.m30526a(c9);
        if (c10.m31109a() != null) {
            state.f22927z = ((Integer) c10.m31109a()).intValue();
        }
        ComponentsPools.m30526a(c10);
        if (c11.m31109a() != null) {
            state.f22915n = ((Integer) c11.m31109a()).intValue();
        }
        ComponentsPools.m30526a(c11);
        if (c12.m31109a() != null) {
            state.f22920s = (Alignment) c12.m31109a();
        }
        ComponentsPools.m30526a(c12);
        if (c13.m31109a() != null) {
            state.f22918q = ((Integer) c13.m31109a()).intValue();
        }
        ComponentsPools.m30526a(c13);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 1968415480);
        }
    }

    public static Builder m31012a(ComponentContext componentContext, int i) {
        State state = new State();
        Builder builder = (Builder) f22899c.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m31037a(builder, componentContext, i, state);
        return builder;
    }

    public static Builder m31011a(ComponentContext componentContext) {
        return m31012a(componentContext, 0);
    }
}
