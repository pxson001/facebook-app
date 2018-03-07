package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.feedplugins.nearbyfriends.rows.util.FriendsNearbyFeedUnitAnalyticsLogger;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.feed.quickcam.sourceType */
public class FriendsLocationsFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLFriendsLocationsFeedUnit, Void, HasPositionInformation, OneButtonFooterView> {
    public static final String f8495a = StringFormatUtil.formatStrLocaleSafe(FBLinks.cQ, "feed_friends_locations_see_all");
    private static FriendsLocationsFooterPartDefinition f8496g;
    private static final Object f8497h = new Object();
    private final OneButtonFooterStylerPartDefinition f8498b;
    private final ClickListenerPartDefinition f8499c;
    private final TextPartDefinition f8500d;
    public final IFeedIntentBuilder f8501e;
    public final FriendsNearbyFeedUnitAnalyticsLogger f8502f;

    private static FriendsLocationsFooterPartDefinition m9373b(InjectorLike injectorLike) {
        return new FriendsLocationsFooterPartDefinition(OneButtonFooterStylerPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike.getApplicationInjector()), FriendsNearbyFeedUnitAnalyticsLogger.m9411b(injectorLike));
    }

    public final Object m9375a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) obj;
        Object a = graphQLFriendsLocationsFeedUnit.p() == null ? "" : graphQLFriendsLocationsFeedUnit.p().a();
        subParts.a(this.f8498b, null);
        subParts.a(2131559974, this.f8500d, a);
        subParts.a(this.f8499c, new OnClickListener(this) {
            final /* synthetic */ FriendsLocationsFooterPartDefinition f8494b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1974215157);
                this.f8494b.f8502f.m9413a(graphQLFriendsLocationsFeedUnit);
                this.f8494b.f8501e.a(view.getContext(), FriendsLocationsFooterPartDefinition.f8495a);
                Logger.a(2, EntryType.UI_INPUT_END, 88503075, a);
            }
        });
        return null;
    }

    @Inject
    public FriendsLocationsFooterPartDefinition(OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, @NeedsApplicationInjector IFeedIntentBuilder iFeedIntentBuilder, FriendsNearbyFeedUnitAnalyticsLogger friendsNearbyFeedUnitAnalyticsLogger) {
        this.f8498b = oneButtonFooterStylerPartDefinition;
        this.f8499c = clickListenerPartDefinition;
        this.f8500d = textPartDefinition;
        this.f8501e = iFeedIntentBuilder;
        this.f8502f = friendsNearbyFeedUnitAnalyticsLogger;
    }

    public static FriendsLocationsFooterPartDefinition m9372a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8497h) {
                FriendsLocationsFooterPartDefinition friendsLocationsFooterPartDefinition;
                if (a2 != null) {
                    friendsLocationsFooterPartDefinition = (FriendsLocationsFooterPartDefinition) a2.a(f8497h);
                } else {
                    friendsLocationsFooterPartDefinition = f8496g;
                }
                if (friendsLocationsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9373b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8497h, b3);
                        } else {
                            f8496g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m9374a() {
        return OneButtonFooterView.a;
    }

    public final boolean m9376a(Object obj) {
        return true;
    }
}
