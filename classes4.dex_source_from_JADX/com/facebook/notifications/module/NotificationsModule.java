package com.facebook.notifications.module;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.notifications.annotations.OverflowedNotificationCache;
import com.facebook.notifications.annotations.RegularNotificationCache;
import com.facebook.notifications.cache.NotificationStoryCache;
import com.facebook.notifications.protocol.NotificationsQueue;
import com.facebook.notifications.protocol.NotificationsServiceHandler;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHandler;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.proguard.annotations.DoNotStrip;

@InjectorModule
/* compiled from: mobile_fbtrace_config */
public class NotificationsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @NotificationsQueue
    @ContextScoped
    static BlueServiceHandler m7929a(GraphQLNotificationsContentProviderHandler graphQLNotificationsContentProviderHandler, NotificationsServiceHandler notificationsServiceHandler) {
        return new FilterChainLink(graphQLNotificationsContentProviderHandler, notificationsServiceHandler);
    }

    @ProviderMethod
    @RegularNotificationCache
    static NotificationStoryCache m7930a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, MemoryTrimmableRegistry memoryTrimmableRegistry, AbstractFbErrorReporter abstractFbErrorReporter) {
        return new NotificationStoryCache(defaultAndroidThreadUtil, "Notification.NotificationStoryCache", "notification_story_cache_entries", memoryTrimmableRegistry, abstractFbErrorReporter);
    }

    @ProviderMethod
    @OverflowedNotificationCache
    static NotificationStoryCache m7931b(DefaultAndroidThreadUtil defaultAndroidThreadUtil, MemoryTrimmableRegistry memoryTrimmableRegistry, AbstractFbErrorReporter abstractFbErrorReporter) {
        return new NotificationStoryCache(defaultAndroidThreadUtil, "Notification.OverflowedNotificationStoryCache", "overflowed_notification_story_cache_entries", memoryTrimmableRegistry, abstractFbErrorReporter);
    }

    @DoNotStrip
    public static GraphQLNotificationsContentProviderHelper getInstanceForTest_GraphQLNotificationsContentProviderHelper(FbInjector fbInjector) {
        return GraphQLNotificationsContentProviderHelper.m7861a((InjectorLike) fbInjector);
    }
}
