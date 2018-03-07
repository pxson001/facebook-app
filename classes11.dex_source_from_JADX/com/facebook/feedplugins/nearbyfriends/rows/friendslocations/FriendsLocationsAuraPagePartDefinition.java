package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder;
import com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder.FriendsNearbyEvent;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feedplugins.nearbyfriends.rows.ui.FriendsLocationsPageView;
import com.facebook.feedplugins.nearbyfriends.rows.util.FriendsNearbyFeedUnitAnalyticsLogger;
import com.facebook.graphql.enums.GraphQLFriendLocationCategory;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.gametime.ui.GametimeActivity */
public class FriendsLocationsAuraPagePartDefinition extends BaseSinglePartDefinition<FriendsNearbyItemPartDefinition$Props, State, AnyEnvironment, FriendsLocationsPageView> {
    private static FriendsLocationsAuraPagePartDefinition f8467e;
    private static final Object f8468f = new Object();
    private final FriendsNearbyFeedUnitAnalyticsEventBuilder f8469a;
    private final DefaultFeedUnitRenderer f8470b;
    public final GlyphColorizer f8471c;
    public final FriendsNearbyFeedUnitAnalyticsLogger f8472d;

    /* compiled from: com.facebook.gametime.ui.GametimeActivity */
    public class State {
        public final OnClickListener f8460a;
        public final OnClickListener f8461b;
        public final OnClickListener f8462c;
        public final OnClickListener f8463d;
        public final String f8464e;
        public final int f8465f;
        public final String f8466g;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, OnClickListener onClickListener4, String str, int i, String str2) {
            this.f8460a = onClickListener;
            this.f8461b = onClickListener2;
            this.f8462c = onClickListener3;
            this.f8463d = onClickListener4;
            this.f8464e = str;
            this.f8465f = i;
            this.f8466g = str2;
        }
    }

    private static FriendsLocationsAuraPagePartDefinition m9363b(InjectorLike injectorLike) {
        return new FriendsLocationsAuraPagePartDefinition(DefaultFeedUnitRenderer.a(injectorLike), FriendsNearbyFeedUnitAnalyticsEventBuilder.a(injectorLike), GlyphColorizer.a(injectorLike), FriendsNearbyFeedUnitAnalyticsLogger.m9411b(injectorLike));
    }

    public final Object m9364a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        final FriendsNearbyItemPartDefinition$Props friendsNearbyItemPartDefinition$Props = (FriendsNearbyItemPartDefinition$Props) obj;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b).b());
        HoneyClientEvent a = FriendsNearbyFeedUnitAnalyticsEventBuilder.a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_TAP_MESSAGE, GraphQLHelper.a(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a));
        if (a != null) {
            a.a("feed_type", friendsNearbyItemPartDefinition$Props.f8548a.u());
            a.a("location_category", friendsNearbyItemPartDefinition$Props.f8549b.m());
        }
        GraphQLProfile a2 = FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b);
        C10451 c10451 = new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsAuraPagePartDefinition f8455b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 295678459);
                FriendsLocationsAuraPagePartDefinition.m9362a(this.f8455b, view, friendsNearbyItemPartDefinition$Props);
                this.f8455b.f8472d.m9412a(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, 1505119868, a);
            }
        };
        C10473 c10473 = new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsAuraPagePartDefinition f8459b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 788996205);
                FriendsLocationsAuraPagePartDefinition.m9362a(this.f8459b, view, friendsNearbyItemPartDefinition$Props);
                if (friendsNearbyItemPartDefinition$Props.f8549b.j() != null) {
                    this.f8459b.f8472d.m9417c(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                } else {
                    this.f8459b.f8472d.m9418d(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                }
                LogUtils.a(-2080479162, a);
            }
        };
        C10462 c10462 = new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsAuraPagePartDefinition f8457b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -198652061);
                FriendsLocationsAuraPagePartDefinition.m9362a(this.f8457b, view, friendsNearbyItemPartDefinition$Props);
                this.f8457b.f8472d.m9415b(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, -271908187, a);
            }
        };
        OnClickListener a3 = this.f8470b.a(formatStrLocaleSafe, a);
        String U = a2.U();
        if (friendsNearbyItemPartDefinition$Props.f8549b.m() == GraphQLFriendLocationCategory.APPROXIMATE_LOCATION) {
            i = 2130839998;
        } else {
            i = 2130839921;
        }
        return new State(c10451, c10473, c10462, a3, U, i, friendsNearbyItemPartDefinition$Props.f8549b.n() == null ? "" : friendsNearbyItemPartDefinition$Props.f8549b.n().a());
    }

    public final /* bridge */ /* synthetic */ void m9365a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -892287755);
        State state = (State) obj2;
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setNameText(state.f8464e);
        int i = state.f8465f;
        Resources resources = friendsLocationsPageView.getResources();
        Drawable a2 = this.f8471c.a(i, resources.getColor(2131363067));
        Preconditions.checkNotNull(a2);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430241);
        a2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        friendsLocationsPageView.m9406a(a2, state.f8466g);
        friendsLocationsPageView.setOnNameClickListener(state.f8460a);
        friendsLocationsPageView.setOnLocationClickListener(state.f8460a);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(state.f8460a);
        friendsLocationsPageView.setPageCoverOnClickListener(state.f8461b);
        friendsLocationsPageView.setCenterCircleOnClickListener(state.f8462c);
        friendsLocationsPageView.m9405a(this.f8471c.a(AppGlyphResolver.a(), ContextCompat.b(friendsLocationsPageView.getContext(), 2131361937)), state.f8463d);
        Logger.a(8, EntryType.MARK_POP, -858447434, a);
    }

    public final void m9366b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setOnNameClickListener(null);
        friendsLocationsPageView.setOnLocationClickListener(null);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(null);
        friendsLocationsPageView.setPageCoverOnClickListener(null);
        friendsLocationsPageView.setCenterCircleOnClickListener(null);
        friendsLocationsPageView.m9405a(null, null);
    }

    public static FriendsLocationsAuraPagePartDefinition m9361a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsAuraPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8468f) {
                FriendsLocationsAuraPagePartDefinition friendsLocationsAuraPagePartDefinition;
                if (a2 != null) {
                    friendsLocationsAuraPagePartDefinition = (FriendsLocationsAuraPagePartDefinition) a2.a(f8468f);
                } else {
                    friendsLocationsAuraPagePartDefinition = f8467e;
                }
                if (friendsLocationsAuraPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9363b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8468f, b3);
                        } else {
                            f8467e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsAuraPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendsLocationsAuraPagePartDefinition(DefaultFeedUnitRenderer defaultFeedUnitRenderer, FriendsNearbyFeedUnitAnalyticsEventBuilder friendsNearbyFeedUnitAnalyticsEventBuilder, GlyphColorizer glyphColorizer, FriendsNearbyFeedUnitAnalyticsLogger friendsNearbyFeedUnitAnalyticsLogger) {
        this.f8470b = defaultFeedUnitRenderer;
        this.f8469a = friendsNearbyFeedUnitAnalyticsEventBuilder;
        this.f8471c = glyphColorizer;
        this.f8472d = friendsNearbyFeedUnitAnalyticsLogger;
    }

    public static void m9362a(FriendsLocationsAuraPagePartDefinition friendsLocationsAuraPagePartDefinition, View view, FriendsNearbyItemPartDefinition$Props friendsNearbyItemPartDefinition$Props) {
        friendsLocationsAuraPagePartDefinition.f8470b.a(view, LinkifyTargetBuilder.a(FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b)), null);
    }
}
