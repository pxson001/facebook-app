package com.facebook.analytics.permalink;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: timeline_action_menu_suggest_edits */
public class PermalinkEventsBuilder {
    public static PermalinkEventsBuilder m2578a(InjectorLike injectorLike) {
        return new PermalinkEventsBuilder();
    }

    public static void m2579a(HoneyClientEvent honeyClientEvent, @Nullable String str) {
        if (!Strings.isNullOrEmpty(str)) {
            honeyClientEvent.b("group_id", str);
        }
    }
}
