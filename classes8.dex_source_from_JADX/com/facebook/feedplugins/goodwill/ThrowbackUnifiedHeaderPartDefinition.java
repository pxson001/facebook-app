package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceBasePartDefinition;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceBasePartDefinition.State;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gone */
public class ThrowbackUnifiedHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends FacebookVoiceBasePartDefinition<GraphQLGoodwillThrowbackPromotionFeedUnit, E> {
    private static final PaddingStyle f12541b = Builder.f().i();
    private static ThrowbackUnifiedHeaderPartDefinition f12542g;
    private static final Object f12543h = new Object();
    private final BackgroundPartDefinition f12544c;
    private final MenuButtonPartDefinition f12545d;
    private final LinkifyUtil f12546e;
    private final Resources f12547f;

    private static ThrowbackUnifiedHeaderPartDefinition m14426b(InjectorLike injectorLike) {
        return new ThrowbackUnifiedHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), LinkifyUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m14427a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m14423a(subParts, (FeedProps) obj);
    }

    @Inject
    public ThrowbackUnifiedHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, LinkifyUtil linkifyUtil, Resources resources) {
        this.f12544c = backgroundPartDefinition;
        this.f12545d = menuButtonPartDefinition;
        this.f12546e = linkifyUtil;
        this.f12547f = resources;
    }

    public final boolean m14428a(Object obj) {
        return true;
    }

    public static ThrowbackUnifiedHeaderPartDefinition m14424a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackUnifiedHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12543h) {
                ThrowbackUnifiedHeaderPartDefinition throwbackUnifiedHeaderPartDefinition;
                if (a2 != null) {
                    throwbackUnifiedHeaderPartDefinition = (ThrowbackUnifiedHeaderPartDefinition) a2.a(f12543h);
                } else {
                    throwbackUnifiedHeaderPartDefinition = f12542g;
                }
                if (throwbackUnifiedHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14426b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12543h, b3);
                        } else {
                            f12542g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackUnifiedHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private State m14423a(SubParts<E> subParts, FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps) {
        Spannable a;
        boolean z;
        boolean z2;
        boolean z3;
        GraphQLImage graphQLImage;
        int i;
        float f;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a();
        if (graphQLGoodwillThrowbackPromotionFeedUnit.I() != null) {
            a = this.f12546e.a(LinkifyUtilConverter.c(graphQLGoodwillThrowbackPromotionFeedUnit.I()), true, null);
        } else {
            Object obj = "";
        }
        String a2 = m14425a(graphQLGoodwillThrowbackPromotionFeedUnit.x());
        boolean z4 = graphQLGoodwillThrowbackPromotionFeedUnit.A() != null;
        GraphQLImage A = z4 ? graphQLGoodwillThrowbackPromotionFeedUnit.A() : graphQLGoodwillThrowbackPromotionFeedUnit.l();
        int a3 = (graphQLGoodwillThrowbackPromotionFeedUnit.w() == null || graphQLGoodwillThrowbackPromotionFeedUnit.w().j() == null) ? -16777216 : m14422a(graphQLGoodwillThrowbackPromotionFeedUnit.w().j());
        GraphQLImage z5 = graphQLGoodwillThrowbackPromotionFeedUnit.z();
        if (!GoodwillFeedUnitHelper.f(graphQLGoodwillThrowbackPromotionFeedUnit) || "friendversary_card_collage".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            z = true;
        } else {
            z = false;
        }
        int i2 = 0;
        Object stylingData = new StylingData(feedProps, f12541b, 2130839797, -1, Position.MIDDLE);
        if (graphQLGoodwillThrowbackPromotionFeedUnit.F() != null) {
            GraphQLImage graphQLImage2;
            float f2;
            if (graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("friend_birthday")) {
                int i3;
                GraphQLImage a4 = GoodwillFeedUnitHelper.a(graphQLGoodwillThrowbackPromotionFeedUnit, this.f12547f.getDimensionPixelSize(2131429039));
                if (a4 != null) {
                    i3 = 2130842776;
                } else {
                    i3 = 0;
                }
                i2 = i3;
                graphQLImage2 = a4;
                f2 = 0.0f;
            } else if (graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("friendversary_polaroids")) {
                z = true;
                f2 = 280.0f;
                graphQLImage2 = null;
            } else if (graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("friendversary_card_data")) {
                A = null;
                graphQLImage2 = null;
                f2 = 0.0f;
            } else {
                graphQLImage2 = null;
                f2 = 0.0f;
            }
            if (graphQLGoodwillThrowbackPromotionFeedUnit.F().equals("friendversary_card_data")) {
                z2 = false;
                z3 = z;
                graphQLImage = A;
                i = i2;
                A = graphQLImage2;
                f = f2;
            } else {
                z2 = true;
                subParts.a(2131560877, this.f12545d, new Props(feedProps, MenuConfig.CLICKABLE));
                stylingData = new StylingData(feedProps, f12541b, 2130839797, -1);
                z3 = z;
                graphQLImage = A;
                i = i2;
                A = graphQLImage2;
                f = f2;
            }
        } else {
            z2 = false;
            z3 = z;
            graphQLImage = A;
            i = 0;
            A = null;
            f = 0.0f;
        }
        subParts.a(this.f12544c, stylingData);
        return new State(a2, a, null, z2, graphQLImage, a3, z4, z5, z3, A, i, f);
    }

    private static String m14425a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities != null ? graphQLTextWithEntities.a() : "";
    }

    private static int m14422a(String str) {
        return (int) Long.parseLong(str, 16);
    }
}
