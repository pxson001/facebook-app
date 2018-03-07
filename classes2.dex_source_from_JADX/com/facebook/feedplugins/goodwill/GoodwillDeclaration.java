package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceBasePartDefinition;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaignFeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
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
/* compiled from: last_data_usage_fetch_time_ms */
public class GoodwillDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static GoodwillDeclaration f18049c;
    private static final Object f18050d = new Object();
    private final Lazy<AnniversaryPartDefinition> f18051a;
    private final Lazy<ThrowbackGroupPartDefinition> f18052b;

    private static GoodwillDeclaration m25334b(InjectorLike injectorLike) {
        return new GoodwillDeclaration(IdBasedLazy.m1808a(injectorLike, 6234), IdBasedLazy.m1808a(injectorLike, 6272));
    }

    @Inject
    public GoodwillDeclaration(Lazy<AnniversaryPartDefinition> lazy, Lazy<ThrowbackGroupPartDefinition> lazy2) {
        this.f18051a = lazy;
        this.f18052b = lazy2;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(CulturalMomentAttachmentPartDefinition.a);
        listItemRowController.m16558a(DailyDialogueBirthdayTitlePartDefinition.a);
        listItemRowController.m16558a(DailyDialogueLightweightHeaderPartDefinition.a);
        listItemRowController.m16558a(DualPhotoBasePartDefinition.a);
        listItemRowController.m16558a(GoodwillIconWithMenuHeaderView.a);
        listItemRowController.m16558a(GoodwillFeedUnitTitleView.a);
        listItemRowController.m16558a(MessageAndPostPartDefinition.a);
        listItemRowController.m16558a(UploadProfilePicturePartDefinition.a);
        listItemRowController.m16558a(ThrowbackFeedUnitHeaderView.a);
        listItemRowController.m16558a(ThrowbackPrivacyLabelPartDefinition.a);
        listItemRowController.m16558a(ThrowbackPhotoAttachmentContainerView.b);
        listItemRowController.m16558a(ThrowbackUnifiedSeeMorePartDefinition.a);
        listItemRowController.m16558a(ThrowbackUnifiedSharePartDefinition.a);
        listItemRowController.m16558a(FacebookVoiceBasePartDefinition.a);
        listItemRowController.m16558a(ThrowbackBirthdayFacepilePartDefinition.a);
        listItemRowController.m16558a(DefaultThrowbackPromotedStoryHeaderPartDefinition.a);
        listItemRowController.m16558a(FriendversaryDataCardHeaderPartDefinition.a);
        listItemRowController.m16558a(DailyDialogueBrandedBannerPartDefinition.a);
        listItemRowController.m16558a(DailyDialogueBrandedTitlePartDefinition.a);
        listItemRowController.m16558a(FriendversaryDataCardDataPointPartDefinition.a);
        listItemRowController.m16558a(FriendversaryDataCardAttachmentHeaderTextPartDefinition.a);
        listItemRowController.m16558a(FriendversaryDataCardAttachmentHeaderPartDefinition.a);
        listItemRowController.m16558a(FriendversaryDataCardAttachmentDataPointPartDefinition.a);
        listItemRowController.m16558a(FriendversaryInProductBrandingAttachmentHeaderPartDefinition.a);
        listItemRowController.m16558a(ThrowbackUnifiedInProductBrandingHeaderPartDefinition.a);
        listItemRowController.m16558a(ThrowbackRichVideoRowPartDefinition.a);
    }

    public static GoodwillDeclaration m25333a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GoodwillDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18050d) {
                GoodwillDeclaration goodwillDeclaration;
                if (a2 != null) {
                    goodwillDeclaration = (GoodwillDeclaration) a2.mo818a(f18050d);
                } else {
                    goodwillDeclaration = f18049c;
                }
                if (goodwillDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25334b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18050d, b3);
                        } else {
                            f18049c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = goodwillDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLGoodwillAnniversaryCampaignFeedUnit.class, this.f18051a);
        rootPartRegistrationController.m25196a(GraphQLGoodwillThrowbackPromotionFeedUnit.class, this.f18052b);
    }

    public final void mo2999a(RecyclableViewPoolManager recyclableViewPoolManager) {
    }
}
