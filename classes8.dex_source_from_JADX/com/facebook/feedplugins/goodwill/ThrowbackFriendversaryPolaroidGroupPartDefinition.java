package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
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
/* compiled from: goodwill_throwback_add_profile_frame_click */
public class ThrowbackFriendversaryPolaroidGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackFriendversaryPolaroidGroupPartDefinition f12418f;
    private static final Object f12419g = new Object();
    private final ThrowbackHeaderSelectorPartDefinition f12420a;
    private final ThrowbackFriendversaryPolaroidContentPartDefinition<FeedEnvironment> f12421b;
    private final ThrowbackCollageAttachmentPartDefinition<FeedEnvironment> f12422c;
    private final ThrowbackUnifiedSharePartDefinition f12423d;
    private final ThrowbackUnifiedSeeMorePartDefinition f12424e;

    private static ThrowbackFriendversaryPolaroidGroupPartDefinition m14330b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryPolaroidGroupPartDefinition(ThrowbackHeaderSelectorPartDefinition.m14338a(injectorLike), ThrowbackFriendversaryPolaroidContentPartDefinition.m14325a(injectorLike), ThrowbackCollageAttachmentPartDefinition.m14294a(injectorLike), ThrowbackUnifiedSharePartDefinition.m14447a(injectorLike), ThrowbackUnifiedSeeMorePartDefinition.m14441a(injectorLike));
    }

    public final Object m14331a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f12420a, feedProps);
        if ("friendversary_polaroids_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
            Builder builder = new Builder();
            builder.r = g.u();
            builder = builder;
            GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
            builder2.o = graphQLGoodwillThrowbackPromotionFeedUnit.g();
            GraphQLStory.Builder builder3 = builder2;
            builder3.ay = g.E();
            builder3 = builder3;
            builder3.m = ImmutableList.of(builder.a());
            baseMultiRowSubParts.a(this.f12422c, feedProps.a(builder3.a()));
        } else if ("friendversary_polaroids".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            baseMultiRowSubParts.a(this.f12421b, feedProps);
        }
        baseMultiRowSubParts.a(this.f12423d, feedProps);
        baseMultiRowSubParts.a(this.f12424e, feedProps);
        return null;
    }

    public final boolean m14332a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit) == null) {
            return false;
        }
        if ("friendversary_polaroids".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friendversary_polaroids_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            return true;
        }
        return false;
    }

    @Inject
    public ThrowbackFriendversaryPolaroidGroupPartDefinition(ThrowbackHeaderSelectorPartDefinition throwbackHeaderSelectorPartDefinition, ThrowbackFriendversaryPolaroidContentPartDefinition throwbackFriendversaryPolaroidContentPartDefinition, ThrowbackCollageAttachmentPartDefinition throwbackCollageAttachmentPartDefinition, ThrowbackUnifiedSharePartDefinition throwbackUnifiedSharePartDefinition, ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition) {
        this.f12420a = throwbackHeaderSelectorPartDefinition;
        this.f12421b = throwbackFriendversaryPolaroidContentPartDefinition;
        this.f12422c = throwbackCollageAttachmentPartDefinition;
        this.f12424e = throwbackUnifiedSeeMorePartDefinition;
        this.f12423d = throwbackUnifiedSharePartDefinition;
    }

    public static ThrowbackFriendversaryPolaroidGroupPartDefinition m14329a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryPolaroidGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12419g) {
                ThrowbackFriendversaryPolaroidGroupPartDefinition throwbackFriendversaryPolaroidGroupPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryPolaroidGroupPartDefinition = (ThrowbackFriendversaryPolaroidGroupPartDefinition) a2.a(f12419g);
                } else {
                    throwbackFriendversaryPolaroidGroupPartDefinition = f12418f;
                }
                if (throwbackFriendversaryPolaroidGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14330b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12419g, b3);
                        } else {
                            f12418f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryPolaroidGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
