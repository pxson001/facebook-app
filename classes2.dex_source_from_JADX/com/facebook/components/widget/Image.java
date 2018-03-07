package com.facebook.components.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.support.v4.util.Pools$SynchronizedPool;
import android.widget.ImageView.ScaleType;
import com.facebook.R;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.Diff;
import com.facebook.components.DrawableMatrix;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.MatrixDrawable;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.components.reference.Reference;
import com.facebook.components.reference.ResourceDrawableReference;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: from %s */
public final class Image extends ComponentLifecycle {
    public static Image f22964b = null;
    public static final Pools$SynchronizedPool<Builder> f22965c = new Pools$SynchronizedPool(2);
    private final ImageSpec f22966d = new ImageSpec();

    /* compiled from: from %s */
    public class State extends Component<Image> implements Cloneable {
        public Reference<Drawable> f22967a;
        ScaleType f22968b;
        DrawableMatrix f22969c;
        Integer f22970d;
        Integer f22971e;

        public State() {
            super(Image.m31070j());
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
            if (this.f22967a == null ? state.f22967a != null : !this.f22967a.equals(state.f22967a)) {
                return false;
            }
            if (this.f22968b != null) {
                if (this.f22968b.equals(state.f22968b)) {
                    return true;
                }
            } else if (state.f22968b == null) {
                return true;
            }
            return false;
        }

        protected final void mo3374a(Component<Image> component) {
            State state = (State) component;
            this.f22969c = state.f22969c;
            this.f22970d = state.f22970d;
            this.f22971e = state.f22971e;
        }
    }

    /* compiled from: from %s */
    public class Builder extends com.facebook.components.Component.Builder<Image> {
        public State f22973a;

        public static void m31087a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22973a = state;
        }

        public final Builder m31089a(Reference<Drawable> reference) {
            this.f22973a.f22967a = reference;
            return this;
        }

        public final Builder m31092h(@DrawableRes int i) {
            this.f22973a.f22967a = m30679g(i);
            return this;
        }

        public final Builder m31088a(ScaleType scaleType) {
            this.f22973a.f22968b = scaleType;
            return this;
        }

        public final Component<Image> mo3296d() {
            Component component = this.f22973a;
            mo3295a();
            return component;
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22973a = null;
            Image.f22965c.mo741a(this);
        }
    }

    private Image() {
    }

    public static synchronized Image m31070j() {
        Image image;
        synchronized (Image.class) {
            if (f22964b == null) {
                f22964b = new Image();
            }
            image = f22964b;
        }
        return image;
    }

    public final boolean mo3148h() {
        return true;
    }

    public final boolean mo3143b(Component component, Component component2) {
        boolean z;
        State state = (State) component;
        State state2 = (State) component2;
        Diff a = ComponentLifecycle.m28111a(state.f22968b, state2.f22968b);
        Diff a2 = ComponentLifecycle.m28111a(state.f22967a, state2.f22967a);
        if (a.b != a.a || Reference.m30533a((Reference) a2.b, (Reference) a2.a)) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        ComponentsPools.m30523a(a);
        ComponentsPools.m30523a(a2);
        return z2;
    }

    public final boolean mo3368i() {
        return true;
    }

    protected final boolean mo3144c() {
        return true;
    }

    protected final void mo3141a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        ImageSpec.m31085a(componentContext, i, i2, size, ((State) component).f22967a);
    }

    protected final void mo3142a(ComponentContext componentContext, InternalNode internalNode, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.m30528c();
        Output c2 = ComponentsPools.m30528c();
        Output c3 = ComponentsPools.m30528c();
        ImageSpec.m31086a(componentContext, internalNode, state.f22967a, state.f22968b, c, c2, c3);
        if (c.f22989a != null) {
            state.f22969c = (DrawableMatrix) c.f22989a;
        }
        ComponentsPools.m30526a(c);
        if (c2.f22989a != null) {
            state.f22970d = (Integer) c2.f22989a;
        }
        ComponentsPools.m30526a(c2);
        if (c3.f22989a != null) {
            state.f22971e = (Integer) c3.f22989a;
        }
        ComponentsPools.m30526a(c3);
    }

    public final MountType mo3146f() {
        return MountType.DRAWABLE;
    }

    protected final Object mo3145e(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        return ImageSpec.m31084a(componentContext, (MatrixDrawable) obj, state.f22967a, state.f22969c);
    }

    protected final void mo3366g(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        ((MatrixDrawable) obj).m31142a(state.f22970d.intValue(), state.f22971e.intValue());
    }

    protected final void mo3150f(ComponentContext componentContext, Object obj, Component component) {
        MatrixDrawable matrixDrawable = (MatrixDrawable) obj;
        Reference.m30532a(componentContext, matrixDrawable.f23012a, ((State) component).f22967a);
        matrixDrawable.m31141a();
    }

    protected final void mo3372d(ComponentContext componentContext, Component<?> component) {
        Output c = ComponentsPools.m30528c();
        Output c2 = ComponentsPools.m30528c();
        TypedArray a = componentContext.m30446a(R.styleable.Image, 0);
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = a.getIndex(i);
            if (index == 0) {
                c.f22989a = ResourceDrawableReference.m30964a(componentContext).m30972h(a.getResourceId(index, 0)).mo3297b();
            } else if (index == 1) {
                c2.f22989a = ImageSpec.f22972a[a.getInteger(index, -1)];
            }
        }
        a.recycle();
        State state = (State) component;
        if (c.f22989a != null) {
            state.f22967a = (Reference) c.f22989a;
        }
        ComponentsPools.m30526a(c);
        if (c2.f22989a != null) {
            state.f22968b = (ScaleType) c2.f22989a;
        }
        ComponentsPools.m30526a(c2);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 21468968);
        }
    }

    public static Builder m31069a(ComponentContext componentContext) {
        State state = new State();
        Builder builder = (Builder) f22965c.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m31087a(builder, componentContext, 0, state);
        return builder;
    }
}
