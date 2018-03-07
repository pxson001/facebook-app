package com.facebook.goodfriends.feedplugins;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLNoContentGoodFriendsFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: jewel_footer_promo_times_shown_total */
public class FeedPluginsDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static FeedPluginsDeclaration f18648b;
    private static final Object f18649c = new Object();
    private final Lazy<NoContentFeedPartDefinition> f18650a;

    private static FeedPluginsDeclaration m26154b(InjectorLike injectorLike) {
        return new FeedPluginsDeclaration(IdBasedLazy.m1808a(injectorLike, 6804));
    }

    @Inject
    public FeedPluginsDeclaration(Lazy<NoContentFeedPartDefinition> lazy) {
        this.f18650a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(NoContentFeedPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLNoContentGoodFriendsFeedUnit.class, this.f18650a);
    }

    public static FeedPluginsDeclaration m26153a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedPluginsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18649c) {
                FeedPluginsDeclaration feedPluginsDeclaration;
                if (a2 != null) {
                    feedPluginsDeclaration = (FeedPluginsDeclaration) a2.mo818a(f18649c);
                } else {
                    feedPluginsDeclaration = f18648b;
                }
                if (feedPluginsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26154b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18649c, b3);
                        } else {
                            f18648b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedPluginsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
