package com.facebook.notifications.multirow;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.today.abtest.TodayExperimentController;

/* compiled from: custom_cta_mobile_invalid_email */
public class NotificationsFeedInteractionTrackerProvider extends AbstractAssistedProvider<NotificationsFeedInteractionTracker> {
    public final NotificationsFeedInteractionTracker m18957a(ReactionSession reactionSession, LinearLayoutManager linearLayoutManager, NotificationsFeedCollection notificationsFeedCollection) {
        return new NotificationsFeedInteractionTracker(reactionSession, linearLayoutManager, notificationsFeedCollection, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), GraphQLNotificationsContentProviderHelper.a(this), NotificationsLogger.a(this), NotificationsUtils.a(this), ReactionAnalyticsLogger.m22814a((InjectorLike) this), ReactionPerfLogger.a(this), DefaultAndroidThreadUtil.b(this), TodayExperimentController.a(this));
    }
}
