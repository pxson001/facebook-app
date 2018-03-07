package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.LayoutInflater;
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
/* compiled from: gravity_finish_ble_scan */
public class DailyDialogueBrandedTitlePartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, E, View> {
    public static final ViewType f12176a = new C12981();
    private static DailyDialogueBrandedTitlePartDefinition f12177c;
    private static final Object f12178d = new Object();
    private final DailyDialogueBrandedTitleSubPartDefinition f12179b;

    /* compiled from: gravity_finish_ble_scan */
    final class C12981 extends ViewType {
        C12981() {
        }

        public final View m14170a(Context context) {
            return LayoutInflater.from(context).inflate(2130903838, null);
        }
    }

    private static DailyDialogueBrandedTitlePartDefinition m14172b(InjectorLike injectorLike) {
        return new DailyDialogueBrandedTitlePartDefinition(DailyDialogueBrandedTitleSubPartDefinition.m14176a(injectorLike));
    }

    public final Object m14174a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12179b, (FeedProps) obj);
        return null;
    }

    public final boolean m14175a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        return (graphQLGoodwillThrowbackPromotionFeedUnit.I() == null || graphQLGoodwillThrowbackPromotionFeedUnit.x() == null) ? false : true;
    }

    @Inject
    public DailyDialogueBrandedTitlePartDefinition(DailyDialogueBrandedTitleSubPartDefinition dailyDialogueBrandedTitleSubPartDefinition) {
        this.f12179b = dailyDialogueBrandedTitleSubPartDefinition;
    }

    public final ViewType m14173a() {
        return f12176a;
    }

    public static DailyDialogueBrandedTitlePartDefinition m14171a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DailyDialogueBrandedTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12178d) {
                DailyDialogueBrandedTitlePartDefinition dailyDialogueBrandedTitlePartDefinition;
                if (a2 != null) {
                    dailyDialogueBrandedTitlePartDefinition = (DailyDialogueBrandedTitlePartDefinition) a2.a(f12178d);
                } else {
                    dailyDialogueBrandedTitlePartDefinition = f12177c;
                }
                if (dailyDialogueBrandedTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14172b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12178d, b3);
                        } else {
                            f12177c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = dailyDialogueBrandedTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
