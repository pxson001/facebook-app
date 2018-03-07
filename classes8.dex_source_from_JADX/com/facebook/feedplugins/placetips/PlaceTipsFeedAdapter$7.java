package com.facebook.feedplugins.placetips;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.events.common.ActionMechanism;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.EventsModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.EventsModel.EventModel;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.google.common.base.Preconditions;

/* compiled from: friending/ */
class PlaceTipsFeedAdapter$7 implements OnClickListener {
    final /* synthetic */ EventsModel f12909a;
    final /* synthetic */ PlaceTipsFeedAdapter f12910b;

    PlaceTipsFeedAdapter$7(PlaceTipsFeedAdapter placeTipsFeedAdapter, EventsModel eventsModel) {
        this.f12910b = placeTipsFeedAdapter;
        this.f12909a = eventsModel;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2743925);
        PlaceTipsFeedAdapter placeTipsFeedAdapter = this.f12910b;
        EventsModel eventsModel = this.f12909a;
        EventModel eventModel = (EventModel) Preconditions.checkNotNull(eventsModel.m3764a());
        Context context = view.getContext();
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.t, eventModel.m3757b());
        Bundle bundle = new Bundle();
        bundle.putParcelable("event_ref_mechanism", ActionMechanism.EVENT_TIPS);
        ((FbUriIntentHandler) placeTipsFeedAdapter.l.get()).a(context, formatStrLocaleSafe, bundle);
        placeTipsFeedAdapter.b.a(PlaceTipsAnalyticsEvent.EVENT_TIP_CLICK, PresenceSourceType.GPS, eventsModel.m3764a().m3757b(), false);
        Logger.a(2, EntryType.UI_INPUT_END, 346710455, a);
    }
}
