package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

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
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
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
/* compiled from: com.facebook.credentials.AuthTokenStore */
public class FriendsLocationsHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLFriendsLocationsFeedUnit>, String, E, TextWithMenuButtonView> {
    private static final PaddingStyle f8503a = PaddingStyle.j;
    private static FriendsLocationsHeaderPartDefinition f8504d;
    private static final Object f8505e = new Object();
    private final BackgroundPartDefinition f8506b;
    private final MenuButtonPartDefinition f8507c;

    private static FriendsLocationsHeaderPartDefinition m9378b(InjectorLike injectorLike) {
        return new FriendsLocationsHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m9380a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) feedProps.a;
        subParts.a(this.f8506b, new StylingData(feedProps, f8503a));
        subParts.a(2131560877, this.f8507c, new Props(feedProps, MenuConfig.CLICKABLE));
        return graphQLFriendsLocationsFeedUnit.m().a();
    }

    public final /* bridge */ /* synthetic */ void m9381a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 222672901);
        String str = (String) obj2;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.SUGGESTED_CONTENT);
        textWithMenuButtonView.a(str, Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(true);
        Logger.a(8, EntryType.MARK_POP, -1367921284, a);
    }

    @Inject
    public FriendsLocationsHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition) {
        this.f8506b = backgroundPartDefinition;
        this.f8507c = menuButtonPartDefinition;
    }

    public final ViewType m9379a() {
        return TextWithMenuButtonView.b;
    }

    public final boolean m9382a(Object obj) {
        return true;
    }

    public static FriendsLocationsHeaderPartDefinition m9377a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8505e) {
                FriendsLocationsHeaderPartDefinition friendsLocationsHeaderPartDefinition;
                if (a2 != null) {
                    friendsLocationsHeaderPartDefinition = (FriendsLocationsHeaderPartDefinition) a2.a(f8505e);
                } else {
                    friendsLocationsHeaderPartDefinition = f8504d;
                }
                if (friendsLocationsHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9378b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8505e, b3);
                        } else {
                            f8504d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
