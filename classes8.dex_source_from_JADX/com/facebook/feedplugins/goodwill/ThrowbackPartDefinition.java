package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_campaign_post_submitting */
public class ThrowbackPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackPartDefinition f12442f;
    private static final Object f12443g = new Object();
    private final ThrowbackUnifiedSeeMorePartDefinition f12444a;
    private final ThrowbackUnifiedSharePartDefinition f12445b;
    private final ThrowbackPromotedStoryPartDefinition f12446c;
    private final ThrowbackUnifiedHeaderPartDefinition<FeedEnvironment> f12447d;
    private final DailyDialogueBrandedHeaderPartDefinition f12448e;

    private static ThrowbackPartDefinition m14343b(InjectorLike injectorLike) {
        return new ThrowbackPartDefinition(ThrowbackUnifiedHeaderPartDefinition.m14424a(injectorLike), DailyDialogueBrandedHeaderPartDefinition.m14166a(injectorLike), ThrowbackPromotedStoryPartDefinition.m14384a(injectorLike), ThrowbackUnifiedSharePartDefinition.m14447a(injectorLike), ThrowbackUnifiedSeeMorePartDefinition.m14441a(injectorLike));
    }

    public final Object m14344a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if ("status_update_ipb".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F()) || "link_ipb".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F()) || "reshare_photo".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F()) || "reshare_status_update".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F()) || "reshare_video".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F())) {
            baseMultiRowSubParts.a(this.f12448e, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f12447d, feedProps);
        }
        baseMultiRowSubParts.a(this.f12446c, feedProps);
        baseMultiRowSubParts.a(this.f12445b, feedProps);
        baseMultiRowSubParts.a(this.f12444a, feedProps);
        return null;
    }

    public final boolean m14345a(Object obj) {
        return ((FeedProps) obj).a != null;
    }

    @Inject
    public ThrowbackPartDefinition(ThrowbackUnifiedHeaderPartDefinition throwbackUnifiedHeaderPartDefinition, DailyDialogueBrandedHeaderPartDefinition dailyDialogueBrandedHeaderPartDefinition, ThrowbackPromotedStoryPartDefinition throwbackPromotedStoryPartDefinition, ThrowbackUnifiedSharePartDefinition throwbackUnifiedSharePartDefinition, ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition) {
        this.f12444a = throwbackUnifiedSeeMorePartDefinition;
        this.f12445b = throwbackUnifiedSharePartDefinition;
        this.f12446c = throwbackPromotedStoryPartDefinition;
        this.f12448e = dailyDialogueBrandedHeaderPartDefinition;
        this.f12447d = throwbackUnifiedHeaderPartDefinition;
    }

    public static ThrowbackPartDefinition m14342a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12443g) {
                ThrowbackPartDefinition throwbackPartDefinition;
                if (a2 != null) {
                    throwbackPartDefinition = (ThrowbackPartDefinition) a2.a(f12443g);
                } else {
                    throwbackPartDefinition = f12442f;
                }
                if (throwbackPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14343b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12443g, b3);
                        } else {
                            f12442f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
