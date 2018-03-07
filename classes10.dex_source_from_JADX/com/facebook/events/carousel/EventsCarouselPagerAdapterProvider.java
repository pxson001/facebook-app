package com.facebook.events.carousel;

import android.content.Context;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.ActionSource;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.permalinkintent.EventPermalinkIntentBuilder;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import java.util.List;

/* compiled from: contacts_sections */
public class EventsCarouselPagerAdapterProvider extends AbstractAssistedProvider<EventsCarouselPagerAdapter> {
    public final EventsCarouselPagerAdapter m16435a(Context context, EventAnalyticsParams eventAnalyticsParams, List<EventCardViewBinder> list, ActionSource actionSource, ActionMechanism actionMechanism, String str) {
        return new EventsCarouselPagerAdapter(context, eventAnalyticsParams, list, actionSource, actionMechanism, str, EventEventLogger.m18119b(this), EventGraphQLModelHelper.m19271a((InjectorLike) this), EventPermalinkIntentBuilder.a(this));
    }
}
