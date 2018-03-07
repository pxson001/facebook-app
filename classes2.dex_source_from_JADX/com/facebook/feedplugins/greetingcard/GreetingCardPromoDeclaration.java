package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLGreetingCardPromotionFeedUnit;
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
/* compiled from: last_check_time_ms */
public class GreetingCardPromoDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static GreetingCardPromoDeclaration f18099b;
    private static final Object f18100c = new Object();
    private final Lazy<GreetingCardPromoPartDefinition> f18101a;

    private static GreetingCardPromoDeclaration m25404b(InjectorLike injectorLike) {
        return new GreetingCardPromoDeclaration(IdBasedLazy.m1808a(injectorLike, 6326));
    }

    @Inject
    public GreetingCardPromoDeclaration(Lazy<GreetingCardPromoPartDefinition> lazy) {
        this.f18101a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLGreetingCardPromotionFeedUnit.class, this.f18101a);
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(GreetingCardPromoHeaderPartDefinition.a);
        listItemRowController.m16558a(GreetingCardPromoContentPartDefinition.a);
    }

    public static GreetingCardPromoDeclaration m25403a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPromoDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18100c) {
                GreetingCardPromoDeclaration greetingCardPromoDeclaration;
                if (a2 != null) {
                    greetingCardPromoDeclaration = (GreetingCardPromoDeclaration) a2.mo818a(f18100c);
                } else {
                    greetingCardPromoDeclaration = f18099b;
                }
                if (greetingCardPromoDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25404b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18100c, b3);
                        } else {
                            f18099b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPromoDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
