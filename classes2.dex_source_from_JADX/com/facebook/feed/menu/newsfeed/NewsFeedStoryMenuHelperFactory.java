package com.facebook.feed.menu.newsfeed;

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
/* compiled from: new_conn_timeout */
public class NewsFeedStoryMenuHelperFactory implements BaseFeedStoryMenuHelperFactory {
    private static NewsFeedStoryMenuHelperFactory f12312b;
    private static final Object f12313c = new Object();
    private final NewsFeedStoryMenuHelperProvider f12314a;

    private static NewsFeedStoryMenuHelperFactory m18362b(InjectorLike injectorLike) {
        return new NewsFeedStoryMenuHelperFactory((NewsFeedStoryMenuHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NewsFeedStoryMenuHelperProvider.class));
    }

    @Inject
    public NewsFeedStoryMenuHelperFactory(NewsFeedStoryMenuHelperProvider newsFeedStoryMenuHelperProvider) {
        this.f12314a = newsFeedStoryMenuHelperProvider;
    }

    public final BaseFeedStoryMenuHelper mo2464a(FeedEnvironment feedEnvironment) {
        return this.f12314a.m18365a(feedEnvironment);
    }

    public static NewsFeedStoryMenuHelperFactory m18361a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NewsFeedStoryMenuHelperFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f12313c) {
                NewsFeedStoryMenuHelperFactory newsFeedStoryMenuHelperFactory;
                if (a2 != null) {
                    newsFeedStoryMenuHelperFactory = (NewsFeedStoryMenuHelperFactory) a2.mo818a(f12313c);
                } else {
                    newsFeedStoryMenuHelperFactory = f12312b;
                }
                if (newsFeedStoryMenuHelperFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m18362b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f12313c, b3);
                        } else {
                            f12312b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = newsFeedStoryMenuHelperFactory;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
