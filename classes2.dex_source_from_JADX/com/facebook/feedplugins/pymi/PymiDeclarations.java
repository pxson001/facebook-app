package com.facebook.feedplugins.pymi;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.pymi.rows.FutureFriendingPagePartDefinition;
import com.facebook.feedplugins.pymi.rows.PaginatedPeopleYouMayInvitePartDefinition;
import com.facebook.feedplugins.pymi.rows.PeopleYouMayInviteMorePartDefinition;
import com.facebook.feedplugins.pymi.rows.PeopleYouMayInvitePagePartDefinition;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
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
/* compiled from: la */
public class PymiDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static PymiDeclarations f18280b;
    private static final Object f18281c = new Object();
    private final Lazy<PaginatedPeopleYouMayInvitePartDefinition> f18282a;

    private static PymiDeclarations m25630b(InjectorLike injectorLike) {
        return new PymiDeclarations(IdBasedLazy.m1808a(injectorLike, 6453));
    }

    @Inject
    public PymiDeclarations(Lazy<PaginatedPeopleYouMayInvitePartDefinition> lazy) {
        this.f18282a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.a(FutureFriendingPagePartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
        recyclableViewPoolManager.a(PeopleYouMayInvitePagePartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
        recyclableViewPoolManager.a(PeopleYouMayInviteMorePartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLPeopleYouMayInviteFeedUnit.class, this.f18282a);
    }

    public static PymiDeclarations m25629a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymiDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18281c) {
                PymiDeclarations pymiDeclarations;
                if (a2 != null) {
                    pymiDeclarations = (PymiDeclarations) a2.mo818a(f18281c);
                } else {
                    pymiDeclarations = f18280b;
                }
                if (pymiDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25630b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18281c, b3);
                        } else {
                            f18280b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = pymiDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
