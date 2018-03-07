package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_feed_unit_vpv */
public class DailyDialogueBrandedTitleSubPartDefinition<E extends HasPositionInformation> extends BaseSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, E, View> {
    private static final PaddingStyle f12180a = Builder.f().i();
    private static DailyDialogueBrandedTitleSubPartDefinition f12181d;
    private static final Object f12182e = new Object();
    private final TextPartDefinition f12183b;
    private final BackgroundPartDefinition f12184c;

    private static DailyDialogueBrandedTitleSubPartDefinition m14177b(InjectorLike injectorLike) {
        return new DailyDialogueBrandedTitleSubPartDefinition(TextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14178a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        subParts.a(this.f12184c, new StylingData(feedProps, f12180a, 2130839797, -1));
        subParts.a(2131560875, this.f12183b, graphQLGoodwillThrowbackPromotionFeedUnit.x() != null ? graphQLGoodwillThrowbackPromotionFeedUnit.x().a() : "");
        subParts.a(2131560876, this.f12183b, graphQLGoodwillThrowbackPromotionFeedUnit.I() != null ? graphQLGoodwillThrowbackPromotionFeedUnit.I().a() : "");
        return null;
    }

    @Inject
    public DailyDialogueBrandedTitleSubPartDefinition(TextPartDefinition textPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12183b = textPartDefinition;
        this.f12184c = backgroundPartDefinition;
    }

    public static DailyDialogueBrandedTitleSubPartDefinition m14176a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DailyDialogueBrandedTitleSubPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12182e) {
                DailyDialogueBrandedTitleSubPartDefinition dailyDialogueBrandedTitleSubPartDefinition;
                if (a2 != null) {
                    dailyDialogueBrandedTitleSubPartDefinition = (DailyDialogueBrandedTitleSubPartDefinition) a2.a(f12182e);
                } else {
                    dailyDialogueBrandedTitleSubPartDefinition = f12181d;
                }
                if (dailyDialogueBrandedTitleSubPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14177b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12182e, b3);
                        } else {
                            f12181d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = dailyDialogueBrandedTitleSubPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
