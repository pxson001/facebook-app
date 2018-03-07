package com.facebook.feedplugins.goodwill;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger$Events;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.action.DefaultQuickPromotionActionHandler;

/* compiled from: gravity_feed_unit_gen */
class DailyDialogueLightweightHeaderPartDefinition$2 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f12185a;
    final /* synthetic */ GraphQLCustomizedStory f12186b;
    final /* synthetic */ DailyDialogueLightweightHeaderPartDefinition f12187c;

    DailyDialogueLightweightHeaderPartDefinition$2(DailyDialogueLightweightHeaderPartDefinition dailyDialogueLightweightHeaderPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink, GraphQLCustomizedStory graphQLCustomizedStory) {
        this.f12187c = dailyDialogueLightweightHeaderPartDefinition;
        this.f12185a = graphQLStoryActionLink;
        this.f12186b = graphQLCustomizedStory;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 378556412);
        ((DefaultQuickPromotionActionHandler) this.f12187c.e.get()).m4470a(Uri.parse(this.f12185a.aE()));
        GoodwillAnalyticsLogger goodwillAnalyticsLogger = (GoodwillAnalyticsLogger) this.f12187c.d.get();
        String k = this.f12186b.k();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(GoodwillAnalyticsLogger$Events.DAILYDIALOGUE_LIGHTWEIGHT_HEADER_TAPPED.name);
        honeyClientEvent.c = "goodwill";
        goodwillAnalyticsLogger.a.a(honeyClientEvent.b("tracking", k).b("action", "open_url"));
        Logger.a(2, EntryType.UI_INPUT_END, -1930662423, a);
    }
}
