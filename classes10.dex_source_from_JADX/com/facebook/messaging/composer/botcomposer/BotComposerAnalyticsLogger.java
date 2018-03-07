package com.facebook.messaging.composer.botcomposer;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: thread wasn't set before fragment was attached to activity! */
public class BotComposerAnalyticsLogger {
    private final AnalyticsLogger f1713a;

    public static BotComposerAnalyticsLogger m1699b(InjectorLike injectorLike) {
        return new BotComposerAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BotComposerAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1713a = analyticsLogger;
    }

    public final void m1700a(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("action", "display");
        hashMap.put("page_id", str);
        hashMap.put("count", String.valueOf(i));
        m1698a("bot_composer_quick_replies", hashMap);
    }

    public final void m1701a(String str, long j) {
        Map hashMap = new HashMap();
        hashMap.put("action", "click");
        hashMap.put("type", str);
        hashMap.put("ttc", String.valueOf(j));
        m1698a("bot_composer_quick_replies", hashMap);
    }

    public final void m1703b(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("action", "display");
        hashMap.put("page_id", str);
        hashMap.put("count", String.valueOf(i));
        m1698a("bot_composer_structured_menu", hashMap);
    }

    public final void m1702a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("action", "click");
        hashMap.put("page_id", str);
        hashMap.put("type", str2);
        m1698a("bot_composer_structured_menu", hashMap);
    }

    private void m1698a(String str, @Nullable Map<String, ?> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "messenger_commerce";
        this.f1713a.a(honeyClientEvent.a(map));
    }
}
