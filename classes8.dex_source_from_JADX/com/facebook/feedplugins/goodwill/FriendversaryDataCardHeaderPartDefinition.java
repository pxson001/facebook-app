package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_live_conversation_fragment */
public class FriendversaryDataCardHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, E, FbRelativeLayout> {
    public static final ViewType f12268a = ViewType.a(2130904614);
    private static final CallerContext f12269b = CallerContext.a(FriendversaryDataCardHeaderPartDefinition.class, "goodwill_throwback");
    private static final PaddingStyle f12270c = Builder.f().i();
    private static FriendversaryDataCardHeaderPartDefinition f12271h;
    private static final Object f12272i = new Object();
    private final FbDraweePartDefinition f12273d;
    private final MenuButtonPartDefinition f12274e;
    private final BackgroundPartDefinition f12275f;
    private final FriendversaryDataCardHeaderPolaroidPartDefinition f12276g;

    private static FriendversaryDataCardHeaderPartDefinition m14237b(InjectorLike injectorLike) {
        return new FriendversaryDataCardHeaderPartDefinition(FbDraweePartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), FriendversaryDataCardHeaderPolaroidPartDefinition.m14241a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14239a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        GraphQLImage graphQLImage = (GraphQLImage) graphQLGoodwillThrowbackPromotionFeedUnit.n().get(0);
        GraphQLImage graphQLImage2 = (GraphQLImage) graphQLGoodwillThrowbackPromotionFeedUnit.n().get(1);
        FbDraweePartDefinition fbDraweePartDefinition = this.f12273d;
        Props.Builder a = new Props.Builder().a(graphQLImage.b());
        a.c = f12269b;
        subParts.a(2131562585, fbDraweePartDefinition, a.a(graphQLImage.c(), graphQLImage.a()).a());
        FbDraweePartDefinition fbDraweePartDefinition2 = this.f12273d;
        Props.Builder a2 = new Props.Builder().a(graphQLImage2.b());
        a2.c = f12269b;
        subParts.a(2131562587, fbDraweePartDefinition2, a2.a(graphQLImage2.c(), graphQLImage2.a()).a());
        subParts.a(this.f12275f, new StylingData(feedProps, f12270c, 2130839797, -1));
        subParts.a(2131560877, this.f12274e, new MenuButtonPartDefinition.Props(feedProps, MenuConfig.CLICKABLE));
        subParts.a(2131562586, this.f12276g, feedProps);
        return null;
    }

    public final boolean m14240a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (graphQLGoodwillThrowbackPromotionFeedUnit == null || graphQLGoodwillThrowbackPromotionFeedUnit.n() == null || graphQLGoodwillThrowbackPromotionFeedUnit.n().size() < 2) {
            return false;
        }
        ImmutableList n = graphQLGoodwillThrowbackPromotionFeedUnit.n();
        for (int i = 0; i < 2; i++) {
            GraphQLImage graphQLImage = (GraphQLImage) n.get(i);
            if (graphQLImage == null || graphQLImage.b() == null) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public FriendversaryDataCardHeaderPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, FriendversaryDataCardHeaderPolaroidPartDefinition friendversaryDataCardHeaderPolaroidPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12273d = fbDraweePartDefinition;
        this.f12274e = menuButtonPartDefinition;
        this.f12276g = friendversaryDataCardHeaderPolaroidPartDefinition;
        this.f12275f = backgroundPartDefinition;
    }

    public static FriendversaryDataCardHeaderPartDefinition m14236a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12272i) {
                FriendversaryDataCardHeaderPartDefinition friendversaryDataCardHeaderPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardHeaderPartDefinition = (FriendversaryDataCardHeaderPartDefinition) a2.a(f12272i);
                } else {
                    friendversaryDataCardHeaderPartDefinition = f12271h;
                }
                if (friendversaryDataCardHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14237b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12272i, b3);
                        } else {
                            f12271h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14238a() {
        return f12268a;
    }
}
