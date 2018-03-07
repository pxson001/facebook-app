package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: image_medium_height */
public class FollowableHeaderComponentSpec<E extends CanFollowUser & HasContext & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey> {
    private static FollowableHeaderComponentSpec f20398c;
    private static final Object f20399d = new Object();
    public final HeaderComponentLayouts<E> f20400a;
    public final FollowButtonComponent<E> f20401b;

    private static FollowableHeaderComponentSpec m28147b(InjectorLike injectorLike) {
        return new FollowableHeaderComponentSpec(HeaderComponentLayouts.m28148b(injectorLike), FollowButtonComponent.m28294a(injectorLike));
    }

    @Inject
    public FollowableHeaderComponentSpec(HeaderComponentLayouts headerComponentLayouts, FollowButtonComponent followButtonComponent) {
        this.f20400a = headerComponentLayouts;
        this.f20401b = followButtonComponent;
    }

    public static FollowableHeaderComponentSpec m28146a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowableHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20399d) {
                FollowableHeaderComponentSpec followableHeaderComponentSpec;
                if (a2 != null) {
                    followableHeaderComponentSpec = (FollowableHeaderComponentSpec) a2.mo818a(f20399d);
                } else {
                    followableHeaderComponentSpec = f20398c;
                }
                if (followableHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28147b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20399d, b3);
                        } else {
                            f20398c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followableHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
