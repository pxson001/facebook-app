package com.facebook.goodwill.dailydialogue.env;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.SetNotifyMeLegacyMutationProvider;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.negativefeedback.video.RapidReportingController;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.xconfig.core.XConfigReader;

/* compiled from: method/mobile.zeroUpdateStatus */
public class DailyDialogueMenuHelperProvider extends AbstractAssistedProvider<DailyDialogueMenuHelper> {
    public final DailyDialogueMenuHelper m19952a(Runnable runnable, BaseFeedEnvironment baseFeedEnvironment) {
        return new DailyDialogueMenuHelper(runnable, IdBasedSingletonScopeProvider.m1809a(this, 968), IdBasedSingletonScopeProvider.m1809a(this, 2347), ComposerLauncherImpl.m14892a(this), TasksManager.m14546a((InjectorLike) this), ProductItemUpdateAvailabilityHelper.m18443a((InjectorLike) this), FbObjectMapperMethodAutoProvider.m6609a(this), SaveButtonUtils.m18452a((InjectorLike) this), SaveAnalyticsLogger.m13117a(this), IdBasedProvider.m1811a(this, 216), DefaultAndroidThreadUtil.m1645a((InjectorLike) this), FeedEventBus.m4573a(this), AnalyticsLoggerMethodAutoProvider.m3509a(this), NewsFeedAnalyticsEventBuilder.m14112a((InjectorLike) this), IdBasedProvider.m1811a(this, 3588), SystemClockMethodAutoProvider.m1498a(this), IdBasedProvider.m1811a(this, 9702), IdBasedProvider.m1811a(this, 10288), GraphQLStoryUtil.m9565a((InjectorLike) this), QeInternalImplMethodAutoProvider.m3744a(this), IdBasedProvider.m1811a(this, 11752), baseFeedEnvironment, OptimisticStoryStateCache.m9726a((InjectorLike) this), XConfigReader.m2681a(this), RapidReportingController.m18608a((InjectorLike) this), ControllerMutationGatekeepers.m18448a(this), GraphQLQueryExecutor.m10435a((InjectorLike) this), (SetNotifyMeLegacyMutationProvider) getOnDemandAssistedProviderForStaticDi(SetNotifyMeLegacyMutationProvider.class));
    }
}
