package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
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
/* compiled from: home_stories_sort_key_index */
public class ContentTextComponent<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState> extends ComponentLifecycle {
    private static ContentTextComponent f20914d;
    private static final Object f20915e = new Object();
    private final ContentTextComponentSpec f20916b;
    public final Pools$SynchronizedPool<Builder> f20917c = new Pools$SynchronizedPool(2);

    private static ContentTextComponent m28641b(InjectorLike injectorLike) {
        return new ContentTextComponent(ContentTextComponentSpec.m28645a(injectorLike));
    }

    public static ContentTextComponent m28640a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentTextComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20915e) {
                ContentTextComponent contentTextComponent;
                if (a2 != null) {
                    contentTextComponent = (ContentTextComponent) a2.mo818a(f20915e);
                } else {
                    contentTextComponent = f20914d;
                }
                if (contentTextComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28641b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20915e, b3);
                        } else {
                            f20914d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = contentTextComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ContentTextComponent(ContentTextComponentSpec contentTextComponentSpec) {
        this.f20916b = contentTextComponentSpec;
    }

    public final Builder m28642a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20917c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20916b.m28647a(componentContext, state.a, state.b, state.c, state.d, state.e, state.f, state.g, state.h);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), -971496344);
        }
    }
}
