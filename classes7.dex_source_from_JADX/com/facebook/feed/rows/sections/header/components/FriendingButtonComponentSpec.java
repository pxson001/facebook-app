package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: Universal Feedback CANCELLED! */
public class FriendingButtonComponentSpec<E extends CanFriendPerson & HasInvalidate & HasPersistentState> {
    private static FriendingButtonComponentSpec f21308c;
    private static final Object f21309d = new Object();
    public final NewsFeedAnalyticsEventBuilder f21310a;
    public final AnalyticsLogger f21311b;

    private static FriendingButtonComponentSpec m24077b(InjectorLike injectorLike) {
        return new FriendingButtonComponentSpec(NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendingButtonComponentSpec(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
        this.f21310a = newsFeedAnalyticsEventBuilder;
        this.f21311b = analyticsLogger;
    }

    public static FriendingButtonComponentSpec m24076a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendingButtonComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21309d) {
                FriendingButtonComponentSpec friendingButtonComponentSpec;
                if (a2 != null) {
                    friendingButtonComponentSpec = (FriendingButtonComponentSpec) a2.a(f21309d);
                } else {
                    friendingButtonComponentSpec = f21308c;
                }
                if (friendingButtonComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24077b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21309d, b3);
                        } else {
                            f21308c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendingButtonComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
