package com.facebook.feedplugins.gts;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.gts.rows.GroupTopStoriesPartDefinition;
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnit;
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
/* compiled from: last_asset_flush_xconfig_ver */
public class GtsDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static GtsDeclarations f18158b;
    private static final Object f18159c = new Object();
    private final Lazy<GroupTopStoriesPartDefinition> f18160a;

    private static GtsDeclarations m25468b(InjectorLike injectorLike) {
        return new GtsDeclarations(IdBasedLazy.m1808a(injectorLike, 6345));
    }

    @Inject
    public GtsDeclarations(Lazy<GroupTopStoriesPartDefinition> lazy) {
        this.f18160a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLGroupTopStoriesFeedUnit.class, this.f18160a);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
    }

    public static GtsDeclarations m25467a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GtsDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18159c) {
                GtsDeclarations gtsDeclarations;
                if (a2 != null) {
                    gtsDeclarations = (GtsDeclarations) a2.mo818a(f18159c);
                } else {
                    gtsDeclarations = f18158b;
                }
                if (gtsDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25468b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18159c, b3);
                        } else {
                            f18158b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = gtsDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
