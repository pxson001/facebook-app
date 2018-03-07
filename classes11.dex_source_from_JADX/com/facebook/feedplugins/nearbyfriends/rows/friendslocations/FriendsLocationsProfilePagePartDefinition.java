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
import com.facebook.graphql.model.GraphQLHelper;
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
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.backgroundlocation.settings.BackgroundLocationSettingsActivity */
public class FriendsLocationsProfilePagePartDefinition extends BaseSinglePartDefinition<FriendsNearbyItemPartDefinition$Props, State, AnyEnvironment, FriendsLocationsPageView> {
    private static FriendsLocationsProfilePagePartDefinition f8523e;
    private static final Object f8524f = new Object();
    private final FriendsNearbyFeedUnitAnalyticsEventBuilder f8525a;
    private final DefaultFeedUnitRenderer f8526b;
    public final GlyphColorizer f8527c;
    public final FriendsNearbyFeedUnitAnalyticsLogger f8528d;

    /* compiled from: com.facebook.backgroundlocation.settings.BackgroundLocationSettingsActivity */
    public class State {
        public final OnClickListener f8518a;
        public final OnClickListener f8519b;
        public final OnClickListener f8520c;
        public final String f8521d;
        public final String f8522e;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, String str, String str2) {
            this.f8518a = onClickListener;
            this.f8519b = onClickListener2;
            this.f8520c = onClickListener3;
            this.f8521d = str;
            this.f8522e = str2;
        }
    }

    private static FriendsLocationsProfilePagePartDefinition m9389b(InjectorLike injectorLike) {
        return new FriendsLocationsProfilePagePartDefinition(DefaultFeedUnitRenderer.a(injectorLike), FriendsNearbyFeedUnitAnalyticsEventBuilder.a(injectorLike), GlyphColorizer.a(injectorLike), FriendsNearbyFeedUnitAnalyticsLogger.m9411b(injectorLike));
    }

    public final Object m9390a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FriendsNearbyItemPartDefinition$Props friendsNearbyItemPartDefinition$Props = (FriendsNearbyItemPartDefinition$Props) obj;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b).b());
        HoneyClientEvent a = FriendsNearbyFeedUnitAnalyticsEventBuilder.a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_TAP_MESSAGE, GraphQLHelper.a(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a));
        if (a != null) {
            a.a("feed_type", friendsNearbyItemPartDefinition$Props.f8548a.u());
            a.a("location_category", friendsNearbyItemPartDefinition$Props.f8549b.m());
        }
        return new State(new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsProfilePagePartDefinition f8515b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1471359251);
                FriendsLocationsProfilePagePartDefinition.m9388a(this.f8515b, view, friendsNearbyItemPartDefinition$Props);
                this.f8515b.f8528d.m9412a(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, 816653386, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsProfilePagePartDefinition f8517b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1546417663);
                FriendsLocationsProfilePagePartDefinition.m9388a(this.f8517b, view, friendsNearbyItemPartDefinition$Props);
                this.f8517b.f8528d.m9418d(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, 133803633, a);
            }
        }, this.f8526b.a(formatStrLocaleSafe, a), FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b).U(), friendsNearbyItemPartDefinition$Props.f8549b.n() == null ? "" : friendsNearbyItemPartDefinition$Props.f8549b.n().a());
    }

    public final /* bridge */ /* synthetic */ void m9391a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 779387066);
        State state = (State) obj2;
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setNameText(state.f8521d);
        Resources resources = friendsLocationsPageView.getResources();
        Drawable a2 = this.f8527c.a(2130839998, resources.getColor(2131363067));
        Preconditions.checkNotNull(a2);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430241);
        a2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        friendsLocationsPageView.m9406a(a2, state.f8522e);
        friendsLocationsPageView.setOnNameClickListener(state.f8518a);
        friendsLocationsPageView.setOnLocationClickListener(state.f8518a);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(state.f8518a);
        friendsLocationsPageView.setPageCoverOnClickListener(state.f8519b);
        friendsLocationsPageView.m9405a(this.f8527c.a(AppGlyphResolver.a(), ContextCompat.b(friendsLocationsPageView.getContext(), 2131361937)), state.f8520c);
        Logger.a(8, EntryType.MARK_POP, 1417506114, a);
    }

    public final void m9392b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setOnNameClickListener(null);
        friendsLocationsPageView.setOnLocationClickListener(null);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(null);
        friendsLocationsPageView.setPageCoverOnClickListener(null);
        friendsLocationsPageView.m9405a(null, null);
    }

    public static FriendsLocationsProfilePagePartDefinition m9387a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsProfilePagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8524f) {
                FriendsLocationsProfilePagePartDefinition friendsLocationsProfilePagePartDefinition;
                if (a2 != null) {
                    friendsLocationsProfilePagePartDefinition = (FriendsLocationsProfilePagePartDefinition) a2.a(f8524f);
                } else {
                    friendsLocationsProfilePagePartDefinition = f8523e;
                }
                if (friendsLocationsProfilePagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9389b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8524f, b3);
                        } else {
                            f8523e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsProfilePagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendsLocationsProfilePagePartDefinition(DefaultFeedUnitRenderer defaultFeedUnitRenderer, FriendsNearbyFeedUnitAnalyticsEventBuilder friendsNearbyFeedUnitAnalyticsEventBuilder, GlyphColorizer glyphColorizer, FriendsNearbyFeedUnitAnalyticsLogger friendsNearbyFeedUnitAnalyticsLogger) {
        this.f8526b = defaultFeedUnitRenderer;
        this.f8525a = friendsNearbyFeedUnitAnalyticsEventBuilder;
        this.f8527c = glyphColorizer;
        this.f8528d = friendsNearbyFeedUnitAnalyticsLogger;
    }

    public static void m9388a(FriendsLocationsProfilePagePartDefinition friendsLocationsProfilePagePartDefinition, View view, FriendsNearbyItemPartDefinition$Props friendsNearbyItemPartDefinition$Props) {
        friendsLocationsProfilePagePartDefinition.f8526b.a(view, LinkifyTargetBuilder.a(FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b)), null);
    }
}
