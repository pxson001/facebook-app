package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
/* compiled from: gravity_finish_ble_scan_fail */
public class DailyDialogueBrandedHeaderPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static DailyDialogueBrandedHeaderPartDefinition f12171d;
    private static final Object f12172e = new Object();
    private final DailyDialogueBrandedBannerPartDefinition f12173a;
    private final DailyDialogueBrandedTitlePartDefinition f12174b;
    private final DailyDialogueBirthdayTitlePartDefinition f12175c;

    private static DailyDialogueBrandedHeaderPartDefinition m14167b(InjectorLike injectorLike) {
        return new DailyDialogueBrandedHeaderPartDefinition(DailyDialogueBrandedBannerPartDefinition.m14159a(injectorLike), DailyDialogueBrandedTitlePartDefinition.m14171a(injectorLike), DailyDialogueBirthdayTitlePartDefinition.m14153a(injectorLike));
    }

    public final Object m14168a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12173a, feedProps);
        SubPartsSelector.a(baseMultiRowSubParts, this.f12175c, feedProps).a(this.f12174b, feedProps);
        return null;
    }

    public final boolean m14169a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        return "single_photo_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "instagram_photo".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "birthday_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "status_update_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "link_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "video".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "reshare_photo".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "reshare_status_update".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "reshare_video".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "multi_photo".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F());
    }

    @Inject
    public DailyDialogueBrandedHeaderPartDefinition(DailyDialogueBrandedBannerPartDefinition dailyDialogueBrandedBannerPartDefinition, DailyDialogueBrandedTitlePartDefinition dailyDialogueBrandedTitlePartDefinition, DailyDialogueBirthdayTitlePartDefinition dailyDialogueBirthdayTitlePartDefinition) {
        this.f12173a = dailyDialogueBrandedBannerPartDefinition;
        this.f12174b = dailyDialogueBrandedTitlePartDefinition;
        this.f12175c = dailyDialogueBirthdayTitlePartDefinition;
    }

    public static DailyDialogueBrandedHeaderPartDefinition m14166a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DailyDialogueBrandedHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12172e) {
                DailyDialogueBrandedHeaderPartDefinition dailyDialogueBrandedHeaderPartDefinition;
                if (a2 != null) {
                    dailyDialogueBrandedHeaderPartDefinition = (DailyDialogueBrandedHeaderPartDefinition) a2.a(f12172e);
                } else {
                    dailyDialogueBrandedHeaderPartDefinition = f12171d;
                }
                if (dailyDialogueBrandedHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14167b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12172e, b3);
                        } else {
                            f12171d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = dailyDialogueBrandedHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
