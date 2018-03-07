package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
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
/* compiled from: goodwill_throwback_permalink_view */
public class ThrowbackFriendversaryCollageGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackFriendversaryCollageGroupPartDefinition f12397h;
    private static final Object f12398i = new Object();
    private final ThrowbackHeaderSelectorPartDefinition f12399a;
    private final PhotoAttachmentPartDefinition<FeedEnvironment> f12400b;
    private final ThrowbackSimplePhotoAttachmentPartDefinition<FeedEnvironment> f12401c;
    private final ThrowbackCollageAttachmentPartDefinition<FeedEnvironment> f12402d;
    private final ThrowbackUnifiedSeeMorePartDefinition f12403e;
    private final ThrowbackUnifiedSharePartDefinition f12404f;
    private final GatekeeperStoreImpl f12405g;

    private static ThrowbackFriendversaryCollageGroupPartDefinition m14318b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryCollageGroupPartDefinition(ThrowbackHeaderSelectorPartDefinition.m14338a(injectorLike), PhotoAttachmentPartDefinition.a(injectorLike), ThrowbackSimplePhotoAttachmentPartDefinition.m14411a(injectorLike), ThrowbackCollageAttachmentPartDefinition.m14294a(injectorLike), ThrowbackUnifiedSeeMorePartDefinition.m14441a(injectorLike), ThrowbackUnifiedSharePartDefinition.m14447a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m14319a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        baseMultiRowSubParts.a(this.f12399a, feedProps);
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        Builder builder = new Builder();
        builder.r = g.u();
        GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
        builder2.o = graphQLGoodwillThrowbackPromotionFeedUnit.g();
        GraphQLStory.Builder builder3 = builder2;
        builder3.ay = g.E();
        builder3 = builder3;
        builder3.m = ImmutableList.of(builder.a());
        GraphQLStory a = builder3.a();
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(a);
        if (o.x().size() != 1) {
            baseMultiRowSubParts.a(this.f12402d, feedProps.a(a));
        } else if (this.f12405g.a(858, false)) {
            baseMultiRowSubParts.a(this.f12401c, feedProps.a(a).a(o).a((Flattenable) o.x().get(0)));
        } else {
            baseMultiRowSubParts.a(this.f12400b, feedProps.a(a).a(o).a((Flattenable) o.x().get(0)));
        }
        baseMultiRowSubParts.a(this.f12404f, feedProps);
        baseMultiRowSubParts.a(this.f12403e, feedProps);
        return null;
    }

    public final boolean m14320a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit) == null) {
            return false;
        }
        if ("friendversary_card_collage".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friendversary_card_collage_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            return true;
        }
        return false;
    }

    @Inject
    public ThrowbackFriendversaryCollageGroupPartDefinition(ThrowbackHeaderSelectorPartDefinition throwbackHeaderSelectorPartDefinition, PhotoAttachmentPartDefinition photoAttachmentPartDefinition, ThrowbackSimplePhotoAttachmentPartDefinition throwbackSimplePhotoAttachmentPartDefinition, ThrowbackCollageAttachmentPartDefinition throwbackCollageAttachmentPartDefinition, ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition, ThrowbackUnifiedSharePartDefinition throwbackUnifiedSharePartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12399a = throwbackHeaderSelectorPartDefinition;
        this.f12400b = photoAttachmentPartDefinition;
        this.f12402d = throwbackCollageAttachmentPartDefinition;
        this.f12403e = throwbackUnifiedSeeMorePartDefinition;
        this.f12404f = throwbackUnifiedSharePartDefinition;
        this.f12401c = throwbackSimplePhotoAttachmentPartDefinition;
        this.f12405g = gatekeeperStoreImpl;
    }

    public static ThrowbackFriendversaryCollageGroupPartDefinition m14317a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryCollageGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12398i) {
                ThrowbackFriendversaryCollageGroupPartDefinition throwbackFriendversaryCollageGroupPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryCollageGroupPartDefinition = (ThrowbackFriendversaryCollageGroupPartDefinition) a2.a(f12398i);
                } else {
                    throwbackFriendversaryCollageGroupPartDefinition = f12397h;
                }
                if (throwbackFriendversaryCollageGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14318b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12398i, b3);
                        } else {
                            f12397h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryCollageGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
