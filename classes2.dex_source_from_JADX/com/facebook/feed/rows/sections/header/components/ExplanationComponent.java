package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friending_blacklist_people_you_may_know */
public class ExplanationComponent<E extends HasInvalidate & HasMenuButtonProvider & HasPersistentState> extends ComponentLifecycle {
    private static ExplanationComponent f23139d;
    private static final Object f23140e = new Object();
    private final ExplanationComponentSpec f23141b;
    public final Pools$SynchronizedPool<Builder> f23142c = new Pools$SynchronizedPool(2);

    private static ExplanationComponent m31253b(InjectorLike injectorLike) {
        return new ExplanationComponent(ExplanationComponentSpec.m31257a(injectorLike));
    }

    @Inject
    public ExplanationComponent(ExplanationComponentSpec explanationComponentSpec) {
        this.f23141b = explanationComponentSpec;
    }

    public static ExplanationComponent m31252a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23140e) {
                ExplanationComponent explanationComponent;
                if (a2 != null) {
                    explanationComponent = (ExplanationComponent) a2.mo818a(f23140e);
                } else {
                    explanationComponent = f23139d;
                }
                if (explanationComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31253b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23140e, b3);
                        } else {
                            f23139d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m31254a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f23142c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f23141b.m31259a(componentContext, state.a, state.b, state.c);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 391450529);
        }
    }
}
