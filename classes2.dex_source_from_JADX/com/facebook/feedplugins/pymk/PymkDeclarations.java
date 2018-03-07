package com.facebook.feedplugins.pymk;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.pymk.rows.CCUPromoCardPartDefinition;
import com.facebook.feedplugins.pymk.rows.PaginatedPeopleYouMayKnowPartDefinition;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowQuickPromotionPartDefinition;
import com.facebook.feedplugins.pymk.rows.PersonYouMayKnowPagePartDefinition;
import com.facebook.feedplugins.pymk.rows.PymkLoadingPartDefinition;
import com.facebook.feedplugins.pymk.rows.PymkSeeAllPartDefinition;
import com.facebook.feedplugins.pymk.rows.QuickPromotionPeopleYouMayKnowHeaderPartDefinition;
import com.facebook.feedplugins.pymk.rows.QuickPromotionPeopleYouMayKnowPartDefinition;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLQuickPromotionPeopleYouMayKnowFeedUnit;
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
/* compiled from: kvm/ */
public class PymkDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static PymkDeclarations f18316c;
    private static final Object f18317d = new Object();
    private final Lazy<PaginatedPeopleYouMayKnowPartDefinition> f18318a;
    private final Lazy<QuickPromotionPeopleYouMayKnowPartDefinition> f18319b;

    private static PymkDeclarations m25681b(InjectorLike injectorLike) {
        return new PymkDeclarations(IdBasedLazy.m1808a(injectorLike, 6462), IdBasedLazy.m1808a(injectorLike, 6471));
    }

    @Inject
    public PymkDeclarations(Lazy<PaginatedPeopleYouMayKnowPartDefinition> lazy, Lazy<QuickPromotionPeopleYouMayKnowPartDefinition> lazy2) {
        this.f18318a = lazy;
        this.f18319b = lazy2;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(PeopleYouMayKnowQuickPromotionPartDefinition.a);
        listItemRowController.m16558a(QuickPromotionPeopleYouMayKnowHeaderPartDefinition.a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.a(PersonYouMayKnowPagePartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
        recyclableViewPoolManager.a(PymkSeeAllPartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
        recyclableViewPoolManager.a(PymkLoadingPartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
        recyclableViewPoolManager.a(CCUPromoCardPartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
    }

    public static PymkDeclarations m25680a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymkDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18317d) {
                PymkDeclarations pymkDeclarations;
                if (a2 != null) {
                    pymkDeclarations = (PymkDeclarations) a2.mo818a(f18317d);
                } else {
                    pymkDeclarations = f18316c;
                }
                if (pymkDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25681b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18317d, b3);
                        } else {
                            f18316c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = pymkDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class, this.f18318a);
        rootPartRegistrationController.m25196a(GraphQLQuickPromotionPeopleYouMayKnowFeedUnit.class, this.f18319b);
    }
}
