package com.facebook.zero;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.extra.ACTION */
public class MessageCapLogger {
    private final Lazy<AnalyticsLogger> f20237a;

    public static MessageCapLogger m28846b(InjectorLike injectorLike) {
        return new MessageCapLogger(IdBasedSingletonScopeProvider.b(injectorLike, 175));
    }

    @Inject
    public MessageCapLogger(Lazy<AnalyticsLogger> lazy) {
        this.f20237a = lazy;
    }

    public final void m28848a(String str) {
        m28847a(new HoneyClientEvent(str));
    }

    public final void m28847a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "message_capping";
        ((AnalyticsLogger) this.f20237a.get()).a(honeyClientEvent);
    }
}
