package com.facebook.notifications.multirow;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.DefaultNotificationStoryLauncher;
import com.facebook.notifications.util.NotificationStoryHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.today.common.HasNotifications;

/* compiled from: custom_cta_mobile_back_click_yes */
public class TodayNotificationClickListenerProvider extends AbstractAssistedProvider<TodayNotificationClickListener> {
    public final <E extends HasInvalidate & HasNotifications> TodayNotificationClickListener<E> m18961a(NotificationsEdgeFields notificationsEdgeFields, E e) {
        return new TodayNotificationClickListener(notificationsEdgeFields, (HasInvalidate) e, FbUriIntentHandler.a(this), NotificationStoryHelper.a(this), GraphQLNotificationsContentProviderHelper.a(this), DefaultNotificationStoryLauncher.a(this), NotificationsUtils.a(this), (PerformanceLogger) DelegatingPerformanceLogger.a(this), DefaultAndroidThreadUtil.b(this), TodayExperimentController.a(this));
    }
}
