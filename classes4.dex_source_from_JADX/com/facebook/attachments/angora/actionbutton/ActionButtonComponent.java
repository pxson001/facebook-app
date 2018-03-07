package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: net_duration */
public class ActionButtonComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f7250b = new SynchronizedPool(2);
    private static ActionButtonComponent f7251d;
    private static final Object f7252e = new Object();
    private final ActionButtonComponentSpec f7253c;

    private static ActionButtonComponent m7578b(InjectorLike injectorLike) {
        return new ActionButtonComponent(ActionButtonComponentSpec.m7582a(injectorLike));
    }

    public static ActionButtonComponent m7576a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActionButtonComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7252e) {
                ActionButtonComponent actionButtonComponent;
                if (a2 != null) {
                    actionButtonComponent = (ActionButtonComponent) a2.a(f7252e);
                } else {
                    actionButtonComponent = f7251d;
                }
                if (actionButtonComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7578b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7252e, b3);
                        } else {
                            f7251d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = actionButtonComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ActionButtonComponent(ActionButtonComponentSpec actionButtonComponentSpec) {
        this.f7253c = actionButtonComponentSpec;
    }

    public final Builder m7579a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f7250b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m7581b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f7253c.m7584a(componentContext, state.a, state.b, state.c, state.d, state.e, state.f, state.g, state.h, state.i, state.j);
    }

    public static EventHandler m7577a(ComponentContext componentContext, OnClickListener onClickListener) {
        return ComponentLifecycle.a(componentContext, 1364419525, new Object[]{onClickListener});
    }

    public final void m7580a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new 1(this, eventHandler, obj), -589052437);
            return;
        }
        switch (eventHandler.b) {
            case 1364419525:
                View view = ((ClickEvent) obj).a;
                OnClickListener onClickListener = (OnClickListener) eventHandler.c[0];
                Component component = eventHandler.a;
                onClickListener.onClick(view);
                return;
            default:
                return;
        }
    }
}
