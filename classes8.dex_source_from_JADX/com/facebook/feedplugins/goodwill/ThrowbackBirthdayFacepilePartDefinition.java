package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.net.Uri;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillBirthdayCampaign;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.conversion.GraphQLGoodwillCampaignConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FacepilePartDefinition;
import com.facebook.multirow.parts.FacepilePartDefinition.Props;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: google_play_services */
public class ThrowbackBirthdayFacepilePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, HasPositionInformation, LinearLayout> {
    public static final ViewType f12338a = ViewType.a(2130907402);
    private static final PaddingStyle f12339b = Builder.f().i();
    private static ThrowbackBirthdayFacepilePartDefinition f12340f;
    private static final Object f12341g = new Object();
    private final BackgroundPartDefinition f12342c;
    private final FacepilePartDefinition f12343d;
    private final TextPartDefinition f12344e;

    private static ThrowbackBirthdayFacepilePartDefinition m14279b(InjectorLike injectorLike) {
        return new ThrowbackBirthdayFacepilePartDefinition(BackgroundPartDefinition.a(injectorLike), FacepilePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m14281a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ImmutableList immutableList;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        String a = g.C().a();
        GraphQLGoodwillBirthdayCampaign a2 = GraphQLGoodwillCampaignConversionHelper.a(g);
        if (a2.l() == null || a2.l().a() == null || a2.l().a().isEmpty()) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = m14278a(a2.l().a());
        }
        if ("birthday_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            subParts.a(this.f12342c, new StylingData(feedProps, f12339b));
        } else {
            subParts.a(this.f12342c, new StylingData(feedProps, f12339b, 2131361941, -1));
        }
        subParts.a(2131567863, this.f12343d, new Props(immutableList, null, immutableList.size()));
        subParts.a(2131567864, this.f12344e, a);
        return null;
    }

    public final boolean m14282a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
        if (graphQLGoodwillThrowbackPromotionFeedUnit.I() == null || Strings.isNullOrEmpty(graphQLGoodwillThrowbackPromotionFeedUnit.I().a()) || g == null || g.C() == null || g.C().a() == null || g.v() == null || g.v().a() == null || g.v().a().size() < 3 || graphQLGoodwillThrowbackPromotionFeedUnit.x() == null || graphQLGoodwillThrowbackPromotionFeedUnit.x().a() == null || graphQLGoodwillThrowbackPromotionFeedUnit.B() == null || graphQLGoodwillThrowbackPromotionFeedUnit.z() == null || graphQLGoodwillThrowbackPromotionFeedUnit.z().b() == null) {
            return false;
        }
        ImmutableList a = g.v().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (((GraphQLUser) a.get(i)) == null) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public ThrowbackBirthdayFacepilePartDefinition(BackgroundPartDefinition backgroundPartDefinition, FacepilePartDefinition facepilePartDefinition, TextPartDefinition textPartDefinition) {
        this.f12342c = backgroundPartDefinition;
        this.f12343d = facepilePartDefinition;
        this.f12344e = textPartDefinition;
    }

    public static ThrowbackBirthdayFacepilePartDefinition m14277a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackBirthdayFacepilePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12341g) {
                ThrowbackBirthdayFacepilePartDefinition throwbackBirthdayFacepilePartDefinition;
                if (a2 != null) {
                    throwbackBirthdayFacepilePartDefinition = (ThrowbackBirthdayFacepilePartDefinition) a2.a(f12341g);
                } else {
                    throwbackBirthdayFacepilePartDefinition = f12340f;
                }
                if (throwbackBirthdayFacepilePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14279b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12341g, b3);
                        } else {
                            f12340f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackBirthdayFacepilePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14280a() {
        return f12338a;
    }

    private static ImmutableList<Uri> m14278a(ImmutableList<GraphQLUser> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLUser graphQLUser = (GraphQLUser) immutableList.get(i);
            if (!(graphQLUser.aI() == null || graphQLUser.aI().b() == null)) {
                builder.c(ImageUtil.a(graphQLUser.aI()));
            }
        }
        return builder.b();
    }
}
