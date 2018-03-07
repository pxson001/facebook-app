package com.facebook.notifications.module;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.cache.NotificationStoryCache;

/* compiled from: ml_state */
public class C0371x4c6b58f0 extends AbstractProvider<NotificationStoryCache> {
    public static NotificationStoryCache m7960b(InjectorLike injectorLike) {
        return NotificationsModule.m7931b(DefaultAndroidThreadUtil.b(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public Object get() {
        return NotificationsModule.m7931b(DefaultAndroidThreadUtil.b(this), (MemoryTrimmableRegistry) MemoryManager.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
