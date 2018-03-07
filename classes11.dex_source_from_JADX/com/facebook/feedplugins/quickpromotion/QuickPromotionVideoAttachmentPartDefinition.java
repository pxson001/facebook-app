package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.VideoAttachmentsSelectorPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLQuickPromotion;
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
/* compiled from: card_subtitle */
public class QuickPromotionVideoAttachmentPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, Void, FeedEnvironment> {
    private static QuickPromotionVideoAttachmentPartDefinition f9005b;
    private static final Object f9006c = new Object();
    private final VideoAttachmentsSelectorPartDefinition f9007a;

    private static QuickPromotionVideoAttachmentPartDefinition m9709b(InjectorLike injectorLike) {
        return new QuickPromotionVideoAttachmentPartDefinition(VideoAttachmentsSelectorPartDefinition.a(injectorLike));
    }

    public final Object m9710a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c((GraphQLQuickPromotionFeedUnit) feedProps.a);
        if (!(c == null || c.a() == null)) {
            FeedProps feedProps2;
            GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) feedProps.a;
            GraphQLQuickPromotionCreative c2 = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
            if (c2 == null) {
                feedProps2 = null;
            } else {
                Builder builder = new Builder();
                if (c2.a() != null) {
                    builder.r = ImmutableList.of(c2.a());
                    builder.q = c2.a().w();
                }
                GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
                builder2.o = graphQLQuickPromotionFeedUnit.g();
                GraphQLStory.Builder builder3 = builder2;
                builder3.m = ImmutableList.of(builder.a());
                feedProps2 = feedProps.b(builder3.a());
            }
            FeedProps feedProps3 = feedProps2;
            GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps3.a);
            baseMultiRowSubParts.a(this.f9007a, feedProps3.a(o).a((Flattenable) o.x().get(0)));
        }
        return null;
    }

    public final boolean m9711a(Object obj) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a;
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        if (graphQLQuickPromotionFeedUnit == null || c == null || b == null || b.l() == null) {
            return false;
        }
        return QuickPromotionTemplate.NEWSFEED_BRANDED_VIDEO.equals(QuickPromotionTemplate.fromString(b.l().a()));
    }

    @Inject
    public QuickPromotionVideoAttachmentPartDefinition(VideoAttachmentsSelectorPartDefinition videoAttachmentsSelectorPartDefinition) {
        this.f9007a = videoAttachmentsSelectorPartDefinition;
    }

    public static QuickPromotionVideoAttachmentPartDefinition m9708a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9006c) {
                QuickPromotionVideoAttachmentPartDefinition quickPromotionVideoAttachmentPartDefinition;
                if (a2 != null) {
                    quickPromotionVideoAttachmentPartDefinition = (QuickPromotionVideoAttachmentPartDefinition) a2.a(f9006c);
                } else {
                    quickPromotionVideoAttachmentPartDefinition = f9005b;
                }
                if (quickPromotionVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9709b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9006c, b3);
                        } else {
                            f9005b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
