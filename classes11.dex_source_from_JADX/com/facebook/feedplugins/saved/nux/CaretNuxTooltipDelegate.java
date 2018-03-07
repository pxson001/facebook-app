package com.facebook.feedplugins.saved.nux;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySaveInfo;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: bundle_self_view_fetch */
public class CaretNuxTooltipDelegate extends CaretNuxTooltipDelegateBase {
    private static final InterstitialTrigger f9264f = new InterstitialTrigger(Action.FEED_STORY_CARET);
    private final long f9265g;
    private final GraphQLStorySaveNuxType f9266h;

    @Inject
    public CaretNuxTooltipDelegate(@Assisted String str, @Assisted Long l, @Assisted ImmutableSet<String> immutableSet, @Assisted GraphQLStorySaveNuxType graphQLStorySaveNuxType, FbErrorReporter fbErrorReporter, SaveAnalyticsLogger saveAnalyticsLogger, InterstitialManager interstitialManager) {
        super(fbErrorReporter, immutableSet, saveAnalyticsLogger, interstitialManager, str);
        this.f9265g = l.longValue();
        this.f9266h = graphQLStorySaveNuxType;
    }

    public final boolean mo253a(FeedUnit feedUnit) {
        Optional d = m9898d(feedUnit);
        if (!d.isPresent()) {
            return false;
        }
        GraphQLStorySaveInfo as = ((GraphQLStory) d.get()).as();
        if (as == null || this.f9266h != as.k()) {
            return false;
        }
        if (this.f9265g > ((long) as.a()) || this.f9265g < ((long) as.j())) {
            return false;
        }
        return this.f9263e.a(f9264f, SavedCaretNuxInterstitialController.class) != null;
    }
}
