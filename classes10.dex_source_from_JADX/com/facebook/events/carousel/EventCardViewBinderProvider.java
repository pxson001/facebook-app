package com.facebook.events.carousel;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dateformatter.EventsCardViewTimeFormatUtil;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCardFragment.CoverPhoto;
import com.facebook.events.model.Event;
import com.facebook.events.mutators.PrivateEventsRsvpMutator;
import com.facebook.events.mutators.PublicEventsRsvpMutator;
import com.facebook.events.socialcontext.EventSocialContextFormatter;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import java.util.List;

/* compiled from: contacts_upload_off */
public class EventCardViewBinderProvider extends AbstractAssistedProvider<EventCardViewBinder> {
    public final EventCardViewBinder m16417a(Event event, CoverPhoto coverPhoto, EventAnalyticsParams eventAnalyticsParams, List<? extends EventCardRemover> list) {
        return new EventCardViewBinder(event, coverPhoto, eventAnalyticsParams, list, (Context) getInstance(Context.class), (EventActionButtonStateSelectorProvider) getOnDemandAssistedProviderForStaticDi(EventActionButtonStateSelectorProvider.class), PrivateEventsRsvpMutator.b(this), PublicEventsRsvpMutator.b(this), EventsCardViewTimeFormatUtil.a(this), EventsEventBus.a(this), IdBasedProvider.a(this, 1117), EventSocialContextFormatter.b(this), ResourcesMethodAutoProvider.a(this));
    }
}
