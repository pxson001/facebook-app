package com.facebook.events.permalink.actionbar;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.Event;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;

/* compiled from: callback is null */
public class EventActionsHandlerUtilProvider extends AbstractAssistedProvider<EventActionsHandlerUtil> {
    public final EventActionsHandlerUtil m18426a(Event event, EventAnalyticsParams eventAnalyticsParams) {
        return new EventActionsHandlerUtil(event, eventAnalyticsParams, (Context) getInstance(Context.class), EventEventLogger.m18119b(this), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(this), IdBasedProvider.a(this, 12), (SecureContextHelper) DefaultSecureContextHelper.a(this));
    }
}
