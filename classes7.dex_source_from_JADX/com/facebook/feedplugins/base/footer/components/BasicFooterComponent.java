package com.facebook.feedplugins.base.footer.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.reference.DrawableReference;
import com.facebook.components.reference.Reference;
import com.facebook.components.widget.SolidColor;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterBackgroundStyleDefinition;
import com.facebook.feedplugins.base.footer.components.BasicFooterButtonsComponent.Builder;
import com.facebook.feedplugins.base.footer.components.BasicFooterComponent$java.lang.Object;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TAG_EXPANSION_VIEW */
public class BasicFooterComponent<E extends HasFeedListType & HasPersistentState> extends ComponentLifecycle {
    private static BasicFooterComponent f22990d;
    private static final Object f22991e = new Object();
    private final BasicFooterComponentSpec f22992b;
    private final SynchronizedPool<Object> f22993c = new SynchronizedPool(2);

    /* compiled from: TAG_EXPANSION_VIEW */
    class State extends Component<BasicFooterComponent> implements Cloneable {
        FeedProps<GraphQLStory> f22987a;
        FooterBackgroundStyleDefinition f22988b;
        E f22989c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b) {
                return true;
            }
            if (this.f22987a == null ? state.f22987a != null : !this.f22987a.equals(state.f22987a)) {
                return false;
            }
            if (this.f22988b == null ? state.f22988b != null : !this.f22988b.equals(state.f22988b)) {
                return false;
            }
            if (this.f22989c != null) {
                if (this.f22989c.equals(state.f22989c)) {
                    return true;
                }
            } else if (state.f22989c == null) {
                return true;
            }
            return false;
        }
    }

    private static BasicFooterComponent m25479b(InjectorLike injectorLike) {
        return new BasicFooterComponent(BasicFooterComponentSpec.m25482a(injectorLike));
    }

    @Inject
    public BasicFooterComponent(BasicFooterComponentSpec basicFooterComponentSpec) {
        this.f22992b = basicFooterComponentSpec;
    }

    public static BasicFooterComponent m25478a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22991e) {
                BasicFooterComponent basicFooterComponent;
                if (a2 != null) {
                    basicFooterComponent = (BasicFooterComponent) a2.a(f22991e);
                } else {
                    basicFooterComponent = f22990d;
                }
                if (basicFooterComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25479b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22991e, b3);
                        } else {
                            f22990d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m25481b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        BasicFooterComponentSpec basicFooterComponentSpec = this.f22992b;
        FeedProps feedProps = state.f22987a;
        FooterBackgroundStyleDefinition footerBackgroundStyleDefinition = state.f22988b;
        HasFeedListType hasFeedListType = state.f22989c;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        ContainerBuilder o = Container.a(componentContext).o(1, (int) footerBackgroundStyleDefinition.c.b).o(3, (int) footerBackgroundStyleDefinition.c.c).o(5, (int) footerBackgroundStyleDefinition.c.a);
        if (footerBackgroundStyleDefinition.g.equals(DividerStyle.VISIBLE)) {
            o.a(SolidColor.m1358a(componentContext).m1357h(2131362761).c().p(2131427379).c(5, 2131427642));
        }
        GraphQLStorySeenState a = basicFooterComponentSpec.f22998c.a(feedProps);
        Drawable b = footerBackgroundStyleDefinition.b(componentContext.getResources(), a);
        basicFooterComponentSpec.f22998c.a(feedProps, b);
        Reference b2 = DrawableReference.b().a(b).b();
        int a2 = basicFooterComponentSpec.f22999d.a(footerBackgroundStyleDefinition);
        Builder a3 = basicFooterComponentSpec.f22997b.m25472a(componentContext);
        a3.f22963a.f22968a = feedProps;
        a3.f22967e.set(0);
        a3 = a3;
        a3.f22963a.f22974g = hasFeedListType;
        a3.f22967e.set(6);
        a3 = a3;
        a3.f22963a.f22969b = graphQLStory.z();
        a3.f22967e.set(1);
        a3 = a3;
        a3.f22963a.f22970c = graphQLStory.A();
        a3.f22967e.set(2);
        a3 = a3;
        a3.f22963a.f22971d = StorySharingHelper.b(graphQLStory);
        a3.f22967e.set(3);
        Builder builder = a3;
        builder.f22963a.f22972e = footerBackgroundStyleDefinition.f;
        builder.f22967e.set(4);
        builder = builder;
        builder.f22963a.f22973f = a2;
        builder.f22967e.set(5);
        o.a(builder.c().a(b2));
        if (footerBackgroundStyleDefinition.h.equals(DividerStyle.VISIBLE)) {
            o.a(SolidColor.m1358a(componentContext).m1357h(2131362791).c().p(2131427379));
        }
        b = footerBackgroundStyleDefinition.a(componentContext.getResources(), a);
        basicFooterComponentSpec.f22998c.a(feedProps, b);
        return o.b(DrawableReference.b().a(b).b()).b(BasicFooterComponentSpec.f22994a).j();
    }

    public final void m25480a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ BasicFooterComponent f22986c;

                public void run() {
                    this.f22986c.a(eventHandler, obj);
                }
            }, 684898011);
        }
    }
}
