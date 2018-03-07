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
/* compiled from: friending_add_friend_list_member */
public class ExplanationTextComponent<E extends HasInvalidate & HasPersistentState> extends ComponentLifecycle {
    private static ExplanationTextComponent f23147d;
    private static final Object f23148e = new Object();
    private final ExplanationTextComponentSpec f23149b;
    public final Pools$SynchronizedPool<Builder> f23150c = new Pools$SynchronizedPool(2);

    private static ExplanationTextComponent m31261b(InjectorLike injectorLike) {
        return new ExplanationTextComponent(ExplanationTextComponentSpec.m31264a(injectorLike));
    }

    @Inject
    public ExplanationTextComponent(ExplanationTextComponentSpec explanationTextComponentSpec) {
        this.f23149b = explanationTextComponentSpec;
    }

    public static ExplanationTextComponent m31260a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationTextComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23148e) {
                ExplanationTextComponent explanationTextComponent;
                if (a2 != null) {
                    explanationTextComponent = (ExplanationTextComponent) a2.mo818a(f23148e);
                } else {
                    explanationTextComponent = f23147d;
                }
                if (explanationTextComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31261b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23148e, b3);
                        } else {
                            f23147d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationTextComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f23149b.m31266a(componentContext, state.a, state.b, state.c, state.d, state.e);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), -364736216);
        }
    }
}
