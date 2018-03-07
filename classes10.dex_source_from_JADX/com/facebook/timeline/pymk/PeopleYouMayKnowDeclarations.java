package com.facebook.timeline.pymk;

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
import com.facebook.timeline.pymk.rows.PeopleYouMayKnowHScrollPartDefinition;
import com.facebook.timeline.pymk.rows.PeopleYouMayKnowPagePartDefinition;
import com.facebook.timeline.pymk.rows.PeopleYouMayKnowSeeAllPartDefinition;

@ContextScoped
/* compiled from: fail to send invite. */
public class PeopleYouMayKnowDeclarations implements FeedRowSupportDeclaration {
    private static PeopleYouMayKnowDeclarations f12466a;
    private static final Object f12467b = new Object();

    private static PeopleYouMayKnowDeclarations m12496a() {
        return new PeopleYouMayKnowDeclarations();
    }

    public final void m12498a(ListItemRowController listItemRowController) {
        listItemRowController.a(PeopleYouMayKnowHScrollPartDefinition.f12531a);
        listItemRowController.a(PeopleYouMayKnowPagePartDefinition.f12558a);
        listItemRowController.a(PeopleYouMayKnowSeeAllPartDefinition.f12568a);
    }

    public static PeopleYouMayKnowDeclarations m12497a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowDeclarations a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f12467b) {
                PeopleYouMayKnowDeclarations peopleYouMayKnowDeclarations;
                if (a3 != null) {
                    peopleYouMayKnowDeclarations = (PeopleYouMayKnowDeclarations) a3.a(f12467b);
                } else {
                    peopleYouMayKnowDeclarations = f12466a;
                }
                if (peopleYouMayKnowDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m12496a();
                        if (a3 != null) {
                            a3.a(f12467b, a2);
                        } else {
                            f12466a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = peopleYouMayKnowDeclarations;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
