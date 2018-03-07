package com.facebook.feedplugins.findpages;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLFindPagesFeedUnit;
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
/* compiled from: last_delivered_receipt_time_ms */
public class FindPagesDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static FindPagesDeclaration f18042b;
    private static final Object f18043c = new Object();
    private final Lazy<FindPagesPartDefinition> f18044a;

    private static FindPagesDeclaration m25322b(InjectorLike injectorLike) {
        return new FindPagesDeclaration(IdBasedLazy.m1808a(injectorLike, 6220));
    }

    @Inject
    public FindPagesDeclaration(Lazy<FindPagesPartDefinition> lazy) {
        this.f18044a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(FindPagesPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLFindPagesFeedUnit.class, this.f18044a);
    }

    public static FindPagesDeclaration m25321a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindPagesDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18043c) {
                FindPagesDeclaration findPagesDeclaration;
                if (a2 != null) {
                    findPagesDeclaration = (FindPagesDeclaration) a2.mo818a(f18043c);
                } else {
                    findPagesDeclaration = f18042b;
                }
                if (findPagesDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25322b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18043c, b3);
                        } else {
                            f18042b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = findPagesDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
