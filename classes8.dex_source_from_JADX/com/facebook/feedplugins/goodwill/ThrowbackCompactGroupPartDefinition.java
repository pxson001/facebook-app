package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_throwback_reshare_original_post_link_click */
public class ThrowbackCompactGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackCompactGroupPartDefinition f12375g;
    private static final Object f12376h = new Object();
    private final ThrowbackUnifiedSeeMorePartDefinition f12377a;
    private final ThrowbackUnifiedSharePartDefinition f12378b;
    private final ThrowbackPhotoAttachmentPartDefinition<FeedEnvironment> f12379c;
    private final ThrowbackHeaderSelectorPartDefinition f12380d;
    private final ThrowbackCollageAttachmentPartDefinition f12381e;
    private final ThrowbackRichVideoRowPartDefinition<FeedEnvironment> f12382f;

    private static ThrowbackCompactGroupPartDefinition m14308b(InjectorLike injectorLike) {
        return new ThrowbackCompactGroupPartDefinition(ThrowbackHeaderSelectorPartDefinition.m14338a(injectorLike), ThrowbackPhotoAttachmentPartDefinition.m14347a(injectorLike), ThrowbackCollageAttachmentPartDefinition.m14294a(injectorLike), ThrowbackRichVideoRowPartDefinition.m14404a(injectorLike), ThrowbackUnifiedSharePartDefinition.m14447a(injectorLike), ThrowbackUnifiedSeeMorePartDefinition.m14441a(injectorLike));
    }

    public final Object m14309a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12380d, feedProps);
        FeedProps b = m14307b(feedProps);
        String F = ((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F();
        if ("video".equals(F)) {
            baseMultiRowSubParts.a(this.f12382f, b);
        } else if ("multi_photo".equals(F)) {
            baseMultiRowSubParts.a(this.f12381e, FeedProps.c((GraphQLStory) ((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).E().a().get(0)));
        } else {
            baseMultiRowSubParts.a(this.f12379c, b);
        }
        baseMultiRowSubParts.a(this.f12378b, feedProps);
        baseMultiRowSubParts.a(this.f12377a, feedProps);
        return null;
    }

    public final boolean m14310a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        if (graphQLGoodwillThrowbackPromotionFeedUnit == null || !GoodwillFeedUnitHelper.e(graphQLGoodwillThrowbackPromotionFeedUnit)) {
            return false;
        }
        int i;
        int i2;
        FeedProps b;
        String F = graphQLGoodwillThrowbackPromotionFeedUnit.F();
        boolean equals = "video".equals(F);
        boolean equals2 = "multi_photo".equals(F);
        if (GoodwillFeedUnitHelper.h(graphQLGoodwillThrowbackPromotionFeedUnit) == 1) {
            int i3;
            GraphQLStory graphQLStory = (GraphQLStory) graphQLGoodwillThrowbackPromotionFeedUnit.E().a().get(0);
            if (graphQLStory.M() == null) {
                i3 = 0;
            } else {
                i3 = graphQLStory.M().size();
            }
            if (i3 == 1) {
                Object obj2;
                GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) graphQLGoodwillThrowbackPromotionFeedUnit.E().a().get(0));
                if (o.r() == null || o.r().S() == null || !GraphQLStoryAttachmentUtil.a(o, GraphQLStoryAttachmentStyle.PHOTO)) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    i = 1;
                    i2 = i;
                    if (equals && i2 == 0 && !equals2) {
                        return false;
                    }
                    b = m14307b(feedProps);
                    if (b != null || b.a == null) {
                        return false;
                    }
                    if (equals) {
                        return this.f12382f.m14409a(b);
                    }
                    if (!equals2) {
                        return true;
                    }
                    return this.f12381e.m14298a(FeedProps.c((GraphQLStory) ((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).E().a().get(0)));
                }
            }
        }
        i = 0;
        i2 = i;
        if (equals) {
        }
        b = m14307b(feedProps);
        if (b != null) {
        }
        return false;
    }

    @Inject
    public ThrowbackCompactGroupPartDefinition(ThrowbackHeaderSelectorPartDefinition throwbackHeaderSelectorPartDefinition, ThrowbackPhotoAttachmentPartDefinition throwbackPhotoAttachmentPartDefinition, ThrowbackCollageAttachmentPartDefinition throwbackCollageAttachmentPartDefinition, ThrowbackRichVideoRowPartDefinition throwbackRichVideoRowPartDefinition, ThrowbackUnifiedSharePartDefinition throwbackUnifiedSharePartDefinition, ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition) {
        this.f12377a = throwbackUnifiedSeeMorePartDefinition;
        this.f12378b = throwbackUnifiedSharePartDefinition;
        this.f12379c = throwbackPhotoAttachmentPartDefinition;
        this.f12381e = throwbackCollageAttachmentPartDefinition;
        this.f12382f = throwbackRichVideoRowPartDefinition;
        this.f12380d = throwbackHeaderSelectorPartDefinition;
    }

    public static ThrowbackCompactGroupPartDefinition m14306a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackCompactGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12376h) {
                ThrowbackCompactGroupPartDefinition throwbackCompactGroupPartDefinition;
                if (a2 != null) {
                    throwbackCompactGroupPartDefinition = (ThrowbackCompactGroupPartDefinition) a2.a(f12376h);
                } else {
                    throwbackCompactGroupPartDefinition = f12375g;
                }
                if (throwbackCompactGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14308b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12376h, b3);
                        } else {
                            f12375g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackCompactGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static FeedProps<GraphQLStoryAttachment> m14307b(FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps) {
        try {
            FeedProps a = ThrowbackPromotionFeedUnitToStoryConverter.m14393a(feedProps);
            GraphQLStory graphQLStory = (GraphQLStory) a.a();
            return a.a(graphQLStory.L()).a(StoryAttachmentHelper.o(graphQLStory.L()));
        } catch (Exception e) {
            return null;
        }
    }
}
