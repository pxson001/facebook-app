package com.facebook.feedplugins.graphqlstory.seefirsttombstone;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: Seal Broadcast Request */
public class SeeFirstTombstoneDeclaration implements FeedRowSupportDeclaration {
    private static SeeFirstTombstoneDeclaration f23370a;
    private static final Object f23371b = new Object();

    private static SeeFirstTombstoneDeclaration m25699a() {
        return new SeeFirstTombstoneDeclaration();
    }

    public final void m25701a(ListItemRowController listItemRowController) {
        listItemRowController.a(SeeFirstTombstonePartDefinition.a);
    }

    public static SeeFirstTombstoneDeclaration m25700a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeFirstTombstoneDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23371b) {
                SeeFirstTombstoneDeclaration seeFirstTombstoneDeclaration;
                if (a3 != null) {
                    seeFirstTombstoneDeclaration = (SeeFirstTombstoneDeclaration) a3.a(f23371b);
                } else {
                    seeFirstTombstoneDeclaration = f23370a;
                }
                if (seeFirstTombstoneDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m25699a();
                        if (a3 != null) {
                            a3.a(f23371b, a2);
                        } else {
                            f23370a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = seeFirstTombstoneDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
