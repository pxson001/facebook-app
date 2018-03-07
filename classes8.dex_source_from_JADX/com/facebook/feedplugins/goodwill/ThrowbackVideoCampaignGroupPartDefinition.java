package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.VideoAttachmentsSelectorPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillVideoCampaign;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gms_dialog_surface */
public class ThrowbackVideoCampaignGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackVideoCampaignGroupPartDefinition f12610g;
    private static final Object f12611h = new Object();
    private final Lazy<ThrowbackHeaderSelectorPartDefinition> f12612a;
    private final Lazy<VideoAttachmentsSelectorPartDefinition> f12613b;
    private final Lazy<ThrowbackPrivacyLabelComponentPartDefinition> f12614c;
    private final Lazy<ThrowbackPrivacyLabelPartDefinition> f12615d;
    private final Lazy<ThrowbackUnifiedSeeMorePartDefinition> f12616e;
    private final Lazy<ThrowbackVideoSharePartDefinition> f12617f;

    private static ThrowbackVideoCampaignGroupPartDefinition m14457b(InjectorLike injectorLike) {
        return new ThrowbackVideoCampaignGroupPartDefinition(IdBasedLazy.a(injectorLike, 6273), IdBasedLazy.a(injectorLike, 2066), IdBasedLazy.a(injectorLike, 6277), IdBasedLazy.a(injectorLike, 6279), IdBasedLazy.a(injectorLike, 6290), IdBasedLazy.a(injectorLike, 6294));
    }

    public final Object m14458a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps;
        FeedProps feedProps2 = (FeedProps) obj;
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12612a.get(), feedProps2);
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps2.a;
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (g == null) {
            feedProps = null;
        } else {
            GraphQLGoodwillVideoCampaign F = g.F();
            Builder builder = new Builder();
            builder.r = F.l();
            builder.q = ((GraphQLStoryAttachment) F.l().get(0)).w();
            GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
            builder2.o = graphQLGoodwillThrowbackPromotionFeedUnit.g();
            GraphQLStory.Builder builder3 = builder2;
            builder3.ay = g.E();
            builder3 = builder3;
            builder3.m = ImmutableList.of(builder.a());
            feedProps = feedProps2.b(builder3.a());
        }
        FeedProps feedProps3 = feedProps;
        if (feedProps3 != null) {
            GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps3.a);
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12613b.get(), feedProps3.a(o).a((Flattenable) o.x().get(0)));
            SubPartsSelector.a(baseMultiRowSubParts, (MultiRowSinglePartDefinition) this.f12614c.get(), feedProps2).a((MultiRowSinglePartDefinition) this.f12615d.get(), feedProps2);
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12617f.get(), feedProps2);
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12616e.get(), feedProps2);
        }
        return null;
    }

    public final boolean m14459a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (graphQLGoodwillThrowbackPromotionFeedUnit == null) {
            return false;
        }
        if (!"friendversary_video_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            return false;
        }
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (g == null) {
            return false;
        }
        GraphQLGoodwillVideoCampaign F = g.F();
        return (F == null || F.l() == null || F.l().isEmpty()) ? false : true;
    }

    @Inject
    public ThrowbackVideoCampaignGroupPartDefinition(Lazy<ThrowbackHeaderSelectorPartDefinition> lazy, Lazy<VideoAttachmentsSelectorPartDefinition> lazy2, Lazy<ThrowbackPrivacyLabelComponentPartDefinition> lazy3, Lazy<ThrowbackPrivacyLabelPartDefinition> lazy4, Lazy<ThrowbackUnifiedSeeMorePartDefinition> lazy5, Lazy<ThrowbackVideoSharePartDefinition> lazy6) {
        this.f12612a = lazy;
        this.f12613b = lazy2;
        this.f12614c = lazy3;
        this.f12615d = lazy4;
        this.f12616e = lazy5;
        this.f12617f = lazy6;
    }

    public static ThrowbackVideoCampaignGroupPartDefinition m14456a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackVideoCampaignGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12611h) {
                ThrowbackVideoCampaignGroupPartDefinition throwbackVideoCampaignGroupPartDefinition;
                if (a2 != null) {
                    throwbackVideoCampaignGroupPartDefinition = (ThrowbackVideoCampaignGroupPartDefinition) a2.a(f12611h);
                } else {
                    throwbackVideoCampaignGroupPartDefinition = f12610g;
                }
                if (throwbackVideoCampaignGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14457b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12611h, b3);
                        } else {
                            f12610g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackVideoCampaignGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
