package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackFooterShareButtonView;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryStory;
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
/* compiled from: jewel_footer_promo_last_shown_secs */
public class ThrowbackPartsDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static ThrowbackPartsDeclaration f18655c;
    private static final Object f18656d = new Object();
    private final Lazy<ThrowbackYearMarkerPartDefinition> f18657a;
    private final Lazy<ThrowbackFriendversaryGroupPartDefinition> f18658b;

    private static ThrowbackPartsDeclaration m26166b(InjectorLike injectorLike) {
        return new ThrowbackPartsDeclaration(IdBasedLazy.m1808a(injectorLike, 6847), IdBasedLazy.m1808a(injectorLike, 6837));
    }

    @Inject
    public ThrowbackPartsDeclaration(Lazy<ThrowbackYearMarkerPartDefinition> lazy, Lazy<ThrowbackFriendversaryGroupPartDefinition> lazy2) {
        this.f18657a = lazy;
        this.f18658b = lazy2;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(ThrowbackYearMarkerFeedUnitEdge$ThrowbackYearMarkerFeedUnit.class, this.f18657a);
        rootPartRegistrationController.m25196a(GraphQLGoodwillThrowbackFriendversaryStory.class, this.f18658b);
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(ThrowbackYearMarkerPartDefinition.a);
        listItemRowController.m16558a(ThrowbackFriendversaryHeaderView.a);
        listItemRowController.m16558a(ThrowbackFooterShareButtonView.a);
        listItemRowController.m16558a(ThrowbackFriendversaryFriendViewPartDefinition.a);
        listItemRowController.m16558a(ThrowbackAnniversaryCampaignHeaderPartDefinition.a);
        listItemRowController.m16558a(ThrowbackFeedPromotionHeaderPartDefinition.a);
        listItemRowController.m16558a(ThrowbackPromotionMoreFooterPartDefinition.a);
        listItemRowController.m16558a(ThrowbackFeedStorySectionHeaderView.a);
        listItemRowController.m16558a(ThrowbackFriendversaryCampaignFriendViewPartDefinition.a);
        listItemRowController.m16558a(ThrowbackFriendversaryAggregatedFriendListItemPartDefinition.a);
        listItemRowController.m16558a(ThrowbackFriendversaryAggregatedFriendListFriendPartDefinition.a);
    }

    public static ThrowbackPartsDeclaration m26165a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPartsDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18656d) {
                ThrowbackPartsDeclaration throwbackPartsDeclaration;
                if (a2 != null) {
                    throwbackPartsDeclaration = (ThrowbackPartsDeclaration) a2.mo818a(f18656d);
                } else {
                    throwbackPartsDeclaration = f18655c;
                }
                if (throwbackPartsDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26166b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18656d, b3);
                        } else {
                            f18655c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPartsDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
