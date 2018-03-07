package com.facebook.components;

import android.graphics.drawable.Drawable;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.reference.Reference;

/* compiled from: friends_locations_profile_pic_size_param */
class DrawableComponent extends ComponentLifecycle {
    static DrawableComponent f23004b;

    /* compiled from: friends_locations_profile_pic_size_param */
    public class State extends Component<DrawableComponent> implements Cloneable {
        public Reference<Drawable> f23005a;
        public int f23006b;
        public int f23007c;

        protected State(Reference<Drawable> reference) {
            super(DrawableComponent.m31128j());
            this.f23005a = reference;
        }

        public int hashCode() {
            return this.f23005a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f23005a.equals(((State) obj).f23005a);
        }
    }

    DrawableComponent() {
    }

    static synchronized DrawableComponent m31128j() {
        DrawableComponent drawableComponent;
        synchronized (DrawableComponent.class) {
            if (f23004b == null) {
                f23004b = new DrawableComponent();
            }
            drawableComponent = f23004b;
        }
        return drawableComponent;
    }

    protected final void mo3142a(ComponentContext componentContext, ComponentLayout componentLayout, Component<?> component) {
        State state = (State) component;
        state.f23006b = componentLayout.m30790c();
        state.f23007c = componentLayout.m30793d();
    }

    protected final Object mo3145e(ComponentContext componentContext, Object obj, Component component) {
        obj = (MatrixDrawable) obj;
        if (obj == null) {
            obj = new MatrixDrawable();
        }
        obj.m31143a((Drawable) Reference.m30531a(componentContext, ((State) component).f23005a), null);
        return obj;
    }

    protected final void mo3366g(ComponentContext componentContext, Object obj, Component<?> component) {
        State state = (State) component;
        ((MatrixDrawable) obj).m31142a(state.f23006b, state.f23007c);
    }

    protected final void mo3150f(ComponentContext componentContext, Object obj, Component<?> component) {
        MatrixDrawable matrixDrawable = (MatrixDrawable) obj;
        Reference.m30532a(componentContext, matrixDrawable.f23012a, ((State) component).f23005a);
        matrixDrawable.m31141a();
    }

    protected final boolean mo3148h() {
        return true;
    }

    public final MountType mo3146f() {
        return MountType.DRAWABLE;
    }

    public static Component m31127a(Reference<Drawable> reference) {
        return new State(reference);
    }

    protected final boolean mo3143b(Component component, Component component2) {
        return Reference.m30533a(((State) component).f23005a, ((State) component2).f23005a);
    }
}
