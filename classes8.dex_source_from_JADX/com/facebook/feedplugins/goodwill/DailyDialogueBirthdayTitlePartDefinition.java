package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gravity_gps_location_reported */
public class DailyDialogueBirthdayTitlePartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, E, View> {
    public static final ViewType f12151a = ViewType.a(2130903836);
    private static DailyDialogueBirthdayTitlePartDefinition f12152c;
    private static final Object f12153d = new Object();
    private final DailyDialogueBrandedTitleSubPartDefinition f12154b;

    private static DailyDialogueBirthdayTitlePartDefinition m14154b(InjectorLike injectorLike) {
        return new DailyDialogueBirthdayTitlePartDefinition(DailyDialogueBrandedTitleSubPartDefinition.m14176a(injectorLike));
    }

    public final Object m14156a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12154b, (FeedProps) obj);
        return null;
    }

    public final boolean m14157a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        return (graphQLGoodwillThrowbackPromotionFeedUnit.I() == null || graphQLGoodwillThrowbackPromotionFeedUnit.x() == null || !"birthday_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) ? false : true;
    }

    @Inject
    public DailyDialogueBirthdayTitlePartDefinition(DailyDialogueBrandedTitleSubPartDefinition dailyDialogueBrandedTitleSubPartDefinition) {
        this.f12154b = dailyDialogueBrandedTitleSubPartDefinition;
    }

    public final ViewType m14155a() {
        return f12151a;
    }

    public static DailyDialogueBirthdayTitlePartDefinition m14153a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DailyDialogueBirthdayTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12153d) {
                DailyDialogueBirthdayTitlePartDefinition dailyDialogueBirthdayTitlePartDefinition;
                if (a2 != null) {
                    dailyDialogueBirthdayTitlePartDefinition = (DailyDialogueBirthdayTitlePartDefinition) a2.a(f12153d);
                } else {
                    dailyDialogueBirthdayTitlePartDefinition = f12152c;
                }
                if (dailyDialogueBirthdayTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14154b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12153d, b3);
                        } else {
                            f12152c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = dailyDialogueBirthdayTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
