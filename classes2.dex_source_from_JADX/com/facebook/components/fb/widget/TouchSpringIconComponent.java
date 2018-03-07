package com.facebook.components.fb.widget;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.Diff;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.components.fb.widget.TouchSpringIconComponentSpec.Key;
import com.facebook.components.reference.Reference;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.springs.Spring;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ignore_old_datasource @ onFailure */
public class TouchSpringIconComponent<E extends HasPersistentState> extends ComponentLifecycle {
    private static TouchSpringIconComponent f20569d;
    private static final Object f20570e = new Object();
    private final TouchSpringIconComponentSpec f20571b;
    public final Pools$SynchronizedPool<Builder> f20572c = new Pools$SynchronizedPool(2);

    private static TouchSpringIconComponent m28304b(InjectorLike injectorLike) {
        return new TouchSpringIconComponent(TouchSpringIconComponentSpec.m28315a(injectorLike));
    }

    @Inject
    public TouchSpringIconComponent(TouchSpringIconComponentSpec touchSpringIconComponentSpec) {
        this.f20571b = touchSpringIconComponentSpec;
    }

    public static TouchSpringIconComponent m28303a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TouchSpringIconComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20570e) {
                TouchSpringIconComponent touchSpringIconComponent;
                if (a2 != null) {
                    touchSpringIconComponent = (TouchSpringIconComponent) a2.mo818a(f20570e);
                } else {
                    touchSpringIconComponent = f20569d;
                }
                if (touchSpringIconComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28304b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20570e, b3);
                        } else {
                            f20569d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = touchSpringIconComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m28305a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20572c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.a(builder, componentContext, 0, state);
        return builder;
    }

    protected final void mo3149c(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.m30528c();
        TouchSpringIconComponentSpec touchSpringIconComponentSpec = this.f20571b;
        HasPersistentState hasPersistentState = state.a;
        String str = state.b;
        c.f22989a = hasPersistentState.mo2425a(new Key(str, touchSpringIconComponentSpec.f20575a), state.c);
        if (c.f22989a != null) {
            state.d = (Spring) c.f22989a;
        }
        ComponentsPools.m30526a(c);
    }

    protected final boolean mo3144c() {
        return true;
    }

    protected final void mo3141a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        TouchSpringIconComponentSpec.m28317a(componentContext, i, i2, size, ((State) component).e);
    }

    public final MountType mo3146f() {
        return MountType.DRAWABLE;
    }

    protected final Object mo3145e(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        return TouchSpringIconComponentSpec.m28316a(componentContext, (TouchSpringIconDrawable) obj, state.e, state.d);
    }

    protected final void mo3150f(ComponentContext componentContext, Object obj, Component component) {
        TouchSpringIconDrawable touchSpringIconDrawable = (TouchSpringIconDrawable) obj;
        Reference.m30532a(componentContext, touchSpringIconDrawable.mo2739a(), ((State) component).e);
        touchSpringIconDrawable.a(null, null);
    }

    public final boolean mo3148h() {
        return true;
    }

    public final boolean mo3143b(Component component, Component component2) {
        Diff a = ComponentLifecycle.m28111a(((State) component).e, ((State) component2).e);
        boolean a2 = Reference.m30533a((Reference) a.a, (Reference) a.b);
        ComponentsPools.m30523a(a);
        return a2;
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 772689796);
        }
    }
}
