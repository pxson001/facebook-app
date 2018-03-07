package com.facebook.feedplugins.hpp;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.feedplugins.hpp.ui.MobilePageAdminPanelPagePartDefinition;
import com.facebook.feedplugins.hpp.ui.MobilePageAdminPanelSeeAllPagesPartDefinition;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnit;
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
/* compiled from: lastName */
public class MobilePageAdminPanelDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static MobilePageAdminPanelDeclaration f18189b;
    private static final Object f18190c = new Object();
    private final Lazy<MobilePageAdminPanelPartDefinition> f18191a;

    private static MobilePageAdminPanelDeclaration m25520b(InjectorLike injectorLike) {
        return new MobilePageAdminPanelDeclaration(IdBasedLazy.m1808a(injectorLike, 6352));
    }

    @Inject
    public MobilePageAdminPanelDeclaration(Lazy<MobilePageAdminPanelPartDefinition> lazy) {
        this.f18191a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(MobilePageAdminPanelHeaderPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLMobilePageAdminPanelFeedUnit.class, this.f18191a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, MobilePageAdminPanelPagePartDefinition.a);
        RecyclableViewTypeUtil.a(recyclableViewPoolManager, MobilePageAdminPanelSeeAllPagesPartDefinition.a);
    }

    public static MobilePageAdminPanelDeclaration m25519a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MobilePageAdminPanelDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18190c) {
                MobilePageAdminPanelDeclaration mobilePageAdminPanelDeclaration;
                if (a2 != null) {
                    mobilePageAdminPanelDeclaration = (MobilePageAdminPanelDeclaration) a2.mo818a(f18190c);
                } else {
                    mobilePageAdminPanelDeclaration = f18189b;
                }
                if (mobilePageAdminPanelDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25520b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18190c, b3);
                        } else {
                            f18189b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = mobilePageAdminPanelDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
