package com.facebook.feed.menu.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelperFactory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: group_leave */
public class PermalinkFeedStoryMenuHelperFactory implements BaseFeedStoryMenuHelperFactory {
    private static PermalinkFeedStoryMenuHelperFactory f11925b;
    private static final Object f11926c = new Object();
    private final PermalinkFeedStoryMenuHelperProvider f11927a;

    private static PermalinkFeedStoryMenuHelperFactory m14018b(InjectorLike injectorLike) {
        return new PermalinkFeedStoryMenuHelperFactory((PermalinkFeedStoryMenuHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PermalinkFeedStoryMenuHelperProvider.class));
    }

    @Inject
    public PermalinkFeedStoryMenuHelperFactory(PermalinkFeedStoryMenuHelperProvider permalinkFeedStoryMenuHelperProvider) {
        this.f11927a = permalinkFeedStoryMenuHelperProvider;
    }

    public final BaseFeedStoryMenuHelper m14019a(FeedEnvironment feedEnvironment) {
        return this.f11927a.m14020a(feedEnvironment);
    }

    public static PermalinkFeedStoryMenuHelperFactory m14017a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkFeedStoryMenuHelperFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11926c) {
                PermalinkFeedStoryMenuHelperFactory permalinkFeedStoryMenuHelperFactory;
                if (a2 != null) {
                    permalinkFeedStoryMenuHelperFactory = (PermalinkFeedStoryMenuHelperFactory) a2.a(f11926c);
                } else {
                    permalinkFeedStoryMenuHelperFactory = f11925b;
                }
                if (permalinkFeedStoryMenuHelperFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14018b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11926c, b3);
                        } else {
                            f11925b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkFeedStoryMenuHelperFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
