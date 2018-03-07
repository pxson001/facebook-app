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
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
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
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
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
/* compiled from: com.facebook.feed.quickcam.targetData */
public class FriendsLocationsCheckinPagePartDefinition extends BaseSinglePartDefinition<FriendsNearbyItemPartDefinition$Props, State, AnyEnvironment, FriendsLocationsPageView> {
    private static FriendsLocationsCheckinPagePartDefinition f8485g;
    private static final Object f8486h = new Object();
    private final FriendsNearbyFeedUnitAnalyticsEventBuilder f8487a;
    public final DefaultFeedUnitRenderer f8488b;
    public final GlyphColorizer f8489c;
    public final FriendsNearbyFeedUnitAnalyticsLogger f8490d;
    public final ViewPermalinkIntentFactory f8491e;
    public final SecureContextHelper f8492f;

    /* compiled from: com.facebook.feed.quickcam.targetData */
    public class State {
        public final OnClickListener f8479a;
        public final OnClickListener f8480b;
        public final OnClickListener f8481c;
        public final OnClickListener f8482d;
        public final String f8483e;
        public final String f8484f;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, OnClickListener onClickListener4, String str, String str2) {
            this.f8479a = onClickListener;
            this.f8480b = onClickListener2;
            this.f8481c = onClickListener3;
            this.f8482d = onClickListener4;
            this.f8483e = str;
            this.f8484f = str2;
        }
    }

    private static FriendsLocationsCheckinPagePartDefinition m9368b(InjectorLike injectorLike) {
        return new FriendsLocationsCheckinPagePartDefinition(DefaultFeedUnitRenderer.a(injectorLike), FriendsNearbyFeedUnitAnalyticsEventBuilder.a(injectorLike), GlyphColorizer.a(injectorLike), FriendsNearbyFeedUnitAnalyticsLogger.m9411b(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m9369a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FriendsNearbyItemPartDefinition$Props friendsNearbyItemPartDefinition$Props = (FriendsNearbyItemPartDefinition$Props) obj;
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b).b());
        HoneyClientEvent a = FriendsNearbyFeedUnitAnalyticsEventBuilder.a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_TAP_MESSAGE, GraphQLHelper.a(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a));
        if (a != null) {
            a.a("feed_type", friendsNearbyItemPartDefinition$Props.f8548a.u());
            a.a("location_category", friendsNearbyItemPartDefinition$Props.f8549b.m());
        }
        return new State(new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsCheckinPagePartDefinition f8474b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1521741339);
                FriendsLocationsCheckinPagePartDefinition friendsLocationsCheckinPagePartDefinition = this.f8474b;
                String q = friendsNearbyItemPartDefinition$Props.f8549b.q();
                Builder builder = new Builder();
                builder.a = q;
                friendsLocationsCheckinPagePartDefinition.f8492f.a(friendsLocationsCheckinPagePartDefinition.f8491e.a(builder.a()), view.getContext());
                this.f8474b.f8490d.m9412a(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, 960069602, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsCheckinPagePartDefinition f8478b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -218217525);
                if (friendsNearbyItemPartDefinition$Props.f8549b.q() != null) {
                    FriendsLocationsCheckinPagePartDefinition friendsLocationsCheckinPagePartDefinition = this.f8478b;
                    String q = friendsNearbyItemPartDefinition$Props.f8549b.q();
                    Builder builder = new Builder();
                    builder.a = q;
                    friendsLocationsCheckinPagePartDefinition.f8492f.a(friendsLocationsCheckinPagePartDefinition.f8491e.a(builder.a()), view.getContext());
                    this.f8478b.f8490d.m9417c(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                } else {
                    this.f8478b.f8488b.a(view, LinkifyTargetBuilder.a(FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b)), null);
                    this.f8478b.f8490d.m9418d(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                }
                LogUtils.a(758229063, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsCheckinPagePartDefinition f8476b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 523952128);
                FriendsLocationsCheckinPagePartDefinition friendsLocationsCheckinPagePartDefinition = this.f8476b;
                String q = friendsNearbyItemPartDefinition$Props.f8549b.q();
                Builder builder = new Builder();
                builder.a = q;
                friendsLocationsCheckinPagePartDefinition.f8492f.a(friendsLocationsCheckinPagePartDefinition.f8491e.a(builder.a()), view.getContext());
                this.f8476b.f8490d.m9415b(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, 2019753543, a);
            }
        }, this.f8488b.a(formatStrLocaleSafe, a), FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b).U(), friendsNearbyItemPartDefinition$Props.f8549b.n() == null ? "" : friendsNearbyItemPartDefinition$Props.f8549b.n().a());
    }

    public final /* bridge */ /* synthetic */ void m9370a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 751687503);
        State state = (State) obj2;
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setNameText(state.f8483e);
        Resources resources = friendsLocationsPageView.getResources();
        Drawable a2 = this.f8489c.a(2130840023, resources.getColor(2131363067));
        Preconditions.checkNotNull(a2);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131430241);
        a2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        friendsLocationsPageView.m9406a(a2, state.f8484f);
        friendsLocationsPageView.setOnNameClickListener(state.f8479a);
        friendsLocationsPageView.setOnLocationClickListener(state.f8479a);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(state.f8479a);
        friendsLocationsPageView.setPageCoverOnClickListener(state.f8480b);
        friendsLocationsPageView.setCenterCircleOnClickListener(state.f8481c);
        friendsLocationsPageView.m9405a(this.f8489c.a(AppGlyphResolver.a(), ContextCompat.b(friendsLocationsPageView.getContext(), 2131361937)), state.f8482d);
        Logger.a(8, EntryType.MARK_POP, 1201166625, a);
    }

    public final void m9371b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setOnNameClickListener(null);
        friendsLocationsPageView.setOnLocationClickListener(null);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(null);
        friendsLocationsPageView.setPageCoverOnClickListener(null);
        friendsLocationsPageView.setCenterCircleOnClickListener(null);
        friendsLocationsPageView.m9405a(null, null);
    }

    public static FriendsLocationsCheckinPagePartDefinition m9367a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsCheckinPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8486h) {
                FriendsLocationsCheckinPagePartDefinition friendsLocationsCheckinPagePartDefinition;
                if (a2 != null) {
                    friendsLocationsCheckinPagePartDefinition = (FriendsLocationsCheckinPagePartDefinition) a2.a(f8486h);
                } else {
                    friendsLocationsCheckinPagePartDefinition = f8485g;
                }
                if (friendsLocationsCheckinPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9368b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8486h, b3);
                        } else {
                            f8485g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsCheckinPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendsLocationsCheckinPagePartDefinition(DefaultFeedUnitRenderer defaultFeedUnitRenderer, FriendsNearbyFeedUnitAnalyticsEventBuilder friendsNearbyFeedUnitAnalyticsEventBuilder, GlyphColorizer glyphColorizer, FriendsNearbyFeedUnitAnalyticsLogger friendsNearbyFeedUnitAnalyticsLogger, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper) {
        this.f8488b = defaultFeedUnitRenderer;
        this.f8487a = friendsNearbyFeedUnitAnalyticsEventBuilder;
        this.f8489c = glyphColorizer;
        this.f8490d = friendsNearbyFeedUnitAnalyticsLogger;
        this.f8491e = viewPermalinkIntentFactory;
        this.f8492f = secureContextHelper;
    }
}
