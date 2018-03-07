package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
/* compiled from: hr */
public class DefaultHeaderComponentSpec<E extends HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> {
    private static DefaultHeaderComponentSpec f20824c;
    private static final Object f20825d = new Object();
    private final HeaderComponentLayouts<E> f20826a;
    private final HeaderMenuComponentLayouts f20827b;

    private static DefaultHeaderComponentSpec m28553b(InjectorLike injectorLike) {
        return new DefaultHeaderComponentSpec(HeaderComponentLayouts.m28148b(injectorLike), HeaderMenuComponentLayouts.m28491b(injectorLike));
    }

    @Inject
    public DefaultHeaderComponentSpec(HeaderComponentLayouts headerComponentLayouts, HeaderMenuComponentLayouts headerMenuComponentLayouts) {
        this.f20826a = headerComponentLayouts;
        this.f20827b = headerMenuComponentLayouts;
    }

    protected final ComponentLayout m28554a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e, boolean z) {
        ComponentLayout$Builder a = this.f20826a.m28150a(componentContext, feedProps, e);
        if (!z) {
            a.mo3316a(this.f20827b.m28492a(componentContext, feedProps, ((HasMenuButtonProvider) e).mo2448e()));
        }
        return a.mo3343j();
    }

    public static DefaultHeaderComponentSpec m28552a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20825d) {
                DefaultHeaderComponentSpec defaultHeaderComponentSpec;
                if (a2 != null) {
                    defaultHeaderComponentSpec = (DefaultHeaderComponentSpec) a2.mo818a(f20825d);
                } else {
                    defaultHeaderComponentSpec = f20824c;
                }
                if (defaultHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28553b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20825d, b3);
                        } else {
                            f20824c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
