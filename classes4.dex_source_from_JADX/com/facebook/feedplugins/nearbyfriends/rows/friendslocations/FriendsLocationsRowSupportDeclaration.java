package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

@ContextScoped
/* compiled from: null_listener */
public class FriendsLocationsRowSupportDeclaration implements FeedRowSupportDeclaration, RecyclableViewsDeclaration {
    private static FriendsLocationsRowSupportDeclaration f6647a;
    private static final Object f6648b = new Object();

    private static FriendsLocationsRowSupportDeclaration m7047a() {
        return new FriendsLocationsRowSupportDeclaration();
    }

    public final void m7049a(ListItemRowController listItemRowController) {
        listItemRowController.a(FriendsLocationsSubtitlePartDefinition.a);
    }

    public final void m7050a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.m6979a(recyclableViewPoolManager, FriendsNearbyItemPartDefinition.f6649a);
    }

    public static FriendsLocationsRowSupportDeclaration m7048a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsRowSupportDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f6648b) {
                FriendsLocationsRowSupportDeclaration friendsLocationsRowSupportDeclaration;
                if (a3 != null) {
                    friendsLocationsRowSupportDeclaration = (FriendsLocationsRowSupportDeclaration) a3.a(f6648b);
                } else {
                    friendsLocationsRowSupportDeclaration = f6647a;
                }
                if (friendsLocationsRowSupportDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m7047a();
                        if (a3 != null) {
                            a3.a(f6648b, a2);
                        } else {
                            f6647a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = friendsLocationsRowSupportDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
