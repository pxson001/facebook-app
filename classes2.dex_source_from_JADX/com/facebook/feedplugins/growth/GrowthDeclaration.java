package com.facebook.feedplugins.growth;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.growth.rows.FindFriendsGroupPartDefinition;
import com.facebook.feedplugins.growth.rows.FindFriendsPartDefinition;
import com.facebook.feedplugins.growth.rows.NoContentFeedPartDefinition;
import com.facebook.graphql.model.GraphQLFindFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLNoContentFeedUnit;
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
/* compiled from: last_body_byte_flushed_ratio */
public class GrowthDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static GrowthDeclaration f18146c;
    private static final Object f18147d = new Object();
    private final Lazy<NoContentFeedPartDefinition> f18148a;
    private final Lazy<FindFriendsGroupPartDefinition> f18149b;

    private static GrowthDeclaration m25448b(InjectorLike injectorLike) {
        return new GrowthDeclaration(IdBasedLazy.m1808a(injectorLike, 6342), IdBasedLazy.m1808a(injectorLike, 1910));
    }

    @Inject
    public GrowthDeclaration(Lazy<FindFriendsGroupPartDefinition> lazy, Lazy<NoContentFeedPartDefinition> lazy2) {
        this.f18149b = lazy;
        this.f18148a = lazy2;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(FindFriendsPartDefinition.a);
        listItemRowController.m16558a(NoContentFeedPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLFindFriendsFeedUnit.class, this.f18149b);
        rootPartRegistrationController.m25196a(GraphQLNoContentFeedUnit.class, this.f18148a);
    }

    public static GrowthDeclaration m25447a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GrowthDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18147d) {
                GrowthDeclaration growthDeclaration;
                if (a2 != null) {
                    growthDeclaration = (GrowthDeclaration) a2.mo818a(f18147d);
                } else {
                    growthDeclaration = f18146c;
                }
                if (growthDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25448b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18147d, b3);
                        } else {
                            f18146c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = growthDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
