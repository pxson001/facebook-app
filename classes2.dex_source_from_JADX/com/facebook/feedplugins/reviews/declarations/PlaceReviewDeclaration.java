package com.facebook.feedplugins.reviews.declarations;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.feedplugins.reviews.rows.PlaceReviewPageItemPartDefinition;
import com.facebook.feedplugins.reviews.rows.PlaceReviewPartDefinition;
import com.facebook.feedplugins.reviews.views.PlaceReviewItemView;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
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
/* compiled from: key_process_name */
public class PlaceReviewDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static PlaceReviewDeclaration f18454b;
    private static final Object f18455c = new Object();
    private Lazy<PlaceReviewPartDefinition> f18456a;

    private static PlaceReviewDeclaration m25900b(InjectorLike injectorLike) {
        return new PlaceReviewDeclaration(IdBasedLazy.m1808a(injectorLike, 6531));
    }

    @Inject
    public PlaceReviewDeclaration(Lazy<PlaceReviewPartDefinition> lazy) {
        this.f18456a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLPlaceReviewFeedUnit.class, this.f18456a);
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(PlaceReviewItemView.a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, PlaceReviewPageItemPartDefinition.a);
    }

    public static PlaceReviewDeclaration m25899a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18455c) {
                PlaceReviewDeclaration placeReviewDeclaration;
                if (a2 != null) {
                    placeReviewDeclaration = (PlaceReviewDeclaration) a2.mo818a(f18455c);
                } else {
                    placeReviewDeclaration = f18454b;
                }
                if (placeReviewDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25900b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18455c, b3);
                        } else {
                            f18454b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
