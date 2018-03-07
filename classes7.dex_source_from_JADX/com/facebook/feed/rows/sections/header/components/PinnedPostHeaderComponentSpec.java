package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Image;
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
/* compiled from: Unexpected error loading stream */
public class PinnedPostHeaderComponentSpec<E extends HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPrefetcher & HasRowKey> {
    private static PinnedPostHeaderComponentSpec f21390b;
    private static final Object f21391c = new Object();
    private final DefaultHeaderComponent<E> f21392a;

    private static PinnedPostHeaderComponentSpec m24112b(InjectorLike injectorLike) {
        return new PinnedPostHeaderComponentSpec(DefaultHeaderComponent.a(injectorLike));
    }

    @Inject
    public PinnedPostHeaderComponentSpec(DefaultHeaderComponent defaultHeaderComponent) {
        this.f21392a = defaultHeaderComponent;
    }

    protected final ComponentLayout m24113a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        return Container.a(componentContext).a(this.f21392a.a(componentContext).a(feedProps).a((HasFeedListType) e).d()).a(Image.a(componentContext).h(2130842661).c().b(1).g(componentContext.getResources().getDimensionPixelSize(2131432266)).e(0).j()).j();
    }

    public static PinnedPostHeaderComponentSpec m24111a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PinnedPostHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21391c) {
                PinnedPostHeaderComponentSpec pinnedPostHeaderComponentSpec;
                if (a2 != null) {
                    pinnedPostHeaderComponentSpec = (PinnedPostHeaderComponentSpec) a2.a(f21391c);
                } else {
                    pinnedPostHeaderComponentSpec = f21390b;
                }
                if (pinnedPostHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24112b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21391c, b3);
                        } else {
                            f21390b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pinnedPostHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
