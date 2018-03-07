package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.sections.HoldoutUnitPartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.feed.rows.sections.hidden.FeedHiddenUnitGroupPartDefinition;
import com.facebook.feed.rows.sections.hidden.HiddenUnitGroupPartDefinition;
import com.facebook.goodwill.feed.rows.ThrowbackPromotionFeedUnitEdge.ThrowbackPromotionFeedUnit;
import com.facebook.goodwill.feed.rows.ThrowbackYearMarkerFeedUnitEdge.ThrowbackYearMarkerFeedUnit;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackAnniversaryCampaignStory;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryPromotionStory;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryStory;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackMissedMemoriesStory;
import com.facebook.graphql.model.GraphQLHoldoutAdFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: feed_unit_subtitle_styled */
public class ThrowbackFeedRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedUnit, Void, FeedEnvironment> {
    private static ThrowbackFeedRootGroupPartDefinition f13554b;
    private static final Object f13555c = new Object();
    private final RootPartSelector<FeedEnvironment> f13556a;

    private static ThrowbackFeedRootGroupPartDefinition m15318b(InjectorLike injectorLike) {
        return new ThrowbackFeedRootGroupPartDefinition(IdBasedLazy.a(injectorLike, 6839), IdBasedLazy.a(injectorLike, 6826), IdBasedLazy.a(injectorLike, 1664), IdBasedLazy.a(injectorLike, 1666), IdBasedLazy.a(injectorLike, 5961), IdBasedLazy.a(injectorLike, 6837), IdBasedLazy.a(injectorLike, 6847), IdBasedLazy.a(injectorLike, 6834), IdBasedLazy.a(injectorLike, 6023), IdBasedLazy.a(injectorLike, 6820), IdBasedLazy.a(injectorLike, 6840));
    }

    public final Object m15319a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f13556a.a(baseMultiRowSubParts, (FeedUnit) obj);
        return null;
    }

    @Inject
    public ThrowbackFeedRootGroupPartDefinition(Lazy<ThrowbackGraphQLStorySelectorPartDefinition> lazy, Lazy<ThrowbackFeedPromotionSelectorPartDefinition> lazy2, Lazy<FeedHiddenUnitGroupPartDefinition> lazy3, Lazy<HiddenUnitGroupPartDefinition> lazy4, Lazy<HoldoutUnitPartDefinition> lazy5, Lazy<ThrowbackFriendversaryGroupPartDefinition> lazy6, Lazy<ThrowbackYearMarkerPartDefinition> lazy7, Lazy<ThrowbackFriendversaryCampaignGroupPartDefinition> lazy8, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy9, Lazy<ThrowbackAnniversaryCampaignGroupPartDefinition> lazy10, Lazy<ThrowbackMissedMemoriesStoryGroupPartDefinition> lazy11) {
        this.f13556a = RootPartSelector.a().b(NegativeFeedbackActionsUnit.class, lazy3).b(HideableUnit.class, lazy4).a(GraphQLHoldoutAdFeedUnit.class, lazy5).b(GraphQLStory.class, lazy).b(GraphQLGoodwillThrowbackFriendversaryStory.class, lazy6).b(ThrowbackYearMarkerFeedUnit.class, lazy7).a(GraphQLGoodwillThrowbackFriendversaryPromotionStory.class, lazy8).a(GraphQLGoodwillThrowbackAnniversaryCampaignStory.class, lazy10).b(ThrowbackPromotionFeedUnit.class, lazy2).b(GraphQLGoodwillThrowbackMissedMemoriesStory.class, lazy11).a(Object.class, lazy9);
    }

    public static ThrowbackFeedRootGroupPartDefinition m15317a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFeedRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13555c) {
                ThrowbackFeedRootGroupPartDefinition throwbackFeedRootGroupPartDefinition;
                if (a2 != null) {
                    throwbackFeedRootGroupPartDefinition = (ThrowbackFeedRootGroupPartDefinition) a2.a(f13555c);
                } else {
                    throwbackFeedRootGroupPartDefinition = f13554b;
                }
                if (throwbackFeedRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15318b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13555c, b3);
                        } else {
                            f13554b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFeedRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m15320a(Object obj) {
        return true;
    }
}
