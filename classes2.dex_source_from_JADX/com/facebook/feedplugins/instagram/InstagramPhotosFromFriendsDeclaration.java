package com.facebook.feedplugins.instagram;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;
import javax.inject.Inject;

@ContextScoped
/* compiled from: last */
public class InstagramPhotosFromFriendsDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static InstagramPhotosFromFriendsDeclaration f18204d;
    private static final Object f18205e = new Object();
    private final Lazy<InstagramPhotosFromFriendsPartDefinition> f18206a;
    private final Lazy<InstagramPromoteUnitPartDefinition> f18207b;
    private final InstagramUtils f18208c;

    private static InstagramPhotosFromFriendsDeclaration m25544b(InjectorLike injectorLike) {
        return new InstagramPhotosFromFriendsDeclaration(IdBasedLazy.m1808a(injectorLike, 6357), IdBasedLazy.m1808a(injectorLike, 6361), InstagramUtils.m22703a(injectorLike));
    }

    @Inject
    public InstagramPhotosFromFriendsDeclaration(Lazy<InstagramPhotosFromFriendsPartDefinition> lazy, Lazy<InstagramPromoteUnitPartDefinition> lazy2, InstagramUtils instagramUtils) {
        this.f18206a = lazy;
        this.f18207b = lazy2;
        this.f18208c = instagramUtils;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(InstagramPromoteUnitHeaderView.a);
        listItemRowController.m16558a(InstagramPhotosFromFriendsHeaderView.a);
        listItemRowController.m16558a(InstagramPhotosFromFriendsFooterView.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        if (this.f18208c.m22725j()) {
            rootPartRegistrationController.m25196a(GraphQLInstagramPhotosFromFriendsFeedUnit.class, this.f18207b);
        } else {
            rootPartRegistrationController.m25196a(GraphQLInstagramPhotosFromFriendsFeedUnit.class, this.f18206a);
        }
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, InstagramPromoteUnitItemView.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, InstagramPhotosFromFriendsItemView.a);
    }

    public static InstagramPhotosFromFriendsDeclaration m25543a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramPhotosFromFriendsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18205e) {
                InstagramPhotosFromFriendsDeclaration instagramPhotosFromFriendsDeclaration;
                if (a2 != null) {
                    instagramPhotosFromFriendsDeclaration = (InstagramPhotosFromFriendsDeclaration) a2.mo818a(f18205e);
                } else {
                    instagramPhotosFromFriendsDeclaration = f18204d;
                }
                if (instagramPhotosFromFriendsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25544b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18205e, b3);
                        } else {
                            f18204d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramPhotosFromFriendsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
