package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cb04f9addf988ef995767708aab06d6c */
public class QuickPromotionHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, Void, E, TextWithMenuButtonView> implements HasSpecialStyling {
    private static QuickPromotionHeaderPartDefinition f8884c;
    private static final Object f8885d = new Object();
    private final BackgroundPartDefinition f8886a;
    private final MenuButtonPartDefinition f8887b;

    private static QuickPromotionHeaderPartDefinition m9638b(InjectorLike injectorLike) {
        return new QuickPromotionHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m9640a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f8886a, new StylingData(feedProps, PaddingStyle.j));
        subParts.a(2131560877, this.f8887b, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m9641a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        boolean z;
        int a = Logger.a(8, EntryType.MARK_PUSH, -1102002802);
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        if (c == null || c.l() == null) {
            z = false;
        } else {
            z = true;
        }
        textWithMenuButtonView.setMenuButtonActive(z);
        textWithMenuButtonView.a(QuickPromotionFeedUnitHelper.d(graphQLQuickPromotionFeedUnit), Sponsored.NOT_SPONSORED);
        Logger.a(8, EntryType.MARK_POP, 2044174064, a);
    }

    public final boolean m9642a(Object obj) {
        return QuickPromotionFeedUnitUtils.m9625a((GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a);
    }

    @Inject
    public QuickPromotionHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f8886a = backgroundPartDefinition;
        this.f8887b = menuButtonPartDefinition;
    }

    public final SpecialStylingType m9643b() {
        return SpecialStylingType.NEED_BOTTOM_DIVIDER;
    }

    public static QuickPromotionHeaderPartDefinition m9637a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8885d) {
                QuickPromotionHeaderPartDefinition quickPromotionHeaderPartDefinition;
                if (a2 != null) {
                    quickPromotionHeaderPartDefinition = (QuickPromotionHeaderPartDefinition) a2.a(f8885d);
                } else {
                    quickPromotionHeaderPartDefinition = f8884c;
                }
                if (quickPromotionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9638b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8885d, b3);
                        } else {
                            f8884c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9639a() {
        return TextWithMenuButtonView.b;
    }
}
