package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.util.SparseArray;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$Builder;
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
/* compiled from: http.route.default-proxy */
public class HeaderWithSeeFirstComponentSpec<E extends HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> {
    private static final SparseArray<Object> f20771a = new C08301(1);
    private static HeaderWithSeeFirstComponentSpec f20772d;
    private static final Object f20773e = new Object();
    private final HeaderComponentLayouts<E> f20774b;
    public final HeaderMenuComponentLayouts f20775c;

    /* compiled from: http.route.default-proxy */
    final class C08301 extends SparseArray<Object> {
        C08301(int i) {
            super(i);
            append(2131558757, Boolean.valueOf(true));
        }
    }

    private static HeaderWithSeeFirstComponentSpec m28489b(InjectorLike injectorLike) {
        return new HeaderWithSeeFirstComponentSpec(HeaderComponentLayouts.m28148b(injectorLike), HeaderMenuComponentLayouts.m28491b(injectorLike));
    }

    @Inject
    public HeaderWithSeeFirstComponentSpec(HeaderComponentLayouts headerComponentLayouts, HeaderMenuComponentLayouts headerMenuComponentLayouts) {
        this.f20774b = headerComponentLayouts;
        this.f20775c = headerMenuComponentLayouts;
    }

    public static HeaderWithSeeFirstComponentSpec m28488a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderWithSeeFirstComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20773e) {
                HeaderWithSeeFirstComponentSpec headerWithSeeFirstComponentSpec;
                if (a2 != null) {
                    headerWithSeeFirstComponentSpec = (HeaderWithSeeFirstComponentSpec) a2.mo818a(f20773e);
                } else {
                    headerWithSeeFirstComponentSpec = f20772d;
                }
                if (headerWithSeeFirstComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28489b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20773e, b3);
                        } else {
                            f20772d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerWithSeeFirstComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final ComponentLayout m28490a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        ComponentLayout$Builder a = this.f20774b.m28150a(componentContext, feedProps, e);
        ComponentLayout$Builder a2 = this.f20775c.m28492a(componentContext, feedProps, ((HasMenuButtonProvider) e).mo2448e());
        if (a2 == null) {
            a2 = m28487a(componentContext).mo3336g(7, 2131427607);
        } else {
            a2 = Container.m30723a(componentContext).mo3300C(2).mo3316a(m28487a(componentContext)).mo3316a(a2.mo3346l(2131427606).mo3336g(6, 2131427609).mo3336g(7, 2131427602));
        }
        a.mo3316a(a2);
        return a.mo3343j();
    }

    public static ComponentLayout$Builder m28487a(ComponentContext componentContext) {
        return Image.m31069a(componentContext).m31092h(2130843313).m30663c().mo3310a(f20771a).mo3358t(2131233596).mo3354p(2131427606).mo3336g(1, 2131427603).mo3336g(3, 2131427604);
    }
}
