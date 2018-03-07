package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
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
/* compiled from: keywords_topic_trending(%s) */
public class QuickPromotionDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static QuickPromotionDeclarations f18399b;
    private static final Object f18400c = new Object();
    private final Lazy<QuickPromotionFeedUnitPartDefinition> f18401a;

    private static QuickPromotionDeclarations m25818b(InjectorLike injectorLike) {
        return new QuickPromotionDeclarations(IdBasedLazy.m1808a(injectorLike, 6501));
    }

    @Inject
    QuickPromotionDeclarations(Lazy<QuickPromotionFeedUnitPartDefinition> lazy) {
        this.f18401a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(QuickPromotionCreativeContentPartDefinition.a);
        listItemRowController.m16558a(QuickPromotionSocialContextPartDefinition.a);
        listItemRowController.m16558a(QuickPromotionLargeImageCreativeContentPartDefinition.a);
        listItemRowController.m16558a(QuickPromotionBrandedVideoCreativeContentPartDefinition.a);
        listItemRowController.m16558a(QuickPromotionOneButtonWithDrawableFooterPartDefinition.a);
        listItemRowController.m16558a(QuickPromotionTwoButtonWithDrawableFooterPartDefinition.a);
        listItemRowController.m16558a(QuickPromotionOneButtonFooterPartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLQuickPromotionFeedUnit.class, this.f18401a);
    }

    public static QuickPromotionDeclarations m25817a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionDeclarations b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18400c) {
                QuickPromotionDeclarations quickPromotionDeclarations;
                if (a2 != null) {
                    quickPromotionDeclarations = (QuickPromotionDeclarations) a2.mo818a(f18400c);
                } else {
                    quickPromotionDeclarations = f18399b;
                }
                if (quickPromotionDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25818b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18400c, b3);
                        } else {
                            f18399b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionDeclarations;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
