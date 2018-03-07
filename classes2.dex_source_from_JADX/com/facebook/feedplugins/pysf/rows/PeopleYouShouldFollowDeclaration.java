package com.facebook.feedplugins.pysf.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
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
/* compiled from: km_KH */
public class PeopleYouShouldFollowDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static PeopleYouShouldFollowDeclaration f18383b;
    private static final Object f18384c = new Object();
    private final Lazy<PeopleYouShouldFollowPartDefinition> f18385a;

    private static PeopleYouShouldFollowDeclaration m25792b(InjectorLike injectorLike) {
        return new PeopleYouShouldFollowDeclaration(IdBasedLazy.m1808a(injectorLike, 6496));
    }

    @Inject
    public PeopleYouShouldFollowDeclaration(Lazy<PeopleYouShouldFollowPartDefinition> lazy) {
        this.f18385a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(PersonYouShouldFollowPagePartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLPeopleYouShouldFollowFeedUnit.class, this.f18385a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PersonYouShouldFollowPagePartDefinition.a);
    }

    public static PeopleYouShouldFollowDeclaration m25791a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouShouldFollowDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18384c) {
                PeopleYouShouldFollowDeclaration peopleYouShouldFollowDeclaration;
                if (a2 != null) {
                    peopleYouShouldFollowDeclaration = (PeopleYouShouldFollowDeclaration) a2.mo818a(f18384c);
                } else {
                    peopleYouShouldFollowDeclaration = f18383b;
                }
                if (peopleYouShouldFollowDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25792b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18384c, b3);
                        } else {
                            f18383b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouShouldFollowDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
