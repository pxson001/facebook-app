package com.facebook.feedplugins.friendingcommon;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLIncomingFriendRequestFeedUnit;
import com.facebook.graphql.model.GraphQLQuickPromotionPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
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
/* compiled from: TPARAMS;)V */
public class FriendingCommonHeaderPartDefinition<T extends ScrollableItemListFeedUnit> extends MultiRowSinglePartDefinition<FeedProps<T>, String, HasPositionInformation, TextWithMenuButtonView> {
    private static final PaddingStyle f24634a = PaddingStyle.j;
    private static FriendingCommonHeaderPartDefinition f24635d;
    private static final Object f24636e = new Object();
    private final Resources f24637b;
    private final BackgroundPartDefinition f24638c;

    private static FriendingCommonHeaderPartDefinition m26536b(InjectorLike injectorLike) {
        return new FriendingCommonHeaderPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m26538a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f24638c, new StylingData(feedProps, f24634a));
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) feedProps.a;
        if (scrollableItemListFeedUnit instanceof GraphQLIncomingFriendRequestFeedUnit) {
            GraphQLIncomingFriendRequestFeedUnit graphQLIncomingFriendRequestFeedUnit = (GraphQLIncomingFriendRequestFeedUnit) scrollableItemListFeedUnit;
            if (graphQLIncomingFriendRequestFeedUnit.q() != null) {
                return graphQLIncomingFriendRequestFeedUnit.q().a();
            }
            return this.f24637b.getString(2131233203);
        }
        if (scrollableItemListFeedUnit instanceof GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) {
            GraphQLQuickPromotionPeopleYouMayKnowFeedUnit graphQLQuickPromotionPeopleYouMayKnowFeedUnit = (GraphQLQuickPromotionPeopleYouMayKnowFeedUnit) scrollableItemListFeedUnit;
            if (graphQLQuickPromotionPeopleYouMayKnowFeedUnit.r() != null) {
                return graphQLQuickPromotionPeopleYouMayKnowFeedUnit.r().a();
            }
        }
        return this.f24637b.getString(2131233210);
    }

    public final /* bridge */ /* synthetic */ void m26539a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 388913912);
        String str = (String) obj2;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(str, Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, 347449961, a);
    }

    @Inject
    public FriendingCommonHeaderPartDefinition(Resources resources, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24637b = resources;
        this.f24638c = backgroundPartDefinition;
    }

    public final ViewType m26537a() {
        return TextWithMenuButtonView.b;
    }

    public final boolean m26540a(Object obj) {
        return true;
    }

    public static FriendingCommonHeaderPartDefinition m26535a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendingCommonHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24636e) {
                FriendingCommonHeaderPartDefinition friendingCommonHeaderPartDefinition;
                if (a2 != null) {
                    friendingCommonHeaderPartDefinition = (FriendingCommonHeaderPartDefinition) a2.a(f24636e);
                } else {
                    friendingCommonHeaderPartDefinition = f24635d;
                }
                if (friendingCommonHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26536b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24636e, b3);
                        } else {
                            f24635d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendingCommonHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
