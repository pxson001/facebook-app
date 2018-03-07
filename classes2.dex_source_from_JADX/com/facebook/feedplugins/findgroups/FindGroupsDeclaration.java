package com.facebook.feedplugins.findgroups;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLFindGroupsFeedUnit;
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
/* compiled from: last_expired */
public class FindGroupsDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static FindGroupsDeclaration f18035b;
    private static final Object f18036c = new Object();
    private final Lazy<FindGroupsGroupPartDefinition> f18037a;

    private static FindGroupsDeclaration m25310b(InjectorLike injectorLike) {
        return new FindGroupsDeclaration(IdBasedLazy.m1808a(injectorLike, 6218));
    }

    @Inject
    public FindGroupsDeclaration(Lazy<FindGroupsGroupPartDefinition> lazy) {
        this.f18037a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(FindGroupsPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLFindGroupsFeedUnit.class, this.f18037a);
    }

    public static FindGroupsDeclaration m25309a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindGroupsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18036c) {
                FindGroupsDeclaration findGroupsDeclaration;
                if (a2 != null) {
                    findGroupsDeclaration = (FindGroupsDeclaration) a2.mo818a(f18036c);
                } else {
                    findGroupsDeclaration = f18035b;
                }
                if (findGroupsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25310b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18036c, b3);
                        } else {
                            f18035b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = findGroupsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
