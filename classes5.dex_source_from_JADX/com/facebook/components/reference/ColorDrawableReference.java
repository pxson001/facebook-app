package com.facebook.components.reference;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorRes;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference.Builder;

/* compiled from: server group */
public final class ColorDrawableReference extends ReferenceLifecycle<Drawable> {
    private static final boolean f2826a = (VERSION.SDK_INT >= 11);
    private static ColorDrawableReference f2827b;
    public static final SynchronizedPool<PropsBuilder> f2828c = new SynchronizedPool(2);
    private static final Pool<ColorDrawable> f2829d;

    /* compiled from: server group */
    public class PropsBuilder extends Builder<Drawable> {
        private State f2823a;

        public final void m3951a(ComponentContext componentContext, State state) {
            super.a(componentContext);
            this.f2823a = state;
        }

        protected final void m3950a() {
            super.a();
            this.f2823a = null;
            ColorDrawableReference.f2828c.a(this);
        }

        public final PropsBuilder m3953h(int i) {
            this.f2823a.f2824a = i;
            return this;
        }

        public final PropsBuilder m3954i(@ColorRes int i) {
            this.f2823a.f2824a = d(i);
            return this;
        }

        public final Reference<Drawable> m3952b() {
            State state = this.f2823a;
            m3950a();
            return state;
        }
    }

    /* compiled from: server group */
    class State extends Reference<Drawable> {
        int f2824a;
        int f2825b = 255;

        protected State() {
            super(ColorDrawableReference.m3956a());
        }

        public int hashCode() {
            return (this.f2824a * 31) + this.f2825b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.f2824a != state.f2824a) {
                return false;
            }
            if (this.f2825b != state.f2825b) {
                return false;
            }
            return true;
        }
    }

    protected final void m3958a(ComponentContext componentContext, Object obj, Reference reference) {
        Drawable drawable = (Drawable) obj;
        if (f2826a) {
            f2829d.a((ColorDrawable) drawable);
        }
    }

    static {
        Pool synchronizedPool;
        if (f2826a) {
            synchronizedPool = new SynchronizedPool(50);
        } else {
            synchronizedPool = null;
        }
        f2829d = synchronizedPool;
    }

    private ColorDrawableReference() {
    }

    public static synchronized ColorDrawableReference m3956a() {
        ColorDrawableReference colorDrawableReference;
        synchronized (ColorDrawableReference.class) {
            if (f2827b == null) {
                f2827b = new ColorDrawableReference();
            }
            colorDrawableReference = f2827b;
        }
        return colorDrawableReference;
    }

    public static PropsBuilder m3955a(ComponentContext componentContext) {
        State state = new State();
        PropsBuilder propsBuilder = (PropsBuilder) f2828c.a();
        if (propsBuilder == null) {
            propsBuilder = new PropsBuilder();
        }
        propsBuilder.m3951a(componentContext, state);
        return propsBuilder;
    }

    protected final Object m3957a(ComponentContext componentContext, Reference reference) {
        ColorDrawable colorDrawable;
        ColorDrawable colorDrawable2 = null;
        if (f2826a) {
            colorDrawable2 = (ColorDrawable) f2829d.a();
        }
        if (colorDrawable2 == null) {
            colorDrawable = new ColorDrawable(((State) reference).f2824a);
        } else {
            colorDrawable2.setColor(((State) reference).f2824a);
            colorDrawable = colorDrawable2;
        }
        colorDrawable.setAlpha(((State) reference).f2825b);
        return colorDrawable;
    }
}
