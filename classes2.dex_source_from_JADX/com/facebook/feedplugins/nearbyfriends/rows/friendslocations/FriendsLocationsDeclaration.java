package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
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
/* compiled from: language_switcher/ */
public class FriendsLocationsDeclaration implements RootPartsDeclaration {
    private static FriendsLocationsDeclaration f18240b;
    private static final Object f18241c = new Object();
    private final Lazy<FriendsLocationsPartDefinition> f18242a;

    private static FriendsLocationsDeclaration m25567b(InjectorLike injectorLike) {
        return new FriendsLocationsDeclaration(IdBasedLazy.m1808a(injectorLike, 6410));
    }

    @Inject
    public FriendsLocationsDeclaration(Lazy<FriendsLocationsPartDefinition> lazy) {
        this.f18242a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLFriendsLocationsFeedUnit.class, this.f18242a);
    }

    public static FriendsLocationsDeclaration m25566a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18241c) {
                FriendsLocationsDeclaration friendsLocationsDeclaration;
                if (a2 != null) {
                    friendsLocationsDeclaration = (FriendsLocationsDeclaration) a2.mo818a(f18241c);
                } else {
                    friendsLocationsDeclaration = f18240b;
                }
                if (friendsLocationsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25567b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18241c, b3);
                        } else {
                            f18240b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
