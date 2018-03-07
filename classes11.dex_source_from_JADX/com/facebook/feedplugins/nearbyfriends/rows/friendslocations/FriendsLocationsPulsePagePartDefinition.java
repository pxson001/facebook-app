package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feedplugins.nearbyfriends.rows.ui.FriendsLocationsPageView;
import com.facebook.feedplugins.nearbyfriends.rows.util.FriendsNearbyFeedUnitAnalyticsLogger;
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
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.appmanager.dev */
public class FriendsLocationsPulsePagePartDefinition extends BaseSinglePartDefinition<FriendsNearbyItemPartDefinition$Props, State, AnyEnvironment, FriendsLocationsPageView> {
    public static final String f8537a = StringFormatUtil.formatStrLocaleSafe(FBLinks.cQ, "feed_friends_locations_pulse");
    private static FriendsLocationsPulsePagePartDefinition f8538e;
    private static final Object f8539f = new Object();
    public final DefaultFeedUnitRenderer f8540b;
    public final FriendsNearbyFeedUnitAnalyticsLogger f8541c;
    public final SecureContextHelper f8542d;

    /* compiled from: com.facebook.appmanager.dev */
    public class State {
        public final OnClickListener f8533a;
        public final OnClickListener f8534b;
        public final String f8535c;
        public final String f8536d;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, String str, String str2) {
            this.f8533a = onClickListener;
            this.f8534b = onClickListener2;
            this.f8535c = str;
            this.f8536d = str2;
        }
    }

    private static FriendsLocationsPulsePagePartDefinition m9394b(InjectorLike injectorLike) {
        return new FriendsLocationsPulsePagePartDefinition(DefaultFeedUnitRenderer.a(injectorLike), FriendsNearbyFeedUnitAnalyticsLogger.m9411b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m9395a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FriendsNearbyItemPartDefinition$Props friendsNearbyItemPartDefinition$Props = (FriendsNearbyItemPartDefinition$Props) obj;
        return new State(new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsPulsePagePartDefinition f8530b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -724058650);
                FriendsLocationsPulsePagePartDefinition friendsLocationsPulsePagePartDefinition = this.f8530b;
                Intent intent = new Intent();
                intent.setData(Uri.parse(FriendsLocationsPulsePagePartDefinition.f8537a));
                friendsLocationsPulsePagePartDefinition.f8542d.a(intent, view.getContext());
                this.f8530b.f8541c.m9412a(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, 78841005, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsPulsePagePartDefinition f8532b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -117496616);
                this.f8532b.f8540b.a(view, LinkifyTargetBuilder.a(FeedUnitItemProfileHelper.a(friendsNearbyItemPartDefinition$Props.f8549b)), null);
                this.f8532b.f8541c.m9415b(friendsNearbyItemPartDefinition$Props.f8549b, friendsNearbyItemPartDefinition$Props.f8548a);
                Logger.a(2, EntryType.UI_INPUT_END, 918305721, a);
            }
        }, friendsNearbyItemPartDefinition$Props.f8549b.s() == null ? "" : friendsNearbyItemPartDefinition$Props.f8549b.s().a(), friendsNearbyItemPartDefinition$Props.f8549b.n() == null ? "" : friendsNearbyItemPartDefinition$Props.f8549b.n().a());
    }

    public final /* bridge */ /* synthetic */ void m9396a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 848879181);
        State state = (State) obj2;
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setNameText(state.f8535c);
        friendsLocationsPageView.m9406a(null, state.f8536d);
        friendsLocationsPageView.setOnNameClickListener(state.f8533a);
        friendsLocationsPageView.setOnLocationClickListener(state.f8533a);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(state.f8533a);
        friendsLocationsPageView.setPulseCenterFrameOnClickListener(state.f8534b);
        Logger.a(8, EntryType.MARK_POP, 1749496370, a);
    }

    public final void m9397b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setOnNameClickListener(null);
        friendsLocationsPageView.setOnLocationClickListener(null);
        friendsLocationsPageView.setOnNameLocationSectionClickListener(null);
        friendsLocationsPageView.setPulseCenterFrameOnClickListener(null);
    }

    public static FriendsLocationsPulsePagePartDefinition m9393a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsPulsePagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8539f) {
                FriendsLocationsPulsePagePartDefinition friendsLocationsPulsePagePartDefinition;
                if (a2 != null) {
                    friendsLocationsPulsePagePartDefinition = (FriendsLocationsPulsePagePartDefinition) a2.a(f8539f);
                } else {
                    friendsLocationsPulsePagePartDefinition = f8538e;
                }
                if (friendsLocationsPulsePagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9394b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8539f, b3);
                        } else {
                            f8538e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsPulsePagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendsLocationsPulsePagePartDefinition(DefaultFeedUnitRenderer defaultFeedUnitRenderer, FriendsNearbyFeedUnitAnalyticsLogger friendsNearbyFeedUnitAnalyticsLogger, SecureContextHelper secureContextHelper) {
        this.f8540b = defaultFeedUnitRenderer;
        this.f8541c = friendsNearbyFeedUnitAnalyticsLogger;
        this.f8542d = secureContextHelper;
    }
}
