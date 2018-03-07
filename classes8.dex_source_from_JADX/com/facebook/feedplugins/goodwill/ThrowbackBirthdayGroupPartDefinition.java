package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotedCampaignsConnection;
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
/* compiled from: goodwill_video_share_composer_opened */
public class ThrowbackBirthdayGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackBirthdayGroupPartDefinition f12345g;
    private static final Object f12346h = new Object();
    private final ThrowbackUnifiedSeeMorePartDefinition f12347a;
    private final ThrowbackBirthdayFacepilePartDefinition f12348b;
    private final ThrowbackUnifiedHeaderPartDefinition f12349c;
    private final DailyDialogueBrandedHeaderPartDefinition f12350d;
    private final ThrowbackUnifiedInProductBrandingHeaderPartDefinition<FeedEnvironment> f12351e;
    private final UploadProfilePicturePartDefinition f12352f;

    private static ThrowbackBirthdayGroupPartDefinition m14284b(InjectorLike injectorLike) {
        return new ThrowbackBirthdayGroupPartDefinition(ThrowbackUnifiedHeaderPartDefinition.m14424a(injectorLike), DailyDialogueBrandedHeaderPartDefinition.m14166a(injectorLike), ThrowbackBirthdayFacepilePartDefinition.m14277a(injectorLike), ThrowbackUnifiedSeeMorePartDefinition.m14441a(injectorLike), ThrowbackUnifiedInProductBrandingHeaderPartDefinition.m14432a(injectorLike), UploadProfilePicturePartDefinition.m14472a(injectorLike));
    }

    public final Object m14285a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12350d, feedProps).a(this.f12351e, feedProps).a(this.f12349c, feedProps);
        baseMultiRowSubParts.a(this.f12348b, feedProps);
        baseMultiRowSubParts.a(this.f12352f, feedProps);
        baseMultiRowSubParts.a(this.f12347a, feedProps);
        return null;
    }

    public final boolean m14286a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        GraphQLGoodwillThrowbackPromotedCampaignsConnection v = graphQLGoodwillThrowbackPromotionFeedUnit.v();
        if (!GoodwillFeedUnitHelper.f(graphQLGoodwillThrowbackPromotionFeedUnit) || v.a().get(0) == null || ((GraphQLGoodwillCampaign) v.a().get(0)).j() == null) {
            return false;
        }
        if (((GraphQLGoodwillCampaign) v.a().get(0)).j().g() == -538251524) {
            return true;
        }
        return false;
    }

    @Inject
    public ThrowbackBirthdayGroupPartDefinition(ThrowbackUnifiedHeaderPartDefinition throwbackUnifiedHeaderPartDefinition, DailyDialogueBrandedHeaderPartDefinition dailyDialogueBrandedHeaderPartDefinition, ThrowbackBirthdayFacepilePartDefinition throwbackBirthdayFacepilePartDefinition, ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition, ThrowbackUnifiedInProductBrandingHeaderPartDefinition throwbackUnifiedInProductBrandingHeaderPartDefinition, UploadProfilePicturePartDefinition uploadProfilePicturePartDefinition) {
        this.f12347a = throwbackUnifiedSeeMorePartDefinition;
        this.f12348b = throwbackBirthdayFacepilePartDefinition;
        this.f12349c = throwbackUnifiedHeaderPartDefinition;
        this.f12350d = dailyDialogueBrandedHeaderPartDefinition;
        this.f12351e = throwbackUnifiedInProductBrandingHeaderPartDefinition;
        this.f12352f = uploadProfilePicturePartDefinition;
    }

    public static ThrowbackBirthdayGroupPartDefinition m14283a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackBirthdayGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12346h) {
                ThrowbackBirthdayGroupPartDefinition throwbackBirthdayGroupPartDefinition;
                if (a2 != null) {
                    throwbackBirthdayGroupPartDefinition = (ThrowbackBirthdayGroupPartDefinition) a2.a(f12346h);
                } else {
                    throwbackBirthdayGroupPartDefinition = f12345g;
                }
                if (throwbackBirthdayGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14284b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12346h, b3);
                        } else {
                            f12345g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackBirthdayGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
