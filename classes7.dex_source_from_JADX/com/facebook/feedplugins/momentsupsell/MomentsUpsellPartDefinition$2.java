package com.facebook.feedplugins.momentsupsell;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feedplugins.momentsupsell.analytics.MomentsUpsellFeedPluginLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: STICKER_PICKER_CLOSED */
class MomentsUpsellPartDefinition$2 implements OnClickListener {
    final /* synthetic */ MomentsUpsellPartDefinition f23555a;

    MomentsUpsellPartDefinition$2(MomentsUpsellPartDefinition momentsUpsellPartDefinition) {
        this.f23555a = momentsUpsellPartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1612628992);
        this.f23555a.c.a(view.getContext());
        MomentsUpsellFeedPluginLogger momentsUpsellFeedPluginLogger = this.f23555a.e;
        int d = momentsUpsellFeedPluginLogger.b.d();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("moments_in_feed_upsell_clicked");
        honeyClientEvent.a("total_impressions", d);
        momentsUpsellFeedPluginLogger.a.a(honeyClientEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 1235662868, a);
    }
}
