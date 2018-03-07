package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.feed.fragment.generatedenvironments.NewsFeedEnvironmentGeneratedProvider;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerMultiRowInjectedFeedAdapter;
import com.facebook.feed.logging.FeedUnitHeightTrackerProvider;
import com.facebook.feed.megaphone.MegaphoneController;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.rows.FeedAdapterFactory;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feed.topicfeeds.customization.TopicFeedsCustomizationModule.C04411;
import com.facebook.feed.workingrange.listeners.HideableUnitWorkingRangeListener;
import com.facebook.feed.workingrange.rows.FeedRangesController;
import com.facebook.feedplugins.placetips.PlaceTipsInjectedFeedAdapter;
import com.facebook.goodwill.dailydialogue.adapter.DailyDialogueInjectedFeedAdapter;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: pages_surface_android_no_back_capture */
public class NewsFeedAdapterConfigurationProvider extends AbstractAssistedProvider<NewsFeedAdapterConfiguration> {
    public final NewsFeedAdapterConfiguration m15499a(InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter, DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter, MegaphoneController megaphoneController, C04411 c04411, PlaceTipsInjectedFeedAdapter placeTipsInjectedFeedAdapter, GoodFriendsCustomizationHeaderController goodFriendsCustomizationHeaderController, TailLoaderController tailLoaderController, NewsFeedViewController newsFeedViewController, MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper) {
        return new NewsFeedAdapterConfiguration((NewsFeedEnvironmentGeneratedProvider) getOnDemandAssistedProviderForStaticDi(NewsFeedEnvironmentGeneratedProvider.class), QeInternalImplMethodAutoProvider.m3744a(this), FeedAdapterFactory.m16447a((InjectorLike) this), FeedRangesController.m16451a(this), (FeedUnitHeightTrackerProvider) getOnDemandAssistedProviderForStaticDi(FeedUnitHeightTrackerProvider.class), StartupPerfLogger.m3406a((InjectorLike) this), FeedPerfLogger.m3326a((InjectorLike) this), HideableUnitWorkingRangeListener.m16473a(this), inlineComposerMultiRowInjectedFeedAdapter, dailyDialogueInjectedFeedAdapter, megaphoneController, c04411, placeTipsInjectedFeedAdapter, goodFriendsCustomizationHeaderController, tailLoaderController, newsFeedViewController, multiRowImagePrefetcherWrapper);
    }
}
