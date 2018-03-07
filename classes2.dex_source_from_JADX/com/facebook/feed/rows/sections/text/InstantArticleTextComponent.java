package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: home_team_fan_count */
public class InstantArticleTextComponent<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState> extends ComponentLifecycle {
    private static InstantArticleTextComponent f20905d;
    private static final Object f20906e = new Object();
    private final InstantArticleTextComponentSpec f20907b;
    public final Pools$SynchronizedPool<Builder> f20908c = new Pools$SynchronizedPool(2);

    private static InstantArticleTextComponent m28635b(InjectorLike injectorLike) {
        return new InstantArticleTextComponent(InstantArticleTextComponentSpec.m28638a(injectorLike));
    }

    @Inject
    public InstantArticleTextComponent(InstantArticleTextComponentSpec instantArticleTextComponentSpec) {
        this.f20907b = instantArticleTextComponentSpec;
    }

    public static InstantArticleTextComponent m28633a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleTextComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20906e) {
                InstantArticleTextComponent instantArticleTextComponent;
                if (a2 != null) {
                    instantArticleTextComponent = (InstantArticleTextComponent) a2.mo818a(f20906e);
                } else {
                    instantArticleTextComponent = f20905d;
                }
                if (instantArticleTextComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28635b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20906e, b3);
                        } else {
                            f20905d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleTextComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        InstantArticleTextComponentSpec instantArticleTextComponentSpec = this.f20907b;
        FeedProps feedProps = state.a;
        return instantArticleTextComponentSpec.f20911a.m28642a(componentContext).a(feedProps).a(state.b).m30663c().mo3311a(ComponentLifecycle.m28112a(componentContext, 782112918, null)).mo3343j();
    }

    private void m28634a(View view, Component component) {
        State state = (State) component;
        InstantArticleTextComponentSpec instantArticleTextComponentSpec = this.f20907b;
        InstantArticleClickWithPositionListener instantArticleClickWithPositionListener = (InstantArticleClickWithPositionListener) instantArticleTextComponentSpec.f20913c.get();
        instantArticleClickWithPositionListener.b = InstantArticleClickTextPartDefinition.m28580a((GraphQLStory) state.a.f13444a);
        instantArticleClickWithPositionListener.a(view, 0.0f, 0.0f);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 222366327);
            return;
        }
        switch (eventHandler.f22608b) {
            case 782112918:
                m28634a(((ClickEvent) obj).a, eventHandler.f22607a);
                return;
            default:
                return;
        }
    }
}
