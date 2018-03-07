package com.facebook.feedplugins.egolistview.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.egolistview.views.GroupsYouShouldJoinPageView;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
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
/* compiled from: last_fetch_time_ms */
public class GysjDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static GysjDeclarations f18007b;
    private static final Object f18008c = new Object();
    private final Lazy<GroupYouShouldJoinPartDefinition> f18009a;

    private static GysjDeclarations m25267b(InjectorLike injectorLike) {
        return new GysjDeclarations(IdBasedLazy.m1808a(injectorLike, 6207));
    }

    @Inject
    public GysjDeclarations(Lazy<GroupYouShouldJoinPartDefinition> lazy) {
        this.f18009a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(GroupsYouShouldJoinFooterPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLGroupsYouShouldJoinFeedUnit.class, this.f18009a);
        rootPartRegistrationController.m25196a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class, this.f18009a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.a(GroupsYouShouldJoinPageView.class, RecyclableViewPoolManager.a, RecyclableViewPoolManager.e);
    }

    public static GysjDeclarations m25266a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GysjDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18008c) {
                GysjDeclarations gysjDeclarations;
                if (a2 != null) {
                    gysjDeclarations = (GysjDeclarations) a2.mo818a(f18008c);
                } else {
                    gysjDeclarations = f18007b;
                }
                if (gysjDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25267b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18008c, b3);
                        } else {
                            f18007b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = gysjDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
