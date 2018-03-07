package com.facebook.feedplugins.saved.nux;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySaveInfo;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.gating.feature.SaverInfoXConfig;
import com.facebook.saved.gating.feature.SaverInfoXConfig.SaveBookmarkNuxState;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: bundle_selected_profile_id */
public class OnlyMeShareNuxTooltipDelegate extends CaretNuxTooltipDelegateBase {
    private static final InterstitialTrigger f9267f = new InterstitialTrigger(Action.FEED_STORY_ONLY_ME_SHARE);
    private XConfigReader f9268g;

    @Inject
    public OnlyMeShareNuxTooltipDelegate(@Assisted String str, @Assisted ImmutableSet<String> immutableSet, XConfigReader xConfigReader, FbErrorReporter fbErrorReporter, SaveAnalyticsLogger saveAnalyticsLogger, InterstitialManager interstitialManager) {
        super(fbErrorReporter, immutableSet, saveAnalyticsLogger, interstitialManager, str);
        this.f9268g = xConfigReader;
    }

    public final boolean mo253a(FeedUnit feedUnit) {
        Optional d = m9898d(feedUnit);
        if (!d.isPresent()) {
            return false;
        }
        GraphQLStorySaveInfo as = ((GraphQLStory) d.get()).as();
        if (as == null || as.m() != GraphQLSavedState.NOT_SAVED) {
            return false;
        }
        if (SaveBookmarkNuxState.INELIGIBLE.equals(SaveBookmarkNuxState.convertString(this.f9268g.a(SaverInfoXConfig.c, null)))) {
            return false;
        }
        return this.f9263e.a(f9267f, SavedOnlyMeShareNuxInterstitialController.class) != null;
    }
}
