package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackDataPoint;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_throwback_nux_megaphone_dismiss */
public class ThrowbackFriendversaryDataCardGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackFriendversaryDataCardGroupPartDefinition f12406h;
    private static final Object f12407i = new Object();
    private final FriendversaryDataCardHeaderPartDefinition f12408a;
    private final ThrowbackUnifiedHeaderPartDefinition<FeedEnvironment> f12409b;
    private final ThrowbackUnifiedSharePartDefinition f12410c;
    private final ThrowbackUnifiedSeeMorePartDefinition f12411d;
    private final ThrowbackPrivacyLabelComponentPartDefinition<FeedEnvironment> f12412e;
    private final ThrowbackPrivacyLabelPartDefinition f12413f;
    private final FriendversaryDataCardDataPointPartDefinition f12414g;

    private static ThrowbackFriendversaryDataCardGroupPartDefinition m14322b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryDataCardGroupPartDefinition(FriendversaryDataCardHeaderPartDefinition.m14236a(injectorLike), ThrowbackUnifiedHeaderPartDefinition.m14424a(injectorLike), FriendversaryDataCardDataPointPartDefinition.m14228a(injectorLike), ThrowbackPrivacyLabelComponentPartDefinition.m14362a(injectorLike), ThrowbackPrivacyLabelPartDefinition.m14372a(injectorLike), ThrowbackUnifiedSharePartDefinition.m14447a(injectorLike), ThrowbackUnifiedSeeMorePartDefinition.m14441a(injectorLike));
    }

    public final Object m14323a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f12408a, feedProps);
        baseMultiRowSubParts.a(this.f12409b, feedProps);
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (!(g.l() == null || g.l().a() == null)) {
            ImmutableList a = g.l().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint = (GraphQLGoodwillThrowbackDataPoint) a.get(i);
                if (!(graphQLGoodwillThrowbackDataPoint == null || graphQLGoodwillThrowbackDataPoint.j() == null || TextUtils.isEmpty(graphQLGoodwillThrowbackDataPoint.j().a()) || graphQLGoodwillThrowbackDataPoint.a() == null)) {
                    baseMultiRowSubParts.a(this.f12414g, FeedProps.c(graphQLGoodwillThrowbackDataPoint));
                }
            }
        }
        SubPartsSelector.a(baseMultiRowSubParts, this.f12412e, feedProps).a(this.f12413f, feedProps);
        baseMultiRowSubParts.a(this.f12410c, feedProps);
        baseMultiRowSubParts.a(this.f12411d, feedProps);
        return null;
    }

    public final boolean m14324a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        return (GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit) == null || graphQLGoodwillThrowbackPromotionFeedUnit.F() == null || !graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("friendversary_card_data")) ? false : true;
    }

    @Inject
    public ThrowbackFriendversaryDataCardGroupPartDefinition(FriendversaryDataCardHeaderPartDefinition friendversaryDataCardHeaderPartDefinition, ThrowbackUnifiedHeaderPartDefinition throwbackUnifiedHeaderPartDefinition, FriendversaryDataCardDataPointPartDefinition friendversaryDataCardDataPointPartDefinition, ThrowbackPrivacyLabelComponentPartDefinition throwbackPrivacyLabelComponentPartDefinition, ThrowbackPrivacyLabelPartDefinition throwbackPrivacyLabelPartDefinition, ThrowbackUnifiedSharePartDefinition throwbackUnifiedSharePartDefinition, ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition) {
        this.f12408a = friendversaryDataCardHeaderPartDefinition;
        this.f12409b = throwbackUnifiedHeaderPartDefinition;
        this.f12414g = friendversaryDataCardDataPointPartDefinition;
        this.f12412e = throwbackPrivacyLabelComponentPartDefinition;
        this.f12413f = throwbackPrivacyLabelPartDefinition;
        this.f12411d = throwbackUnifiedSeeMorePartDefinition;
        this.f12410c = throwbackUnifiedSharePartDefinition;
    }

    public static ThrowbackFriendversaryDataCardGroupPartDefinition m14321a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryDataCardGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12407i) {
                ThrowbackFriendversaryDataCardGroupPartDefinition throwbackFriendversaryDataCardGroupPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryDataCardGroupPartDefinition = (ThrowbackFriendversaryDataCardGroupPartDefinition) a2.a(f12407i);
                } else {
                    throwbackFriendversaryDataCardGroupPartDefinition = f12406h;
                }
                if (throwbackFriendversaryDataCardGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14322b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12407i, b3);
                        } else {
                            f12406h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryDataCardGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
