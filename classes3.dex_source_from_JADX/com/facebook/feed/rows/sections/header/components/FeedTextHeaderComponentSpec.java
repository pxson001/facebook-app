package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: video_channel_unfollow_data */
public class FeedTextHeaderComponentSpec<E extends HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasContext> {
    private static FeedTextHeaderComponentSpec f4c;
    private static final Object f5d = new Object();
    private final HeaderTitleComponent<E> f6a;
    private final HeaderMenuComponentLayouts f7b;

    private static FeedTextHeaderComponentSpec m5b(InjectorLike injectorLike) {
        return new FeedTextHeaderComponentSpec(HeaderTitleComponent.a(injectorLike), HeaderMenuComponentLayouts.b(injectorLike));
    }

    @Inject
    public FeedTextHeaderComponentSpec(HeaderTitleComponent headerTitleComponent, HeaderMenuComponentLayouts headerMenuComponentLayouts) {
        this.f6a = headerTitleComponent;
        this.f7b = headerMenuComponentLayouts;
    }

    protected final ComponentLayout m6a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        return Container.a(componentContext).C(2).E(1).a(this.f6a.a(componentContext).a(feedProps).a((HasPersistentState) e).c().a(1.0f).c(1, 2131428829)).a(this.f7b.a(componentContext, feedProps, ((HasMenuButtonProvider) e).e())).j();
    }

    public static FeedTextHeaderComponentSpec m4a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedTextHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5d) {
                FeedTextHeaderComponentSpec feedTextHeaderComponentSpec;
                if (a2 != null) {
                    feedTextHeaderComponentSpec = (FeedTextHeaderComponentSpec) a2.a(f5d);
                } else {
                    feedTextHeaderComponentSpec = f4c;
                }
                if (feedTextHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5d, b3);
                        } else {
                            f4c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedTextHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
