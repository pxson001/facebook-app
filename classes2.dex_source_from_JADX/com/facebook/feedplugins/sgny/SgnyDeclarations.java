package com.facebook.feedplugins.sgny;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.sgny.rows.SaleGroupsNearYouFooterPartDefinition;
import com.facebook.feedplugins.sgny.rows.SaleGroupsNearYouPagePartDefinition;
import com.facebook.feedplugins.sgny.rows.SaleGroupsNearYouPartDefinition;
import com.facebook.feedplugins.sgny.views.SaleGroupsNearYouPageView;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
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
/* compiled from: key_hash */
public class SgnyDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static SgnyDeclarations f18470b;
    private static final Object f18471c = new Object();
    private final Lazy<SaleGroupsNearYouPartDefinition> f18472a;

    private static SgnyDeclarations m25926b(InjectorLike injectorLike) {
        return new SgnyDeclarations(IdBasedLazy.m1808a(injectorLike, 6555));
    }

    @Inject
    public SgnyDeclarations(Lazy<SaleGroupsNearYouPartDefinition> lazy) {
        this.f18472a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(SaleGroupsNearYouFooterPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLSaleGroupsNearYouFeedUnit.class, this.f18472a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.a(SaleGroupsNearYouPageView.class, RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
        recyclableViewPoolManager.a(SaleGroupsNearYouPagePartDefinition.a.getClass(), RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
    }

    public static SgnyDeclarations m25925a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SgnyDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18471c) {
                SgnyDeclarations sgnyDeclarations;
                if (a2 != null) {
                    sgnyDeclarations = (SgnyDeclarations) a2.mo818a(f18471c);
                } else {
                    sgnyDeclarations = f18470b;
                }
                if (sgnyDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25926b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18471c, b3);
                        } else {
                            f18470b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = sgnyDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
