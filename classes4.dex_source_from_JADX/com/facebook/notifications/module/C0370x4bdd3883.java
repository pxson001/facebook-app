package com.facebook.notifications.module;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.cache.NotificationStoryCache;

/* compiled from: mobile_highres_pref */
public class C0370x4bdd3883 extends AbstractProvider<NotificationStoryCache> {
    public static NotificationStoryCache m7928b(InjectorLike injectorLike) {
        return NotificationsModule.m7930a(DefaultAndroidThreadUtil.b(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public Object get() {
        return NotificationsModule.m7930a(DefaultAndroidThreadUtil.b(this), (MemoryTrimmableRegistry) MemoryManager.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
