package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotedCampaignsConnection;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
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
/* compiled from: goodwill_throwback_share_composer_post */
public class ThrowbackCampaignGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackCampaignGroupPartDefinition f12358e;
    private static final Object f12359f = new Object();
    private final ThrowbackUnifiedSeeMorePartDefinition f12360a;
    private final ThrowbackUnifiedSharePartDefinition f12361b;
    private final ThrowbackUnifiedAttachmentPartDefinition f12362c;
    private final ThrowbackUnifiedHeaderPartDefinition f12363d;

    private static ThrowbackCampaignGroupPartDefinition m14291b(InjectorLike injectorLike) {
        return new ThrowbackCampaignGroupPartDefinition(ThrowbackUnifiedHeaderPartDefinition.m14424a(injectorLike), ThrowbackUnifiedAttachmentPartDefinition.m14418a(injectorLike), ThrowbackUnifiedSharePartDefinition.m14447a(injectorLike), ThrowbackUnifiedSeeMorePartDefinition.m14441a(injectorLike));
    }

    public final Object m14292a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        Builder builder = new Builder();
        builder.r = ((GraphQLGoodwillCampaign) graphQLGoodwillThrowbackPromotionFeedUnit.v().a().get(0)).u();
        GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
        builder2.o = graphQLGoodwillThrowbackPromotionFeedUnit.g();
        builder2 = builder2;
        builder2.ay = ((GraphQLGoodwillCampaign) graphQLGoodwillThrowbackPromotionFeedUnit.v().a().get(0)).E();
        GraphQLStory.Builder builder3 = builder2;
        builder3.m = ImmutableList.of(builder.a());
        GraphQLStory a = builder3.a();
        baseMultiRowSubParts.a(this.f12363d, feedProps);
        baseMultiRowSubParts.a(this.f12362c, feedProps.b(a));
        baseMultiRowSubParts.a(this.f12361b, feedProps);
        baseMultiRowSubParts.a(this.f12360a, feedProps);
        return null;
    }

    public final boolean m14293a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        GraphQLGoodwillThrowbackPromotedCampaignsConnection v = graphQLGoodwillThrowbackPromotionFeedUnit.v();
        if (!GoodwillFeedUnitHelper.f(graphQLGoodwillThrowbackPromotionFeedUnit) || v.a().get(0) == null || graphQLGoodwillThrowbackPromotionFeedUnit.F() == null) {
            return false;
        }
        if (graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("friendversary_photo_collage") || graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("friendversary_card_collage") || graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("anniversary_photo_collage")) {
            return true;
        }
        return false;
    }

    @Inject
    public ThrowbackCampaignGroupPartDefinition(ThrowbackUnifiedHeaderPartDefinition throwbackUnifiedHeaderPartDefinition, ThrowbackUnifiedAttachmentPartDefinition throwbackUnifiedAttachmentPartDefinition, ThrowbackUnifiedSharePartDefinition throwbackUnifiedSharePartDefinition, ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition) {
        this.f12360a = throwbackUnifiedSeeMorePartDefinition;
        this.f12361b = throwbackUnifiedSharePartDefinition;
        this.f12362c = throwbackUnifiedAttachmentPartDefinition;
        this.f12363d = throwbackUnifiedHeaderPartDefinition;
    }

    public static ThrowbackCampaignGroupPartDefinition m14290a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackCampaignGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12359f) {
                ThrowbackCampaignGroupPartDefinition throwbackCampaignGroupPartDefinition;
                if (a2 != null) {
                    throwbackCampaignGroupPartDefinition = (ThrowbackCampaignGroupPartDefinition) a2.a(f12359f);
                } else {
                    throwbackCampaignGroupPartDefinition = f12358e;
                }
                if (throwbackCampaignGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14291b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12359f, b3);
                        } else {
                            f12358e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackCampaignGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
